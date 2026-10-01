package su.energyclient.manager.impl;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.NbtSizeTracker;
import net.minecraft.registry.RegistryOps;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.util.collection.DefaultedList;
import su.energyclient.util.Util42;

public class InventoryManager {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final File f_6764 = new File(Util42.f_7521 + "data\\inventories");
   private static final File f_6765 = new File(f_6764, InventoryManager.f_6787);
   private static final String f_6766 = ".inv";
   public static final int f_6767 = 0;
   public static final int f_6768 = 0;
   public static final int f_6769 = 0;
   public static final int f_6770 = 0;
   private final DefaultedList<ItemStack> f_6771 = DefaultedList.ofSize(41, ItemStack.EMPTY);
   private String f_6772;
   private boolean f_6773;
   private String f_6774;
   private static final String f_6775 = ".inv";
   private static final String f_6776 = "slot";
   private static final String f_6777 = "item";
   private static final String f_6778 = "items";
   private static final String f_6779 = "creationDate";
   private static final String f_6780 = "items";
   private static final String f_6781 = "slot";
   private static final String f_6782 = "item";
   private static final String f_6783 = "/";
   private static final String f_6784 = "\\";
   private static final String f_6785 = "..";
   private static final String f_6786 = ".inv";
   private static final String f_6787 = "active";

   public boolean m_2811() {
      if (this.f_6774 == null) {
         return false;
      } else {
         for (ItemStack var3 : this.m_2290()) {
            if (!var3.isEmpty()) {
               return true;
            }
         }

         return false;
      }
   }

   private boolean m_1482(String var1, DefaultedList<ItemStack> var2) {
      File var3 = this.m_2999(var1);
      if (!var3.exists()) {
         return false;
      } else {
         WrapperLookup var4 = m_3945();
         if (var4 == null) {
            return false;
         } else {
            try {
               NbtCompound var5;
               try (InputStream var6 = Files.newInputStream(var3.toPath())) {
                  var5 = NbtIo.readCompressed(var6, NbtSizeTracker.ofUnlimitedBytes());
               }

               for (int var15 = 0; var15 < var2.size(); var15++) {
                  var2.set(var15, ItemStack.EMPTY);
               }

               if (var5 == null) {
                  return true;
               } else {
                  RegistryOps var16 = var4.getOps(NbtOps.INSTANCE);
                  NbtList var7 = var5.getListOrEmpty(f_6780);

                  for (int var8 = 0; var8 < var7.size(); var8++) {
                     NbtCompound var9 = (NbtCompound)var7.getCompound(var8).orElse(null);
                     if (var9 != null) {
                        int var10 = var9.getInt(f_6781).orElse(-1);
                        if (var10 >= 0 && var10 < var2.size()) {
                           NbtElement var11 = var9.get(f_6782);
                           if (var11 != null) {
                              var2.set(var10, (ItemStack)ItemStack.CODEC.parse(var16, var11).result().orElse(ItemStack.EMPTY));
                           }
                        }
                     }
                  }

                  return true;
               }
            } catch (Exception var14) {
               System.err.println("Failed to load inventory set: " + var1 + " - " + var14.getMessage());
               return false;
            }
         }
      }
   }

   private String m_2253(String var1) {
      if (var1 == null) {
         return null;
      } else {
         String var2 = var1.trim();
         if (var2.isEmpty()) {
            return null;
         } else {
            return !var2.contains(f_6783) && !var2.contains(f_6784) && !var2.contains(f_6785) ? var2 : null;
         }
      }
   }

   private File m_2999(String var1) {
      return new File(f_6764, var1 + ".inv");
   }

   public String m_1011() {
      return this.f_6772;
   }

   private void m_1397() {
      this.f_6774 = null;

      try {
         if (f_6765.exists()) {
            String var1 = Files.readString(f_6765.toPath(), StandardCharsets.UTF_8).trim();
            if (!var1.isEmpty() && this.m_2999(var1).exists()) {
               this.f_6774 = var1;
            }
         }
      } catch (Exception var2) {
      }
   }

