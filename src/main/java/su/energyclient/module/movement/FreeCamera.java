package su.energyclient.module.movement;

import net.minecraft.client.option.Perspective;
import net.minecraft.item.BlockItem;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.glfw.GLFW;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventFreecamWorldRender;
import su.energyclient.event.impl.EventMouseOver;
import su.energyclient.event.impl.EventThirdPersonDistance;
import su.energyclient.event.impl.EventThirdPersonRender;
import su.energyclient.mixin.PlayerInteractEntityC2SPacketMixin;
import su.energyclient.mixin.PlayerMoveC2SPacketMixin;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util10;
import su.energyclient.util.Util121;
import su.energyclient.util.Util170;
import su.energyclient.util.Util173;
import su.energyclient.util.Util19;
import su.energyclient.util.Util54;
import su.energyclient.util.Util66;

public class FreeCamera extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final NumberSetting f_10;
   private final BooleanSetting f_11;
   private final BooleanSetting f_12;
   private Vec3d f_13;
   private Vec3d f_14;
   private Vec2f f_15;
   private Perspective f_16;
   private Vec3d f_17;
   private float f_18;
   private float f_19;
   private boolean f_20;
   private static final String f_21 = "Free Camera";
   private static final String f_22 = "Позволяет перемещаться в свободной камере";
   private static final String f_23 = "Скорость";
   private static final float f_24 = 0.1F;
   private static final float f_25 = 0.1F;
   private static final String f_26 = "Подменять взаимодействие";
   private static final String f_27 = "Заморозить игрока";
   private static final float f_28 = 360.0F;
   private static final float f_29 = (float) (Math.PI / 180.0);

   @EventHandler
   public void m_3505(Util170 var1) {
      Util54.m_3501(new Util10(f_5909.player.getYaw(), f_5909.player.getPitch()), f_28, 1, 1);
      this.f_13 = this.f_14;
      f_5909.options.setPerspective(Perspective.THIRD_PERSON_BACK);
      if (this.f_15 != null) {
         double var2 = this.f_10.m_4046();
         float var4 = this.f_15.x;
         float var5 = var4 * f_29;
         Vec3d var6 = new Vec3d(-Math.sin(var5), 0.0, Math.cos(var5));
         Vec3d var7 = new Vec3d(Math.cos(var5), 0.0, Math.sin(var5));
         Vec3d var8 = new Vec3d(0.0, 1.0, 0.0);
         if (f_5909.options.forwardKey.isPressed()) {
            this.f_14 = this.f_14.add(var6.multiply(var2));
         }

         if (f_5909.options.backKey.isPressed()) {
            this.f_14 = this.f_14.subtract(var6.multiply(var2));
         }

         if (f_5909.options.leftKey.isPressed()) {
            this.f_14 = this.f_14.add(var7.multiply(var2));
         }

         if (f_5909.options.rightKey.isPressed()) {
            this.f_14 = this.f_14.subtract(var7.multiply(var2));
         }

         if (f_5909.options.jumpKey.isPressed()) {
            this.f_14 = this.f_14.add(var8.multiply(var2));
         }

         if (f_5909.options.sneakKey.isPressed()) {
            this.f_14 = this.f_14.subtract(var8.multiply(var2));
         }
      }
   }

   @Override
   public void m_2() {
      super.m_2();
      if (f_5909.player == null) {
         this.m_680();
      } else {
         this.f_17 = f_5909.player.getEntityPos();
         this.f_18 = f_5909.player.getYaw();
         this.f_19 = f_5909.player.getPitch();
         this.f_20 = f_5909.player.isOnGround();
         this.f_14 = f_5909.player.getCameraPosVec(f_5909.getRenderTickCounter().getTickProgress(true));
         this.f_13 = this.f_14;
         this.f_16 = f_5909.options.getPerspective();
      }
   }

   @EventHandler
   public void m_4055(EventMouseOver var1) {
      if (this.f_11.m_1163()) {
         if (this.f_14 != null) {
            var1.m_3310(this.f_14);
         }

         if (this.f_15 != null) {
            var1.m_1496(this.f_15);
         }
      }
   }

   @EventHandler
   public void m_2886(Util173 var1) {
      this.f_15 = var1.m_556();
      Vec3d var2 = this.f_13 == null ? this.f_14 : this.f_13.add(this.f_14.subtract(this.f_13).multiply(f_5909.getRenderTickCounter().getTickProgress(true)));
      var1.m_1672(var2);
   }

   @EventHandler
   public void m_3145(EventFreecamWorldRender var1) {
      var1.m_3732(true);
   }

   @EventHandler
   public void m_483(Util121 var1) {
      if (this.f_14 != null) {
         if (this.f_12.m_1163()) {
            var1.m_433(0.0F);
            var1.m_2791(0.0F);
            var1.m_564(false);
            var1.m_1269(false);
         } else {
            long var2 = f_5909.getWindow().getHandle();
            float var4 = 0.0F;
            if (GLFW.glfwGetKey(var2, 265) == 1) {
               var4++;
            }

            if (GLFW.glfwGetKey(var2, 264) == 1) {
               var4--;
            }

            float var5 = 0.0F;
            if (GLFW.glfwGetKey(var2, 263) == 1) {
               var5++;
            }

            if (GLFW.glfwGetKey(var2, 262) == 1) {
               var5--;
            }

            var1.m_433(var4);
            var1.m_2791(var5);
            var1.m_564(false);
            var1.m_1269(false);
         }
      }
   }

   @EventHandler
   private void m_1664(Util66 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         if (var1.m_3295() instanceof PlayerInteractEntityC2SPacket var2) {
            int var5 = ((PlayerInteractEntityC2SPacketMixin)var2).getEntityId();
            if (var5 == f_5909.player.getId()) {
               var1.m_277(true);
            }
         }

         if (var1.m_3295() instanceof GameJoinS2CPacket) {
            this.m_680();
         }

         if (var1.m_3295() instanceof PlayerInteractBlockC2SPacket && !(f_5909.player.getMainHandStack().getItem() instanceof BlockItem)) {
            var1.m_277(true);
         }

         if (this.f_12.m_1163() && this.f_17 != null && var1.m_3295() instanceof PlayerMoveC2SPacket var4) {
            PlayerMoveC2SPacketMixin var7 = (PlayerMoveC2SPacketMixin)var4;
            if (var7.isChangingPosition()) {
               var7.setX(this.f_17.x);
               var7.setY(this.f_17.y);
               var7.setZ(this.f_17.z);
            }

            var7.setOnGround(this.f_20);
            if (var7.isChangingLook()) {
               var7.setYaw(this.f_18);
               var7.setPitch(this.f_19);
            }
         }
      } else {
         this.m_680();
      }
   }

   @Override
   public void m_1() {
      super.m_1();
      this.f_14 = null;
      this.f_13 = null;
      this.f_17 = null;
      f_5909.options.setPerspective(this.f_16);
   }

   public FreeCamera() {
      super(f_21, f_22, Category.MOVEMENT);
      this.f_10 = new NumberSetting(f_23, 1.0F, f_24, 2.0F, f_25);
      this.f_11 = new BooleanSetting(f_26, true);
      this.f_12 = new BooleanSetting(f_27, true);
      this.f_16 = Perspective.FIRST_PERSON;
   }

   public Vec3d m_2713(float var1) {
      if (this.f_13 == null) {
         return this.f_14;
      } else {
         double var2 = this.f_13.x + (this.f_14.x - this.f_13.x) * var1;
         double var4 = this.f_13.y + (this.f_14.y - this.f_13.y) * var1;
         double var6 = this.f_13.z + (this.f_14.z - this.f_13.z) * var1;
         return new Vec3d(var2, var4, var6);
      }
   }

   @EventHandler
   public void m_1666(Util19 var1) {
      var1.m_277(true);
   }

   @EventHandler
   public void m_2866(EventThirdPersonRender var1) {
      var1.m_957(true);
   }

   @EventHandler
   public void m_3096(EventThirdPersonDistance var1) {
      var1.m_4098(0.0F);
   }
}
