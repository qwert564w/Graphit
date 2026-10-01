package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import org.joml.Matrix4f;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util170;
import su.energyclient.util.Util66;
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;

public class KillEffect extends Module {
   private final ModeSetting f_7533;
   private final NumberSetting f_7534;
   private final NumberSetting f_7535;
   private final NumberSetting f_7536;
   private final Identifier f_7537;
   private final ObjectArrayList<KillEffect.bi3LOF8JfzZH3cxB> f_7538;
   private UUID f_7539;

   private final NumberSetting bloodAmount;
   private final NumberSetting bloodPower;
   private final NumberSetting bloodSize;
   private final NumberSetting bloodTime;

   private final List<BloodDrop> bloodDrops = new ArrayList<>();
   private final List<BloodSplat> bloodSplats = new ArrayList<>();
   private final Set<Integer> processedDeaths = new HashSet<>();
   private Object lastLevel = null;
   private int splatCounter = 0;

   private static final String f_7540 = "Kill Effect";
   private static final String f_7541 = "Красивый визуальный эффект при убийстве";
   private static final String f_7542 = "Эффект";
   private static final String f_7543 = "Спираль + Кольцо";
   private static final String f_7544 = "Спираль + Кольцо";
   private static final String f_7545 = "Столб света";
   private static final String f_7546 = "Взрыв душ";
   private static final String MODE_BLOOD = "Кровь";
   private static final String f_7547 = "Длительность (мс)";
   private static final float f_7548 = 3500.0F;
   private static final float f_7549 = 1500.0F;
   private static final float f_7550 = 7000.0F;
   private static final float f_7551 = 250.0F;
   private static final String f_7552 = "Кол-во частиц";
   private static final float f_7553 = 80.0F;
   private static final float f_7554 = 20.0F;
   private static final float f_7555 = 200.0F;
   private static final float f_7556 = 5.0F;
   private static final String f_7557 = "Размер кольца";
   private static final float f_7558 = 3.5F;
   private static final float f_7559 = 8.0F;
   private static final float f_7560 = 0.25F;
   private static final String f_7561 = "energy";
   private static final String f_7562 = "images/esp/glow.png";
   private static final String f_7563 = "Спираль + Кольцо";
   private static final String f_7564 = "Столб света";
   private static final double f_7565 = Math.PI * 2;
   private static final double f_7566 = 0.015;
   private static final double f_7567 = 0.025;
   private static final double f_7568 = 0.02;
   private static final double f_7569 = 0.04;
   private static final double f_7570 = 0.3;
   private static final double f_7571 = 0.3;
   private static final double f_7572 = 360.0;
   private static final String f_7573 = "Взрыв душ";
   private static final double f_7574 = 2.0;
   private static final double f_7575 = Math.PI;
   private static final double f_7576 = 2.0;
   private static final double f_7577 = 0.03;
   private static final double f_7578 = 0.06;
   private static final double f_7579 = 0.015;
   private static final double f_7580 = 0.5;
   private static final double f_7581 = 360.0;
   private static final String f_7582 = "Спираль + Кольцо";
   private static final String f_7583 = "Столб света";
   private static final String f_7584 = "Взрыв душ";
   private static final float f_7585 = 0.1F;
   private static final float f_7586 = 0.6F;
   private static final float f_7587 = 0.4F;
   private static final float f_7588 = 0.01F;
   private static final float f_7629 = 0.15F;
   private static final float f_7630 = 0.4F;
   private static final float f_7631 = 0.3F;
   private static final float f_7632 = 0.01F;
   private static final float f_7633 = 0.6F;
   private static final float f_7634 = 0.1F;
   private static final float f_7635 = 255.0F;
   private static final float f_7636 = 180.0F;
   private static final float f_7637 = 0.35F;
   private static final float f_7638 = 200.0F;
   private static final float f_7639 = 0.15F;
   private static final float f_7640 = 0.2F;
   private static final float f_7641 = 0.25F;
   private static final float f_7642 = 0.5F;
   private static final float f_7643 = 0.3F;
   private static final float f_7644 = 0.85F;
   private static final float f_7645 = 0.01F;
   private static final float f_7646 = 0.5F;
   private static final float f_7647 = 0.05F;
   private static final float f_7648 = 220.0F;
   private static final float f_7649 = 0.001F;
   private static final float f_7674 = (float)(Math.PI * 2);
   private static final float f_7676 = (float)(Math.PI * 2);
   private static final float f_7677 = (float)(Math.PI * 2);

