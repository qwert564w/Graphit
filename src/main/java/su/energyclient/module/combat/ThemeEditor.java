package su.energyclient.module.combat;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.awt.Color;
import java.nio.file.Path;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.joml.Matrix3x2fStack;
import org.joml.Vector4f;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.module.ToggleMode;
import su.energyclient.render.RenderUtil19;
import su.energyclient.render.RenderUtil2;
import su.energyclient.render.RenderUtil22;
import su.energyclient.setting.Setting;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util153;
import su.energyclient.util.Util158;
import su.energyclient.util.Util165;
import su.energyclient.util.Util28;
import su.energyclient.util.Util39;
import su.energyclient.util.Util40;
import su.energyclient.util.Util5;
import su.energyclient.util.Util63;
import su.energyclient.util.Util71;
import su.energyclient.util.Util90;
import su.energyclient.util.Util93;

public class ThemeEditor extends Screen implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_9398 = 160.0F;
   private static final float f_9399 = 0.0F;
   private static final float f_9400 = 0.0F;
   private static final float f_9401 = 0.0F;
   private static final float f_9402 = 0.0F;
   private static final float f_9403 = 0.0F;
   private static final float f_9404 = 0.0F;
   private static final float f_9405 = 0.0F;
   private static final float f_9406 = 0.0F;
   private static final float f_9407 = 0.0F;
   private static final float f_9408 = 0.0F;
   private static final float f_9409 = 0.0F;
   private static final float f_9410 = 0.0F;
   private static final float f_9411 = 0.0F;
   private static final float f_9412 = 0.0F;
   private static final float f_9413 = 0.0F;
   private static final float f_9414 = 0.0F;
   private static final float f_9415 = 0.0F;
   private static final float f_9416 = 0.0F;
   private static final float f_9417 = 0.0F;
   private static final int f_9418 = 0;
   private static final Identifier f_9419 = Identifier.of(ThemeEditor.f_10298, ThemeEditor.f_10299);
   private static final Identifier f_9420 = Identifier.of(ThemeEditor.f_10300, ThemeEditor.f_10301);
   private static final List<ThemeEditor.sKN8QGcpT98iFDgp> f_9421 = List.of(
      new ThemeEditor.sKN8QGcpT98iFDgp(ThemeEditor.f_10302, ThemeEditor.f_10303),
      new ThemeEditor.sKN8QGcpT98iFDgp(ThemeEditor.f_10304, ThemeEditor.f_10305),
      new ThemeEditor.sKN8QGcpT98iFDgp(ThemeEditor.f_10306, ThemeEditor.f_10307),
      new ThemeEditor.sKN8QGcpT98iFDgp(ThemeEditor.f_10308, ThemeEditor.f_10309),
      new ThemeEditor.sKN8QGcpT98iFDgp(ThemeEditor.f_10310, ThemeEditor.f_10311),
      new ThemeEditor.sKN8QGcpT98iFDgp(ThemeEditor.f_10312, ThemeEditor.f_10313)
   );
   private float f_9422;
   private float f_9423;
   private final float f_9424;
   private final float I;
   private Category f_9425;
   private Module f_9426;
   private RenderUtil22 f_9427;
   private boolean f_9428;
   private float f_9429;
   private float f_9430;
   private Module f_9431;
   private RenderUtil22 f_9432;
   private boolean f_9433;
   private final Util165 l;
   private final Util165 f_9434;
   private final Util165 f_9435;
   private final Util165 f_9436;
   private final Util165 f_9437;
   private final Util165 f_9438;
   private final RenderUtil19 f_9439;
   private final Util5 f_9440;
   private boolean f_9441;
   private float f_9442;
   private float f_9443;
   private final Map<String, Util165> f_9444;
   private final Map<String, Util165> f_9445;
   private final Map<String, Util165> f_9446;
   private final Map<String, Util165> f_9447;
   private final Map<Category, Util165> f_9448;
   private String f_9449;
   private boolean f_9450;
   private final Util165 f_9451;
   private final Util165 f_9452;
   private final Util165 f_9453;
   private boolean f_9454;
   private long f_9455;
   private int f_9456;
   private ModeSetting f_9457;
   private Util63 f_9458;
   private ThemeEditor.xCBuOCHHe6IcZJcG f_9459;
   private boolean f_9460;
   private boolean f_9461;
   private float f_9462;
   private float f_9463;
   private float f_9464;
   private float f_9465;
   private List<Module> f_9466;
   private Category f_9467;
   private String f_9468;
   private Util28 f_frameCache;
   private List<Module> f_frameCacheModules;
   private static final String f_9469 = "gui";
   private static final float f_9470 = 416.0F;
   private static final float f_9471 = 272.0F;
   private static final long f_9472 = 155L;
   private static final long f_9473 = 240L;
   private static final long f_9474 = 300L;
   private static final long f_9475 = 430L;
   private static final long f_9476 = 320L;
   private static final long f_9477 = 240L;
   private static final long f_9478 = 200L;
   private static final long f_9479 = 210L;
   private static final long f_9480 = 180L;
   private static final float f_9481 = 0.66F;
   private static final float f_9482 = 0.35F;
   private static final double f_9483 = 0.98;
   private static final double f_9484 = 0.96;
   private static final float f_9485 = 0.46F;
   private static final float f_9486 = 0.055F;
   private static final float f_9487 = 0.035F;
   private static final float f_9488 = 0.001F;
   private static final float f_9489 = 30.0F;
   private static final float f_9490 = 6.0F;
   private static final float f_9491 = 6.0F;
   private static final float f_9492 = 4.0F;
   private static final float f_9493 = 0.58F;
   private static final float f_9494 = 0.42F;
   private static final double f_9495 = 0.01;
   private static final float f_9496 = 29.0F;
   private static final float f_9497 = 272.0F;
   private static final float f_9498 = 10.0F;
   private static final float f_9499 = 4.0F;
   private static final float f_9500 = 0.01F;
   private static final float f_9501 = 96.0F;
   private static final float f_9502 = 29.0F;
   private static final float f_9503 = 320.0F;
   private static final float f_9504 = 243.0F;
   private static final float f_9505 = 150.0F;
   private static final int f_9506 = 789774;
   private static final float f_9507 = 416.0F;
   private static final float f_9508 = 115.0F;
   private static final float f_9509 = 110.0F;
   private static final float f_9510 = 5.0F;
   private static final float f_9511 = 5.0F;
   private static final float f_9512 = 5.0F;
   private static final float f_9513 = 5.0F;
   private static final float f_9514 = 0.72F;
   private static final int f_9515 = 1447448;
   private static final float f_9516 = 0.55F;
   private static final int f_9517 = 1052946;
   private static final float f_9518 = 0.22F;
   private static final float f_9519 = 0.16F;
   private static final float f_9520 = 100.0F;
   private static final float f_9521 = 78.0F;
   private static final float f_9522 = 112.0F;
   private static final float f_9523 = 22.0F;
   private static final float f_9524 = 16.5F;
   private static final float f_9525 = 110.0F;
   private static final float f_9526 = 20.0F;
   private static final float f_9527 = 16.0F;
   private static final float f_9528 = 118.0F;
   private static final float f_9529 = 0.01F;
   private static final float f_9530 = 90.0F;
   private static final float f_9531 = 110.0F;
   private static final float f_9532 = 20.0F;
   private static final float f_9533 = 1.25F;
   private static final float f_9534 = 0.5F;
   private static final float f_9535 = 105.0F;
   private static final float f_9536 = 6.0F;
   private static final float f_9537 = 8.5F;
   private static final float f_9538 = 255.0F;
   private static final double f_9539 = 78.0;
   private static final double f_9540 = 16.0;
   private static final float f_9541 = 0.999F;
   private static final String f_9542 = "Search...";
   private static final int f_9543 = 12500670;
   private static final float f_9544 = 0.001F;
   private static final String f_9545 = "Find cosmetic...";
   private static final String f_9546 = "Type module...";
   private static final float f_9547 = 3.0F;
   private static final float f_9548 = 1.5F;
   private static final int f_9549 = 14145496;
   private static final float f_9550 = 75.0F;
   private static final float f_9551 = 1.4F;
   private static final float f_9552 = 0.999F;
   private static final float f_9553 = 0.28F;
   private static final float f_9554 = 0.72F;
   private static final float f_9555 = 2.2F;
   private static final float f_9556 = 78.0F;
   private static final float f_9557 = 1.5F;
   private static final float f_9558 = 1.5F;
   private static final long f_9559 = 900L;
   private static final float f_9560 = 900.0F;
   private static final float f_9561 = 0.35F;
   private static final float f_9562 = 0.65F;
   private static final float l1 = 0.5F;
   private static final float f_9563 = 0.5F;
   private static final double f_9564 = Math.PI;
   private static final double ll = 2.0;
   private static final float l2 = 5.5F;
   private static final float f_9565 = 1.2F;
   private static final float f_9566 = 8.0F;
   private static final float f_9567 = 0.6F;
   private static final float f_9568 = 255.0F;
   private static final long f_9569 = 900L;
   private static final float f_9570 = 900.0F;
   private static final float l5 = 0.35F;
   private static final float f_9571 = 0.65F;
   private static final float f_9572 = 0.5F;
   private static final float f_9573 = 0.5F;
   private static final double f_9574 = Math.PI;
   private static final double f_9575 = 2.0;
   private static final float l7 = 5.5F;
   private static final float l9 = 1.2F;
   private static final float f_9576 = 8.0F;
   private static final float l4 = 0.6F;
   private static final float f_9577 = 255.0F;
   private static final int f_9578 = 12500670;
   private static final float f_9579 = 0.78F;
   private static final String f_9580 = "c";
   private static final float f_9581 = 110.0F;
   private static final float f_9582 = 15.0F;
   private static final float f_9583 = 0.8F;
   private static final float f_9584 = 8.0F;
   private static final float f_9585 = 160.0F;
   private static final float f_9586 = 168.0F;
   private static final float f_9587 = 118.0F;
   private static final float f_9588 = 10.0F;
   private static final float l3 = 12.0F;
   private static final float f_9589 = 92.0F;
   private static final float f_9590 = 92.0F;
   private static final float f_9591 = 6.0F;
   private static final float f_9592 = 9.0F;
   private static final float f_9593 = 5.0F;
   private static final float lO = 9.0F;
   private static final float f_9594 = 16.0F;
   private static final float f_9595 = 13.0F;
   private static final float f_9596 = 10.0F;
   private static final float f_9597 = 20.0F;
   private static final float f_9598 = 10.0F;
   private static final float f_9599 = 138.0F;
   private static final float f_9600 = 140.0F;
   private static final float f_9601 = 19.0F;
   private static final float f_9602 = 160.0F;
   private static final float f_9603 = 168.0F;
   private static final float f_9604 = 10.0F;
   private static final float f_9605 = 16.0F;
   private static final float f_9606 = 0.01F;
   private static final float f_9607 = 255.0F;
   private static final float f_9608 = 0.5F;
   private static final float f_9609 = 0.5F;
   private static final float l_ = 8.0F;
   private static final int f_9610 = 1710876;
   private static final float f_9611 = 7.5F;
   private static final float f_9612 = 0.5F;
   private static final float l8 = 0.5F;
   private static final float f_9613 = 6.0F;
   private static final int f_9614 = 1710876;
   private static final float f_9615 = (float) Math.PI;
   private static final float f_9616 = 0.5F;
   private static final float f_9617 = 0.5F;
   private static final float f_9618 = 6.0F;
   private static final int f_9619 = 1710876;
   private static final float l0 = 10.0F;
   private static final int f_9620 = 987153;
   private static final float f_9621 = 7.0F;
   private static final float f_9622 = 5.0F;
   private static final float l6 = 9.0F;
   private static final int f_9623 = 987153;
   private static final float f_9624 = 6.0F;
   private static final float f_9625 = 4.0F;
   private static final float f_9626 = 9.0F;
   private static final int f_9627 = 987153;
   private static final float lI = 6.0F;
   private static final float f_9628 = 4.0F;
   private static final String f_9629 = "#%02X%02X%02X";
   private static final float f_9630 = 7.0F;
   private static final int f_9631 = 13158601;
   private static final float f_9632 = 16.0F;
   private static final float f_9633 = 9.0F;
   private static final float f_9634 = 9.0F;
   private static final float f_9635 = 255.0F;
   private static final float f_9636 = 19.5F;
   private static final int f_9637 = 1447448;
   private static final float f_9638 = 220.0F;
   private static final float f_9639 = 19.0F;
   private static final int f_9640 = 1052946;
   private static final float f_9641 = 205.0F;
   private static final String f_9642 = "Theme Editor";
   private static final float f_9643 = 11.0F;
   private static final float f_9644 = 12.0F;
   private static final String f_9645 = "One accent color";
   private static final float f_9646 = 11.0F;
   private static final float f_9647 = 24.0F;
   private static final int f_9648 = 9408400;
   private static final float f_9649 = 38.0F;
   private static final float f_9650 = 10.0F;
   private static final float f_9651 = 20.0F;
   private static final float f_9652 = 20.0F;
   private static final float f_9653 = 12.0F;
   private static final int f_9654 = 1513497;
   private static final float f_9655 = 225.0F;
   private static final String f_9656 = "Current";
   private static final float f_9657 = 16.0F;
   private static final float f_9658 = 8.0F;
   private static final int f_9659 = 13158601;
   private static final String f_9660 = "#%02X%02X%02X";
   private static final float f_9661 = 28.0F;
   private static final float f_9662 = 8.0F;
   private static final float f_9663 = 18.0F;
   private static final float f_9664 = 10.0F;
   private static final float f_9665 = 10.0F;
   private static final float f_9666 = 66.0F;
   private static final float f_9667 = 10.0F;
   private static final float f_9668 = 75.0F;
   private static final float f_9669 = 23.0F;
   private static final int f_9670 = 16777215;
   private static final int f_9671 = 16777215;
   private static final int f_9672 = 1710876;
   private static final float f_9673 = 225.0F;
   private static final float f_9674 = 95.0F;
   private static final int f_9675 = 1316118;
   private static final float f_9676 = 225.0F;
   private static final float f_9677 = 0.72F;
   private static final float f_9678 = 205.0F;
   private static final float f_9679 = 0.5F;
   private static final float f_9680 = 0.5F;
   private static final float f_9681 = 65.0F;
   private static final float f_9682 = 18.0F;
   private static final float f_9683 = 10.0F;
   private static final float f_9684 = 64.0F;
   private static final float f_9685 = 17.0F;
   private static final float f_9686 = 9.5F;
   private static final float f_9687 = 0.01F;
   private static final float f_9688 = 1.1F;
   private static final float f_9689 = 1.1F;
   private static final float f_9690 = 66.2F;
   private static final float f_9691 = 19.2F;
   private static final float f_9692 = 10.8F;
   private static final float f_9693 = 45.0F;
   private static final float f_9694 = 9.0F;
   private static final float f_9695 = 8.5F;
   private static final float f_9696 = 7.0F;
   private static final float f_9697 = 1.25F;
   private static final float f_9698 = 16.0F;
   private static final float f_9699 = 1.5F;
   private static final float f_9700 = 7.0F;
   private static final float f_9701 = 0.01F;
   private static final String f_9702 = "i";
   private static final float f_9703 = 64.0F;
   private static final float f_9704 = 10.0F;
   private static final float f_9705 = 8.0F;
   private static final String f_9706 = "custom_button";
   private static final int f_9707 = 1710876;
   private static final float f_9708 = 225.0F;
   private static final float f_9709 = 55.0F;
   private static final int f_9710 = 1316118;
   private static final float f_9711 = 225.0F;
   private static final float f_9712 = 0.72F;
   private static final float f_9713 = 155.0F;
   private static final float f_9714 = 0.5F;
   private static final float f_9715 = 0.5F;
   private static final float f_9716 = 10.0F;
   private static final float f_9717 = 9.5F;
   private static final float f_9718 = 0.01F;
   private static final float f_9719 = 1.1F;
   private static final float f_9720 = 1.1F;
   private static final float f_9721 = 2.2F;
   private static final float f_9722 = 2.2F;
   private static final float f_9723 = 10.8F;
   private static final float f_9724 = 38.0F;
   private static final String f_9725 = "Custom Theme";
   private static final float f_9726 = 9.0F;
   private static final float f_9727 = 1.5F;
   private static final float f_9728 = 8.0F;
   private static final float f_9729 = 0.01F;
   private static final String f_9730 = "i";
   private static final float f_9731 = 10.0F;
   private static final float f_9732 = 8.0F;
   private static final float f_9733 = 0.01F;
   private static final float f_9734 = 4.0F;
   private static final float f_9735 = 4.0F;
   private static final String f_9736 = "Color Picker";
   private static final float f_9737 = 12.0F;
   private static final int f_9738 = 13158601;
   private static final String f_9739 = "x";
   private static final float f_9740 = 0.5F;
   private static final int f_9741 = 13816531;
   private static final float f_9742 = 14.0F;
   private static final float f_9743 = 28.0F;
   private static final float f_9744 = 3.0F;
   private static final float f_9745 = 3.0F;
   private static final float f_9746 = 6.0F;
   private static final float f_9747 = 6.0F;
   private static final float f_9748 = 66.0F;
   private static final float f_9749 = 10.0F;
   private static final float f_9750 = 75.0F;
   private static final float f_9751 = 23.0F;
   private static final float f_9752 = 64.0F;
   private static final float f_9753 = 17.0F;
   private static final float f_9754 = 25.0F;
   private static final float f_9755 = 100.0F;
   private static final int f_9756 = 1447448;
   private static final int f_9757 = 1118739;
   private static final float f_9758 = 0.01F;
   private static final float f_9759 = 208.0F;
   private static final float f_9760 = 136.0F;
   private static final float f_9761 = 255.0F;
   private static final float f_9762 = 10.0F;
   private static final float f_9763 = 416.0F;
   private static final float f_9764 = 272.0F;
   private static final float f_9765 = 24.0F;
   private static final int f_9766 = 921360;
   private static final float f_9767 = 220.0F;
   private static final float f_9768 = 96.0F;
   private static final float f_9769 = 272.0F;
   private static final float f_9770 = 24.0F;
   private static final float f_9771 = 24.0F;
   private static final int f_9772 = 921360;
   private static final float f_9773 = 135.0F;
   private static final String f_9774 = "a";
   private static final float f_9775 = 40.0F;
   private static final float f_9776 = 12.0F;
   private static final float f_9777 = 29.0F;
   private static final float f_9778 = 416.0F;
   private static final int f_9779 = 2171427;
   private static final float f_9780 = 8.0F;
   private static final float f_9781 = 5.0F;
   private static final float f_9782 = 272.0F;
   private static final float f_9783 = 33.0F;
   private static final float f_9784 = 5.0F;
   private static final float f_9785 = 82.0F;
   private static final float f_9786 = 27.0F;
   private static final float f_9787 = 16.5F;
   private static final int f_9788 = 1447448;
   private static final float f_9789 = 8.0F;
   private static final float f_9790 = 5.0F;
   private static final float f_9791 = 272.0F;
   private static final float f_9792 = 33.0F;
   private static final float f_9793 = 5.0F;
   private static final float f_9794 = 80.0F;
   private static final float f_9795 = 25.0F;
   private static final float f_9796 = 16.0F;
   private static final int f_9797 = 1118739;
   private static final String f_9798 = "energy";
   private static final String f_9799 = "images/ui/ava.png";
   private static final float f_9800 = 12.0F;
   private static final float f_9801 = 5.0F;
   private static final float f_9802 = 272.0F;
   private static final float f_9803 = 33.0F;
   private static final float f_9804 = 16.0F;
   private static final float f_9805 = 16.0F;
   private static final float f_9806 = 7.0F;
   private static final float f_9807 = 30.0F;
   private static final float f_9808 = 5.0F;
   private static final float f_9809 = 272.0F;
   private static final float f_9810 = 33.0F;
   private static final float f_9811 = 1.5F;
   private static final float f_9812 = 30.0F;
   private static final float f_9813 = 5.0F;
   private static final float f_9814 = 272.0F;
   private static final float f_9815 = 33.0F;
   private static final float f_9816 = 1.5F;
   private static final float f_9817 = 8.0F;
   private static final String f_9818 = "Main";
   private static final float f_9819 = 10.0F;
   private static final float f_9820 = 42.0F;
   private static final int f_9821 = 4802890;
   private static final float f_9822 = 18.0F;
   private static final float f_9823 = 10.0F;
   private static final float f_9824 = 58.0F;
   private static final float f_9825 = 9.5F;
   private static final float f_9826 = 80.0F;
   private static final float f_9827 = 22.0F;
   private static final float f_9828 = 5.5F;
   private static final int f_9829 = 1447448;
   private static final float f_9830 = 10.0F;
   private static final float f_9831 = 58.0F;
   private static final float f_9832 = 9.5F;
   private static final float f_9833 = 78.0F;
   private static final float f_9834 = 20.0F;
   private static final float f_9835 = 5.0F;
   private static final int f_9836 = 1118739;
   private static final float f_9837 = 58.0F;
   private static final float f_9838 = 25.0F;
   private static final float f_9839 = 10.0F;
   private static final float f_9840 = 9.5F;
   private static final float f_9841 = 80.0F;
   private static final float f_9842 = 22.0F;
   private static final float f_9843 = 0.72F;
   private static final int f_9844 = 12369085;
   private static final int f_9845 = 8487298;
   private static final float f_9846 = 0.82F;
   private static final float f_9847 = 1.4F;
   private static final float f_9848 = 0.3F;
   private static final float f_9849 = 10.0F;
   private static final float f_9850 = 25.0F;
   private static final float f_9851 = 224.0F;
   private static final float f_9852 = 306.0F;
   private static final float f_9853 = 110.0F;
   private static final float f_9854 = 184.0F;
   private static final float f_9855 = 225.0F;
   private static final float f_9856 = 47.0F;
   private static final float f_9857 = 102.0F;
   private static final float f_9858 = 39.0F;
   private static final float f_9859 = 224.0F;
   private static final float f_9860 = 96.0F;
   private static final float f_9861 = 29.0F;
   private static final double f_9862 = 320.0;
   private static final double f_9863 = 243.0;
   private static final float f_9864 = 102.0F;
   private static final float f_9865 = 48.0F;
   private static final float f_9866 = 153.0F;
   private static final float f_9867 = 19.5F;
   private static final int f_9868 = 1447448;
   private static final float f_9869 = 66.0F;
   private static final float f_9870 = 151.0F;
   private static final float f_9871 = 19.0F;
   private static final int f_9872 = 1052946;
   private static final float f_9873 = 66.0F;
   private static final float f_9874 = 6.0F;
   private static final float f_9875 = 8.0F;
   private static final int f_9876 = 4868940;
   private static final String f_9877 = "Active";
   private static final float f_9878 = 10.0F;
   private static final float f_9879 = 10.0F;
   private static final int f_9880 = 2236962;
   private static final int f_9881 = 9276813;
   private static final float f_9882 = 125.0F;
   private static final float f_9883 = 7.0F;
   private static final float f_9884 = 17.0F;
   private static final float f_9885 = 12.0F;
   private static final float f_9886 = 5.0F;
   private static final float f_9887 = 131.2F;
   private static final double f_9888 = 4.9F;
   private static final float f_9889 = 13.0F;
   private static final float f_9890 = 10.0F;
   private static final float f_9891 = 10.0F;
   private static final float f_9892 = 35.0F;
   private static final float f_9893 = 10.0F;
   private static final float f_9894 = 130.0F;
   private static final float f_9895 = 1.5F;
   private static final int f_9896 = 2236962;
   private static final float f_9897 = 70.0F;
   private static final int f_9898 = 2236962;
   private static final int f_9899 = 9276813;
   private static final float f_9900 = 125.0F;
   private static final float f_9901 = 10.0F;
   private static final float f_9902 = 7.0F;
   private static final float f_9903 = 10.0F;
   private static final float f_9904 = 17.0F;
   private static final float f_9905 = 12.0F;
   private static final float f_9906 = 5.0F;
   private static final float f_9907 = 131.2F;
   private static final float f_9908 = 10.0F;
   private static final double f_9909 = 4.9F;
   private static final float f_9910 = 3.0F;
   private static final float f_9911 = 10.0F;
   private static final float f_9912 = 25.0F;
   private static final float f_9913 = 10.0F;
   private static final float f_9914 = 130.0F;
   private static final float f_9915 = 1.5F;
   private static final int f_9916 = 2236962;
   private static final float f_9917 = 125.0F;
   private static final float f_9918 = 5.0F;
   private static final String f_9919 = "f";
   private static final int f_9920 = 12369085;
   private static final String f_9921 = "f";
   private static final float f_9922 = 125.0F;
   private static final float f_9923 = 5.0F;
   private static final float f_9924 = 25.0F;
   private static final float f_9925 = 8.0F;
   private static final float f_9926 = 43.0F;
   private static final float f_9927 = 43.0F;
   private static final float f_9928 = 43.0F;
   private static final float f_9929 = 10.0F;
   private static final float f_9930 = 130.0F;
   private static final float f_9931 = 1.5F;
   private static final int f_9932 = 2236962;
   private static final float f_9933 = 53.0F;
   private static final float f_9934 = 3.5F;
   private static final float f_9935 = 7.0F;
   private static final float f_9936 = 3.0F;
   private static final int f_9937 = 1841948;
   private static final float f_9938 = 0.5F;
   private static final float f_9939 = 3.5F;
   private static final float f_9940 = 0.5F;
   private static final float f_9941 = 7.0F;
   private static final float f_9942 = 3.0F;
   private static final int f_9943 = 1512983;
   private static final float f_9944 = 4.0F;
   private static final int f_9945 = 1512983;
   private static final float f_9946 = 4.0F;
   private static final float f_9947 = 2.5F;
   private static final float f_9948 = 7.5F;
   private static final float f_9949 = 4.0F;
   private static final float f_9950 = 1.5F;
   private static final float f_9951 = 25.0F;
   private static final float f_9952 = 10.0F;
   private static final float f_9953 = 130.0F;
   private static final float f_9954 = 1.5F;
   private static final int f_9955 = 2236962;
   private static final float f_9956 = 130.0F;
   private static final float f_9957 = 60.0F;
   private static final float f_9958 = 3.5F;
   private static final float f_9959 = 70.0F;
   private static final float f_9960 = 13.0F;
   private static final float f_9961 = 6.0F;
   private static final int f_9962 = 1841948;
   private static final float f_9963 = 235.0F;
   private static final float f_9964 = 60.0F;
   private static final float f_9965 = 0.5F;
   private static final float f_9966 = 3.5F;
   private static final float f_9967 = 0.5F;
   private static final float f_9968 = 69.0F;
   private static final float f_9969 = 12.0F;
   private static final float f_9970 = 6.0F;
   private static final int f_9971 = 1512983;
   private static final float f_9972 = 235.0F;
   private static final float f_9973 = 63.0F;
   private static final float f_9974 = 40.0F;
   private static final String f_9975 = "e";
   private static final float f_9976 = 120.0F;
   private static final int f_9977 = 8684676;
   private static final float f_9978 = 25.0F;
   private static final float f_9979 = 10.0F;
   private static final float f_9980 = 130.0F;
   private static final float f_9981 = 1.5F;
   private static final int f_9982 = 2236962;
   private static final float f_9983 = 60.0F;
   private static final float f_9984 = 3.5F;
   private static final float f_9985 = 70.0F;
   private static final float f_9986 = 13.0F;
   private static final float f_9987 = 6.0F;
   private static final int f_9988 = 1841948;
   private static final float f_9989 = 235.0F;
   private static final float f_9990 = 60.0F;
   private static final float f_9991 = 0.5F;
   private static final float f_9992 = 3.5F;
   private static final float f_9993 = 0.5F;
   private static final float f_9994 = 69.0F;
   private static final float f_9995 = 12.0F;
   private static final float f_9996 = 6.0F;
   private static final int f_9997 = 1512983;
   private static final float f_9998 = 235.0F;
   private static final String f_9999 = ", ";
   private static final String f_10000 = "Пусто";
   private static final float f_10001 = 63.0F;
   private static final float f_10002 = 35.0F;
   private static final String f_10003 = "e";
   private static final float f_10004 = 120.0F;
   private static final int f_10005 = 8684676;
   private static final float f_10006 = 25.0F;
   private static final String f_10007 = "Модули не найдены";
   private static final float f_10008 = 0.58F;
   private static final float f_10009 = 0.42F;
   private static final float f_10010 = 208.0F;
   private static final float f_10011 = 45.0F;
   private static final float f_10012 = 136.0F;
   private static final float f_10013 = 5.0F;
   private static final int f_10014 = 8421504;
   private static final float f_10015 = 96.0F;
   private static final float f_10016 = 29.0F;
   private static final double f_10017 = 320.0;
   private static final double f_10018 = 243.0;
   private static final float f_10019 = 102.0F;
   private static final float f_10020 = 48.0F;
   private static final float f_10021 = 10.0F;
   private static final float f_10022 = 35.0F;
   private static final float f_10023 = 13.0F;
   private static final float f_10024 = 13.0F;
   private static final float f_10025 = 60.0F;
   private static final float f_10026 = 3.5F;
   private static final float f_10027 = 70.0F;
   private static final float f_10028 = 6.0F;
   private static final int f_10029 = 1841948;
   private static final float f_10030 = 235.0F;
   private static final float f_10031 = 60.0F;
   private static final float f_10032 = 0.5F;
   private static final float f_10033 = 3.5F;
   private static final float f_10034 = 0.5F;
   private static final float f_10035 = 69.0F;
   private static final float f_10036 = 6.0F;
   private static final int f_10037 = 1512983;
   private static final float f_10038 = 235.0F;
   private static final float f_10039 = 63.0F;
   private static final float f_10040 = 40.0F;
   private static final String f_10041 = "e";
   private static final float f_10042 = 120.0F;
   private static final int f_10043 = 8684676;
   private static final float f_10044 = 0.1F;
   private static final float f_10045 = 60.0F;
   private static final float f_10046 = 7.0F;
   private static final double f_10047 = 70.0;
   private static final float f_10048 = 13.0F;
   private static final float f_10049 = 3.0F;
   private static final float f_10050 = 0.1F;
   private static final float f_10051 = 0.3F;
   private static final float f_10052 = 8.0F;
   private static final int f_10053 = 12631998;
   private static final int f_10054 = 16777215;
   private static final float f_10055 = 255.0F;
   private static final float f_10056 = 63.0F;
   private static final float f_10057 = 10.0F;
   private static final float f_10058 = 37.0F;
   private static final float f_10059 = 0.01F;
   private static final float f_10060 = 255.0F;
   private static final String f_10061 = "i";
   private static final float f_10062 = 63.0F;
   private static final float f_10063 = 10.0F;
   private static final float f_10064 = 10.0F;
   private static final float f_10065 = 25.0F;
   private static final float f_10066 = 13.0F;
   private static final float f_10067 = 13.0F;
   private static final float f_10068 = 60.0F;
   private static final float f_10069 = 3.5F;
   private static final float f_10070 = 70.0F;
   private static final float f_10071 = 6.0F;
   private static final int f_10072 = 1841948;
   private static final float f_10073 = 235.0F;
   private static final float f_10074 = 60.0F;
   private static final float f_10075 = 0.5F;
   private static final float f_10076 = 3.5F;
   private static final float f_10077 = 0.5F;
   private static final float f_10078 = 69.0F;
   private static final float f_10079 = 6.0F;
   private static final int f_10080 = 1512983;
   private static final float f_10081 = 235.0F;
   private static final String f_10082 = ", ";
   private static final String f_10083 = "Пусто";
   private static final float f_10084 = 63.0F;
   private static final float f_10085 = 35.0F;
   private static final String f_10086 = "e";
   private static final float f_10087 = 120.0F;
   private static final int f_10088 = 8684676;
   private static final float f_10089 = 0.1F;
   private static final float f_10090 = 60.0F;
   private static final float f_10091 = 7.0F;
   private static final double f_10092 = 70.0;
   private static final float f_10093 = 13.0F;
   private static final float f_10094 = 3.0F;
   private static final float f_10095 = 0.1F;
   private static final float f_10096 = 0.3F;
   private static final float f_10097 = 8.0F;
   private static final int f_10098 = 12631998;
   private static final int f_10099 = 16777215;
   private static final float f_10100 = 255.0F;
   private static final float f_10101 = 63.0F;
   private static final float f_10102 = 10.0F;
   private static final float f_10103 = 37.0F;
   private static final float f_10104 = 0.01F;
   private static final float f_10105 = 255.0F;
   private static final String f_10106 = "i";
   private static final float f_10107 = 63.0F;
   private static final float f_10108 = 10.0F;
   private static final float f_10109 = 10.0F;
   private static final float f_10110 = 25.0F;
   private static final float f_10111 = 25.0F;
   private static final float f_10112 = 224.0F;
   private static final float f_10113 = 0.58F;
   private static final float f_10114 = 0.42F;
   private static final double f_10115 = 0.01;
   private static final float f_10116 = 120.0F;
   private static final float f_10117 = 80.0F;
   private static final float f_10118 = 255.0F;
   private static final float f_10119 = 19.5F;
   private static final int f_10120 = 1447448;
   private static final float f_10121 = 220.0F;
   private static final float f_10122 = 19.0F;
   private static final int f_10123 = 1052946;
   private static final float f_10124 = 205.0F;
   private static final float f_10125 = 15.0F;
   private static final String f_10126 = "Keybind";
   private static final float f_10127 = 10.0F;
   private static final String f_10128 = "...";
   private static final String f_10129 = "n/a";
   private static final float f_10130 = 10.0F;
   private static final int f_10131 = 12369085;
   private static final float f_10132 = 10.0F;
   private static final float f_10133 = 15.0F;
   private static final float f_10134 = 20.0F;
   private static final float f_10135 = 1.5F;
   private static final int f_10136 = 2236962;
   private static final float f_10137 = 28.0F;
   private static final String f_10138 = "Mode";
   private static final float f_10139 = 10.0F;
   private static final String f_10140 = "Toggle";
   private static final String f_10141 = "Hold";
   private static final float f_10142 = 5.0F;
   private static final float f_10143 = 10.0F;
   private static final int f_10144 = 16777215;
   private static final int f_10145 = 8421504;
   private static final int f_10146 = 8421504;
   private static final int f_10147 = 16777215;
   private static final float f_10148 = 10.0F;
   private static final float f_10149 = 15.0F;
   private static final float f_10150 = 20.0F;
   private static final float f_10151 = 1.5F;
   private static final int f_10152 = 2236962;
   private static final float f_10153 = 25.0F;
   private static final String f_10154 = "o";
   private static final float f_10155 = 10.0F;
   private static final int f_10156 = 16739179;
   private static final String f_10157 = "Delete";
   private static final float f_10158 = 22.0F;
   private static final float f_10159 = 0.5F;
   private static final int f_10160 = 16739179;
   private static final float f_10161 = 62.0F;
   private static final float f_10162 = 127.0F;
   private static final float f_10163 = 20.0F;
   private static final float f_10164 = 9.0F;
   private static final float f_10165 = 4.0F;
   private static final float f_10166 = 24.0F;
   private static final float f_10167 = 20.0F;
   private static final float f_10168 = 20.0F;
   private static final float f_10169 = 4.0F;
   private static final float f_10170 = 24.0F;
   private static final float f_10171 = 1.0E-6F;
   private static final float f_10172 = 10.0F;
   private static final String f_10173 = ".";
   private static final String f_10174 = "0";
   private static final String f_10175 = ".";
   private static final float f_10176 = 1000.0F;
   private static final String f_10177 = "K";
   private static final String f_10178 = "M";
   private static final String f_10179 = "B";
   private static final String f_10180 = "T";
   private static final float f_10181 = 1000.0F;
   private static final float f_10182 = 1000.0F;
   private static final String f_10183 = "%.1e";
   private static final String f_10184 = "0";
   private static final float f_10185 = 110.0F;
   private static final float f_10186 = 20.0F;
   private static final float f_10187 = 110.0F;
   private static final float f_10188 = 20.0F;
   private static final double f_10189 = 0.5;
   private static final float f_10190 = 120.0F;
   private static final float f_10191 = 80.0F;
   private static final float f_10192 = 15.0F;
   private static final float f_10193 = 10.0F;
   private static final float f_10194 = 20.0F;
   private static final float f_10195 = 25.0F;
   private static final String f_10196 = "Toggle";
   private static final String f_10197 = "Hold";
   private static final float f_10198 = 5.0F;
   private static final float f_10199 = 10.0F;
   private static final float f_10200 = 25.0F;
   private static final float f_10201 = 10.0F;
   private static final float f_10202 = 60.0F;
   private static final double f_10203 = 0.5;
   private static final float f_10204 = 120.0F;
   private static final float f_10205 = 80.0F;
   private static final float f_10206 = 15.0F;
   private static final float f_10207 = 10.0F;
   private static final float f_10208 = 20.0F;
   private static final float f_10209 = 28.0F;
   private static final String f_10210 = "Toggle";
   private static final String f_10211 = "Hold";
   private static final float f_10212 = 5.0F;
   private static final float f_10213 = 10.0F;
   private static final float f_10214 = 25.0F;
   private static final float f_10215 = 10.0F;
   private static final float f_10216 = 60.0F;
   private static final float f_10217 = 18.0F;
   private static final float f_10218 = 58.0F;
   private static final float f_10219 = 10.0F;
   private static final float f_10220 = 9.5F;
   private static final float f_10221 = 80.0F;
   private static final float f_10222 = 22.0F;
   private static final float f_10223 = 25.0F;
   private static final float f_10224 = 96.0F;
   private static final float f_10225 = 29.0F;
   private static final float f_10226 = 320.0F;
   private static final float f_10227 = 243.0F;
   private static final float f_10228 = 29.0F;
   private static final float f_10229 = 416.0F;
   private static final float f_10230 = 243.0F;
   private static final float f_10231 = 102.0F;
   private static final float f_10232 = 48.0F;
   private static final float f_10233 = 10.0F;
   private static final float f_10234 = 35.0F;
   private static final float f_10235 = 60.0F;
   private static final float f_10236 = 3.5F;
   private static final float f_10237 = 70.0F;
   private static final float f_10238 = 60.0F;
   private static final float f_10239 = 3.5F;
   private static final float f_10240 = 70.0F;
   private static final float f_10241 = 25.0F;
   private static final float f_10242 = 18.0F;
   private static final float f_10243 = 18.0F;
   private static final float f_10244 = 102.0F;
   private static final float f_10245 = 48.0F;
   private static final float f_10246 = 153.0F;
   private static final float f_10247 = 27.0F;
   private static final float f_10248 = 10.0F;
   private static final float f_10249 = 35.0F;
   private static final float f_10250 = 125.0F;
   private static final float f_10251 = 10.0F;
   private static final float f_10252 = 7.0F;
   private static final float f_10253 = 10.0F;
   private static final float f_10254 = 17.0F;
   private static final float f_10255 = 12.0F;
   private static final float f_10256 = 25.0F;
   private static final float f_10257 = 125.0F;
   private static final float f_10258 = 5.0F;
   private static final String f_10259 = "f";
   private static final float f_10260 = 25.0F;
   private static final float f_10261 = 4.0F;
   private static final float f_10262 = 25.0F;
   private static final float f_10263 = 13.0F;
   private static final float f_10264 = 60.0F;
   private static final float f_10265 = 3.5F;
   private static final float f_10266 = 70.0F;
   private static final float f_10267 = 60.0F;
   private static final float f_10268 = 3.5F;
   private static final float f_10269 = 70.0F;
   private static final float f_10270 = 63.0F;
   private static final float f_10271 = 10.0F;
   private static final float f_10272 = 10.0F;
   private static final float f_10273 = 25.0F;
   private static final float f_10274 = 13.0F;
   private static final float f_10275 = 60.0F;
   private static final float f_10276 = 3.5F;
   private static final float f_10277 = 70.0F;
   private static final float f_10278 = 60.0F;
   private static final float f_10279 = 3.5F;
   private static final float f_10280 = 70.0F;
   private static final float f_10281 = 63.0F;
   private static final float f_10282 = 10.0F;
   private static final float f_10283 = 10.0F;
   private static final float f_10284 = 25.0F;
   private static final float f_10285 = 18.0F;
   private static final float f_10286 = 18.0F;
   private static final float f_10287 = 96.0F;
   private static final float f_10288 = 40.0F;
   private static final float f_10289 = 320.0F;
   private static final float f_10290 = 232.0F;
   private static final float f_10291 = 224.0F;
   private static final float f_10292 = 20.0F;
   private static final long f_10293 = 160L;
   private static final long f_10294 = 220L;
   private static final long f_10295 = 150L;
   private static final long f_10296 = 150L;
   private static final long f_10297 = 150L;
   private static final String f_10298 = "energy";
   private static final String f_10299 = "images/colorpicker/hueslider.png";
   private static final String f_10300 = "energy";
   private static final String f_10301 = "images/colorpicker/alphahueslider.png";
   private static final String f_10302 = "Aqua";
   private static final int f_10303 = 10857983;
   private static final String f_10304 = "Mint";
   private static final int f_10305 = 7788484;
   private static final String f_10306 = "Rose";
   private static final int f_10307 = 15961000;
   private static final String f_10308 = "Gold";
   private static final int f_10309 = 15382134;
   private static final String f_10310 = "Sky";
   private static final int f_10311 = 8043007;
   private static final String f_10312 = "Lime";
   private static final int f_10313 = 10935162;

   private float getThemeSVX() {
      return this.getThemeWindowX() + l3;
   }

   public boolean keyReleased(KeyInput var1) {
      return super.keyReleased(var1);
   }

   private void openBindWindowForBindSet(RenderUtil22 var1, double var2, double var4) {
      this.f_9427 = var1;
      this.f_9426 = null;
      this.f_9432 = var1;
      this.f_9431 = null;
      this.f_9433 = true;
      this.f_9428 = false;
      this.f_9429 = (float)var2;
      this.f_9430 = (float)var4;
   }

   private boolean isModuleVisible(float var1, float var2) {
      float var3 = this.f_9423 + f_9496;
      float var4 = this.f_9423 + f_9497;
      float var5 = var1 - f_9498;
      float var6 = var1 + var2 + f_9499;
      return var6 >= var3 && var5 <= var4;
   }

   public boolean shouldPause() {
      return false;
   }

   public boolean keyPressed(KeyInput var1) {
      int var2 = var1.key();
      if (!this.f_9428 || this.f_9426 == null && this.f_9427 == null) {
         if (var2 != 256 || this.f_9426 == null && this.f_9427 == null) {
            if (this.f_9461 && var2 == 256) {
               this.f_9461 = false;
               this.f_9459 = null;
               return true;
            } else {
               if (this.f_9450) {
                  if (var2 == 256) {
                     if (!this.f_9449.isEmpty()) {
                        this.f_9449 = "";
                        this.onSearchQueryMutated(false);
                     }

                     this.f_9450 = false;
                     return true;
                  }

                  if (var1.hasCtrlOrCmd() && var2 == 86) {
                     if (this.client != null && this.client.keyboard != null) {
                        this.appendSearchText(this.client.keyboard.getClipboard());
                     }

                     return true;
                  }

                  if (var2 == 259) {
                     if (!this.f_9449.isEmpty()) {
                        int var3 = this.f_9449.offsetByCodePoints(this.f_9449.length(), -1);
                        this.f_9449 = this.f_9449.substring(0, var3);
                        this.onSearchQueryMutated(false);
                     }

                     return true;
                  }

                  if (var2 == 257) {
                     this.f_9450 = false;
                     return true;
                  }
               }

               return super.keyPressed(var1);
            }
         } else {
            this.closeBindWindow();
            return true;
         }
      } else if (var2 == -1) {
         return true;
      } else {
         if (var2 == 256) {
            if (this.f_9426 != null) {
               this.f_9426.m_1957(-1);
            }

            if (this.f_9427 != null) {
               this.f_9427.m_466(-1);
            }
         } else if (var2 != 261 && var2 != 259) {
            if (this.f_9426 != null) {
               this.f_9426.m_1957(var2);
            }

            if (this.f_9427 != null) {
               this.f_9427.m_466(var2);
            }
         } else {
            if (this.f_9426 != null) {
               this.f_9426.m_1957(-1);
            }

            if (this.f_9427 != null) {
               this.f_9427.m_466(-1);
            }
         }

         this.f_9428 = false;
         return true;
      }
   }

   private Util165 getThemeSelectAnimation(String var1) {
      return this.f_9447.computeIfAbsent(var1, var0 -> new Util165(Util153.EASE_OUT_CUBIC, f_10294));
   }

   public boolean charTyped(CharInput var1) {
      if (this.f_9450) {
         this.appendSearchText(var1.asString());
         return true;
      } else {
         return super.charTyped(var1);
      }
   }

   protected void init() {
      super.init();
      this.restartAnimation(this.l, 0.0, 1.0);
      this.restartAnimation(this.f_9436, 0.0, 1.0);
      this.snapAnimation(this.f_9437, this.f_9425.ordinal() * f_9754);
      this.snapAnimation(this.f_9434, 0.0);
      this.snapAnimation(this.f_9438, 0.0);
      this.snapAnimation(this.f_9451, this.f_9450 ? 1.0 : 0.0);
      this.snapAnimation(this.f_9452, 1.0);
      this.snapAnimation(this.f_9453, 1.0);
      this.f_9455 = System.currentTimeMillis();
      this.f_9456 = 1;
      this.f_9448.clear();
      this.f_9441 = false;
      this.f_9433 = false;
      this.f_9431 = null;
      this.f_9432 = null;
      this.f_9426 = null;
      this.f_9427 = null;
      this.f_9428 = false;
      this.deactivateNumberSettings();
      this.closeAllDropdowns();
      this.f_9439.m_1549();
      this.f_9440.m_1283();
   }

   private float getThemeCustomButtonHeight() {
      return f_9601;
   }

   private void advanceModuleAnimations(Module var1, ObjectArrayList<Setting> var2) {
      var1.m_236().m_3631(var1.m_677() ? 1.0 : 0.0);
      ObjectListIterator var3 = var2.iterator();

      while (var3.hasNext()) {
         Setting var4 = (Setting)var3.next();
         if (var4.m_1326()) {
            if (var4 instanceof BooleanSetting var5) {
               var5.l().m_3631(var5.m_1163() ? 1.0 : 0.0);
            } else if (var4 instanceof NumberSetting var6) {
               var6.m_1997().m_3631(this.getPos(var6));
            } else if (var4 instanceof ModeSetting var7) {
               var7.m_3744().m_3631(var7.m_2480() ? 1.0 : 0.0);
            } else if (var4 instanceof Util63 var8) {
               var8.m_3994().m_3631(var8.m_1931() ? 1.0 : 0.0);
            }
         }
      }
   }

   private void closeAllDropdowns() {
      if (this.f_9457 != null) {
         this.f_9457.m_3344(false);
         this.f_9457 = null;
      }

      if (this.f_9458 != null) {
         this.f_9458.m_2410(false);
         this.f_9458 = null;
      }
   }

   private float getThemeSVWidth() {
      return f_9589;
   }

   private void closeBindWindow() {
      this.f_9433 = false;
      this.f_9428 = false;
      this.f_9426 = null;
      this.f_9427 = null;
   }

   private float getThemeHueWidth() {
      return f_9592;
   }

   private boolean appendSearchText(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         StringBuilder var2 = new StringBuilder(this.f_9449);
         int var3 = this.f_9449.codePointCount(0, this.f_9449.length());

         for (int var4 = 0; var4 < var1.length() && var3 < 48; var4++) {
            char var5 = var1.charAt(var4);
            if (!Character.isISOControl(var5) && Util93.f_6003[15].m_1621(var5) > 0.0F) {
               var2.append(var5);
               var3++;
            }
         }

         if (var2.length() == this.f_9449.length()) {
            return false;
         } else {
            this.f_9449 = var2.toString();
            this.onSearchQueryMutated(true);
            return true;
         }
      } else {
         return false;
      }
   }

   public void render(DrawContext var1, int var2, int var3, float var4) {
      if (this.client != null && this.client.getWindow() != null) {
         this.renderContent(var1, var2, var3, var4);
      }
   }

   private float getThemeSVHeight() {
      return f_9590;
   }

   private float getNumberSliderValueRightX(float var1) {
      return var1 + f_10162;
   }

   private boolean isThemeWindowHovered(double var1, double var3) {
      return Util39.m_121(var1, var3, this.getThemeWindowX(), this.getThemeWindowY(), this.getThemeWindowWidth(), this.getThemeWindowHeight());
   }

   private void openBindWindowForModule(Module var1, double var2, double var4) {
      this.f_9426 = var1;
      this.f_9427 = null;
      this.f_9431 = var1;
      this.f_9432 = null;
      this.f_9433 = true;
      this.f_9428 = false;
      this.f_9429 = (float)var2;
      this.f_9430 = (float)var4;
   }

   private float getConfigImportWindowX() {
      return this.getThemeWindowX();
   }

   private boolean isAnyDropdownOpen() {
      return this.f_9457 != null && this.f_9457.m_2480() || this.f_9458 != null && this.f_9458.m_1931();
   }

   private float getNumberSliderStartX(float var1) {
      return var1 + f_10161;
   }

   private List<Module> getFilteredModules() {
      if (this.f_9425 == Category.COSMETICS) {
         return List.of();
      } else if (this.f_9466 != null && this.f_9467 == this.f_9425 && this.f_9449.equals(this.f_9468)) {
         return this.f_9466;
      } else {
         if (InitManager.f_2740 == null || InitManager.f_2740.f_2741 == null) return List.of();
         Stream<Module> var1 = InitManager.f_2740.f_2741.m_3515().stream();
         if (this.f_9449.isEmpty()) {
            var1 = var1.filter(var1x -> var1x.m_2409() == this.f_9425);
         } else {
            String var2 = this.f_9449.toLowerCase(Locale.ROOT);
            var1 = var1.filter(var1x -> var1x.m_1199().toLowerCase(Locale.ROOT).contains(var2));
         }

         this.f_9466 = var1.toList();
         this.f_9467 = this.f_9425;
         this.f_9468 = this.f_9449;
         return this.f_9466;
      }
   }

   public boolean shouldCloseOnEsc() {
      this.f_9440.m_1283();
      if (!this.f_9441) {
         this.f_9441 = true;
         this.closeBindWindow();
         this.f_9461 = false;
         this.f_9459 = null;
         return false;
      } else {
         return true;
      }
   }

   private float getThemeCustomButtonX() {
      return this.getThemeWindowX() + f_9598;
   }

   private void snapAnimation(Util165 var1, double var2) {
      var1.m_2214(var2);
      var1.m_2946(var2);
      var1.m_1829(var2);
      var1.m_1876(System.currentTimeMillis());
      var1.l(true);
   }

   private float getConfigImportVisibility() {
      return 1.0F - Util39.m_2529((float)this.f_9438.m_2276(), 0.0F, 1.0F);
   }

   private float getThemeAlphaX() {
      return this.getThemeHueX() + this.getThemeHueWidth() + f_9593;
   }

   private void deactivateNumberSettings() {
      if (InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null) {
         ObjectListIterator var1 = InitManager.f_2740.f_2741.m_3515().iterator();

         while (var1.hasNext()) {
            Module var2 = (Module)var1.next();
            ObjectListIterator var3 = var2.m_179().iterator();

            while (var3.hasNext()) {
               Setting var4 = (Setting)var3.next();
               if (var4 instanceof NumberSetting var5) {
                  var5.m_1584(false);
               }
            }
         }
      }
   }

   private void beginCategoryTransition(Category var1, Category var2) {
      this.f_9440.m_1283();
      this.f_9456 = Integer.compare(var2.ordinal(), var1.ordinal());
      if (this.f_9456 == 0) {
         this.f_9456 = 1;
      }

      this.resetModuleScroll();
      this.closeAllDropdowns();
      this.closeBindWindow();
      this.deactivateNumberSettings();
      this.restartAnimation(this.f_9436, 0.0, 1.0);
   }

   public boolean mouseReleased(Click var1) {
      this.f_9440.m_1283();
      this.f_9459 = null;
      this.buildFrameCache().m_353().forEach(var0 -> var0.m_1278().forEach(var0x -> {
         if (var0x instanceof NumberSetting var1x) {
            var1x.m_1584(false);
         }
      }));
      return super.mouseReleased(var1);
   }

   private float getThemeAlphaWidth() {
      return lO;
   }

   private void resetModuleScroll() {
      this.f_9442 = 0.0F;
      this.f_9443 = 0.0F;
   }

   private void renderCustomThemePicker(DrawContext var1, float var2) {
      float var3 = (float)this.f_9438.m_2276();
      if (!(var3 <= f_9606)) {
         int var4 = (int)(f_9607 * var2 * var3);
         float var5 = this.getThemeSVX();
         float var6 = this.getThemeSVY();
         float var7 = this.getThemeSVWidth();
         float var8 = this.getThemeSVHeight();
         int var9 = Util71.m_3389(Color.HSBtoRGB(this.f_9462, 1.0F, 1.0F), 255);
         Util158.m_1849(var5 - f_9608, var6 - f_9609, var7 + 1.0F, var8 + 1.0F, l_, Util71.m_3389(f_9610, var4));
         Util158.m_3404(var5, var6, var7, var8, f_9611, Util71.m_1415(255, 255, 255), Util71.m_1415(0, 0, 0), var9, Util71.m_1415(0, 0, 0), var2 * var3);
         float var10 = this.getThemeHueX();
         float var11 = this.getThemeHueY();
         float var12 = this.getThemeHueWidth();
         float var13 = this.getThemeHueHeight();
         Util158.m_1849(var10 - f_9612, var11 - l8, var12 + 1.0F, var13 + 1.0F, f_9613, Util71.m_3389(f_9614, var4));
         Matrix3x2fStack var14 = var1.getMatrices();
         var14.pushMatrix();
         var14.translate(var10 + var12 / 2.0F, var11 + var13 / 2.0F);
         var14.rotate(f_9615);
         Util158.m_3024(var14, f_9419, -var12 / 2.0F, -var13 / 2.0F, var12, var13, new Color(255, 255, 255, var4));
         var14.popMatrix();
         float var15 = this.getThemeAlphaX();
         float var16 = this.getThemeAlphaY();
         float var17 = this.getThemeAlphaWidth();
         float var18 = this.getThemeAlphaHeight();
         int var19 = Color.HSBtoRGB(this.f_9462, this.f_9463, this.f_9464);
         Util158.m_1849(var15 - f_9616, var16 - f_9617, var17 + 1.0F, var18 + 1.0F, f_9618, Util71.m_3389(f_9619, var4));
         Util158.m_3024(
            var1.getMatrices(), f_9420, var15, var16, var17, var18, new Color(Util71.m_1989(var19), Util71.m_644(var19), Util71.m_3163(var19), var4)
         );
         float var20 = var5 + this.f_9463 * var7;
         float var21 = var6 + (1.0F - this.f_9464) * var8;
         Util158.m_1115(var20, var21, l0, Util71.m_3389(f_9620, var4));
         Util158.m_1115(var20, var21, f_9621, Util71.m_3389(-1, var4));
         Util158.m_1115(var20, var21, f_9622, Util71.m_3389(var19, var4));
         float var22 = var10 + var12 / 2.0F;
         float var23 = var11 + this.f_9462 * var13;
         Util158.m_1115(var22, var23, l6, Util71.m_3389(f_9623, var4));
         Util158.m_1115(var22, var23, f_9624, Util71.m_3389(-1, var4));
         Util158.m_1115(var22, var23, f_9625, Util71.m_3389(Color.HSBtoRGB(this.f_9462, 1.0F, 1.0F), var4));
         float var24 = var15 + var17 / 2.0F;
         float var25 = var16 + (1.0F - this.f_9465) * var18;
         Util158.m_1115(var24, var25, f_9626, Util71.m_3389(f_9627, var4));
         Util158.m_1115(var24, var25, lI, Util71.m_3389(-1, var4));
         Util158.m_1115(var24, var25, f_9628, Util71.m_3389(var19, var4));
         String var26 = String.format(
            f_9629, Util71.m_1989(EnergyClient.getThemeColor()), Util71.m_644(EnergyClient.getThemeColor()), Util71.m_3163(EnergyClient.getThemeColor())
         );
         Util93.f_6003[13].m_2915(var1, var26, this.getThemeSVX(), this.getThemeSVY() + this.getThemeSVHeight() + f_9630, Util71.m_3389(f_9631, var4));
         Util158.m_1115(
            this.getThemeWindowX() + this.getThemeWindowWidth() - f_9632,
            this.getThemeSVY() + this.getThemeSVHeight() + f_9633,
            f_9634,
            Util71.m_3389(EnergyClient.getThemeColor(), var4)
         );
      }
   }

   private float getPos(NumberSetting var1) {
      float var2 = var1.m_2596() - var1.m_925();
      return (var1.m_4046() - var1.m_925()) / var2;
   }

   private void renderThemeEditor(DrawContext var1, float var2) {
      float var3 = this.getThemeWindowX();
      float var4 = this.getThemeWindowY();
      float var5 = this.getThemeWindowWidth();
      float var6 = this.getThemeWindowHeight();
      int var7 = (int)(f_9635 * var2);
      int var8 = EnergyClient.getThemeColor();
      float var9 = (float)this.f_9438.m_2276();
      float var10 = Util39.m_2529(var2, 0.0F, 1.0F);
      Util158.m_3998(var3 - 1.0F, var4 - 1.0F, var5 + 2.0F, var6 + 2.0F, f_9636, Util71.m_3389(f_9637, (int)(f_9638 * var10)), var10);
      Util158.m_3998(var3, var4, var5, var6, f_9639, Util71.m_3389(f_9640, (int)(f_9641 * var10)), var10);
      Util93.f_6001[16].m_2915(var1, f_9642, var3 + f_9643, var4 + f_9644, Util71.m_3389(-1, var7));
      Util93.f_6003[13].m_2915(var1, f_9645, var3 + f_9646, var4 + f_9647, Util71.m_3389(f_9648, var7));
      float var11 = var4 + f_9649;
      Util158.m_3998(var3 + f_9650, var11, var5 - f_9651, f_9652, f_9653, Util71.m_3389(f_9654, (int)(f_9655 * var2)), var2);
      Util93.f_6001[13].m_2915(var1, f_9656, var3 + f_9657, var11 + f_9658, Util71.m_3389(f_9659, var7));
      String var12 = String.format(f_9660, Util71.m_1989(var8), Util71.m_644(var8), Util71.m_3163(var8));
      float var13 = Util93.f_6003[13].m_585(var12);
      Util93.f_6003[13].m_2915(var1, var12, var3 + var5 - f_9661 - var13, var11 + f_9662, Util71.m_3389(-1, var7));
      Util158.m_1115(var3 + var5 - f_9663, var11 + f_9664, f_9665, Util71.m_3389(var8, var7));
      float var14 = var4 + f_9666;

      for (int var15 = 0; var15 < f_9421.size(); var15++) {
         ThemeEditor.sKN8QGcpT98iFDgp var16 = f_9421.get(var15);
         float var17 = var3 + f_9667 + var15 % 2 * f_9668;
         float var18 = var14 + var15 / 2 * f_9669;
         boolean var19 = !this.f_9460 && (var8 & f_9670) == (var16.color() & f_9671);
         Util165 var20 = this.getThemeSelectAnimation("preset_" + var16.name());
         var20.m_3631(var19 ? 1.0 : 0.0);
         float var21 = (float)var20.m_2276();
         int var22 = Util71.m_2924(Util71.m_3389(f_9672, (int)(f_9673 * var2)), Util71.m_3389(var8, (int)(f_9674 * var2)), var21);
         int var23 = Util71.m_2924(Util71.m_3389(f_9675, (int)(f_9676 * var2)), Util71.m_3389(Util71.m_2101(var8, f_9677), (int)(f_9678 * var2)), var21);
         Util158.m_3998(var17 - f_9679, var18 - f_9680, f_9681, f_9682, f_9683, var22, var10);
         Util158.m_3998(var17, var18, f_9684, f_9685, f_9686, var23, var10);
         if (var21 > f_9687) {
            Util158.m_3998(var17 - f_9688, var18 - f_9689, f_9690, f_9691, f_9692, Util71.m_3389(var8, (int)(f_9693 * var2 * var21)), var10 * var21);
         }

         Util158.m_1115(var17 + f_9694, var18 + f_9695, f_9696 + var21 * f_9697, Util71.m_3389(var16.color(), var7));
         Util93.f_6001[13].m_2915(var1, var16.name(), var17 + f_9698 + var21 * f_9699, var18 + f_9700, Util71.m_3389(-1, var7));
         if (var21 > f_9701) {
            Util93.f_6000[13].m_2915(var1, f_9702, var17 + f_9703 - f_9704, var18 + f_9705, Util71.m_3389(var8, (int)(var7 * var21)));
         }
      }

      float var31 = this.getThemeCustomButtonX();
      float var32 = this.getThemeCustomButtonY();
      float var33 = this.getThemeCustomButtonWidth();
      float var34 = this.getThemeCustomButtonHeight();
      boolean var35 = this.f_9460;
      Util165 var36 = this.getThemeSelectAnimation(f_9706);
      var36.m_3631(var35 ? 1.0 : 0.0);
      float var37 = (float)var36.m_2276();
      int var38 = Util71.m_2924(Util71.m_3389(f_9707, (int)(f_9708 * var2)), Util71.m_3389(var8, (int)(f_9709 * var2)), var37);
      int var39 = Util71.m_2924(Util71.m_3389(f_9710, (int)(f_9711 * var2)), Util71.m_3389(Util71.m_2101(var8, f_9712), (int)(f_9713 * var2)), var37);
      Util158.m_3998(var31 - f_9714, var32 - f_9715, var33 + 1.0F, var34 + 1.0F, f_9716, var38, var10);
      Util158.m_3998(var31, var32, var33, var34, f_9717, var39, var10);
      if (var37 > f_9718) {
         Util158.m_3998(
            var31 - f_9719, var32 - f_9720, var33 + f_9721, var34 + f_9722, f_9723, Util71.m_3389(var8, (int)(f_9724 * var2 * var37)), var10 * var37
         );
      }

      Util93.f_6001[13].m_2915(var1, f_9725, var31 + f_9726 + var37 * f_9727, var32 + f_9728, Util71.m_3389(-1, var7));
      if (var37 > f_9729) {
         Util93.f_6000[13].m_2915(var1, f_9730, var31 + var33 - f_9731, var32 + f_9732, Util71.m_3389(var8, (int)(var7 * var37)));
      }

      if (var9 > f_9733) {
         int var24 = (int)(var7 * var9);
         RenderUtil2.m_3624(var3 + 2.0F, var4 + 2.0F, var5 - f_9734, var6 - f_9735);

         try {
            float var25 = this.getThemeCloseX();
            float var26 = this.getThemeCloseY();
            float var27 = this.getThemeCloseSize();
            Util93.f_6003[13].m_2915(var1, f_9736, this.getThemeSVX(), this.getThemeSVY() - f_9737, Util71.m_3389(f_9738, var24));
            Util93.f_6003[16].m_2915(var1, f_9739, var25 + f_9740, var26, Util71.m_3389(f_9741, var24));
            this.renderCustomThemePicker(var1, var2);
         } finally {
            RenderUtil2.m_1647();
         }
      }
   }

   private float getConfigImportWindowY() {
      return this.f_9423 + f_9603 + f_9604 + (1.0F - this.getConfigImportVisibility()) * f_9605;
   }

   private float getThemeHueHeight() {
      return this.getThemeSVHeight();
   }

   private Util165 getModeAnimation(String var1, String var2) {
      String var3 = var1 + "_" + var2;
      return this.f_9444.computeIfAbsent(var3, var0 -> new Util165(Util153.EASE_OUT_CUBIC, f_10297));
   }

   private String formatNumberWithDecimals(float var1, int var2) {
      if (var2 <= 0) {
         return Integer.toString(Math.round(var1));
      } else {
         String var3 = String.format(Locale.US, "%." + var2 + "f", var1);

         while (var3.contains(f_10173) && (var3.endsWith(f_10174) || var3.endsWith(f_10175))) {
            var3 = var3.substring(0, var3.length() - 1);
         }

         return var3;
      }
   }

   private void syncCustomPickerFromTheme() {
      int var1 = EnergyClient.getThemeColor();
      float[] var2 = Color.RGBtoHSB(Util71.m_1989(var1), Util71.m_644(var1), Util71.m_3163(var1), null);
      this.f_9462 = var2[0];
      this.f_9463 = var2[1];
      this.f_9464 = var2[2];
      this.f_9465 = 1.0F;
   }

   private void restartAnimation(Util165 var1, double var2, double var4) {
      var1.m_2214(var2);
      var1.m_2946(var2);
      var1.m_1829(var4);
      var1.m_1876(System.currentTimeMillis());
      var1.l(false);
   }

   private float getThemeWindowWidth() {
      return f_9585;
   }

   private float getThemeSVY() {
      return this.getThemePickerY();
   }

   private float getNumberSliderWidth(float var1, float var2) {
      float var3 = this.getNumberSliderValueRightX(var1) - var2 - this.getNumberSliderStartX(var1) - f_10169;
      return Math.max(f_10170, var3);
   }

   private boolean handleConfigImportClick(double var1, double var3, int var5) {
      return this.f_9439
         .m_3509(
            var1,
            var3,
            var5,
            this.getConfigImportWindowX(),
            this.getConfigImportWindowY(),
            this.getConfigImportWindowWidth(),
            this.getConfigImportVisibility(),
            InitManager.f_2740 != null ? InitManager.f_2740.f_2751 : null
         );
   }

   public boolean mouseDragged(Click var1, double var2, double var4) {
      double var6 = var1.x();
      double var8 = var1.y();
      int var10 = var1.button();
      if (this.f_9459 != null && var10 == 0) {
         this.updateCustomPickerFromMouse(this.f_9459, var6, var8);
         return true;
      } else {
         return this.f_9425 == Category.COSMETICS && this.f_9440.m_2894(var10, var2, var4) ? true : super.mouseDragged(var1, var2, var4);
      }
   }

   private void renderSearchField(DrawContext var1, int var2, float var3) {
      float var4 = this.getSearchFieldX();
      float var5 = this.getSearchFieldY();
      float var6 = this.clamp01(var3);
      this.f_9451.m_3631(this.f_9450 ? 1.0 : 0.0);
      this.f_9452.m_3631(1.0);
      float var7 = this.clamp01(this.f_9451.m_2276());
      float var8 = this.clamp01(this.f_9452.m_2276());
      float var9 = 1.0F - var8;
      float var10 = this.clamp01(Math.max(var7 * f_9514, var9));
      int var11 = Util71.m_2924(f_9515, var2, var10 * f_9516);
      int var12 = Util71.m_2924(f_9517, Util71.m_2101(var2, f_9518), var10 * f_9519);
      int var13 = (int)((f_9520 + f_9521 * var10) * var6);
      Util158.m_335(var4 - 1.0F, var5 - 1.0F, f_9522, f_9523, f_9524, Util71.m_3389(var11, var13));
      Util158.m_335(var4, var5, f_9525, f_9526, f_9527, Util71.m_3389(var12, (int)(f_9528 * var6)));
      if (var10 > f_9529) {
         float var14 = this.clamp01(Math.max(var7, var9));
         float var15 = f_9530 * var14;
         Util158.m_1849(var4 + (f_9531 - var15) / 2.0F, var5 + f_9532 - f_9533, var15, 1.0F, f_9534, Util71.m_3389(var2, (int)(f_9535 * var10 * var6)));
      }

      float var28 = var4 + f_9536;
      float var29 = var5 + f_9537;
      int var16 = (int)(f_9538 * var6);
      RenderUtil2.m_3624(var28, var5 + 2.0F, f_9539, f_9540);

      try {
         if (this.f_9449.isEmpty()) {
            if (var7 < f_9541) {
               Util93.f_6003[15].m_2915(var1, f_9542, var28, var29 - var7, Util71.m_3389(f_9543, (int)(var16 * (1.0F - var7))));
            }

            if (var7 > f_9544) {
               Util93.f_6003[15]
                  .m_2915(
                     var1,
                     this.f_9425 == Category.COSMETICS ? f_9545 : f_9546,
                     var28 + f_9547,
                     var29 + (1.0F - var7) * f_9548,
                     Util71.m_3389(f_9549, (int)(var16 * var7))
                  );
            }
         } else {
            String var17 = this.fitSearchTail(this.f_9449, f_9550);
            float var18 = this.f_9454 ? 0.0F : var9 * f_9551;
            if (this.f_9454 && var8 < f_9552 && !var17.isEmpty()) {
               int var34 = var17.offsetByCodePoints(var17.length(), -1);
               String var20 = var17.substring(0, var34);
               String var21 = var17.substring(var34);
               Util93.f_6003[15].m_2915(var1, var20, var28, var29, Util71.m_3389(-1, var16));
               float var22 = var28 + Util93.f_6003[15].m_585(var20);
               int var23 = Util71.m_2924(var2, -1, var8);
               int var24 = (int)(var16 * (f_9553 + f_9554 * var8));
               Util93.f_6003[15].m_2915(var1, var21, var22, var29 + var9 * f_9555, Util71.m_3389(var23, var24));
            } else {
               int var19 = Util71.m_2924(var2, -1, var8);
               Util93.f_6003[15].m_2915(var1, var17, var28 + var18, var29, Util71.m_3389(var19, var16));
            }

            if (this.f_9450) {
               float var35 = Util93.f_6003[15].m_585(var17);
               float var36 = Math.min(var28 + f_9556 - f_9557, var28 + var35 + f_9558 + var18);
               float var37 = (float)((System.currentTimeMillis() - this.f_9455) % f_9559) / f_9560;
               float var38 = f_9561 + f_9562 * (l1 + f_9563 * (float)Math.cos(var37 * f_9564 * ll));
               float var39 = Math.max(var38, var9);
               Util158.m_1849(var36, var5 + l2 - var9, f_9565, f_9566 + var9 * 2.0F, f_9567, Util71.m_3389(var2, (int)(f_9568 * var6 * var7 * var39)));
            }
         }

         if (this.f_9450 && this.f_9449.isEmpty()) {
            float var30 = (float)((System.currentTimeMillis() - this.f_9455) % f_9569) / f_9570;
            float var32 = l5 + f_9571 * (f_9572 + f_9573 * (float)Math.cos(var30 * f_9574 * f_9575));
            Util158.m_1849(var28, var5 + l7, l9, f_9576, l4, Util71.m_3389(var2, (int)(f_9577 * var6 * var7 * Math.max(var32, var9))));
         }
      } finally {
         RenderUtil2.m_1647();
      }

      float var31 = this.clamp01(Math.max(var7, var9));
      int var33 = Util71.m_2924(f_9578, var2, var31 * f_9579);
      Util93.f_6000[15].m_2915(var1, f_9580, var4 + f_9581 - f_9582 - var7 * f_9583 + var9, var5 + f_9584, Util71.m_3389(var33, var16));
   }

   private float getThemeAlphaHeight() {
      return this.getThemeSVHeight();
   }

   private float getSearchFieldY() {
      return this.f_9425 == Category.COSMETICS ? Math.max(f_9511, this.f_9423 + f_9512) : this.f_9423 + f_9513;
   }

   private void clearBindWindowRenderCacheIfFinished() {
      if (!this.f_9433 && this.f_9434.m_2276() <= f_9495) {
         this.f_9431 = null;
         this.f_9432 = null;
      }
   }

   private float getThemePickerY() {
      return this.getThemeCustomButtonY() + this.getThemeCustomButtonHeight() + f_9597;
   }

   private int getNumberDecimals(float var1) {
      int var2 = 0;

      for (float var3 = var1; var2 < 6 && Math.abs(var3 - Math.round(var3)) > f_10171; var2++) {
         var3 *= f_10172;
      }

      return var2;
   }

   private float clamp01(double var1) {
      return (float)Math.max(0.0, Math.min(1.0, var1));
   }

   private float getNumberValueBoxWidth(float var1, float var2) {
      float var3 = Math.max(f_10163, var2 + f_10164);
      float var4 = this.getNumberSliderValueRightX(var1) - this.getNumberSliderStartX(var1) - f_10165 - f_10166;
      float var5 = Math.max(f_10167, var4);
      return Util39.m_2529(var3, f_10168, var5);
   }

   private String fitSearchTail(String var1, float var2) {
      if (var1 != null && !var1.isEmpty()) {
         String var3 = var1;

         while (var3.codePointCount(0, var3.length()) > 1 && Util93.f_6003[15].m_585(var3) > var2) {
            int var4 = var3.offsetByCodePoints(0, 1);
            var3 = var3.substring(var4);
         }

         return var3;
      } else {
         return "";
      }
   }

   public ThemeEditor() {
      super(Text.literal(f_9469));
      this.f_9424 = f_9470;
      this.I = f_9471;
      this.f_9425 = Category.COMBAT;
      this.f_9428 = false;
      this.f_9433 = false;
      this.l = new Util165(Util153.EASE_OUT_CUBIC, f_9472);
      this.f_9434 = new Util165(Util153.EASE_OUT_CUBIC, f_9473);
      this.f_9435 = new Util165(Util153.EASE_OUT_CUBIC, f_9474);
      this.f_9436 = new Util165(Util153.LINEAR, f_9475);
      this.f_9437 = new Util165(Util153.EASE_OUT_BACK, f_9476);
      this.f_9438 = new Util165(Util153.EASE_OUT_CUBIC, f_9477);
      this.f_9439 = new RenderUtil19();
      this.f_9440 = new Util5();
      this.f_9444 = new HashMap<>();
      this.f_9445 = new HashMap<>();
      this.f_9446 = new HashMap<>();
      this.f_9447 = new HashMap<>();
      this.f_9448 = new EnumMap<>(Category.class);
      this.f_9449 = "";
      this.f_9450 = false;
      this.f_9451 = new Util165(Util153.EASE_OUT_CUBIC, f_9478);
      this.f_9452 = new Util165(Util153.EASE_OUT_CUBIC, f_9479);
      this.f_9453 = new Util165(Util153.EASE_OUT_CUBIC, f_9480);
      this.f_9454 = true;
      this.f_9455 = System.currentTimeMillis();
      this.f_9456 = 1;
      this.f_9457 = null;
      this.f_9458 = null;
      this.f_9459 = null;
      this.f_9460 = false;
      this.f_9461 = false;
      this.f_9462 = f_9481;
      this.f_9463 = f_9482;
      this.f_9464 = 1.0F;
      this.f_9465 = 1.0F;
   }

   private Util165 getMultiBoolAnimation(String var1, String var2) {
      String var3 = var1 + "_" + var2;
      return this.f_9445.computeIfAbsent(var3, var0 -> new Util165(Util153.EASE_OUT_CUBIC, f_10296));
   }

   private float getThemeAlphaY() {
      return this.getThemeSVY();
   }

   private String formatNumberValue(NumberSetting var1) {
      float var2 = var1.m_4046();
      int var3 = Math.min(this.getNumberDecimals(var1.m_2099()), 4);
      return this.formatNumberWithDecimals(var2, var3);
   }

   private float getThemeWindowX() {
      return this.f_9422 - this.getThemeWindowWidth() - f_9588;
   }

   private Util28 buildFrameCache() {
      List<Module> modules = this.getFilteredModules();
      if (this.f_frameCache != null && this.f_frameCacheModules == modules) {
         return this.f_frameCache;
      }
      this.f_frameCache = Util28.m_468(modules);
      this.f_frameCacheModules = modules;
      return this.f_frameCache;
   }

   private ThemeEditor.iOgAfy2mLF6S7jpm getModuleEntryTransform(int var1, boolean var2, float var3, float var4) {
      int var5 = var1 / 2;
      float var6 = Math.min(f_9485, var5 * f_9486 + (var2 ? f_9487 : 0.0F));
      float var7 = this.clamp01((var3 - var6) / Math.max(f_9488, 1.0F - var6));
      float var8 = this.clamp01(Util153.EASE_OUT_CUBIC.m_3883(var7));
      float var9 = Util153.EASE_OUT_BACK.m_3883(var7);
      float var10 = this.clamp01(var4);
      float var11 = f_9489 + (var2 ? f_9490 : 0.0F);
      float var12 = this.f_9456 * var11 * (1.0F - var9);
      float var13 = f_9491 * (1.0F - var8) + f_9492 * (1.0F - var10);
      float var14 = var8 * (f_9493 + f_9494 * var10);
      return new ThemeEditor.iOgAfy2mLF6S7jpm(var14, var12, var13);
   }

   private void renderContent(DrawContext var1, int var2, int var3, float var4) {
      this.l.m_3631(this.f_9441 ? 0.0 : 1.0);
      float var5 = (float)this.l.m_2276();
      Util158.m_1849(
         this.client.getWindow().getScaledWidth() / 2.0F - this.width / 2.0F,
         this.client.getWindow().getScaledHeight() / 2.0F - this.height / 2.0F,
         this.width,
         this.height,
         0.0F,
         Util71.m_756(15, 15, 15, (int)(var5 * f_9755))
      );
      this.f_9436.m_3631(1.0);
      this.f_9453.m_3631(1.0);
      float var6 = this.clamp01(this.f_9436.m_2276());
      float var7 = this.clamp01(this.f_9453.m_2276());
      int var8 = f_9756;
      int var9 = f_9757;
      if (this.f_9441 && var5 <= f_9758) {
         this.f_9441 = false;
         super.close();
      } else {
         this.f_9422 = this.client.getWindow().getScaledWidth() / 2.0F - f_9759;
         this.f_9423 = this.client.getWindow().getScaledHeight() / 2.0F - f_9760;
         int var10 = EnergyClient.getTheme(0);
         int var11 = (int)(f_9761 * var5);
         float var12 = var5;
         this.f_9443 = Util39.m_3959(this.f_9443, this.f_9442, f_9762);
         Util158.m_3998(this.f_9422, this.f_9423, f_9763, f_9764, f_9765, Util71.m_3389(f_9766, (int)(f_9767 * var5)), var5);
         Util158.m_1919(this.f_9422, this.f_9423, f_9768, f_9769, new Vector4f(f_9770, f_9771, 0.0F, 0.0F), Util71.m_3389(f_9772, (int)(f_9773 * var5)));
         Util93.f_6000[25].m_2915(var1, f_9774, this.f_9422 + f_9775, this.f_9423 + f_9776, Util71.m_3389(var10, var11));
         Util158.m_1849(this.f_9422, this.f_9423 + f_9777, f_9778, 1.0F, 0.0F, Util71.m_3389(f_9779, var11));
         this.renderSearchField(var1, var10, var5);
         Util158.m_335(
            this.f_9422 + f_9780 - 1.0F, this.f_9423 - 1.0F + f_9781 + f_9782 - f_9783 - f_9784, f_9785, f_9786, f_9787, Util71.m_3389(f_9788, var11)
         );
         Util158.m_335(this.f_9422 + f_9789, this.f_9423 + f_9790 + f_9791 - f_9792 - f_9793, f_9794, f_9795, f_9796, Util71.m_3389(f_9797, var11));
         Util158.m_4005(Identifier.of(f_9798, f_9799), null, this.f_9422 + f_9800, this.f_9423 + f_9801 + f_9802 - f_9803 - 1.0F, f_9804, f_9805, f_9806, var5);
         Util93.f_6001[14].m_2915(var1, Util90.f_5919, this.f_9422 + f_9807, this.f_9423 + f_9808 + f_9809 - f_9810 + f_9811, Util71.m_3389(-1, var11));
         Util93.f_6001[14]
            .m_2915(var1, "uid: " + Util90.f_5920, this.f_9422 + f_9812, this.f_9423 + f_9813 + f_9814 - f_9815 + f_9816 + f_9817, Util71.m_3389(-1, var11));
         Util93.f_6002[13].m_2915(var1, f_9818, this.f_9422 + f_9819, this.f_9423 + f_9820, Util71.m_3389(f_9821, var11));
         float var13 = this.f_9425.ordinal() * 25;
         this.f_9437.m_3631(var13);
         float var14 = this.f_9422 + f_9822;
         float var15 = (float)this.f_9437.m_2276();
         Util158.m_1849(var14 - f_9823, this.f_9423 + var15 + f_9824 - f_9825, f_9826, f_9827, f_9828, Util71.m_3389(f_9829, var11));
         Util158.m_1849(var14 - f_9830 + 1.0F, this.f_9423 + var15 + f_9831 - f_9832 + 1.0F, f_9833, f_9834, f_9835, Util71.m_3389(f_9836, var11));
         float var16 = 0.0F;

         for (Category var20 : Category.values()) {
            float var21 = this.f_9423 + var16 + f_9837;
            float var22 = this.clamp01(1.0F - Math.abs(var15 - var16) / f_9838);
            Util165 var23 = this.getCategoryHoverAnimation(var20);
            boolean var24 = Util39.m_2594(var2, var3, var14 - f_9839, var21 - f_9840, f_9841, f_9842);
            var23.m_3631(var24 && var20 != this.f_9425 ? 1.0 : 0.0);
            float var25 = this.clamp01(var23.m_2276());
            float var26 = this.clamp01(Math.max(var22, var25 * f_9843));
            int var27 = Util71.m_2924(f_9844, -1, var26);
            int var28 = Util71.m_2924(f_9845, var10, var26 * f_9846);
            float var29 = var26 * f_9847;
            Util93.f_6000[14].m_2915(var1, var20.m_3343(), var14 + var29, var21 + f_9848, Util71.m_3389(var28, var11));
            Util93.f_6003[14].m_2915(var1, var20.m_2294(), var14 + f_9849 + var29, var21, Util71.m_3389(var27, var11));
            var16 += f_9850;
         }

         if (this.f_9425 == Category.COSMETICS) {
            float var58 = Math.max(f_9851, Math.min(f_9852, this.client.getWindow().getScaledWidth() - this.f_9422 - f_9853));
            float var61 = Math.max(f_9854, Math.min(f_9855, this.client.getWindow().getScaledHeight() - this.f_9423 - f_9856));
            this.f_9440.m_2582(var1, var2, var3, this.f_9422 + f_9857, this.f_9423 + f_9858, var58, var61, var5 * var6, var10, this.f_9449);
         } else {
            Util28 var59 = this.buildFrameCache();
            List var62 = var59.m_353();
            float var63 = var59.m_1038(true);
            float var64 = f_9859;
            RenderUtil2.m_3624(this.f_9422 + f_9860, this.f_9423 + f_9861, f_9862, f_9863);

            for (int var65 = 0; var65 < var62.size(); var65++) {
               Util28.nlM2fh0AzQtK9c6l var68 = (Util28.nlM2fh0AzQtK9c6l)var62.get(var65);
               Module var71 = var68.m_636();
               boolean var74 = var68.m_2785();
               ObjectArrayList var76 = var68.m_1278();
               this.advanceModuleAnimations(var71, var76);
               ThemeEditor.iOgAfy2mLF6S7jpm var78 = this.getModuleEntryTransform(var65, var74, var6, var7);
               float var80 = this.f_9422 + f_9864 + (var74 ? 155 : 0) + var78.xOffset();
               float var82 = this.f_9423 + var68.m_1660() + f_9865 + this.f_9443 + var78.yOffset();
               float var84 = var68.m_2243();
               if (this.isModuleVisible(var82, var84)) {
                  int var30 = (int)(var11 * var78.alpha());
                  float var31 = var12 * var78.alpha();
                  Util158.m_335(var80 - 1.0F, var82 - 1.0F, f_9866, var84 + 2.0F, f_9867, Util71.m_3389(f_9868, (int)(f_9869 * var5 * var78.alpha())));
                  Util158.m_335(var80, var82, f_9870, var84, f_9871, Util71.m_3389(f_9872, (int)(f_9873 * var5 * var78.alpha())));
                  Util93.f_6002[15].m_2915(var1, var71.m_1199(), var80 + f_9874, var82 - f_9875, Util71.m_3389(f_9876, var30));
                  Util93.f_6001[16].m_2915(var1, f_9877, var80 + f_9878, var82 + f_9879, Util71.m_3389(-1, var30));
                  int var32 = Util71.m_2924(f_9880, var10, (float)var71.m_236().m_2276());
                  int var33 = Util71.m_2924(f_9881, -1, (float)var71.m_236().m_2276());
                  Util158.m_1849(var80 + f_9882, var82 + f_9883, f_9884, f_9885, f_9886, Util71.m_3389(var32, var30));
                  Util158.m_1115((float)(var80 + f_9887 + var71.m_236().m_2276() * f_9888), var82 + f_9889, f_9890, Util71.m_3389(var33, var30));
                  float var34 = 0.0F;
                  ObjectListIterator var35 = var76.iterator();

                  while (var35.hasNext()) {
                     Object var36 = (Setting)var35.next();
                     if (((Setting)var36).m_1326()) {
                        float var37 = var80 + f_9891;
                        float var38 = var82 + f_9892 + var34;
                        switch (var36) {
                           case BooleanSetting var41:
                              Util158.m_1849(var37, var38 - f_9893, f_9894, f_9895, 0.0F, Util71.m_3389(f_9896, var30));
                              Util93.f_6001[16].m_1904(var1, var41.m_1488(), var37, var38 + 1.0F, Util71.m_3389(-1, var30), f_9897);
                              int var103 = Util71.m_2924(f_9898, var10, (float)var41.l().m_2276());
                              int var108 = Util71.m_2924(f_9899, -1, (float)var41.l().m_2276());
                              Util158.m_1849(var37 + f_9900 - f_9901, var38 + f_9902 - f_9903, f_9904, f_9905, f_9906, Util71.m_3389(var103, var30));
                              Util158.m_1115(
                                 (float)(var37 + f_9907 - f_9908 + var41.l().m_2276() * f_9909), var38 + f_9910, f_9911, Util71.m_3389(var108, var30)
                              );
                              var34 += f_9912;
                              break;
                           case RenderUtil22 var134:
                              RenderUtil22 var42 = (RenderUtil22)var36;
                              Util158.m_1849(var37, var38 - f_9913, f_9914, f_9915, 0.0F, Util71.m_3389(f_9916, var30));
                              Util93.f_6001[16].m_2915(var1, var42.m_1488(), var37, var38 + 1.0F, Util71.m_3389(-1, var30));
                              Util165 var107 = this.getBindSetHoverAnimation(var42.m_1488());
                              boolean var112 = Util39.m_2594(
                                    var2, var3, var37 + f_9917 - f_9918, var38 + 2.0F, Util93.f_5999[17].m_585(f_9919), Util93.f_5999[17].m_619()
                                 )
                                 && this.f_9427 == null
                                 && this.f_9426 == null;
                              var107.m_3631(var112 ? 1.0 : 0.0);
                              int var116 = Util71.m_2924(f_9920, -1, (float)var107.m_2276());
                              Util93.f_5999[17].m_2915(var1, f_9921, var37 + f_9922 - f_9923, var38 + 2.0F, Util71.m_3389(var116, var30));
                              var34 += f_9924;
                              break;
                           case NumberSetting var43:
                              float var111 = this.getNumberSliderStartX(var37);
                              float var115 = this.getNumberSliderValueRightX(var37);
                              String var119 = this.formatNumberValue(var43);
                              float var123 = Util93.f_6003[14].m_585(var119);
                              float var126 = this.getNumberValueBoxWidth(var37, var123);
                              float var49 = var115 - var126;
                              float var50 = this.getNumberSliderWidth(var37, var126);
                              if (var43.m_2619()) {
                                 var43.m_3690(this.getSliderDeltaValue(var43, var111, var2, var50));
                              }

                              float var51 = Math.max(1.0F, var126 - f_9925);
                              String var52 = this.fitNumberValueText(var43, var51);
                              float var53 = Util93.f_6003[14].m_585(var52);
                              float var54 = f_9926;
                              float var55 = Util93.f_6001[16].m_585(var43.m_1488());
                              boolean var56 = Util39.m_2594(var2, var3, var37, var38 + 1.0F, f_9927, Util93.f_6001[16].m_619());
                              var43.m_544(var56 && var55 > f_9928);
                              Util158.m_1849(var37, var38 - f_9929, f_9930, f_9931, 0.0F, Util71.m_3389(f_9932, var30));
                              Util93.f_6001[16]
                                 .m_1710(var1, var43.m_1488(), var37, var38 + 1.0F, f_9933, Util71.m_3389(-1, var30), var43.m_1345(), var43.m_575());
                              Util158.m_1849(var49, var38 - f_9934, var126, Util93.f_6003[14].m_619() + f_9935, f_9936, Util71.m_3389(f_9937, var30));
                              Util158.m_1849(
                                 var49 + f_9938,
                                 var38 - f_9939 + f_9940,
                                 var126 - 1.0F,
                                 Util93.f_6003[14].m_619() + f_9941 - 1.0F,
                                 f_9942,
                                 Util71.m_3389(f_9943, var30)
                              );
                              Util158.m_1849(var111, var38 + 1.0F, var50, f_9944, 1.0F, Util71.m_3389(f_9945, var30));
                              float var57 = Util39.m_2529((float)var43.m_1997().m_2276(), 0.0F, 1.0F);
                              Util158.m_1849(var111, var38 + 1.0F, var50 * var57, f_9946, 1.0F, Util71.m_3389(var10, var30));
                              Util158.m_1115(var111 + var57 * var50, var38 + f_9947, f_9948, Util71.m_3389(-1, var30));
                              Util93.f_6003[14].m_2915(var1, var52, var115 - var53 - f_9949, var38 + f_9950, Util71.m_3389(-1, var30));
                              var34 += f_9951;
                              break;
                           case ModeSetting var44:
                              Util158.m_1849(var37, var38 - f_9952, f_9953, f_9954, 0.0F, Util71.m_3389(f_9955, var30));
                              Util93.f_6001[16].m_1904(var1, var44.m_1488(), var37, var38 + 1.0F, Util71.m_3389(-1, var30), f_9956);
                              Util158.m_3998(
                                 var37 + f_9957, var38 - f_9958, f_9959, f_9960, f_9961, Util71.m_3389(f_9962, (int)(f_9963 * var5 * var78.alpha())), var31
                              );
                              Util158.m_3998(
                                 var37 + f_9964 + f_9965,
                                 var38 - f_9966 + f_9967,
                                 f_9968,
                                 f_9969,
                                 f_9970,
                                 Util71.m_3389(f_9971, (int)(f_9972 * var5 * var78.alpha())),
                                 var31
                              );
                              Util93.f_6003[14].m_1904(var1, var44.m_3862(), var37 + f_9973, var38 + 1.0F, Util71.m_3389(-1, var30), f_9974);
                              Util93.f_6000[14].m_2915(var1, f_9975, var37 + f_9976, var38 + 2.0F, Util71.m_3389(f_9977, var30));
                              var34 += f_9978;
                              break;
                           case Util63 var135:
                              Util63 var45 = (Util63)var36;
                              Util158.m_1849(var37, var38 - f_9979, f_9980, f_9981, 0.0F, Util71.m_3389(f_9982, var30));
                              Util93.f_6001[16].m_2915(var1, var45.m_1488(), var37, var38 + 1.0F, Util71.m_3389(-1, var30));
                              Util158.m_3998(
                                 var37 + f_9983, var38 - f_9984, f_9985, f_9986, f_9987, Util71.m_3389(f_9988, (int)(f_9989 * var5 * var78.alpha())), var31
                              );
                              Util158.m_3998(
                                 var37 + f_9990 + f_9991,
                                 var38 - f_9992 + f_9993,
                                 f_9994,
                                 f_9995,
                                 f_9996,
                                 Util71.m_3389(f_9997, (int)(f_9998 * var5 * var78.alpha())),
                                 var31
                              );
                              StringBuilder var46 = new StringBuilder();
                              ObjectListIterator var47 = var45.m_841().iterator();

                              while (var47.hasNext()) {
                                 BooleanSetting var48 = (BooleanSetting)var47.next();
                                 if (var48.m_1163()) {
                                    if (!var46.isEmpty()) {
                                       var46.append(f_9999);
                                    }

                                    var46.append(var48.m_1488());
                                 }
                              }

                              String var122 = !var46.isEmpty() ? var46.toString() : f_10000;
                              Util93.f_6003[14].m_1904(var1, var122, var37 + f_10001, var38 + 1.0F, Util71.m_3389(-1, var30), f_10002);
                              Util93.f_6000[14].m_2915(var1, f_10003, var37 + f_10004, var38 + 2.0F, Util71.m_3389(f_10005, var30));
                              var34 += f_10006;
                              continue;
                           default:
                        }
                     }
                  }
               }
            }

            RenderUtil2.m_1647();
            if (var62.isEmpty() && !this.f_9449.isEmpty()) {
               String var66 = f_10007;
               float var69 = Util93.f_6001[16].m_585(var66);
               float var72 = var6 * (f_10008 + f_10009 * var7);
               Util93.f_6001[16]
                  .m_2915(
                     var1,
                     var66,
                     this.f_9422 + f_10010 - var69 / 2.0F + f_10011,
                     this.f_9423 + f_10012 + (1.0F - var72) * f_10013,
                     Util71.m_3389(f_10014, (int)(var11 * var72))
                  );
            }

            RenderUtil2.m_3624(this.f_9422 + f_10015, this.f_9423 + f_10016, f_10017, f_10018);

            for (int var67 = 0; var67 < var62.size(); var67++) {
               Util28.nlM2fh0AzQtK9c6l var70 = (Util28.nlM2fh0AzQtK9c6l)var62.get(var67);
               boolean var73 = var70.m_2785();
               ThemeEditor.iOgAfy2mLF6S7jpm var75 = this.getModuleEntryTransform(var67, var73, var6, var7);
               float var77 = this.f_9422 + f_10019 + (var73 ? 155 : 0) + var75.xOffset();
               float var79 = this.f_9423 + var70.m_1660() + f_10020 + this.f_9443 + var75.yOffset();
               if (this.isModuleVisible(var79, var70.m_3993())) {
                  ObjectArrayList var81 = var70.m_1278();
                  int var83 = (int)(var11 * var75.alpha());
                  float var85 = var12 * var75.alpha();
                  float var86 = 0.0F;
                  ObjectListIterator var87 = var81.iterator();

                  while (var87.hasNext()) {
                     Setting var88 = (Setting)var87.next();
                     if (var88.m_1326()) {
                        float var89 = var77 + f_10021;
                        float var90 = var79 + f_10022 + var86;
                        if (var88 instanceof ModeSetting var91) {
                           float var94 = (float)var91.m_3744().m_2276();
                           if (var94 > 0.0F) {
                              float var96 = 13 + var91.m_3551().size() * 10;
                              float var97 = f_10023 + (var96 - f_10024) * var94;
                              Util158.m_3998(
                                 var89 + f_10025,
                                 var90 - f_10026,
                                 f_10027,
                                 var97,
                                 f_10028,
                                 Util71.m_3389(f_10029, (int)(f_10030 * var5 * var75.alpha())),
                                 var85
                              );
                              Util158.m_3998(
                                 var89 + f_10031 + f_10032,
                                 var90 - f_10033 + f_10034,
                                 f_10035,
                                 var97 - 1.0F,
                                 f_10036,
                                 Util71.m_3389(f_10037, (int)(f_10038 * var5 * var75.alpha())),
                                 var85
                              );
                              Util93.f_6003[14].m_1904(var1, var91.m_3862(), var89 + f_10039, var90 + 1.0F, Util71.m_3389(-1, var83), f_10040);
                              Util93.f_6000[14].m_2915(var1, f_10041, var89 + f_10042, var90 + 2.0F, Util71.m_3389(f_10043, var83));
                              if (var94 > f_10044) {
                                 RenderUtil2.m_3624(var89 + f_10045, var90 + f_10046, f_10047, var97 - f_10048 + f_10049);
                                 float var99 = Math.min(1.0F, (var94 - f_10050) / f_10051) * var5 * var75.alpha();
                                 float var102 = 0.0F;

                                 for (ObjectListIterator var106 = var91.m_3551().iterator(); var106.hasNext(); var102 += f_10064) {
                                    String var110 = (String)var106.next();
                                    boolean var114 = var91.m_3862().equals(var110);
                                    Util165 var118 = this.getModeAnimation(var91.m_1488(), var110);
                                    var118.m_3631(var114 ? 1.0 : 0.0);
                                    float var121 = (float)var118.m_2276();
                                    float var125 = var121 * f_10052;
                                    int var128 = Util71.m_2924(f_10053, f_10054, var121);
                                    var128 = Util71.m_3389(var128, (int)(f_10055 * var99));
                                    Util93.f_6003[14].m_1904(var1, var110, var89 + f_10056 + var125, var90 + f_10057 + var102, var128, f_10058);
                                    if (var121 > f_10059) {
                                       int var132 = (int)(f_10060 * var99 * var121);
                                       Util93.f_6000[14].m_2915(var1, f_10061, var89 + f_10062, var90 + f_10063 + var102, Util71.m_3389(var10, var132));
                                    }
                                 }

                                 RenderUtil2.m_1647();
                              }
                           }

                           var86 += f_10065;
                        } else if (!(var88 instanceof Util63 var92)) {
                           if (var88 instanceof BooleanSetting || var88 instanceof NumberSetting) {
                              var86 += f_10111;
                           }
                        } else {
                           float var93 = (float)var92.m_3994().m_2276();
                           if (var93 > 0.0F) {
                              float var95 = 13 + var92.m_841().size() * 10;
                              float var39 = f_10066 + (var95 - f_10067) * var93;
                              Util158.m_3998(
                                 var89 + f_10068,
                                 var90 - f_10069,
                                 f_10070,
                                 var39,
                                 f_10071,
                                 Util71.m_3389(f_10072, (int)(f_10073 * var5 * var75.alpha())),
                                 var85
                              );
                              Util158.m_3998(
                                 var89 + f_10074 + f_10075,
                                 var90 - f_10076 + f_10077,
                                 f_10078,
                                 var39 - 1.0F,
                                 f_10079,
                                 Util71.m_3389(f_10080, (int)(f_10081 * var5 * var75.alpha())),
                                 var85
                              );
                              StringBuilder var98 = new StringBuilder();
                              ObjectListIterator var100 = var92.m_841().iterator();

                              while (var100.hasNext()) {
                                 BooleanSetting var104 = (BooleanSetting)var100.next();
                                 if (var104.m_1163()) {
                                    if (!var98.isEmpty()) {
                                       var98.append(f_10082);
                                    }

                                    var98.append(var104.m_1488());
                                 }
                              }

                              String var101 = !var98.isEmpty() ? var98.toString() : f_10083;
                              Util93.f_6003[14].m_1904(var1, var101, var89 + f_10084, var90 + 1.0F, Util71.m_3389(-1, var83), f_10085);
                              Util93.f_6000[14].m_2915(var1, f_10086, var89 + f_10087, var90 + 2.0F, Util71.m_3389(f_10088, var83));
                              if (var93 > f_10089) {
                                 RenderUtil2.m_3624(var89 + f_10090, var90 + f_10091, f_10092, var39 - f_10093 + f_10094);
                                 float var105 = Math.min(1.0F, (var93 - f_10095) / f_10096) * var5 * var75.alpha();
                                 float var109 = 0.0F;

                                 for (ObjectListIterator var113 = var92.m_841().iterator(); var113.hasNext(); var109 += f_10109) {
                                    BooleanSetting var117 = (BooleanSetting)var113.next();
                                    Util165 var120 = this.getMultiBoolAnimation(var92.m_1488(), var117.m_1488());
                                    var120.m_3631(var117.m_1163() ? 1.0 : 0.0);
                                    float var124 = (float)var120.m_2276();
                                    float var127 = var124 * f_10097;
                                    int var130 = Util71.m_2924(f_10098, f_10099, var124);
                                    var130 = Util71.m_3389(var130, (int)(f_10100 * var105));
                                    Util93.f_6003[14].m_1904(var1, var117.m_1488(), var89 + f_10101 + var127, var90 + f_10102 + var109, var130, f_10103);
                                    if (var124 > f_10104) {
                                       int var133 = (int)(f_10105 * var105 * var124);
                                       Util93.f_6000[14].m_2915(var1, f_10106, var89 + f_10107, var90 + f_10108 + var109, Util71.m_3389(var10, var133));
                                    }
                                 }

                                 RenderUtil2.m_1647();
                              }
                           }

                           var86 += f_10110;
                        }
                     }
                  }
               }
            }

            RenderUtil2.m_1647();
            if (var63 > f_10112) {
               this.renderModuleViewportShadow(var5 * var6 * (f_10113 + f_10114 * var7));
            }
         }

         this.f_9438.m_3631(!this.f_9441 && this.f_9461 ? 1.0 : 0.0);
         this.renderThemeEditor(var1, var5);
         this.renderConfigImportPanel(var1, var2, var3, var5);
         if (this.f_9426 != null) {
            this.f_9431 = this.f_9426;
            this.f_9432 = null;
         } else if (this.f_9427 != null) {
            this.f_9432 = this.f_9427;
            this.f_9431 = null;
         }

         this.f_9434.m_3631(this.f_9433 ? 1.0 : 0.0);
         boolean var60 = this.f_9434.m_2276() > f_10115;
         if (var60 && (this.f_9431 != null || this.f_9432 != null)) {
            this.renderBindWindow(var1, var2, var3, var10);
         }

         this.clearBindWindowRenderCacheIfFinished();
      }
   }

   private float getThemeHueY() {
      return this.getThemeSVY();
   }

   public float getSliderDeltaValue(NumberSetting var1, float var2, int var3, float var4) {
      float var5 = var1.m_2596() - var1.m_925();
      float var6 = Math.max(0.0F, Math.min(var3 - var2, var4));
      float var7 = var6 / var4;
      float var8 = var1.m_925() + var5 * var7;
      float var9 = Util39.m_2261(var8, var1.m_2099());
      return Math.max(var1.m_925(), Math.min(var9, var1.m_2596()));
   }

   private float getThemeCloseY() {
      return this.getThemePickerY() - f_9595;
   }

   private void updateCustomPickerFromMouse(ThemeEditor.xCBuOCHHe6IcZJcG var1, double var2, double var4) {
      switch (var1) {
         case SATURATION_VALUE:
            this.f_9463 = Util39.m_2529((float)((var2 - this.getThemeSVX()) / this.getThemeSVWidth()), 0.0F, 1.0F);
            this.f_9464 = 1.0F - Util39.m_2529((float)((var4 - this.getThemeSVY()) / this.getThemeSVHeight()), 0.0F, 1.0F);
            this.updateCustomThemeColor();
            break;
         case HUE:
            this.f_9462 = Util39.m_2529((float)((var4 - this.getThemeHueY()) / this.getThemeHueHeight()), 0.0F, 1.0F);
            this.updateCustomThemeColor();
            break;
         case OPACITY:
            this.f_9465 = 1.0F - Util39.m_2529((float)((var4 - this.getThemeAlphaY()) / this.getThemeAlphaHeight()), 0.0F, 1.0F);
            this.updateCustomThemeColor();
      }
   }

   private void renderConfigImportPanel(DrawContext var1, int var2, int var3, float var4) {
      this.f_9439
         .m_211(
            var1,
            var2,
            var3,
            var4,
            this.getConfigImportWindowX(),
            this.getConfigImportWindowY(),
            this.getConfigImportWindowWidth(),
            this.getConfigImportVisibility(),
            EnergyClient.getThemeColor()
         );
   }

   private float getThemeWindowHeight() {
      float var1 = Util39.m_2529((float)this.f_9438.m_2276(), 0.0F, 1.0F);
      return f_9586 + f_9587 * var1;
   }

   private Util165 getCategoryHoverAnimation(Category var1) {
      return this.f_9448.computeIfAbsent(var1, var0 -> new Util165(Util153.EASE_OUT_CUBIC, f_10293));
   }

   public void renderBackground(DrawContext var1, int var2, int var3, float var4) {
   }

   private void renderBindWindow(DrawContext var1, int var2, int var3, int var4) {
      Module var5 = this.f_9426 != null ? this.f_9426 : this.f_9431;
      RenderUtil22 var6 = this.f_9427 != null ? this.f_9427 : this.f_9432;
      if (var5 != null || var6 != null) {
         float var7 = (float)this.f_9434.m_2276();
         float var8 = f_10116;
         float var9 = f_10117;
         boolean var10 = var5 != null;
         int var11 = var10 ? var5.m_689() : var6.m_1958();
         this.f_9435.m_3631(var10 ? (var5.m_696() == ToggleMode.HOLD ? 1 : 0) : (var6.m_766() == RenderUtil22.pqYfuJa0oJD2nAQv.HOLD ? 1 : 0));
         float var14 = this.f_9429;
         float var15 = this.f_9430;
         int var16 = (int)(f_10118 * var7);
         float var17 = Util39.m_2529(var7, 0.0F, 1.0F);
         Util158.m_3998(var14 - 1.0F, var15 - 1.0F, var8 + 2.0F, var9 + 2.0F, f_10119, Util71.m_3389(f_10120, (int)(f_10121 * var17)), var17);
         Util158.m_3998(var14, var15, var8, var9, f_10122, Util71.m_3389(f_10123, (int)(f_10124 * var17)), var17);
         float var18 = var15 + f_10125;
         Util93.f_6001[14].m_2915(var1, f_10126, var14 + f_10127, var18, Util71.m_3389(-1, var16));
         String var19 = !this.f_9428 || this.f_9426 == null && this.f_9427 == null ? (var11 == -1 ? f_10129 : Util40.m_2030(var11)) : f_10128;
         if (var19 == null) {
            var19 = "Key " + var11;
         }

         float var20 = Util93.f_6003[14].m_585(var19);
         Util93.f_6003[14].m_2915(var1, var19, var14 + var8 - var20 - f_10130, var18, Util71.m_3389(f_10131, var16));
         Util158.m_1849(var14 + f_10132, var18 + f_10133, var8 - f_10134, f_10135, 0.0F, Util71.m_3389(f_10136, var16));
         float var21 = var18 + f_10137;
         Util93.f_6001[14].m_2915(var1, f_10138, var14 + f_10139, var21, Util71.m_3389(-1, var16));
         String var22 = f_10140;
         String var23 = f_10141;
         float var24 = Util93.f_6003[14].m_585(var22);
         float var25 = Util93.f_6003[14].m_585(var23);
         float var26 = f_10142;
         float var27 = var24 + var25 + var26;
         float var28 = var14 + var8 - var27 - f_10143;
         float var30 = var28 + var24 + var26;
         int var31 = Util71.m_2924(f_10144, f_10145, (float)this.f_9435.m_2276());
         int var32 = Util71.m_2924(f_10146, f_10147, (float)this.f_9435.m_2276());
         Util93.f_6003[14].m_2915(var1, var22, var28, var21, Util71.m_3389(var31, var16));
         Util93.f_6003[14].m_2915(var1, var23, var30, var21, Util71.m_3389(var32, var16));
         Util158.m_1849(var14 + f_10148, var21 + f_10149, var8 - f_10150, f_10151, 0.0F, Util71.m_3389(f_10152, var16));
         float var33 = var21 + f_10153;
         Util93.f_6000[14].m_2915(var1, f_10154, var14 + f_10155, var33 + 1.0F, Util71.m_3389(f_10156, var16));
         Util93.f_6001[14].m_2915(var1, f_10157, var14 + f_10158, var33 + f_10159, Util71.m_3389(f_10160, var16));
      }
   }

   private void renderModuleViewportShadow(float var1) {
      float var2 = Util39.m_2529(var1, 0.0F, 1.0F);
      if (!(var2 <= f_9500)) {
         float var3 = this.f_9422 + f_9501;
         float var4 = this.f_9423 + f_9502;
         float var5 = f_9503;
         float var6 = f_9504;
         byte var7 = 14;
         RenderUtil2.m_3624(var3, var4, var5, var6);

         try {
            for (int var8 = 0; var8 < var7; var8++) {
               float var9 = var7 <= 1 ? 1.0F : (float)var8 / (var7 - 1);
               float var10 = 1.0F - var9;
               var10 *= var10;
               int var11 = (int)(f_9505 * var2 * var10);
               if (var11 > 0) {
                  int var12 = Util71.m_3389(f_9506, var11);
                  Util158.m_1849(var3, var4 + var8, var5, 1.0F, 0.0F, var12);
                  Util158.m_1849(var3, var4 + var6 - 1.0F - var8, var5, 1.0F, 0.0F, var12);
               }
            }
         } finally {
            RenderUtil2.m_1647();
         }
      }
   }

   private void onSearchQueryMutated(boolean var1) {
      this.f_9440.m_580();
      this.f_9454 = var1;
      this.f_9455 = System.currentTimeMillis();
      this.resetModuleScroll();
      this.closeAllDropdowns();
      this.closeBindWindow();
      this.deactivateNumberSettings();
      this.restartAnimation(this.f_9452, 0.0, 1.0);
      this.restartAnimation(this.f_9453, 0.0, 1.0);
   }

   public boolean mouseScrolled(double var1, double var3, double var5, double var7) {
      if (this.f_9425 != Category.COSMETICS) {
         if (Util39.m_121(var1, var3, this.f_9422 + f_10287, this.f_9423 + f_10288, f_10289, f_10290)) {
            float var9 = this.buildFrameCache().m_1038(true);
            float var10 = f_10291;
            if (var9 > var10) {
               float var11 = f_10292;
               this.f_9442 += (float)var7 * var11;
               float var12 = 0.0F;
               float var13 = -(var9 - var10);
               this.f_9442 = Math.max(var13, Math.min(var12, this.f_9442));
               return true;
            }
         }

         return super.mouseScrolled(var1, var3, var5, var7);
      } else {
         return this.f_9440.m_1185(var1, var3, var7) || super.mouseScrolled(var1, var3, var5, var7);
      }
   }

   private boolean areModulesInteractive() {
      return this.f_9436.m_2276() >= f_9483 && this.f_9453.m_2276() >= f_9484;
   }

   public boolean mouseClicked(Click var1, boolean var2) {
      double var3 = var1.x();
      double var5 = var1.y();
      int var7 = var1.button();
      float var8 = this.getSearchFieldX();
      float var9 = this.getSearchFieldY();
      if (var7 == 0 && Util39.m_121(var3, var5, var8, var9, f_10185, f_10186)) {
         if (!this.f_9450) {
            this.f_9450 = true;
            this.f_9454 = false;
            this.restartAnimation(this.f_9452, 0.0, 1.0);
         }

         this.f_9455 = System.currentTimeMillis();
         return true;
      } else {
         if (this.f_9450 && !Util39.m_121(var3, var5, var8, var9, f_10187, f_10188)) {
            this.f_9450 = false;
         }

         if (this.handleThemeEditorClick(var3, var5, var7)) {
            return true;
         } else if (this.handleConfigImportClick(var3, var5, var7)) {
            return true;
         } else if (this.f_9426 != null && this.f_9434.m_2276() > f_10189) {
            float var43 = f_10190;
            float var46 = f_10191;
            float var49 = this.f_9430 + f_10192;
            if (Util39.m_121(var3, var5, this.f_9429 + f_10193, var49, var43 - f_10194, Util93.f_6001[14].m_619())) {
               if (this.f_9428) {
                  this.f_9426.m_1957(Util40.m_3418(var7));
                  this.f_9428 = false;
               } else {
                  this.f_9428 = true;
               }

               return true;
            } else {
               float var52 = var49 + f_10195;
               String var56 = f_10196;
               String var60 = f_10197;
               float var64 = Util93.f_6003[14].m_585(var56);
               float var68 = Util93.f_6003[14].m_585(var60);
               float var71 = f_10198;
               float var74 = var64 + var68 + var71;
               float var77 = this.f_9429 + var43 - var74 - f_10199;
               float var81 = var77 + var64 + var71;
               if (Util39.m_121(var3, var5, var77, var52, var64, Util93.f_6003[14].m_619())) {
                  this.f_9426.m_159(ToggleMode.TOGGLE);
                  return true;
               } else if (Util39.m_121(var3, var5, var81, var52, var68, Util93.f_6003[14].m_619())) {
                  this.f_9426.m_159(ToggleMode.HOLD);
                  return true;
               } else {
                  float var84 = var52 + f_10200;
                  if (Util39.m_121(var3, var5, this.f_9429 + f_10201, var84, f_10202, Util93.f_6001[14].m_619())) {
                     this.f_9426.m_1957(-1);
                     this.closeBindWindow();
                     return true;
                  } else if (!Util39.m_121(var3, var5, this.f_9429, this.f_9430, var43, var46)) {
                     this.closeBindWindow();
                     return true;
                  } else {
                     return true;
                  }
               }
            }
         } else if (this.f_9427 != null && this.f_9434.m_2276() > f_10203) {
            float var42 = f_10204;
            float var45 = f_10205;
            float var48 = this.f_9430 + f_10206;
            if (Util39.m_121(var3, var5, this.f_9429 + f_10207, var48, var42 - f_10208, Util93.f_6001[14].m_619())) {
               if (this.f_9428) {
                  this.f_9427.m_466(Util40.m_3418(var7));
                  this.f_9428 = false;
               } else {
                  this.f_9428 = true;
               }

               return true;
            } else {
               float var51 = var48 + f_10209;
               String var55 = f_10210;
               String var59 = f_10211;
               float var63 = Util93.f_6003[14].m_585(var55);
               float var67 = Util93.f_6003[14].m_585(var59);
               float var70 = f_10212;
               float var73 = var63 + var67 + var70;
               float var76 = this.f_9429 + var42 - var73 - f_10213;
               float var80 = var76 + var63 + var70;
               if (Util39.m_121(var3, var5, var76, var51, var63, Util93.f_6003[14].m_619())) {
                  this.f_9427.m_3210(RenderUtil22.pqYfuJa0oJD2nAQv.TOGGLE);
                  return true;
               } else if (Util39.m_121(var3, var5, var80, var51, var67, Util93.f_6003[14].m_619())) {
                  this.f_9427.m_3210(RenderUtil22.pqYfuJa0oJD2nAQv.HOLD);
                  return true;
               } else {
                  float var83 = var51 + f_10214;
                  if (Util39.m_121(var3, var5, this.f_9429 + f_10215, var83, f_10216, Util93.f_6001[14].m_619())) {
                     this.f_9427.m_466(-1);
                     this.closeBindWindow();
                     return true;
                  } else if (!Util39.m_121(var3, var5, this.f_9429, this.f_9430, var42, var45)) {
                     this.closeBindWindow();
                     return true;
                  } else {
                     return true;
                  }
               }
            }
         } else {
            float var10 = 0.0F;

            for (Category var14 : Category.values()) {
               float var15 = this.f_9422 + f_10217;
               float var16 = this.f_9423 + var10 + f_10218;
               if (Util39.m_121(var3, var5, var15 - f_10219, var16 - f_10220, f_10221, f_10222)) {
                  if (this.f_9425 != var14) {
                     Category var17 = this.f_9425;
                     this.f_9425 = var14;
                     this.beginCategoryTransition(var17, var14);
                  }

                  return true;
               }

               var10 += f_10223;
            }

            if (this.f_9425 == Category.COSMETICS) {
               return this.f_9440.m_4042(var3, var5, var7, this.areModulesInteractive() && !this.f_9441) || super.mouseClicked(var1, var2);
            } else if (!this.areModulesInteractive() && Util39.m_121(var3, var5, this.f_9422 + f_10224, this.f_9423 + f_10225, f_10226, f_10227)) {
               return true;
            } else {
               Util28 var44 = this.buildFrameCache();
               List<Util28.nlM2fh0AzQtK9c6l> var47 = var44.m_353();
               boolean var50 = false;
               boolean var53 = false;
               float var57 = 0.0F;
               float var61 = 0.0F;
               if (Util39.m_121(var3, var5, this.f_9422, this.f_9423 + f_10228, f_10229, f_10230)) {
                  for (Util28.nlM2fh0AzQtK9c6l var18 : var47) {
                     Module var19 = var18.m_636();
                     float var20 = this.f_9422 + f_10231 + (var53 ? 155 : 0);
                     float var21 = this.f_9423 + (!var53 ? var57 : var61) + f_10232 + this.f_9443;
                     ObjectArrayList var22 = var18.m_1278();
                     float var23 = 0.0F;
                     ObjectListIterator var24 = var22.iterator();

                     while (var24.hasNext()) {
                        Setting var25 = (Setting)var24.next();
                        if (var25.m_1326()) {
                           float var26 = var20 + f_10233;
                           float var27 = var21 + f_10234 + var23;
                           if (var25 instanceof ModeSetting var28 && var28.m_2480()) {
                              float var29 = 13 + var28.m_3551().size() * 10;
                              if (Util39.m_121(var3, var5, var26 + f_10235, var27 - f_10236, f_10237, var29)) {
                                 var50 = true;
                                 break;
                              }
                           }

                           if (var25 instanceof Util63 var89 && var89.m_1931()) {
                              float var90 = 13 + var89.m_841().size() * 10;
                              if (Util39.m_121(var3, var5, var26 + f_10238, var27 - f_10239, f_10240, var90)) {
                                 var50 = true;
                                 break;
                              }
                           }

                           if (var25 instanceof BooleanSetting
                              || var25 instanceof NumberSetting
                              || var25 instanceof ModeSetting
                              || var25 instanceof Util63
                              || var25 instanceof RenderUtil22) {
                              var23 += f_10241;
                           }
                        }
                     }

                     if (var50) {
                        break;
                     }

                     if (var53) {
                        var61 += var18.m_2243() + f_10242;
                     } else {
                        var57 += var18.m_2243() + f_10243;
                     }

                     var53 = !var53;
                  }

                  var53 = false;
                  var57 = 0.0F;
                  var61 = 0.0F;

                  for (Util28.nlM2fh0AzQtK9c6l var69 : var47) {
                     Module var72 = var69.m_636();
                     float var75 = this.f_9422 + f_10244 + (var53 ? 155 : 0);
                     float var78 = this.f_9423 + (!var53 ? var57 : var61) + f_10245 + this.f_9443;
                     ObjectArrayList var79 = var69.m_1278();
                     if (Util39.m_121(var3, var5, var75 - 1.0F, var78 - 1.0F, f_10246, f_10247)) {
                        if (var7 == 0 && !var50) {
                           var72.m_680();
                        }

                        if (var7 == 2 && !var50) {
                           this.openBindWindowForModule(var72, var3, var5);
                        }
                     }

                     float var82 = 0.0F;
                     ObjectListIterator var85 = var79.iterator();

                     while (var85.hasNext()) {
                        Object var86 = (Setting)var85.next();
                        if (((Setting)var86).m_1326()) {
                           float var87 = var75 + f_10248;
                           float var88 = var78 + f_10249 + var82;
                           switch (var86) {
                              case BooleanSetting var30:
                                 if (var7 == 0 && Util39.m_121(var3, var5, var87 + f_10250 - f_10251, var88 + f_10252 - f_10253, f_10254, f_10255) && !var50) {
                                    var30.m_1848(!var30.m_1163());
                                 }

                                 var82 += f_10256;
                                 break;
                              case RenderUtil22 var31:
                                 float var92 = var87 + f_10257 - f_10258;
                                 float var94 = var88 + 2.0F;
                                 float var97 = Util93.f_5999[17].m_585(f_10259);
                                 float var100 = Util93.f_5999[17].m_619();
                                 if (var7 == 0 && Util39.m_121(var3, var5, var92, var94, var97, var100) && !var50) {
                                    this.openBindWindowForBindSet(var31, var3, var5);
                                    return true;
                                 }

                                 var82 += f_10260;
                                 break;
                              case NumberSetting var32:
                                 float var93 = this.getNumberSliderStartX(var87);
                                 String var96 = this.formatNumberValue(var32);
                                 float var99 = Util93.f_6003[14].m_585(var96);
                                 float var102 = this.getNumberValueBoxWidth(var87, var99);
                                 float var104 = this.getNumberSliderWidth(var87, var102);
                                 if (var7 == 0 && Util39.m_121(var3, var5, var93, var88 + 1.0F, var104, f_10261) && !var50) {
                                    var32.m_1584(true);
                                 }

                                 var82 += f_10262;
                                 break;
                              case ModeSetting var108:
                                 ModeSetting var33 = (ModeSetting)var86;
                                 float var95 = f_10263;
                                 float var98 = 13 + var33.m_3551().size() * 10;
                                 boolean var101 = Util39.m_121(var3, var5, var87 + f_10264, var88 - f_10265, f_10266, var95);
                                 boolean var103 = var33.m_2480() && Util39.m_121(var3, var5, var87 + f_10267, var88 - f_10268, f_10269, var98);
                                 if ((var7 == 0 || var7 == 1) && var101 && (!var50 || var103)) {
                                    if (var33.m_2480()) {
                                       var33.m_3344(false);
                                       this.f_9457 = null;
                                    } else {
                                       this.closeAllDropdowns();
                                       var33.m_3344(true);
                                       this.f_9457 = var33;
                                    }
                                 }

                                 float var105 = 0.0F;
                                 if ((var7 == 0 || var7 == 1) && var33.m_2480() && var103) {
                                    for (ObjectListIterator var106 = var33.m_3551().iterator(); var106.hasNext(); var105 += f_10272) {
                                       String var107 = (String)var106.next();
                                       if (Util39.m_121(
                                          var3, var5, var87 + f_10270, var88 + f_10271 + var105, Util93.f_6003[14].m_585(var107), Util93.f_6003[14].m_619()
                                       )) {
                                          var33.m_1159(var107);
                                       }
                                    }
                                 }

                                 var82 += f_10273;
                                 break;
                              case Util63 var109:
                                 Util63 var34 = (Util63)var86;
                                 float var35 = f_10274;
                                 float var36 = 13 + var34.m_841().size() * 10;
                                 boolean var37 = Util39.m_121(var3, var5, var87 + f_10275, var88 - f_10276, f_10277, var35);
                                 boolean var38 = var34.m_1931() && Util39.m_121(var3, var5, var87 + f_10278, var88 - f_10279, f_10280, var36);
                                 if ((var7 == 0 || var7 == 1) && var37 && (!var50 || var38)) {
                                    if (var34.m_1931()) {
                                       var34.m_2410(false);
                                       this.f_9458 = null;
                                    } else {
                                       this.closeAllDropdowns();
                                       var34.m_2410(true);
                                       this.f_9458 = var34;
                                    }
                                 }

                                 float var39 = 0.0F;
                                 if ((var7 == 0 || var7 == 1) && var34.m_1931() && var38) {
                                    for (ObjectListIterator var40 = var34.m_841().iterator(); var40.hasNext(); var39 += f_10283) {
                                       BooleanSetting var41 = (BooleanSetting)var40.next();
                                       if (Util39.m_121(
                                          var3,
                                          var5,
                                          var87 + f_10281,
                                          var88 + f_10282 + var39,
                                          Util93.f_6003[14].m_585(var41.m_1488()),
                                          Util93.f_6003[14].m_619()
                                       )) {
                                          var41.m_1848(!var41.m_1163());
                                       }
                                    }
                                 }

                                 var82 += f_10284;
                                 continue;
                              default:
                           }
                        }
                     }

                     if (var53) {
                        var61 += var69.m_2243() + f_10285;
                     } else {
                        var57 += var69.m_2243() + f_10286;
                     }

                     var53 = !var53;
                  }
               }

               return super.mouseClicked(var1, var2);
            }
         }
      }
   }

   private boolean handleThemeEditorClick(double var1, double var3, int var5) {
      boolean var6 = this.isThemeWindowHovered(var1, var3);
      float var7 = this.getThemeSVX() - 2.0F;
      float var8 = this.getThemeSVY() - f_9742;
      float var9 = this.getThemeAlphaX() + this.getThemeAlphaWidth() - var7 + 2.0F;
      float var10 = this.getThemeSVHeight() + f_9743;
      boolean var11 = this.f_9461 && Util39.m_121(var1, var3, var7, var8, var9, var10);
      if (var5 != 0) {
         return var6 || var11;
      } else {
         if (this.f_9461) {
            if (Util39.m_121(
               var1, var3, this.getThemeCloseX() - f_9744, this.getThemeCloseY() - f_9745, this.getThemeCloseSize() + f_9746, this.getThemeCloseSize() + f_9747
            )) {
               this.f_9461 = false;
               this.f_9459 = null;
               return true;
            }

            if (Util39.m_121(var1, var3, this.getThemeSVX(), this.getThemeSVY(), this.getThemeSVWidth(), this.getThemeSVHeight())) {
               this.f_9459 = ThemeEditor.xCBuOCHHe6IcZJcG.SATURATION_VALUE;
               this.updateCustomPickerFromMouse(this.f_9459, var1, var3);
               return true;
            }

            if (Util39.m_121(var1, var3, this.getThemeHueX(), this.getThemeHueY(), this.getThemeHueWidth(), this.getThemeHueHeight())) {
               this.f_9459 = ThemeEditor.xCBuOCHHe6IcZJcG.HUE;
               this.updateCustomPickerFromMouse(this.f_9459, var1, var3);
               return true;
            }

            if (Util39.m_121(var1, var3, this.getThemeAlphaX(), this.getThemeAlphaY(), this.getThemeAlphaWidth(), this.getThemeAlphaHeight())) {
               this.f_9459 = ThemeEditor.xCBuOCHHe6IcZJcG.OPACITY;
               this.updateCustomPickerFromMouse(this.f_9459, var1, var3);
               return true;
            }
         }

         if (Util39.m_121(
            var1, var3, this.getThemeCustomButtonX(), this.getThemeCustomButtonY(), this.getThemeCustomButtonWidth(), this.getThemeCustomButtonHeight()
         )) {
            if (!this.f_9460) {
               this.f_9460 = true;
               this.syncCustomPickerFromTheme();
               this.f_9461 = true;
            } else {
               this.f_9461 = !this.f_9461;
            }

            this.f_9459 = null;
            return true;
         } else {
            float var12 = this.getThemeWindowY() + f_9748;

            for (int var13 = 0; var13 < f_9421.size(); var13++) {
               ThemeEditor.sKN8QGcpT98iFDgp var14 = f_9421.get(var13);
               float var15 = this.getThemeWindowX() + f_9749 + var13 % 2 * f_9750;
               float var16 = var12 + var13 / 2 * f_9751;
               if (Util39.m_121(var1, var3, var15, var16, f_9752, f_9753)) {
                  EnergyClient.setThemeColor(var14.color());
                  this.f_9460 = false;
                  this.f_9461 = false;
                  this.f_9459 = null;
                  return true;
               }
            }

            if (!var6 && !var11) {
               this.f_9459 = null;
            }

            return var6 || var11;
         }
      }
   }

   private Util165 getBindSetHoverAnimation(String var1) {
      return this.f_9446.computeIfAbsent(var1, var0 -> new Util165(Util153.EASE_OUT_CUBIC, f_10295));
   }

   public void onFilesDropped(List<Path> var1) {
      if (var1 != null && !var1.isEmpty() && InitManager.f_2740 != null && InitManager.f_2740.f_2751 != null) {
         this.f_9461 = false;
         this.f_9459 = null;
         this.f_9439.m_3961(var1, InitManager.f_2740.f_2751);
      } else {
         super.onFilesDropped(var1);
      }
   }

   private float getConfigImportWindowWidth() {
      return f_9602;
   }

   private float getThemeCustomButtonY() {
      return this.getThemeWindowY() + f_9599;
   }

   private String fitNumberValueText(NumberSetting var1, float var2) {
      float var3 = var1.m_4046();
      int var4 = Math.min(this.getNumberDecimals(var1.m_2099()), 4);

      for (int var5 = var4; var5 >= 0; var5--) {
         String var6 = this.formatNumberWithDecimals(var3, var5);
         if (Util93.f_6003[14].m_585(var6) <= var2) {
            return var6;
         }
      }

      float var11 = Math.abs(var3);
      if (var11 >= f_10176) {
         String[] var12 = new String[]{f_10177, f_10178, f_10179, f_10180};
         float var7 = var3;

         int var8;
         for (var8 = -1; Math.abs(var7) >= f_10181 && var8 < var12.length - 1; var8++) {
            var7 /= f_10182;
         }

         if (var8 >= 0) {
            for (int var9 = 1; var9 >= 0; var9--) {
               String var10 = this.formatNumberWithDecimals(var7, var9) + var12[var8];
               if (Util93.f_6003[14].m_585(var10) <= var2) {
                  return var10;
               }
            }
         }
      }

      String var13 = String.format(Locale.US, f_10183, var3);
      return Util93.f_6003[14].m_585(var13) <= var2 ? var13 : f_10184;
   }

   private float getThemeCustomButtonWidth() {
      return f_9600;
   }

   private float getThemeWindowY() {
      return this.f_9423;
   }

   private float getThemeCloseX() {
      return this.getThemeWindowX() + this.getThemeWindowWidth() - f_9594;
   }

   private float getThemeCloseSize() {
      return f_9596;
   }

   private void updateCustomThemeColor() {
      int var1 = Util71.m_3389(Color.HSBtoRGB(this.f_9462, this.f_9463, this.f_9464), 255);
      int var2 = Util71.m_2924(Util71.m_1415(0, 0, 0), var1, this.f_9465);
      EnergyClient.setThemeColor(var2);
   }

   private float getSearchFieldX() {
      float var1 = this.f_9422 + f_9507 - f_9508;
      return this.f_9425 == Category.COSMETICS && this.client != null ? Math.min(var1, this.client.getWindow().getScaledWidth() - f_9509 - f_9510) : var1;
   }

   private float getThemeHueX() {
      return this.getThemeSVX() + this.getThemeSVWidth() + f_9591;
   }

   public void close() {
      this.f_9440.m_1283();
      if (!this.f_9441) {
         this.f_9441 = true;
         this.closeBindWindow();
         this.f_9461 = false;
         this.f_9459 = null;
      } else {
         super.close();
      }
   }

   private record iOgAfy2mLF6S7jpm(float alpha, float xOffset, float yOffset) {
   }

   private record sKN8QGcpT98iFDgp(String name, int color) {
   }

   private static enum xCBuOCHHe6IcZJcG {
      SATURATION_VALUE,
      HUE,
      OPACITY;
   }
}
