package su.energyclient.module.miscellaneous;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import su.energyclient.event.EventHandler;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util1;
import su.energyclient.util.Util10;
import su.energyclient.util.Util131;
import su.energyclient.util.Util15;
import su.energyclient.util.Util152;
import su.energyclient.util.Util172;
import su.energyclient.util.Util54;
import su.energyclient.util.Util62;

public class ObsidianFarm extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static ObsidianFarm f_11054;
   public static final String f_11055 = "1";
   public static String f_11056 = ObsidianFarm.f_11091;
   public final Util1 f_11057 = new Util1(this);
   public final Util62 f_11058 = new Util62(this);
   public final Util15 f_11059 = new Util15();
   public final Util131 f_11060 = new Util131(this);
   public boolean f_11061;
   public boolean f_11062;
   public int f_11063 = -1;
   public int f_11064 = -1;
   public int f_11065 = -1;
   public int O = -1;
   public long f_11066;
   public long f_11067;
   public BlockPos f_11068;
   public BooleanSetting f_11069;
   public BooleanSetting f_11070;
   public BooleanSetting f_11071;
   public ModeSetting f_11072;
   private static final String f_11073 = "Obsidian Farm";
   private static final String f_11074 = "Автокоп обсидиана с авто-продажей и починкой кирки";
   private static final String f_11075 = "Авто продажа";
   private static final String f_11076 = "Авто починка";
   private static final String f_11077 = "Тп на спавн при y < 0";
   private static final String f_11078 = "Режим починки";
   private static final String f_11079 = "Команда";
   private static final String f_11080 = "Опыт";
   private static final String f_11081 = "Команда";
   private static final float f_11082 = 90.0F;
   private static final float f_11083 = 360.0F;
   private static final float f_11084 = 360.0F;
   private static final float f_11085 = 360.0F;
   private static final float f_11086 = 360.0F;
   private static final long f_11087 = 600L;
   private static final long f_11088 = 500L;
   private static final String f_11089 = "бур";
   private static final double f_11090 = 25.0;
   private static final String f_11091 = "1";

   public boolean m_2098() {
      ItemStack var1 = f_5909.player.getMainHandStack();
      if (var1.isIn(ItemTags.PICKAXES)) {
         for (Text var3 : var1.getTooltip(TooltipContext.create(f_5909.world), f_5909.player, TooltipType.BASIC)) {
            if (Formatting.strip(var3.getString()).toLowerCase().contains(f_11089)) {
               return true;
            }
         }
      }

      return false;
   }

   public void m_74(String var1) {
      if (f_5909.player != null) {
         f_5909.player.networkHandler.sendChatMessage(var1);
      }
   }

   @EventHandler
   public void m_3946(Util172 var1) {
      if (f_5909.player != null) {
         this.f_11060.m_2967();
         if (this.f_11071.m_1163()) {
            this.f_11058.m_3033();
         }

         if (this.f_11070.m_1163()) {
            this.f_11060.m_2139();
         }

         if (!this.f_11060.f_10626 && !this.f_11061 && !this.f_11062 && this.f_11068 != null) {
            Vec3d var2 = Vec3d.ofCenter(this.f_11068).subtract(f_5909.player.getEyePos());
            float var3 = (float)Math.toDegrees(Math.atan2(var2.z, var2.x)) - f_11082;
            float var4 = (float)(-Math.toDegrees(Math.atan2(var2.y, Math.sqrt(var2.x * var2.x + var2.z * var2.z))));
            Util54.m_2145(new Util10(var3, var4), f_11083, f_11084, f_11085, f_11086, 0, 100, false);
         }

         this.m_3072();
         if (this.f_11069.m_1163()) {
            this.m_1393();
         } else {
            this.m_3561();
         }
      }
   }

   public void m_3072() {
      if (!this.f_11061 && !this.f_11062 && !this.f_11060.f_10626) {
         this.f_11068 = this.f_11057.m_1300(this.m_2098());
         if (this.f_11068 != null && f_5909.interactionManager.updateBlockBreakingProgress(this.f_11068, Direction.UP)) {
            f_5909.player.swingHand(Hand.MAIN_HAND);
         }
      }
   }

   public void m_3314(String var1) {
      Util152.m_662(var1);
   }

   private void m_3134() {
      if (this.f_11064 != -1) {
         int var1 = this.f_11059.m_2367(this.f_11063);
         if (this.f_11064 != var1) {
            this.f_11059.m_205(this.f_11064, var1);
         }
      }

      int var2 = this.f_11063 != -1 ? this.f_11063 : 0;
      this.f_11059.m_2913(var2);
      this.f_11061 = false;
      this.f_11062 = false;
      this.f_11063 = -1;
      this.f_11064 = -1;
      this.f_11065 = -1;
      this.O = -1;
   }

   public boolean m_933(BlockPos var1) {
      return f_5909.player.squaredDistanceTo(Vec3d.ofCenter(var1)) <= f_11090;
   }

   public void m_3561() {
      this.f_11061 = false;
      this.f_11062 = false;
      this.f_11063 = -1;
      this.f_11064 = -1;
      this.f_11065 = -1;
      this.O = -1;
   }

   public void m_1393() {
      long var1 = System.currentTimeMillis();
      if (this.f_11061) {
         if (var1 - this.f_11066 >= f_11087) {
            this.m_74("/market sell " + f_11056);
            this.f_11066 = var1;
            this.f_11061 = false;
            this.f_11067 = var1;
            int var4 = this.f_11059.m_3452();
            if (var4 != -1) {
               this.f_11065 = var4;
               this.f_11062 = true;
            } else {
               this.m_3134();
            }
         }
      } else if (var1 - this.f_11067 >= f_11088) {
         if (this.f_11062) {
            this.f_11059.m_205(this.f_11065, this.f_11059.m_2367(this.O));
            this.f_11059.m_2913(this.O);
            this.f_11061 = true;
            this.f_11066 = var1;
            this.f_11062 = false;
            this.f_11067 = var1;
         } else {
            if (this.f_11059.m_625(Items.OBSIDIAN) >= 1152) {
               int var3 = this.f_11059.m_3452();
               if (var3 == -1) {
                  return;
               }

               if (this.f_11063 == -1) {
                  this.f_11063 = f_5909.player.getInventory().getSelectedSlot();
                  this.f_11064 = this.f_11059.m_2233();
                  this.O = this.f_11059.m_1865(this.f_11063);
               }

               this.f_11065 = var3;
               this.f_11062 = true;
               this.f_11067 = var1;
            }
         }
      }
   }

   @Override
   public void m_1() {
      super.m_1();
      this.f_11060.m_3293();
      this.m_3561();
   }

   public ObsidianFarm() {
      super(f_11073, f_11074, Category.MISCELLANEOUS);
      this.f_11069 = new BooleanSetting(f_11075, true);
      this.f_11070 = new BooleanSetting(f_11076, true);
      this.f_11071 = new BooleanSetting(f_11077, true);
      this.f_11072 = new ModeSetting(f_11078, f_11079, f_11080, f_11081).m_1263(this.f_11070::m_1163);
      f_11054 = this;
   }
}