   private static final float GRAVITY = 0.045F;
   private static final float DRAG = 0.96F;
   private static final int MAX_FLIGHT_TICKS = 90;
   private static final int MAX_SPLATS = 80;

   public KillEffect() {
      super(f_7540, f_7541, Category.RENDER);
      this.f_7533 = new ModeSetting(f_7542, f_7543, f_7544, f_7545, f_7546, MODE_BLOOD);
      this.f_7534 = new NumberSetting(f_7547, f_7548, f_7549, f_7550, f_7551);
      this.f_7535 = new NumberSetting(f_7552, f_7553, f_7554, f_7555, f_7556);
      this.f_7536 = new NumberSetting(f_7557, f_7558, 1.0F, f_7559, f_7560);
      this.f_7537 = Identifier.of(f_7561, f_7562);
      this.f_7538 = new ObjectArrayList<>();

      this.bloodAmount = new NumberSetting("Кол-во крови", 55.0F, 15.0F, 140.0F, 1.0F).m_356(() -> this.f_7533.m_2073(MODE_BLOOD));
      this.bloodPower = new NumberSetting("Сила разлёта", 0.55F, 0.15F, 1.4F, 0.05F).m_356(() -> this.f_7533.m_2073(MODE_BLOOD));
      this.bloodSize = new NumberSetting("Размер капель", 0.09F, 0.03F, 0.22F, 0.01F).m_356(() -> this.f_7533.m_2073(MODE_BLOOD));
      this.bloodTime = new NumberSetting("Время крови (сек)", 2.8F, 1.0F, 6.0F, 0.1F).m_356(() -> this.f_7533.m_2073(MODE_BLOOD));
   }

   @Override
   public void m_1() {
      this.f_7538.clear();
      this.f_7539 = null;
      this.resetBlood();
      super.m_1();
   }

   @Override
   public void m_2() {
      super.m_2();
      this.f_7538.clear();
      this.f_7539 = null;
      this.resetBlood();
   }

   private void resetBlood() {
      this.bloodDrops.clear();
      this.bloodSplats.clear();
      this.processedDeaths.clear();
      this.lastLevel = null;
   }

   @EventHandler
   private void m_3572(Util170 var1) {
      if (f_5909.player == null || f_5909.world == null) {
         this.resetBlood();
         return;
      }
      if (this.f_7533.m_2073(MODE_BLOOD)) this.tickBlood();
      if (this.lastLevel != f_5909.world) {
         this.resetBlood();
         this.lastLevel = f_5909.world;
      }
      if (!(InitManager.f_2740.f_2741.attackAura.m_891() instanceof PlayerEntity var3)) {
         this.f_7539 = null;
      } else {
         boolean dead = !var3.isAlive() || var3.isDead() || var3.getHealth() <= 0.0F;
         if (!dead) {
            if (this.f_7539 != null && this.f_7539.equals(var3.getUuid())) this.f_7539 = null;
         } else if (!var3.getUuid().equals(this.f_7539)) {
            this.f_7539 = var3.getUuid();
            this.m_2831(var3);
         }
      }
      if (this.f_7533.m_2073(MODE_BLOOD)) {
         Set<Integer> active = new HashSet<>();
         for (Entity e : f_5909.world.getEntities()) {
            if (e instanceof LivingEntity living && living != f_5909.player) {
               active.add(e.getId());
               if ((living.isDead() || living.getHealth() <= 0.0F) && this.processedDeaths.add(e.getId())) {
                  this.spawnBlood(living);
               }
            }
         }
         this.processedDeaths.removeIf(id -> !active.contains(id));
      }
   }

   @EventHandler
   private void onPacket(Util66 event) {
      if (!this.f_7533.m_2073(MODE_BLOOD)) return;
      if (!event.m_2068() || f_5909.world == null || f_5909.player == null) return;
      if (!(event.m_3295() instanceof EntityStatusS2CPacket packet)) return;
      if (packet.getStatus() != 3) return;
      Entity entity = packet.getEntity(f_5909.world);
      if (entity instanceof LivingEntity living && living != f_5909.player) {
         if (this.processedDeaths.add(entity.getId())) this.spawnBlood(living);
      }
   }

