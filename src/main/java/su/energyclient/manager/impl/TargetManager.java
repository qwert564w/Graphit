package su.energyclient.manager.impl;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Module;
import su.energyclient.module.ToggleMode;
import su.energyclient.render.RenderUtil17;
import su.energyclient.render.RenderUtil22;
import su.energyclient.setting.Setting;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util42;
import su.energyclient.util.Util63;
import su.energyclient.util.Util67;
import su.energyclient.util.Util90;

public class TargetManager extends RenderUtil17<TargetManager.h0hCwMrcXFXtkGo5> {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final File f_7093 = new File(Util42.f_7521 + "data\\custom.sk3d");
   private static final String f_7094 = "data\\custom.sk3d";
   private static final String f_7095 = "lastLoadedConfig";
   private static final String f_7096 = "lastLoadedConfig";
   private static final String f_7097 = "lastLoadedConfig";
   private static final String f_7098 = "lastLoadedConfig";
   private static final String f_7099 = ".cfg";
   private static final String f_7100 = "Cannot load config: name is null or empty";
   private static final String f_7101 = "module";
   private static final String f_7102 = "module";
   private static final String f_7103 = "module";
   private static final String f_7104 = "Cannot save config: name is null or empty";
   private static final String f_7105 = "module";
   private static final String f_7106 = "creationDate";
   private static final String f_7107 = "creator";
   private static final String f_7108 = "Cannot delete config: name is null or empty";
   private static final String f_7109 = "Cannot get config info: name is null or empty";
   private static final String f_7110 = "creationDate";
   private static final String f_7111 = "creationDate";
   private static final String f_7112 = "creationDate";
   private static final String f_7113 = "creator";
   private static final String f_7114 = "creator";
   private static final String f_7115 = "creator";
   private static final String f_7116 = "Unknown";
   private static final String f_7117 = "Файл не выбран";
   private static final String f_7118 = "Файл недоступен";
   private static final String f_7119 = ".cfg";
   private static final String f_7120 = "Нужен файл с расширением .cfg";
   private static final String f_7121 = "module";
   private static final String f_7122 = "Файл не похож на конфиг клиента";
   private static final String f_7123 = "Готов к загрузке";
   private static final String f_7124 = "Не удалось прочитать конфиг";
   private static final String f_7125 = "Конфиг импортирован, но не загрузился";
   private static final String f_7126 = "Конфиг загружен";
   private static final String f_7127 = "Не удалось импортировать конфиг";
   private static final String f_7128 = "value";
   private static final String f_7129 = "value";
   private static final String f_7130 = "config.cfg";
   private static final String f_7131 = "[\\\\/:*?\"<>|]";
   private static final String f_7132 = "_";
   private static final String f_7133 = "\\s+";
   private static final String f_7134 = "_";
   private static final String f_7135 = "_+";
   private static final String f_7136 = "_";
   private static final String f_7137 = "^_+";
   private static final String f_7138 = "_+$";
   private static final String f_7139 = "imported_config";
   private static final String f_7140 = "key";
   private static final String f_7141 = "enabled";
   private static final String f_7142 = "togglemode";
   private static final String f_7143 = "key";
   private static final String f_7144 = "enabled";
   private static final String f_7145 = "togglemode";
   private static final String f_7146 = ".cfg";

   @Override
   protected void m_7(JsonObject var1) {
      if (var1.has(f_7096) && !var1.get(f_7097).isJsonNull()) {
         this.f_1420.m_3454(var1.get(f_7098).getAsString());
      }
   }

   private void m_1476(JsonObject var1, Setting var2) {
      JsonElement var3 = var1.get(var2.m_1488());
      if (var3 != null && !var3.isJsonNull()) {
         try {
            if (var2 instanceof NumberSetting) {
               ((NumberSetting)var2).m_3690(var3.getAsFloat());
            } else if (var2 instanceof BooleanSetting) {
               if (var3.isJsonObject()) {
                  JsonObject var4 = var3.getAsJsonObject();
                  BooleanSetting var5 = (BooleanSetting)var2;
                  this.m_1945(var4, f_7128, var1x -> var5.m_1848(var1x.getAsBoolean()));
               }
            } else if (var2 instanceof ModeSetting) {
               ((ModeSetting)var2).m_21(var3.getAsString());
            } else if (var2 instanceof RenderUtil22) {
               ((RenderUtil22)var2).m_466(var3.getAsInt());
            } else if (var2 instanceof Util63 && var3.isJsonObject()) {
               JsonObject var7 = var3.getAsJsonObject();
               Util63 var8 = (Util63)var2;
               var8.m_841().forEach(var1x -> {
                  JsonElement var2x = var7.get(var1x.m_1488());
                  if (var2x != null && !var2x.isJsonNull()) {
                     var1x.m_1848(var2x.getAsBoolean());
                  }
               });
            }
         } catch (Exception var6) {
            System.err.println("Failed to load setting " + var2.m_1488() + ": " + var6.getMessage());
         }
      }
   }

