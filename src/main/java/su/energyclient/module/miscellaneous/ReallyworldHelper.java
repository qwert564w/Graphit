package su.energyclient.module.miscellaneous;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.network.packet.s2c.play.OpenScreenS2CPacket;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import su.energyclient.EnergyClient;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil22;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util121;
import su.energyclient.util.Util146;
import su.energyclient.util.Util152;
import su.energyclient.util.Util153;
import su.energyclient.util.Util165;
import su.energyclient.util.Util170;
import su.energyclient.util.Util66;
import su.energyclient.util.Util88;

public class ReallyworldHelper extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final RenderUtil22 f_7357;
   private final RenderUtil22 f_7358;
   private final RenderUtil22 f_7359;
   private final BooleanSetting f_7360;
   private final BooleanSetting f_7361;
   private final BooleanSetting f_7362;
   private static final float f_7363 = 16.0F;
   private final Util165 f_7364;
   private final Set<String> f_7365;
   private boolean f_7366;
   private boolean f_7367;
   private int f_7368;
   private int f_7369;
   private static final String f_7370 = "ReallyWorld Helper";
   private static final String f_7371 = "Помощник для сервера ReallyWorld";
   private static final String f_7372 = "Бинд ловушки";
   private static final String f_7373 = "Бинд эндер - ловушки";
   private static final String f_7374 = "Бинд анти-полёта";
   private static final String f_7375 = "Закрывать меню";
   private static final String f_7376 = "Фильтр чата";
   private static final String f_7377 = "Радиус анти-полёта";
   private static final long f_7378 = 350L;
   private static final String f_7379 = "акриен(а|у|ом|е|чик)?";
   private static final String f_7380 = "рич(а|у|ом|ей|е)?";
   private static final String f_7381 = "ньюкод(ом|а|у|ами|ик|е)?";
   private static final String f_7382 = "экспенсив(ом|а|у|ами|е)?";
   private static final String f_7383 = "импакт(ом|а|у|ами|ик|е)?";
   private static final String f_7384 = "экселлент(ом|а|у|ами|ик|е)?";
   private static final String f_7385 = "экселент(ом|а|у|ами|ик)?";
   private static final String f_7386 = "катлаван(ом|а|у|ами|чик)?";
   private static final String f_7387 = "катлован(ом|а|у|ами|чик)?";
   private static final String f_7388 = "целестиал(ом|а|у|ами|е)?";
   private static final String f_7389 = "целк(ой|а|у|ами|очка|е)?";
   private static final String f_7390 = "матикс(ом|а|у|ами|е)?";
   private static final String f_7391 = "инерти(я|ей|ю|ями|е)?";
   private static final String f_7392 = "эксп(а|ой|ою|у|уличка|е)?";
   private static final String f_7393 = "флюгер(ом|а|у|ами)?";
   private static final String f_7394 = "рикер(а|у|ом|очек)?";
   private static final String f_7395 = "фанпе(й|ю|я|ем|е|йчик)?";
   private static final String f_7396 = "вексайд(ом|а|у|ами|ик|е)?";
   private static final String f_7397 = "нурсултан(а|у|е|ом|чик)?";
   private static final String f_7398 = "нурик(а|у|ом|е)?";
   private static final String f_7399 = "нурлан(а|у|ом|чик|е)?";
   private static final String f_7400 = "векс(ом|у|а|ами|ик|е)?";
   private static final String f_7401 = "релейк(ом|у|а|ами|е)?";
   private static final String f_7402 = "арбуз(ом|а|у|ами|ик|е)?";
   private static final String f_7403 = "вилд(ом|у|а|ами|ик|е)?";
   private static final String f_7404 = "фантайм(е|а|у)?";
   private static final String f_7405 = "холик(е|а|у)?";
   private static final String f_7406 = "холиворлд(а|у|е)?";
   private static final String f_7407 = "рокстар(ом|а|у|ами|чик|е)?";
   private static final String f_7408 = "рогалик(а|у|ом|е)?";
   private static final String f_7409 = "тандерхак(ом|у|и|ами|а|е)?";
   private static final String f_7410 = "ликвидбаунс(а|у|ами|е)?";
   private static final String f_7411 = "expensive";
   private static final String f_7412 = "celestial";
   private static final String f_7413 = "newcode";
   private static final String f_7414 = "arbuz";
   private static final String f_7415 = "akrien";
   private static final String f_7416 = "nursultan";
   private static final String f_7417 = "relake";
   private static final String f_7418 = "wild";
   private static final String f_7419 = "wurst";
   private static final String f_7420 = "catlovan";
   private static final String f_7421 = "excellent";
   private static final String f_7422 = "rockstar";
   private static final String f_7423 = "catlavan";
   private static final String f_7424 = "impact";
   private static final String f_7425 = "matix";
   private static final String f_7426 = "inertia";
   private static final String f_7427 = "wex";
   private static final String f_7428 = "wexside";
   private static final String f_7429 = "nurik";
   private static final String f_7430 = "nurlan";
   private static final String f_7431 = "rich";
   private static final String f_7432 = "funpay";
   private static final String f_7433 = "fluger";
   private static final String f_7434 = "riker";
   private static final String f_7435 = "funtime";
   private static final String f_7436 = "holyworld";
   private static final String f_7437 = "wwe";
   private static final String f_7438 = "hvh";
   private static final String f_7439 = "rogalik";
   private static final String f_7440 = "thunderhack";
   private static final String f_7441 = "liquidbounce";
   private static final String f_7442 = "Эндер Ловушка";
   private static final String f_7443 = "Анти Полет";
   private static final String f_7444 = "ꈁꀀꈂꌁꈂꀁ§0ꈃꄀ";
   private static final String f_7445 = "В вашем сообщении было найдено запретное слово, отправка сообщения отменена!";
   private static final float f_7446 = 0.01F;
   private static final String f_7447 = "Анти Полет";
   private static final float f_7448 = 16.0F;
   private static final float f_7449 = 0.5F;
   private static final float f_7450 = 0.5F;
   private static final float f_7451 = 600.0F;
   private static final long f_7452 = 3600L;
   private static final double f_7453 = 3600.0;
   private static final double f_7454 = Math.PI;
   private static final double f_7455 = 2.0;
   private static final float f_7456 = 255.0F;
   private static final float f_7457 = 255.0F;
   private static final float f_7458 = 255.0F;
   private static final float f_7459 = 15.6F;
   private static final float f_7460 = 0.18F;
   private static final float f_7461 = 0.22F;
   private static final float f_7462 = 0.1F;
   private static final double f_7463 = 0.03;
   private static final double f_7464 = 2.0;
   private static final double f_7465 = 72.0;
   private static final double f_7466 = Math.PI;
   private static final double f_7467 = 2.0;
   private static final double f_7468 = 72.0;
   private static final double f_7469 = Math.PI;
   private static final double f_7470 = 2.0;
   private static final float f_7471 = 16.0F;
   private static final float f_7472 = 16.0F;
   private static final float f_7473 = 16.0F;
   private static final float f_7474 = 16.0F;
   private static final float f_7475 = 0.55F;
   private static final float f_7476 = 0.55F;
   private static final double f_7477 = 0.02;
   private static final double f_7478 = 0.02;
   private static final float f_7479 = 0.5F;
   private static final float f_7480 = 0.5F;
   private static final float f_7481 = 0.3F;
   private static final float f_7482 = 0.3F;
   private static final float f_7483 = 1.8F;
   private static final float f_7484 = 0.55F;
   private static final float f_7485 = 0.3F;
   private static final double f_7486 = 72.0;
   private static final double f_7487 = Math.PI;
   private static final double f_7488 = 2.0;
   private static final double f_7489 = 72.0;
   private static final double f_7490 = Math.PI;
   private static final double f_7491 = 2.0;
   private static final float f_7492 = 16.0F;
   private static final float f_7493 = 16.0F;
   private static final float f_7494 = 16.0F;
   private static final float f_7495 = 16.0F;
   private static final float f_7496 = 0.35F;
   private static final float f_7497 = 0.35F;
   private static final float f_7498 = 0.22F;
   private static final float f_7499 = 0.6F;

   public ReallyworldHelper() {
      super(f_7370, f_7371, Category.MISCELLANEOUS);
      this.f_7357 = new RenderUtil22(f_7372, -1);
      this.f_7358 = new RenderUtil22(f_7373, -1);
      this.f_7359 = new RenderUtil22(f_7374, -1);
      this.f_7360 = new BooleanSetting(f_7375, false);
      this.f_7361 = new BooleanSetting(f_7376, false);
      this.f_7362 = new BooleanSetting(f_7377, false);
      this.f_7364 = new Util165(Util153.LINEAR, f_7378);
      this.f_7365 = new HashSet<>(
         Arrays.asList(
            f_7379,
            f_7380,
            f_7381,
            f_7382,
            f_7383,
            f_7384,
            f_7385,
            f_7386,
            f_7387,
            f_7388,
            f_7389,
            f_7390,
            f_7391,
            f_7392,
            f_7393,
            f_7394,
            f_7395,
            f_7396,
            f_7397,
            f_7398,
            f_7399,
            f_7400,
            f_7401,
            f_7402,
            f_7403,
            f_7404,
            f_7405,
            f_7406,
            f_7407,
            f_7408,
            f_7409,
            f_7410,
            f_7411,
            f_7412,
            f_7413,
            f_7414,
            f_7415,
            f_7416,
            f_7417,
            f_7418,
            f_7419,
            f_7420,
            f_7421,
            f_7422,
            f_7423,
            f_7424,
            f_7425,
            f_7426,
            f_7427,
            f_7428,
            f_7429,
            f_7430,
            f_7431,
            f_7432,
            f_7433,
            f_7434,
            f_7435,
            f_7436,
            f_7437,
            f_7438,
            f_7439,
            f_7440,
            f_7441
         )
      );
      this.f_7368 = 0;
      this.f_7369 = -1;
   }

   @EventHandler
   private void m_291(Util88 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         boolean var2 = this.f_7362.m_1163() && this.m_2250();
         this.f_7364.m_3631(var2 ? 1.0 : 0.0);
         float var3 = (float)this.f_7364.m_2276();
         if (!(var3 <= f_7446)) {
            this.m_2501(var1, var3);
         }
      }
   }

   private boolean m_586(ItemStack var1) {
      return var1 != null && !var1.isEmpty() && var1.getName().getString().contains(f_7447);
   }

   private void m_2501(Util88 var1, float var2) {
      MatrixStack var3 = var1.m_213();
      Vec3d var4 = f_5909.gameRenderer.getCamera().getCameraPos();
      Vec3d var5 = f_5909.player.getLerpedPos(var1.m_191());
      float var6 = f_7448;
      float var7 = 2.0F;
      byte var8 = 72;
      double var9 = var5.x - var4.x;
      double var11 = var5.y - var4.y;
      double var13 = var5.z - var4.z;
      long var15 = System.currentTimeMillis();
      float var17 = f_7449 + f_7450 * MathHelper.sin((float)var15 / f_7451);
      float var18 = (float)(var15 % f_7452 / f_7453 * f_7454 * f_7455);
      int var19 = EnergyClient.getTheme(0);
      float var20 = (var19 >> 16 & 0xFF) / f_7456;
      float var21 = (var19 >> 8 & 0xFF) / f_7457;
      float var22 = (var19 & 0xFF) / f_7458;
      Util114.m_1481();
      Util114.m_582(770, 1);
      Util114.m_3978();
      Util114.m_100();
      Util114.m_1878(false);
      Util114.m_3784(RenderUtil7.f_13885);
      Matrix4f var23 = var3.peek().getPositionMatrix();
      float var24 = Math.max(0.0F, f_7459);
      float var25 = (f_7460 + f_7461 * var17) * var2;
      float var26 = f_7462 * var2;
      double var27 = var11 + f_7463;
      double var29 = var11 + f_7464;
      BufferBuilder var31 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

      for (int var32 = 0; var32 < 72; var32++) {
         float var33 = (float)(var32 / f_7465 * f_7466 * f_7467);
         float var34 = (float)((var32 + 1) / f_7468 * f_7469 * f_7470);
         float var35 = MathHelper.cos(var33);
         float var36 = MathHelper.sin(var33);
         float var37 = MathHelper.cos(var34);
         float var38 = MathHelper.sin(var34);
         float var39 = this.m_890(var33, var18);
         float var40 = this.m_890(var34, var18);
         double var41 = var9 + var35 * f_7471;
         double var43 = var13 + var36 * f_7472;
         double var45 = var9 + var37 * f_7473;
         double var47 = var13 + var38 * f_7474;
         float var49 = this.m_3628(var26 + var39 * f_7475 * var2);
         float var50 = this.m_3628(var26 + var40 * f_7476 * var2);
         var31.vertex(var23, (float)var41, (float)(var11 + f_7477), (float)var43).color(var20, var21, var22, var49);
         var31.vertex(var23, (float)var45, (float)(var11 + f_7478), (float)var47).color(var20, var21, var22, var50);
         var31.vertex(var23, (float)var45, (float)var29, (float)var47).color(var20, var21, var22, 0.0F);
         var31.vertex(var23, (float)var41, (float)var29, (float)var43).color(var20, var21, var22, 0.0F);
         float var51 = this.m_3628(var25 + var39 * f_7479 * var2);
         float var52 = this.m_3628(var25 + var40 * f_7480 * var2);
         double var53 = var9 + var35 * var24;
         double var55 = var13 + var36 * var24;
         double var57 = var9 + var37 * var24;
         double var59 = var13 + var38 * var24;
         var31.vertex(var23, (float)var53, (float)var27, (float)var55).color(var20, var21, var22, var51 * f_7481);
         var31.vertex(var23, (float)var57, (float)var27, (float)var59).color(var20, var21, var22, var52 * f_7482);
         var31.vertex(var23, (float)var45, (float)var27, (float)var47).color(var20, var21, var22, var52);
         var31.vertex(var23, (float)var41, (float)var27, (float)var43).color(var20, var21, var22, var51);
      }

      BuiltBuffer var61 = var31.endNullable();
      if (var61 != null) {
         RenderUtil12.I(var61);
      }

      Util114.m_2977(f_7483);
      BufferBuilder var62 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
      float var63 = this.m_3628((f_7484 + f_7485 * var17) * var2);

      for (int var64 = 0; var64 < 72; var64++) {
         float var66 = (float)(var64 / f_7486 * f_7487 * f_7488);
         float var67 = (float)((var64 + 1) / f_7489 * f_7490 * f_7491);
         float var68 = MathHelper.cos(var66);
         float var69 = MathHelper.sin(var66);
         float var70 = MathHelper.cos(var67);
         float var71 = MathHelper.sin(var67);
         double var42 = var9 + var68 * f_7492;
         double var44 = var13 + var69 * f_7493;
         double var46 = var9 + var70 * f_7494;
         double var48 = var13 + var71 * f_7495;
         var62.vertex(var23, (float)var42, (float)var27, (float)var44).color(var20, var21, var22, var63);
         var62.vertex(var23, (float)var46, (float)var27, (float)var48).color(var20, var21, var22, var63);
         var62.vertex(var23, (float)var42, (float)var29, (float)var44).color(var20, var21, var22, var63 * f_7496);
         var62.vertex(var23, (float)var46, (float)var29, (float)var48).color(var20, var21, var22, var63 * f_7497);
         if (var64 % 6 == 0) {
            float var72 = this.m_3628((f_7498 + this.m_890(var66, var18) * f_7499) * var2);
            var62.vertex(var23, (float)var42, (float)var27, (float)var44).color(var20, var21, var22, var72);
            var62.vertex(var23, (float)var42, (float)var29, (float)var44).color(var20, var21, var22, 0.0F);
         }
      }

      BuiltBuffer var65 = var62.endNullable();
      if (var65 != null) {
         RenderUtil12.I(var65);
      }

      Util114.m_2977(1.0F);
      Util114.m_1878(true);
      Util114.m_542();
      Util114.m_1562();
      Util114.m_963();
   }

   private float m_3628(float var1) {
      return var1 < 0.0F ? 0.0F : (var1 > 1.0F ? 1.0F : var1);
   }

   private float m_890(float var1, float var2) {
      float var3 = MathHelper.cos(var1 - var2);
      if (var3 <= 0.0F) {
         return 0.0F;
      } else {
         var3 *= var3;
         var3 *= var3;
         return var3 * var3;
      }
   }

   @EventHandler
   private void m_803(Util66 var1) {
      if (var1.m_3295() instanceof OpenScreenS2CPacket var2 && this.f_7360.m_1163() && var2.getName().getString().contains(f_7444) && f_5909.player.age < 100) {
         f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(f_5909.player.currentScreenHandler.syncId));
         var1.m_277(true);
      }

      if (var1.m_3295() instanceof ChatMessageC2SPacket && this.f_7361.m_1163()) {
         String var6 = ((ChatMessageC2SPacket)var1.m_3295()).chatMessage().toLowerCase();
         boolean var7 = false;

         for (String var5 : this.f_7365) {
            if (var6.matches(".*" + var5 + ".*")) {
               var7 = true;
               break;
            }
         }

         if (var7) {
            var1.m_277(true);
            Util152.m_662(f_7445);
         }
      }
   }

   @EventHandler
   private void m_2766(Util170 var1) {
      if (this.f_7366) {
         Util146.m_2425(Items.HEART_OF_THE_SEA);
         this.f_7366 = false;
      }

      if (this.f_7368 > 0) {
         this.f_7368--;
         if (this.f_7368 == 0 && this.f_7369 != -1) {
            f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, this.f_7369, 40, SlotActionType.SWAP, f_5909.player);
            f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(f_5909.player.currentScreenHandler.syncId));
            this.f_7369 = -1;
         }
      }
   }

   @EventHandler
   private void m_2916(CancellableEvent var1) {
      if (!var1.m_3546()) {
         if (var1.m_2169() == this.f_7357.m_1958()) {
            this.f_7366 = true;
         }

         if (var1.m_2169() == this.f_7358.m_1958()) {
            int var2 = Util146.m_149(f_7442);
            if (f_5909.player.getInventory().getSelectedSlot() != var2) {
               if (var2 > 9) {
                  f_5909.interactionManager.clickSlot(0, var2, f_5909.player.getInventory().getSelectedSlot(), SlotActionType.SWAP, f_5909.player);
                  f_5909.interactionManager.interactItem(f_5909.player, Hand.OFF_HAND);
                  f_5909.interactionManager.clickSlot(0, var2, f_5909.player.getInventory().getSelectedSlot(), SlotActionType.SWAP, f_5909.player);
               } else {
                  f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(var2));
                  f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
                  f_5909.player.networkHandler.sendPacket(new UpdateSelectedSlotC2SPacket(f_5909.player.getInventory().getSelectedSlot()));
               }
            } else {
               f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
            }
         }

         if (var1.m_2169() == this.f_7359.m_1958() && var1.m_1362() && this.f_7368 == 0) {
            int var3 = Util146.m_149(f_7443);
            if (var3 != -1 && f_5909.player != null) {
               this.f_7369 = var3;
               f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, var3, 40, SlotActionType.SWAP, f_5909.player);
               f_5909.player.networkHandler.sendPacket(new CloseHandledScreenC2SPacket(f_5909.player.currentScreenHandler.syncId));
               this.f_7368 = 20;
            }
         }
      }
   }

   @EventHandler
   private void m_3775(Util121 var1) {
      if (this.f_7368 > 0) {
         var1.m_1269(true);
      }
   }

   private boolean m_2250() {
      return this.m_586(f_5909.player.getMainHandStack()) || this.m_586(f_5909.player.getOffHandStack());
   }
}