   private void m_2831(LivingEntity var1) {
      if (this.f_7533.m_2073(MODE_BLOOD)) {
         this.spawnBlood(var1);
         return;
      }
      Vec3d var2 = new Vec3d(var1.getX(), var1.getY(), var1.getZ());
      float var3 = var1.getHeight();
      int var4 = this.f_7535.m_134().intValue();
      KillEffect.bi3LOF8JfzZH3cxB var5 = new KillEffect.bi3LOF8JfzZH3cxB(var2, var3, System.currentTimeMillis());
      if (this.f_7533.m_2073(f_7563) || this.f_7533.m_2073(f_7564)) {
         for (int var6 = 0; var6 < var4; var6++) {
            double var7 = f_7565 * var6 / var4;
            double var9 = (double)var6 / var4;
            double var11 = f_7566 + Math.random() * f_7567;
            double var13 = Math.cos(var7) * var11;
            double var15 = f_7568 + Math.random() * f_7569;
            double var17 = Math.sin(var7) * var11;
            int var19 = EnergyClient.getTheme(var6 * 40);
            var5.f_5111.add(new KillEffect.dTC4nEiXa2WA0ZjM(var2.x + Math.cos(var7) * f_7570, var2.y + var3 * var9, var2.z + Math.sin(var7) * f_7571, var13, var15, var17, var19, (float)(Math.random() * f_7572), var6));
         }
      }
      if (this.f_7533.m_2073(f_7573)) {
         for (int var20 = 0; var20 < var4; var20++) {
            double var21 = Math.random() * f_7574 * f_7575;
            double var22 = Math.acos(f_7576 * Math.random() - 1.0);
            double var23 = f_7577 + Math.random() * f_7578;
            double var24 = var23 * Math.sin(var22) * Math.cos(var21);
            double var25 = var23 * Math.cos(var22) + f_7579;
            double var26 = var23 * Math.sin(var22) * Math.sin(var21);
            int var27 = EnergyClient.getTheme(var20 * 30);
            var5.f_5111.add(new KillEffect.dTC4nEiXa2WA0ZjM(var2.x, var2.y + var3 * f_7580, var2.z, var24, var25, var26, var27, (float)(Math.random() * f_7581), var20));
         }
      }
      this.f_7538.add(var5);
   }

   private void spawnBlood(LivingEntity entity) {
      Vec3d pos = entity.getPos();
      float width = MathHelper.clamp(entity.getWidth(), 0.3F, 1.6F);
      float height = MathHelper.clamp(entity.getHeight(), 0.3F, 2.6F);
      Vec3d center = new Vec3d(pos.x, pos.y + height * 0.55, pos.z);
      int count = Math.round(this.bloodAmount.m_4046());
      float power = this.bloodPower.m_4046();
      float size = this.bloodSize.m_4046();
      ThreadLocalRandom rnd = ThreadLocalRandom.current();
      for (int i = 0; i < count; i++) {
         double a = rnd.nextDouble() * Math.PI * 2.0;
         double elev = (rnd.nextDouble() - 0.25) * 0.9;
         double speed = (0.25 + rnd.nextDouble() * 0.75) * power;
         double vx = Math.cos(a) * speed * (0.7 + rnd.nextDouble() * 0.6);
         double vy = (0.15 + rnd.nextDouble() * 0.55) * power + elev * 0.2;
         double vz = Math.sin(a) * speed * (0.7 + rnd.nextDouble() * 0.6);
         float s = size * (0.55F + rnd.nextFloat() * 0.9F);
         int r = MathHelper.clamp(139 + rnd.nextInt(30) - 10, 40, 180);
         int g = MathHelper.clamp(rnd.nextInt(15), 0, 40);
         int b = MathHelper.clamp(rnd.nextInt(10), 0, 30);
         int color = 0xFF000000 | (r << 16) | (g << 8) | b;
         this.bloodDrops.add(new BloodDrop(center.add((rnd.nextDouble() - 0.5) * width * 0.4, (rnd.nextDouble() - 0.3) * height * 0.3, (rnd.nextDouble() - 0.5) * width * 0.4), new Vec3d(vx, vy, vz), s, color));
      }
   }

