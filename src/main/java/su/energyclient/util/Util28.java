package su.energyclient.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil22;
import su.energyclient.setting.Setting;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;

public final class Util28 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final List<Util28.nlM2fh0AzQtK9c6l> f_3445;
   private final float f_3446;
   private final float f_3447;
   private static final float f_3448 = 18.0F;
   private static final float f_3449 = 18.0F;
   private static final float f_3450 = 18.0F;
   private static final float f_3451 = 18.0F;
   private static final float f_3452 = 25.0F;
   private static final float f_3453 = 25.0F;
   private static final float f_3454 = 10.0F;
   private static final float f_3455 = 10.0F;

   private Util28(List<Util28.nlM2fh0AzQtK9c6l> var1, float var2, float var3) {
      this.f_3445 = var1;
      this.f_3446 = var2;
      this.f_3447 = var3;
   }

   public float m_1038(boolean var1) {
      return var1 ? this.f_3447 : this.f_3446;
   }

   public List<Util28.nlM2fh0AzQtK9c6l> m_353() {
      return this.f_3445;
   }

   private static float m_945(ObjectArrayList<Setting> var0) {
      float var1 = 0.0F;
      ObjectListIterator var2 = var0.iterator();

      while (var2.hasNext()) {
         Setting var3 = (Setting)var2.next();
         if (var3.m_1326()) {
            if (var3 instanceof ModeSetting var4 && var4.m_2480()) {
               var1 += var4.m_3551().size() * f_3454;
            } else if (var3 instanceof Util63 var5 && var5.m_1931()) {
               var1 += var5.m_841().size() * f_3455;
            }
         }
      }

      return var1;
   }

   private static boolean m_1251(Setting var0) {
      return var0.m_1326()
         && (
            var0 instanceof BooleanSetting
               || var0 instanceof NumberSetting
               || var0 instanceof ModeSetting
               || var0 instanceof Util63
               || var0 instanceof RenderUtil22
         );
   }

   public static Util28 m_468(List<Module> var0) {
      if (var0 != null && !var0.isEmpty()) {
         ArrayList var1 = new ArrayList(var0.size());
         boolean var2 = false;
         float var3 = 0.0F;
         float var4 = 0.0F;
         float var5 = 0.0F;
         float var6 = 0.0F;

         for (Module var8 : var0) {
            ObjectArrayList var9 = var8.m_179();
            float var10 = m_3478(var9);
            float var11 = var10 + m_945(var9);
            float var13 = var2 ? var4 : var3;
            Util28.nlM2fh0AzQtK9c6l var14 = new Util28.nlM2fh0AzQtK9c6l(var8, var9, var10, var11, var2, var13);
            var1.add(var14);
            if (var2) {
               var4 += var10 + f_3448;
               var6 += var11 + f_3449;
            } else {
               var3 += var10 + f_3450;
               var5 += var11 + f_3451;
            }

            var2 = !var2;
         }

         return new Util28(Collections.unmodifiableList(var1), Math.max(var3, var4), Math.max(var5, var6));
      } else {
         return new Util28(Collections.emptyList(), 0.0F, 0.0F);
      }
   }

   private static float m_3478(ObjectArrayList<Setting> var0) {
      float var1 = f_3452;
      ObjectListIterator var2 = var0.iterator();

      while (var2.hasNext()) {
         Setting var3 = (Setting)var2.next();
         if (m_1251(var3)) {
            var1 += f_3453;
         }
      }

      return var1;
   }

   public static final class nlM2fh0AzQtK9c6l {
      private final Module f_10314;
      private final ObjectArrayList<Setting> f_10315;
      private final float f_10316;
      private final float f_10317;
      private final boolean f_10318;
      private final float f_10319;

      public boolean m_2785() {
         return this.f_10318;
      }

      public float m_3993() {
         return this.f_10317;
      }

      private nlM2fh0AzQtK9c6l(Module var1, ObjectArrayList<Setting> var2, float var3, float var4, boolean var5, float var6) {
         this.f_10314 = var1;
         this.f_10315 = var2;
         this.f_10316 = var3;
         this.f_10317 = var4;
         this.f_10318 = var5;
         this.f_10319 = var6;
      }

      public float m_2243() {
         return this.f_10316;
      }

      public ObjectArrayList<Setting> m_1278() {
         return this.f_10315;
      }

      public float m_3562(boolean var1) {
         return var1 ? this.f_10317 : this.f_10316;
      }

      public float m_1660() {
         return this.f_10319;
      }

      public Module m_636() {
         return this.f_10314;
      }
   }
}
