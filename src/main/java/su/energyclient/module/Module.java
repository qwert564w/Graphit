package su.energyclient.module;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.lang.reflect.Field;
import net.minecraft.util.Formatting;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.manager.InitManager;
import su.energyclient.manager.impl.RotationManager;
import su.energyclient.module.miscellaneous.ClientSounds;
import su.energyclient.setting.Setting;
import su.energyclient.util.Util153;
import su.energyclient.util.Util165;
import su.energyclient.util.Util71;
import su.energyclient.util.Util89;

public abstract class Module implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private String f_8303;
   private String f_8304;
   private Category f_8305;
   private Util165 f_8306;
   private Util165 f_8307;
   private boolean f_8308;
   private int f_8309;
   private ToggleMode f_8310;
   private ObjectArrayList<Setting> f_8311;
   private static boolean f_8312 = false;
   private static final long f_8313 = 150L;
   private static final long f_8314 = 200L;
   private static final String f_8315 = "Мод 1";
   private static final String f_8316 = "Мод 2";
   private static final String f_8317 = "enable1";
   private static final String f_8318 = "apple_enable";
   private static final String f_8319 = "+";
   private static final String f_8320 = "Мод 1";
   private static final String f_8321 = "Мод 2";
   private static final String f_8322 = "disable1";
   private static final String f_8323 = "apple_disable";
   private static final String f_8324 = "-";

   public void m_680() {
      this.f_8308 = !this.f_8308;
      if (this.f_8308) {
         this.m_2();
      } else {
         this.m_1();
      }
   }

   public void m_2() {
      this.f_8308 = true;
      this.f_8307.m_3631(1.0);
      if (!f_8312) {
         ClientSounds var1 = InitManager.f_2740.f_2741 != null ? InitManager.f_2740.f_2741.clientSounds : null;
         if (var1 != null && var1.m_677()) {
            String var2 = var1.f_5040.m_3862();
            switch (var2) {
               case f_8315:
                  Util89.m_3138(f_8317);
                  break;
               case f_8316:
                  Util89.m_3138(f_8318);
            }
         }

         RotationManager.m_260(f_8319, this.f_8303 + " enabled", Util71.m_1415(112, 242, 156));
      }

      EnergyClient.f_1622.f_1624.m_32(this);
   }

   public static boolean m_2448() {
      return f_8312;
   }

   public void m_3545(Util165 var1) {
      this.f_8307 = var1;
   }

   public void m_2346(Category var1) {
      this.f_8305 = var1;
   }

   public Util165 m_236() {
      return this.f_8306;
   }

   public void m_1957(int var1) {
      this.f_8309 = var1;
   }

   public ToggleMode m_696() {
      return this.f_8310;
   }

   public void m_3680(String var1) {
      this.f_8303 = var1;
   }

   public String m_1199() {
      return this.f_8303;
   }

   public void m_3025(ObjectArrayList<Setting> var1) {
      this.f_8311 = var1;
   }

   public ObjectArrayList<Setting> m_2728() {
      return this.f_8311;
   }

   public void m_3347(Util165 var1) {
      this.f_8306 = var1;
   }

   public Util165 m_2432() {
      return this.f_8307;
   }

   public void m_2204(String var1) {
      this.f_8304 = var1;
   }

   public Module(String var1, String var2, Category var3) {
      this.f_8306 = new Util165(Util153.LINEAR, f_8313);
      this.f_8307 = new Util165(Util153.LINEAR, f_8314);
      this.f_8310 = ToggleMode.TOGGLE;
      this.f_8303 = var1;
      this.f_8304 = var2;
      this.f_8305 = var3;
      this.f_8308 = false;
      this.f_8309 = -1;
   }

   public ObjectArrayList<Setting> m_179() {
      if (this.f_8311 != null) {
         return this.f_8311;
      } else {
         ObjectArrayList var1 = new ObjectArrayList();

         try {
            for (Field var5 : this.getClass().getDeclaredFields()) {
               var5.setAccessible(true);
               if (var5.get(this) instanceof Setting var7) {
                  var1.add(var7);
               }
            }
         } catch (Exception var8) {
         }

         this.f_8311 = var1;
         return this.f_8311;
      }
   }

   public boolean m_677() {
      return this.f_8308;
   }

   public void m_1() {
      this.f_8308 = false;
      this.f_8307.m_3631(0.0);
      if (!f_8312) {
         ClientSounds var1 = InitManager.f_2740.f_2741 != null ? InitManager.f_2740.f_2741.clientSounds : null;
         if (var1 != null && var1.m_677()) {
            String var2 = var1.f_5040.m_3862();
            switch (var2) {
               case f_8320:
                  Util89.m_3138(f_8322);
                  break;
               case f_8321:
                  Util89.m_3138(f_8323);
            }
         }

         RotationManager.m_260(f_8324, Formatting.GRAY + this.f_8303 + " disabled", Util71.m_1415(255, 126, 126));
      }

      EnergyClient.f_1622.f_1624.m_52(this);
   }

   public static void m_2182(boolean var0) {
      f_8312 = var0;
   }

   public void m_1926(boolean var1) {
      boolean var2 = this.f_8308;
      this.f_8308 = var1;

      try {
         if (var1) {
            this.m_2();
         } else if (var2) {
            this.m_1();
         }
      } catch (Exception var4) {
         this.f_8308 = false;
         this.m_1();
      }
   }

   public int m_689() {
      return this.f_8309;
   }

   public void m_159(ToggleMode var1) {
      this.f_8310 = var1;
   }

   public String m_2644() {
      return this.f_8304;
   }

   public Category m_2409() {
      return this.f_8305;
   }
}