   private void tickBlood() {
      if (f_5909.world == null || f_5909.player == null) return;
      long now = System.currentTimeMillis();
      long splatLife = (long)(this.bloodTime.m_4046() * 1000.0F);
      this.bloodSplats.removeIf(s -> now - s.start > splatLife);
      List<BloodDrop> secondary = null;
      Iterator<BloodDrop> it = this.bloodDrops.iterator();
      while (it.hasNext()) {
         BloodDrop d = it.next();
         d.prev = d.pos;
         d.age++;
         if (d.age > MAX_FLIGHT_TICKS) { it.remove(); continue; }
         Vec3d vel = new Vec3d(d.vel.x * DRAG, (d.vel.y - GRAVITY) * DRAG, d.vel.z * DRAG);
         Vec3d next = d.pos.add(vel);
         BlockHitResult hit = f_5909.world.raycast(new RaycastContext(d.pos, next, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.ANY, f_5909.player));
         if (hit != null && hit.getType() == HitResult.Type.BLOCK) {
            Direction face = hit.getSide();
            Vec3d at = hit.getPos();
            if (face == Direction.UP) {
               float speed = (float)vel.length();
               float radius = d.size * (2.2F + Math.min(speed, 0.8F) * 4.0F);
               this.bloodSplats.add(new BloodSplat(at, radius, d.color, now, this.splatCounter++ % 40));
               while (this.bloodSplats.size() > MAX_SPLATS) this.bloodSplats.remove(0);
               if (d.size > 0.055F && speed > 0.25F && !d.child) {
                  if (secondary == null) secondary = new ArrayList<>();
                  ThreadLocalRandom rnd = ThreadLocalRandom.current();
                  int n = 2 + rnd.nextInt(3);
                  for (int k = 0; k < n; k++) {
                     double a = rnd.nextDouble() * Math.PI * 2.0;
                     double h = 0.03 + rnd.nextDouble() * 0.07;
                     BloodDrop c = new BloodDrop(at.add(0, 0.02, 0), new Vec3d(Math.cos(a) * h + vel.x * 0.25, 0.05 + rnd.nextDouble() * 0.08, Math.sin(a) * h + vel.z * 0.25), d.size * 0.35F, d.color);
                     c.child = true;
                     secondary.add(c);
                  }
               }
               it.remove();
               continue;
            }
            if (face == Direction.DOWN) vel = new Vec3d(vel.x * 0.4, -Math.abs(vel.y) * 0.1, vel.z * 0.4);
            else {
               double vx = face.getAxis() == Direction.Axis.X ? -vel.x * 0.12 : vel.x * 0.3;
               double vz = face.getAxis() == Direction.Axis.Z ? -vel.z * 0.12 : vel.z * 0.3;
               vel = new Vec3d(vx, vel.y * 0.35, vz);
            }
            d.pos = at.add(face.getOffsetX() * 0.01, face.getOffsetY() * 0.01, face.getOffsetZ() * 0.01);
            d.vel = vel;
         } else {
            d.pos = next;
            d.vel = vel;
         }
      }
      if (secondary != null) this.bloodDrops.addAll(secondary);
   }

   @EventHandler
   private void m_552(Util88 var1) {
      if (f_5909.world == null || f_5909.player == null) return;
      if (this.f_7533.m_2073(MODE_BLOOD) && (!this.bloodDrops.isEmpty() || !this.bloodSplats.isEmpty())) {
         this.renderBlood(var1.m_213(), f_5909.gameRenderer.getCamera());
      }
      if (this.f_7538.isEmpty()) return;
      long var2 = System.currentTimeMillis();
      long var4 = (long)this.f_7534.m_4046();
      this.f_7538.removeIf(var4x -> var2 - var4x.f_5110 > var4);
      if (this.f_7538.isEmpty()) return;
      MatrixStack var6 = var1.m_213();
      Camera var7 = f_5909.gameRenderer.getCamera();
      Vec3d var8 = var7.getCameraPos();
      ObjectListIterator var9 = this.f_7538.iterator();
      while (var9.hasNext()) {
         KillEffect.bi3LOF8JfzZH3cxB var10 = (KillEffect.bi3LOF8JfzZH3cxB)var9.next();
         float var11 = MathHelper.clamp((float)(var2 - var10.f_5110) / (float)var4, 0.0F, 1.0F);
         if (this.f_7533.m_2073(f_7582)) this.m_1778(var6, var7, var8, var10, var11, var2);
         else if (this.f_7533.m_2073(f_7583)) this.m_2049(var6, var7, var8, var10, var11, var2);
         else if (this.f_7533.m_2073(f_7584)) this.m_914(var6, var7, var8, var10, var11, var2);
      }
   }