   private String m_3411(Path var1) {
      if (var1 == null) {
         return f_7130;
      } else {
         Path var2 = var1.getFileName();
         return var2 != null ? var2.toString() : var1.toString();
      }
   }

   @Override
   protected JsonObject m_9() {
      JsonObject var1 = new JsonObject();
      if (this.f_1420.m_2396() != null) {
         var1.addProperty(f_7095, this.f_1420.m_2396());
      }

      return var1;
   }

   private TargetManager.BMnfwtQglxOM05G9 m_975(String var1, String var2, String var3) {
      return new TargetManager.BMnfwtQglxOM05G9(true, var1, var2, var3);
   }

   public void m_1961(String var1) {
      if (var1 != null && !var1.trim().isEmpty()) {
         f_7093.mkdirs();
         File var2 = new File(f_7093, var1.trim() + ".cfg");

         try {
            JsonObject var3 = new JsonObject();
            var3.add(f_7105, this.m_810());
            var3.addProperty(f_7106, System.currentTimeMillis());
            var3.addProperty(f_7107, Util90.f_5919);
            String var4 = f_1416.toJson(var3);
            String var5 = this.f_1419 ? Util67.m_3426(var4) : var4;
            Files.writeString(var2.toPath(), var5);
         } catch (Exception var6) {
            System.err.println("Failed to save config: " + var1 + " - " + var6.getMessage());
         }
      } else {
         System.err.println(f_7104);
      }
   }

   public TargetManager.BMnfwtQglxOM05G9 m_620(Path var1) {
      TargetManager.BMnfwtQglxOM05G9 var2 = this.m_1940(var1);
      if (!var2.success()) {
         return var2;
      } else {
         try {
            f_7093.mkdirs();
            Path var3 = new File(f_7093, var2.configName() + ".cfg").toPath();
            Path var4 = var1.toAbsolutePath().normalize();
            Path var5 = var3.toAbsolutePath().normalize();
            if (!var4.equals(var5)) {
               Files.copy(var1, var3, StandardCopyOption.REPLACE_EXISTING);
            }

            return !this.m_1074(var2.configName())
               ? this.m_2725(var2.sourceName(), var2.configName(), f_7125)
               : this.m_975(var2.sourceName(), var2.configName(), f_7126);
         } catch (Exception var6) {
            return this.m_2725(var2.sourceName(), var2.configName(), f_7127);
         }
      }
   }

   public boolean m_1074(String var1) {
      if (var1 != null && !var1.trim().isEmpty()) {
         File var2 = new File(f_7093, var1.trim() + ".cfg");
         if (!var2.exists()) {
            return false;
         } else {
            try {
               JsonObject var3 = this.m_3999(var2.toPath());
               if (var3.has(f_7101) && var3.get(f_7102).isJsonObject()) {
                  this.m_624(var3.getAsJsonObject(f_7103));
                  this.f_1420.m_3454(var1);
                  this.m_2691();
                  return true;
               }
            } catch (Exception var4) {
               System.err.println("Failed to load config: " + var1 + " - " + var4.getMessage());
            }

            return false;
         }
      } else {
         System.err.println(f_7100);
         return false;
      }
   }

   private void m_1945(JsonObject var1, String var2, Consumer<JsonElement> var3) {
      JsonElement var4 = var1.get(var2);
      if (var4 != null && !var4.isJsonNull()) {
         var3.accept(var4);
      }
   }

