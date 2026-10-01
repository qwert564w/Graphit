package su.energyclient.command.impl;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import su.energyclient.QuickImports;
import su.energyclient.command.Command;
import su.energyclient.util.Util152;

public class GpsCommand extends Command implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static boolean f_1379 = false;
   public static double f_1380 = 0.0;
   public static double f_1381 = 0.0;
   private static final String f_1382 = "gps";
   private static final String f_1383 = "x";
   private static final String f_1384 = "z";
   private static final String f_1385 = "off";
   private static final String f_1386 = "info";
   private static final String f_1387 = "Сейчас GPS отключен!";
   private static final String f_1388 = "Информация о текущем GPS: ";
   private static final String f_1389 = "x: ";
   private static final String f_1390 = "%.1f";
   private static final String f_1391 = ",";
   private static final String f_1392 = ".";
   private static final String f_1393 = " z: ";
   private static final String f_1394 = "%.1f";
   private static final String f_1395 = ",";
   private static final String f_1396 = ".";
   private static final String f_1397 = "GPS уже отключен!";
   private static final String f_1398 = "GPS отключен!";
   private static final String f_1399 = "x";
   private static final String f_1400 = "z";
   private static final String f_1401 = "GPS установлен на координаты: ";
   private static final String f_1402 = "%.1f";
   private static final String f_1403 = ",";
   private static final String f_1404 = ".";
   private static final String f_1405 = "%.1f";
   private static final String f_1406 = ",";
   private static final String f_1407 = ".";

   @Override
   public void run(LiteralArgumentBuilder<CommandSource> var1) {
      var1.executes(var1x -> this.m_2444(var1x));
      var1.then(
         ((RequiredArgumentBuilder)m_2219(f_1383, DoubleArgumentType.doubleArg()).executes(var1x -> this.m_2444(var1x)))
            .then(m_2219(f_1384, DoubleArgumentType.doubleArg()).executes(var0 -> {
               double var1x = (Double)var0.getArgument(f_1399, Double.class);
               double var3 = (Double)var0.getArgument(f_1400, Double.class);
               f_1379 = true;
               f_1380 = var1x;
               f_1381 = var3;
               MutableText var5 = Text.literal(f_1401).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
               MutableText var6 = Text.literal("x: " + String.format(f_1402, f_1380).replace(f_1403, f_1404)).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
               MutableText var7 = Text.literal(" z: " + String.format(f_1405, f_1381).replace(f_1406, f_1407))
                  .setStyle(Style.EMPTY.withColor(Formatting.WHITE));
               Util152.m_662(Text.literal("").append(var5).append(var6).append(var7));
               return 1;
            }))
      );
      var1.then(m_1192(f_1385).executes(var0 -> {
         if (!f_1379) {
            MutableText var1x = Text.literal(f_1397).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            Util152.m_662(var1x);
         } else {
            f_1379 = false;
            f_1380 = 0.0;
            f_1381 = 0.0;
            MutableText var2 = Text.literal(f_1398).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            Util152.m_662(var2);
         }

         return 1;
      }));
      var1.then(m_1192(f_1386).executes(var0 -> {
         if (!f_1379) {
            MutableText var1x = Text.literal(f_1387).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            Util152.m_662(var1x);
         } else {
            MutableText var6 = Text.literal(f_1388).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            MutableText var2 = Text.literal(f_1389).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            MutableText var3 = Text.literal(String.format(f_1390, f_1380).replace(f_1391, f_1392)).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
            MutableText var4 = Text.literal(f_1393).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            MutableText var5 = Text.literal(String.format(f_1394, f_1381).replace(f_1395, f_1396)).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
            Util152.m_662(Text.literal("").append(var6).append(var2).append(var3).append(var4).append(var5));
         }

         return 1;
      }));
   }

   public GpsCommand() {
      super(f_1382);
   }
}