   private void renderBlood(MatrixStack matrices, Camera camera) {
      if (camera == null) return;
      Vec3d cam = camera.getCameraPos();
      long now = System.currentTimeMillis();
      long splatLife = (long)(this.bloodTime.m_4046() * 1000.0F);
      Util114.m_1481();
      Util114.m_3978();
      Util114.m_100();
      Util114.m_1878(false);
      Util114.m_1206(770, 1, 0, 1);
      Matrix4f mat = matrices.peek().getPositionMatrix();
      if (!this.bloodDrops.isEmpty()) {
         BufferBuilder buf = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         float pt = f_5909.getRenderTickCounter().getTickDelta(false);
         for (BloodDrop d : this.bloodDrops) {
            double x = MathHelper.lerp(pt, d.prev.x, d.pos.x) - cam.x;
            double y = MathHelper.lerp(pt, d.prev.y, d.pos.y) - cam.y;
            double z = MathHelper.lerp(pt, d.prev.z, d.pos.z) - cam.z;
            float s = d.size * 0.5F;
            float[] c = Util71.m_2326(d.color);
            float a = c[3] * MathHelper.clamp(1.0F - d.age / (float)MAX_FLIGHT_TICKS, 0.15F, 1.0F);
            buf.vertex(mat, (float)(x - s), (float)(y - s), (float)z).color(c[0], c[1], c[2], a);
            buf.vertex(mat, (float)(x + s), (float)(y - s), (float)z).color(c[0], c[1], c[2], a);
            buf.vertex(mat, (float)(x + s), (float)(y + s), (float)z).color(c[0], c[1], c[2], a);
            buf.vertex(mat, (float)(x - s), (float)(y + s), (float)z).color(c[0], c[1], c[2], a);
         }
         RenderUtil12.I(buf.end());
      }
      if (!this.bloodSplats.isEmpty()) {
         BufferBuilder buf = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         for (BloodSplat s : this.bloodSplats) {
            float life = MathHelper.clamp((now - s.start) / (float)splatLife, 0.0F, 1.0F);
            float alpha = 1.0F - life * life;
            if (alpha <= 0.02F) continue;
            float r = s.radius * (0.85F + life * 0.4F);
            float[] c = Util71.m_2326(s.color);
            double x = s.pos.x - cam.x;
            double y = s.pos.y - cam.y + 0.01;
            double z = s.pos.z - cam.z;
            buf.vertex(mat, (float)(x - r), (float)y, (float)(z - r)).color(c[0], c[1], c[2], c[3] * alpha * 0.85F);
            buf.vertex(mat, (float)(x + r), (float)y, (float)(z - r)).color(c[0], c[1], c[2], c[3] * alpha * 0.85F);
            buf.vertex(mat, (float)(x + r), (float)y, (float)(z + r)).color(c[0], c[1], c[2], c[3] * alpha * 0.85F);
            buf.vertex(mat, (float)(x - r), (float)y, (float)(z + r)).color(c[0], c[1], c[2], c[3] * alpha * 0.85F);
         }
         RenderUtil12.I(buf.end());
      }
      Util114.m_1878(true);
      Util114.m_963();
      Util114.m_542();
      Util114.m_1562();
   }

   private void m_1778(MatrixStack var1, Camera var2, Vec3d var3, KillEffect.bi3LOF8JfzZH3cxB var4, float var5, long var6) {
      float var8 = this.m_2654(MathHelper.clamp(var5 / f_7585, 0.0F, 1.0F));
      float var9 = 1.0F - this.m_2654(MathHelper.clamp((var5 - f_7586) / f_7587, 0.0F, 1.0F));
      float var10 = var8 * var9;
      if (!(var10 <= f_7588)) {
         this.m_923(var1, var3, var4, var5, var10);
         this.m_2518(var1, var3, var4, var5, var10);
         this.m_3646(var1, var2, var3, var4, var5, var10, var6);
      }
   }

