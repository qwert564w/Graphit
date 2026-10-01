package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.module.combat.AimBot;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util153;
import su.energyclient.util.Util165;
import su.energyclient.util.Util170;
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;

public class TargetEsp extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Identifier f_11141 = Identifier.of(TargetEsp.f_11327, TargetEsp.f_11328);
   private static final int f_11142 = 4;
   private static final int f_11143 = 0;
   private static final double f_11144 = Math.toRadians(TargetEsp.f_11329);
   private static final float f_11145 = 0.0F;
   private static final float f_11146 = 0.0F;
   private final ModeSetting f_11147;
   private final BooleanSetting f_11148;
   private LivingEntity f_11149;
   private LivingEntity f_11150;
   private ClientWorld f_11151;
   private final Util165 f_11152;
   private final Util165 f_11153;
   private float f_11154;
   private long f_11155;
   private final Util165 f_11156;
   private final Util165 f_11157;
   private final Util165 f_11158;
   private final Util165 f_11159;
   private final Util165 f_11160;
   private final Util165 f_11161;
   private long f_11162;
   private float f_11163;
   private boolean f_11164;
   private float f_11165;
   private float f_11166;
   private float f_11167;
   private boolean f_11168;
   private static final String f_11169 = "Target ESP";
   private static final String f_11170 = "description";
   private static final String f_11171 = "Мод";
   private static final String f_11172 = "Ромб";
   private static final String f_11173 = "Ромб";
   private static final String f_11174 = "Кружок";
   private static final String f_11175 = "Crystal";
   private static final String f_11176 = "Призраки";
   private static final String f_11177 = "Призраки 2";
   private static final String f_11178 = "Краснеть при ударе";
   private static final long f_11179 = 200L;
   private static final long f_11180 = 300L;
   private static final long f_11181 = 300L;
   private static final long f_11182 = 200L;
   private static final long f_11183 = 300L;
   private static final long f_11184 = 300L;
   private static final long f_11185 = 670L;
   private static final long f_11186 = 350L;
   private static final float f_11187 = -0.5F;
   private static final String f_11188 = "Old Circle";
   private static final String f_11189 = "Кружок";
   private static final String f_11190 = "Ромб";
   private static final String f_11191 = "Призраки 2";
   private static final String f_11192 = "Ромб";
   private static final String f_11193 = "Кружок";
   private static final String f_11194 = "Crystal";
   private static final String f_11195 = "Призраки";
   private static final String f_11196 = "Призраки 2";
   private static final float f_11197 = 0.001F;
   private static final double f_11198 = 1000.0;
   private static final double f_11199 = 3.0;
   private static final double f_11200 = Math.PI * 2;
   private static final double f_11201 = 14.0;
   private static final float f_11202 = 0.2F;
   private static final float f_11203 = 255.0F;
   private static final float f_11204 = (float) (Math.PI / 10);
   private static final double f_11205 = 15.0;
   private static final double f_11206 = Math.PI / 2;
   private static final double f_11207 = 0.7;
   private static final float f_11208 = 0.4F;
   private static final float f_11209 = 0.4F;
   private static final float f_11210 = 14.0F;
   private static final int f_11211 = -760475;
   private static final float f_11212 = -0.5F;
   private static final float f_11213 = -0.5F;
   private static final float f_11214 = 0.5F;
   private static final float f_11215 = -0.5F;
   private static final float f_11216 = 0.5F;
   private static final float f_11217 = 0.5F;
   private static final float f_11218 = -0.5F;
   private static final float f_11219 = 0.5F;
   private static final float f_11220 = 0.016666668F;
   private static final float f_11221 = 1.0E-9F;
   private static final float f_11222 = 0.05F;
   private static final float f_11223 = 1.5F;
   private static final float f_11224 = 1.2F;
   private static final float f_11225 = 0.5F;
   private static final float f_11226 = 0.3F;
   private static final float f_11227 = 90.0F;
   private static final float f_11228 = 38.0F;
   private static final float f_11229 = 105.0F;
   private static final float f_11230 = 0.28F;
   private static final float f_11231 = 0.5F;
   private static final float f_11232 = 0.5F;
   private static final float f_11233 = 1.0E-4F;
   private static final float f_11234 = 0.07F;
   private static final float f_11235 = 0.1F;
   private static final float f_11236 = 0.5F;
   private static final float f_11237 = 255.0F;
   private static final float f_11238 = 235.0F;
   private static final float f_11239 = 0.48F;
   private static final float f_11240 = 205.0F;
   private static final float f_11241 = 1.39F;
   private static final float f_11242 = 0.89F;
   private static final float f_11243 = 0.89F;
   private static final float f_11244 = 1.39F;
   private static final float f_11245 = 0.89F;
   private static final float f_11246 = -0.89F;
   private static final float f_11247 = 1.39F;
   private static final float f_11248 = -0.89F;
   private static final float f_11249 = -0.89F;
   private static final float f_11250 = 1.39F;
   private static final float f_11251 = -0.89F;
   private static final float f_11252 = 0.89F;
   private static final float f_11253 = -1.39F;
   private static final float f_11254 = 0.89F;
   private static final float f_11255 = 0.89F;
   private static final float f_11256 = -1.39F;
   private static final float f_11257 = -0.89F;
   private static final float f_11258 = 0.89F;
   private static final float f_11259 = -1.39F;
   private static final float f_11260 = -0.89F;
   private static final float f_11261 = -0.89F;
   private static final float f_11262 = -1.39F;
   private static final float f_11263 = 0.89F;
   private static final float f_11264 = -0.89F;
   private static final float f_11265 = 0.99F;
   private static final float f_11266 = 0.01F;
   private static final float f_11267 = 0.9F;
   private static final float f_11268 = 0.5F;
   private static final float f_11269 = 0.1F;
   private static final float f_11270 = -0.5F;
   private static final float f_11271 = 0.1F;
   private static final float f_11272 = 1.1F;
   private static final float f_11273 = 72.5F;
   private static final float f_11274 = 2.55F;
   private static final float f_11275 = 0.7F;
   private static final float f_11276 = 0.2F;
   private static final float f_11277 = 0.1F;
   private static final float f_11278 = 0.7F;
   private static final float f_11279 = 0.2F;
   private static final float f_11280 = 0.1F;
   private static final float f_11281 = 5.0F;
   private static final float f_11282 = 0.22F;
   private static final float f_11283 = 0.01F;
   private static final float f_11284 = (float) (Math.PI / 10);
   private static final float f_11285 = 0.5F;
   private static final float f_11286 = 255.0F;
   private static final float f_11287 = 1000.0F;
   private static final float f_11288 = 10.0F;
   private static final double f_11289 = Math.PI / 10;
   private static final float f_11290 = 0.1F;
   private static final float f_11291 = 0.8F;
   private static final float f_11292 = 0.5F;
   private static final double f_11293 = 2.0;
   private static final float f_11294 = 0.3F;
   private static final float f_11295 = 0.2F;
   private static final float f_11296 = 0.2F;
   private static final float f_11297 = 0.005F;
   private static final float f_11298 = 2000.0F;
   private static final double f_11299 = 255.0;
   private static final double f_11300 = 255.0;
   private static final double f_11301 = Math.PI / 10;
   private static final double f_11302 = Math.PI / 10;
   private static final float f_11303 = 0.13F;
   private static final float f_11304 = 0.03F;
   private static final String f_11305 = "energy";
   private static final String f_11306 = "images/esp/target.png";
   private static final float f_11307 = 255.0F;
   private static final float f_11308 = 255.0F;
   private static final float f_11309 = 255.0F;
   private static final float f_11310 = 255.0F;
   private static final float f_11311 = 4.5F;
   private static final float f_11312 = 4.5F;
   private static final float f_11313 = 4.5F;
   private static final float f_11314 = -4.5F;
   private static final float f_11315 = -4.5F;
   private static final float f_11316 = -4.5F;
   private static final float f_11317 = -4.5F;
   private static final float f_11318 = 4.5F;
   private static final float f_11319 = 0.01F;
   private static final double f_11320 = 2.3;
   private static final float f_11321 = 2.3F;
   private static final float f_11322 = 0.01F;
   private static final double f_11323 = -2.3;
   private static final float f_11324 = -2.3F;
   private static final float f_11325 = 360.0F;
   private static final float f_11326 = 360.0F;
   private static final String f_11327 = "energy";
   private static final String f_11328 = "images/esp/glow.png";
   private static final double f_11329 = 60.0;

   private void m_1182(BufferBuilder var1, Matrix4f var2, int var3, float var4, int var5) {
      int var6 = Util71.m_120(Util71.m_3793(var3, 105), (int)(f_11237 * var4));
      int var7 = Util71.m_120(var3, (int)(f_11238 * var4));
      int var8 = Util71.m_120(Util71.m_2101(var3, f_11239), (int)(f_11240 * var4));
      int var9 = var5 / 12 % 2 == 0 ? var6 : var7;
      int var10 = var5 / 12 % 2 == 0 ? var7 : var6;
      this.m_617(var1, var2, 0.0F, f_11241, 0.0F, f_11242, 0.0F, 0.0F, 0.0F, 0.0F, f_11243, var9);
      this.m_617(var1, var2, 0.0F, f_11244, 0.0F, 0.0F, 0.0F, f_11245, f_11246, 0.0F, 0.0F, var10);
      this.m_617(var1, var2, 0.0F, f_11247, 0.0F, f_11248, 0.0F, 0.0F, 0.0F, 0.0F, f_11249, var7);
      this.m_617(var1, var2, 0.0F, f_11250, 0.0F, 0.0F, 0.0F, f_11251, f_11252, 0.0F, 0.0F, var6);
      this.m_617(var1, var2, 0.0F, f_11253, 0.0F, 0.0F, 0.0F, f_11254, f_11255, 0.0F, 0.0F, var8);
      this.m_617(var1, var2, 0.0F, f_11256, 0.0F, f_11257, 0.0F, 0.0F, 0.0F, 0.0F, f_11258, var7);
      this.m_617(var1, var2, 0.0F, f_11259, 0.0F, 0.0F, 0.0F, f_11260, f_11261, 0.0F, 0.0F, var8);
      this.m_617(var1, var2, 0.0F, f_11262, 0.0F, f_11263, 0.0F, 0.0F, 0.0F, 0.0F, f_11264, var10);
   }

   private void m_3323(Util88 var1) {
      LivingEntity var2 = this.m_713();
      if (this.m_3970(var2)) {
         this.f_11149 = var2;
      }

      this.f_11159.m_3631(this.m_3970(var2) ? 1.0 : 0.0);
      float var3 = MathHelper.clamp((float)this.f_11159.m_2276(), 0.0F, 1.0F);
      if (this.m_107(var3)) {
         long var4 = System.nanoTime();
         float var6 = this.f_11162 == 0L ? f_11220 : Math.min((float)(var4 - this.f_11162) * f_11221, f_11222);
         this.f_11162 = var4;
         this.f_11163 += var6;
         float var7 = var1.m_191();
         Camera var8 = f_5909.gameRenderer.getCamera();
         Vec3d var9 = var8.getCameraPos();
         float var10 = (float)(MathHelper.lerp(var7, this.f_11149.lastX, this.f_11149.getX()) - var9.x);
         float var11 = (float)(MathHelper.lerp(var7, this.f_11149.lastY, this.f_11149.getY()) - var9.y);
         float var12 = (float)(MathHelper.lerp(var7, this.f_11149.lastZ, this.f_11149.getZ()) - var9.z);
         float var13 = this.m_2126(var7);
         float var14 = this.f_11149.getHeight();
         float var15 = this.f_11149.getWidth() * f_11223 * (f_11224 - f_11225 * var3) * (1.0F - f_11226 * var13);
         float var16 = this.f_11163 * f_11227;
         int var17 = this.m_1138(var7);
         Quaternionf var18 = new Quaternionf(var8.getRotation());
         Vector3f var19 = new Vector3f(1.0F, 0.0F, 0.0F).rotate(var18);
         Vector3f var20 = new Vector3f(0.0F, 1.0F, 0.0F).rotate(var18);
         Matrix4f var21 = var1.m_213().peek().getPositionMatrix();
         this.m_1659();
         Util114.m_3784(RenderUtil7.f_13886);
         Util114.m_2037(0, f_11141);
         BufferBuilder var22 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

         for (int var23 = 0; var23 < 360; var23 += 12) {
            float var24 = (float)Math.toRadians(var23 + var16);
            float var25 = MathHelper.sin(var24) * var15;
            float var26 = MathHelper.cos(var24) * var15;
            float var27 = this.m_1675(var23, var14);
            int var28 = Util71.m_120(var17, (int)(f_11228 * var3));
            int var29 = Util71.m_120(Util71.m_3793(var17, 80), (int)(f_11229 * var3));
            this.m_2360(var22, var21, var19, var20, var10 + var25, var11 + var27, var12 + var26, 1.0F, var28);
            this.m_2360(var22, var21, var19, var20, var10 + var25, var11 + var27, var12 + var26, f_11230, var29);
         }

         RenderUtil12.I(var22.end());
         Util114.m_3784(RenderUtil7.f_13885);
         BufferBuilder var32 = Tessellator.getInstance().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);

         for (int var33 = 0; var33 < 360; var33 += 12) {
            float var34 = (float)Math.toRadians(var33 + var16);
            float var35 = MathHelper.sin(var34) * var15;
            float var36 = MathHelper.cos(var34) * var15;
            float var37 = this.m_1675(var33, var14);
            Vector3f var38 = new Vector3f(-var35, (var14 * f_11231 - var37) * f_11232, -var36);
            if (var38.lengthSquared() < f_11233) {
               var38.set(0.0F, 1.0F, 0.0F);
            } else {
               var38.normalize();
            }

            Quaternionf var30 = new Quaternionf().rotationTo(new Vector3f(0.0F, 1.0F, 0.0F), var38);
            Matrix4f var31 = new Matrix4f(var21).translate(var10 + var35, var11 + var37, var12 + var36).rotate(var30).scale(f_11234);
            this.m_1182(var32, var31, var17, var3, var33);
         }

         RenderUtil12.I(var32.end());
         this.m_250();
      }
   }

   private void m_2938(Util88 var1) {
      if (this.f_11151 != f_5909.world) {
         this.m_3634();
         this.f_11151 = f_5909.world;
      }

      LivingEntity var2 = this.m_713();
      boolean var3 = this.m_3970(var2);
      if (var3) {
         this.f_11150 = var2;
      }

      float var4 = var1.m_191();
      this.f_11152.m_3631(var3 ? 1.0 : 0.0);
      float var5 = MathHelper.clamp((float)this.f_11152.m_2276(), 0.0F, 1.0F);
      if (this.f_11150 != null) {
         if (var5 <= f_11197) {
            if (!var3) {
               this.f_11150 = null;
            }
         } else {
            LivingEntity var6 = this.f_11150;
            Camera var7 = f_5909.gameRenderer.getCamera();
            Vec3d var8 = var7.getCameraPos();
            double var9 = MathHelper.lerp(var4, var6.lastX, var6.getX()) - var8.x;
            double var11 = MathHelper.lerp(var4, var6.lastY, var6.getY()) - var8.y;
            double var13 = MathHelper.lerp(var4, var6.lastZ, var6.getZ()) - var8.z;
            double var15 = System.currentTimeMillis() / f_11198;
            double var17 = var15 * f_11199 % f_11200;
            double var19 = f_11144 / f_11201;
            double var21 = var6.getWidth();
            float var23 = var6.getHeight() / 2.0F + f_11202;
            int var24 = (int)(f_11203 * var5);
            float var25 = this.f_11148.m_1163() ? MathHelper.sin(Math.max(0.0F, var6.hurtTime - var4) * f_11204) : 0.0F;
            Quaternionf var26 = new Quaternionf(var7.getRotation());
            Matrix4f var27 = var1.m_213().peek().getPositionMatrix();
            this.m_1659();

            try {
               Util114.m_582(770, 1);
               Util114.m_3784(RenderUtil7.f_13886);
               Util114.m_2037(0, f_11141);
               BufferBuilder var28 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

               for (int var29 = 0; var29 < 4; var29++) {
                  double var30 = var15 + var29 * f_11205;
                  double var32 = var29 * f_11206;

                  for (int var34 = 0; var34 <= 14; var34++) {
                     double var35 = var34 * var19;
                     double var37 = var35 + var17 + var32;
                     float var39 = (float)(var9 + var21 * Math.cos(var37));
                     float var40 = (float)(var11 + var23 + Math.sin(var30 + var35 + var29) * f_11207);
                     float var41 = (float)(var13 + var21 * Math.sin(var37));
                     float var42 = f_11208 * (f_11209 + var34 / f_11210);
                     int var43 = EnergyClient.getTheme(var34 * 14);
                     if (var25 > 0.0F) {
                        var43 = Util71.m_2924(var43, f_11211, var25);
                     }

                     var43 = Util71.m_120(var43, var24);
                     Matrix4f var44 = new Matrix4f(var27).translate(var39, var40, var41).rotate(var26).scale(var42);
                     var28.vertex(var44, f_11212, f_11213, 0.0F).texture(0.0F, 0.0F).color(var43);
                     var28.vertex(var44, f_11214, f_11215, 0.0F).texture(1.0F, 0.0F).color(var43);
                     var28.vertex(var44, f_11216, f_11217, 0.0F).texture(1.0F, 1.0F).color(var43);
                     var28.vertex(var44, f_11218, f_11219, 0.0F).texture(0.0F, 1.0F).color(var43);
                  }
               }

               RenderUtil12.I(var28.end());
            } finally {
               this.m_250();
            }
         }
      }
   }

   @EventHandler
   private void m_2150(Util170 var1) {
      this.f_11155 = System.currentTimeMillis();
   }

   private void m_3485() {
      if (f_11188.equals(this.f_11147.m_3862())) {
         this.f_11147.m_21(f_11189);
      } else if (!this.f_11147.m_3551().contains(this.f_11147.m_3862())) {
         this.f_11147.m_21(f_11190);
      }
   }

   private LivingEntity m_713() {
      AimBot var1 = InitManager.f_2740.f_2741.aimBot;
      if (var1 != null && var1.m_677() && var1.m_3028() != null) {
         return var1.m_3028();
      } else {
         AttackAura var2 = InitManager.f_2740.f_2741.attackAura;
         if (var2 != null && var2.m_677() && var2.m_891() != null) {
            return var2.m_891();
         } else if (f_5909.targetedEntity instanceof LivingEntity var3) {
            return var3;
         } else {
            return null;
         }
      }
   }

   public TargetEsp() {
      super(f_11169, f_11170, Category.RENDER);
      this.f_11147 = new ModeSetting(f_11171, f_11172, f_11173, f_11174, f_11175, f_11176, f_11177);
      this.f_11148 = new BooleanSetting(f_11178, false);
      this.f_11152 = new Util165(Util153.LINEAR, f_11179);
      this.f_11153 = new Util165(Util153.LINEAR, f_11180);
      this.f_11154 = 0.0F;
      this.f_11155 = System.currentTimeMillis();
      this.f_11156 = new Util165(Util153.LINEAR, f_11181);
      this.f_11157 = new Util165(Util153.EASE_OUT_CIRC, f_11182);
      this.f_11158 = new Util165(Util153.EASE_OUT_CUBIC, f_11183);
      this.f_11159 = new Util165(Util153.EASE_OUT_CUBIC, f_11184);
      this.f_11160 = new Util165(Util153.EASE_IN_OUT_SINE, f_11185);
      this.f_11161 = new Util165(Util153.EASE_IN_OUT_SINE, f_11186);
      this.f_11164 = true;
      this.f_11165 = f_11187;
      this.f_11166 = 0.0F;
      this.f_11167 = 0.0F;
      this.f_11168 = false;
   }

   private void m_3634() {
      this.f_11150 = null;
      this.f_11151 = null;
      this.f_11152.m_2214(0.0);
      this.f_11152.m_2946(0.0);
      this.f_11152.m_1829(0.0);
      this.f_11152.m_2903();
   }

   @EventHandler
   private void m_2154(Util88 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
         this.m_3485();
         if (!this.f_11147.m_2073(f_11191)) {
            this.m_3634();
         }

         String var2 = this.f_11147.m_3862();
         switch (var2) {
            case f_11192:
               this.m_2948(var1);
               break;
            case f_11193:
               this.m_3332(var1);
               break;
            case f_11194:
               this.m_3323(var1);
               break;
            case f_11195:
               this.O(var1);
               break;
            case f_11196:
               this.m_2938(var1);
         }
      } else {
         this.f_11149 = null;
         this.m_3634();
      }
   }

   private void m_250() {
      Util114.m_2977(1.0F);
      Util114.m_100();
      Util114.m_1878(true);
      Util114.m_1562();
      Util114.m_542();
      Util114.m_963();
      Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void O(Util88 var1) {
      MatrixStack var2 = var1.m_213();
      LivingEntity var3 = this.m_713();
      if (var3 != null) {
         this.f_11149 = var3;
      }

      this.f_11153.m_3631(var3 != null ? 1.0 : 0.0);
      long var4 = System.currentTimeMillis();
      float var6 = (float)(var4 - this.f_11155) / f_11287;
      this.f_11155 = var4;
      float var7 = f_11288;
      this.f_11154 += var7 * var6;
      if (this.f_11149 != null) {
         Util114.m_3784(RenderUtil7.f_13886);
         Util114.m_2037(0, f_11141);
         Util114.m_1481();
         Util114.m_1206(770, 1, 0, 1);
         Util114.m_3978();
         Util114.m_672();
         Util114.m_1878(false);
         Camera var8 = f_5909.getEntityRenderDispatcher().camera;
         double var9 = MathHelper.lerp(var1.m_191(), this.f_11149.lastX, this.f_11149.getX()) - var8.getCameraPos().x;
         double var11 = MathHelper.lerp(var1.m_191(), this.f_11149.lastY, this.f_11149.getY()) - var8.getCameraPos().y;
         double var13 = MathHelper.lerp(var1.m_191(), this.f_11149.lastZ, this.f_11149.getZ()) - var8.getCameraPos().z;
         byte var15 = 3;
         byte var16 = 12;
         int var17 = 3 * var15;
         float var18 = (float)Math.sin(this.f_11149.hurtTime * f_11289);
         Tessellator var19 = Tessellator.getInstance();
         var2.push();

         for (int var20 = 0; var20 < var17; var20 += var15) {
            for (int var21 = 0; var21 < var16; var21++) {
               int var22;
               if (this.f_11148.m_1163()) {
                  var22 = Util71.m_2924(EnergyClient.getTheme(var20 * 50), Util71.m_1415(244, 101, 101), var18);
               } else {
                  var22 = EnergyClient.getTheme(var20 * 50);
               }

               float var23 = this.f_11154 + var21 * f_11290;
               float var24 = f_11291;
               float var25 = f_11292;
               int var26 = (int)Math.pow(var20, f_11293);
               var2.push();
               var2.translate(
                  var9 + var24 * MathHelper.sin(var23 + var26),
                  var11 + var25 + f_11294 * MathHelper.sin(this.f_11154 + var21 * f_11295) + f_11296 * var20,
                  var13 + var24 * MathHelper.cos(var23 - var26)
               );
               float var27 = (float)this.f_11153.m_2276() * (f_11297 + var21 / f_11298);
               var2.scale(var27, var27, var27);
               var2.multiply(var8.getRotation());
               byte var28 = -25;
               byte var29 = 50;
               int var30 = (int)(this.f_11153.m_2276() * f_11299);
               int var31 = Util71.m_3389(var22, var30);
               int var32 = var31 >> 16 & 0xFF;
               int var33 = var31 >> 8 & 0xFF;
               int var34 = var31 & 0xFF;
               int var35 = var31 >> 24 & 0xFF;
               Matrix4f var36 = var2.peek().getPositionMatrix();
               BufferBuilder var37 = var19.begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
               var37.vertex(var36, var28, var28 + var29, 0.0F).texture(0.0F, 1.0F).color(var32, var33, var34, var35);
               var37.vertex(var36, var28 + var29, var28 + var29, 0.0F).texture(1.0F, 1.0F).color(var32, var33, var34, var35);
               var37.vertex(var36, var28 + var29, var28, 0.0F).texture(1.0F, 0.0F).color(var32, var33, var34, var35);
               var37.vertex(var36, var28, var28, 0.0F).texture(0.0F, 0.0F).color(var32, var33, var34, var35);
               RenderUtil12.I(var37.end());
               var2.pop();
            }
         }

         var2.pop();
         Util114.m_100();
         Util114.m_1878(true);
         Util114.m_963();
         Util114.m_542();
         Util114.m_1562();
      }
   }

   @Override
   public void m_2() {
      this.m_3634();
      this.m_3485();
      super.m_2();
   }

   private void m_2360(BufferBuilder var1, Matrix4f var2, Vector3f var3, Vector3f var4, float var5, float var6, float var7, float var8, int var9) {
      float var10 = var8 * f_11236;
      float var11 = var3.x * var10;
      float var12 = var3.y * var10;
      float var13 = var3.z * var10;
      float var14 = var4.x * var10;
      float var15 = var4.y * var10;
      float var16 = var4.z * var10;
      int var17 = var9 >> 16 & 0xFF;
      int var18 = var9 >> 8 & 0xFF;
      int var19 = var9 & 0xFF;
      int var20 = var9 >> 24 & 0xFF;
      var1.vertex(var2, var5 - var11 - var14, var6 - var12 - var15, var7 - var13 - var16).texture(0.0F, 1.0F).color(var17, var18, var19, var20);
      var1.vertex(var2, var5 - var11 + var14, var6 - var12 + var15, var7 - var13 + var16).texture(0.0F, 0.0F).color(var17, var18, var19, var20);
      var1.vertex(var2, var5 + var11 + var14, var6 + var12 + var15, var7 + var13 + var16).texture(1.0F, 0.0F).color(var17, var18, var19, var20);
      var1.vertex(var2, var5 + var11 - var14, var6 + var12 - var15, var7 + var13 - var16).texture(1.0F, 1.0F).color(var17, var18, var19, var20);
   }

   private boolean m_3970(LivingEntity var1) {
      return var1 != null && var1.isAlive() && !var1.isRemoved();
   }

   private float m_1675(int var1, float var2) {
      float var3 = Math.abs(MathHelper.sin(var1));
      return f_11235 + var2 * var3 * var3;
   }

   private void m_1659() {
      Util114.m_1481();
      Util114.m_1206(770, 1, 1, 0);
      Util114.m_3978();
      Util114.m_672();
      Util114.m_1878(false);
      Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
      Util114.m_3784(RenderUtil7.f_13885);
   }

   public void m_2383() {
      if (!this.f_11168) {
         this.f_11167 = this.f_11167 + f_11319;
         if (this.f_11167 > f_11320) {
            this.f_11167 = f_11321;
            this.f_11168 = true;
         }
      } else {
         this.f_11167 = this.f_11167 - f_11322;
         if (this.f_11167 < f_11323) {
            this.f_11167 = f_11324;
            this.f_11168 = false;
         }
      }

      this.f_11166 = this.f_11166 + this.f_11167;
      this.f_11166 = (this.f_11166 + f_11325) % f_11326;
   }

   private void m_617(
      BufferBuilder var1,
      Matrix4f var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      int var12
   ) {
      this.m_1951(var1, var2, var3, var4, var5, var12);
      this.m_1951(var1, var2, var6, var7, var8, var12);
      this.m_1951(var1, var2, var9, var10, var11, var12);
   }

   private boolean m_107(float var1) {
      if (this.f_11149 == null) {
         return false;
      } else if (!this.f_11149.isAlive() || this.f_11149.isRemoved()) {
         this.f_11149 = null;
         return false;
      } else if (var1 <= f_11283) {
         if (this.m_713() == null) {
            this.f_11149 = null;
         }

         return false;
      } else {
         return true;
      }
   }

   private void m_1640(Matrix4f var1, float var2, float var3, float var4, float var5, int var6, float var7, float var8, float var9, int var10) {
      int var11 = Util71.m_120(var6, (int)(f_11286 * var7 * var9));
      Util114.m_2977(var8);
      BufferBuilder var12 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINE_STRIP, VertexFormats.POSITION_COLOR);
      int var13 = 0;

      while (var13 <= 360) {
         float var14 = (float)Math.toRadians(var13);
         this.m_1951(var12, var1, var2 + MathHelper.cos(var14) * var5, var3, var4 + MathHelper.sin(var14) * var5, var11);
         var13 += var10;
      }

      RenderUtil12.I(var12.end());
   }

   private float m_2126(float var1) {
      float var2 = Math.max(0.0F, this.f_11149.hurtTime - var1);
      return MathHelper.sin(var2 * f_11284) * f_11285;
   }

   private void m_3332(Util88 var1) {
      LivingEntity var2 = this.m_713();
      if (this.m_3970(var2)) {
         this.f_11149 = var2;
      }

      this.f_11158.m_3631(this.m_3970(var2) ? 1.0 : 0.0);
      float var3 = MathHelper.clamp((float)this.f_11158.m_2276(), 0.0F, 1.0F);
      if (this.m_107(var3)) {
         float var4 = (float)this.f_11160.m_2276();
         if (var4 >= f_11265) {
            this.f_11164 = false;
         } else if (var4 <= f_11266) {
            this.f_11164 = true;
         }

         this.f_11160.m_3631(this.f_11164 ? 1.0 : 0.0);
         var4 = MathHelper.clamp((float)this.f_11160.m_2276(), 0.0F, 1.0F);
         if (var4 > f_11267) {
            this.f_11165 = f_11268;
         } else if (var4 < f_11269) {
            this.f_11165 = f_11270;
         }

         this.f_11161.m_3631(this.f_11165);
         float var5 = (float)this.f_11161.m_2276();
         float var6 = var1.m_191();
         Camera var7 = f_5909.gameRenderer.getCamera();
         Vec3d var8 = var7.getCameraPos();
         float var9 = (float)(MathHelper.lerp(var6, this.f_11149.lastX, this.f_11149.getX()) - var8.x);
         float var10 = (float)(MathHelper.lerp(var6, this.f_11149.lastY, this.f_11149.getY()) - var8.y) + (this.f_11149.getHeight() + f_11271) * var4;
         float var11 = (float)(MathHelper.lerp(var6, this.f_11149.lastZ, this.f_11149.getZ()) - var8.z);
         float var12 = this.f_11149.getWidth() * f_11272;
         int var13 = this.m_1138(var6);
         int var14 = Util71.m_120(var13, (int)(f_11273 * var3));
         int var15 = Util71.m_120(var13, Math.max(1, (int)(f_11274 * var3)));
         this.m_1659();
         Matrix4f var16 = var1.m_213().peek().getPositionMatrix();
         BufferBuilder var17 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

         for (int var18 = 0; var18 < 360; var18++) {
            int var19 = var18 + 1;
            float var20 = (float)Math.toRadians(var18);
            float var21 = (float)Math.toRadians(var19);
            float var22 = var9 + MathHelper.cos(var20) * var12;
            float var23 = var11 + MathHelper.sin(var20) * var12;
            float var24 = var9 + MathHelper.cos(var21) * var12;
            float var25 = var11 + MathHelper.sin(var21) * var12;
            float var26 = (1.0F + MathHelper.cos(var18 * f_11275) * MathHelper.cos(var18 * f_11276) * f_11277) * var5;
            float var27 = (1.0F + MathHelper.cos(var19 * f_11278) * MathHelper.cos(var19 * f_11279) * f_11280) * var5;
            this.m_1951(var17, var16, var22, var10, var23, var14);
            this.m_1951(var17, var16, var24, var10, var25, var14);
            this.m_1951(var17, var16, var24, var10 + var27, var25, var15);
            this.m_1951(var17, var16, var22, var10 + var26, var23, var15);
         }

         RenderUtil12.I(var17.end());
         this.m_1640(var16, var9, var10, var11, var12, var13, var3, f_11281, f_11282, 2);
         this.m_1640(var16, var9, var10, var11, var12, var13, var3, 2.0F, 1.0F, 1);
         this.m_250();
      }
   }

   private int m_1138(float var1) {
      int var2 = EnergyClient.getTheme(0);
      if (this.f_11148.m_1163()) {
         var2 = Util71.m_2924(var2, Util71.m_1415(255, 0, 0), this.m_2126(var1));
      }

      return var2;
   }

   private void m_2948(Util88 var1) {
      LivingEntity var2 = this.m_713();
      if (var2 != null) {
         this.f_11149 = var2;
      }

      this.f_11156.m_3631(var2 != null ? 1.0 : 0.0);
      float var3 = (float)(this.f_11156.m_2276() * f_11300);
      if (this.f_11149 != null) {
         if (Math.sin(this.f_11149.hurtTime * f_11301) > 0.0) {
            this.f_11157.m_444(Util153.EASE_IN_SINE);
            this.f_11157.m_3631(1.0);
         } else {
            this.f_11157.m_444(Util153.EASE_OUT_SINE);
            this.f_11157.m_3631(0.0);
         }

         float var4 = (float)Math.sin(this.f_11149.hurtTime * f_11302);
         int var5;
         if (this.f_11148.m_1163()) {
            var5 = Util71.m_2924(EnergyClient.getTheme(90), Util71.m_1415(244, 101, 101), var4);
         } else {
            var5 = EnergyClient.getTheme(90);
         }

         MatrixStack var6 = var1.m_213();
         float var7 = var1.m_191();
         Tessellator var8 = Tessellator.getInstance();
         var6.push();
         Camera var9 = f_5909.gameRenderer.getCamera();
         Vec3d var10 = var9.getCameraPos();
         double var11 = MathHelper.lerp(var7, this.f_11149.lastX, this.f_11149.getX()) - var10.x;
         double var13 = MathHelper.lerp(var7, this.f_11149.lastY, this.f_11149.getY()) - var10.y + this.f_11149.getHeight() / 2.0F;
         double var15 = MathHelper.lerp(var7, this.f_11149.lastZ, this.f_11149.getZ()) - var10.z;
         var6.translate(var11, var13, var15);
         var6.multiply(var9.getRotation());
         float var17 = f_11303;
         float var18 = var17 + var17 - (float)this.f_11156.m_2276() * var17 - (float)this.f_11157.m_2276() * f_11304;
         var6.scale(var18, var18, var18);
         Util114.m_672();
         Util114.m_1878(false);
         Util114.m_3978();
         Util114.m_1481();
         Util114.m_542();
         Util114.m_1206(770, 1, 0, 1);
         Identifier var19 = Identifier.of(f_11305, f_11306);
         Util114.m_2037(0, var19);
         Util114.m_3784(RenderUtil7.f_13886);
         this.m_2383();
         var6.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(this.f_11166));
         Matrix4f var20 = var6.peek().getPositionMatrix();
         int var21 = Util71.m_3389(var5, (int)var3);
         float var22 = (var21 >> 16 & 0xFF) / f_11307;
         float var23 = (var21 >> 8 & 0xFF) / f_11308;
         float var24 = (var21 & 0xFF) / f_11309;
         float var25 = (var21 >> 24 & 0xFF) / f_11310;
         BufferBuilder var26 = var8.begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

         for (int var27 = 0; var27 < 2; var27++) {
            var26.vertex(var20, f_11311, f_11312, 0.0F).texture(0.0F, 0.0F).color(var22, var23, var24, var25);
            var26.vertex(var20, f_11313, f_11314, 0.0F).texture(0.0F, 1.0F).color(var22, var23, var24, var25);
            var26.vertex(var20, f_11315, f_11316, 0.0F).texture(1.0F, 1.0F).color(var22, var23, var24, var25);
            var26.vertex(var20, f_11317, f_11318, 0.0F).texture(1.0F, 0.0F).color(var22, var23, var24, var25);
         }

         RenderUtil12.I(var26.end());
         Util114.m_1878(true);
         Util114.m_1562();
         Util114.m_542();
         Util114.m_963();
         Util114.m_100();
         Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
         var6.pop();
      }
   }

   private void m_1951(BufferBuilder var1, Matrix4f var2, float var3, float var4, float var5, int var6) {
      var1.vertex(var2, var3, var4, var5).color(var6 >> 16 & 0xFF, var6 >> 8 & 0xFF, var6 & 0xFF, var6 >> 24 & 0xFF);
   }

   @Override
   public void m_1() {
      this.m_3634();
      super.m_1();
   }
}
