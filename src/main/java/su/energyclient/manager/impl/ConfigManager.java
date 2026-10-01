package su.energyclient.manager.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.function.Consumer;
import su.energyclient.EnergyClient;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Module;
import su.energyclient.module.ToggleMode;
import su.energyclient.render.RenderUtil17;
import su.energyclient.render.RenderUtil22;
import su.energyclient.setting.Setting;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util63;

public class ConfigManager extends RenderUtil17<ConfigManager.kmevokPGSRtvsx7y> {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_4935 = "data\\autoconfig.sk3d";
   private static final String f_4936 = "modules";
   private static final String f_4937 = "themeColor";
   private static final String f_4938 = "commandPrefix";
   private static final String f_4939 = "themeColor";
   private static final String f_4940 = "modules";
   private static final String f_4941 = "modules";
   private static final String f_4942 = "modules";
   private static final String f_4943 = "commandPrefix";
   private static final String f_4944 = "theme";
   private static final String f_4945 = "value";
   private static final String f_4946 = "value";
   private static final String f_4947 = "[Energy] AutoConfig: Starting save on shutdown...";
   private static final String f_4948 = "[Energy] AutoConfig: Saved successfully on shutdown!";
   private static final String f_4949 = "[Energy] AutoConfig: Starting load process...";
   private static final String f_4950 = "[Energy] AutoConfig: Loading config file...";
   private static final String f_4951 = "[Energy] AutoConfig: Config loaded successfully!";
   private static final String f_4952 = "[Energy] AutoConfig: Config file not found, will be created on first save";
   private static final String f_4953 = "key";
   private static final String f_4954 = "enabled";
   private static final String f_4955 = "togglemode";
   private static final String f_4956 = "key";
   private static final String f_4957 = "enabled";
   private static final String f_4958 = "togglemode";
   private static final String f_4959 = "name";
   private static final String f_4960 = "name";
   private static final String f_4961 = "Saved";
   private static final String f_4962 = "isCustom";
   private static final String f_4963 = "isCustom";
   private static final String f_4964 = "colors";

   private void m_2435(JsonObject var1, String var2, Consumer<JsonElement> var3) {
      JsonElement var4 = var1.get(var2);
      if (var4 != null && !var4.isJsonNull()) {
         var3.accept(var4);
      }
   }

   @Override
   protected JsonObject m_9() {
      JsonObject var1 = new JsonObject();
      var1.add(f_4936, this.m_3936());
      var1.addProperty(f_4937, EnergyClient.getThemeColor());
      if (InitManager.f_2740.f_2742 != null) {
         var1.addProperty(f_4938, InitManager.f_2740.f_2742.m_1465());
      }

      return var1;
   }

   @Override
   protected void m_7(JsonObject var1) {
      this.m_2435(var1, f_4939, var0 -> EnergyClient.setThemeColor(var0.getAsInt()));
      this.m_3421(var1);
      if (var1.has(f_4940) && !var1.get(f_4941).isJsonNull()) {
         this.m_1634(var1.getAsJsonObject(f_4942));
      }

      this.m_2435(var1, f_4943, var0 -> {
         if (InitManager.f_2740.f_2742 != null) {
            InitManager.f_2740.f_2742.m_3586(var0.getAsString());
         }
      });
   }

   private void m_1665(JsonObject var1, Setting var2) {
      try {
         if (var2 instanceof BooleanSetting var3) {
            JsonObject var8 = new JsonObject();
            var8.addProperty(f_4945, var3.m_1163());
            var1.add(var2.m_1488(), var8);
         } else if (var2 instanceof NumberSetting var4) {
            var1.addProperty(var2.m_1488(), var4.m_4046());
         } else if (var2 instanceof ModeSetting var5) {
            var1.addProperty(var2.m_1488(), var5.m_3862());
         } else if (var2 instanceof RenderUtil22 var6) {
            var1.addProperty(var2.m_1488(), var6.m_1958());
         } else if (var2 instanceof Util63 var7) {
            JsonObject var10 = new JsonObject();
            var7.m_841().forEach(var1x -> var10.addProperty(var1x.m_1488(), var1x.m_1163()));
            var1.add(var2.m_1488(), var10);
         }
      } catch (Exception var9) {
         System.err.println("Failed to save setting " + var2.m_1488() + ": " + var9.getMessage());
      }
   }

   public void m_3716() {
      try {
         System.out.println(f_4947);
         System.out.println("[Energy] AutoConfig: File path: " + this.m_2016());
         this.m_2691();
         if (InitManager.f_2740.f_2743 != null) {
            InitManager.f_2740.f_2743.m_2691();
         }

         System.out.println(f_4948);
      } catch (Exception var2) {
         System.err.println("[Energy] AutoConfig: Failed to save on shutdown - " + var2.getMessage());
         var2.printStackTrace();
      }
   }