   private void m_923(MatrixStack var1, Vec3d var2, KillEffect.bi3LOF8JfzZH3cxB var3, float var4, float var5) {
      float var6 = this.m_2654(MathHelper.clamp(var4 / f_7629, 0.0F, 1.0F));
      float var7 = 1.0F - this.m_2654(MathHelper.clamp((var4 - f_7630) / f_7631, 0.0F, 1.0F));
      float var8 = var5 * var7;
      if (!(var8 <= f_7632)) {
         float var9 = this.f_7536.m_4046();
         float var10 = var9 * var6;
         float var11 = var10 * f_7633;
         float var12 = (float)(var3.f_5108.x - var2.x);
         float var13 = (float)(var3.f_5108.y - var2.y + f_7634);
         float var14 = (float)(var3.f_5108.z - var2.z);
         Util114.m_1481();
         Util114.m_3978();
         Util114.m_100();
         Util114.m_1878(false);
         Util114.m_1206(770, 1, 0, 1);
         Util114.m_3784(RenderUtil7.f_13885);
         Matrix4f var15 = var1.peek().getPositionMatrix();
         byte var16 = 64;
         int var17 = Util71.m_3389(EnergyClient.getTheme(0), (int)(var8 * f_7635));
         int var18 = Util71.m_3389(EnergyClient.getTheme(90), (int)(var8 * f_7636));
         this.m_1464(var15, var12, var13, var14, var11, var10, var17, var18, var16);
         float var19 = var10 * f_7637;
         int var20 = Util71.m_3389(EnergyClient.getTheme(45), (int)(var8 * f_7638));
         int var21 = Util71.m_3389(EnergyClient.getTheme(45), 0);
         this.m_1464(var15, var12, var13 + f_7639, var14, var10, var19, var20, var21, var16);
         Util114.m_1878(true);
         Util114.m_963();
         Util114.m_542();
         Util114.m_1562();
      }
   }

   private void m_1204(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9) {
      float[] var10 = Util71.m_2326(var7);
      float[] var11 = Util71.m_2326(var8);
      BufferBuilder var12 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
      float var13 = (float)(f_7676 / var9);
      for (int var14 = 0; var14 <= var9; var14++) {
         float var15 = var14 * var13;
         float var16 = MathHelper.cos(var15);
         float var17 = MathHelper.sin(var15);
         var12.vertex(var1, var2 + var16 * var6, var3, var5 + var17 * var6).color(var10[0], var10[1], var10[2], var10[3]);
         var12.vertex(var1, var2 + var16 * var6, var4, var5 + var17 * var6).color(var11[0], var11[1], var11[2], var11[3]);
      }
      RenderUtil12.I(var12.end());
   }

   private void m_2518(MatrixStack var1, Vec3d var2, KillEffect.bi3LOF8JfzZH3cxB var3, float var4, float var5) {
      float var6 = this.m_2654(MathHelper.clamp((var4 - f_7640) / f_7641, 0.0F, 1.0F));
      float var7 = 1.0F - this.m_2654(MathHelper.clamp((var4 - f_7642) / f_7643, 0.0F, 1.0F));
      float var8 = var5 * var7 * f_7644;
      if (!(var8 <= f_7645)) {
         float var9 = this.f_7536.m_4046() * f_7646 * var6;
         float var10 = (float)(var3.f_5108.x - var2.x);
         float var11 = (float)(var3.f_5108.y - var2.y + f_7647);
         float var12 = (float)(var3.f_5108.z - var2.z);
         Util114.m_1481();
         Util114.m_3978();
         Util114.m_100();
         Util114.m_1878(false);
         Util114.m_1206(770, 1, 0, 1);
         Util114.m_3784(RenderUtil7.f_13885);
         Matrix4f var13 = var1.peek().getPositionMatrix();
         int var14 = Util71.m_3389(-1, (int)(var8 * f_7648));
         int var15 = Util71.m_3389(EnergyClient.getTheme(0), 0);
         this.m_683(var13, var10, var11, var12, var9, var14, var15, 48);
         Util114.m_1878(true);
         Util114.m_963();
         Util114.m_542();
         Util114.m_1562();
      }
   }

