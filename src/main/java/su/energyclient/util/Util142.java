package su.energyclient.util;

import net.minecraft.client.gl.Framebuffer;
import su.energyclient.QuickImports;
import su.energyclient.render.RenderUtil24;
import su.energyclient.render.RenderUtil6;
import su.energyclient.util.math.MathUtil6;

public class Util142 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_12026 = 0.5F;
   public static Util142 f_12027 = new Util142();
   public final RenderUtil24 f_12028;
   public final RenderUtil24 f_12029;
   private float f_12030 = 2.0F;
   private int f_12031 = 4;
   private boolean f_12032;
   private boolean f_12033;
   private int f_12034 = -1;
   private int f_12035 = -1;
   private static final float f_12036 = 0.5F;
   private static final float f_12037 = 0.5F;
   private static final String f_12038 = "offset";
   private static final String f_12039 = "offset";
   private static final String f_12040 = "resolution";
   private static final float f_12041 = 3.0F;
   private static final float f_12042 = 3.0F;

   public void m_2732(float var1, int var2) {
      this.f_12030 = var1;
      this.f_12031 = var2;
      this.f_12032 = true;
      this.f_12033 = this.m_3725(var1, var2);
   }

   public boolean m_2282() {
      this.f_12032 = true;
      if (this.f_12033 && this.m_2155()) {
         return true;
      } else {
         this.f_12033 = this.m_3725(this.f_12030, this.f_12031);
         return this.f_12033;
      }
   }

   public void m_1746(float var1, int var2) {
      this.f_12030 = var1;
      this.f_12031 = var2;
      this.f_12032 = false;
      this.f_12033 = false;
   }

   private static void m_262(Util98 var0, Framebuffer var1) {
      MathUtil6 var2 = var0.m_1335(f_12040);
      if (var2 != null) {
         var2.m_54(f_12041 / Math.max(1, var1.textureWidth), f_12042 / Math.max(1, var1.textureHeight));
      }
   }

   private boolean m_2155() {
      return QuickImports.f_5909 != null
         && QuickImports.f_5909.getFramebuffer() != null
         && this.f_12034 == QuickImports.f_5909.getFramebuffer().textureWidth
         && this.f_12035 == QuickImports.f_5909.getFramebuffer().textureHeight;
   }

   private boolean m_3725(float var1, int var2) {
      if (var2 > 0 && QuickImports.f_5909 != null && QuickImports.f_5909.getFramebuffer() != null) {
         Framebuffer var3 = QuickImports.f_5909.getFramebuffer();

         int var17;
         try {
            Util114.m_3784(Util24.l);
            Util98 var4 = Util114.m_4018();
            if (var4 == null) {
               return false;
            }

            this.f_12029.setup();
            Util114.m_2037(0, var3.getColorAttachment());
            MathUtil6 var5 = var4.m_1335(f_12038);
            if (var5 != null) {
               var5.O(var1);
            }

            m_262(var4, var3);
            RenderUtil24.drawQuads();
            RenderUtil24[] var6 = new RenderUtil24[]{this.f_12029, this.f_12028};

            for (int var7 = 1; var7 < var2; var7++) {
               var17 = var7 % 2;
               var6[var17].setup();
               m_262(var4, var6[(var17 + 1) % 2]);
               var6[(var17 + 1) % 2].draw();
            }

            Util114.m_3784(Util24.f_3260);
            Util98 var16 = Util114.m_4018();
            if (var16 != null) {
               var5 = var16.m_1335(f_12039);
               if (var5 != null) {
                  var5.O(var1);
               }

               var17 = var2 - 1 & 1;

               for (int var9 = 0; var9 < var2; var9++) {
                  int var10 = 1 - var17;
                  var6[var10].setup();
                  m_262(var16, var6[var17]);
                  var6[var17].draw();
                  var17 = var10;
               }

               this.f_12034 = var3.textureWidth;
               this.f_12035 = var3.textureHeight;
               return true;
            }

            var17 = 0;
         } finally {
            RenderUtil6.m_4071(var3, true);
         }

         return var17 != 0;
      } else {
         return false;
      }
   }

   public Util142() {
      this.f_12028 = new RenderUtil24(false, f_12036).setLinear();
      this.f_12029 = new RenderUtil24(false, f_12037).setLinear();
   }
}
