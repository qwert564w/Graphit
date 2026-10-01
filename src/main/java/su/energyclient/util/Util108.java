package su.energyclient.util;

import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import su.energyclient.event.Event;

public class Util108 extends Event {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private LivingEntity f_14172;
   private MatrixStack f_14173;
   private EntityModel<?> f_14174;

   public void m_281(EntityModel<?> var1) {
      this.f_14174 = var1;
   }

   public Util108(LivingEntity var1, MatrixStack var2, EntityModel<?> var3) {
      this.f_14172 = var1;
      this.f_14173 = var2;
      this.f_14174 = var3;
   }

   public void m_3812(MatrixStack var1) {
      this.f_14173 = var1;
   }

   public LivingEntity m_315() {
      return this.f_14172;
   }

   public EntityModel<?> m_3626() {
      return this.f_14174;
   }

   public MatrixStack m_2094() {
      return this.f_14173;
   }

   public void m_1624(LivingEntity var1) {
      this.f_14172 = var1;
   }
}
