package su.energyclient.module.miscellaneous;

import java.util.List;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.manager.impl.RotationManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.module.combat.Macetarget;
import su.energyclient.module.movement.AutoSprint;
import su.energyclient.render.RenderUtil22;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util121;
import su.energyclient.util.Util146;
import su.energyclient.util.Util170;
import su.energyclient.util.Util38;

public class ElytraHelper extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final RenderUtil22 O;
   private final RenderUtil22 f_102;
   private final BooleanSetting f_103;
   private final BooleanSetting f_104;
   private final BooleanSetting f_105;
   private boolean f_106;
   private boolean f_107;
   private ElytraHelper.qIe0IOH69oT2y8c0 f_108;
   private long f_109;
   private ElytraHelper.RSJ7stB9EqAZqvn9 f_110;
   private int f_111;
   private int f_112;
   private Item f_113;
   private static final List<Item> f_114 = List.of(
      Items.NETHERITE_CHESTPLATE,
      Items.DIAMOND_CHESTPLATE,
      Items.IRON_CHESTPLATE,
      Items.GOLDEN_CHESTPLATE,
      Items.CHAINMAIL_CHESTPLATE,
      Items.LEATHER_CHESTPLATE
   );
   private static final String f_115 = "Elytra Helper";
   private static final String f_116 = "Бинд свапа";
   private static final String f_117 = "Бинд фейерверка";
   private static final String f_118 = "Авто-взлёт";
   private static final String f_119 = "Оповещать";
   private static final String f_120 = "Замедление";
   private static final long f_121 = 100L;
   private static final String f_122 = "ReallyWorld";
   private static final String f_123 = "ReallyWorld";
   private static final String f_124 = "Свапнул на ";

   @Override
   public void m_1() {
      this.f_106 = false;
      this.f_108 = ElytraHelper.qIe0IOH69oT2y8c0.IDLE;
      this.m_3313();
      AutoSprint.m_1519(true);
      super.m_1();
   }

   public ElytraHelper() {
      super(f_115, "", Category.MISCELLANEOUS);
      this.O = new RenderUtil22(f_116, -1);
      this.f_102 = new RenderUtil22(f_117, -1);
      this.f_103 = new BooleanSetting(f_118, true);
      this.f_104 = new BooleanSetting(f_119, true);
      this.f_105 = new BooleanSetting(f_120, false);
      this.f_106 = false;
      this.f_107 = false;
      this.f_108 = ElytraHelper.qIe0IOH69oT2y8c0.IDLE;
      this.f_110 = ElytraHelper.RSJ7stB9EqAZqvn9.NONE;
   }

   private void m_2753() {
      AutoSprint.m_1519(false);
      f_5909.player.setSprinting(false);
      f_5909.options.jumpKey.setPressed(false);
      f_5909.options.forwardKey.setPressed(false);
      f_5909.options.backKey.setPressed(false);
      f_5909.options.leftKey.setPressed(false);
      f_5909.options.rightKey.setPressed(false);
      f_5909.options.sprintKey.setPressed(false);
   }

   private void m_2533(Item var1) {
      if (f_5909.player != null && f_5909.player.isAlive()) {
         ItemStack var2 = new ItemStack(var1);
         MutableText var3 = Text.empty().append(Text.literal(f_124).formatted(Formatting.GRAY)).append(var2.getName().copy().formatted(Formatting.WHITE));
         RotationManager.m_3112(var2, var3);
      }
   }

   private Item m_3222() {
      for (Item var2 : f_114) {
         if (Util146.m_3290(var2, 0, 45) != -1) {
            return var2;
         }
      }

      return Items.AIR;
   }

   private boolean m_967(int var1) {
      return Util146.m_3282(var1, 6, 8, SlotActionType.SWAP);
   }

   @EventHandler
   public void m_1309(Util170 var1) {
      if (this.f_108 == ElytraHelper.qIe0IOH69oT2y8c0.STOPPING) {
         this.m_2753();
         long var2 = System.currentTimeMillis();
         if (var2 - this.f_109 >= f_121) {
            Item var4 = this.f_113;
            boolean var5 = this.m_355();
            if (var5 && this.f_104.m_1163() && var4 != null && var4 != Items.AIR) {
               this.m_2533(var4);
            }

            this.m_3313();
            this.f_108 = ElytraHelper.qIe0IOH69oT2y8c0.IDLE;
            this.f_106 = false;
            AutoSprint.m_1519(true);
         }
      } else if (this.f_106) {
         this.m_1859();
      }

      if (this.f_107) {
         Util146.m_2425(Items.FIREWORK_ROCKET);
         this.f_107 = false;
      }

      if (this.f_103.m_1163() && !Macetarget.m_329() && !f_5909.player.isTouchingWater()) {
         ItemStack var6 = f_5909.player.getEquippedStack(EquipmentSlot.CHEST);
         if (var6.isOf(Items.ELYTRA) && !f_5909.player.isInLava() && f_5909.player.isOnGround() && !f_5909.options.jumpKey.isPressed()) {
            f_5909.player.jump();
         } else if (var6.isOf(Items.ELYTRA) && this.m_3016(var6) && !f_5909.player.isGliding() && !f_5909.player.isOnGround()) {
            f_5909.player.startGliding();
            f_5909.player.networkHandler.sendPacket(new ClientCommandC2SPacket(f_5909.player, Mode.START_FALL_FLYING));
         }
      }
   }

   private boolean m_355() {
      return switch (this.f_110) {
         case NONE -> false;
         case SIMPLE_HOTBAR -> this.m_1414(this.f_111, this.f_112);
         case COMPLEX_INV -> this.m_967(this.f_111);
      };
   }

   private boolean m_3016(ItemStack var1) {
      return var1.getDamage() < var1.getMaxDamage() - 1;
   }

   private void m_1859() {
      boolean var1 = f_5909.player.getEquippedStack(EquipmentSlot.CHEST).getItem() == Items.ELYTRA;
      Item var2 = var1 ? this.m_3222() : Items.ELYTRA;
      if (var2 == Items.AIR) {
         this.f_106 = false;
      } else {
         int var3 = Util146.m_3290(var2, 0, 8);
         int var4 = Util146.m_3290(var2, 9, 45);
         if (var3 != -1) {
            if ((this.f_105.m_1163() || InitManager.f_2740.f_2741.guiMove.m_512().m_2073(f_122)) && Util38.m_469()) {
               this.f_110 = ElytraHelper.RSJ7stB9EqAZqvn9.SIMPLE_HOTBAR;
               this.f_111 = 6;
               this.f_112 = var3;
               this.f_113 = var2;
               this.f_109 = System.currentTimeMillis();
               this.f_108 = ElytraHelper.qIe0IOH69oT2y8c0.STOPPING;
               this.m_2753();
            } else if (this.m_1414(6, var3)) {
               if (this.f_104.m_1163()) {
                  this.m_2533(var2);
               }

               this.f_106 = false;
            }
         } else if (var4 == -1) {
            this.f_106 = false;
         } else {
            if ((this.f_105.m_1163() || InitManager.f_2740.f_2741.guiMove.m_512().m_2073(f_123)) && Util38.m_469()) {
               this.f_110 = ElytraHelper.RSJ7stB9EqAZqvn9.COMPLEX_INV;
               this.f_111 = var4;
               this.f_113 = var2;
               this.f_109 = System.currentTimeMillis();
               this.f_108 = ElytraHelper.qIe0IOH69oT2y8c0.STOPPING;
               this.m_2753();
            } else if (this.m_967(var4)) {
               if (this.f_104.m_1163()) {
                  this.m_2533(var2);
               }

               this.f_106 = false;
            }
         }
      }
   }

   private boolean m_1414(int var1, int var2) {
      return Util146.m_3282(var1, -1, var2, SlotActionType.SWAP);
   }

   @EventHandler
   public void m_1262(Util121 var1) {
      if (this.f_108 == ElytraHelper.qIe0IOH69oT2y8c0.STOPPING) {
         var1.m_433(0.0F);
         var1.m_2791(0.0F);
      }
   }

   @EventHandler
   public void m_2314(CancellableEvent var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (!var1.m_3546()) {
            if (var1.m_2169() == this.O.m_1958()) {
               if (this.O.m_766() == RenderUtil22.pqYfuJa0oJD2nAQv.TOGGLE) {
                  if (var1.m_1362()) {
                     this.f_106 = true;
                  }
               } else if (this.O.m_766() == RenderUtil22.pqYfuJa0oJD2nAQv.HOLD) {
                  this.f_106 = true;
               }
            }

            if (var1.m_2169() == this.f_102.m_1958() && f_5909.player.isGliding()) {
               if (this.f_102.m_766() == RenderUtil22.pqYfuJa0oJD2nAQv.TOGGLE) {
                  if (var1.m_1362()) {
                     this.f_107 = true;
                  }
               } else if (this.f_102.m_766() == RenderUtil22.pqYfuJa0oJD2nAQv.HOLD) {
                  this.f_107 = true;
               }
            }
         }
      }
   }

   private void m_3313() {
      this.f_110 = ElytraHelper.RSJ7stB9EqAZqvn9.NONE;
      this.f_113 = null;
   }

   private static enum RSJ7stB9EqAZqvn9 {
      NONE,
      SIMPLE_HOTBAR,
      COMPLEX_INV;
   }

   private static enum qIe0IOH69oT2y8c0 {
      IDLE,
      STOPPING;
   }
}
