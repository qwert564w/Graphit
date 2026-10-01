package su.energyclient.manager.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.entity.player.PlayerEntity;
import su.energyclient.render.RenderUtil17;

public class FriendManager extends RenderUtil17<List<FriendManager.Cfsq1JrSJubpZ92Z>> {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_963 = "data\\friends.sk3d";
   private static final String f_964 = "name";
   private static final String f_965 = "addedTime";
   private static final String f_966 = "friends";
   private static final String f_967 = "friends";
   private static final String f_968 = "name";
   private static final String f_969 = "Cannot add friend: name is null or empty";
   private static final String f_970 = "Cannot remove friend: name is null";
   private static final String f_971 = "addedTime";

   @Override
   protected void m_7(JsonObject var1) {
      this.f_1420.clear();
      JsonArray var2 = var1.getAsJsonArray(f_967);
      if (var2 != null) {
         for (JsonElement var4 : var2) {
            if (var4.isJsonObject()) {
               JsonObject var5 = var4.getAsJsonObject();
               this.m_1816(var5, f_968, var2x -> this.m_1816(var5, f_971, var2xx -> {
                  try {
                     String var3 = var2x.getAsString();
                     String var4x = var2xx.getAsString();
                     LocalDateTime var5x = LocalDateTime.parse(var4x, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                     this.f_1420.add(new FriendManager.Cfsq1JrSJubpZ92Z(var3, var5x));
                  } catch (Exception var6) {
                     System.err.println("Failed to parse friend entry: " + var6.getMessage());
                  }
               }));
            }
         }
      }
   }

   public void m_1236() {
      if (!this.f_1420.isEmpty()) {
         this.f_1420.clear();
         this.m_2691();
      }
   }

   private void m_1816(JsonObject var1, String var2, Consumer<JsonElement> var3) {
      JsonElement var4 = var1.get(var2);
      if (var4 != null && !var4.isJsonNull()) {
         var3.accept(var4);
      }
   }

   public List<FriendManager.Cfsq1JrSJubpZ92Z> m_3756() {
      return new ArrayList<>(this.f_1420);
   }

   @Override
   protected JsonObject m_9() {
      JsonObject var1 = new JsonObject();
      JsonArray var2 = new JsonArray();

      for (FriendManager.Cfsq1JrSJubpZ92Z var4 : this.f_1420) {
         JsonObject var5 = new JsonObject();
         var5.addProperty(f_964, var4.m_173());
         var5.addProperty(f_965, var4.m_4092().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
         var2.add(var5);
      }

      var1.add(f_966, var2);
      return var1;
   }

   @Override
   protected void m_14(Exception var1) {
      if (this.f_1420 == null) {
         this.m_10();
      }
   }

   public FriendManager() {
      super(f_963);
   }

   public boolean m_2704(String var1) {
      return var1 == null ? false : this.f_1420.stream().anyMatch(var1x -> var1x.m_173().equalsIgnoreCase(var1.trim()));
   }

   public void m_3798(String var1) {
      if (var1 == null) {
         System.err.println(f_970);
      } else {
         boolean var2 = this.f_1420.removeIf(var1x -> var1x.m_173().equalsIgnoreCase(var1.trim()));
         if (var2) {
            this.m_2691();
         }
      }
   }

   public boolean m_3914(PlayerEntity var1) {
      return var1 != null && this.m_2704(var1.getGameProfile().name());
   }

   public void m_959(String var1) {
      if (var1 != null && !var1.trim().isEmpty()) {
         String var2 = var1.trim();
         if (!this.m_2704(var2)) {
            this.f_1420.add(new FriendManager.Cfsq1JrSJubpZ92Z(var2, LocalDateTime.now()));
            this.m_2691();
         }
      } else {
         System.err.println(f_969);
      }
   }

   @Override
   protected void m_10() {
      this.f_1420 = new ArrayList<>();
   }

   public static class Cfsq1JrSJubpZ92Z {
      private final String f_2738;
      private final LocalDateTime f_2739;

      public LocalDateTime m_4092() {
         return this.f_2739;
      }

      public Cfsq1JrSJubpZ92Z(String var1, LocalDateTime var2) {
         this.f_2738 = var1;
         this.f_2739 = var2;
      }

      public String m_173() {
         return this.f_2738;
      }

      @Override
      public String toString() {
         return this.f_2738 + " (" + this.f_2739.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + ")";
      }
   }
}
