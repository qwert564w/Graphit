package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Arm;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector2f;
import org.joml.Vector3f;
import su.energyclient.EnergyClient;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil25;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util158;
import su.energyclient.util.Util169;
import su.energyclient.util.Util63;
import su.energyclient.util.Util71;
import su.energyclient.util.Util88;
import su.energyclient.util.Util93;
import su.energyclient.util.math.MathUtil10;

public class Trajectory extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_7856 = 3.0F;
   private final Util63 f_7857;
   private final BooleanSetting f_7858;
   private static final DecimalFormat f_7859 = new DecimalFormat(Trajectory.f_7969);
   private List<Trajectory.Inner_5beMQo65TV0Qqt90> f_7860;
   private static final String f_7861 = "Trajectory";
   private static final String f_7862 = "Показывает траекторию бросаемых предметов";
   private static final String f_7863 = "Предметы";
   private static final String f_7864 = "Лук";
   private static final String f_7865 = "Арбалет";
   private static final String f_7866 = "Эндер Пёрл";
   private static final String f_7867 = "Снежок";
   private static final String f_7868 = "Яйцо";
   private static final String f_7869 = "Зелье";
   private static final String f_7870 = "Опыт";
   private static final String f_7871 = "Трезубец";
   private static final String f_7872 = "Время падения";
   private static final float f_7873 = 3.0F;
   private static final float f_7874 = Float.MAX_VALUE;
   private static final float f_7875 = Float.MAX_VALUE;
   private static final float f_7876 = 3.0F;
   private static final float f_7877 = 20.0F;
   private static final float f_7878 = 3.0F;
   private static final float f_7879 = 15.5F;
   private static final float f_7880 = 11.0F;
   private static final float f_7881 = 18.0F;
   private static final float f_7882 = 0.5F;
   private static final float f_7883 = 6.0F;
   private static final float f_7884 = 0.5F;
   private static final String f_7885 = "Лук";
   private static final float f_7886 = 0.1F;
   private static final float f_7887 = 0.1F;
   private static final float f_7888 = 3.0F;
   private static final float f_7889 = 0.05F;
   private static final String f_7890 = "Арбалет";
   private static final float f_7891 = 3.15F;
   private static final float f_7892 = 0.05F;
   private static final float f_7893 = 10.0F;
   private static final double f_7894 = 0.16;
   private static final float f_7895 = 0.99F;
   private static final double f_7896 = 0.16;
   private static final double f_7897 = 0.16;
   private static final double f_7898 = 0.16;
   private static final float f_7899 = 0.99F;
   private static final float f_7900 = 0.99F;
   private static final double f_7901 = 0.16;
   private static final double f_7902 = 0.16;
   private static final double f_7903 = 0.16;
   private static final float f_7904 = 0.99F;
   private static final double f_7905 = 0.16;
   private static final String f_7906 = "Эндер Пёрл";
   private static final String f_7907 = "Снежок";
   private static final String f_7908 = "Яйцо";
   private static final float f_7909 = 1.5F;
   private static final float f_7910 = 0.03F;
   private static final String f_7911 = "Трезубец";
   private static final float f_7912 = 2.5F;
   private static final float f_7913 = 0.05F;
   private static final String f_7914 = "Опыт";
   private static final float f_7915 = 0.7F;
   private static final float f_7916 = 0.07F;
   private static final String f_7917 = "Зелье";
   private static final float f_7918 = 0.5F;
   private static final float f_7919 = 0.05F;
   private static final float f_7920 = 3.0F;
   private static final String f_7921 = "Зелье";
   private static final float f_7922 = 0.5F;
   private static final float f_7923 = 0.05F;
   private static final float f_7924 = 4.0F;
   private static final float f_7925 = 6.0F;
   private static final float f_7926 = 0.5F;
   private static final double f_7927 = 0.3;
   private static final double f_7928 = 0.8F;
   private static final float f_7929 = 6.0F;
   private static final float f_7930 = 6.0F;
   private static final float f_7931 = 255.0F;
   private static final float f_7932 = 255.0F;
   private static final float f_7933 = 255.0F;
   private static final float f_7934 = 255.0F;
   private static final float f_7935 = 255.0F;
   private static final float f_7936 = 255.0F;
   private static final float f_7937 = 255.0F;
   private static final float f_7938 = 255.0F;
   private static final float f_7939 = 3.0F;
   private static final float f_7940 = 3.0F;
   private static final float f_7941 = 0.05F;
   private static final float f_7942 = 0.05F;
   private static final float f_7943 = 255.0F;
   private static final float f_7944 = 255.0F;
   private static final float f_7945 = 255.0F;
   private static final float f_7946 = 3.0F;
   private static final float f_7947 = 3.0F;
   private static final float f_7948 = 255.0F;
   private static final float f_7949 = 255.0F;
   private static final float f_7950 = 255.0F;
   private static final float f_7951 = 255.0F;
   private static final float f_7952 = 0.999F;
   private static final double f_7953 = Math.PI * 2;
   private static final double f_7954 = Math.PI * 2;
   private static final float f_7955 = 3.0F;
   private static final float f_7956 = 3.0F;
   private static final double f_7957 = -0.3;
   private static final double f_7958 = 0.3;
   private static final double f_7959 = 0.1;
   private static final double f_7960 = 0.16;
   private static final float f_7961 = 0.99F;
   private static final double f_7962 = 0.16;
   private static final double f_7963 = -20.0;
   private static final double f_7964 = -0.1;
   private static final float f_7965 = 0.99F;
   private static final double f_7966 = -0.1;
   private static final float f_7967 = 3.0F;
   private static final float f_7968 = 1.0E-6F;
   private static final String f_7969 = "0.0";

   private Vector3f m_3825(float var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = var4 - var1;
      float var8 = var5 - var2;
      float var9 = var6 - var3;
      float var10 = (float)Math.sqrt(var7 * var7 + var8 * var8 + var9 * var9);
      return var10 < f_7968 ? new Vector3f(0.0F, 1.0F, 0.0F) : new Vector3f(var7 / var10, var8 / var10, var9 / var10);
   }

   private void m_4127(MatrixStack var1, BufferBuilder var2, Vec3d var3, float var4, Vec3d var5, int var6) {
      Matrix4f var7 = var1.peek().getPositionMatrix();
      float var8 = Util71.m_1989(var6) / f_7948;
      float var9 = Util71.m_644(var6) / f_7949;
      float var10 = Util71.m_3163(var6) / f_7950;
      float var11 = Util71.m_2734(var6) / f_7951;
      Vector3f var12 = this.m_3825((float)var3.x, (float)var3.y, (float)var3.z, (float)(var3.x + var5.x), (float)(var3.y + var5.y), (float)(var3.z + var5.z));
      Vector3f var13 = Math.abs(var12.y()) < f_7952 ? new Vector3f(0.0F, 1.0F, 0.0F) : new Vector3f(1.0F, 0.0F, 0.0F);
      Vector3f var14 = new Vector3f(var13).cross(var12).normalize();
      Vector3f var15 = new Vector3f(var12).cross(var14).normalize();
      byte var16 = 64;

      for (int var17 = 0; var17 < var16; var17++) {
         double var18 = f_7953 * var17 / var16;
         double var20 = f_7954 * (var17 + 1) / var16;
         float var22 = (float)Math.cos(var18);
         float var23 = (float)Math.sin(var18);
         float var24 = (float)Math.cos(var20);
         float var25 = (float)Math.sin(var20);
         Vector3f var26 = new Vector3f(var14).mul(var4 * var22).add(new Vector3f(var15).mul(var4 * var23)).add((float)var3.x, (float)var3.y, (float)var3.z);
         Vector3f var27 = new Vector3f(var14).mul(var4 * var24).add(new Vector3f(var15).mul(var4 * var25)).add((float)var3.x, (float)var3.y, (float)var3.z);
         var2.vertex(var7, var26.x(), var26.y(), var26.z())
            .color(var8, var9, var10, var11)
            .normal(var1.peek(), var12.x(), var12.y(), var12.z())
            .lineWidth(f_7955);
         var2.vertex(var7, var27.x(), var27.y(), var27.z())
            .color(var8, var9, var10, var11)
            .normal(var1.peek(), var12.x(), var12.y(), var12.z())
            .lineWidth(f_7956);
      }
   }

   private void m_3060(MatrixStack var1, BufferBuilder var2, Trajectory.Inner_5beMQo65TV0Qqt90 var3) {
      Vec3d var4 = var3.f_2713;
      Vec3d var5 = var3.f_2714;
      Matrix4f var7 = var1.peek().getPositionMatrix();
      float var8 = 0.0F;
      float var9 = f_7925;
      int var10 = EnergyClient.getTheme(0);
      int var11 = Util71.m_2101(var10, f_7926);

      for (int var12 = 0; var12 <= var3.f_2717; var12++) {
         Vec3d var6 = var4;
         var4 = var4.add(var5);
         Vec3d var15 = var4;
         Entity var16 = null;
         boolean var17 = false;
         Vec3d var18 = null;
         RaycastContext var19 = new RaycastContext(var6, var4, ShapeType.COLLIDER, FluidHandling.NONE, f_5909.player);
         BlockHitResult var20 = f_5909.world.raycast(var19);
         if (var20.getType() == Type.BLOCK) {
            var15 = var20.getPos();
            var17 = true;
            Direction var21 = var20.getSide();
            var18 = new Vec3d(var21.getOffsetX(), var21.getOffsetY(), var21.getOffsetZ());
         }

         Box var46 = new Box(var6, var4).expand(f_7927);
         EntityHitResult var22 = ProjectileUtil.raycast(
            f_5909.player, var6, var4, var46, var0 -> EntityPredicates.CAN_HIT.test(var0) && var0 != f_5909.player, var6.squaredDistanceTo(var4)
         );
         if (var22 != null) {
            Vec3d var23 = var22.getPos();
            double var24 = var23.squaredDistanceTo(var6);
            double var26 = var15.squaredDistanceTo(var6);
            if (!var17 || var24 < var26) {
               var15 = var23;
               var17 = true;
               var16 = var22.getEntity();
            }
         }

         if (var15.y <= 0.0) {
            var15 = new Vec3d(var15.x, 0.0, var15.z);
            var17 = true;
         }

         var5 = var5.multiply(var3.f_2716);
         var5 = var5.add(0.0, -var3.f_2715, 0.0);
         if (f_5909.world.getBlockState(BlockPos.ofFloored(var6)).getBlock() == Blocks.WATER) {
            var5 = var5.multiply(f_7928);
         }

         float var47 = (float)var6.distanceTo(var15);
         float var48 = this.m_3082(0.0F, f_7929, var8);
         float var25 = this.m_3082(0.0F, f_7930, var8 + var47);
         int var49 = Util71.m_1784(3, var12 * 8, var10, var11);
         int var27 = Util71.m_1784(3, (var12 + 1) * 8, var10, var11);
         int var28 = Util71.m_3765(var49, var48);
         int var29 = Util71.m_3765(var27, var25);
         float var30 = Util71.m_1989(var28) / f_7931;
         float var31 = Util71.m_644(var28) / f_7932;
         float var32 = Util71.m_3163(var28) / f_7933;
         float var33 = Util71.m_2734(var28) / f_7934;
         float var34 = Util71.m_1989(var29) / f_7935;
         float var35 = Util71.m_644(var29) / f_7936;
         float var36 = Util71.m_3163(var29) / f_7937;
         float var37 = Util71.m_2734(var29) / f_7938;
         Vec3d var38 = var12 == 0 && var3.f_2719 != null ? var3.f_2719 : var6;
         Vector3f var39 = this.m_3825((float)var38.x, (float)var38.y, (float)var38.z, (float)var15.x, (float)var15.y, (float)var15.z);
         var2.vertex(var7, (float)var38.x, (float)var38.y, (float)var38.z)
            .color(var30, var31, var32, var33)
            .normal(var1.peek(), var39.x(), var39.y(), var39.z())
            .lineWidth(f_7939);
         var2.vertex(var7, (float)var15.x, (float)var15.y, (float)var15.z)
            .color(var34, var35, var36, var37)
            .normal(var1.peek(), var39.x(), var39.y(), var39.z())
            .lineWidth(f_7940);
         var8 += var47;
         if (var16 != null) {
            var3.f_2722 = var15;
            var3.f_2723 = var12 * f_7941;
            var3.f_2721 = true;
            this.m_3268(var1, var2, var16, var3.f_2718, var29);
            if (var3.f_2720 > 0.0F) {
               Vec3d var50 = var16.getEntityPos();
               Vec3d var41 = var16.getLerpedPos(var3.f_2718);
               Vec3d var42 = var41.subtract(var50);
               Box var43 = var16.getBoundingBox().offset(var42);
               Vec3d var44 = new Vec3d(var41.x, var43.minY, var41.z);
               this.m_4127(var1, var2, var44, var3.f_2720, new Vec3d(0.0, 1.0, 0.0), var29);
            }
            break;
         }

         if (var17) {
            var3.f_2722 = var15;
            var3.f_2723 = var12 * f_7942;
            var3.f_2721 = true;
            if (var3.f_2720 > 0.0F) {
               Vec3d var40 = var18 != null ? var18 : new Vec3d(0.0, 1.0, 0.0);
               this.m_4127(var1, var2, var15, var3.f_2720, var40, var29);
            }
            break;
         }
      }
   }

   private Vec3d m_3192(float var1) {
      if (f_5909.player == null) {
         return this.l(0.0F, 0.0F);
      } else {
         Vec3d var2 = f_5909.player.getOppositeRotationVector(1.0F);
         Quaternionf var3 = new Quaternionf().setAngleAxis((float)Math.toRadians(var1), var2.x, var2.y, var2.z);
         Vec3d var4 = f_5909.player.getRotationVec(1.0F);
         Vector3f var5 = var4.toVector3f().rotate(var3);
         return new Vec3d(var5.x(), var5.y(), var5.z()).normalize();
      }
   }

   private void m_2840(
      BufferBuilder var1,
      MatrixStack var2,
      Matrix4f var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13
   ) {
      Vector3f var14 = this.m_3825(var4, var5, var6, var7, var8, var9);
      var1.vertex(var3, var4, var5, var6).color(var10, var11, var12, var13).normal(var2.peek(), var14.x(), var14.y(), var14.z()).lineWidth(f_7946);
      var1.vertex(var3, var7, var8, var9).color(var10, var11, var12, var13).normal(var2.peek(), var14.x(), var14.y(), var14.z()).lineWidth(f_7947);
   }

   public Trajectory() {
      super(f_7861, f_7862, Category.RENDER);
      this.f_7857 = new Util63(
         f_7863,
         new BooleanSetting(f_7864, true),
         new BooleanSetting(f_7865, true),
         new BooleanSetting(f_7866, true),
         new BooleanSetting(f_7867, true),
         new BooleanSetting(f_7868, true),
         new BooleanSetting(f_7869, true),
         new BooleanSetting(f_7870, true),
         new BooleanSetting(f_7871, true)
      );
      this.f_7858 = new BooleanSetting(f_7872, false);
      this.f_7860 = new ArrayList<>();
   }

   private List<Trajectory.Inner_5beMQo65TV0Qqt90> m_3150(ItemStack var1, float var2) {
      Item var3 = var1.getItem();
      ArrayList var4 = new ArrayList();
      Vec3d var5 = f_5909.player.getLerpedPos(var2);
      double var6 = f_5909.player.getEyeY() - f_5909.player.getY();
      Vec3d var8 = var5.add(0.0, var6, 0.0);
      float var9 = f_5909.player.getYaw();
      float var10 = f_5909.player.getPitch();
      if (var3 == Items.BOW && this.f_7857.I(f_7885)) {
         if (f_5909.player.isUsingItem() && f_5909.player.getActiveItem() == var1) {
            int var31 = f_5909.player.getItemUseTime();
            float var32 = BowItem.getPullProgress(var31);
            if (var32 < f_7886) {
               var32 = f_7887;
            }

            float var33 = f_7888;
            float var34 = var33 * var32;
            var4.add(this.m_259(var8, var9, var10, var34, f_7889, var2));
            return var4;
         } else {
            return var4;
         }
      } else if (var3 == Items.CROSSBOW && this.f_7857.I(f_7890)) {
         if (!CrossbowItem.isCharged(var1)) {
            return var4;
         } else {
            float var30 = f_7891;
            float var12 = f_7892;
            boolean var13 = false;
            ItemEnchantmentsComponent var14 = var1.getEnchantments();

            for (Entry var16 : var14.getEnchantmentEntries()) {
               if (((RegistryEntry)var16.getKey()).matchesKey(Enchantments.MULTISHOT) && var16.getIntValue() > 0) {
                  var13 = true;
                  break;
               }
            }

            Vec3d var35 = this.m_1990(var8, var9);
            if (var13) {
               float var37 = f_7893;
               Vec3d var38 = this.m_3192(0.0F);
               Vec3d var39 = var8.add(var38.multiply(f_7894));
               Vec3d var40 = var38.multiply(var30);
               Trajectory.Inner_5beMQo65TV0Qqt90 var20 = new Trajectory.Inner_5beMQo65TV0Qqt90(var39, var40, var12, f_7895, 160, var2);
               var20.f_2719 = var35.add(var38.multiply(f_7896));
               var4.add(var20);
               Vec3d var21 = this.m_3192(-var37);
               Vec3d var22 = this.m_3192(var37);
               Vec3d var23 = var8.add(var21.multiply(f_7897));
               Vec3d var24 = var8.add(var22.multiply(f_7898));
               Vec3d var25 = var21.multiply(var30);
               Vec3d var26 = var22.multiply(var30);
               Trajectory.Inner_5beMQo65TV0Qqt90 var27 = new Trajectory.Inner_5beMQo65TV0Qqt90(var23, var25, var12, f_7899, 160, var2);
               Trajectory.Inner_5beMQo65TV0Qqt90 var28 = new Trajectory.Inner_5beMQo65TV0Qqt90(var24, var26, var12, f_7900, 160, var2);
               var27.f_2719 = var35.add(var21.multiply(f_7901));
               var28.f_2719 = var35.add(var22.multiply(f_7902));
               var4.add(var27);
               var4.add(var28);
               return var4;
            } else {
               Vec3d var36 = this.m_3192(0.0F);
               Vec3d var17 = var8.add(var36.multiply(f_7903));
               Vec3d var18 = var36.multiply(var30);
               Trajectory.Inner_5beMQo65TV0Qqt90 var19 = new Trajectory.Inner_5beMQo65TV0Qqt90(var17, var18, var12, f_7904, 160, var2);
               var19.f_2719 = var35.add(var36.multiply(f_7905));
               var4.add(var19);
               return var4;
            }
         }
      } else if ((var3 != Items.ENDER_PEARL || !this.f_7857.I(f_7906))
         && (var3 != Items.SNOWBALL || !this.f_7857.I(f_7907))
         && (var3 != Items.EGG || !this.f_7857.I(f_7908))) {
         if (var3 == Items.TRIDENT && this.f_7857.I(f_7911)) {
            var4.add(this.m_259(var8, var9, var10, f_7912, f_7913, var2));
            return var4;
         } else if (var3 == Items.EXPERIENCE_BOTTLE && this.f_7857.I(f_7914)) {
            var4.add(this.l(var8, var9, var10, f_7915, f_7916, var2));
            return var4;
         } else if (var3 == Items.LINGERING_POTION && this.f_7857.I(f_7917)) {
            Trajectory.Inner_5beMQo65TV0Qqt90 var29 = this.l(var8, var9, var10, f_7918, f_7919, var2);
            var29.f_2720 = f_7920;
            var4.add(var29);
            return var4;
         } else if (var3 == Items.SPLASH_POTION && this.f_7857.I(f_7921)) {
            Trajectory.Inner_5beMQo65TV0Qqt90 var11 = this.l(var8, var9, var10, f_7922, f_7923, var2);
            var11.f_2720 = f_7924;
            var4.add(var11);
            return var4;
         } else {
            return var4;
         }
      } else {
         var4.add(this.m_259(var8, var9, var10, f_7909, f_7910, var2));
         return var4;
      }
   }

   private Vec3d l(float var1, float var2) {
      float var3 = (float)Math.toRadians(var1);
      float var4 = (float)Math.toRadians(var2);
      float var5 = -MathHelper.sin(var3) * MathHelper.cos(var4);
      float var6 = -MathHelper.sin(var4);
      float var7 = MathHelper.cos(var3) * MathHelper.cos(var4);
      return new Vec3d(var5, var6, var7).normalize();
   }

   private Vec3d m_1990(Vec3d var1, float var2) {
      float var3 = (float)Math.toRadians(var2);
      double var4 = f_5909.player.getMainArm() == Arm.RIGHT ? f_7957 : f_7958;
      double var6 = var1.x + var4 * MathHelper.cos(var3);
      double var8 = var1.z + var4 * MathHelper.sin(var3);
      double var10 = var1.y - f_7959;
      return new Vec3d(var6, var10, var8);
   }

   @EventHandler
   public void m_1250(Util169 var1) {
      if (this.f_7858.m_1163() && f_5909.player != null && f_5909.world != null) {
         if (this.f_7860 != null && !this.f_7860.isEmpty()) {
            for (Trajectory.Inner_5beMQo65TV0Qqt90 var3 : this.f_7860) {
               if (var3.f_2721 && var3.f_2722 != null) {
                  Vec3d var4 = var3.f_2722;
                  Vector2f var5 = MathUtil10.m_1972((float)var4.x, (float)var4.y, (float)var4.z);
                  if (var5.x != f_7874 || var5.y != f_7875) {
                     float var6 = var5.x;
                     float var7 = var5.y + f_7876;
                     String var8 = f_7859.format(var3.f_2723) + " сек.";
                     float var9 = Util93.f_6003[14].m_585(var8);
                     RenderUtil25.m_1557(var1.m_4037(), var6 - f_7877, var7 - f_7878, var9 + f_7879, f_7880, Util71.m_756(0, 0, 0, 120));
                     Util158.m_1974(var1.m_4037(), f_5909.player.getMainHandStack(), var6 - f_7881, var7 - 2.0F, f_7882, -1, 1.0F);
                     Util93.f_6003[14].m_2915(var1.m_4037(), var8, var6 - var9 / 2.0F + f_7883, var7 + f_7884, -1);
                  }
               }
            }
         }
      }
   }

   private Trajectory.Inner_5beMQo65TV0Qqt90 l(Vec3d var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = (float)Math.toRadians(var3);
      float var8 = (float)Math.toRadians(var2);
      float var9 = (float)Math.toRadians(f_7963);
      float var10 = -MathHelper.sin(var8) * MathHelper.cos(var7);
      float var11 = -MathHelper.sin(var7 + var9);
      float var12 = MathHelper.cos(var8) * MathHelper.cos(var7);
      Vec3d var13 = new Vec3d(var10, var11, var12).normalize();
      Vec3d var14 = var1.add(0.0, f_7964, 0.0);
      Vec3d var15 = f_5909.player.getVelocity();
      Vec3d var16 = var13.multiply(var4).add(var15.x, f_5909.player.isOnGround() ? 0.0 : var15.y, var15.z);
      Trajectory.Inner_5beMQo65TV0Qqt90 var17 = new Trajectory.Inner_5beMQo65TV0Qqt90(var14, var16, var5, f_7965, 160, var6);
      var17.f_2719 = this.m_1990(var1, var2).add(0.0, f_7966, 0.0);
      return var17;
   }

   private void m_3268(MatrixStack var1, BufferBuilder var2, Entity var3, float var4, int var5) {
      Vec3d var6 = var3.getEntityPos();
      Vec3d var7 = var3.getLerpedPos(var4);
      Vec3d var8 = var7.subtract(var6);
      Box var9 = var3.getBoundingBox().offset(var8);
      float var10 = Util71.m_1989(var5) / f_7943;
      float var11 = Util71.m_644(var5) / f_7944;
      float var12 = Util71.m_3163(var5) / f_7945;
      float var13 = 1.0F;
      float var14 = (float)var9.minX;
      float var15 = (float)var9.minY;
      float var16 = (float)var9.minZ;
      float var17 = (float)var9.maxX;
      float var18 = (float)var9.maxY;
      float var19 = (float)var9.maxZ;
      Matrix4f var20 = var1.peek().getPositionMatrix();
      this.m_2840(var2, var1, var20, var14, var15, var16, var17, var15, var16, var10, var11, var12, var13);
      this.m_2840(var2, var1, var20, var17, var15, var16, var17, var15, var19, var10, var11, var12, var13);
      this.m_2840(var2, var1, var20, var17, var15, var19, var14, var15, var19, var10, var11, var12, var13);
      this.m_2840(var2, var1, var20, var14, var15, var19, var14, var15, var16, var10, var11, var12, var13);
      this.m_2840(var2, var1, var20, var14, var18, var16, var17, var18, var16, var10, var11, var12, var13);
      this.m_2840(var2, var1, var20, var17, var18, var16, var17, var18, var19, var10, var11, var12, var13);
      this.m_2840(var2, var1, var20, var17, var18, var19, var14, var18, var19, var10, var11, var12, var13);
      this.m_2840(var2, var1, var20, var14, var18, var19, var14, var18, var16, var10, var11, var12, var13);
      this.m_2840(var2, var1, var20, var14, var15, var16, var14, var18, var16, var10, var11, var12, var13);
      this.m_2840(var2, var1, var20, var17, var15, var16, var17, var18, var16, var10, var11, var12, var13);
      this.m_2840(var2, var1, var20, var17, var15, var19, var17, var18, var19, var10, var11, var12, var13);
      this.m_2840(var2, var1, var20, var14, var15, var19, var14, var18, var19, var10, var11, var12, var13);
   }

   private float m_3082(float var1, float var2, float var3) {
      float var4 = MathHelper.clamp((var3 - var1) / (var2 - var1), 0.0F, 1.0F);
      return var4 * var4 * (f_7967 - 2.0F * var4);
   }

   private Trajectory.Inner_5beMQo65TV0Qqt90 m_259(Vec3d var1, float var2, float var3, float var4, float var5, float var6) {
      Vec3d var7 = this.l(var2, var3);
      Vec3d var8 = var1.add(var7.multiply(f_7960));
      Vec3d var9 = f_5909.player.getVelocity();
      Vec3d var10 = var7.multiply(var4).add(var9.x, f_5909.player.isOnGround() ? 0.0 : var9.y, var9.z);
      Trajectory.Inner_5beMQo65TV0Qqt90 var11 = new Trajectory.Inner_5beMQo65TV0Qqt90(var8, var10, var5, f_7961, 160, var6);
      var11.f_2719 = this.m_1990(var1, var2).add(var7.multiply(f_7962));
      return var11;
   }

   @EventHandler
   public void m_2777(Util88 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         ItemStack var2 = f_5909.player.getMainHandStack();
         if (var2.isEmpty()) {
            this.f_7860 = Collections.emptyList();
         } else {
            List<Trajectory.Inner_5beMQo65TV0Qqt90> var3 = this.m_3150(var2, var1.m_191());
            if (var3.isEmpty()) {
               this.f_7860 = Collections.emptyList();
            } else {
               this.f_7860 = var3;
               MatrixStack var4 = var1.m_213();
               Vec3d var5 = f_5909.gameRenderer.getCamera().getCameraPos();
               var4.push();
               var4.translate(-var5.x, -var5.y, -var5.z);
               Util114.m_672();
               Util114.m_3978();
               Util114.m_1481();
               Util114.m_3784(RenderUtil7.f_13887);
               Util114.m_2977(f_7873);
               BufferBuilder var6 = Tessellator.getInstance().begin(DrawMode.LINES, VertexFormats.POSITION_COLOR_NORMAL_LINE_WIDTH);

               for (Trajectory.Inner_5beMQo65TV0Qqt90 var8 : var3) {
                  this.m_3060(var4, var6, var8);
               }

               RenderUtil12.I(var6.end());
               Util114.m_100();
               Util114.m_1562();
               var4.pop();
            }
         }
      }
   }

   private static class Inner_5beMQo65TV0Qqt90 {
      final Vec3d f_2713;
      final Vec3d f_2714;
      final float f_2715;
      final float f_2716;
      final int f_2717;
      final float f_2718;
      Vec3d f_2719;
      float f_2720;
      boolean f_2721;
      Vec3d f_2722;
      float f_2723;

      Inner_5beMQo65TV0Qqt90(Vec3d var1, Vec3d var2, float var3, float var4, int var5, float var6) {
         this.f_2713 = var1;
         this.f_2714 = var2;
         this.f_2715 = var3;
         this.f_2716 = var4;
         this.f_2717 = var5;
         this.f_2718 = var6;
         this.f_2719 = null;
         this.f_2720 = 0.0F;
         this.f_2721 = false;
         this.f_2722 = null;
         this.f_2723 = 0.0F;
      }
   }
}
