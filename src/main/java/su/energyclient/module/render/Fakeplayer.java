package su.energyclient.module.render;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity.RemovalReason;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util164;
import su.energyclient.util.Util29;

public class Fakeplayer extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_8195 = 2147483646;
   private static final int f_8196 = 0;
   private final BooleanSetting f_8197;
   private final BooleanSetting f_8198;
   private Util29 f_8199;
   private static final String f_8200 = "FakePlayer";
   private static final String f_8201 = "Creates a client-side player dummy with infinite health";
   private static final String f_8202 = "Copy equipment";
   private static final String f_8203 = "Copy skin";
   private static final String f_8204 = "FakePlayer";
   private static final String f_8205 = "FakePlayer";
   private static final int f_8206 = 2147483646;

   private void m_2958() {
      if (this.f_8199 != null) {
         if (f_5909.world != null && !this.f_8199.isRemoved()) {
            f_5909.world.removeEntity(this.f_8199.getId(), RemovalReason.DISCARDED);
         }

         this.f_8199 = null;
      }
   }

   @Override
   public void m_1() {
      this.m_2958();
      super.m_1();
   }

   private void m_658() {
      ClientWorld var1 = f_5909.world;
      ClientPlayerEntity var2 = f_5909.player;
      if (var1 != null && var2 != null) {
         this.m_2958();
         int var3 = m_56(var1);
         if (var3 != -1) {
            GameProfile var4 = this.f_8198.m_1163()
               ? new GameProfile(UUID.randomUUID(), f_8204, var2.getGameProfile().properties())
               : new GameProfile(UUID.randomUUID(), f_8205);
            Util29 var5 = new Util29(var1, var4);
            var5.setId(var3);
            var5.refreshPositionAndAngles(var2.getX(), var2.getY(), var2.getZ(), var2.getYaw(), var2.getPitch());
            var5.setHeadYaw(var2.getHeadYaw());
            var5.setBodyYaw(var2.getBodyYaw());
            if (this.f_8197.m_1163()) {
               var5.getInventory().clone(var2.getInventory());
            }

            var5.healFully();
            var1.addEntity(var5);
            this.f_8199 = var5;
         }
      }
   }

   @Override
   public void m_2() {
      super.m_2();
      this.m_658();
   }

   private static int m_56(ClientWorld var0) {
      for (int var1 = 0; var1 < 512; var1++) {
         int var2 = f_8206 - var1;
         if (var0.getEntityById(var2) == null) {
            return var2;
         }
      }

      return -1;
   }

   public Fakeplayer() {
      super(f_8200, f_8201, Category.RENDER);
      this.f_8197 = new BooleanSetting(f_8202, true);
      this.f_8198 = new BooleanSetting(f_8203, true);
   }

   @EventHandler
   public void m_2808(Util164 var1) {
      if (f_5909.world != null && f_5909.player != null) {
         if (this.f_8199 == null || this.f_8199.isRemoved() || f_5909.world.getEntityById(this.f_8199.getId()) != this.f_8199) {
            this.m_658();
         }
      } else {
         this.f_8199 = null;
      }
   }
}
