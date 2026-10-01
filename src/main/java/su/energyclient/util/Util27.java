package su.energyclient.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import net.minecraft.entity.LivingEntity;
import su.energyclient.module.combat.AttackAura;

public class Util27 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Map<String, Util148> f_3489 = new HashMap<>();
   private String f_3490;

   public void m_3612(AttackAura var1) {
      Util148 var2 = this.f_3489.get(this.f_3490);
      if (var2 == null && var1 != null && var1.m_2597() != null) {
         var2 = this.f_3489.get(var1.m_2597().m_3862());
      }

      if (var2 != null) {
         var2.m_6(var1);
      }

      this.f_3490 = null;
   }

   public void m_1161(AttackAura var1) {
      Util148 var2 = this.m_1004(var1);
      if (var2 != null) {
         var2.m_8(var1);
      }
   }

   public boolean m_1095(AttackAura var1, LivingEntity var2) {
      Util148 var3 = this.m_1004(var1);
      return var3 != null && var2 != null && var3.m_13(var1, var2);
   }

   public void m_4102(AttackAura var1, LivingEntity var2) {
      Util148 var3 = this.m_1004(var1);
      if (var3 != null && var2 != null) {
         var3.m_5(var1, var2);
      }
   }

   public void m_916(AttackAura var1, LivingEntity var2, boolean var3) {
      Util148 var4 = this.m_1004(var1);
      if (var4 != null && var2 != null) {
         var4.m_28(var1, var2, var3);
      }
   }

   public Util27() {
      this.m_3924(new Util127());
      this.m_3924(new Util14());
      this.m_3924(new Util119());
      this.m_3924(new Util33());
      this.m_3924(new Util57());
      this.m_3924(new Util107());
      this.m_3924(new Util151());
      this.m_3924(new Util140());
   }

   public void m_3618(AttackAura var1, LivingEntity var2) {
      Util148 var3 = this.m_1004(var1);
      if (var3 != null && var2 != null) {
         var3.m_12(var1, var2);
      }
   }

   private void m_3924(Util148 var1) {
      this.f_3489.put(var1.m_3(), var1);
   }

   private Util148 m_1004(AttackAura var1) {
      String var2 = var1.m_2597().m_3862();
      if (!Objects.equals(this.f_3490, var2)) {
         Util148 var3 = this.f_3489.get(this.f_3490);
         if (var3 != null) {
            var3.m_8(var1);
         }

         this.f_3490 = var2;
         Util148 var4 = this.f_3489.get(this.f_3490);
         if (var4 != null) {
            var4.m_11(var1);
         }
      }

      return this.f_3489.get(var2);
   }

   public void m_1097(AttackAura var1, LivingEntity var2) {
      Util148 var3 = this.m_1004(var1);
      if (var3 != null && var2 != null) {
         var3.m_35(var1, var2);
      }
   }

   public void m_98(AttackAura var1) {
      this.f_3490 = var1.m_2597().m_3862();
      Util148 var2 = this.f_3489.get(this.f_3490);
      if (var2 != null) {
         var2.m_11(var1);
      }
   }
}
