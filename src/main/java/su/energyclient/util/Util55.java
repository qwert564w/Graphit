package su.energyclient.util;

import java.util.Locale;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import su.energyclient.QuickImports;

public class Util55 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final float f_8673 = 150.0F;
   public static final float f_8674 = 0.0F;
   private static final float f_8675 = 0.0F;
   private static final float f_8676 = 0.0F;
   private static final float f_8677 = 0.0F;
   private static final float f_8678 = 0.0F;
   private static final float f_8679 = 0.0F;
   private static final float f_8680 = 0.0F;
   private final Util147.qkA6Y4JkO2xPSL6l f_8681;
   private boolean f_8682 = false;
   private String f_8683 = "";
   private final Util165 f_8684;
   private static final long f_8685 = 120L;
   private static final String f_8686 = " ";
   private static final String f_8687 = ",";
   private static final float f_8688 = 4.0F;
   private static final float f_8689 = 15.0F;
   private static final float f_8690 = 58.0F;
   private static final float f_8691 = 4.0F;
   private static final float f_8692 = 150.0F;
   private static final float f_8693 = 58.0F;
   private static final int f_8694 = 2775612;
   private static final int f_8695 = 2764339;
   private static final int f_8696 = 2112811;
   private static final int f_8697 = 1777186;
   private static final int f_8698 = 1186581;
   private static final int f_8699 = 1119255;
   private static final int f_8700 = 2764596;
   private static final int f_8701 = 1777444;
   private static final float f_8702 = 150.0F;
   private static final float f_8703 = 58.0F;
   private static final float f_8704 = 4.0F;
   private static final float f_8705 = 255.0F;
   private static final float f_8706 = 0.8F;
   private static final float f_8707 = 0.8F;
   private static final float f_8708 = 148.4F;
   private static final float f_8709 = 56.4F;
   private static final float f_8710 = 3.5F;
   private static final float f_8711 = 0.8F;
   private static final float f_8712 = 0.12F;
   private static final float f_8713 = 8.0F;
   private static final float f_8714 = 13.0F;
   private static final float f_8715 = 4.0F;
   private static final float f_8716 = 15.0F;
   private static final float f_8717 = 58.0F;
   private static final float f_8718 = 48.0F;
   private static final int f_8719 = 16777215;
   private static final float f_8720 = 0.68F;
   private static final float f_8721 = 94.0F;
   private static final float f_8722 = 4.0F;
   private static final float f_8723 = 94.0F;
   private static final float f_8724 = 15.0F;
   private static final float f_8725 = 3.0F;
   private static final float f_8726 = 0.6F;
   private static final float f_8727 = 0.6F;
   private static final float f_8728 = 92.8F;
   private static final float f_8729 = 13.8F;
   private static final float f_8730 = 2.5F;
   private static final int f_8731 = 921876;
   private static final float f_8732 = 0.55F;
   private static final String f_8733 = "0";
   private static final float f_8734 = 5.0F;
   private static final float f_8735 = 15.0F;
   private static final int f_8736 = 14146014;
   private static final float f_8737 = 86.0F;
   private static final float f_8738 = 150.0F;
   private static final float f_8739 = 58.0F;
   private static final float f_8740 = 48.0F;
   private static final float f_8741 = 94.0F;
   private static final float f_8742 = 15.0F;
   private static final String f_8743 = "[^0-9]";
   private static final String f_8744 = "---";
   private static final String f_8745 = "%,d";

   public void m_387(DrawContext var1, float var2, float var3, int var4, int var5, int var6) {
      boolean var7 = Util39.m_2594(var5, var6, var2, var3, f_8692, f_8693);
      this.f_8684.m_3631(var7 ? 1.0 : 0.0);
      float var8 = (float)this.f_8684.m_2276();
      int var9 = this.f_8681.f_1760 ? f_8694 : f_8695;
      int var10 = this.f_8681.f_1760 ? f_8696 : f_8697;
      int var11 = this.f_8681.f_1760 ? f_8698 : f_8699;
      int var12 = this.f_8682 ? f_8700 : f_8701;
      Util158.m_3404(var2, var3, f_8702, f_8703, f_8704, var9, var10, var9, var10, var4 / f_8705);
      Util158.m_1849(var2 + f_8706, var3 + f_8707, f_8708, f_8709, f_8710, Util71.m_3389(var11, Math.min(255, (int)(var4 * (f_8711 + var8 * f_8712)))));
      ItemStack var13 = new ItemStack(this.f_8681.f_1758);
      Util158.m_1974(var1, var13, var2 + f_8713, var3 + f_8714, 2.0F, -1, 1.0F);
      float var14 = Util93.f_6001[14].m_619();
      float var15 = var14 + f_8715 + f_8716;
      float var16 = var3 + (f_8717 - var15) / 2.0F;
      float var17 = var2 + f_8718;
      Util93.f_6001[14].m_1904(var1, this.f_8681.f_1757, var17, var16, Util71.m_3389(f_8719, (int)(var4 * f_8720)), f_8721);
      float var18 = var16 + var14 + f_8722;
      Util158.m_1849(var17, var18, f_8723, f_8724, f_8725, Util71.m_3389(var12, var4));
      Util158.m_1849(var17 + f_8726, var18 + f_8727, f_8728, f_8729, f_8730, Util71.m_3389(f_8731, (int)(var4 * f_8732)));
      String var19 = this.f_8682 ? this.f_8683 : m_2841(this.f_8681.f_1761);
      if (var19.isBlank()) {
         var19 = f_8733;
      }

      float var20 = Util93.f_6001[13].m_619();
      Util93.f_6001[13].m_1904(var1, var19, var17 + f_8734, var18 + (f_8735 - var20) / 2.0F + 1.0F, Util71.m_3389(f_8736, var4), f_8737);
   }

   static String m_2841(long var0) {
      return var0 < 0L ? f_8744 : String.format(Locale.US, f_8745, var0);
   }

   public Util147.qkA6Y4JkO2xPSL6l m_348() {
      return this.f_8681;
   }

   public Util55(Util147.qkA6Y4JkO2xPSL6l var1) {
      this.f_8684 = new Util165(Util153.EASE_IN_OUT_CUBIC, f_8685);
      this.f_8681 = var1;
   }

   public void m_2237() {
      if (this.f_8682) {
         try {
            String var1 = this.f_8683.replace(f_8686, "").replace(f_8687, "");
            if (!var1.isBlank()) {
               long var2 = Long.parseLong(var1);
               this.f_8681.f_1761 = Math.max(0L, var2);
            }
         } catch (NumberFormatException var4) {
         }

         this.f_8682 = false;
         this.f_8683 = "";
      }
   }

   public boolean m_802(char var1, int var2) {
      if (!this.f_8682) {
         return false;
      } else if (Character.isDigit(var1)) {
         this.f_8683 = this.f_8683 + var1;
         return true;
      } else {
         return false;
      }
   }

   public boolean m_1157(int var1, int var2, int var3) {
      if (!this.f_8682) {
         return false;
      } else if (var1 == 257) {
         this.m_2237();
         return true;
      } else if (var1 == 259) {
         if (!this.f_8683.isEmpty()) {
            this.f_8683 = this.f_8683.substring(0, this.f_8683.length() - 1);
         }

         return true;
      } else if (f_5909.isCtrlPressed() && var1 == 86) {
         String var4 = f_5909.keyboard.getClipboard();
         if (var4 != null) {
            String var5 = var4.replaceAll(f_8743, "");
            if (!var5.isBlank()) {
               this.f_8683 = this.f_8683 + var5;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public void m_4148() {
      this.f_8682 = false;
      this.f_8683 = "";
   }

   private float m_243(float var1) {
      float var2 = Util93.f_6001[14].m_619();
      float var3 = var2 + f_8688 + f_8689;
      float var4 = var1 + (f_8690 - var3) / 2.0F;
      return var4 + var2 + f_8691;
   }

   public boolean m_860() {
      return this.f_8682;
   }

   public boolean m_3952(double var1, double var3, float var5, float var6) {
      if (!Util39.m_2594((float)var1, (float)var3, var5, var6, f_8738, f_8739)) {
         return false;
      } else {
         float var7 = var5 + f_8740;
         float var8 = this.m_243(var6);
         if (Util39.m_2594((float)var1, (float)var3, var7, var8, f_8741, f_8742)) {
            this.m_2237();
            this.f_8682 = true;
            this.f_8683 = String.valueOf(this.f_8681.f_1761);
            return true;
         } else {
            this.m_2237();
            this.f_8681.f_1760 = !this.f_8681.f_1760;
            return true;
         }
      }
   }
}
