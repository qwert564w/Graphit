package su.energyclient.util;

import su.energyclient.render.RenderUtil26;

public class Util93 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final String f_5997 = "/assets/energy/fonts/";
   public static volatile RenderUtil26[] f_5998 = new RenderUtil26[33];
   public static volatile RenderUtil26[] f_5999 = new RenderUtil26[55];
   public static volatile RenderUtil26[] f_6000 = new RenderUtil26[55];
   public static volatile RenderUtil26[] f_6001 = new RenderUtil26[55];
   public static volatile RenderUtil26[] f_6002 = new RenderUtil26[55];
   public static volatile RenderUtil26[] f_6003 = new RenderUtil26[55];
   public static volatile RenderUtil26[] l = new RenderUtil26[55];
   public static volatile RenderUtil26[] f_6004 = new RenderUtil26[55];
   private static final String f_6005 = "sf_bold.ttf";
   private static final float f_6006 = -1.0F;
   private static final String f_6007 = "icons.ttf";
   private static final float f_6008 = -1.0F;
   private static final String f_6009 = "energy.ttf";
   private static final float f_6010 = -1.0F;
   private static final String f_6011 = "SuisseIntl-Medium.otf";
   private static final float f_6012 = -1.0F;
   private static final String f_6013 = "SuisseIntl-Regular.otf";
   private static final float f_6014 = -1.0F;
   private static final String f_6015 = "SuisseIntl-SemiBold.otf";
   private static final float f_6016 = -1.0F;
   private static final String f_6017 = "custom-icons.ttf";
   private static final float f_6018 = -1.0F;

   private static void m_1721(RenderUtil26[] var0, String var1, float var2, int... var3) {
      for (int var7 : var3) {
         var0[var7] = new RenderUtil26(var1, var7, var2, true);
      }
   }

   public static void m_3239() {
      m_1721(f_5998, f_6005, f_6006, 12, 14, 17, 18, 19, 20, 25);
      m_1721(f_5999, f_6007, f_6008, 17);
      m_1721(f_6000, f_6009, f_6010, 13, 14, 15, 16, 18, 25);
      m_1721(f_6001, f_6011, f_6012, 11, 12, 13, 14, 15, 16, 17);
      m_1721(f_6002, f_6013, f_6014, 10, 11, 13, 15, 32);
      m_1721(f_6003, f_6015, f_6016, 12, 13, 14, 15, 16, 50);
      m_1721(l, f_6017, f_6018, 21);
   }
}
