package su.energyclient.module.miscellaneous;

import java.awt.Color;
import java.util.ArrayList;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.text.HoverEvent.ShowText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.impl.RotationManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.util.Util152;
import su.energyclient.util.Util163;
import su.energyclient.util.Util71;

public class PotionTracker extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final BooleanSetting f_4858;
   private static final String f_4859 = "Potion Tracker";
   private static final String f_4860 = "Оповещает о наложенных эффектах";
   private static final String f_4861 = "Игнорировать себя";
   private static final float f_4862 = 100.0F;
   private static final int f_4863 = 16777215;
   private static final String f_4864 = " получил эффекты из ";
   private static final String f_4865 = "\n● Успешность ";
   private static final String f_4866 = "\n";
   private static final String f_4867 = " получил эффекты ";
   private static final String f_4868 = "minecraft";
   private static final String f_4869 = "textures/item/splash_potion.png";
   private static final String f_4870 = "%d:%02d";
   private static final String f_4871 = "\n";
   private static final String f_4872 = "● ";
   private static final String f_4873 = "M";
   private static final String f_4874 = "MM";
   private static final String f_4875 = "MMM";
   private static final String f_4876 = "C";
   private static final String f_4877 = "CC";
   private static final String f_4878 = "CCC";
   private static final String f_4879 = "CD";
   private static final String f_4880 = "D";
   private static final String f_4881 = "DC";
   private static final String f_4882 = "DCC";
   private static final String f_4883 = "DCCC";
   private static final String f_4884 = "CM";
   private static final String f_4885 = "X";
   private static final String f_4886 = "XX";
   private static final String f_4887 = "XXX";
   private static final String f_4888 = "XL";
   private static final String f_4889 = "L";
   private static final String f_4890 = "LX";
   private static final String f_4891 = "LXX";
   private static final String f_4892 = "LXXX";
   private static final String f_4893 = "XC";
   private static final String f_4894 = "I";
   private static final String f_4895 = "II";
   private static final String f_4896 = "III";
   private static final String f_4897 = "IV";
   private static final String f_4898 = "V";
   private static final String f_4899 = "VI";
   private static final String f_4900 = "VII";
   private static final String f_4901 = "VIII";
   private static final String f_4902 = "IX";
   private static final float f_4903 = 20.0F;
   private static final String f_4904 = "\n";

   private int m_279(Util163 var1) {
      int var2 = 0;
      int var3 = 0;

      for (StatusEffectInstance var5 : var1.m_2300()) {
         var2 += (int)(var5.getDuration() * var1.m_1174());
         var3 += var5.getDuration();
      }

      return var3 > 0 ? var2 * 100 / var3 : 100;
   }

   public PotionTracker() {
      super(f_4859, f_4860, Category.MISCELLANEOUS);
      this.f_4858 = new BooleanSetting(f_4861, false);
   }

   private String m_4062(int var1) {
      if (var1 >= 1 && var1 <= 3999) {
         String[] var2 = new String[]{"", f_4873, f_4874, f_4875};
         String[] var3 = new String[]{"", f_4876, f_4877, f_4878, f_4879, f_4880, f_4881, f_4882, f_4883, f_4884};
         String[] var4 = new String[]{"", f_4885, f_4886, f_4887, f_4888, f_4889, f_4890, f_4891, f_4892, f_4893};
         String[] var5 = new String[]{"", f_4894, f_4895, f_4896, f_4897, f_4898, f_4899, f_4900, f_4901, f_4902};
         return var2[var1 / 1000] + var3[var1 % 1000 / 100] + var4[var1 % 100 / 10] + var5[var1 % 10];
      } else {
         return String.valueOf(var1);
      }
   }

   @EventHandler
   public void m_270(Util163 var1) {
      if (!this.f_4858.m_1163() || !(var1.m_530() instanceof PlayerEntity) || !var1.m_530().equals(f_5909.player)) {
         int var2 = this.m_279(var1);
         int var3 = Util71.m_2924(Color.RED.getRGB(), Color.GREEN.getRGB(), var2 / f_4862) & f_4863;
         MutableText var4 = this.m_2987(var1);
         PotionContentsComponent var5 = (PotionContentsComponent)var1.m_1417()
            .getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
         MutableText var6 = Text.empty()
            .append(var1.m_530().getName().copy().formatted(Formatting.GRAY))
            .append(Text.literal(f_4864).formatted(Formatting.GRAY))
            .append(var1.m_1417().getName().copy())
            .append(Text.literal(f_4865).formatted(Formatting.GRAY))
            .append(Text.literal(var2 + "%").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(var3))))
            .append(Text.literal(f_4866))
            .append(var4)
            .styled(var3x -> var3x.withHoverEvent(new ShowText(this.m_102(var1.m_1417(), var5))));
         Util152.m_662(var6);
         MutableText var7 = Text.empty()
            .append(var1.m_530().getName().copy().formatted(Formatting.WHITE))
            .append(Text.literal(f_4867).formatted(Formatting.WHITE))
            .append(Text.literal(var2 + "%").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(var3))));
         RotationManager.m_2424(Identifier.of(f_4868, f_4869), var7, var5.getColor());
      }
   }

   private MutableText m_102(ItemStack var1, PotionContentsComponent var2) {
      ArrayList var3 = new ArrayList();
      var3.add(var1.getName().copy());
      float var4 = f_5909.world != null ? TooltipContext.create(f_5909.world).getUpdateTickRate() : f_4903;
      PotionContentsComponent.buildTooltip(var2.getEffects(), var3::add, 1.0F, var4);
      MutableText var5 = Text.empty();

      for (int var6 = 0; var6 < var3.size(); var6++) {
         if (var6 > 0) {
            var5.append(Text.literal(f_4904));
         }

         var5.append((Text)var3.get(var6));
      }

      return var5;
   }

   private MutableText m_2987(Util163 var1) {
      MutableText var2 = Text.empty();

      for (StatusEffectInstance var4 : var1.m_2300()) {
         int var5 = (int)(var4.getDuration() * var1.m_1174()) / 20;
         String var6 = String.format(f_4870, var5 / 60, var5 % 60);
         String var7 = this.m_4062(var4.getAmplifier() + 1);
         if (!var2.getString().isEmpty()) {
            var2.append(Text.literal(f_4871));
         }

         var2.append(Text.literal(f_4872).formatted(Formatting.GRAY))
            .append(Text.translatable(var4.getTranslationKey()).formatted(Formatting.RED))
            .append(Text.literal(" " + var7 + " " + var6).formatted(Formatting.GRAY));
      }

      return var2;
   }
}
