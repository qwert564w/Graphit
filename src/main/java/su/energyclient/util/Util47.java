package su.energyclient.util;

import java.util.Locale;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import su.energyclient.EnergyClient;
import su.energyclient.render.RenderUtil25;

public class Util47 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final long f_8099 = 2100L;
   private static final float f_8100 = 0.0F;
   private static final float f_8101 = 0.0F;
   private static final float f_8102 = 0.0F;
   private static final float f_8103 = 0.0F;
   private static final float f_8104 = 0.0F;
   private static final float f_8105 = 0.0F;
   private static final float f_8106 = 0.0F;
   private final Text f_8107;
   private final String f_8108;
   private final Identifier f_8109;
   private final ItemStack f_8110;
   private final Integer f_8111;
   private final Util125 f_8112 = new Util125();
   private final Util165 f_8113;
   private final Util165 f_8114;
   private boolean f_8115;
   private boolean f_8116;
   private static final long f_8117 = 220L;
   private static final long f_8118 = 150L;
   private static final long f_8119 = 220L;
   private static final long f_8120 = 150L;
   private static final long f_8121 = 220L;
   private static final long f_8122 = 150L;
   private static final long f_8123 = 2100L;
   private static final float f_8124 = 4.0F;
   private static final float f_8125 = 0.01F;
   private static final float f_8126 = 6.0F;
   private static final float f_8127 = 5.0F;
   private static final float f_8128 = 4.0F;
   private static final float f_8129 = 5.0F;
   private static final float f_8130 = 10.0F;
   private static final float f_8131 = 5.0F;
   private static final float f_8132 = 18.0F;
   private static final float f_8133 = 10.0F;
   private static final float f_8134 = 150.0F;
   private static final float f_8135 = 0.55F;
   private static final float f_8136 = 105.0F;
   private static final float f_8137 = 1.1F;
   private static final float f_8138 = 0.5F;
   private static final float f_8139 = 0.65F;
   private static final float f_8140 = 1.6F;
   private static final float f_8141 = 1.6F;
   private static final float f_8142 = 6.8F;
   private static final float f_8143 = 6.8F;
   private static final float f_8144 = 5.0F;
   private static final float f_8145 = 0.5F;
   private static final float f_8146 = 4.1F;
   private static final float f_8147 = 5.0F;
   private static final float f_8148 = 0.5F;
   private static final float f_8149 = 4.0F;
   private static final float f_8150 = 7.5F;
   private static final String f_8151 = "i";
   private static final String f_8152 = "enable";
   private static final String f_8153 = "on";
   private static final String f_8154 = "+";
   private static final String f_8155 = "i";
   private static final String f_8156 = "disable";
   private static final String f_8157 = "off";
   private static final String f_8158 = "-";
   private static final String f_8159 = "b";
   private static final String f_8160 = "warn";
   private static final String f_8161 = "alert";
   private static final String f_8162 = "!";
   private static final String f_8163 = "info";
   private static final String f_8164 = "!";
   private static final String f_8165 = "i";
   private static final String f_8166 = "b";
   private static final String f_8167 = "i";
   private static final String f_8168 = "b";
   private static final String f_8169 = "!";
   private static final int f_8170 = 9306039;
   private static final int f_8171 = 16751258;
   private static final int f_8172 = 16765050;
   private static final int f_8173 = 16777215;
   private static final long f_8174 = 2100L;
   private static final double f_8175 = 0.01F;
   private static final float f_8176 = 205.0F;
   private static final float f_8177 = 20.0F;
   private static final float f_8178 = 5.0F;
   private static final float f_8179 = 72.0F;
   private static final float f_8180 = 230.0F;
   private static final float f_8181 = 18.0F;
   private static final float f_8182 = 24.0F;
   private static final float f_8183 = 10.0F;
   private static final float f_8184 = 10.0F;
   private static final float f_8185 = 5.0F;

   private float m_3826(float var1) {
      return Math.max(0.0F, Math.min(1.0F, var1));
   }

   private int m_539(String var1, int var2) {
      return switch (var1) {
         case f_8167 -> f_8170;
         case f_8168 -> f_8171;
         case f_8169 -> f_8172;
         default -> f_8173;
      };
   }

   public boolean m_4078() {
      return this.f_8115;
   }

   private float m_3817(float var1) {
      return Math.max(f_8182, var1 - f_8183 - f_8184 - f_8185);
   }

   public Util47(ItemStack var1, Text var2) {
      this.f_8113 = new Util165(Util153.EASE_OUT_CUBIC, f_8121);
      this.f_8114 = new Util165(Util153.LINEAR, f_8122);
      this.f_8115 = false;
      this.f_8116 = false;
      this.f_8108 = null;
      this.f_8107 = var2;
      this.f_8109 = null;
      this.f_8110 = var1;
      this.f_8111 = null;
   }

   public Util47(String var1, String var2, int var3) {
      this.f_8113 = new Util165(Util153.EASE_OUT_CUBIC, f_8117);
      this.f_8114 = new Util165(Util153.LINEAR, f_8118);
      this.f_8115 = false;
      this.f_8116 = false;
      this.f_8108 = var1;
      this.f_8107 = Text.literal(var2);
      this.f_8109 = null;
      this.f_8110 = null;
      this.f_8111 = var3;
   }

   private int m_1135() {
      return this.f_8111 != null && this.f_8111 != -1 ? Util71.m_3389(this.f_8111, 255) : EnergyClient.getTheme(0);
   }

   private void m_1532(float var1, float var2, float var3, float var4, DrawContext var5) {
      float var6 = this.m_3817(var3);
      Util93.f_6001[15].m_417(var5, this.f_8107, var1, var2 + f_8150, Util71.m_1907(-1, var4), var6);
   }

   public boolean m_3899() {
      return (this.f_8115 || this.f_8112.m_2636(f_8174)) && this.f_8114.m_2276() <= f_8175;
   }

   public Util165 m_3944() {
      return this.f_8113;
   }

   public float m_3281() {
      return f_8181;
   }

   private void m_3451(float var1, float var2, float var3, float var4) {
      Util158.m_3998(var1, var2, var3, f_8132, f_8133, Util71.m_756(20, 20, 25, Math.round(f_8134 * var4)), var4);
   }

   public void m_3220(float var1, float var2, DrawContext var3) {
      if (!this.f_8116) {
         this.f_8113.m_2214(var2);
         this.f_8116 = true;
      }

      boolean var4 = this.f_8115 || this.f_8112.m_2636(f_8123);
      this.f_8114.m_3631(var4 ? 0.0 : 1.0);
      this.f_8113.m_3631(this.f_8115 && var4 ? var2 - f_8124 : var2);
      float var5 = (float)this.f_8113.m_2276();
      float var6 = this.m_3826((float)this.f_8114.m_2276());
      if (!(var6 <= f_8125)) {
         float var7 = this.m_1189();
         int var8 = this.m_1135();
         float var9 = var1 + (1.0F - var6) * f_8126;
         this.m_3451(var9, var5, var7, var6);
         this.m_3399(var9 + f_8127, var5 + f_8128, var6, var8, var3);
         this.m_1532(var9 + f_8129 + f_8130 + f_8131, var5, var7, var6, var3);
      }
   }

   public Util165 m_1256() {
      return this.f_8114;
   }

   public Util125 m_3296() {
      return this.f_8112;
   }

   public String m_2719() {
      return this.f_8108;
   }

   private String m_2269() {
      if (this.f_8108 != null && !this.f_8108.isEmpty()) {
         String var1 = this.f_8108.toLowerCase(Locale.ROOT);
         if (var1.contains(f_8152) || var1.contains(f_8153) || var1.contains(f_8154)) {
            return f_8155;
         } else if (var1.contains(f_8156) || var1.contains(f_8157) || var1.contains(f_8158)) {
            return f_8159;
         } else if (!var1.contains(f_8160) && !var1.contains(f_8161) && !var1.contains(f_8162) && !var1.contains(f_8163)) {
            return this.f_8108.length() == 1 ? this.f_8108 : this.f_8108.substring(0, 1).toUpperCase(Locale.ROOT);
         } else {
            return f_8164;
         }
      } else {
         return f_8151;
      }
   }

   public boolean m_1752() {
      return this.f_8116;
   }

   public float m_1189() {
      float var1 = this.f_8107 == null ? 0.0F : Util93.f_6001[15].m_3324(this.f_8107);
      float var2 = Math.min(var1, f_8176);
      float var3 = f_8177 + var2 + f_8178;
      return Math.max(f_8179, Math.min(f_8180, var3));
   }

   public Identifier m_730() {
      return this.f_8109;
   }

   public Text m_2623() {
      return this.f_8107;
   }

   public Integer m_1083() {
      return this.f_8111;
   }

   private boolean m_1612(String var1) {
      return f_8165.equals(var1) || f_8166.equals(var1);
   }

   private void m_3399(float var1, float var2, float var3, int var4, DrawContext var5) {
      int var6 = Util71.m_3389(Util71.m_2101(EnergyClient.getThemeColor(), f_8135), Math.round(f_8136 * var3));
      if (this.f_8110 != null) {
         Util158.m_1974(var5, this.f_8110, var1 + f_8137, var2 - f_8138, f_8139, -1, var3);
      } else if (this.f_8109 != null) {
         RenderUtil25.m_3570(var5, this.f_8109, var1 + f_8140, var2 + f_8141, f_8142, f_8143, Util71.m_1907(-1, var3));
      } else {
         String var7 = this.m_2269();
         int var8 = Util71.m_1907(EnergyClient.getThemeColor(), var3);
         if (this.m_1612(var7)) {
            Util93.f_6000[16].m_765(var5, var7, var1 + f_8144 + f_8145, var2 + f_8146, var8);
         } else {
            Util93.f_6003[16].m_765(var5, var7, var1 + f_8147 + f_8148, var2 + f_8149, var8);
         }
      }
   }

   public ItemStack m_2909() {
      return this.f_8110;
   }

   public void m_3577() {
      this.f_8115 = true;
   }

   public Util47(Identifier var1, Text var2, Integer var3) {
      this.f_8113 = new Util165(Util153.EASE_OUT_CUBIC, f_8119);
      this.f_8114 = new Util165(Util153.LINEAR, f_8120);
      this.f_8115 = false;
      this.f_8116 = false;
      this.f_8108 = null;
      this.f_8107 = var2;
      this.f_8109 = var1;
      this.f_8110 = null;
      this.f_8111 = var3;
   }
}
