package su.energyclient.manager.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import su.energyclient.render.RenderUtil17;

public class WaypointsManager extends RenderUtil17<List<WaypointsManager.Inner_9JcfksyJpnbcaVkW>> {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_551 = "data\\macros.sk3d";
   private static final String f_552 = "name";
   private static final String f_553 = "key";
   private static final String f_554 = "cmd";
   private static final String f_555 = "macros";
   private static final String f_556 = "macros";
   private static final String f_557 = "name";
   private static final String f_558 = "key";
   private static final String f_559 = "cmd";

   private void m_1846(JsonObject var1, String var2, Consumer<JsonElement> var3) {
      JsonElement var4 = var1.get(var2);
      if (var4 != null && !var4.isJsonNull()) {
         var3.accept(var4);
      }
   }

   public void m_1975() {
      if (!this.f_1420.isEmpty()) {
         this.f_1420.clear();
         this.m_2691();
      }
   }

   public WaypointsManager() {
      super(f_551);
   }

   public List<WaypointsManager.Inner_9JcfksyJpnbcaVkW> m_817() {
      return new ArrayList<>(this.f_1420);
   }

   @Override
   protected JsonObject m_9() {
      JsonObject var1 = new JsonObject();
      JsonArray var2 = new JsonArray();

      for (WaypointsManager.Inner_9JcfksyJpnbcaVkW var4 : this.f_1420) {
         JsonObject var5 = new JsonObject();
         var5.addProperty(f_552, var4.m_3303());
         var5.addProperty(f_553, var4.m_3326());
         var5.addProperty(f_554, var4.m_1474());
         var2.add(var5);
      }

      var1.add(f_555, var2);
      return var1;
   }

   public void m_606(String var1) {
      if (var1 != null) {
         boolean var2 = this.f_1420.removeIf(var1x -> var1x.m_3303().equalsIgnoreCase(var1.trim()));
         if (var2) {
            this.m_2691();
         }
      }
   }

   public void m_456(String var1, int var2, String var3) {
      if (var1 != null && var3 != null) {
         this.m_606(var1);
         this.f_1420.add(new WaypointsManager.Inner_9JcfksyJpnbcaVkW(var1.trim(), var2, var3));
         this.m_2691();
      }
   }

   @Override
   protected void m_14(Exception var1) {
      if (this.f_1420 == null) {
         this.m_10();
      }
   }

   @Override
   protected void m_7(JsonObject var1) {
      this.f_1420.clear();
      JsonArray var2 = var1.getAsJsonArray(f_556);
      if (var2 != null) {
         for (JsonElement var4 : var2) {
            if (var4.isJsonObject()) {
               JsonObject var5 = var4.getAsJsonObject();
               this.m_1846(var5, f_557, var2x -> this.m_1846(var5, f_558, var3 -> this.m_1846(var5, f_559, var3x -> {
                  try {
                     this.f_1420.add(new WaypointsManager.Inner_9JcfksyJpnbcaVkW(var2x.getAsString(), var3.getAsInt(), var3x.getAsString()));
                  } catch (Exception var5x) {
                  }
               })));
            }
         }
      }
   }

   @Override
   protected void m_10() {
      this.f_1420 = new ArrayList<>();
   }

   public static class Inner_9JcfksyJpnbcaVkW {
      private final String f_10806;
      private final int f_10807;
      private final String f_10808;

      public Inner_9JcfksyJpnbcaVkW(String var1, int var2, String var3) {
         this.f_10806 = var1;
         this.f_10807 = var2;
         this.f_10808 = var3;
      }

      public int m_3326() {
         return this.f_10807;
      }

      public String m_1474() {
         return this.f_10808;
      }

      public String m_3303() {
         return this.f_10806;
      }
   }
}
