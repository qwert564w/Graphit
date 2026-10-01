package su.energyclient.module.miscellaneous;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import su.energyclient.event.CancellableEvent;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil22;
import su.energyclient.render.RenderUtil25;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util125;
import su.energyclient.util.Util170;
import su.energyclient.util.Util88;

public class FuntimeHelper extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_7180 = -8249328;
   private static final int f_7181 = 0;
   private static final int f_7182 = 0;
   private final ModeSetting f_7183;
   private final RenderUtil22 f_7184;
   private final RenderUtil22 f_7185;
   private final RenderUtil22 f_7186;
   private final RenderUtil22 f_7187;
   private final RenderUtil22 f_7188;
   private final RenderUtil22 f_7189;
   private final RenderUtil22 f_7190;
   private final RenderUtil22 f_7191;
   private final RenderUtil22 f_7192;
   private final RenderUtil22 f_7193;
   private final RenderUtil22 f_7194;
   private final RenderUtil22 f_7195;
   private final RenderUtil22 f_7196;
   private final RenderUtil22 f_7197;
   private final Map<String, FuntimeHelper.Inner_6McL3fEmUp3oxQbL> f_7198;
   private final List<FuntimeHelper.Inner_8jJesZhV8pIKaauY> f_7199;
   private final Deque<String> f_7200;
   private final Set<String> f_7201;
   private final Util125 f_7202;
   private FuntimeHelper.Tl5itnNztq8uPcAl f_7203;
   private FuntimeHelper.ciVlKWPiuydMAjDW f_7204;
   private long f_7205;
   private int f_7206;
   private int f_7207;
   private int f_7208;
   private boolean f_7209;
   private boolean f_7210;
   private boolean f_7211;
   private boolean f_7212;
   private boolean f_7213;
   private boolean f_7214;
   private static final String f_7215 = "FunTime Helper";
   private static final String f_7216 = "Быстрое использование предметов FunTime";
   private static final String f_7217 = "Режим свапа";
   private static final String f_7218 = "Legit";
   private static final String f_7219 = "Instant";
   private static final String f_7220 = "Legit";
   private static final String f_7221 = "Снежок заморозка";
   private static final String f_7222 = "Божья аура";
   private static final String f_7223 = "Трапка";
   private static final String f_7224 = "Пласт";
   private static final String f_7225 = "Явная пыль";
   private static final String f_7226 = "Огненный смерч";
   private static final String f_7227 = "Дезориентация";
   private static final String f_7228 = "Хлопушка";
   private static final String f_7229 = "Святая вода";
   private static final String f_7230 = "Зелье Гнева";
   private static final String f_7231 = "Зелье Палладина";
   private static final String f_7232 = "Зелье Ассасина";
   private static final String f_7233 = "Зелье Радиации";
   private static final String f_7234 = "Снотворное";
   private static final String f_7235 = "sugar";
   private static final String f_7236 = "Явная пыль";
   private static final String f_7237 = "явная пыль";
   private static final String f_7238 = "световая вспышка";
   private static final String f_7239 = "радиус: 10 блоков";
   private static final String f_7240 = "свечение";
   private static final String f_7241 = "слепота";
   private static final String f_7242 = "disorientation";
   private static final String f_7243 = "Дезориентация";
   private static final String f_7244 = "дезориентация";
   private static final String f_7245 = "чем ближе цель, тем дольше длительность эффектов";
   private static final String f_7246 = "trap";
   private static final String f_7247 = "Трапка";
   private static final String f_7248 = "трапка";
   private static final String f_7249 = "нерушимая клетка";
   private static final String f_7250 = "длительность: 15 секунд";
   private static final String f_7251 = "plast";
   private static final String f_7252 = "Пласт";
   private static final String f_7253 = "пласт";
   private static final String f_7254 = "нерушимая стена";
   private static final String f_7255 = "вертикальный:";
   private static final String f_7256 = "горизонтальный:";
   private static final String f_7257 = "fireSwirl";
   private static final String f_7258 = "Огненный смерч";
   private static final String f_7259 = "огненный смерч";
   private static final String f_7260 = "огненная волна";
   private static final String f_7261 = "радиус: 10 блоков";
   private static final String f_7262 = "поджог";
   private static final String f_7263 = "snow";
   private static final String f_7264 = "Снежок заморозка";
   private static final String f_7265 = "снежок заморозка";
   private static final String f_7266 = "ледяная сфера";
   private static final String f_7267 = "радиус: 7 блоков";
   private static final String f_7268 = "заморозка";
   private static final String f_7269 = "слабость";
   private static final String f_7270 = "bojaura";
   private static final String f_7271 = "Божья аура";
   private static final String f_7272 = "божья аура";
   private static final String f_7273 = "божественная аура";
   private static final String f_7274 = "радиус: 2 блока";
   private static final String f_7275 = "снятие всех эффектов";
   private static final String f_7276 = "невидимость";
   private static final String f_7277 = "hlopushka";
   private static final String f_7278 = "Хлопушка";
   private static final String f_7279 = "хлопушка";
   private static final String f_7280 = "holywater";
   private static final String f_7281 = "Святая вода";
   private static final String f_7282 = "святая вода";
   private static final String f_7283 = "gnev";
   private static final String f_7284 = "Зелье Гнева";
   private static final String f_7285 = "зелье гнева";
   private static final String f_7286 = "paladin";
   private static final String f_7287 = "Зелье Палладина";
   private static final String f_7288 = "зелье палладина";
   private static final String f_7289 = "assassin";
   private static final String f_7290 = "Зелье Ассасина";
   private static final String f_7291 = "зелье ассасина";
   private static final String f_7292 = "radiation";
   private static final String f_7293 = "Зелье Радиации";
   private static final String f_7294 = "зелье радиации";
   private static final String f_7295 = "snotvornoe";
   private static final String f_7296 = "Снотворное";
   private static final String f_7297 = "снотворное";
   private static final String f_7298 = "snow";
   private static final float f_7299 = 7.0F;
   private static final String f_7300 = "bojaura";
   private static final String f_7301 = "trap";
   private static final String f_7302 = "plast";
   private static final String f_7303 = "sugar";
   private static final float f_7304 = 10.0F;
   private static final String f_7305 = "fireSwirl";
   private static final float f_7306 = 10.0F;
   private static final String f_7307 = "disorientation";
   private static final float f_7308 = 10.0F;
   private static final String f_7309 = "hlopushka";
   private static final String f_7310 = "holywater";
   private static final String f_7311 = "gnev";
   private static final String f_7312 = "paladin";
   private static final String f_7313 = "assassin";
   private static final String f_7314 = "radiation";
   private static final String f_7315 = "snotvornoe";
   private static final double f_7316 = 150.0;
   private static final String f_7317 = "Instant";
   private static final long f_7318 = 40L;
   private static final String f_7319 = " ";
   private static final String f_7320 = " ";
   private static final String f_7321 = "§[0-9a-fk-or]";
   private static final int f_7322 = -11207596;
   private static final int f_7323 = -8249328;
   private static final float f_7324 = 255.0F;
   private static final float f_7325 = 255.0F;
   private static final float f_7326 = 255.0F;
   private static final float f_7327 = 0.03F;
   private static final float f_7328 = 0.18F;
   private static final double f_7329 = Math.PI * 2;
   private static final double f_7330 = Math.PI * 2;
   private static final float f_7331 = 0.08F;
   private static final float f_7332 = 0.08F;
   private static final float f_7333 = 0.22F;
   private static final float f_7334 = 0.22F;
   private static final double f_7335 = Math.PI * 2;
   private static final double f_7336 = Math.PI * 2;
   private static final double f_7337 = 1.99;
   private static final int f_7338 = -11207596;
   private static final int f_7339 = -8249328;
   private static final double f_7340 = 0.5;
   private static final double f_7341 = 0.5;
   private static final double f_7342 = 3.0;
   private static final double f_7343 = 0.08;
   private static final double f_7344 = 3.0;
   private static final double f_7345 = 4.0;
   private static final double f_7346 = 0.08;
   private static final double f_7347 = 0.08;
   private static final double f_7348 = 3.0;
   private static final double f_7349 = 0.08;
   private static final double f_7350 = 4.0;
   private static final double f_7351 = 3.0;
   private static final int f_7352 = -8249328;
   private static final int f_7353 = -8249328;
   private static final float f_7354 = 255.0F;
   private static final float f_7355 = 255.0F;
   private static final float f_7356 = 255.0F;

   private boolean m_3695(ItemStack var1, List<FuntimeHelper.BEuUyvLVYltdLYxg> var2) {
      PotionContentsComponent var3 = (PotionContentsComponent)var1.get(DataComponentTypes.POTION_CONTENTS);
      if (var3 == null) {
         return false;
      } else {
         HashMap var4 = new HashMap();

         for (StatusEffectInstance var6 : var3.getEffects()) {
            var4.put(var6.getEffectType(), var6.getAmplifier());
         }

         int var9 = 0;

         for (FuntimeHelper.BEuUyvLVYltdLYxg var7 : var2) {
            Integer var8 = (Integer)var4.get(var7.effect());
            if (var8 != null && var8 >= var7.minAmplifier()) {
               var9++;
            }
         }

         return var9 >= Math.min(2, var2.size());
      }
   }

   private List<String> m_804(ItemStack var1) {
      ArrayList var2 = new ArrayList();
      if (var1 != null && !var1.isEmpty()) {
         LoreComponent var3 = (LoreComponent)var1.get(DataComponentTypes.LORE);
         if (var3 != null) {
            for (Text var5 : var3.lines()) {
               String var6 = this.m_3896(var5);
               if (!var6.isEmpty()) {
                  var2.add(var6);
               }
            }
         }

         return var2;
      } else {
         return var2;
      }
   }

   private void m_2206(int var1) {
      this.f_7206 = f_5909.player.getInventory().getSelectedSlot();
      this.f_7207 = var1;
      this.f_7208 = -1;
      this.f_7209 = false;
      this.f_7204 = this.f_7183.m_2073(f_7317) ? FuntimeHelper.ciVlKWPiuydMAjDW.instant() : FuntimeHelper.ciVlKWPiuydMAjDW.legit();
      this.m_2708();
      this.f_7210 = true;
      this.f_7205 = System.currentTimeMillis();
      if (var1 >= 9 && this.f_7204.stopBeforeSwap()) {
         this.f_7203 = FuntimeHelper.Tl5itnNztq8uPcAl.SLOWING_DOWN;
      } else {
         this.f_7203 = FuntimeHelper.Tl5itnNztq8uPcAl.SWAP_TO_ITEM;
      }

      this.m_3271();
   }

   @EventHandler
   private void m_1727(Util88 var1) {
      if (f_5909.player != null && f_5909.world != null && !this.f_7201.isEmpty()) {
         MatrixStack var2 = var1.m_213();
         Vec3d var3 = f_5909.gameRenderer.getCamera().getCameraPos();
         Vec3d var4 = f_5909.player.getLerpedPos(var1.m_191());
         var2.push();
         var2.translate(-var3.x, -var3.y, -var3.z);

         for (FuntimeHelper.Inner_8jJesZhV8pIKaauY var6 : this.f_7199) {
            if (this.f_7201.contains(var6.itemKey()) && var6.renderKind() != FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.NONE) {
               FuntimeHelper.Inner_6McL3fEmUp3oxQbL var7 = this.f_7198.get(var6.itemKey());
               if (var7 != null && this.m_2699(var7) != -1) {
                  switch (var6.renderKind()) {
                     case NONE:
                     default:
                        break;
                     case RADIUS:
                        this.m_321(var2, var4, var6.distance(), this.m_2486(var6.distance()));
                        break;
                     case TRAP:
                        this.m_1755(var2, var4);
                        break;
                     case PLAST:
                        this.m_381(var2, var4);
                  }
               }
            }
         }

         var2.pop();
      }
   }

   private void m_940() {
      if (this.f_7209 && this.f_7207 >= 9 && this.f_7208 >= 0) {
         f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, this.f_7207, this.f_7208, SlotActionType.SWAP, f_5909.player);
         this.f_7209 = false;
      }

      if (this.f_7206 >= 0 && this.f_7206 < 9) {
         this.m_3062(this.f_7206);
      }
   }

   private void m_150() {
      if (f_5909.player != null && f_5909.interactionManager != null) {
         this.m_940();
      }

      this.m_1639();
      this.m_3502();
   }

   private void m_160() {
      if (this.f_7207 >= 0 && this.f_7207 < 36) {
         if (this.f_7207 < 9) {
            this.f_7208 = this.f_7207;
         } else {
            this.f_7208 = 8;
            f_5909.interactionManager.clickSlot(f_5909.player.currentScreenHandler.syncId, this.f_7207, this.f_7208, SlotActionType.SWAP, f_5909.player);
            this.f_7209 = true;
         }

         this.m_3062(this.f_7208);
      }
   }

   @EventHandler
   private void m_3098(CancellableEvent var1) {
      for (FuntimeHelper.Inner_8jJesZhV8pIKaauY var3 : this.f_7199) {
         if (var3.setting().m_1958() != -1 && var1.m_2169() == var3.setting().m_1958()) {
            if (var1.m_1362()) {
               if (!var1.m_3546()) {
                  this.f_7201.add(var3.itemKey());
               }
            } else {
               this.f_7201.remove(var3.itemKey());
               if (!var1.m_3546()) {
                  this.m_607(var3.itemKey());
               }
            }
         }
      }
   }

   private void m_2484() {
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7298, this.f_7184, f_7299, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.RADIUS));
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7300, this.f_7185, 2.0F, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.RADIUS));
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7301, this.f_7186, 0.0F, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.TRAP));
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7302, this.f_7187, 0.0F, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.PLAST));
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7303, this.f_7188, f_7304, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.RADIUS));
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7305, this.f_7189, f_7306, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.RADIUS));
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7307, this.f_7190, f_7308, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.RADIUS));
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7309, this.f_7191, 0.0F, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.NONE));
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7310, this.f_7192, 0.0F, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.NONE));
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7311, this.f_7193, 0.0F, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.NONE));
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7312, this.f_7194, 0.0F, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.NONE));
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7313, this.f_7195, 0.0F, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.NONE));
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7314, this.f_7196, 0.0F, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.NONE));
      this.f_7199.add(new FuntimeHelper.Inner_8jJesZhV8pIKaauY(f_7315, this.f_7197, 0.0F, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI.NONE));
   }

   @Override
   public void m_2() {
      this.m_265();
      super.m_2();
   }

   private void m_1639() {
      if (this.f_7210) {
         f_5909.options.forwardKey.setPressed(this.f_7211);
         f_5909.options.backKey.setPressed(this.f_7212);
         f_5909.options.leftKey.setPressed(this.f_7213);
         f_5909.options.rightKey.setPressed(this.f_7214);
         this.f_7210 = false;
      }
   }

   private void m_2513(
      BufferBuilder var1, Matrix4f var2, double var3, double var5, double var7, double var9, double var11, double var13, float var15, float var16, float var17
   ) {
      var1.vertex(var2, (float)var3, (float)var5, (float)var7).color(var15, var16, var17, 1.0F);
      var1.vertex(var2, (float)var9, (float)var11, (float)var13).color(var15, var16, var17, 1.0F);
   }

   private void m_321(MatrixStack var1, Vec3d var2, float var3, boolean var4) {
      int var5 = var4 ? f_7322 : f_7323;
      float var6 = (var5 >> 16 & 0xFF) / f_7324;
      float var7 = (var5 >> 8 & 0xFF) / f_7325;
      float var8 = (var5 & 0xFF) / f_7326;
      float var9 = (float)var2.y + f_7327;
      byte var10 = 96;
      float var11 = Math.max(0.0F, var3 - f_7328);
      Matrix4f var12 = var1.peek().getPositionMatrix();
      Util114.m_672();
      Util114.m_3978();
      Util114.m_1481();
      Util114.m_542();
      Util114.m_3784(RenderUtil7.f_13885);
      BufferBuilder var13 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);

      for (int var14 = 0; var14 < var10; var14++) {
         double var15 = f_7329 * var14 / var10;
         double var17 = f_7330 * (var14 + 1) / var10;
         float var19 = (float)var2.x + (float)Math.cos(var15) * var3;
         float var20 = (float)var2.z + (float)Math.sin(var15) * var3;
         float var21 = (float)var2.x + (float)Math.cos(var17) * var3;
         float var22 = (float)var2.z + (float)Math.sin(var17) * var3;
         float var23 = (float)var2.x + (float)Math.cos(var15) * var11;
         float var24 = (float)var2.z + (float)Math.sin(var15) * var11;
         float var25 = (float)var2.x + (float)Math.cos(var17) * var11;
         float var26 = (float)var2.z + (float)Math.sin(var17) * var11;
         var13.vertex(var12, var23, var9, var24).color(var6, var7, var8, f_7331);
         var13.vertex(var12, var25, var9, var26).color(var6, var7, var8, f_7332);
         var13.vertex(var12, var21, var9, var22).color(var6, var7, var8, f_7333);
         var13.vertex(var12, var19, var9, var20).color(var6, var7, var8, f_7334);
      }

      RenderUtil12.I(var13.end());
      BufferBuilder var27 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

      for (int var28 = 0; var28 < var10; var28++) {
         double var16 = f_7335 * var28 / var10;
         double var18 = f_7336 * (var28 + 1) / var10;
         var27.vertex(var12, (float)var2.x + (float)Math.cos(var16) * var3, var9, (float)var2.z + (float)Math.sin(var16) * var3).color(var6, var7, var8, 1.0F);
         var27.vertex(var12, (float)var2.x + (float)Math.cos(var18) * var3, var9, (float)var2.z + (float)Math.sin(var18) * var3).color(var6, var7, var8, 1.0F);
      }

      RenderUtil12.I(var27.end());
      Util114.m_100();
      Util114.m_1562();
      Util114.m_963();
   }

   private FuntimeHelper.BEuUyvLVYltdLYxg m_475(RegistryEntry<StatusEffect> var1, int var2) {
      return new FuntimeHelper.BEuUyvLVYltdLYxg(var1, var2);
   }

   private void m_381(MatrixStack var1, Vec3d var2) {
      double var3 = Math.floor(var2.x) + f_7340;
      double var5 = Math.floor(var2.y);
      double var7 = Math.floor(var2.z) + f_7341;
      Box var9 = new Box(var3 - f_7342, var5, var7 - f_7343, var3 + f_7344, var5 + f_7345, var7 + f_7346);
      Box var10 = new Box(var3 - f_7347, var5, var7 - f_7348, var3 + f_7349, var5 + f_7350, var7 + f_7351);
      RenderUtil25.m_724(var9, f_7352, true, true);
      RenderUtil25.m_724(var10, f_7353, true, true);
      RenderUtil25.m_1569(var1);
   }

   private void m_3271() {
      f_5909.options.forwardKey.setPressed(false);
      f_5909.options.backKey.setPressed(false);
      f_5909.options.leftKey.setPressed(false);
      f_5909.options.rightKey.setPressed(false);
      if (f_5909.player != null && f_5909.player.isSprinting()) {
         f_5909.player.setSprinting(false);
      }
   }

   private int m_2699(FuntimeHelper.Inner_6McL3fEmUp3oxQbL var1) {
      if (f_5909.player == null) {
         return -1;
      } else {
         for (int var2 = 0; var2 < 36; var2++) {
            ItemStack var3 = f_5909.player.getInventory().getStack(var2);
            if (!var3.isEmpty() && var3.isOf(var1.item()) && !var1.effects().isEmpty() && this.m_3695(var3, var1.effects())) {
               return var2;
            }
         }

         for (int var5 = 0; var5 < 36; var5++) {
            ItemStack var7 = f_5909.player.getInventory().getStack(var5);
            if (!var7.isEmpty() && var7.isOf(var1.item()) && !var1.loreKeywords().isEmpty() && this.m_3563(var7, var1.loreKeywords())) {
               return var5;
            }
         }

         for (int var6 = 0; var6 < 36; var6++) {
            ItemStack var8 = f_5909.player.getInventory().getStack(var6);
            if (!var8.isEmpty() && var8.isOf(var1.item())) {
               List var4 = this.m_804(var8);
               if (!var4.isEmpty()) {
                  if (String.join(f_7319, var4).contains(var1.nameFallback())) {
                     return var6;
                  }
               } else if (this.m_3896(var8.getName()).contains(var1.nameFallback())) {
                  return var6;
               }
            }
         }

         return -1;
      }
   }

   private FuntimeHelper.Inner_6McL3fEmUp3oxQbL m_4109(String var1, String var2, FuntimeHelper.BEuUyvLVYltdLYxg... var3) {
      return new FuntimeHelper.Inner_6McL3fEmUp3oxQbL(Items.SPLASH_POTION, var1, var2, List.of(), List.of(var3));
   }

   private void m_3502() {
      this.f_7203 = FuntimeHelper.Tl5itnNztq8uPcAl.IDLE;
      this.f_7205 = 0L;
      this.f_7206 = -1;
      this.f_7207 = -1;
      this.f_7208 = -1;
      this.f_7209 = false;
      this.f_7210 = false;
      this.f_7211 = false;
      this.f_7212 = false;
      this.f_7213 = false;
      this.f_7214 = false;
   }

   private boolean m_3563(ItemStack var1, List<String> var2) {
      List var3 = this.m_804(var1);
      if (var3.isEmpty()) {
         return false;
      } else {
         String var4 = String.join(f_7320, var3);
         int var5 = 0;

         for (String var7 : var2) {
            if (var4.contains(var7.toLowerCase(Locale.ROOT))) {
               var5++;
            }
         }

         return var5 >= Math.min(2, var2.size());
      }
   }

   private void m_1169() {
      long var1 = System.currentTimeMillis();
      long var3 = var1 - this.f_7205;
      switch (this.f_7203) {
         case IDLE:
         default:
            break;
         case SLOWING_DOWN:
            this.m_3271();
            if (var3 >= this.f_7204.preStopDelay()) {
               this.f_7203 = FuntimeHelper.Tl5itnNztq8uPcAl.WAITING_STOP;
            }
            break;
         case WAITING_STOP:
            this.m_3271();
            Vec3d var5 = f_5909.player.getVelocity();
            boolean var6 = Math.abs(var5.x) < this.f_7204.velocityThreshold() && Math.abs(var5.z) < this.f_7204.velocityThreshold();
            if (var6 || var3 >= this.f_7204.waitStopDelay()) {
               this.f_7203 = FuntimeHelper.Tl5itnNztq8uPcAl.SWAP_TO_ITEM;
               this.f_7205 = var1;
            }
            break;
         case SWAP_TO_ITEM:
            if (var3 >= this.f_7204.preSwapDelay()) {
               this.m_160();
               this.f_7203 = FuntimeHelper.Tl5itnNztq8uPcAl.USE_ITEM;
               this.f_7205 = var1;
            }
            break;
         case USE_ITEM:
            if (var3 >= f_7318) {
               f_5909.interactionManager.interactItem(f_5909.player, Hand.MAIN_HAND);
               f_5909.player.swingHand(Hand.MAIN_HAND);
               this.f_7203 = FuntimeHelper.Tl5itnNztq8uPcAl.SWAP_BACK;
               this.f_7205 = var1;
            }
            break;
         case SWAP_BACK:
            if (var3 >= this.f_7204.postSwapDelay()) {
               this.m_940();
               this.m_1639();
               this.f_7203 = FuntimeHelper.Tl5itnNztq8uPcAl.SPEEDING_UP;
               this.f_7205 = var1;
            }
            break;
         case SPEEDING_UP:
            if (var3 >= this.f_7204.resumeDelay()) {
               this.m_3502();
            }
      }
   }

   private void m_607(String var1) {
      if (f_5909.player != null) {
         FuntimeHelper.Inner_6McL3fEmUp3oxQbL var2 = this.f_7198.get(var1);
         int var3 = var2 == null ? -1 : this.m_2699(var2);
         if (var3 != -1) {
            ItemStack var4 = f_5909.player.getInventory().getStack(var3);
            if (!f_5909.player.getItemCooldownManager().isCoolingDown(var4) && !this.f_7200.contains(var1)) {
               this.f_7200.addLast(var1);
            }
         }
      }
   }

   private void m_543(MatrixStack var1, Box var2, int var3) {
      RenderUtil25.m_724(var2, var3, true, true);
      RenderUtil25.m_1569(var1);
      this.m_2080(var1, var2, var3);
   }

   public FuntimeHelper() {
      super(f_7215, f_7216, Category.MISCELLANEOUS);
      this.f_7183 = new ModeSetting(f_7217, f_7218, f_7219, f_7220);
      this.f_7184 = new RenderUtil22(f_7221);
      this.f_7185 = new RenderUtil22(f_7222);
      this.f_7186 = new RenderUtil22(f_7223);
      this.f_7187 = new RenderUtil22(f_7224);
      this.f_7188 = new RenderUtil22(f_7225);
      this.f_7189 = new RenderUtil22(f_7226);
      this.f_7190 = new RenderUtil22(f_7227);
      this.f_7191 = new RenderUtil22(f_7228);
      this.f_7192 = new RenderUtil22(f_7229);
      this.f_7193 = new RenderUtil22(f_7230);
      this.f_7194 = new RenderUtil22(f_7231);
      this.f_7195 = new RenderUtil22(f_7232);
      this.f_7196 = new RenderUtil22(f_7233);
      this.f_7197 = new RenderUtil22(f_7234);
      this.f_7198 = new LinkedHashMap<>();
      this.f_7199 = new ArrayList<>();
      this.f_7200 = new ArrayDeque<>();
      this.f_7201 = new HashSet<>();
      this.f_7202 = new Util125();
      this.f_7203 = FuntimeHelper.Tl5itnNztq8uPcAl.IDLE;
      this.f_7204 = FuntimeHelper.ciVlKWPiuydMAjDW.instant();
      this.f_7206 = -1;
      this.f_7207 = -1;
      this.f_7208 = -1;
      this.m_1832();
      this.m_2484();
   }

   private void m_265() {
      this.f_7200.clear();
      this.f_7201.clear();
      this.f_7202.m_3493();
      this.m_3502();
   }

   private String m_3896(Text var1) {
      return var1.getString().toLowerCase(Locale.ROOT).replaceAll(f_7321, "");
   }

   private void m_1832() {
      this.f_7198.put(f_7235, new FuntimeHelper.Inner_6McL3fEmUp3oxQbL(Items.SUGAR, f_7236, f_7237, List.of(f_7238, f_7239, f_7240, f_7241), List.of()));
      this.f_7198.put(f_7242, new FuntimeHelper.Inner_6McL3fEmUp3oxQbL(Items.ENDER_EYE, f_7243, f_7244, List.of(f_7245), List.of()));
      this.f_7198.put(f_7246, new FuntimeHelper.Inner_6McL3fEmUp3oxQbL(Items.NETHERITE_SCRAP, f_7247, f_7248, List.of(f_7249, f_7250), List.of()));
      this.f_7198.put(f_7251, new FuntimeHelper.Inner_6McL3fEmUp3oxQbL(Items.DRIED_KELP, f_7252, f_7253, List.of(f_7254, f_7255, f_7256), List.of()));
      this.f_7198.put(f_7257, new FuntimeHelper.Inner_6McL3fEmUp3oxQbL(Items.FIRE_CHARGE, f_7258, f_7259, List.of(f_7260, f_7261, f_7262), List.of()));
      this.f_7198.put(f_7263, new FuntimeHelper.Inner_6McL3fEmUp3oxQbL(Items.SNOWBALL, f_7264, f_7265, List.of(f_7266, f_7267, f_7268, f_7269), List.of()));
      this.f_7198
         .put(f_7270, new FuntimeHelper.Inner_6McL3fEmUp3oxQbL(Items.PHANTOM_MEMBRANE, f_7271, f_7272, List.of(f_7273, f_7274, f_7275, f_7276), List.of()));
      this.f_7198
         .put(
            f_7277,
            this.m_4109(
               f_7278,
               f_7279,
               this.m_475(StatusEffects.SLOWNESS, 9),
               this.m_475(StatusEffects.SPEED, 4),
               this.m_475(StatusEffects.BLINDNESS, 9),
               this.m_475(StatusEffects.GLOWING, 0)
            )
         );
      this.f_7198
         .put(
            f_7280,
            this.m_4109(
               f_7281,
               f_7282,
               this.m_475(StatusEffects.REGENERATION, 2),
               this.m_475(StatusEffects.INVISIBILITY, 1),
               this.m_475(StatusEffects.INSTANT_HEALTH, 1)
            )
         );
      this.f_7198.put(f_7283, this.m_4109(f_7284, f_7285, this.m_475(StatusEffects.STRENGTH, 4), this.m_475(StatusEffects.SLOWNESS, 3)));
      this.f_7198
         .put(
            f_7286,
            this.m_4109(
               f_7287,
               f_7288,
               this.m_475(StatusEffects.RESISTANCE, 0),
               this.m_475(StatusEffects.FIRE_RESISTANCE, 0),
               this.m_475(StatusEffects.INVISIBILITY, 0),
               this.m_475(StatusEffects.HEALTH_BOOST, 2)
            )
         );
      this.f_7198
         .put(
            f_7289,
            this.m_4109(
               f_7290,
               f_7291,
               this.m_475(StatusEffects.STRENGTH, 3),
               this.m_475(StatusEffects.SPEED, 2),
               this.m_475(StatusEffects.HASTE, 0),
               this.m_475(StatusEffects.INSTANT_DAMAGE, 1)
            )
         );
      this.f_7198
         .put(
            f_7292,
            this.m_4109(
               f_7293,
               f_7294,
               this.m_475(StatusEffects.POISON, 1),
               this.m_475(StatusEffects.WITHER, 1),
               this.m_475(StatusEffects.SLOWNESS, 2),
               this.m_475(StatusEffects.HUNGER, 4),
               this.m_475(StatusEffects.GLOWING, 0)
            )
         );
      this.f_7198
         .put(
            f_7295,
            this.m_4109(
               f_7296,
               f_7297,
               this.m_475(StatusEffects.WEAKNESS, 1),
               this.m_475(StatusEffects.MINING_FATIGUE, 1),
               this.m_475(StatusEffects.WITHER, 2),
               this.m_475(StatusEffects.BLINDNESS, 0)
            )
         );
   }

   private boolean m_3714(PlayerEntity var1) {
      return InitManager.f_2740.f_2744 != null && InitManager.f_2740.f_2744.m_2704(var1.getGameProfile().name());
   }

   private void m_1755(MatrixStack var1, Vec3d var2) {
      BlockPos var3 = BlockPos.ofFloored(var2).up();
      Box var4 = new Box(var3).expand(f_7337);
      boolean var5 = f_5909.world
         .getPlayers()
         .stream()
         .anyMatch(var2x -> var2x != f_5909.player && !this.m_3714(var2x) && var4.intersects(var2x.getBoundingBox()));
      this.m_543(var1, var4, var5 ? f_7338 : f_7339);
   }

   private void m_3062(int var1) {
      if (var1 >= 0 && var1 <= 8 && f_5909.player != null && f_5909.getNetworkHandler() != null) {
         f_5909.getNetworkHandler().sendPacket(new UpdateSelectedSlotC2SPacket(var1));
         f_5909.player.getInventory().setSelectedSlot(var1);
      }
   }

   private boolean m_2486(float var1) {
      return f_5909.world.getPlayers().stream().anyMatch(var2 -> var2 != f_5909.player && !this.m_3714(var2) && f_5909.player.distanceTo(var2) <= var1);
   }

   private void m_3413() {
      if (this.f_7203 == FuntimeHelper.Tl5itnNztq8uPcAl.IDLE && !this.f_7200.isEmpty() && this.f_7202.m_2884(f_7316)) {
         String var1 = this.f_7200.removeFirst();
         FuntimeHelper.Inner_6McL3fEmUp3oxQbL var2 = this.f_7198.get(var1);
         if (var2 != null) {
            int var3 = this.m_2699(var2);
            if (var3 != -1) {
               ItemStack var4 = f_5909.player.getInventory().getStack(var3);
               if (!f_5909.player.getItemCooldownManager().isCoolingDown(var4)) {
                  this.m_2206(var3);
               }
            }
         }

         this.f_7202.m_3493();
      }
   }

   private void m_2708() {
      this.f_7211 = f_5909.options.forwardKey.isPressed();
      this.f_7212 = f_5909.options.backKey.isPressed();
      this.f_7213 = f_5909.options.leftKey.isPressed();
      this.f_7214 = f_5909.options.rightKey.isPressed();
   }

   @EventHandler
   private void m_2957(Util170 var1) {
      if (f_5909.player == null || f_5909.world == null || f_5909.interactionManager == null) {
         this.m_150();
      } else if (f_5909.currentScreen == null) {
         if (this.f_7203 != FuntimeHelper.Tl5itnNztq8uPcAl.IDLE && this.f_7203 != FuntimeHelper.Tl5itnNztq8uPcAl.SPEEDING_UP) {
            this.m_3271();
         }

         if (this.f_7203 != FuntimeHelper.Tl5itnNztq8uPcAl.IDLE) {
            this.m_1169();
         }

         this.m_3413();
      }
   }

   @Override
   public void m_1() {
      this.m_150();
      this.m_265();
      super.m_1();
   }

   private void m_2080(MatrixStack var1, Box var2, int var3) {
      float var4 = (var3 >> 16 & 0xFF) / f_7354;
      float var5 = (var3 >> 8 & 0xFF) / f_7355;
      float var6 = (var3 & 0xFF) / f_7356;
      Matrix4f var7 = var1.peek().getPositionMatrix();
      Util114.m_672();
      Util114.m_3978();
      Util114.m_1481();
      Util114.m_542();
      Util114.m_3784(RenderUtil7.f_13885);
      BufferBuilder var8 = Tessellator.getInstance().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
      this.m_2513(var8, var7, var2.minX, var2.minY, var2.minZ, var2.maxX, var2.maxY, var2.minZ, var4, var5, var6);
      this.m_2513(var8, var7, var2.maxX, var2.minY, var2.minZ, var2.minX, var2.maxY, var2.minZ, var4, var5, var6);
      this.m_2513(var8, var7, var2.minX, var2.minY, var2.maxZ, var2.maxX, var2.maxY, var2.maxZ, var4, var5, var6);
      this.m_2513(var8, var7, var2.maxX, var2.minY, var2.maxZ, var2.minX, var2.maxY, var2.maxZ, var4, var5, var6);
      this.m_2513(var8, var7, var2.minX, var2.minY, var2.minZ, var2.minX, var2.maxY, var2.maxZ, var4, var5, var6);
      this.m_2513(var8, var7, var2.minX, var2.minY, var2.maxZ, var2.minX, var2.maxY, var2.minZ, var4, var5, var6);
      this.m_2513(var8, var7, var2.maxX, var2.minY, var2.minZ, var2.maxX, var2.maxY, var2.maxZ, var4, var5, var6);
      this.m_2513(var8, var7, var2.maxX, var2.minY, var2.maxZ, var2.maxX, var2.maxY, var2.minZ, var4, var5, var6);
      RenderUtil12.I(var8.end());
      Util114.m_100();
      Util114.m_1562();
      Util114.m_963();
   }

   private record BEuUyvLVYltdLYxg(RegistryEntry<StatusEffect> effect, int minAmplifier) {
   }

   private static enum Inner_5ntGvn4LMZqJa1YI {
      NONE,
      RADIUS,
      TRAP,
      PLAST;
   }

   private record Inner_6McL3fEmUp3oxQbL(
      Item item, String displayName, String nameFallback, List<String> loreKeywords, List<FuntimeHelper.BEuUyvLVYltdLYxg> effects
   ) {
   }

   private record Inner_8jJesZhV8pIKaauY(String itemKey, RenderUtil22 setting, float distance, FuntimeHelper.Inner_5ntGvn4LMZqJa1YI renderKind) {
   }

   private static enum Tl5itnNztq8uPcAl {
      IDLE,
      SLOWING_DOWN,
      WAITING_STOP,
      SWAP_TO_ITEM,
      USE_ITEM,
      SWAP_BACK,
      SPEEDING_UP;
   }

   private record ciVlKWPiuydMAjDW(
      boolean stopBeforeSwap, int preStopDelay, int waitStopDelay, int preSwapDelay, int postSwapDelay, int resumeDelay, double velocityThreshold
   ) {
      private static FuntimeHelper.ciVlKWPiuydMAjDW legit() {
         ThreadLocalRandom var0 = ThreadLocalRandom.current();
         return new FuntimeHelper.ciVlKWPiuydMAjDW(
            true, var0.nextInt(35, 66), var0.nextInt(95, 151), var0.nextInt(45, 81), var0.nextInt(95, 151), var0.nextInt(35, 71), 0.03
         );
      }

      private static FuntimeHelper.ciVlKWPiuydMAjDW instant() {
         return new FuntimeHelper.ciVlKWPiuydMAjDW(false, 0, 0, 0, 40, 0, 0.0);
      }
   }
}