   public TargetManager.BMnfwtQglxOM05G9 m_1940(Path var1) {
      String var2 = this.m_3411(var1);
      if (var1 == null) {
         return this.m_2725(var2, "", f_7117);
      } else {
         try {
            if (Files.exists(var1) && Files.isRegularFile(var1)) {
               if (!var2.toLowerCase(Locale.ROOT).endsWith(f_7119)) {
                  return this.m_2725(var2, "", f_7120);
               } else {
                  String var3 = this.m_1131(var2.substring(0, var2.length() - 4));
                  JsonObject var4 = this.m_3999(var1);
                  JsonElement var5 = var4.get(f_7121);
                  return var5 != null && var5.isJsonObject() ? this.m_975(var2, var3, f_7123) : this.m_2725(var2, var3, f_7122);
               }
            } else {
               return this.m_2725(var2, "", f_7118);
            }
         } catch (Exception var6) {
            return this.m_2725(var2, "", f_7124);
         }
      }
   }

   public TargetManager() {
      super(f_7094);
   }

   private String m_1131(String var1) {
      String var2 = var1 == null ? "" : var1.trim();
      var2 = var2.replaceAll(f_7131, f_7132);
      var2 = var2.replaceAll(f_7133, f_7134);
      var2 = var2.replaceAll(f_7135, f_7136);
      var2 = var2.replaceAll(f_7137, "").replaceAll(f_7138, "");
      return var2.isEmpty() ? f_7139 : var2;
   }

   private void m_624(JsonObject var1) {
      boolean var2 = Module.m_2448();
      Module.m_2182(true);

      try {
         InitManager.f_2740.f_2741.m_3515().forEach(var2x -> {
            JsonObject var3 = var1.getAsJsonObject(var2x.m_1199().toLowerCase());
            if (var3 != null) {
               var2x.m_1926(false);
               this.m_1945(var3, f_7143, var1xx -> var2x.m_1957(var1xx.getAsInt()));
               this.m_1945(var3, f_7144, var1xx -> var2x.m_1926(var1xx.getAsBoolean()));
               this.m_1945(var3, f_7145, var1xx -> {
                  try {
                     var2x.m_159(ToggleMode.valueOf(var1xx.getAsString()));
                  } catch (Exception var3x) {
                     var2x.m_159(ToggleMode.TOGGLE);
                  }
               });
               var2x.m_179().forEach(var2xx -> this.m_1476(var3, var2xx));
            }
         });
      } finally {
         Module.m_2182(var2);
      }
   }

   public List<String> m_1599() {
      File[] var1 = f_7093.listFiles((var0, var1x) -> var1x.endsWith(f_7146));
      if (var1 == null) {
         return Collections.emptyList();
      } else {
         ArrayList var2 = new ArrayList();

         for (File var6 : var1) {
            var2.add(var6.getName().replace(f_7099, ""));
         }

         return var2;
      }
   }

   private TargetManager.BMnfwtQglxOM05G9 m_2725(String var1, String var2, String var3) {
      return new TargetManager.BMnfwtQglxOM05G9(false, var1, var2, var3);
   }

   public void m_3733() {
      boolean var1 = Module.m_2448();
      Module.m_2182(true);

      try {
         InitManager.f_2740.f_2741.m_3515().forEach(var0 -> {
            var0.m_1926(false);
            var0.m_1957(-1);
            var0.m_159(ToggleMode.TOGGLE);
            var0.m_179().forEach(var0x -> {
               try {
                  if (var0x instanceof BooleanSetting var1x) {
                     var1x.m_1848(var1x.m_1163());
                  } else if (var0x instanceof NumberSetting var2) {
                     var2.m_3690(var2.m_4046());
                  } else if (var0x instanceof ModeSetting var3) {
                     var3.m_21(var3.m_3862());
                  } else if (var0x instanceof RenderUtil22 var4x) {
                     var4x.m_466(-1);
                  } else if (var0x instanceof Util63 var5) {
                     var5.m_841().forEach(var0xx -> var0xx.m_1848(var0xx.m_1163()));
                  }
               } catch (Exception var6) {
               }
            });
         });
      } finally {
         Module.m_2182(var1);
      }
   }

   private JsonObject m_810() {
      JsonObject var1 = new JsonObject();
      InitManager.f_2740.f_2741.m_3515().forEach(var2 -> {
         JsonObject var3 = new JsonObject();
         var3.addProperty(f_7140, var2.m_689());
         var3.addProperty(f_7141, var2.m_677());
         var3.addProperty(f_7142, var2.m_696().name());
         var2.m_179().forEach(var2x -> this.m_3499(var3, var2x));
         var1.add(var2.m_1199().toLowerCase(), var3);
      });
      return var1;
   }