   private void m_3646(MatrixStack var1, Camera var2, Vec3d var3, KillEffect.bi3LOF8JfzZH3cxB var4, float var5, float var6, long var7) {
      if (!var4.f_5111.isEmpty()) {
         for (KillEffect.dTC4nEiXa2WA0ZjM p : var4.f_5111) p.m_1638();
      }
   }

   private void m_2049(MatrixStack var1, Camera var2, Vec3d var3, KillEffect.bi3LOF8JfzZH3cxB var4, float var5, long var6) {
      float progress = this.m_2654(MathHelper.clamp(var5, 0.0F, 1.0F));
      float fade = 1.0F - this.m_2654(MathHelper.clamp((var5 - 0.6F) / 0.4F, 0.0F, 1.0F));
      float alpha = progress * fade;
      if (alpha <= 0.01F) return;
      float h = var4.f_5109 * (1.5F + progress * 2.5F);
      float r = this.f_7536.m_4046() * 0.4F;
      float x = (float)(var4.f_5108.x - var3.x);
      float y = (float)(var4.f_5108.y - var3.y);
      float z = (float)(var4.f_5108.z - var3.z);
      Util114.m_1481();
      Util114.m_3978();
      Util114.m_100();
      Util114.m_1878(false);
      Util114.m_1206(770, 1, 0, 1);
      Util114.m_3784(RenderUtil7.f_13885);
      Matrix4f mat = var1.peek().getPositionMatrix();
      int c1 = Util71.m_3389(EnergyClient.getTheme(0), (int)(alpha * 220));
      int c2 = Util71.m_3389(EnergyClient.getTheme(0), 0);
      this.m_1204(mat, x, y, y + h, z, r, c1, c2, 32);
      Util114.m_1878(true);
      Util114.m_963();
      Util114.m_542();
      Util114.m_1562();
   }

   private void m_914(MatrixStack var1, Camera var2, Vec3d var3, KillEffect.bi3LOF8JfzZH3cxB var4, float var5, long var6) {
      float progress = this.m_2654(MathHelper.clamp(var5 / 0.3F, 0.0F, 1.0F));
      float fade = 1.0F - this.m_2654(MathHelper.clamp((var5 - 0.5F) / 0.5F, 0.0F, 1.0F));
      float alpha = progress * fade;
      if (alpha <= 0.01F) return;
      Util114.m_1481();
      Util114.m_3978();
      Util114.m_100();
      Util114.m_1878(false);
      Util114.m_1206(770, 1, 0, 1);
      Util114.m_3784(RenderUtil7.f_13885);
      Matrix4f mat = var1.peek().getPositionMatrix();
      float x = (float)(var4.f_5108.x - var3.x);
      float y = (float)(var4.f_5108.y - var3.y + var4.f_5109 * 0.5F);
      float z = (float)(var4.f_5108.z - var3.z);
      float radius = this.f_7536.m_4046() * progress * 1.8F;
      int c = Util71.m_3389(EnergyClient.getTheme(180), (int)(alpha * 200));
      this.m_3652(mat, x, y, z, radius, c, 48);
      Util114.m_1878(true);
      Util114.m_963();
      Util114.m_542();
      Util114.m_1562();
   }

   private void m_3652(Matrix4f var1, float var2, float var3, float var4, float var5, int var6, int var7) {
      float[] var8 = Util71.m_2326(var6);
      BufferBuilder var9 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
      float var10 = (float)(f_7677 / var7);
      for (int var11 = 0; var11 <= var7; var11++) {
         float var12 = var11 * var10;
         float var13 = MathHelper.cos(var12);
         float var14 = MathHelper.sin(var12);
         var9.vertex(var1, var2 + var13 * var5, var3, var4 + var14 * var5).color(var8[0], var8[1], var8[2], var8[3]);
         var9.vertex(var1, var2 + var13 * var5 * 0.3F, var3 + var5 * 0.2F, var4 + var14 * var5 * 0.3F).color(var8[0], var8[1], var8[2], 0.0F);
      }
      RenderUtil12.I(var9.end());
   }

