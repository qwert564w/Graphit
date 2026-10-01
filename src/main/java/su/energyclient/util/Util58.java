package su.energyclient.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import su.energyclient.QuickImports;
import su.energyclient.module.miscellaneous.AutoBuy;
import su.energyclient.render.RenderUtil2;

public class Util58 extends Screen implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private final Util147 f_8506;
   private final AutoBuy f_8507;
   private float f_8508;
   private float f_8509;
   private final float f_8510;
   private final float f_8511;
   private final float f_8512;
   private final Util165 f_8513;
   private boolean f_8514;
   private float f_8515;
   private float f_8516;
   private float f_8517;
   private float f_8518;
   private float f_8519;
   private Util58.oPYFND4ROeKbw7Gd f_8520;
   private String f_8521;
   private boolean f_8522;
   private final Util23 f_8523;
   private final Util23 f_8524;
   private final Util23 f_8525;
   private final List<Util171> f_8526;
   private List<Util55> f_8527;
   private static final String f_8528 = "AutoBuy";
   private static final float f_8529 = 528.0F;
   private static final float f_8530 = 286.0F;
   private static final float f_8531 = 170.0F;
   private static final long f_8532 = 180L;
   private static final String f_8533 = "Спарсить цены";
   private static final String f_8534 = "FunTime";
   private static final String f_8535 = "HolyWorld";
   private static final String f_8536 = "Тотем бессмертия";
   private static final long f_8537 = 152000L;
   private static final long f_8538 = 20000L;
   private static final String f_8539 = "Тотем бессмертия";
   private static final long f_8540 = 148000L;
   private static final long f_8541 = 90000L;
   private static final String f_8542 = "Тотем бессмертия";
   private static final long f_8543 = 155000L;
   private static final long f_8544 = 300000L;
   private static final String f_8545 = "Тотем бессмертия";
   private static final long f_8546 = 149000L;
   private static final long f_8547 = 3600000L;
   private static final String f_8548 = "Тотем бессмертия";
   private static final long f_8549 = 160000L;
   private static final long f_8550 = 86400000L;
   private static final float f_8551 = 0.01F;
   private static final float f_8552 = 528.0F;
   private static final float f_8553 = 286.0F;
   private static final float f_8554 = 10.0F;
   private static final float f_8555 = 10.0F;
   private static final float f_8556 = 255.0F;
   private static final int f_8557 = 1118481;
   private static final float f_8558 = 125.0F;
   private static final float f_8559 = 528.0F;
   private static final float f_8560 = 286.0F;
   private static final float f_8561 = 24.0F;
   private static final int f_8562 = 856083;
   private static final float f_8563 = 220.0F;
   private static final float f_8564 = 528.0F;
   private static final float f_8565 = 286.0F;
   private static final float f_8566 = 24.0F;
   private static final int f_8567 = 1316892;
   private static final float f_8568 = 200.0F;
   private static final float f_8569 = 170.0F;
   private static final float f_8570 = 33.0F;
   private static final double f_8571 = 357.0;
   private static final double f_8572 = 253.0;
   private static final float f_8573 = 24.0F;
   private static final float f_8574 = 16.0F;
   private static final float f_8575 = 122.0F;
   private static final String f_8576 = "AutoBuy";
   private static final int f_8577 = 16777215;
   private static final float f_8578 = 0.66F;
   private static final float f_8579 = 20.0F;
   private static final String f_8580 = "ПАРСЕР";
   private static final int f_8581 = 16777215;
   private static final float f_8582 = 0.1F;
   private static final float f_8583 = 11.0F;
   private static final int f_8584 = 16777215;
   private static final float f_8585 = 0.66F;
   private static final float f_8586 = 13.0F;
   private static final String f_8587 = "Парсинг...";
   private static final String f_8588 = "Спарсить цены";
   private static final float f_8589 = 20.0F;
   private static final float f_8590 = 28.0F;
   private static final String f_8591 = "ПОСЛЕДНИЕ ПОКУПКИ";
   private static final int f_8592 = 16777215;
   private static final float f_8593 = 0.1F;
   private static final float f_8594 = 11.0F;
   private static final float f_8595 = 286.0F;
   private static final double f_8596 = 170.0;
   private static final float f_8597 = 54.0F;
   private static final float f_8598 = 18.0F;
   private static final float f_8599 = 34.0F;
   private static final float f_8600 = 170.0F;
   private static final float f_8601 = 24.0F;
   private static final String f_8602 = "FunTime";
   private static final float f_8603 = 16.0F;
   private static final String f_8604 = "HolyWorld";
   private static final float f_8605 = 16.0F;
   private static final float f_8606 = 6.0F;
   private static final float f_8607 = 120.0F;
   private static final float f_8608 = 528.0F;
   private static final float f_8609 = 24.0F;
   private static final float f_8610 = 4.0F;
   private static final int f_8611 = 16777215;
   private static final float f_8612 = 0.07F;
   private static final float f_8613 = 0.04F;
   private static final String f_8614 = "Найти предмет...";
   private static final int f_8615 = 16777215;
   private static final float f_8616 = 0.2F;
   private static final int f_8617 = 16777215;
   private static final float f_8618 = 0.7F;
   private static final float f_8619 = 6.0F;
   private static final float f_8620 = 12.0F;
   private static final float f_8621 = 170.0F;
   private static final float f_8622 = 24.0F;
   private static final float f_8623 = 42.0F;
   private static final float f_8624 = 10.0F;
   private static final float f_8625 = 10.0F;
   private static final float f_8626 = 150.0F;
   private static final float f_8627 = 58.0F;
   private static final float f_8628 = 58.0F;
   private static final float f_8629 = 36.0F;
   private static final float f_8630 = 286.0F;
   private static final float f_8631 = 8.0F;
   private static final float f_8632 = 18.0F;
   private static final float f_8633 = 34.0F;
   private static final float f_8634 = 170.0F;
   private static final float f_8635 = 24.0F;
   private static final String f_8636 = "FunTime";
   private static final float f_8637 = 16.0F;
   private static final String f_8638 = "HolyWorld";
   private static final float f_8639 = 16.0F;
   private static final float f_8640 = 120.0F;
   private static final float f_8641 = 528.0F;
   private static final float f_8642 = 24.0F;
   private static final float f_8643 = 6.0F;
   private static final float f_8644 = 24.0F;
   private static final float f_8645 = 122.0F;
   private static final float f_8646 = 16.0F;
   private static final float f_8647 = 20.0F;
   private static final float f_8648 = 11.0F;
   private static final float f_8649 = 13.0F;
   private static final float f_8650 = 20.0F;
   private static final float f_8651 = 170.0F;
   private static final float f_8652 = 33.0F;
   private static final float f_8653 = 357.0F;
   private static final float f_8654 = 253.0F;
   private static final float f_8655 = 170.0F;
   private static final float f_8656 = 24.0F;
   private static final float f_8657 = 42.0F;
   private static final float f_8658 = 10.0F;
   private static final float f_8659 = 10.0F;
   private static final float f_8660 = 150.0F;
   private static final float f_8661 = 58.0F;
   private static final float f_8662 = 170.0F;
   private static final float f_8663 = 286.0F;
   private static final float f_8664 = 54.0F;
   private static final float f_8665 = 4.0F;
   private static final float f_8666 = 16.0F;
   private static final float f_8667 = 286.0F;
   private static final float f_8668 = 20.0F;
   private static final double f_8669 = 2.0;
   private static final float f_8670 = 68.0F;
   private static final float f_8671 = 230.0F;
   private static final float f_8672 = 22.0F;

   private void renderHeader(DrawContext var1, int var2, int var3, int var4) {
      float var5 = f_8598;
      float var6 = this.f_8509 + (f_8599 - var5) / 2.0F;
      float var7 = this.f_8508 + f_8600 + f_8601;
      float var8 = Util93.f_6001[13].m_585(f_8602) + f_8603;
      float var9 = Util93.f_6001[13].m_585(f_8604) + f_8605;
      this.f_8524.m_489(this.f_8520 == Util58.oPYFND4ROeKbw7Gd.FUN_TIME);
      this.f_8525.m_489(this.f_8520 == Util58.oPYFND4ROeKbw7Gd.HOLY_WORLD);
      this.f_8524.m_3005(var1, var7, var6, var8, var5, var2, var3, var4);
      this.f_8525.m_3005(var1, var7 + var8 + f_8606, var6, var9, var5, var2, var3, var4);
      float var10 = f_8607;
      float var11 = this.f_8508 + f_8608 - f_8609 - var10;
      Util158.m_1849(var11, var6, var10, var5, f_8610, Util71.m_3389(f_8611, (int)(var2 * (this.f_8522 ? f_8612 : f_8613))));
      String var12 = this.f_8521.isBlank() ? f_8614 : this.f_8521;
      int var13 = this.f_8521.isBlank() ? Util71.m_3389(f_8615, (int)(var2 * f_8616)) : Util71.m_3389(f_8617, (int)(var2 * f_8618));
      float var14 = Util93.f_6001[13].m_619();
      Util93.f_6001[13].m_1904(var1, var12, var11 + f_8619, var6 + (var5 - var14) / 2.0F + 1.0F, var13, var10 - f_8620);
   }

   public void render(DrawContext var1, int var2, int var3, float var4) {
      if (this.client != null && this.client.getWindow() != null) {
         this.f_8513.m_3631(this.f_8514 ? 0.0 : 1.0);
         float var5 = (float)this.f_8513.m_2276();
         if (this.f_8514 && var5 <= f_8551) {
            this.f_8506.m_3447();
            super.close();
         } else {
            this.f_8508 = (this.client.getWindow().getScaledWidth() - f_8552) / 2.0F;
            this.f_8509 = (this.client.getWindow().getScaledHeight() - f_8553) / 2.0F;
            this.f_8516 = Util39.m_3959(this.f_8516, this.f_8515, f_8554);
            this.f_8518 = Util39.m_3959(this.f_8518, this.f_8517, f_8555);
            int var6 = (int)(f_8556 * var5);
            var1.fill(0, 0, this.client.getWindow().getScaledWidth(), this.client.getWindow().getScaledHeight(), Util71.m_3389(f_8557, (int)(f_8558 * var5)));
            Util158.m_1031(this.f_8508, this.f_8509, f_8559, f_8560, f_8561, Util71.m_3389(f_8562, (int)(f_8563 * var5)), var5);
            Util158.m_335(this.f_8508, this.f_8509, f_8564, f_8565, f_8566, Util71.m_3389(f_8567, (int)(f_8568 * var5)));
            this.renderSidebar(var1, var6, var2, var3);
            this.renderHeader(var1, var6, var2, var3);
            RenderUtil2.m_3624(this.f_8508 + f_8569 + 1.0F, this.f_8509 + f_8570, f_8571, f_8572);
            this.renderCards(var1, var6, var2, var3);
            RenderUtil2.m_1647();
         }
      }
   }

   private void onParseClick() {
      if (!this.f_8506.m_3351() && this.f_8507 != null) {
         this.f_8506.m_3707((int)this.f_8507.l().m_4046());
      }
   }

   private void renderCards(DrawContext var1, int var2, int var3, int var4) {
      float var5 = this.f_8508 + f_8621 + f_8622;
      float var6 = this.f_8509 + f_8623 + this.f_8516;
      float var7 = f_8624;
      float var8 = f_8625;
      byte var9 = 2;
      List var10 = this.filteredCards();

      for (int var11 = 0; var11 < var10.size(); var11++) {
         Util55 var12 = (Util55)var10.get(var11);
         int var13 = var11 / var9;
         int var14 = var11 % var9;
         float var15 = var5 + var14 * (f_8626 + var7);
         float var16 = var6 + var13 * (f_8627 + var8);
         if (!(var16 + f_8628 < this.f_8509 + f_8629) && !(var16 > this.f_8509 + f_8630 - f_8631)) {
            var12.m_387(var1, var15, var16, var2, var3, var4);
         }
      }
   }

   private void rebuildCards() {
      this.f_8527 = this.f_8506.m_3250().stream().map(Util55::new).collect(Collectors.toList());
   }

   protected void init() {
      this.f_8514 = false;
      this.rebuildCards();
   }

   public void close() {
      if (!this.f_8514) {
         this.f_8514 = true;
      } else {
         super.close();
      }
   }

   public Util58(Util147 var1, AutoBuy var2) {
      super(Text.literal(f_8528));
      this.f_8510 = f_8529;
      this.f_8511 = f_8530;
      this.f_8512 = f_8531;
      this.f_8513 = new Util165(Util153.EASE_OUT_CUBIC, f_8532);
      this.f_8520 = Util58.oPYFND4ROeKbw7Gd.HOLY_WORLD;
      this.f_8521 = "";
      this.f_8522 = false;
      this.f_8523 = new Util23(f_8533, this::onParseClick);
      this.f_8524 = new Util23(f_8534, () -> {
         this.f_8520 = Util58.oPYFND4ROeKbw7Gd.FUN_TIME;
         this.f_8522 = false;
      });
      this.f_8525 = new Util23(f_8535, () -> {
         this.f_8520 = Util58.oPYFND4ROeKbw7Gd.HOLY_WORLD;
         this.f_8522 = false;
      });
      this.f_8526 = List.of(
         new Util171(Items.TOTEM_OF_UNDYING, f_8536, f_8537, System.currentTimeMillis() - f_8538),
         new Util171(Items.TOTEM_OF_UNDYING, f_8539, f_8540, System.currentTimeMillis() - f_8541),
         new Util171(Items.TOTEM_OF_UNDYING, f_8542, f_8543, System.currentTimeMillis() - f_8544),
         new Util171(Items.TOTEM_OF_UNDYING, f_8545, f_8546, System.currentTimeMillis() - f_8547),
         new Util171(Items.TOTEM_OF_UNDYING, f_8548, f_8549, System.currentTimeMillis() - f_8550)
      );
      this.f_8527 = new ArrayList<>();
      this.f_8506 = var1;
      this.f_8507 = var2;
   }

   public boolean charTyped(CharInput var1) {
      int var2 = var1.modifiers();
      String var3 = var1.asString();
      if (this.f_8522 && !var3.isEmpty() && !Character.isISOControl(var1.codepoint())) {
         if (this.f_8521.length() < 20) {
            this.f_8521 = this.f_8521 + var3;
            this.f_8515 = 0.0F;
         }

         return true;
      } else {
         for (Util55 var5 : this.f_8527) {
            if (var5.m_860() && var3.length() == 1 && var5.m_802(var3.charAt(0), var2)) {
               return true;
            }
         }

         return super.charTyped(var1);
      }
   }

   public boolean keyPressed(KeyInput var1) {
      int var2 = var1.key();
      int var3 = var1.scancode();
      int var4 = var1.modifiers();
      if (this.f_8522) {
         if (var2 == 256 || var2 == 257) {
            this.f_8522 = false;
            return true;
         }

         if (var2 == 259) {
            if (!this.f_8521.isEmpty()) {
               this.f_8521 = this.f_8521.substring(0, this.f_8521.length() - 1);
               this.f_8515 = 0.0F;
            }

            return true;
         }

         if (var1.hasCtrlOrCmd() && var2 == 86) {
            String var7 = f_5909.keyboard.getClipboard();
            if (var7 != null && !var7.isBlank()) {
               String var8 = this.f_8521 + var7;
               this.f_8521 = var8.substring(0, Math.min(var8.length(), 20));
               this.f_8515 = 0.0F;
            }

            return true;
         }
      }

      for (Util55 var6 : this.f_8527) {
         if (var6.m_860() && var6.m_1157(var2, var3, var4)) {
            return true;
         }
      }

      return super.keyPressed(var1);
   }

   private List<Util55> filteredCards() {
      if (this.f_8521.isBlank()) {
         return this.f_8527;
      } else {
         String var1 = this.f_8521.toLowerCase();
         return this.f_8527.stream().filter(var1x -> var1x.m_348().f_1757.toLowerCase().contains(var1)).collect(Collectors.toList());
      }
   }

   public boolean shouldCloseOnEsc() {
      if (!this.f_8514) {
         this.f_8514 = true;
         return false;
      } else {
         return true;
      }
   }

   private void renderSidebar(DrawContext var1, int var2, int var3, int var4) {
      float var5 = this.f_8508 + f_8573;
      float var6 = this.f_8509 + f_8574;
      float var7 = f_8575;
      Util93.f_6001[17].m_2915(var1, f_8576, var5, var6, Util71.m_3389(f_8577, (int)(var2 * f_8578)));
      var6 += f_8579;
      Util93.f_6001[11].m_2915(var1, f_8580, var5, var6, Util71.m_3389(f_8581, (int)(var2 * f_8582)));
      var6 += f_8583;
      int var8 = this.f_8507 != null ? (int)this.f_8507.l().m_4046() : 0;
      Util93.f_6001[14].m_2915(var1, "Парсинг: На " + var8 + "% ниже цены", var5, var6, Util71.m_3389(f_8584, (int)(var2 * f_8585)));
      var6 += f_8586;
      boolean var9 = this.f_8506.m_3351();
      this.f_8523.m_443(var9 ? f_8587 : f_8588);
      this.f_8523.m_3598(!var9);
      this.f_8523.m_489(var9);
      this.f_8523.m_3005(var1, var5, var6, var7, f_8589, var2, var3, var4);
      var6 += f_8590;
      Util93.f_6001[11].m_2915(var1, f_8591, var5, var6, Util71.m_3389(f_8592, (int)(var2 * f_8593)));
      var6 += f_8594;
      this.f_8519 = var6;
      float var10 = this.f_8509 + f_8595 - this.f_8519;
      RenderUtil2.m_3624(this.f_8508, this.f_8519, f_8596, var10);
      float var11 = this.f_8519 + this.f_8518;

      for (Util171 var13 : this.f_8526) {
         var13.m_1674(var1, var5, var11, var7, var2);
         var11 += f_8597;
      }

      RenderUtil2.m_1647();
   }

   public boolean mouseScrolled(double var1, double var3, double var5, double var7) {
      if (Util39.m_2594((float)var1, (float)var3, this.f_8508, this.f_8509, f_8662, f_8663)) {
         float var9 = this.f_8526.size() * f_8664 - f_8665 + f_8666;
         float var10 = this.f_8509 + f_8667 - this.f_8519;
         if (var9 > var10) {
            this.f_8517 = this.f_8517 + (float)var7 * f_8668;
            float var15 = -(var9 - var10);
            if (this.f_8517 > 0.0F) {
               this.f_8517 = 0.0F;
            }

            if (this.f_8517 < var15) {
               this.f_8517 = var15;
            }

            return true;
         }
      }

      int var13 = (int)Math.ceil(this.filteredCards().size() / f_8669);
      float var14 = var13 * f_8670;
      float var11 = f_8671;
      if (var14 <= var11) {
         return super.mouseScrolled(var1, var3, var5, var7);
      } else {
         this.f_8515 = this.f_8515 + (float)var7 * f_8672;
         float var12 = -(var14 - var11);
         if (this.f_8515 > 0.0F) {
            this.f_8515 = 0.0F;
         }

         if (this.f_8515 < var12) {
            this.f_8515 = var12;
         }

         return true;
      }
   }

   private void commitAllCardEditing() {
      for (Util55 var2 : this.f_8527) {
         var2.m_2237();
      }
   }

   public boolean mouseClicked(Click var1, boolean var2) {
      double var3 = var1.x();
      double var5 = var1.y();
      int var7 = var1.button();
      if (var7 != 0) {
         return super.mouseClicked(var1, var2);
      } else {
         float var8 = f_8632;
         float var9 = this.f_8509 + (f_8633 - var8) / 2.0F;
         float var10 = this.f_8508 + f_8634 + f_8635;
         float var11 = Util93.f_6001[13].m_585(f_8636) + f_8637;
         float var12 = Util93.f_6001[13].m_585(f_8638) + f_8639;
         float var13 = f_8640;
         float var14 = this.f_8508 + f_8641 - f_8642 - var13;
         if (this.f_8524.m_3633(var3, var5, var10, var9, var11, var8)) {
            return true;
         } else if (this.f_8525.m_3633(var3, var5, var10 + var11 + f_8643, var9, var12, var8)) {
            return true;
         } else if (Util39.m_2594((float)var3, (float)var5, var14, var9, var13, var8)) {
            this.f_8522 = true;
            return true;
         } else {
            this.f_8522 = false;
            float var15 = this.f_8508 + f_8644;
            float var16 = f_8645;
            float var17 = this.f_8509 + f_8646 + f_8647 + f_8648 + f_8649;
            if (this.f_8523.m_3633(var3, var5, var15, var17, var16, f_8650)) {
               return true;
            } else {
               if (Util39.m_2594((float)var3, (float)var5, this.f_8508 + f_8651 + 1.0F, this.f_8509 + f_8652, f_8653, f_8654)) {
                  float var18 = this.f_8508 + f_8655 + f_8656;
                  float var19 = this.f_8509 + f_8657 + this.f_8516;
                  float var20 = f_8658;
                  float var21 = f_8659;
                  byte var22 = 2;
                  List var23 = this.filteredCards();

                  for (int var24 = 0; var24 < var23.size(); var24++) {
                     Util55 var25 = (Util55)var23.get(var24);
                     int var26 = var24 / var22;
                     int var27 = var24 % var22;
                     float var28 = var18 + var27 * (f_8660 + var20);
                     float var29 = var19 + var26 * (f_8661 + var21);
                     if (var25.m_3952(var3, var5, var28, var29)) {
                        return true;
                     }
                  }
               } else {
                  this.commitAllCardEditing();
               }

               return super.mouseClicked(var1, var2);
            }
         }
      }
   }

   private static enum oPYFND4ROeKbw7Gd {
      FUN_TIME,
      HOLY_WORLD;
   }
}