   private void m_3499(JsonObject var1, Setting var2) {
      try {
         if (var2 instanceof BooleanSetting var3) {
            JsonObject var4 = new JsonObject();
            var4.addProperty(f_7129, var3.m_1163());
            var1.add(var2.m_1488(), var4);
         } else if (var2 instanceof NumberSetting) {
            var1.addProperty(var2.m_1488(), ((NumberSetting)var2).m_4046());
         } else if (var2 instanceof ModeSetting) {
            var1.addProperty(var2.m_1488(), ((ModeSetting)var2).m_3862());
         } else if (var2 instanceof RenderUtil22) {
            var1.addProperty(var2.m_1488(), ((RenderUtil22)var2).m_1958());
         } else if (var2 instanceof Util63 var6) {
            JsonObject var7 = new JsonObject();
            var6.m_841().forEach(var1x -> var7.addProperty(var1x.m_1488(), var1x.m_1163()));
            var1.add(var2.m_1488(), var7);
         }
      } catch (Exception var5) {
         System.err.println("Failed to save setting " + var2.m_1488() + ": " + var5.getMessage());
      }
   }

   public boolean m_1959(String var1) {
      if (var1 != null && !var1.trim().isEmpty()) {
         boolean var2 = new File(f_7093, var1.trim() + ".cfg").delete();
         if (var2 && var1.equals(this.f_1420.m_2396())) {
            this.f_1420.m_3454(null);
            this.m_2691();
         }

         return var2;
      } else {
         System.err.println(f_7108);
         return false;
      }
   }

   @Override
   protected void m_10() {
      this.f_1420 = new TargetManager.h0hCwMrcXFXtkGo5();
   }

   private JsonObject m_3999(Path var1) throws Exception {
      String var2 = Files.readString(var1);
      String var3 = this.f_1419 ? Util67.m_1160(var2) : var2;
      return JsonParser.parseString(var3).getAsJsonObject();
   }

   @Override
   public void m_40() {
      f_7093.mkdirs();
      super.m_40();
   }

   public TargetManager.ZNgd6M3Zoyu1znqA m_288(String var1) {
      if (var1 != null && !var1.trim().isEmpty()) {
         File var2 = new File(f_7093, var1.trim() + ".cfg");
         if (!var2.exists()) {
            return null;
         } else {
            try {
               JsonObject var3 = this.m_3999(var2.toPath());
               long var4 = var3.has(f_7110) && !var3.get(f_7111).isJsonNull() ? var3.get(f_7112).getAsLong() : System.currentTimeMillis();
               String var6 = var3.has(f_7113) && !var3.get(f_7114).isJsonNull() ? var3.get(f_7115).getAsString() : f_7116;
               return new TargetManager.ZNgd6M3Zoyu1znqA(var1, var4, var6);
            } catch (Exception var7) {
               return new TargetManager.ZNgd6M3Zoyu1znqA(var1);
            }
         }
      } else {
         System.err.println(f_7109);
         return null;
      }
   }

   public record BMnfwtQglxOM05G9(boolean success, String sourceName, String configName, String message) {
   }

   public static class ZNgd6M3Zoyu1znqA {
      private final String f_2684;
      private final File f_2685;
      private final long f_2686;
      private final String f_2687;
      private static final String f_2688 = "Unknown";

      public String m_423() {
         return this.f_2684;
      }

      public File m_480() {
         return this.f_2685;
      }

      public ZNgd6M3Zoyu1znqA(String var1) {
         this.f_2684 = var1;
         this.f_2685 = new File(TargetManager.f_7093, var1 + ".cfg");
         this.f_2686 = System.currentTimeMillis();
         this.f_2687 = Util90.f_5919;
      }

      public String m_200() {
         return this.f_2687;
      }

      public ZNgd6M3Zoyu1znqA(String var1, long var2, String var4) {
         this.f_2684 = var1;
         this.f_2685 = new File(TargetManager.f_7093, var1 + ".cfg");
         this.f_2686 = var2;
         this.f_2687 = var4 != null ? var4 : f_2688;
      }

      public long m_903() {
         return this.f_2686;
      }
   }

   public static class h0hCwMrcXFXtkGo5 {
      private String f_4905;

      public void m_3454(String var1) {
         this.f_4905 = var1;
      }

      public String m_2396() {
         return this.f_4905;
      }
   }
}
