package su.energyclient.module.miscellaneous;

import java.util.Locale;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.manager.impl.RotationManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util125;
import su.energyclient.util.Util146;
import su.energyclient.util.Util170;
import su.energyclient.util.Util66;
import su.energyclient.util.Util71;

public class SmartHelper extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final BooleanSetting f_848;
   private final BooleanSetting f_849;
   private final BooleanSetting f_850;
   private final BooleanSetting f_851;
   private static final String[] f_852 = new String[]{SmartHelper.f_875, SmartHelper.f_876, SmartHelper.f_877};
   private static final String[] f_853 = new String[]{SmartHelper.f_878, SmartHelper.f_879, SmartHelper.f_880};
   private final Util125 f_854;
   private final Util125 f_855;
   private final Util125 f_856;
   private final Util125 f_857;
   private static final String f_858 = "Smart Helper";
   private static final String f_859 = "Умные уведомления и хелпер в бою";
   private static final String f_860 = "Уведомлять при малом хп";
   private static final String f_861 = "Уведомлять о пиаре варпов";
   private static final String f_862 = "Уведомлять о спеке";
   private static final String f_863 = "Кушать хорус";
   private static final float f_864 = 6.0F;
   private static final long f_865 = 1200L;
   private static final String f_866 = "!";
   private static final String f_867 = "У вас мало хп!";
   private static final long f_868 = 350L;
   private static final long f_869 = 1500L;
   private static final String f_870 = "WarpInfo";
   private static final String f_871 = "Внимание! Игрок пиарит варп в чате!";
   private static final long f_872 = 1500L;
   private static final String f_873 = "SpecInfo";
   private static final String f_874 = "Внимание! Игрок пишет спек в чате!";
   private static final String f_875 = "/warp";
   private static final String f_876 = "warp";
   private static final String f_877 = "варп";
   private static final String f_878 = "spec";
   private static final String f_879 = "спек";
   private static final String f_880 = "spek";

   @EventHandler
   public void m_2637(Util66 var1) {
      if (var1.m_2068()) {
         if (var1.m_3295() instanceof GameMessageS2CPacket var2) {
            String var4 = var2.content().getString().toLowerCase(Locale.ROOT);
            if (this.f_849.m_1163() && this.m_3329(var4, f_852) && this.f_855.m_2636(f_869)) {
               RotationManager.m_260(f_870, f_871, Util71.m_1415(255, 190, 95));
               this.f_855.m_3493();
            }

            if (this.f_850.m_1163() && this.m_3329(var4, f_853) && this.f_856.m_2636(f_872)) {
               RotationManager.m_260(f_873, f_874, Util71.m_1415(255, 190, 95));
               this.f_856.m_3493();
            }
         }
      }
   }

   @EventHandler
   public void m_194(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         if (this.f_848.m_1163() && f_5909.player.getHealth() <= f_864 && this.f_854.m_2636(f_865)) {
            RotationManager.m_260(f_866, f_867, Util71.m_1415(243, 50, 50));
            this.f_854.m_3493();
         }

         if (this.f_851.m_1163()) {
            LivingEntity var2 = InitManager.f_2740.f_2741.attackAura.m_891();
            if (var2 != null && var2.isUsingItem() && var2.getActiveItem().isOf(Items.CHORUS_FRUIT) && this.f_857.m_2636(f_868)) {
               Util146.m_2425(Items.CHORUS_FRUIT);
               this.f_857.m_3493();
            }
         }
      }
   }

   public SmartHelper() {
      super(f_858, f_859, Category.MISCELLANEOUS);
      this.f_848 = new BooleanSetting(f_860, true);
      this.f_849 = new BooleanSetting(f_861, true);
      this.f_850 = new BooleanSetting(f_862, true);
      this.f_851 = new BooleanSetting(f_863, false);
      this.f_854 = new Util125();
      this.f_855 = new Util125();
      this.f_856 = new Util125();
      this.f_857 = new Util125();
   }

   private boolean m_3329(String var1, String[] var2) {
      for (String var6 : var2) {
         if (var1.contains(var6.toLowerCase(Locale.ROOT))) {
            return true;
         }
      }

      return false;
   }

   @Override
   public void m_1() {
      super.m_1();
   }
}
