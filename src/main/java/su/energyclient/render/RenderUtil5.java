package su.energyclient.render;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import org.joml.Vector3f;
import su.energyclient.ui.UIElement1;
import su.energyclient.util.Util150;
import su.energyclient.util.Util30;
import su.energyclient.util.Util53;

public final class RenderUtil5 extends FeatureRenderer<PlayerEntityRenderState, PlayerEntityModel> {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final Identifier f_13436 = Identifier.of(RenderUtil5.f_13867, RenderUtil5.f_13868);
   private static final Map<UIElement1, RenderUtil5.aDy1Go6eTLIrFEY1> O = new EnumMap<>(UIElement1.class);
   private static final Map<PlayerEntityRenderState, List<Util30>> f_13437 = new WeakHashMap<>();
   private static boolean f_13438;
   private static final float f_13439 = 0.13F;
   private static final float f_13440 = 0.18F;
   private static final float f_13441 = 0.25F;
   private static final float f_13442 = 0.075F;
   private static final float f_13443 = 5.0F;
   private static final float f_13444 = 55.0F;
   private static final float f_13445 = 14.0F;
   private static final float f_13446 = 1.2F;
   private static final float f_13447 = 1.2F;
   private static final float f_13448 = 1.2F;
   private static final float f_13449 = 0.07F;
   private static final double f_13450 = 0.012F;
   private static final int f_13451 = -16777216;
   private static final float f_13452 = 0.02F;
   private static final float f_13453 = 0.08F;
   private static final float f_13454 = 0.45F;
   private static final float f_13455 = -0.33F;
   private static final float f_13456 = 0.105F;
   private static final float f_13457 = 0.07F;
   private static final float f_13458 = 0.45F;
   private static final float f_13459 = -0.33F;
   private static final float f_13460 = 0.98F;
   private static final float f_13461 = -0.57F;
   private static final float f_13462 = 0.1F;
   private static final float f_13463 = 0.07F;
   private static final float f_13464 = 0.18F;
   private static final float f_13465 = 0.118F;
   private static final float f_13466 = -0.06F;
   private static final float f_13467 = 0.065F;
   private static final float f_13468 = 0.2F;
   private static final float f_13469 = 0.022F;
   private static final float f_13470 = 0.6F;
   private static final float f_13471 = 0.02F;
   private static final float f_13472 = 0.077F;
   private static final float f_13473 = 0.028F;
   private static final float f_13474 = 0.006F;
   private static final float f_13475 = 0.17F;
   private static final float f_13476 = 0.37F;
   private static final float f_13477 = 0.01F;
   private static final float f_13478 = 0.019F;
   private static final float f_13479 = 0.05F;
   private static final float f_13480 = 0.43F;
   private static final float f_13481 = -0.34F;
   private static final float f_13482 = 0.94F;
   private static final float f_13483 = -0.61F;
   private static final float f_13484 = 1.13F;
   private static final float f_13485 = -0.14F;
   private static final float f_13486 = 0.78F;
   private static final float f_13487 = -0.08F;
   private static final float f_13488 = 1.02F;
   private static final float f_13489 = 0.32F;
   private static final float f_13490 = 0.64F;
   private static final float f_13491 = 0.24F;
   private static final float f_13492 = 0.65F;
   private static final float f_13493 = 0.66F;
   private static final float f_13494 = 0.31F;
   private static final float f_13495 = 0.36F;
   private static final float f_13496 = 0.12F;
   private static final float f_13497 = 0.61F;
   private static final float f_13498 = 0.18F;
   private static final float f_13499 = 0.12F;
   private static final float f_13500 = 0.035F;
   private static final float f_13501 = 0.05F;
   private static final float f_13502 = 0.43F;
   private static final float f_13503 = -0.34F;
   private static final float f_13504 = 0.035F;
   private static final float f_13505 = -0.012F;
   private static final float f_13506 = 0.43F;
   private static final float f_13507 = -0.34F;
   private static final float f_13508 = 0.94F;
   private static final float f_13509 = -0.61F;
   private static final float f_13510 = 0.03F;
   private static final float f_13511 = -0.012F;
   private static final float f_13512 = 0.18F;
   private static final float f_13513 = 0.12F;
   private static final float f_13514 = 0.019F;
   private static final float f_13515 = -0.014F;
   private static final float f_13516 = 0.86F;
   private static final float f_13517 = -0.53F;
   private static final float f_13518 = 1.08F;
   private static final float f_13519 = -0.73F;
   private static final float f_13520 = 0.045F;
   private static final float f_13521 = -0.015F;
   private static final float f_13522 = 0.03F;
   private static final float f_13523 = 0.06F;
   private static final float f_13524 = 0.24F;
   private static final float f_13525 = -0.35F;
   private static final float f_13526 = 0.65F;
   private static final float f_13527 = -0.61F;
   private static final float f_13528 = 0.96F;
   private static final float f_13529 = -0.47F;
   private static final float f_13530 = 1.04F;
   private static final float f_13531 = -0.19F;
   private static final float f_13532 = 0.83F;
   private static final float f_13533 = 0.06F;
   private static final float f_13534 = 0.38F;
   private static final float f_13535 = 0.19F;
   private static final float f_13536 = 0.03F;
   private static final float f_13537 = 0.1F;
   private static final float f_13538 = 0.5F;
   private static final float f_13539 = 0.15F;
   private static final float f_13540 = 0.87F;
   private static final float f_13541 = 0.3F;
   private static final float f_13542 = 0.88F;
   private static final float f_13543 = 0.62F;
   private static final float f_13544 = 0.58F;
   private static final float f_13545 = 0.78F;
   private static final float f_13546 = 0.26F;
   private static final float f_13547 = 0.53F;
   private static final float f_13548 = 0.31F;
   private static final float f_13549 = -0.03F;
   private static final float f_13550 = 0.04F;
   private static final float f_13551 = 0.33F;
   private static final float f_13552 = 0.35F;
   private static final float f_13553 = 0.05F;
   private static final float f_13554 = 0.025F;
   private static final float f_13555 = -0.005F;
   private static final float f_13556 = 0.025F;
   private static final float f_13557 = -0.005F;
   private static final float f_13558 = 0.67F;
   private static final float f_13559 = -0.3F;
   private static final float f_13560 = 0.15F;
   private static final float f_13561 = 0.18F;
   private static final float f_13562 = -0.012F;
   private static final float f_13563 = 0.57F;
   private static final float f_13564 = 0.44F;
   private static final float f_13565 = 0.13F;
   private static final float f_13566 = 0.15F;
   private static final float f_13567 = 0.63F;
   private static final float f_13568 = 0.06F;
   private static final float f_13569 = -0.46F;
   private static final float f_13570 = 0.015F;
   private static final float f_13571 = -0.015F;
   private static final float f_13572 = 0.026F;
   private static final float f_13573 = 0.045F;
   private static final float f_13574 = 0.02F;
   private static final float f_13575 = 0.05F;
   private static final float f_13576 = 0.12F;
   private static final float f_13577 = 0.63F;
   private static final float f_13578 = -0.3F;
   private static final float f_13579 = 0.014F;
   private static final float f_13580 = -0.02F;
   private static final float f_13581 = 0.05F;
   private static final float f_13582 = 0.12F;
   private static final float f_13583 = 0.55F;
   private static final float f_13584 = 0.46F;
   private static final float f_13585 = 0.014F;
   private static final float f_13586 = -0.02F;
   private static final float f_13587 = 0.13F;
   private static final float f_13588 = 0.15F;
   private static final float f_13589 = 0.03F;
   private static final float f_13590 = 0.08F;
   private static final float f_13591 = 0.1F;
   private static final float f_13592 = 0.015F;
   private static final float f_13593 = 0.24F;
   private static final float f_13594 = 0.025F;
   private static final float f_13595 = -0.1F;
   private static final float f_13596 = 0.12F;
   private static final float f_13597 = 0.2F;
   private static final float f_13598 = 0.07F;
   private static final float f_13599 = 0.055F;
   private static final float f_13600 = 0.03F;
   private static final float f_13601 = 0.05F;
   private static final float f_13602 = 0.74F;
   private static final float f_13603 = 0.38F;
   private static final float f_13604 = 0.047F;
   private static final float f_13605 = 0.03F;
   private static final float f_13606 = 0.18F;
   private static final float f_13607 = 0.18F;
   private static final float f_13608 = 0.11F;
   private static final float f_13609 = 0.18F;
   private static final float f_13610 = -0.1F;
   private static final float f_13611 = -0.29F;
   private static final float f_13612 = -0.56F;
   private static final float f_13613 = -0.29F;
   private static final float f_13614 = 0.58F;
   private static final float f_13615 = 0.09F;
   private static final float f_13616 = 0.06F;
   private static final float f_13617 = -0.29F;
   private static final float f_13618 = -0.56F;
   private static final float f_13619 = 0.23F;
   private static final float f_13620 = 0.58F;
   private static final float f_13621 = 0.09F;
   private static final float f_13622 = 0.06F;
   private static final float f_13623 = -0.29F;
   private static final float f_13624 = -0.56F;
   private static final float f_13625 = -0.23F;
   private static final float f_13626 = 0.06F;
   private static final float f_13627 = 0.09F;
   private static final float f_13628 = 0.46F;
   private static final float f_13629 = 0.23F;
   private static final float f_13630 = -0.56F;
   private static final float f_13631 = -0.23F;
   private static final float f_13632 = 0.06F;
   private static final float f_13633 = 0.09F;
   private static final float f_13634 = 0.46F;
   private static final float f_13635 = 0.23F;
   private static final float f_13636 = -0.56F;
   private static final float f_13637 = -0.26F;
   private static final float f_13638 = 0.105F;
   private static final float f_13639 = 0.06F;
   private static final float f_13640 = 0.17F;
   private static final float f_13641 = 0.115F;
   private static final float f_13642 = 0.19F;
   private static final float f_13643 = -0.516F;
   private static final float f_13644 = 0.037F;
   private static final float f_13645 = 0.034F;
   private static final float f_13646 = -0.325F;
   private static final float f_13647 = -0.76F;
   private static final float f_13648 = 0.33F;
   private static final float f_13649 = 0.27F;
   private static final float f_13650 = 0.037F;
   private static final float f_13651 = -0.755F;
   private static final float f_13652 = 0.355F;
   private static final float f_13653 = 0.29F;
   private static final float f_13654 = 0.012F;
   private static final float f_13655 = 0.36F;
   private static final float f_13656 = -0.75F;
   private static final float f_13657 = 0.035F;
   private static final float f_13658 = 0.08F;
   private static final float f_13659 = -0.24F;
   private static final float f_13660 = -0.53F;
   private static final float f_13661 = -0.14F;
   private static final float f_13662 = 0.48F;
   private static final float f_13663 = 0.032F;
   private static final float f_13664 = 0.15F;
   private static final float f_13665 = 0.1F;
   private static final float f_13666 = -0.51F;
   private static final float f_13667 = -0.12F;
   private static final float f_13668 = 0.24F;
   private static final float f_13669 = -0.79F;
   private static final float f_13670 = -0.08F;
   private static final float f_13671 = 0.3F;
   private static final float f_13672 = -0.51F;
   private static final float f_13673 = -0.12F;
   private static final float f_13674 = 0.14F;
   private static final float f_13675 = -0.535F;
   private static final float f_13676 = -0.128F;
   private static final float f_13677 = 0.232F;
   private static final float f_13678 = -0.705F;
   private static final float f_13679 = -0.098F;
   private static final float f_13680 = 0.267F;
   private static final float f_13681 = -0.535F;
   private static final float f_13682 = -0.128F;
   private static final float f_13683 = 0.21F;
   private static final float f_13684 = -0.46F;
   private static final float f_13685 = 0.015F;
   private static final float f_13686 = 0.35F;
   private static final float f_13687 = -0.63F;
   private static final float f_13688 = -0.02F;
   private static final float f_13689 = 0.1F;
   private static final float f_13690 = 0.076F;
   private static final float f_13691 = 0.35F;
   private static final float f_13692 = -0.63F;
   private static final float f_13693 = -0.02F;
   private static final float f_13694 = 0.34F;
   private static final float f_13695 = -0.8F;
   private static final float f_13696 = -0.04F;
   private static final float f_13697 = 0.076F;
   private static final float f_13698 = 0.04F;
   private static final float f_13699 = 0.34F;
   private static final float f_13700 = -0.8F;
   private static final float f_13701 = -0.04F;
   private static final float f_13702 = 0.24F;
   private static final float f_13703 = -0.89F;
   private static final float f_13704 = -0.095F;
   private static final float f_13705 = 0.04F;
   private static final float f_13706 = 0.003F;
   private static final float f_13707 = -0.275F;
   private static final float f_13708 = -0.36F;
   private static final float f_13709 = -0.293F;
   private static final float f_13710 = 0.55F;
   private static final float f_13711 = 0.18F;
   private static final float f_13712 = 0.055F;
   private static final float f_13713 = -0.24F;
   private static final float f_13714 = -0.33F;
   private static final float f_13715 = -0.305F;
   private static final float f_13716 = 0.48F;
   private static final float f_13717 = 0.112F;
   private static final float f_13718 = 0.018F;
   private static final float f_13719 = -0.215F;
   private static final float f_13720 = -0.3F;
   private static final float f_13721 = -0.323F;
   private static final float f_13722 = 0.43F;
   private static final float f_13723 = 0.03F;
   private static final float f_13724 = 0.017F;
   private static final float f_13725 = -0.297F;
   private static final float f_13726 = -0.32F;
   private static final float f_13727 = -0.22F;
   private static final float f_13728 = 0.04F;
   private static final float f_13729 = 0.11F;
   private static final float f_13730 = 0.28F;
   private static final float f_13731 = 0.257F;
   private static final float f_13732 = -0.32F;
   private static final float f_13733 = -0.22F;
   private static final float f_13734 = 0.04F;
   private static final float f_13735 = 0.11F;
   private static final float f_13736 = 0.28F;
   private static final float f_13737 = -0.26F;
   private static final float f_13738 = -0.17F;
   private static final float f_13739 = -0.285F;
   private static final float f_13740 = 0.52F;
   private static final float f_13741 = 0.135F;
   private static final float f_13742 = 0.032F;
   private static final float f_13743 = -0.26F;
   private static final float f_13744 = -0.035F;
   private static final float f_13745 = -0.29F;
   private static final float f_13746 = 0.26F;
   private static final float f_13747 = -0.035F;
   private static final float f_13748 = -0.29F;
   private static final float f_13749 = 0.095F;
   private static final float f_13750 = -0.3F;
   private static final float f_13751 = -0.22F;
   private static final float f_13752 = -0.12F;
   private static final float f_13753 = 0.22F;
   private static final float f_13754 = -0.12F;
   private static final float f_13755 = 0.011F;
   private static final float f_13756 = -0.321F;
   private static final float f_13757 = -0.05F;
   private static final float f_13758 = 0.042F;
   private static final float f_13759 = 0.043F;
   private static final float f_13760 = -0.323F;
   private static final float f_13761 = -0.265F;
   private static final float f_13762 = -0.17F;
   private static final float f_13763 = -0.23F;
   private static final float f_13764 = 0.025F;
   private static final float f_13765 = 0.07F;
   private static final float f_13766 = 0.49F;
   private static final float f_13767 = 0.24F;
   private static final float f_13768 = -0.17F;
   private static final float f_13769 = -0.23F;
   private static final float f_13770 = 0.025F;
   private static final float f_13771 = 0.07F;
   private static final float f_13772 = 0.49F;
   private static final float f_13773 = -0.26F;
   private static final float f_13774 = -0.43F;
   private static final float f_13775 = -0.282F;
   private static final float f_13776 = 0.52F;
   private static final float f_13777 = 0.18F;
   private static final float f_13778 = 0.032F;
   private static final float f_13779 = -0.25F;
   private static final float f_13780 = -0.18F;
   private static final float f_13781 = -0.282F;
   private static final float f_13782 = 0.5F;
   private static final float f_13783 = 0.16F;
   private static final float f_13784 = 0.035F;
   private static final float f_13785 = -0.265F;
   private static final float f_13786 = -0.31F;
   private static final float f_13787 = -0.281F;
   private static final float f_13788 = 0.075F;
   private static final float f_13789 = 0.18F;
   private static final float f_13790 = 0.033F;
   private static final float f_13791 = 0.19F;
   private static final float f_13792 = -0.31F;
   private static final float f_13793 = -0.281F;
   private static final float f_13794 = 0.075F;
   private static final float f_13795 = 0.18F;
   private static final float f_13796 = 0.033F;
   private static final float f_13797 = -0.043F;
   private static final float f_13798 = -0.31F;
   private static final float f_13799 = -0.3F;
   private static final float f_13800 = 0.086F;
   private static final float f_13801 = 0.18F;
   private static final float f_13802 = 0.045F;
   private static final float f_13803 = 0.075F;
   private static final float f_13804 = -0.272F;
   private static final float f_13805 = 0.209F;
   private static final float f_13806 = -0.303F;
   private static final float f_13807 = 0.014F;
   private static final float f_13808 = -0.319F;
   private static final float f_13809 = 0.184F;
   private static final float f_13810 = -0.15F;
   private static final float f_13811 = 0.033F;
   private static final float f_13812 = 0.06F;
   private static final float f_13813 = -0.32F;
   private static final float f_13814 = 0.135F;
   private static final float f_13815 = -0.427F;
   private static final float f_13816 = -0.284F;
   private static final float f_13817 = 0.255F;
   private static final float f_13818 = -0.66F;
   private static final float f_13819 = -0.24F;
   private static final float f_13820 = 0.27F;
   private static final float f_13821 = -0.427F;
   private static final float f_13822 = -0.284F;
   private static final float f_13823 = 0.17F;
   private static final float f_13824 = -0.44F;
   private static final float f_13825 = -0.294F;
   private static final float f_13826 = 0.245F;
   private static final float f_13827 = -0.57F;
   private static final float f_13828 = -0.268F;
   private static final float f_13829 = 0.25F;
   private static final float f_13830 = -0.44F;
   private static final float f_13831 = -0.294F;
   private static final float f_13832 = 0.19F;
   private static final float f_13833 = -0.4F;
   private static final float f_13834 = -0.265F;
   private static final float f_13835 = 0.24F;
   private static final float f_13836 = -0.61F;
   private static final float f_13837 = -0.32F;
   private static final float f_13838 = 0.065F;
   private static final float f_13839 = 0.008F;
   private static final float f_13840 = 0.105F;
   private static final float f_13841 = -0.06F;
   private static final float f_13842 = -0.337F;
   private static final float f_13843 = 0.037F;
   private static final float f_13844 = 0.034F;
   private static final float f_13845 = -0.087F;
   private static final float f_13846 = -0.34F;
   private static final float f_13847 = 0.029F;
   private static final float f_13848 = 0.055F;
   private static final float f_13849 = -0.328F;
   private static final float f_13850 = -0.08F;
   private static final float f_13851 = -0.071F;
   private static final float f_13852 = -0.325F;
   private static final float f_13853 = 0.16F;
   private static final float f_13854 = 0.022F;
   private static final float f_13855 = 0.02F;
   private static final float f_13856 = 0.07F;
   private static final float f_13857 = 0.035F;
   private static final float f_13858 = 0.05F;
   private static final int f_13859 = -15592675;
   private static final float f_13860 = 0.7F;
   private static final float f_13861 = 0.72F;
   private static final int f_13862 = -16777216;
   private static final int f_13863 = 16777215;
   private static final float f_13864 = 0.5F;
   private static final float f_13865 = 0.5F;
   private static final int f_13866 = 15728880;
   private static final String f_13867 = "energy";
   private static final String f_13868 = "textures/cosmetics/white.png";