   public boolean m_1636(String var1) {
      String var2 = this.m_2253(var1);
      if (var2 == null) {
         return false;
      } else {
         boolean var3 = this.m_2999(var2).delete();
         if (var3 && var2.equals(this.f_6774)) {
            this.m_2091();
         }

         return var3;
      }
   }

   public List<String> m_1873() {
      File[] var1 = f_6764.listFiles((var0, var1x) -> var1x.endsWith(f_6786));
      if (var1 == null) {
         return Collections.emptyList();
      } else {
         ArrayList var2 = new ArrayList();

         for (File var6 : var1) {
            var2.add(var6.getName().substring(0, var6.getName().length() - f_6775.length()));
         }

         Collections.sort(var2);
         return var2;
      }
   }

   public boolean m_3432(String var1) {
      String var2 = this.m_2253(var1);
      return var2 != null && this.m_2999(var2).exists();
   }

   public void m_1265() {
      f_6764.mkdirs();
      this.m_1397();
   }

   private static WrapperLookup m_3945() {
      MinecraftClient var0 = m_2466();
      if (var0.world != null) {
         return var0.world.getRegistryManager();
      } else {
         return var0.player != null ? var0.player.getRegistryManager() : null;
      }
   }

   public boolean m_3886(String var1) {
      String var2 = this.m_2253(var1);
      if (var2 != null && this.m_2999(var2).exists()) {
         this.f_6774 = var2;
         this.m_391();
         this.f_6773 = false;
         return true;
      } else {
         return false;
      }
   }

   private static MinecraftClient m_2466() {
      return MinecraftClient.getInstance();
   }

   public String m_1593() {
      return this.f_6774;
   }

   private void m_391() {
      try {
         f_6764.mkdirs();
         if (this.f_6774 == null) {
            f_6765.delete();
         } else {
            Files.writeString(f_6765.toPath(), this.f_6774, StandardCharsets.UTF_8);
         }
      } catch (Exception var2) {
      }
   }

   public DefaultedList<ItemStack> m_2290() {
      if (!this.f_6773) {
         this.f_6773 = true;
         if (this.f_6774 != null && this.m_1482(this.f_6774, this.f_6771)) {
            this.f_6772 = this.f_6774;
         } else {
            this.f_6772 = null;

            for (int var1 = 0; var1 < this.f_6771.size(); var1++) {
               this.f_6771.set(var1, ItemStack.EMPTY);
            }
         }
      }

      return this.f_6771;
   }

   public void m_2091() {
      this.f_6774 = null;
      this.m_391();
      this.f_6772 = null;
      this.f_6773 = false;

      for (int var1 = 0; var1 < this.f_6771.size(); var1++) {
         this.f_6771.set(var1, ItemStack.EMPTY);
      }
   }

   public boolean m_2567(String var1) {
      String var2 = this.m_2253(var1);
      if (var2 == null) {
         return false;
      } else {
         ClientPlayerEntity var3 = m_2466().player;
         WrapperLookup var4 = m_3945();
         if (var3 != null && var4 != null) {
            f_6764.mkdirs();

            try {
               RegistryOps var5 = var4.getOps(NbtOps.INSTANCE);
               NbtList var6 = new NbtList();

               for (int var7 = 0; var7 < 41; var7++) {
                  ItemStack var8 = var3.getInventory().getStack(var7);
                  if (var8 != null && !var8.isEmpty()) {
                     NbtCompound var9 = new NbtCompound();
                     var9.putInt(f_6776, var7);
                     var9.put(f_6777, (NbtElement)ItemStack.CODEC.encodeStart(var5, var8).getOrThrow());
                     var6.add(var9);
                  }
               }

               NbtCompound var14 = new NbtCompound();
               var14.put(f_6778, var6);
               var14.putLong(f_6779, System.currentTimeMillis());

               try (OutputStream var15 = Files.newOutputStream(this.m_2999(var2).toPath())) {
                  NbtIo.writeCompressed(var14, var15);
               }

               if (var2.equals(this.f_6774)) {
                  this.f_6773 = false;
               }

               return true;
            } catch (Exception var13) {
               System.err.println("Failed to save inventory set: " + var2 + " - " + var13.getMessage());
               return false;
            }
         } else {
            return false;
         }
      }
   }
}
