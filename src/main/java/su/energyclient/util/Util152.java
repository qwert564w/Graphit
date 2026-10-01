package su.energyclient.util;

import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;

public class Util152 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final char f_10994 = '§';
   private static final String f_10995 = "Object is null";
   private static final String f_10996 = "Energy client ⇨";
   private static final float f_10997 = 0.5F;
   private static final String f_10998 = "Energy client ⇨";
   private static final String f_10999 = "Energy client ⇨";
   private static final int f_11000 = 8947848;
   private static final String f_11001 = "Energy client ⇨";
   private static final int f_11002 = 16777215;
   private static final String f_11003 = " ";
   private static final String f_11004 = "§[0-9a-fk-or]";
   private static final int f_11005 = 16777215;

   public static void m_662(Object var0, Object... var1) {
      if (f_5909.player != null) {
         if (var0 == null) {
            m_662(f_10995);
         } else {
            String var2 = f_10996;
            int var3 = EnergyClient.getTheme(0);
            int var4 = Util71.m_2101(var3, f_10997);
            MutableText var5 = Text.literal("");

            for (int var6 = 0; var6 < f_10998.length(); var6++) {
               char var7 = f_10999.charAt(var6);
               MutableText var8 = Text.literal(String.valueOf(var7));
               Style var9;
               if (var7 == 8680) {
                  var9 = Style.EMPTY.withColor(TextColor.fromRgb(f_11000));
               } else {
                  float var10 = (float)var6 / (f_11001.length() - 1);
                  int var11 = Util71.m_2924(var3, var4, var10);
                  var9 = Style.EMPTY.withColor(TextColor.fromRgb(var11 & f_11002)).withBold(true);
               }

               var8.setStyle(var9);
               var5.append(var8);
            }

            var5.append(Text.literal(f_11003));
            if (var0 instanceof Text) {
               var5.append((Text)var0);
            } else {
               String var12 = String.format(var0.toString(), var1).replace('&', '§');
               String var13 = var12.replaceAll(f_11004, "");
               MutableText var14 = Text.literal(var13);
               var14.setStyle(Style.EMPTY.withColor(TextColor.fromRgb(f_11005)));
               var5.append(var14);
            }

            f_5909.inGameHud.getChatHud().addMessage(var5);
         }
      }
   }
}