   public static boolean isPreview(PlayerEntityRenderState var0) {
      return f_13437.containsKey(var0);
   }

   private static int mix(int var0, int var1, float var2) {
      int var3 = Math.round((var0 >> 16 & 0xFF) * (1.0F - var2) + (var1 >> 16 & 0xFF) * var2);
      int var4 = Math.round((var0 >> 8 & 0xFF) * (1.0F - var2) + (var1 >> 8 & 0xFF) * var2);
      int var5 = Math.round((var0 & 0xFF) * (1.0F - var2) + (var1 & 0xFF) * var2);
      return f_13451 | var3 << 16 | var4 << 8 | var5;
   }

   public static void preview(PlayerEntityRenderState var0, List<Util30> var1) {
      f_13437.put(var0, List.copyOf(var1));
   }

   public void render(MatrixStack var1, OrderedRenderCommandQueue var2, int var3, PlayerEntityRenderState var4, float var5, float var6) {
      List<Util30> var7 = f_13437.get(var4);
      if (var7 == null) {
         MinecraftClient var8 = MinecraftClient.getInstance();
         if (var8.player == null || var4.id != var8.player.getId() || var4.invisible || var4.spectator) {
            return;
         }

         RenderUtil3 var9 = RenderUtil3.m_844();
         if (!var9.m_1207()) {
            return;
         }

         var7 = var9.m_1055();
      }

      for (Util30 var20 : var7) {
         var1.push();

         try {
            ((PlayerEntityModel)this.getContextModel()).getRootPart().applyTransform(var1);
            if (var20.slot() == Util150.WINGS) {
               ((PlayerEntityModel)this.getContextModel()).body.applyTransform(var1);
               var1.translate(0.0F, f_13439, var4.equippedChestStack.isEmpty() ? f_13440 : f_13441);
               float var10 = (float)Math.sin(var4.age * f_13442) * f_13443;
               float var11 = var4.isGliding ? f_13444 : f_13445 + var10;

               for (int var15 : new int[]{-1, 1}) {
                  var1.push();
                  var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-var15 * var11));
                  var1.scale(var15, 1.0F, 1.0F);
                  submit(var20, var1, var2, var3);
                  var1.pop();
               }
            } else {
               ((PlayerEntityModel)this.getContextModel()).head.applyTransform(var1);
               if (!var4.equippedHeadStack.isEmpty()) {
                  var1.scale(f_13446, f_13447, f_13448);
               }

               if (var20.style() == UIElement1.HALO) {
                  var1.translate(0.0, Math.sin(var4.age * f_13449) * f_13450, 0.0);
               }

               if (var20.style() != UIElement1.STAFF_CAP && var20.style() != UIElement1.DISGUISE) {
                  submit(var20, var1, var2, var3);
               } else {
                  Util53.m_2578(var20, var1, var2, var3, OverlayTexture.DEFAULT_UV);
               }
            }
         } finally {
            var1.pop();
         }
      }
   }

   private static RenderUtil5.aDy1Go6eTLIrFEY1 build(UIElement1 var0) {
      RenderUtil5.IH56VzMfCUloIgCN var1 = new RenderUtil5.IH56VzMfCUloIgCN();
      switch (var0) {
         case ANGEL:
            var1.m_2767(f_13452, f_13453, f_13454, f_13455, f_13456, f_13457, 0);
            var1.m_2767(f_13458, f_13459, f_13460, f_13461, f_13462, f_13463, 3);

            for (int var14 = 0; var14 < 7; var14++) {
               float var21 = f_13464 + var14 * f_13465;
               float var28 = f_13466 - var14 * f_13467;
               var1.I(
                  var21,
                  var28,
                  var21 + f_13468 + var14 * f_13469,
                  var28 + f_13470 - var14 * f_13471,
                  f_13472,
                  f_13473 + var14 * f_13474,
                  var14 % 3 == 0 ? 3 : 0
               );
               var1.m_2767(var21, var28, var21 + f_13475, var28 + f_13476, f_13477, f_13478, 1);
            }
            break;
         case DRAGON:
            float[][] var13 = new float[][]{
               {0.0F, f_13479},
               {f_13480, f_13481},
               {f_13482, f_13483},
               {f_13484, f_13485},
               {f_13486, f_13487},
               {f_13488, f_13489},
               {f_13490, f_13491},
               {f_13492, f_13493},
               {f_13494, f_13495},
               {f_13496, f_13497}
            };
            var1.m_184(f_13498, f_13499, var13, f_13500, 0);
            var1.m_2767(0.0F, f_13501, f_13502, f_13503, f_13504, f_13505, 2);
            var1.m_2767(f_13506, f_13507, f_13508, f_13509, f_13510, f_13511, 2);

            for (int var6 : new int[]{3, 5, 7, 9}) {
               var1.m_2767(f_13512, f_13513, var13[var6][0], var13[var6][1], f_13514, f_13515, 1);
            }

            var1.I(f_13516, f_13517, f_13518, f_13519, f_13520, f_13521, 3);
            break;
         case BUTTERFLY:
            float[][] var12 = new float[][]{
               {f_13522, f_13523}, {f_13524, f_13525}, {f_13526, f_13527}, {f_13528, f_13529}, {f_13530, f_13531}, {f_13532, f_13533}, {f_13534, f_13535}
            };
            float[][] var19 = new float[][]{
               {f_13536, f_13537}, {f_13538, f_13539}, {f_13540, f_13541}, {f_13542, f_13543}, {f_13544, f_13545}, {f_13546, f_13547}
            };
            var1.m_184(f_13548, f_13549, var12, f_13550, 0);
            var1.m_184(f_13551, f_13552, var19, f_13553, 0);
            var1.m_2189(var12, f_13554, f_13555, 2);
            var1.m_2189(var19, f_13556, f_13557, 2);
            var1.m_2123(f_13558, f_13559, f_13560, f_13561, f_13562, 1);
            var1.m_2123(f_13563, f_13564, f_13565, f_13566, 0.0F, 1);

            for (int var26 = 0; var26 < 4; var26++) {
               var1.m_1850(f_13567 + var26 * f_13568, f_13569 + var26 * f_13570, f_13571, f_13572, f_13573, f_13574, 3);
            }

            var1.m_2767(f_13575, f_13576, f_13577, f_13578, f_13579, f_13580, 1);
            var1.m_2767(f_13581, f_13582, f_13583, f_13584, f_13585, f_13586, 1);
            break;
         case CRYSTAL:
            for (int var11 = 0; var11 < 5; var11++) {
               float var18 = f_13587 + var11 * f_13588;
               float var25 = f_13589 + var11 * f_13590;
               var1.m_3587(
                  var18, var25, f_13591 + var11 * f_13592, f_13593 + var11 * f_13594, f_13595 - var11 * f_13596, f_13597 + var11 * f_13598, f_13599, var11 % 2
               );
            }

            var1.m_2767(f_13600, f_13601, f_13602, f_13603, f_13604, f_13605, 2);
            var1.m_2123(f_13606, f_13607, f_13608, f_13609, f_13610, 1);
            break;
         case CROWN:
            var1.m_1850(f_13611, f_13612, f_13613, f_13614, f_13615, f_13616, 0);
            var1.m_1850(f_13617, f_13618, f_13619, f_13620, f_13621, f_13622, 0);
            var1.m_1850(f_13623, f_13624, f_13625, f_13626, f_13627, f_13628, 0);
            var1.m_1850(f_13629, f_13630, f_13631, f_13632, f_13633, f_13634, 0);

            for (int var10 = -1; var10 <= 1; var10++) {
               var1.m_2666(var10 * f_13635, f_13636, f_13637, f_13638, f_13639, var10 == 0 ? f_13640 : f_13641, 0);
               var1.m_2123(var10 * f_13642, f_13643, f_13644, f_13645, f_13646, 1);
            }
            break;
         case HALO:
            var1.m_2337(f_13647, f_13648, f_13649, f_13650, 1);
            var1.m_2337(f_13651, f_13652, f_13653, f_13654, 3);

            for (int var31 : new int[]{-1, 1}) {
               var1.m_2123(var31 * f_13655, f_13656, f_13657, f_13658, 0.0F, 1);
            }
            break;
         case CAT_EARS:
            var1.m_1850(f_13659, f_13660, f_13661, f_13662, f_13663, f_13664, 2);

            for (int var30 : new int[]{-1, 1}) {
               var1.m_3357(var30 * f_13665, f_13666, f_13667, var30 * f_13668, f_13669, f_13670, var30 * f_13671, f_13672, f_13673, 0);
               var1.m_3357(var30 * f_13674, f_13675, f_13676, var30 * f_13677, f_13678, f_13679, var30 * f_13680, f_13681, f_13682, 1);
            }
            break;
         case HORNS:
            for (int var29 : new int[]{-1, 1}) {
               var1.m_2380(var29 * f_13683, f_13684, f_13685, var29 * f_13686, f_13687, f_13688, f_13689, f_13690, 2);
               var1.m_2380(var29 * f_13691, f_13692, f_13693, var29 * f_13694, f_13695, f_13696, f_13697, f_13698, 0);
               var1.m_2380(var29 * f_13699, f_13700, f_13701, var29 * f_13702, f_13703, f_13704, f_13705, f_13706, 1);
            }
            break;
         case VISOR:
            var1.m_1850(f_13707, f_13708, f_13709, f_13710, f_13711, f_13712, 2);
            var1.m_1850(f_13713, f_13714, f_13715, f_13716, f_13717, f_13718, 0);
            var1.m_1850(f_13719, f_13720, f_13721, f_13722, f_13723, f_13724, 1);
            var1.m_1850(f_13725, f_13726, f_13727, f_13728, f_13729, f_13730, 2);
            var1.m_1850(f_13731, f_13732, f_13733, f_13734, f_13735, f_13736, 2);
            break;
         case BANDANA:
            var1.m_1850(f_13737, f_13738, f_13739, f_13740, f_13741, f_13742, 0);
            var1.m_3357(f_13743, f_13744, f_13745, f_13746, f_13747, f_13748, 0.0F, f_13749, f_13750, 0);
            var1.m_2767(f_13751, f_13752, f_13753, f_13754, f_13755, f_13756, 1);
            var1.m_2123(0.0F, f_13757, f_13758, f_13759, f_13760, 3);
            var1.m_1850(f_13761, f_13762, f_13763, f_13764, f_13765, f_13766, 0);
            var1.m_1850(f_13767, f_13768, f_13769, f_13770, f_13771, f_13772, 0);
            break;
         case KITSUNE:
         case ONI:
            var1.m_1850(f_13773, f_13774, f_13775, f_13776, f_13777, f_13778, 0);
            var1.m_1850(f_13779, f_13780, f_13781, f_13782, f_13783, f_13784, 0);
            var1.m_1850(f_13785, f_13786, f_13787, f_13788, f_13789, f_13790, 0);
            var1.m_1850(f_13791, f_13792, f_13793, f_13794, f_13795, f_13796, 0);
            var1.m_1850(f_13797, f_13798, f_13799, f_13800, f_13801, f_13802, 0);

            for (int var5 : new int[]{-1, 1}) {
               var1.m_2767(var5 * f_13803, f_13804, var5 * f_13805, f_13806, f_13807, f_13808, 1);
               var1.m_2123(var5 * f_13809, f_13810, f_13811, f_13812, f_13813, 1);
               if (var0 == UIElement1.KITSUNE) {
                  var1.m_3357(var5 * f_13814, f_13815, f_13816, var5 * f_13817, f_13818, f_13819, var5 * f_13820, f_13821, f_13822, 0);
                  var1.m_3357(var5 * f_13823, f_13824, f_13825, var5 * f_13826, f_13827, f_13828, var5 * f_13829, f_13830, f_13831, 1);
               } else {
                  var1.m_2380(var5 * f_13832, f_13833, f_13834, var5 * f_13835, f_13836, f_13837, f_13838, f_13839, 1);
                  var1.m_2666(var5 * f_13840, f_13841, f_13842, f_13843, f_13844, f_13845, 3);
               }
            }

            var1.m_2123(0.0F, f_13846, f_13847, f_13848, f_13849, 1);
            var1.m_1850(f_13850, f_13851, f_13852, f_13853, f_13854, f_13855, 2);
      }

      if (var0 == UIElement1.ANGEL) {
         var1.m_1610(f_13856, false);
      }

      if (var0 == UIElement1.DRAGON) {
         var1.m_1610(f_13857, true);
      }

      if (var0 == UIElement1.BUTTERFLY) {
         var1.m_1610(f_13858, true);
      }

      return new RenderUtil5.aDy1Go6eTLIrFEY1(List.copyOf(var1.f_7502));
   }

   public static void register() {
      if (!f_13438) {
         f_13438 = true;
         LivingEntityFeatureRendererRegistrationCallback.EVENT.register((LivingEntityFeatureRendererRegistrationCallback)(var0, var1, var2, var3) -> {
            if (var1 instanceof PlayerEntityRenderer var4) {
               var2.register(new RenderUtil5(var4));
            }
         });
      }
   }

   private static void submit(Util30 var0, MatrixStack var1, OrderedRenderCommandQueue var2, int var3) {
      RenderUtil5.aDy1Go6eTLIrFEY1 var4 = O.computeIfAbsent(var0.style(), RenderUtil5::build);
      int var5 = var0.color();
      int var6 = var0.accent();
      var2.submitCustom(
         var1,
         RenderLayers.entityCutoutNoCull(f_13436),
         (var4x, var5x) -> {
            for (RenderUtil5.AEQV9UkJhJDnBrHw var7 : var4.vertices) {
               int var8 = switch (var7.material) {
                  case 1 -> var6;
                  case 2 -> mix(var5, f_13859, f_13860);
                  case 3 -> mix(var5, -1, f_13861);
                  default -> var5;
               };
               var5x.vertex(var4x, var7.x, var7.y, var7.z)
                  .color(f_13862 | var8 & f_13863)
                  .texture(f_13864, f_13865)
                  .overlay(OverlayTexture.DEFAULT_UV)
                  .light(var7.material == 1 ? f_13866 : var3)
                  .normal(var4x, var7.nx, var7.ny, var7.nz);
            }
         }
      );
   }

   public RenderUtil5(FeatureRendererContext<PlayerEntityRenderState, PlayerEntityModel> var1) {
      super(var1);
   }

   private record AEQV9UkJhJDnBrHw(float x, float y, float z, float nx, float ny, float nz, int material) {
   }

   private static final class IH56VzMfCUloIgCN {
      final List<RenderUtil5.AEQV9UkJhJDnBrHw> f_7502 = new ArrayList<>();
      private static final float f_7503 = 0.55F;
      private static final float f_7504 = 0.55F;
      private static final float f_7505 = 0.022F;
      private static final float f_7506 = 0.55F;
      private static final float f_7507 = 0.55F;
      private static final double f_7508 = Math.PI;
      private static final double f_7509 = 12.0;
      private static final double f_7510 = Math.PI;
      private static final double f_7511 = 12.0;
      private static final float f_7512 = 0.022F;
      private static final float f_7513 = 0.022F;
      private static final double f_7514 = Math.PI;
      private static final double f_7515 = 3.0;
      private static final double f_7516 = Math.PI;
      private static final double f_7517 = 3.0;
      private static final float f_7518 = 0.5F;
      private static final float f_7519 = 0.5F;
      private static final float f_7520 = 0.7F;

      void m_1610(float var1, boolean var2) {
         int var3 = this.f_7502.size();

         for (int var4 = 0; var4 < var3; var4++) {
            RenderUtil5.AEQV9UkJhJDnBrHw var5 = this.f_7502.get(var4);
            if (var2 ? var5.material != 0 : var5.material == 1) {
               this.f_7502.add(new RenderUtil5.AEQV9UkJhJDnBrHw(var5.x, var5.y, var1 * 2.0F - var5.z, var5.nx, var5.ny, -var5.nz, var5.material));
            }
         }
      }

      void m_2380(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
         for (int var10 = 0; var10 < 6; var10++) {
            float var11 = (float)(var10 * f_7514 / f_7515);
            float var12 = (float)((var10 + 1) * f_7516 / f_7517);
            this.m_1448(
               this.m_3337(var1 + (float)Math.cos(var11) * var7, var2, var3 + (float)Math.sin(var11) * var7),
               this.m_3337(var4 + (float)Math.cos(var11) * var8, var5, var6 + (float)Math.sin(var11) * var8),
               this.m_3337(var4 + (float)Math.cos(var12) * var8, var5, var6 + (float)Math.sin(var12) * var8),
               this.m_3337(var1 + (float)Math.cos(var12) * var7, var2, var3 + (float)Math.sin(var12) * var7),
               var9
            );
         }
      }

      void m_2666(float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
         float[][] var8 = new float[][]{
            this.m_3337(var1 - var4, var2, var3 - var5),
            this.m_3337(var1 + var4, var2, var3 - var5),
            this.m_3337(var1 + var4, var2, var3 + var5),
            this.m_3337(var1 - var4, var2, var3 + var5)
         };

         for (int var9 = 0; var9 < 4; var9++) {
            float[] var10 = var8[var9];
            float[] var11 = var8[(var9 + 1) % 4];
            this.m_3357(var10[0], var10[1], var10[2], var1, var2 - var6, var3, var11[0], var11[1], var11[2], var7);
         }
      }

      void m_184(float var1, float var2, float[][] var3, float var4, int var5) {
         for (int var6 = 0; var6 < var3.length; var6++) {
            float[] var7 = var3[var6];
            float[] var8 = var3[(var6 + 1) % var3.length];
            this.m_3357(var1, var2, var4, var7[0], var7[1], var4, var8[0], var8[1], var4, var5);
         }
      }

      void m_2189(float[][] var1, float var2, float var3, int var4) {
         for (int var5 = 0; var5 < var1.length; var5++) {
            float[] var6 = var1[var5];
            float[] var7 = var1[(var5 + 1) % var1.length];
            this.m_2767(var6[0], var6[1], var7[0], var7[1], var2, var3, var4);
         }
      }

      void m_1448(float[] var1, float[] var2, float[] var3, float[] var4, int var5) {
         Vector3f var6 = new Vector3f(var2[0] - var1[0], var2[1] - var1[1], var2[2] - var1[2])
            .cross(var3[0] - var1[0], var3[1] - var1[1], var3[2] - var1[2])
            .normalize();

         for (float[] var10 : new float[][]{var1, var2, var3, var4}) {
            this.f_7502.add(new RenderUtil5.AEQV9UkJhJDnBrHw(var10[0], var10[1], var10[2], var6.x, var6.y, var6.z, var5));
         }
      }

      float[] m_3337(float var1, float var2, float var3) {
         return new float[]{var1, var2, var3};
      }

      void m_1850(float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
         float var8 = var1 + var4;
         float var9 = var2 + var5;
         float var10 = var3 + var6;
         this.m_1448(this.m_3337(var1, var2, var3), this.m_3337(var1, var9, var3), this.m_3337(var8, var9, var3), this.m_3337(var8, var2, var3), var7);
         this.m_1448(this.m_3337(var8, var2, var10), this.m_3337(var8, var9, var10), this.m_3337(var1, var9, var10), this.m_3337(var1, var2, var10), var7);
         this.m_1448(this.m_3337(var1, var2, var10), this.m_3337(var1, var9, var10), this.m_3337(var1, var9, var3), this.m_3337(var1, var2, var3), var7);
         this.m_1448(this.m_3337(var8, var2, var3), this.m_3337(var8, var9, var3), this.m_3337(var8, var9, var10), this.m_3337(var8, var2, var10), var7);
         this.m_1448(this.m_3337(var1, var2, var10), this.m_3337(var1, var2, var3), this.m_3337(var8, var2, var3), this.m_3337(var8, var2, var10), var7);
         this.m_1448(this.m_3337(var1, var9, var3), this.m_3337(var1, var9, var10), this.m_3337(var8, var9, var10), this.m_3337(var8, var9, var3), var7);
      }

      void m_2123(float var1, float var2, float var3, float var4, float var5, int var6) {
         this.m_1448(
            this.m_3337(var1, var2 - var4, var5),
            this.m_3337(var1 + var3, var2, var5),
            this.m_3337(var1, var2 + var4, var5),
            this.m_3337(var1 - var3, var2, var5),
            var6
         );
      }

      void I(float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
         float var8 = (float)Math.hypot(var3 - var1, var4 - var2);
         float var9 = -(var4 - var2) / var8 * var5;
         float var10 = (var3 - var1) / var8 * var5;
         this.m_1448(
            this.m_3337(var1, var2, var6),
            this.m_3337(var1 + (var3 - var1) * f_7503 + var9, var2 + (var4 - var2) * f_7504 + var10, var6),
            this.m_3337(var3, var4, var6 + f_7505),
            this.m_3337(var1 + (var3 - var1) * f_7506 - var9, var2 + (var4 - var2) * f_7507 - var10, var6),
            var7
         );
      }

      void m_2767(float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
         float var8 = (float)Math.hypot(var3 - var1, var4 - var2);
         float var9 = -(var4 - var2) / var8 * var5;
         float var10 = (var3 - var1) / var8 * var5;
         this.m_1448(
            this.m_3337(var1 + var9, var2 + var10, var6),
            this.m_3337(var3 + var9, var4 + var10, var6),
            this.m_3337(var3 - var9, var4 - var10, var6),
            this.m_3337(var1 - var9, var2 - var10, var6),
            var7
         );
      }

      void m_3587(float var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
         float[] var9 = this.m_3337(var1 - var4 * f_7518, var2, var3);
         float[] var10 = this.m_3337(var1, var2, var3 - var7);
         float[] var11 = this.m_3337(var1 + var4 * f_7519, var2, var3);
         float[] var12 = this.m_3337(var1, var2, var3 + var7);

         for (float[][] var16 : new float[][][]{{var9, var10}, {var10, var11}, {var11, var12}, {var12, var9}}) {
            this.m_3357(var16[0][0], var16[0][1], var16[0][2], var1 + var4 * f_7520, var2 + var5, var3, var16[1][0], var16[1][1], var16[1][2], var8);
            this.m_3357(var16[1][0], var16[1][1], var16[1][2], var1, var2 + var6, var3, var16[0][0], var16[0][1], var16[0][2], 1);
         }
      }

      void m_2337(float var1, float var2, float var3, float var4, int var5) {
         for (int var6 = 0; var6 < 24; var6++) {
            float var7 = (float)(var6 * f_7508 / f_7509);
            float var8 = (float)((var6 + 1) * f_7510 / f_7511);
            this.m_1448(
               this.m_3337((var2 - var4) * (float)Math.cos(var7), var1, (var3 - var4) * (float)Math.sin(var7)),
               this.m_3337((var2 - var4) * (float)Math.cos(var8), var1, (var3 - var4) * (float)Math.sin(var8)),
               this.m_3337((var2 + var4) * (float)Math.cos(var8), var1, (var3 + var4) * (float)Math.sin(var8)),
               this.m_3337((var2 + var4) * (float)Math.cos(var7), var1, (var3 + var4) * (float)Math.sin(var7)),
               var5
            );
            this.m_1448(
               this.m_3337((var2 + var4) * (float)Math.cos(var7), var1, (var3 + var4) * (float)Math.sin(var7)),
               this.m_3337((var2 + var4) * (float)Math.cos(var8), var1, (var3 + var4) * (float)Math.sin(var8)),
               this.m_3337((var2 + var4) * (float)Math.cos(var8), var1 + f_7512, (var3 + var4) * (float)Math.sin(var8)),
               this.m_3337((var2 + var4) * (float)Math.cos(var7), var1 + f_7513, (var3 + var4) * (float)Math.sin(var7)),
               var5
            );
         }
      }

      void m_3357(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10) {
         this.m_1448(this.m_3337(var1, var2, var3), this.m_3337(var4, var5, var6), this.m_3337(var7, var8, var9), this.m_3337(var7, var8, var9), var10);
      }
   }

   private record aDy1Go6eTLIrFEY1(List<RenderUtil5.AEQV9UkJhJDnBrHw> vertices) {
   }
}
