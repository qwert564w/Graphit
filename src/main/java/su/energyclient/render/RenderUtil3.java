package su.energyclient.render;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.EnumMap;
import java.util.List;
import su.energyclient.util.Util150;
import su.energyclient.util.Util30;
import su.energyclient.util.Util42;
import su.energyclient.util.Util69;

public final class RenderUtil3 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Gson f_13404 = new GsonBuilder().setPrettyPrinting().create();
   private static final Logger f_13405 = System.getLogger(RenderUtil3.f_13427);
   private final Path f_13406;
   private final EnumMap<Util150, Util30> f_13407 = new EnumMap<>(Util150.class);
   private boolean f_13408 = true;
   private String f_13409;
   private static final String f_13410 = "Cosmetic is not in the bundled catalog";
   private static final long f_13411 = 65536L;
   private static final String f_13412 = "Wardrobe file is too large";
   private static final String f_13413 = "version";
   private static final String f_13414 = "version";
   private static final String f_13415 = "Unsupported wardrobe version";
   private static final String f_13416 = "enabled";
   private static final String f_13417 = "enabled";
   private static final String f_13418 = "equipped";
   private static final String f_13419 = "equipped";
   private static final String f_13420 = "Не удалось загрузить косметику";
   private static final String f_13421 = "version";
   private static final String f_13422 = "enabled";
   private static final String f_13423 = "equipped";
   private static final String f_13424 = "cosmetics-";
   private static final String f_13425 = ".tmp";
   private static final String f_13426 = "Не удалось сохранить косметику";
   private static final String f_13427 = "Energy/Cosmetics";

   public String m_386() {
      return this.f_13409;
   }

   public void m_2325(Util150 var1) {
      if (this.f_13407.remove(var1) != null || this.f_13409 != null) {
         this.m_797();
      }
   }

   public boolean m_1396(Util30 var1) {
      return var1 != null && var1.equals(this.f_13407.get(var1.slot()));
   }

   public void m_1747() {
      if (!this.f_13407.isEmpty() || this.f_13409 != null) {
         this.f_13407.clear();
         this.m_797();
      }
   }

   public static RenderUtil3 m_844() {
      return RenderUtil3.Inner_8QOsl0WqJxlCCqhx.f_4765;
   }

   public void m_1399(Util30 var1) {
      if (var1 == null || !var1.equals(Util69.m_2525(var1.id()))) {
         throw new IllegalArgumentException(f_13410);
      } else if (!this.f_13408 || !this.m_1396(var1) || this.f_13409 != null) {
         this.f_13407.put(var1.slot(), var1);
         this.f_13408 = true;
         this.m_797();
      }
   }

   private void m_3325() {
      if (Files.exists(this.f_13406)) {
         try {
            if (Files.size(this.f_13406) > f_13411) {
               throw new IOException(f_13412);
            }

            JsonObject var1 = JsonParser.parseString(Files.readString(this.f_13406, StandardCharsets.UTF_8)).getAsJsonObject();
            if (var1.has(f_13413) && var1.get(f_13414).getAsInt() != 1) {
               throw new IOException(f_13415);
            }

            boolean var2 = !var1.has(f_13416) || var1.get(f_13417).getAsBoolean();
            EnumMap var3 = new EnumMap<>(Util150.class);
            if (var1.has(f_13418)) {
               JsonObject var4 = var1.getAsJsonObject(f_13419);

               for (Util150 var8 : Util150.values()) {
                  JsonElement var9 = var4.get(var8.name());
                  if (var9 != null && var9.isJsonPrimitive() && var9.getAsJsonPrimitive().isString()) {
                     Util30 var10 = Util69.m_2525(var9.getAsString());
                     if (var10 != null && var10.slot() == var8) {
                        var3.put(var8, var10);
                     }
                  }
               }
            }

            this.f_13408 = var2;
            this.f_13407.putAll(var3);
            this.f_13409 = null;
         } catch (RuntimeException | IOException var11) {
            this.f_13409 = f_13420;
            f_13405.log(Level.WARNING, "Cannot read wardrobe " + this.f_13406, var11);
         }
      }
   }

   private void m_797() {
      Path var1 = null;

      try {
         Files.createDirectories(this.f_13406.getParent());
         JsonObject var2 = new JsonObject();
         var2.addProperty(f_13421, 1);
         var2.addProperty(f_13422, this.f_13408);
         JsonObject var3 = new JsonObject();
         this.f_13407.forEach((var1x, var2x) -> var3.addProperty(var1x.name(), var2x.id()));
         var2.add(f_13423, var3);
         var1 = Files.createTempFile(this.f_13406.getParent(), f_13424, f_13425);
         Files.writeString(var1, f_13404.toJson(var2), StandardCharsets.UTF_8);

         try {
            Files.move(var1, this.f_13406, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
         } catch (AtomicMoveNotSupportedException var14) {
            Files.move(var1, this.f_13406, StandardCopyOption.REPLACE_EXISTING);
         }

         this.f_13409 = null;
      } catch (RuntimeException | IOException var15) {
         this.f_13409 = f_13426;
         f_13405.log(Level.WARNING, "Cannot save wardrobe " + this.f_13406, var15);
      } finally {
         if (var1 != null) {
            try {
               Files.deleteIfExists(var1);
            } catch (IOException var13) {
            }
         }
      }
   }

   public List<Util30> m_1055() {
      return List.copyOf(this.f_13407.values());
   }

   public boolean m_1207() {
      return this.f_13408;
   }

   public void m_411(boolean var1) {
      if (this.f_13408 != var1 || this.f_13409 != null) {
         this.f_13408 = var1;
         this.m_797();
      }
   }

   public Util30 m_3164(Util150 var1) {
      return this.f_13407.get(var1);
   }

   RenderUtil3(Path var1) {
      this.f_13406 = var1.toAbsolutePath();
      this.m_3325();
   }

   private static final class Inner_8QOsl0WqJxlCCqhx {
      private static final RenderUtil3 f_4765 = new RenderUtil3(
         Path.of(Util42.f_7521, RenderUtil3.Inner_8QOsl0WqJxlCCqhx.f_4766, RenderUtil3.Inner_8QOsl0WqJxlCCqhx.f_4767)
      );
      private static final String f_4766 = "data";
      private static final String f_4767 = "cosmetics.json";
   }
}
