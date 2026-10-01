package su.energyclient.util;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import su.energyclient.EnergyClient;
import su.energyclient.module.render.Interface;

public class Util48 extends Util156 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final ObjectArrayList<Util48.cd39V9z4FWPrWCLY> f_8207 = new ObjectArrayList();
   private float f_8208 = 0.0F;
   private final Util165 f_8209;
   private static final long f_8210 = 200L;
   private static final String f_8211 = "Potions";
   private static final float f_8212 = 23.0F;
   private static final float f_8213 = 18.0F;
   private static final float f_8214 = 0.01F;
   private static final float f_8215 = 18.0F;
   private static final float f_8216 = 10.0F;
   private static final float f_8217 = 8.0F;
   private static final float f_8218 = 0.1F;
   private static final float f_8219 = 10.0F;
   private static final String f_8220 = "q";
   private static final float f_8221 = 5.0F;
   private static final float f_8222 = 7.5F;
   private static final float f_8223 = 17.0F;
   private static final float f_8224 = 7.5F;
   private static final float f_8225 = 0.001F;
   private static final float f_8226 = 255.0F;
   private static final float f_8227 = 20.0F;
   private static final float f_8228 = 0.5F;
   private static final float f_8229 = 21.0F;
   private static final float f_8230 = 16.0F;
   private static final float f_8231 = 10.0F;
   private static final int f_8232 = 1315865;
   private static final float f_8233 = 10.0F;
   private static final float f_8234 = 20.0F;
   private static final float f_8235 = 0.5F;
   private static final float f_8236 = 16.0F;
   private static final float f_8237 = 10.0F;
   private static final int f_8238 = 1315865;
   private static final float f_8239 = 5.0F;
   private static final float f_8240 = 20.0F;
   private static final float f_8241 = 2.5F;
   private static final float f_8242 = 16.0F;
   private static final float f_8243 = 20.0F;
   private static final float f_8244 = 7.0F;
   private static final float f_8245 = 0.5F;
   private static final float f_8246 = 5.0F;
   private static final float f_8247 = 20.0F;
   private static final float f_8248 = 7.0F;
   private static final float f_8249 = 0.5F;
   private static final float f_8250 = 16.5F;
   private static final float f_8251 = 255.0F;
   private static final int f_8252 = 16777215;
   private static final int f_8253 = -43691;
   private static final int f_8254 = Integer.MAX_VALUE;
   private static final String f_8255 = "**:**";
   private static final String f_8256 = "%d:%02d";
   private static final String f_8257 = "0:%02d";

   public void m_3341() {
      if (f_5909.player != null) {
         Map<String, StatusEffectInstance> var1 = f_5909.player
            .getStatusEffects()
            .stream()
            .collect(
               Collectors.toMap(
                  var1x -> this.m_2047(var1x.getEffectType()) + ":" + var1x.getAmplifier(), var0 -> (StatusEffectInstance)var0, (var0, var1x) -> var0
               )
            );
         ObjectListIterator var2 = this.f_8207.iterator();

         while (var2.hasNext()) {
            Util48.cd39V9z4FWPrWCLY var3 = (Util48.cd39V9z4FWPrWCLY)var2.next();
            String var4 = var3.m_3742() + ":" + var3.m_3890();
            StatusEffectInstance var5 = (StatusEffectInstance)var1.get(var4);
            if (var5 != null) {
               var3.m_2423(var5.getDuration());
               var3.m_75(true);
               var1.remove(var4);
            } else {
               var3.m_75(false);
            }
         }

         var1.forEach(
            (var1x, var2x) -> this.f_8207
               .add(new Util48.cd39V9z4FWPrWCLY(this.m_2047(var2x.getEffectType()), var2x.getAmplifier(), var2x.getDuration(), var2x.getEffectType()))
         );
         this.f_8207.removeIf(var0 -> !var0.m_2336() && var0.m_369().m_2276() <= 0.0);
      }
   }

   private int m_870(int var1) {
      if (var1 <= 200) {
         return f_8253;
      } else {
         return var1 <= 600 ? -22016 : -1;
      }
   }

   private float m_690(Util48.cd39V9z4FWPrWCLY var1) {
      return Util93.f_6001[15].m_585(var1.m_2067()) + Util93.f_6001[15].m_585(this.m_3266(var1.m_3544()));
   }

   @Override
   public void m_18(Util170 var1) {
      if (f_5909.player != null) {
         this.m_3341();
      }
   }

   private void m_2603(DrawContext var1, RegistryEntry<StatusEffect> var2, float var3, float var4, int var5, float var6) {
      int var7 = Math.max(0, Math.min(255, (int)(var6 * f_8251)));
      int var8 = var7 << 24 | f_8252;
      var1.drawGuiTexture(RenderPipelines.GUI_TEXTURED, InGameHud.getEffectTexture(var2), (int)var3, (int)var4, var5, var5, var8);
   }

   public Util48(Util112 var1) {
      super(var1);
      this.f_8209 = new Util165(Util153.LINEAR, f_8210);
   }

   private String m_3266(int var1) {
      if (var1 != -1 && var1 != f_8254) {
         int var2 = var1 / 20;
         int var3 = var2 / 60;
         var2 %= 60;
         return var3 > 0 ? String.format(f_8256, var3, var2) : String.format(f_8257, var2);
      } else {
         return f_8255;
      }
   }

   private String m_2047(RegistryEntry<StatusEffect> var1) {
      return Text.translatable(((StatusEffect)var1.value()).getTranslationKey()).getString();
   }

   @Override
   public void m_4(Util169 var1) {
      if (f_5909.player != null) {
         DrawContext var2 = var1.m_4037();
         float var3 = this.f_10920.m_2838();
         float var4 = this.f_10920.m_671();
         String var5 = f_8211;
         float var6 = Util93.f_6001[16].m_585(var5);
         float var7 = f_8212 + var6;
         float var9 = f_8213;
         ObjectListIterator var10 = this.f_8207.iterator();

         while (var10.hasNext()) {
            Util48.cd39V9z4FWPrWCLY var11 = (Util48.cd39V9z4FWPrWCLY)var10.next();
            var11.m_369().m_3631(var11.m_2336() ? 1.0 : 0.0);
         }

         List<Util48.cd39V9z4FWPrWCLY> var28 = this.f_8207.stream().filter(var0 -> var0.m_369().m_2276() > 0.0).sorted(Comparator.comparingDouble(this::m_690).reversed()).toList();
         boolean var29 = f_5909.currentScreen instanceof ChatScreen || !var28.isEmpty();
         this.f_8209.m_3631(var29 ? 1.0 : 0.0);
         float var12 = (float)this.f_8209.m_2276();
         if (var12 <= f_8214) {
            this.f_10920.m_1597(0.0F);
            this.f_10920.m_1076(0.0F);
         } else {
            float var13 = 0.0F;
            float var14 = 0.0F;

            for (Util48.cd39V9z4FWPrWCLY var16 : var28) {
               String var17 = var16.m_2067();
               String var18 = this.m_3266(var16.m_3544());
               float var19 = Util93.f_6001[15].m_585(var17);
               float var20 = Util93.f_6001[15].m_585(var18);
               var13 = Math.max(var13, var19);
               var14 = Math.max(var14, var20);
            }

            float var8 = Math.max(var7, f_8215 + var13 + f_8216 + var14 + f_8217);
            this.f_8208 = this.f_8208 + (var8 - this.f_8208) * f_8218;
            Util158.m_3998(var3, var4, this.f_8208, var9, f_8219, Util71.m_756(20, 20, 25, (int)(Interface.m_886(150) * var12)), var12);
            Util93.f_6000[18].m_2915(var2, f_8220, var3 + f_8221, var4 + f_8222, Util71.m_1907(EnergyClient.getTheme(0), var12));
            Util93.f_6001[16].m_2915(var2, var5, var3 + f_8223, var4 + f_8224, Util71.m_1907(-1, var12));
            float var30 = 0.0F;

            for (Util48.cd39V9z4FWPrWCLY var32 : var28) {
               String var33 = var32.m_2067();
               String var34 = this.m_3266(var32.m_3544());
               float var35 = Util93.f_6001[15].m_585(var33);
               float var21 = Util93.f_6001[15].m_585(var34);
               float var22 = (float)var32.m_369().m_2276();
               float var23 = var22 * var12;
               if (!(var23 <= f_8225)) {
                  int var24 = (int)(var23 * f_8226);
                  int var25 = (int)(var23 * Interface.m_886(100));
                  Util158.m_3998(var3, var4 + var30 + f_8227 - f_8228, var35 + f_8229, f_8230, f_8231, Util71.m_3389(f_8232, var25), var23);
                  float var26 = var21 + f_8233;
                  float var27 = var3 + this.f_8208 - var26;
                  Util158.m_3998(var27, var4 + var30 + f_8234 - f_8235, var26, f_8236, f_8237, Util71.m_3389(f_8238, var25), var23);
                  this.m_2603(var2, var32.m_2394(), var3 + f_8239, var4 + var30 + f_8240 + f_8241, 10, var23);
                  Util93.f_6001[15].m_2915(var2, var33, var3 + f_8242, var4 + var30 + f_8243 + f_8244 - f_8245, Util71.m_3389(-1, var24));
                  Util93.f_6001[15]
                     .m_2915(var2, var34, var27 + f_8246, var4 + var30 + f_8247 + f_8248 - f_8249, Util71.m_3389(this.m_870(var32.m_3544()), var24));
                  var30 += var23 * f_8250;
               }
            }

            this.f_10920.m_1597(this.f_8208 * var12);
            this.f_10920.m_1076((var9 + var30) * var12);
         }
      }
   }

   private static class cd39V9z4FWPrWCLY {
      private final String f_8258;
      private final int f_8259;
      private int f_8260;
      private boolean f_8261;
      private final Util165 f_8262;
      private final RegistryEntry<StatusEffect> f_8263;
      private static final long f_8264 = 200L;
      private static final String f_8265 = "I";
      private static final String f_8266 = "II";
      private static final String f_8267 = "III";
      private static final String f_8268 = "IV";
      private static final String f_8269 = "V";
      private static final String f_8270 = "VI";
      private static final String f_8271 = "VII";
      private static final String f_8272 = "VIII";
      private static final String f_8273 = "IX";
      private static final String f_8274 = "X";

      public int m_3890() {
         return this.f_8259;
      }

      public void m_2423(int var1) {
         this.f_8260 = var1;
      }

      public RegistryEntry<StatusEffect> m_2394() {
         return this.f_8263;
      }

      public String m_3742() {
         return this.f_8258;
      }

      private static String m_4044(int var0) {
         return switch (var0) {
            case 1 -> f_8265;
            case 2 -> f_8266;
            case 3 -> f_8267;
            case 4 -> f_8268;
            case 5 -> f_8269;
            case 6 -> f_8270;
            case 7 -> f_8271;
            case 8 -> f_8272;
            case 9 -> f_8273;
            case 10 -> f_8274;
            default -> String.valueOf(var0);
         };
      }

      public int m_4024() {
         return ((StatusEffect)this.f_8263.value()).getColor();
      }

      public Util165 m_369() {
         return this.f_8262;
      }

      public void m_75(boolean var1) {
         this.f_8261 = var1;
      }

      public cd39V9z4FWPrWCLY(String var1, int var2, int var3, RegistryEntry<StatusEffect> var4) {
         this.f_8262 = new Util165(Util153.LINEAR, f_8264);
         this.f_8258 = var1;
         this.f_8259 = var2;
         this.f_8260 = var3;
         this.f_8261 = true;
         this.f_8263 = var4;
      }

      public int m_3544() {
         return this.f_8260;
      }

      public String m_2067() {
         return this.f_8259 > 0 ? this.f_8258 + " " + m_4044(this.f_8259 + 1) : this.f_8258;
      }

      public boolean m_2336() {
         return this.f_8261;
      }
   }
}