   private void m_1464(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9) {
      float[] var10 = Util71.m_2326(var7);
      float[] var11 = Util71.m_2326(var8);
      BufferBuilder var12 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
      float var13 = (float)(f_7674 / var9);
      for (int var14 = 0; var14 <= var9; var14++) {
         float var15 = var14 * var13;
         float var16 = MathHelper.cos(var15);
         float var17 = MathHelper.sin(var15);
         var12.vertex(var1, var2 + var16 * var6, var3, var4 + var17 * var6).color(var10[0], var10[1], var10[2], var10[3]);
         var12.vertex(var1, var2 + var16 * var5, var3 + var5 * 0.1F, var4 + var17 * var5).color(var11[0], var11[1], var11[2], var11[3]);
      }
      RenderUtil12.I(var12.end());
   }

   private void m_683(Matrix4f var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8) {
      float[] var9 = Util71.m_2326(var6);
      float[] var10 = Util71.m_2326(var7);
      BufferBuilder var11 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);
      float var12 = (float)(Math.PI * 2 / var8);
      for (int var13 = 0; var13 <= var8; var13++) {
         float var14 = var13 * var12;
         float var15 = MathHelper.cos(var14);
         float var16 = MathHelper.sin(var14);
         var11.vertex(var1, var2 + var15 * var5, var3, var4 + var16 * var5).color(var9[0], var9[1], var9[2], var9[3]);
         var11.vertex(var1, var2 + var15 * var5 * 0.2F, var3 + var5 * 2.5F, var4 + var16 * var5 * 0.2F).color(var10[0], var10[1], var10[2], var10[3]);
      }
      RenderUtil12.I(var11.end());
   }

   private float m_2654(float var1) {
      return var1 < 0.5F ? 2.0F * var1 * var1 : 1.0F - (float)Math.pow(-2.0F * var1 + 2.0F, 2.0) / 2.0F;
   }

   private static class bi3LOF8JfzZH3cxB {
      final Vec3d f_5108;
      final float f_5109;
      final long f_5110;
      final List<KillEffect.dTC4nEiXa2WA0ZjM> f_5111 = new ArrayList<>();
      bi3LOF8JfzZH3cxB(Vec3d var1, float var2, long var3) {
         this.f_5108 = var1; this.f_5109 = var2; this.f_5110 = var3;
      }
   }

   private static class dTC4nEiXa2WA0ZjM {
      double f_8761, f_8762, f_8763, f_8764, f_8765, f_8766;
      final int f_8767;
      float f_8768;
      final int f_8769;
      private static final double f_8770 = 1.0E-4;
      private static final double f_8771 = 0.995;
      private static final double f_8772 = 0.995;
      private static final double f_8773 = 0.995;
      private static final float f_8774 = 1.5F;
      dTC4nEiXa2WA0ZjM(double var1, double var3, double var5, double var7, double var9, double var11, int var13, float var14, int var15) {
         this.f_8761 = var1; this.f_8762 = var3; this.f_8763 = var5;
         this.f_8764 = var7; this.f_8765 = var9; this.f_8766 = var11;
         this.f_8767 = var13; this.f_8768 = var14; this.f_8769 = var15;
      }
      void m_1638() {
         this.f_8761 += this.f_8764; this.f_8762 += this.f_8765; this.f_8763 += this.f_8766;
         this.f_8765 -= f_8770;
         this.f_8764 *= f_8771; this.f_8765 *= f_8772; this.f_8766 *= f_8773;
         this.f_8768 += f_8774;
      }
   }

   private static class BloodDrop {
      Vec3d pos, prev, vel;
      float size;
      int color, age;
      boolean child;
      BloodDrop(Vec3d pos, Vec3d vel, float size, int color) {
         this.pos = pos; this.prev = pos; this.vel = vel;
         this.size = size; this.color = color; this.age = 0; this.child = false;
      }
   }

   private static class BloodSplat {
      final Vec3d pos;
      final float radius;
      final int color;
      final long start;
      final int variant;
      BloodSplat(Vec3d pos, float radius, int color, long start, int variant) {
         this.pos = pos; this.radius = radius; this.color = color;
         this.start = start; this.variant = variant;
      }
   }
}
