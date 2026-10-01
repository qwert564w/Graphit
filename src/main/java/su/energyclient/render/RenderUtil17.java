package su.energyclient.render;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.nio.file.Files;
import su.energyclient.util.Util42;
import su.energyclient.util.Util67;

public abstract class RenderUtil17<T> {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   protected static final Gson f_1416 = new GsonBuilder().setPrettyPrinting().create();
   protected static final String f_1417 = Util42.f_7521;
   protected final File f_1418;
   protected final boolean f_1419;
   protected T f_1420;

   protected abstract JsonObject m_9();

   protected abstract void m_10();

   protected RenderUtil17(String var1) {
      this(var1, true);
   }

   public T m_835() {
      return this.f_1420;
   }

   public void m_40() {
      this.m_1444();
      this.m_10();
      this.m_305();
   }

   public String m_2216() {
      return this.f_1418.getName();
   }

   protected abstract void m_7(JsonObject var1);

   protected void m_14(Exception var1) {
   }

   protected RenderUtil17(String var1, boolean var2) {
      this.f_1418 = new File(f_1417 + var1);
      this.f_1419 = var2;
   }

   protected void m_1444() {
      File var1 = this.f_1418.getParentFile();
      if (var1 != null && !var1.exists()) {
         var1.mkdirs();
      }
   }

   public String m_2016() {
      return this.f_1418.getAbsolutePath();
   }

   public void m_2691() {
      try {
         this.m_1444();
         JsonObject var1 = this.m_9();
         String var2 = f_1416.toJson(var1);
         String var3 = this.f_1419 ? Util67.m_3426(var2) : var2;
         Files.writeString(this.f_1418.toPath(), var3);
      } catch (Exception var4) {
         System.err.println("Failed to save config to " + this.f_1418.getName() + ": " + var4.getMessage());
         this.m_4080(var4);
      }
   }

   public boolean m_2592() {
      return this.f_1418.exists();
   }

   public void m_305() {
      if (this.f_1418.exists()) {
         try {
            String var1 = Files.readString(this.f_1418.toPath());
            String var2 = this.f_1419 ? Util67.m_1160(var1) : var1;
            JsonObject var3 = JsonParser.parseString(var2).getAsJsonObject();
            this.m_7(var3);
         } catch (Exception var4) {
            System.err.println("Failed to load config from " + this.f_1418.getName() + ": " + var4.getMessage());
            this.m_14(var4);
         }
      }
   }

   protected void m_112(T var1) {
      this.f_1420 = (T)var1;
   }

   public boolean m_109() {
      return this.f_1418.exists() && this.f_1418.delete();
   }

   protected void m_4080(Exception var1) {
   }
}
