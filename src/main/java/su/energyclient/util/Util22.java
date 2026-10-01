package su.energyclient.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.scoreboard.Team;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.GameMode;
import su.energyclient.EnergyClient;
import su.energyclient.module.render.Interface;

public class Util22 extends Util156 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ObjectArrayList<Util22.Inner_6vFjizD9uXsgN2ZE> f_3362 = new ObjectArrayList();
   private final Pattern f_3363;
   private final Pattern f_3364;
   private float f_3365;
   private final Util165 f_3366;
   private static final String f_3367 = "^\\w{3,16}$";
   private static final String f_3368 = new String(
      ".*((s|ꜱ)upp|mod|der|adm|help|wne|мод|хелп|помо|адм|владе|отри|таф|taf|curat|курато|dev|раз|сапп|yt|ютуб|стажер|сотрудник|ꔓ|ꔗ|ꔡ|ꔥ|ꔩ|ꔳ|ꔷ).*"
   );
   private static final long f_3369 = 200L;
   private static final int f_3370 = 65281;
   private static final int f_3371 = 65374;
   private static final int f_3372 = 65248;
   private static final String f_3373 = "Staffs";
   private static final float f_3374 = 23.0F;
   private static final float f_3375 = 18.0F;
   private static final float f_3376 = 0.01F;
   private static final float f_3377 = 18.0F;
   private static final float f_3378 = 10.0F;
   private static final float f_3379 = 8.0F;
   private static final float f_3380 = 0.1F;
   private static final float f_3381 = 10.0F;
   private static final String f_3382 = "r";
   private static final float f_3383 = 5.0F;
   private static final float f_3384 = 7.5F;
   private static final float f_3385 = 17.0F;
   private static final float f_3386 = 7.5F;
   private static final float f_3387 = 0.001F;
   private static final float f_3388 = 255.0F;
   private static final float f_3389 = 20.0F;
   private static final float f_3390 = 0.5F;
   private static final float f_3391 = 21.0F;
   private static final float f_3392 = 16.0F;
   private static final float f_3393 = 10.0F;
   private static final int f_3394 = 1315865;
   private static final float f_3395 = 10.0F;
   private static final float f_3396 = 20.0F;
   private static final float f_3397 = 0.5F;
   private static final float f_3398 = 16.0F;
   private static final float f_3399 = 10.0F;
   private static final int f_3400 = 1315865;
   private static final String f_3401 = "textures/entity/player/wide/steve.png";
   private static final String f_3402 = "textures/entity/player/wide/steve.png";
   private static final float f_3403 = 4.0F;
   private static final float f_3404 = 20.0F;
   private static final float f_3405 = 3.0F;
   private static final float f_3406 = 0.5F;
   private static final float f_3407 = 9.5F;
   private static final float f_3408 = 9.5F;
   private static final float f_3409 = 3.0F;
   private static final float f_3410 = 16.0F;
   private static final float f_3411 = 20.0F;
   private static final float f_3412 = 7.0F;
   private static final float f_3413 = 0.5F;
   private static final float f_3414 = 5.0F;
   private static final float f_3415 = 20.0F;
   private static final float f_3416 = 7.0F;
   private static final float f_3417 = 0.5F;
   private static final float f_3418 = 16.5F;
   private static final float f_3419 = 50.0F;
   private static final int f_3420 = -11141291;
   private static final int f_3421 = -11184641;
   private static final int f_3422 = -43691;

   public Util22(Util112 var1) {
      super(var1);
      this.f_3363 = Pattern.compile(f_3367);
      this.f_3364 = Pattern.compile(f_3368);
      this.f_3365 = 0.0F;
      this.f_3366 = new Util165(Util153.LINEAR, f_3369);
   }

   @Override
   public void m_4(Util169 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         DrawContext var2 = var1.m_4037();
         float var3 = this.f_10920.m_2838();
         float var4 = this.f_10920.m_671();
         String var5 = f_3373;
         float var6 = Util93.f_6001[16].m_585(var5);
         float var7 = f_3374 + var6;
         float var9 = f_3375;
         ObjectListIterator var10 = this.f_3362.iterator();

         while (var10.hasNext()) {
            Util22.Inner_6vFjizD9uXsgN2ZE var11 = (Util22.Inner_6vFjizD9uXsgN2ZE)var10.next();
            var11.m_1294().m_3631(var11.m_1290() ? 1.0 : 0.0);
         }

         List<Util22.Inner_6vFjizD9uXsgN2ZE> var30 = this.f_3362
            .stream()
            .filter(var0 -> var0.m_1294().m_2276() > 0.0)
            .sorted(Comparator.comparing(Util22.Inner_6vFjizD9uXsgN2ZE::m_2764))
            .toList();
         boolean var31 = f_5909.currentScreen instanceof ChatScreen || !var30.isEmpty();
         this.f_3366.m_3631(var31 ? 1.0 : 0.0);
         float var12 = (float)this.f_3366.m_2276();
         if (var12 <= f_3376) {
            this.f_10920.m_1597(0.0F);
            this.f_10920.m_1076(0.0F);
         } else {
            float var13 = 0.0F;
            float var14 = 0.0F;

            for (Util22.Inner_6vFjizD9uXsgN2ZE var16 : var30) {
               Text var17 = var16.m_3740();
               String var18 = var16.m_144().m_3369();
               float var19 = Util93.f_6001[15].m_3324(var17);
               float var20 = Util93.f_6001[15].m_585(var18);
               var13 = Math.max(var13, var19);
               var14 = Math.max(var14, var20);
            }

            float var8 = Math.max(var7, f_3377 + var13 + f_3378 + var14 + f_3379);
            this.f_3365 = this.f_3365 + (var8 - this.f_3365) * f_3380;
            Util158.m_3998(var3, var4, this.f_3365, var9, f_3381, Util71.m_756(20, 20, 25, (int)(Interface.m_886(150) * var12)), var12);
            Util93.f_6000[18].m_2915(var2, f_3382, var3 + f_3383, var4 + f_3384, Util71.m_1907(EnergyClient.getTheme(0), var12));
            Util93.f_6001[16].m_2915(var2, var5, var3 + f_3385, var4 + f_3386, Util71.m_1907(-1, var12));
            float var32 = 0.0F;

            for (Util22.Inner_6vFjizD9uXsgN2ZE var34 : var30) {
               Text var35 = var34.m_3740();
               String var36 = var34.m_144().m_3369();
               float var37 = Util93.f_6001[15].m_3324(var35);
               float var21 = Util93.f_6001[15].m_585(var36);
               float var22 = (float)var34.m_1294().m_2276();
               float var23 = var22 * var12;
               if (!(var23 <= f_3387)) {
                  int var24 = (int)(var23 * f_3388);
                  int var25 = (int)(var23 * Interface.m_886(100));
                  Util158.m_3998(var3, var4 + var32 + f_3389 - f_3390, var37 + f_3391, f_3392, f_3393, Util71.m_3389(f_3394, var25), var23);
                  float var26 = var21 + f_3395;
                  float var27 = var3 + this.f_3365 - var26;
                  Util158.m_3998(var27, var4 + var32 + f_3396 - f_3397, var26, f_3398, f_3399, Util71.m_3389(f_3400, var25), var23);
                  Identifier var28;
                  if (f_5909.getNetworkHandler() != null) {
                     PlayerListEntry var29 = f_5909.getNetworkHandler().getPlayerListEntry(var34.m_2764());
                     if (var29 != null) {
                        var28 = var29.getSkinTextures().body().texturePath();
                     } else {
                        var28 = Identifier.ofVanilla(f_3401);
                     }
                  } else {
                     var28 = Identifier.ofVanilla(f_3402);
                  }

                  Util158.m_4005(var28, null, var3 + f_3403, var4 + var32 + f_3404 + f_3405 - f_3406, f_3407, f_3408, f_3409, var23);
                  Util93.f_6001[15].m_2959(var2, var35, var3 + f_3410, var4 + var32 + f_3411 + f_3412 - f_3413, Util71.m_3389(-1, var24));
                  Util93.f_6001[15]
                     .m_2915(var2, var36, var27 + f_3414, var4 + var32 + f_3415 + f_3416 - f_3417, Util71.m_3389(this.m_2956(var34.m_144()), var24));
                  var32 += var23 * f_3418;
               }
            }

            this.f_10920.m_1597(this.f_3365 * var12);
            this.f_10920.m_1076((var9 + var32) * var12);
         }
      }
   }

   private String m_3557(String var1) {
      StringBuilder var2 = new StringBuilder(var1.length());

      for (char var6 : var1.toCharArray()) {
         if (var6 >= f_3370 && var6 <= f_3371) {
            var2.append((char)(var6 - f_3372));
         } else {
            var2.append(var6);
         }
      }

      return var2.toString();
   }

   @Override
   public void m_18(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         this.m_3803();
      }
   }

   private Util22.Inner_2u5MZIoHT7HZUdP0 m_1767(String var1, boolean var2) {
      if (var2) {
         return Util22.Inner_2u5MZIoHT7HZUdP0.VANISHED;
      } else {
         if (f_5909.world != null) {
            for (AbstractClientPlayerEntity var4 : f_5909.world.getPlayers()) {
               if (var4.getName().getString().equals(var1)) {
                  if (f_5909.player != null && f_5909.player.distanceTo(var4) <= f_3419) {
                     return Util22.Inner_2u5MZIoHT7HZUdP0.NEAR;
                  }

                  return Util22.Inner_2u5MZIoHT7HZUdP0.NONE;
               }
            }
         }

         if (f_5909.getNetworkHandler() != null) {
            for (PlayerListEntry var6 : f_5909.getNetworkHandler().getPlayerList()) {
               if (var6.getProfile().name().equals(var1)) {
                  if (var6.getGameMode() == GameMode.SPECTATOR) {
                     return Util22.Inner_2u5MZIoHT7HZUdP0.SPEC;
                  }

                  return Util22.Inner_2u5MZIoHT7HZUdP0.NONE;
               }
            }
         }

         return Util22.Inner_2u5MZIoHT7HZUdP0.VANISHED;
      }
   }

   public void m_3803() {
      if (f_5909.player != null && f_5909.world != null) {
         ObjectListIterator var1 = this.f_3362.iterator();

         while (var1.hasNext()) {
            Util22.Inner_6vFjizD9uXsgN2ZE var2 = (Util22.Inner_6vFjizD9uXsgN2ZE)var1.next();
            var2.m_834(false);
         }

         ObjectArraySet var13 = new ObjectArraySet();

         for (Team var3 : f_5909.world.getScoreboard().getTeams().stream().sorted(Comparator.comparing(Team::getName)).toList()) {
            String var4 = var3.getPlayerList().toString();
            if (var4.length() >= 2) {
               var4 = var4.substring(1, var4.length() - 1);
               if (this.f_3363.matcher(var4).matches() && !var13.contains(var4)) {
                  boolean var5 = false;
                  boolean var6 = false;
                  Text var7 = var3.getPrefix();
                  String var8 = var7.getString().toLowerCase(Locale.ROOT);
                  if (this.f_3364.matcher(this.m_3557(var8)).matches()) {
                     var5 = true;
                  }

                  if (!var5 && f_5909.getNetworkHandler() != null) {
                     var6 = true;

                     for (PlayerListEntry var10 : f_5909.getNetworkHandler().getPlayerList()) {
                        if (var10.getProfile().name().equals(var4)) {
                           var6 = false;
                           break;
                        }
                     }

                     var5 = var6;
                  }

                  if (var5) {
                     Util22.Inner_6vFjizD9uXsgN2ZE var21 = null;
                     ObjectListIterator var22 = this.f_3362.iterator();

                     while (var22.hasNext()) {
                        Util22.Inner_6vFjizD9uXsgN2ZE var11 = (Util22.Inner_6vFjizD9uXsgN2ZE)var22.next();
                        if (var11.m_2764().equals(var4)) {
                           var21 = var11;
                           break;
                        }
                     }

                     if (var21 != null) {
                        var21.m_834(true);
                        var21.m_239(var7.copy());
                        var21.m_759(this.m_1767(var4, var6));
                     } else {
                        Util22.Inner_6vFjizD9uXsgN2ZE var12 = new Util22.Inner_6vFjizD9uXsgN2ZE(var4, var7.copy(), this.m_1767(var4, var6));
                        this.f_3362.add(var12);
                     }

                     var13.add(var4);
                  }
               }
            }
         }

         for (String var16 : Util87.m_1012()) {
            if (!var13.contains(var16)) {
               Util22.Inner_6vFjizD9uXsgN2ZE var18 = null;
               ObjectListIterator var19 = this.f_3362.iterator();

               while (var19.hasNext()) {
                  Util22.Inner_6vFjizD9uXsgN2ZE var20 = (Util22.Inner_6vFjizD9uXsgN2ZE)var19.next();
                  if (var20.m_2764().equalsIgnoreCase(var16)) {
                     var18 = var20;
                     break;
                  }
               }

               if (var18 != null) {
                  var18.m_834(true);
                  var18.m_239(Util87.m_1332(var16));
                  var18.m_759(Util22.Inner_2u5MZIoHT7HZUdP0.SCAN);
               } else {
                  this.f_3362.add(new Util22.Inner_6vFjizD9uXsgN2ZE(var16, Util87.m_1332(var16), Util22.Inner_2u5MZIoHT7HZUdP0.SCAN));
               }

               var13.add(var16);
            }
         }

         this.f_3362.removeIf(var0 -> !var0.m_1290() && var0.m_1294().m_2276() <= 0.0);
      }
   }

   private int m_2956(Util22.Inner_2u5MZIoHT7HZUdP0 var1) {
      return switch (var1) {
         case NONE -> f_3420;
         case NEAR -> -22016;
         case SPEC -> f_3421;
         case VANISHED -> f_3422;
         case SCAN -> -10496;
      };
   }

   private float m_736(Util22.Inner_6vFjizD9uXsgN2ZE var1) {
      return Util93.f_6001[15].m_3324(var1.m_3740()) + Util93.f_6001[15].m_585(var1.m_144().m_3369());
   }

   public static enum Inner_2u5MZIoHT7HZUdP0 {
      NONE("Active"),
      NEAR("Near"),
      SPEC("Gm 3"),
      VANISHED("Vanish"),
      SCAN("Scan");

      private final String f_550;

      private Inner_2u5MZIoHT7HZUdP0(String var3) {
         this.f_550 = var3;
      }

      public String m_3369() {
         return this.f_550;
      }
   }

   private static class Inner_6vFjizD9uXsgN2ZE {
      private final String f_96;
      private Text f_97;
      private Util22.Inner_2u5MZIoHT7HZUdP0 f_98;
      private boolean f_99;
      private final Util165 f_100;
      private static final long f_101 = 200L;

      public void m_834(boolean var1) {
         this.f_99 = var1;
      }

      public Text m_3238() {
         return this.f_97;
      }

      public Text m_3740() {
         return Text.empty().append(this.f_97.copy()).append(Text.literal(this.f_96));
      }

      public void m_759(Util22.Inner_2u5MZIoHT7HZUdP0 var1) {
         this.f_98 = var1;
      }

      public void m_239(Text var1) {
         this.f_97 = var1;
      }

      public String m_2764() {
         return this.f_96;
      }

      public Util165 m_1294() {
         return this.f_100;
      }

      public boolean m_1290() {
         return this.f_99;
      }

      public Inner_6vFjizD9uXsgN2ZE(String var1, Text var2, Util22.Inner_2u5MZIoHT7HZUdP0 var3) {
         this.f_100 = new Util165(Util153.LINEAR, f_101);
         this.f_96 = var1;
         this.f_97 = var2;
         this.f_98 = var3;
         this.f_99 = true;
      }

      public Util22.Inner_2u5MZIoHT7HZUdP0 m_144() {
         return this.f_98;
      }
   }
}
