package su.energyclient.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import su.energyclient.EnergyClient;
import su.energyclient.mixin.ItemCooldownManagerEntryMixin;
import su.energyclient.mixin.ItemCooldownManagerMixin2;
import su.energyclient.module.render.Interface;

public class Util61 extends Util156 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ObjectArrayList<Util61.JOMyL3laWjQoUevD> f_8401 = new ObjectArrayList();
   private float f_8402 = 0.0F;
   private final Util165 f_8403;
   private static final long f_8404 = 200L;
   private static final String f_8405 = "Cooldowns";
   private static final String f_8406 = "Cooldowns";
   private static final float f_8407 = 23.0F;
   private static final float f_8408 = 18.0F;
   private static final float f_8409 = 0.01F;
   private static final float f_8410 = 20.0F;
   private static final float f_8411 = 12.0F;
   private static final float f_8412 = 8.0F;
   private static final float f_8413 = 0.1F;
   private static final float f_8414 = 18.0F;
   private static final float f_8415 = 10.0F;
   private static final String f_8416 = "s";
   private static final float f_8417 = 5.0F;
   private static final float f_8418 = 7.5F;
   private static final String f_8419 = "Cooldowns";
   private static final float f_8420 = 17.0F;
   private static final float f_8421 = 7.5F;
   private static final float f_8422 = 0.001F;
   private static final float f_8423 = 255.0F;
   private static final float f_8424 = 20.0F;
   private static final float f_8425 = 0.5F;
   private static final float f_8426 = 22.0F;
   private static final float f_8427 = 16.0F;
   private static final float f_8428 = 10.0F;
   private static final int f_8429 = 1315865;
   private static final float f_8430 = 10.0F;
   private static final float f_8431 = 16.0F;
   private static final float f_8432 = 10.0F;
   private static final int f_8433 = 1315865;
   private static final float f_8434 = 0.35F;
   private static final float f_8435 = 5.0F;
   private static final float f_8436 = 2.5F;
   private static final float f_8437 = 0.7F;
   private static final float f_8438 = 18.0F;
   private static final float f_8439 = 7.0F;
   private static final float f_8440 = 5.0F;
   private static final float f_8441 = 7.0F;
   private static final float f_8442 = 16.5F;
   private static final float f_8443 = 18.0F;
   private static final float f_8444 = 20.0F;
   private static final float f_8445 = 1.5F;
   private static final int f_8446 = -43691;
   private static final float f_8447 = 3.0F;
   private static final String f_8448 = "%d:%02dс";

   private String m_664(float var1) {
      int var2 = (int)Math.ceil(Math.max(var1, 0.0F));
      int var3 = var2 / 60;
      int var4 = var2 % 60;
      return String.format(f_8448, var3, var4);
   }

   public Util61(Util112 var1) {
      super(var1);
      this.f_8403 = new Util165(Util153.LINEAR, f_8404);
   }

   private int m_901(float var1) {
      if (var1 <= f_8445) {
         return f_8446;
      } else {
         return var1 <= f_8447 ? -22016 : -1;
      }
   }

   private void m_3913() {
      if (f_5909.player != null) {
         ItemCooldownManager var1 = f_5909.player.getItemCooldownManager();
         ItemCooldownManagerMixin2 var2 = (ItemCooldownManagerMixin2)var1;
         int var3 = var2.getTick();
         Map<?, ?> var4 = var2.getEntries();
         ObjectListIterator var5 = this.f_8401.iterator();

         while (var5.hasNext()) {
            Util61.JOMyL3laWjQoUevD var6 = (Util61.JOMyL3laWjQoUevD)var5.next();
            var6.m_3669(false);
         }

         for (Map.Entry<?, ?> var14 : var4.entrySet()) {
            Identifier var7 = (Identifier)var14.getKey();
            int var8 = ((ItemCooldownManagerEntryMixin)var14.getValue()).callEndTick();
            float var9 = (var8 - var3) / f_8444;
            if (!(var9 <= 0.0F)) {
               Util61.JOMyL3laWjQoUevD var10 = null;
               ObjectListIterator var11 = this.f_8401.iterator();

               while (var11.hasNext()) {
                  Util61.JOMyL3laWjQoUevD var12 = (Util61.JOMyL3laWjQoUevD)var11.next();
                  if (var12.m_2557().equals(var7)) {
                     var10 = var12;
                     break;
                  }
               }

               if (var10 != null) {
                  var10.m_1956(var9);
                  var10.m_3669(true);
               } else {
                  this.f_8401.add(new Util61.JOMyL3laWjQoUevD(var7, this.m_3589(var7, var1), var9));
               }
            }
         }

         this.f_8401.removeIf(var0 -> !var0.m_393() && var0.m_576().m_2276() <= 0.0);
      }
   }

   @Override
   public void m_4(Util169 var1) {
      if (f_5909.player != null) {
         this.m_3913();
         DrawContext var2 = var1.m_4037();
         float var3 = this.f_10920.m_2838();
         float var4 = this.f_10920.m_671();
         String var5 = f_8405;
         float var6 = Util93.f_6001[16].m_585(f_8406);
         float var7 = f_8407 + var6;
         float var8 = f_8408;
         ObjectListIterator var9 = this.f_8401.iterator();

         while (var9.hasNext()) {
            Util61.JOMyL3laWjQoUevD var10 = (Util61.JOMyL3laWjQoUevD)var9.next();
            var10.m_576().m_3631(var10.m_393() ? 1.0 : 0.0);
         }

         List<Util61.JOMyL3laWjQoUevD> var29 = this.f_8401
            .stream()
            .filter(var0 -> var0.m_576().m_2276() > 0.0)
            .sorted(Comparator.comparingDouble(Util61.JOMyL3laWjQoUevD::m_714).reversed())
            .toList();
         boolean var30 = f_5909.currentScreen instanceof ChatScreen || !var29.isEmpty();
         this.f_8403.m_3631(var30 ? 1.0 : 0.0);
         float var11 = (float)this.f_8403.m_2276();
         if (var11 <= f_8409) {
            this.f_10920.m_1597(0.0F);
            this.f_10920.m_1076(0.0F);
         } else {
            float var12 = 0.0F;
            float var13 = 0.0F;

            for (Util61.JOMyL3laWjQoUevD var15 : var29) {
               var12 = Math.max(var12, Util93.f_6001[15].m_585(var15.m_3157()));
               var13 = Math.max(var13, Util93.f_6001[15].m_585(this.m_664(var15.m_714())));
            }

            float var31 = Math.max(var7, f_8410 + var12 + f_8411 + var13 + f_8412);
            this.f_8402 = this.f_8402 + (var31 - this.f_8402) * f_8413;
            Util158.m_3998(var3, var4, this.f_8402, f_8414, f_8415, Util71.m_756(20, 20, 25, (int)(Interface.m_886(150) * var11)), var11);
            Util93.f_6000[18].m_2915(var2, f_8416, var3 + f_8417, var4 + f_8418, Util71.m_1907(EnergyClient.getTheme(0), var11));
            Util93.f_6001[16].m_2915(var2, f_8419, var3 + f_8420, var4 + f_8421, Util71.m_1907(-1, var11));
            float var32 = 0.0F;

            for (Util61.JOMyL3laWjQoUevD var17 : var29) {
               String var18 = var17.m_3157();
               String var19 = this.m_664(var17.m_714());
               float var20 = Util93.f_6001[15].m_585(var18);
               float var21 = Util93.f_6001[15].m_585(var19);
               float var22 = (float)var17.m_576().m_2276();
               float var23 = var22 * var11;
               if (!(var23 <= f_8422)) {
                  int var24 = (int)(var23 * f_8423);
                  int var25 = (int)(var23 * Interface.m_886(100));
                  float var26 = var4 + var32 + f_8424 - f_8425;
                  Util158.m_3998(var3, var26, var20 + f_8426, f_8427, f_8428, Util71.m_3389(f_8429, var25), var23);
                  float var27 = var21 + f_8430;
                  float var28 = var3 + this.f_8402 - var27;
                  Util158.m_3998(var28, var26, var27, f_8431, f_8432, Util71.m_3389(f_8433, var25), var23);
                  if (var23 > f_8434 && !var17.m_378().isEmpty()) {
                     Util158.m_1974(var2, var17.m_378(), (int)(var3 + f_8435), (int)(var26 + f_8436), f_8437, -1, var23);
                  }

                  Util93.f_6001[15].m_2915(var2, var18, var3 + f_8438, var26 + f_8439, Util71.m_3389(-1, var24));
                  Util93.f_6001[15].m_2915(var2, var19, var28 + f_8440, var26 + f_8441, Util71.m_3389(this.m_901(var17.m_714()), var24));
                  var32 += var23 * f_8442;
               }
            }

            this.f_10920.m_1597(this.f_8402 * var11);
            this.f_10920.m_1076((f_8443 + var32) * var11);
         }
      }
   }

   private ItemStack m_3589(Identifier var1, ItemCooldownManager var2) {
      if (f_5909.player != null) {
         for (int var3 = 0; var3 < 36; var3++) {
            ItemStack var4 = f_5909.player.getInventory().getStack(var3);
            if (!var4.isEmpty() && var1.equals(var2.getGroup(var4))) {
               return var4;
            }
         }

         ItemStack var5 = f_5909.player.getOffHandStack();
         if (!var5.isEmpty() && var1.equals(var2.getGroup(var5))) {
            return var5;
         }
      }

      Item var6 = (Item)Registries.ITEM.get(var1);
      return var6 == Items.AIR ? ItemStack.EMPTY : new ItemStack(var6);
   }

   private static class JOMyL3laWjQoUevD {
      private final Identifier f_10784;
      private final ItemStack f_10785;
      private float f_10786;
      private boolean f_10787;
      private final Util165 f_10788;
      private static final long f_10789 = 200L;

      public ItemStack m_378() {
         return this.f_10785;
      }

      public Util165 m_576() {
         return this.f_10788;
      }

      public float m_714() {
         return this.f_10786;
      }

      public void m_1956(float var1) {
         this.f_10786 = var1;
      }

      public boolean m_393() {
         return this.f_10787;
      }

      public JOMyL3laWjQoUevD(Identifier var1, ItemStack var2, float var3) {
         this.f_10788 = new Util165(Util153.LINEAR, f_10789);
         this.f_10784 = var1;
         this.f_10785 = var2;
         this.f_10786 = var3;
         this.f_10787 = true;
      }

      public Identifier m_2557() {
         return this.f_10784;
      }

      public String m_3157() {
         if (this.f_10785 != null && !this.f_10785.isEmpty()) {
            return this.f_10785.getName().getString();
         } else {
            String var1 = this.f_10784.getPath().replace('_', ' ');
            return var1.isEmpty() ? this.f_10784.toString() : Character.toUpperCase(var1.charAt(0)) + var1.substring(1);
         }
      }

      public void m_3669(boolean var1) {
         this.f_10787 = var1;
      }
   }
}
