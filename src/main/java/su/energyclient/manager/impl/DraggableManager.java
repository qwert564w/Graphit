package su.energyclient.manager.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.HashMap;
import java.util.Map;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil17;
import su.energyclient.util.Util112;

public class DraggableManager extends RenderUtil17<Map<String, Util112>> {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ObjectArrayList<Util112> f_2860 = new ObjectArrayList();
   private static final String f_2861 = "data\\drags.sk3d";
   private static final String f_2862 = "name";
   private static final String f_2863 = "x";
   private static final String f_2864 = "y";
   private static final String f_2865 = "draggings";
   private static final String f_2866 = "draggings";
   private static final String f_2867 = "draggings";
   private static final String f_2868 = "name";
   private static final String f_2869 = "x";
   private static final String f_2870 = "y";

   @Override
   protected JsonObject m_9() {
      JsonObject var1 = new JsonObject();
      JsonArray var2 = new JsonArray();
      ObjectListIterator var3 = this.f_2860.iterator();

      while (var3.hasNext()) {
         Util112 var4 = (Util112)var3.next();
         JsonObject var5 = new JsonObject();
         var5.addProperty(f_2862, var4.m_1651());
         var5.addProperty(f_2863, var4.m_2838());
         var5.addProperty(f_2864, var4.m_671());
         var2.add(var5);
      }

      var1.add(f_2865, var2);
      return var1;
   }

   @Override
   protected void m_7(JsonObject var1) {
      if (var1.has(f_2866)) {
         for (JsonElement var4 : var1.getAsJsonArray(f_2867)) {
            JsonObject var5 = var4.getAsJsonObject();
            String var6 = var5.get(f_2868).getAsString();
            float var7 = var5.get(f_2869).getAsFloat();
            float var8 = var5.get(f_2870).getAsFloat();
            this.f_2860.stream().filter(var1x -> var1x.m_1651().equals(var6)).findFirst().ifPresent(var2 -> {
               var2.m_1817(var7);
               var2.m_3694(var8);
            });
         }
      }
   }

   public DraggableManager() {
      super(f_2861);
      this.m_10();
   }

   public Util112 m_1896(Module var1, String var2, float var3, float var4) {
      String var5 = var1.m_1199() + "_" + var2;
      Util112 var6 = this.f_2860.stream().filter(var1x -> var1x.m_1651().equals(var5)).findFirst().orElse(null);
      if (var6 != null) {
         return var6;
      } else {
         Util112 var7 = new Util112(var1, var5, var3, var4);
         this.f_2860.add(var7);
         this.f_1420.put(var5, var7);
         return var7;
      }
   }

   @Override
   protected void m_10() {
      this.f_1420 = new HashMap<>();
   }

   public ObjectArrayList<Util112> m_2418() {
      return this.f_2860;
   }
}