   private void m_951(JsonObject var1, Setting var2) {
      JsonElement var3 = var1.get(var2.m_1488());
      if (var3 != null && !var3.isJsonNull()) {
         try {
            if (var2 instanceof NumberSetting var4) {
               var4.m_3690(var3.getAsFloat());
            } else if (var2 instanceof BooleanSetting var5) {
               if (var3.isJsonObject()) {
                  JsonObject var9 = var3.getAsJsonObject();
                  this.m_2435(var9, f_4946, var1x -> var5.m_1848(var1x.getAsBoolean()));
               }
            } else if (var2 instanceof ModeSetting var6) {
               var6.m_21(var3.getAsString());
            } else if (var2 instanceof RenderUtil22 var7) {
               var7.m_466(var3.getAsInt());
            } else if (var2 instanceof Util63 var8 && var3.isJsonObject()) {
               JsonObject var11 = var3.getAsJsonObject();
               var8.m_841().forEach(var1x -> {
                  JsonElement var2x = var11.get(var1x.m_1488());
                  if (var2x != null && !var2x.isJsonNull()) {
                     var1x.m_1848(var2x.getAsBoolean());
                  }
               });
            }
         } catch (Exception var10) {
            System.err.println("Failed to load setting " + var2.m_1488() + ": " + var10.getMessage());
         }
      }
   }

   public void m_2437() {
      try {
         System.out.println(f_4949);
         System.out.println("[Energy] AutoConfig: File path: " + this.m_2016());
         System.out.println("[Energy] AutoConfig: File exists: " + this.m_2592());
         if (this.m_2592()) {
            System.out.println(f_4950);
            this.m_305();
            System.out.println(f_4951);
         } else {
            System.out.println(f_4952);
         }
      } catch (Exception var2) {
         System.err.println("[Energy] AutoConfig: Failed to load - " + var2.getMessage());
         var2.printStackTrace();
      }
   }

   @Override
   protected void m_10() {
      this.f_1420 = new ConfigManager.kmevokPGSRtvsx7y();
   }

   public ConfigManager() {
      super(f_4935);
   }

   private JsonObject m_3936() {
      JsonObject var1 = new JsonObject();
      if (InitManager.f_2740.f_2741 == null) {
         return var1;
      } else {
         InitManager.f_2740.f_2741.m_3515().forEach(var2 -> {
            JsonObject var3 = new JsonObject();
            var3.addProperty(f_4956, var2.m_689());
            var3.addProperty(f_4957, var2.m_677());
            var3.addProperty(f_4958, var2.m_696().name());
            var2.m_179().forEach(var2x -> this.m_1665(var3, var2x));
            var1.add(var2.m_1199().toLowerCase(), var3);
         });
         return var1;
      }
   }

   private void m_3421(JsonObject var1) {
      this.m_2435(var1, f_4944, var1x -> {
         try {
            JsonObject var2 = var1x.getAsJsonObject();
            String var3 = var2.has(f_4959) ? var2.get(f_4960).getAsString() : f_4961;
            boolean var4 = var2.has(f_4962) && var2.get(f_4963).getAsBoolean();
            JsonArray var5 = var2.getAsJsonArray(f_4964);
            if (var5 != null) {
               int[] var6 = new int[var5.size()];

               for (int var7 = 0; var7 < var5.size(); var7++) {
                  var6[var7] = var5.get(var7).getAsInt();
               }

               this.f_1420.m_2911(var3);
               this.f_1420.m_4128(var6);
               this.f_1420.m_1734(var4);
               if (var6.length > 0) {
                  EnergyClient.setThemeColor(var6[0]);
               }
            }
         } catch (Exception var8) {
            System.err.println("Failed to load theme from autoconfig: " + var8.getMessage());
         }
      });
   }

   private void m_1634(JsonObject var1) {
      if (InitManager.f_2740.f_2741 != null) {
         boolean var2 = Module.m_2448();
         Module.m_2182(true);

         try {
            InitManager.f_2740.f_2741.m_3515().forEach(var2x -> {
               JsonObject var3 = var1.getAsJsonObject(var2x.m_1199().toLowerCase());
               if (var3 != null) {
                  var2x.m_1926(false);
                  this.m_2435(var3, f_4953, var1xx -> var2x.m_1957(var1xx.getAsInt()));
                  this.m_2435(var3, f_4954, var1xx -> var2x.m_1926(var1xx.getAsBoolean()));
                  this.m_2435(var3, f_4955, var1xx -> {
                     try {
                        var2x.m_159(ToggleMode.valueOf(var1xx.getAsString()));
                     } catch (Exception var3x) {
                        var2x.m_159(ToggleMode.TOGGLE);
                     }
                  });
                  var2x.m_179().forEach(var2xx -> this.m_951(var3, var2xx));
               }
            });
         } finally {
            Module.m_2182(var2);
         }
      }
   }

   public static class kmevokPGSRtvsx7y {
      private String f_1135;
      private int[] f_1136;
      private boolean f_1137;
      private String f_1138;

      public void m_2911(String var1) {
         this.f_1135 = var1;
      }

      public String m_667() {
         return this.f_1135;
      }

      public void m_1734(boolean var1) {
         this.f_1137 = var1;
      }

      public boolean m_643() {
         return this.f_1137;
      }

      public void m_4128(int[] var1) {
         this.f_1136 = var1;
      }

      public void m_1813(String var1) {
         this.f_1138 = var1;
      }

      public int[] m_3453() {
         return this.f_1136;
      }

      public String m_3020() {
         return this.f_1138;
      }
   }
}
