package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventAttack;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil14;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util141;
import su.energyclient.util.Util166;
import su.energyclient.util.Util63;
import su.energyclient.util.Util66;
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;

public class Particles extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ModeSetting f_4453;
   private final NumberSetting f_4454;
   private final NumberSetting f_4455;
   private final Util63 f_4456;
   private final NumberSetting f_4457;
   private final NumberSetting f_4458;
   private final NumberSetting f_4459;
   public final BooleanSetting f_4460;
   private final ObjectArrayList<Util141> l;
   private final ObjectArrayList<Util141> f_4461;
   private final ObjectArrayList<Util141> f_4462;
   private final ObjectArrayList<Util141> f_4463;
   private final Map<Integer, Double> f_4464;
   private final Identifier f_4465;
   private final Identifier f_4466;
   private final Identifier f_4467;
   private final Identifier f_4468;
   private final Identifier f_4469;
   private final Identifier f_4470;
   private final Identifier f_4471;
   private final Identifier f_4472;
   private final Identifier f_4473;
   private static final String f_4474 = "Particles";
   private static final String f_4475 = "Мод партиклов";
   private static final String f_4476 = "Звезда";
   private static final String f_4477 = "Звезда";
   private static final String f_4478 = "Снежинка";
   private static final String f_4479 = "Комок";
   private static final String f_4480 = "Корона";
   private static final String f_4481 = "Доллар";
   private static final String f_4482 = "Сердце";
   private static final String f_4483 = "Ромб";
   private static final String f_4484 = "Тыковки";
   private static final String f_4485 = "Призрак";
   private static final String f_4486 = "Количество";
   private static final float f_4487 = 15.0F;
   private static final float f_4488 = 5.0F;
   private static final float f_4489 = 50.0F;
   private static final String f_4490 = "Кол-во при тотеме";
   private static final float f_4491 = 30.0F;
   private static final float f_4492 = 10.0F;
   private static final float f_4493 = 100.0F;
   private static final String f_4494 = "Спавнить при";
   private static final String f_4495 = "Ударе";
   private static final String f_4496 = "Ходьбе";
   private static final String f_4497 = "Бездействии";
   private static final String f_4498 = "Перке";
   private static final String f_4499 = "Фейерверке";
   private static final String f_4500 = "Трезубце";
   private static final String f_4501 = "Стрелах";
   private static final String f_4502 = "Потери тотема";
   private static final String f_4503 = "Кол-во (бездействие)";
   private static final float f_4504 = 55.0F;
   private static final float f_4505 = 10.0F;
   private static final float f_4506 = 140.0F;
   private static final String f_4507 = "Радиус (бездействие)";
   private static final float f_4508 = 16.0F;
   private static final float f_4509 = 4.0F;
   private static final float f_4510 = 35.0F;
   private static final String f_4511 = "Время (мс)";
   private static final float f_4512 = 3500.0F;
   private static final float f_4513 = 1000.0F;
   private static final float f_4514 = 9000.0F;
   private static final float f_4515 = 250.0F;
   private static final String f_4516 = "Рандомный цвет";
   private static final String f_4517 = "energy";
   private static final String f_4518 = "images/particles/firefly.png";
   private static final String f_4519 = "energy";
   private static final String f_4520 = "images/particles/star.png";
   private static final String f_4521 = "energy";
   private static final String f_4522 = "images/particles/snow1.png";
   private static final String f_4523 = "energy";
   private static final String f_4524 = "images/particles/crown.png";
   private static final String f_4525 = "energy";
   private static final String f_4526 = "images/particles/dollar.png";
   private static final String f_4527 = "energy";
   private static final String f_4528 = "images/particles/heart.png";
   private static final String f_4529 = "energy";
   private static final String f_4530 = "images/particles/rhombus.png";
   private static final String f_4531 = "energy";
   private static final String f_4532 = "images/particles/pumpkin.png";
   private static final String f_4533 = "energy";
   private static final String f_4534 = "images/particles/ghost.png";
   private static final String f_4535 = "Потери тотема";
   private static final double f_4536 = 2.0;
   private static final double f_4537 = 0.5;
   private static final double f_4538 = 0.5;
   private static final double f_4539 = 0.5;
   private static final double f_4540 = 0.8;
   private static final double f_4541 = 0.5;
   private static final double f_4542 = 0.5;
   private static final double f_4543 = 55.0;
   private static final double f_4544 = 80.0;
   private static final double f_4545 = 50.0;
   private static final String f_4546 = "Ударе";
   private static final float f_4547 = 5.0F;
   private static final double f_4548 = 0.5;
   private static final double f_4549 = 0.005;
   private static final double f_4550 = 0.005;
   private static final double f_4551 = 0.005;
   private static final String f_4552 = "Ходьбе";
   private static final double f_4553 = -0.6;
   private static final double f_4554 = 0.6;
   private static final double f_4555 = -0.6;
   private static final double f_4556 = 0.6;
   private static final double f_4557 = 0.01;
   private static final double f_4558 = -0.005;
   private static final double f_4559 = 0.005;
   private static final double f_4560 = 0.01;
   private static final double f_4561 = 0.01;
   private static final double f_4562 = -0.005;
   private static final double f_4563 = 0.005;
   private static final String f_4564 = "Перке";
   private static final double f_4565 = 0.45;
   private static final double f_4566 = Math.PI * 2;
   private static final double f_4567 = 0.12;
   private static final double f_4568 = 0.003;
   private static final double f_4569 = 0.004;
   private static final double f_4570 = 0.003;
   private static final double f_4571 = Math.PI / 3;
   private static final String f_4572 = "Фейерверке";
   private static final double f_4573 = -0.5;
   private static final double f_4574 = 0.5;
   private static final double f_4575 = 0.5;
   private static final double f_4576 = -0.5;
   private static final double f_4577 = 0.5;
   private static final double f_4578 = -0.01;
   private static final double f_4579 = 0.01;
   private static final double f_4580 = -0.01;
   private static final double f_4581 = 0.01;
   private static final double f_4582 = -0.01;
   private static final double f_4583 = 0.01;
   private static final String f_4584 = "Трезубце";
   private static final double f_4585 = -0.3;
   private static final double f_4586 = 0.3;
   private static final double f_4587 = 0.3;
   private static final double f_4588 = -0.3;
   private static final double f_4589 = 0.3;
   private static final double f_4590 = 0.005;
   private static final double f_4591 = 0.005;
   private static final double f_4592 = 0.005;
   private static final String f_4593 = "Стрелах";
   private static final double f_4594 = -0.2;
   private static final double f_4595 = 0.2;
   private static final double f_4596 = 0.2;
   private static final double f_4597 = -0.2;
   private static final double f_4598 = 0.2;
   private static final double f_4599 = 0.003;
   private static final double f_4600 = 0.003;
   private static final double f_4601 = 0.003;
   private static final double f_4602 = 4.0;
   private static final double f_4603 = 16.0;
   private static final float f_4604 = 0.2F;
   private static final long f_4605 = -1L;
   private static final long f_4606 = -1L;
   private static final float f_4607 = 0.8F;
   private static final long f_4608 = -1L;
   private static final float f_4609 = 0.9F;
   private static final String f_4610 = "Комок";
   private static final String f_4611 = "Звезда";
   private static final String f_4612 = "Снежинка";
   private static final String f_4613 = "Корона";
   private static final String f_4614 = "Доллар";
   private static final String f_4615 = "Сердце";
   private static final String f_4616 = "Ромб";
   private static final String f_4617 = "Тыковки";
   private static final String f_4618 = "Призрак";
   private static final double f_4619 = 600.0;
   private static final double f_4620 = 0.4;
   private static final double f_4621 = 700.0;
   private static final double f_4622 = 0.3;
   private static final double f_4623 = Math.PI;
   private static final double f_4624 = 2.0;
   private static final double f_4625 = 3.0;
   private static final double f_4626 = 2.0;
   private static final double f_4627 = 0.4;
   private static final double f_4628 = 1.2;
   private static final double f_4629 = 3.0;
   private static final double f_4630 = 2.0;
   private static final double f_4631 = 255.0;
   private static final double f_4632 = 500.0;
   private static final double f_4633 = 255.0;
   private static final long f_4634 = 3000L;
   private static final long f_4635 = 2000L;
   private static final String f_4636 = "Комок";
   private static final String f_4637 = "Бездействии";
   private static final double f_4638 = Math.PI;
   private static final double f_4639 = 2.0;
   private static final double f_4640 = 2.0;
   private static final double f_4641 = 0.35;
   private static final double f_4642 = 0.65;
   private static final double f_4643 = 0.6;
   private static final double f_4644 = 4000.0;
   private static final double f_4645 = 3500.0;
   private static final double f_4646 = 5000.0;
   private static final String f_4647 = "Бездействии";
   private static final String f_4648 = "Бездействии";
   private static final String f_4649 = "Бездействии";

   private void m_1168() {
      String var2 = this.f_4453.m_3862();

      Identifier var1 = switch (var2) {
         case f_4610 -> this.f_4465;
         case f_4611 -> this.f_4466;
         case f_4612 -> this.f_4467;
         case f_4613 -> this.f_4468;
         case f_4614 -> this.f_4469;
         case f_4615 -> this.f_4470;
         case f_4616 -> this.f_4471;
         case f_4617 -> this.f_4472;
         case f_4618 -> this.f_4473;
         default -> this.f_4466;
      };
      Util114.m_2037(0, var1);
   }

   @EventHandler
   private void m_289(Util166 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (this.f_4456.I(f_4552)) {
            Vec3d var2 = new Vec3d(f_5909.player.lastX, f_5909.player.lastY, f_5909.player.lastZ);
            Vec3d var3 = f_5909.player.getEntityPos();
            if (!var2.equals(var3)) {
               Vec3d var4 = f_5909.player.getVelocity();
               this.f_4461
                  .add(
                     new Util141(
                        new Vec3d(
                           f_5909.player.getX() + RenderUtil14.m_2473(f_4553, f_4554),
                           f_5909.player.getY() + RenderUtil14.m_2473(0.0, f_5909.player.getHeight()),
                           f_5909.player.getZ() + RenderUtil14.m_2473(f_4555, f_4556)
                        ),
                        new Vec3d(var4.x * f_4557 + RenderUtil14.m_2473(f_4558, f_4559), f_4560, var4.z * f_4561 + RenderUtil14.m_2473(f_4562, f_4563)),
                        this.f_4461.size(),
                        Util71.m_1563()
                     )
                  );
            }
         }

         if (this.f_4456.I(f_4564)) {
            for (Entity var27 : f_5909.world.getEntities()) {
               if (var27 instanceof EnderPearlEntity var32) {
                  int var5 = var32.getId();
                  double var6 = this.f_4464.getOrDefault(var5, 0.0);
                  double var8 = f_4565;
                  byte var10 = 4;
                  double var11 = f_4566 / var10;

                  for (int var13 = 0; var13 < var10; var13++) {
                     double var14 = var6 + var13 * var11;
                     double var16 = var8 * Math.cos(var14);
                     double var18 = var8 * Math.sin(var14);
                     double var20 = var13 * f_4567;
                     this.f_4461
                        .add(
                           new Util141(
                              new Vec3d(var32.getX() + var16, var32.getY() + var20, var32.getZ() + var18),
                              new Vec3d(Math.cos(var14) * f_4568, f_4569, Math.sin(var14) * f_4570),
                              this.f_4461.size(),
                              Util71.m_1563()
                           )
                        );
                  }

                  this.f_4464.put(var5, var6 + f_4571);
               }
            }

            this.f_4464.entrySet().removeIf(var0 -> {
               Entity var1x = f_5909.world.getEntityById(var0.getKey());
               return var1x == null || !(var1x instanceof EnderPearlEntity);
            });
         }

         if (this.f_4456.I(f_4572)) {
            for (Entity var28 : f_5909.world.getEntities()) {
               if (var28 instanceof FireworkRocketEntity var33) {
                  this.f_4461
                     .add(
                        new Util141(
                           new Vec3d(
                              var33.getX() + RenderUtil14.m_2473(f_4573, f_4574),
                              var33.getY() + RenderUtil14.m_2473(0.0, f_4575),
                              var33.getZ() + RenderUtil14.m_2473(f_4576, f_4577)
                           ),
                           new Vec3d(RenderUtil14.m_2473(f_4578, f_4579), RenderUtil14.m_2473(f_4580, f_4581), RenderUtil14.m_2473(f_4582, f_4583)),
                           this.f_4461.size(),
                           Util71.m_1563()
                        )
                     );
               }
            }
         }

         if (this.f_4456.I(f_4584)) {
            for (Entity var29 : f_5909.world.getEntities()) {
               if (var29 instanceof TridentEntity var34) {
                  Vec3d var36 = var34.getVelocity();
                  this.f_4461
                     .add(
                        new Util141(
                           new Vec3d(
                              var34.getX() + RenderUtil14.m_2473(f_4585, f_4586),
                              var34.getY() + RenderUtil14.m_2473(0.0, f_4587),
                              var34.getZ() + RenderUtil14.m_2473(f_4588, f_4589)
                           ),
                           new Vec3d(var36.x * f_4590, var36.y * f_4591, var36.z * f_4592),
                           this.f_4461.size(),
                           Util71.m_1563()
                        )
                     );
               }
            }
         }

         if (this.f_4456.I(f_4593)) {
            for (Entity var30 : f_5909.world.getEntities()) {
               if (var30 instanceof ArrowEntity var35) {
                  Vec3d var37 = var35.getVelocity();
                  this.f_4461
                     .add(
                        new Util141(
                           new Vec3d(
                              var35.getX() + RenderUtil14.m_2473(f_4594, f_4595),
                              var35.getY() + RenderUtil14.m_2473(0.0, f_4596),
                              var35.getZ() + RenderUtil14.m_2473(f_4597, f_4598)
                           ),
                           new Vec3d(var37.x * f_4599, var37.y * f_4600, var37.z * f_4601),
                           this.f_4461.size(),
                           Util71.m_1563()
                        )
                     );
               }
            }
         }

         this.l.removeIf(var0 -> var0.m_2301().m_2884(f_4646));
         this.f_4461.removeIf(var0 -> var0.m_2301().m_2884(f_4645));
         this.f_4462.removeIf(var0 -> var0.m_2301().m_2884(f_4644));
         float var26 = this.f_4459.m_4046();
         double var31 = this.f_4458.m_4046() * f_4602 + f_4603;
         double var38 = var31 * var31;
         this.f_4463.removeIf(var3x -> var3x.m_2301().m_2884(var26) || f_5909.player.squaredDistanceTo(var3x.m_1622(), var3x.m_2363(), var3x.m_3616()) > var38);
         this.m_2763();
      }
   }

   @EventHandler
   private void m_1671(EventAttack var1) {
      if (this.f_4456.I(f_4546)) {
         Entity var2 = var1.m_1070();
         float var3 = f_4547;

         for (int var4 = 0; var4 < this.f_4454.m_134().intValue(); var4++) {
            this.l
               .add(
                  new Util141(
                     new Vec3d(var2.getX(), var2.getY() + f_4548 + RenderUtil14.m_2473(0.0, var2.getHeight()), var2.getZ()),
                     new Vec3d(RenderUtil14.m_2473(-var3, var3) * f_4549, RenderUtil14.m_2473(0.0, var3) * f_4550, RenderUtil14.m_2473(-var3, var3) * f_4551),
                     this.l.size(),
                     Util71.m_1563()
                  )
               );
         }
      }
   }

   private void m_1839(LivingEntity var1) {
      int var2 = this.f_4455.m_134().intValue();
      double var3 = var1.getX();
      double var5 = var1.getY() + var1.getHeight() / f_4536;
      double var7 = var1.getZ();

      for (int var9 = 0; var9 < var2; var9++) {
         double var10 = (Math.random() - f_4537) * f_4538;
         double var12 = (Math.random() - f_4539) * var1.getHeight() * f_4540;
         double var14 = (Math.random() - f_4541) * f_4542;
         Vec3d var16 = new Vec3d(var3 + var10, var5 + var12, var7 + var14);
         int var17 = 200 + (int)(Math.random() * f_4543);
         int var18 = (int)(Math.random() * f_4544);
         int var19 = (int)(Math.random() * f_4545);
         int var20 = Util71.m_1415(var18, var17, var19);
         this.f_4462.add(Util141.m_1301(var16, this.f_4462.size(), var20));
      }
   }

   private void m_3090(MatrixStack var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8, int var9) {
      Matrix4f var10 = var1.peek().getPositionMatrix();
      Util114.m_3784(RenderUtil7.f_13886);
      Tessellator var11 = Tessellator.getInstance();
      BufferBuilder var12 = var11.begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      float[] var13 = Util71.m_2326(var6);
      float[] var14 = Util71.m_2326(var7);
      float[] var15 = Util71.m_2326(var8);
      float[] var16 = Util71.m_2326(var9);
      var12.vertex(var10, var2, var3, 0.0F).texture(0.0F, 0.0F).color(var13[0], var13[1], var13[2], var13[3]);
      var12.vertex(var10, var4, var3, 0.0F).texture(1.0F, 0.0F).color(var14[0], var14[1], var14[2], var14[3]);
      var12.vertex(var10, var4, var5, 0.0F).texture(1.0F, 1.0F).color(var15[0], var15[1], var15[2], var15[3]);
      var12.vertex(var10, var2, var5, 0.0F).texture(0.0F, 1.0F).color(var16[0], var16[1], var16[2], var16[3]);
      RenderUtil12.I(var12.end());
   }

   @EventHandler
   private void m_3353(Util66 var1) {
      if (this.f_4456.I(f_4535)) {
         if (f_5909.world != null) {
            if (var1.m_2068()
               && var1.m_3295() instanceof EntityStatusS2CPacket var2
               && var2.getStatus() == 35
               && var2.getEntity(f_5909.world) instanceof LivingEntity var4) {
               this.m_1839(var4);
            }
         }
      }
   }

   private Util141 m_1992(float var1) {
      double var2 = f_5909.player.getEyeY();
      double var4 = f_5909.player.getX();
      double var6 = f_5909.player.getZ();

      for (int var8 = 0; var8 < 8; var8++) {
         double var9 = Math.random() * f_4638 * f_4639;
         double var11 = Math.random() * f_4640 - 1.0;
         double var13 = var1 * (f_4641 + f_4642 * Math.cbrt(Math.random()));
         double var15 = Math.sqrt(Math.max(0.0, 1.0 - var11 * var11));
         double var17 = var4 + var13 * var15 * Math.cos(var9);
         double var19 = var6 + var13 * var15 * Math.sin(var9);
         double var21 = var2 + var13 * var11 * f_4643;
         if (f_5909.world.getBlockState(BlockPos.ofFloored(var17, var21, var19)).isAir()) {
            return Util141.m_2532(new Vec3d(var17, var21, var19), this.f_4463.size(), Util71.m_1563(), var1);
         }
      }

      return null;
   }

   private void m_2032(MatrixStack var1, Camera var2, List<Util141> var3, float var4, boolean var5, long var6) {
      if (!var3.isEmpty()) {
         var3.forEach(Util141::m_2516);
         Vec3d var8 = var2.getCameraPos();

         for (Util141 var10 : var3) {
            double var11 = var10.m_1622() - var8.x;
            double var13 = var10.m_2363() - var8.y;
            double var15 = var10.m_3616() - var8.z;
            int var17;
            if (var6 > 0L) {
               double var18 = var10.m_2301().m_1913();
               double var20 = Math.min(f_4619, var6 * f_4620);
               double var22 = Math.min(f_4621, var6 * f_4622);
               double var24 = Math.min(1.0, var18 / var20);
               double var26 = Math.max(0.0, Math.min(1.0, (var6 - var18) / var22));
               double var28 = Math.sin(var24 * f_4623 / f_4624) * (var26 * var26 * (f_4625 - f_4626 * var26));
               double var30 = Math.sqrt(var11 * var11 + var13 * var13 + var15 * var15);
               double var32 = Math.max(0.0, Math.min(1.0, (var30 - f_4627) / f_4628));
               double var34 = var32 * var32 * (f_4629 - f_4630 * var32);
               var17 = (int)(f_4631 * var28 * var34 * var10.m_597());
            } else {
               if ((int)var10.m_3687().m_2276() != 128 && !var10.m_2301().m_2884(f_4632)) {
                  var10.m_3687().m_3631(f_4633);
               }

               long var36 = var5 ? f_4634 : f_4635;
               boolean var38 = var10.m_2301().m_2884(var36);
               if ((int)var10.m_3687().m_2276() != 0 && var38) {
                  var10.m_3687().m_3631(0.0);
               }

               var17 = (int)(var10.m_3687().m_2276() * var10.m_597());
            }

            if (var17 > 0) {
               int var19;
               int var37;
               if (var5) {
                  var37 = Util71.m_3389(var10.m_2431(), var17);
                  var19 = Util71.m_3389(Util71.m_1415(150, 255, 150), var17);
               } else if (this.f_4460.m_1163()) {
                  var37 = Util71.m_3389(var10.m_2431(), var17);
                  var19 = var37;
               } else {
                  var37 = Util71.m_3389(EnergyClient.getTheme(0), var17);
                  var19 = Util71.m_3389(EnergyClient.getTheme(90), var17);
               }

               var1.push();
               var1.translate(var11, var13, var15);
               var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-var2.getYaw()));
               var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var2.getPitch()));
               var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var10.m_2787()));
               float var39 = var4 * var10.m_3147();
               var1.translate(0.0F, var39 / 2.0F, 0.0F);
               int var21 = var5 ? 3 : 2;

               for (int var40 = 0; var40 < var21; var40++) {
                  this.m_3090(var1, -var39, -var39, var39, var39, var37, var19, var37, var19);
               }

               float var41 = var39 / 2.0F;
               int var23 = Util71.m_3389(-1, var17);
               if (this.f_4453.m_2073(f_4636) || var5) {
                  this.m_3090(var1, -var41, -var41, var41, var41, var23, var23, var23, var23);
               }

               var1.pop();
            }
         }
      }
   }

   private void m_2763() {
      if (this.f_4456.I(f_4637)) {
         int var1 = this.f_4457.m_134().intValue();
         int var2 = var1 - this.f_4463.size();
         if (var2 > 0) {
            float var3 = this.f_4458.m_4046();
            int var4 = Math.min(3, var2);

            for (int var5 = 0; var5 < var4; var5++) {
               Util141 var6 = this.m_1992(var3);
               if (var6 != null) {
                  this.f_4463.add(var6);
               }
            }
         }
      }
   }

   @Override
   public void m_2() {
      super.m_2();
      this.l.clear();
      this.f_4461.clear();
      this.f_4462.clear();
      this.f_4463.clear();
      this.f_4464.clear();
   }

   public Particles() {
      super(f_4474, "", Category.RENDER);
      this.f_4453 = new ModeSetting(f_4475, f_4476, f_4477, f_4478, f_4479, f_4480, f_4481, f_4482, f_4483, f_4484, f_4485);
      this.f_4454 = new NumberSetting(f_4486, f_4487, f_4488, f_4489, 1.0F);
      this.f_4455 = new NumberSetting(f_4490, f_4491, f_4492, f_4493, 1.0F);
      this.f_4456 = new Util63(
         f_4494,
         new BooleanSetting(f_4495, true),
         new BooleanSetting(f_4496, false),
         new BooleanSetting(f_4497, true),
         new BooleanSetting(f_4498, true),
         new BooleanSetting(f_4499, false),
         new BooleanSetting(f_4500, false),
         new BooleanSetting(f_4501, false),
         new BooleanSetting(f_4502, true)
      );
      this.f_4457 = new NumberSetting(f_4503, f_4504, f_4505, f_4506, 1.0F).m_356(() -> this.f_4456.I(f_4649));
      this.f_4458 = new NumberSetting(f_4507, f_4508, f_4509, f_4510, 1.0F).m_356(() -> this.f_4456.I(f_4648));
      this.f_4459 = new NumberSetting(f_4511, f_4512, f_4513, f_4514, f_4515).m_356(() -> this.f_4456.I(f_4647));
      this.f_4460 = new BooleanSetting(f_4516, false);
      this.l = new ObjectArrayList();
      this.f_4461 = new ObjectArrayList();
      this.f_4462 = new ObjectArrayList();
      this.f_4463 = new ObjectArrayList();
      this.f_4464 = new HashMap<>();
      this.f_4465 = Identifier.of(f_4517, f_4518);
      this.f_4466 = Identifier.of(f_4519, f_4520);
      this.f_4467 = Identifier.of(f_4521, f_4522);
      this.f_4468 = Identifier.of(f_4523, f_4524);
      this.f_4469 = Identifier.of(f_4525, f_4526);
      this.f_4470 = Identifier.of(f_4527, f_4528);
      this.f_4471 = Identifier.of(f_4529, f_4530);
      this.f_4472 = Identifier.of(f_4531, f_4532);
      this.f_4473 = Identifier.of(f_4533, f_4534);
   }

   @EventHandler
   private void m_372(Util88 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         MatrixStack var2 = var1.m_213();
         Camera var3 = f_5909.gameRenderer.getCamera();
         var2.push();
         Util114.m_1481();
         Util114.m_100();
         Util114.m_3188(515);
         Util114.m_1878(false);
         Util114.m_3978();
         Util114.m_582(770, 1);
         float var4 = f_4604;
         this.m_1168();
         this.m_2032(var2, var3, this.l, var4, false, f_4605);
         this.m_2032(var2, var3, this.f_4461, var4, false, f_4606);
         this.m_2032(var2, var3, this.f_4462, var4 * f_4607, true, f_4608);
         this.m_2032(var2, var3, this.f_4463, var4 * f_4609, false, (long)this.f_4459.m_4046());
         Util114.m_542();
         Util114.m_1562();
         Util114.m_1878(true);
         Util114.m_963();
         var2.pop();
      }
   }
}
