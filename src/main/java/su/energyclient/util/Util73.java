package su.energyclient.util;

import java.util.ArrayList;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.entity.EntityType;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import su.energyclient.render.RenderUtil3;
import su.energyclient.render.RenderUtil5;

public final class Util73 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_9380 = 4.0F;
   private static final float f_9381 = 4.0F;
   private static final float f_9382 = 0.9F;
   private static final float f_9383 = 0.6F;
   private static final float f_9384 = 1.8F;
   private static final float f_9385 = 180.0F;
   private static final int f_9386 = 15728880;
   private static final float f_9387 = 80.0F;
   private static final float f_9388 = 75.0F;
   private static final float f_9389 = 1.4F;
   private static final float f_9390 = 2.65F;
   private static final float f_9391 = 2.95F;
   private static final float f_9392 = 1.8F;
   private static final float f_9393 = -35.0F;
   private static final float f_9394 = 35.0F;
   private static final float f_9395 = (float) Math.PI;
   private static final float f_9396 = 1.6F;
   private static final float f_9397 = 1.04F;

   public static void m_798(DrawContext var0, Util30 var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var0 != null && var1 != null && !(var4 < f_9380) && !(var5 < f_9381) && !(var8 < f_9382)) {
         MinecraftClient var9 = MinecraftClient.getInstance();
         PlayerEntityRenderState var10 = new PlayerEntityRenderState();
         var10.entityType = EntityType.PLAYER;
         var10.skinTextures = var9.player == null ? DefaultSkinHelper.getSteve() : var9.player.getSkin();
         var10.id = var9.player == null ? -1 : var9.player.getId();
         var10.age = var9.player == null ? 0.0F : var9.player.age + var9.getRenderTickCounter().getTickProgress(false);
         var10.width = f_9383;
         var10.height = f_9384;
         var10.baseScale = 1.0F;
         var10.ageScale = 1.0F;
         var10.bodyYaw = f_9385 + var6;
         var10.relativeHeadYaw = 0.0F;
         var10.pitch = 0.0F;
         var10.light = f_9386;
         var10.capeVisible = false;
         ArrayList<Util30> var11 = new ArrayList<>();
         if (var5 >= f_9387) {
            for (Util30 var13 : RenderUtil3.m_844().m_1055()) {
               if (var13.slot() != var1.slot()) {
                  var11.add(var13);
               }
            }
         }

         var11.add(var1);
         RenderUtil5.preview(var10, var11);
         boolean var24 = var11.stream().anyMatch(var0x -> var0x.slot() == Util150.WINGS);
         boolean var25 = !var24 && var5 < f_9388;
         float var14 = Math.min((var5 - 2.0F) / (var25 ? f_9389 : f_9390), (var4 - 2.0F) / (var24 ? f_9391 : f_9392));
         Quaternionf var15 = new Quaternionf().rotateX((float)Math.toRadians(Math.max(f_9393, Math.min(f_9394, var7))));
         Quaternionf var16 = new Quaternionf().rotateZ(f_9395).mul(var15);
         int var17 = Math.round(var2);
         int var18 = Math.round(var3);
         int var19 = Math.round(var2 + var4);
         int var20 = Math.round(var3 + var5);
         var0.enableScissor(var17, var18, var19, var20);

         try {
            var0.addEntity(var10, var14, new Vector3f(0.0F, var25 ? f_9396 : f_9397, 0.0F), var16, var15, var17, var18, var19, var20);
         } finally {
            var0.disableScissor();
         }
      }
   }

   private Util73() {
   }
}
