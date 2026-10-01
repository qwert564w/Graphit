package su.energyclient.module.render;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.LingeringPotionItem;
import net.minecraft.item.SplashPotionItem;
import net.minecraft.item.consume.UseAction;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventSwingSpeed;
import su.energyclient.event.impl.EventTransformSideFirstPerson;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.render.RenderUtil18;
import su.energyclient.setting.impl.BooleanSetting;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util116;

public class SwordAnimations extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public final ModeSetting f_6307;
   public final NumberSetting f_6308;
   public final NumberSetting f_6309;
   public final NumberSetting f_6310;
   public final NumberSetting f_6311;
   public final BooleanSetting f_6312;
   private boolean f_6313;
   private boolean f_6314;
   private boolean f_6315;
   private float f_6316;
   private float f_6317;
   private float f_6318;
   private float f_6319;
   private float f_6320;
   private float f_6321;
   private float f_6322;
   private float f_6323;
   private float f_6324;
   private float f_6325;
   private float f_6326;
   private float f_6327;
   private float f_6328;
   private float f_6329;
   private static final String f_6330 = "Sword Animations";
   private static final String f_6331 = "Позволяет изменить анимацию удара";
   private static final String f_6332 = "Мод";
   private static final String f_6333 = "Мод 1";
   private static final String f_6334 = "Мод 1";
   private static final String f_6335 = "Мод 2";
   private static final String f_6336 = "Мод 3";
   private static final String f_6337 = "Мод 4";
   private static final String f_6338 = "Мод 5";
   private static final String f_6339 = "Мод 6";
   private static final String f_6340 = "Мод 7";
   private static final String f_6341 = "Мод 8";
   private static final String f_6342 = "Мод 9";
   private static final String f_6343 = "HMI";
   private static final String f_6344 = "Угол";
   private static final float f_6345 = 100.0F;
   private static final float f_6346 = 360.0F;
   private static final String f_6347 = "Сила взмаха";
   private static final float f_6348 = 8.0F;
   private static final float f_6349 = 10.0F;
   private static final String f_6350 = "Сила взмаха вниз";
   private static final float f_6351 = 0.1F;
   private static final String f_6352 = "Плавность взмаха";
   private static final float f_6353 = 11.0F;
   private static final float f_6354 = 20.0F;
   private static final String f_6355 = "Только с аурой";
   private static final double f_6356 = Math.PI * 2.0 / 3.0;
   private static final double f_6357 = 1.5;
   private static final String f_6358 = "Мод 1";
   private static final String f_6359 = "Мод 2";
   private static final String f_6360 = "Мод 3";
   private static final String f_6361 = "Мод 4";
   private static final String f_6362 = "Мод 5";
   private static final String f_6363 = "Мод 6";
   private static final String f_6364 = "Мод 7";
   private static final String f_6365 = "Мод 8";
   private static final String f_6366 = "Мод 9";
   private static final String f_6367 = "HMI";
   private static final float f_6368 = -1.0F;
   private static final float f_6369 = 45.0F;
   private static final float f_6370 = 4.0F;
   private static final float f_6371 = -20.0F;
   private static final float f_6372 = -20.0F;
   private static final float f_6373 = 10.0F;
   private static final float f_6374 = 45.0F;
   private static final float f_6375 = 0.1F;
   private static final float f_6376 = -0.35F;
   private static final float f_6377 = 90.0F;
   private static final float f_6378 = -60.0F;
   private static final float f_6379 = 10.0F;
   private static final float f_6380 = 0.05F;
   private static final float f_6381 = -0.25F;
   private static final float f_6382 = 50.0F;
   private static final float f_6383 = -20.0F;
   private static final float f_6384 = -120.0F;
   private static final float f_6385 = 25.0F;
   private static final float f_6386 = 10.0F;
   private static final float f_6387 = 20.0F;
   private static final float f_6388 = 50.0F;
   private static final float f_6389 = -15.0F;
   private static final float f_6390 = -25.0F;
   private static final float f_6391 = (float) Math.PI;
   private static final double f_6392 = 0.15;
   private static final double f_6393 = -0.3F;
   private static final float f_6394 = -70.0F;
   private static final float f_6395 = 70.0F;
   private static final float f_6396 = 30.0F;
   private static final float f_6397 = -30.0F;
   private static final float f_6398 = 10.0F;
   private static final float f_6399 = 100.0F;
   private static final float f_6400 = -1.0F;
   private static final float f_6401 = (float) Math.PI;
   private static final float f_6402 = 45.0F;
   private static final float f_6403 = -20.0F;
   private static final float f_6404 = (float) Math.PI;
   private static final float f_6405 = -20.0F;
   private static final float f_6406 = 10.0F;
   private static final float f_6407 = -45.0F;
   private static final float f_6408 = (float) Math.PI;
   private static final float f_6409 = (float) Math.PI;
   private static final float f_6410 = -1.0F;
   private static final float f_6411 = 0.4F;
   private static final float f_6412 = 0.2F;
   private static final float f_6413 = -0.2F;
   private static final float f_6414 = 0.3F;
   private static final float f_6415 = -0.5F;
   private static final float f_6416 = 0.2F;
   private static final float f_6417 = -91.0F;
   private static final float f_6418 = 91.0F;
   private static final float f_6419 = -40.0F;
   private static final float f_6420 = -100.0F;
   private static final float f_6421 = -60.0F;
   private static final float f_6422 = -1.0F;
   private static final float f_6423 = -90.0F;
   private static final float f_6424 = 60.0F;
   private static final float f_6425 = 30.0F;
   private static final float f_6426 = 25.0F;
   private static final float f_6427 = -1.0F;
   private static final float f_6428 = (float) Math.PI;
   private static final float f_6429 = 45.0F;
   private static final float f_6430 = -20.0F;
   private static final float f_6431 = -20.0F;
   private static final float f_6432 = -80.0F;
   private static final float f_6433 = 0.4F;
   private static final float f_6434 = 0.2F;
   private static final float f_6435 = 0.2F;
   private static final float f_6436 = -0.5F;
   private static final float f_6437 = 0.08F;
   private static final float f_6438 = 20.0F;
   private static final float f_6439 = -80.0F;
   private static final float f_6440 = 20.0F;
   private static final String f_6441 = "HMI";
   private static final float f_6442 = -1.0F;
   private static final float f_6443 = 3.14F;
   private static final float f_6444 = -25.0F;
   private static final float f_6445 = -10.0F;
   private static final float f_6446 = 25.0F;
   private static final float f_6447 = 30.0F;
   private static final float f_6448 = -0.15F;
   private static final float f_6449 = 0.1F;
   private static final float f_6450 = 0.1F;
   private static final float f_6451 = -0.55F;
   private static final float f_6452 = 0.4F;
   private static final float f_6453 = 3.14F;
   private static final float f_6454 = 0.6F;
   private static final float f_6455 = 0.12506F;
   private static final float f_6456 = 12.56F;
   private static final float f_6457 = 0.62532F;
   private static final float f_6458 = 0.75038F;
   private static final float f_6459 = 12.56F;
   private static final float f_6460 = 3.14F;
   private static final float f_6461 = -1.0F;
   private static final float f_6462 = -1.0F;
   private static final float f_6463 = 0.15F;
   private static final float f_6464 = -0.25F;
   private static final float f_6465 = -0.2F;
   private static final float f_6466 = 15.0F;
   private static final float f_6467 = -35.0F;
   private static final float f_6468 = 30.0F;
   private static final float f_6469 = 0.45F;
   private static final float f_6470 = -0.25F;
   private static final float f_6471 = -0.35F;
   private static final float f_6472 = -0.6F;
   private static final float f_6473 = 0.1F;
   private static final float f_6474 = 15.0F;
   private static final float f_6475 = 30.0F;
   private static final float f_6476 = 0.1F;
   private static final float f_6477 = 0.1F;
   private static final float f_6478 = -0.5F;
   private static final float f_6479 = 30.0F;
   private static final float f_6480 = -20.0F;
   private static final float f_6481 = -40.0F;
   private static final float f_6482 = 0.1F;
   private static final float f_6483 = 0.1F;
   private static final float f_6484 = -0.1F;
   private static final float f_6485 = 30.0F;
   private static final float f_6486 = -10.0F;
   private static final float f_6487 = -40.0F;
   private static final float f_6488 = 10.0F;
   private static final float f_6489 = 0.1F;
   private static final float f_6490 = 0.1F;
   private static final float f_6491 = -0.2F;
   private static final float f_6492 = 10.0F;
   private static final float f_6493 = -10.0F;
   private static final float f_6494 = -20.0F;
   private static final float f_6495 = 0.8F;
   private static final float f_6496 = 0.3F;
   private static final float f_6497 = -0.5F;
   private static final float f_6498 = 15.0F;
   private static final float f_6499 = 20.0F;
   private static final float f_6500 = -70.0F;
   private static final float f_6501 = -40.0F;
   private static final float f_6502 = -30.0F;
   private static final float f_6503 = -0.55F;
   private static final float f_6504 = -0.8F;
   private static final float f_6505 = -0.77F;
   private static final float f_6506 = 5.0F;
   private static final float f_6507 = 30.0F;
   private static final float f_6508 = 70.0F;
   private static final float f_6509 = -50.0F;
   private static final float f_6510 = 0.1F;
   private static final float f_6511 = 0.1F;
   private static final float f_6512 = -0.5F;
   private static final float f_6513 = 30.0F;
   private static final float f_6514 = -20.0F;
   private static final float f_6515 = -40.0F;
   private static final float f_6516 = 0.1F;
   private static final float f_6517 = 0.1F;
   private static final float f_6518 = -0.1F;
   private static final float f_6519 = 30.0F;
   private static final float f_6520 = -10.0F;
   private static final float f_6521 = -40.0F;
   private static final float f_6522 = 10.0F;
   private static final float f_6523 = -1.0F;
   private static final double f_6524 = 0.1;
   private static final double f_6525 = 0.88;
   private static final float f_6526 = 0.1F;
   private static final double f_6527 = 0.1;
   private static final double f_6528 = 0.88;
   private static final float f_6529 = 0.02F;
   private static final float f_6530 = 8.0F;
   private static final float f_6531 = 0.3F;
   private static final float f_6532 = 5.0F;
   private static final double f_6533 = -0.85;
   private static final double f_6534 = 0.1;
   private static final double f_6535 = 0.88;
   private static final float f_6536 = 45.0F;
   private static final float f_6537 = -0.2F;
   private static final double f_6538 = 0.015;
   private static final float f_6539 = 0.1F;
   private static final double f_6540 = 0.88;
   private static final double f_6541 = 0.015;
   private static final float f_6542 = 0.1F;
   private static final double f_6543 = 0.88;
   private static final double f_6544 = 0.1;
   private static final double f_6545 = 0.007;
   private static final float f_6546 = 0.15F;
   private static final float f_6547 = 0.15F;
   private static final float f_6548 = -0.1F;
   private static final float f_6549 = 0.1F;
   private static final float f_6550 = 0.1F;
   private static final float f_6551 = -0.1F;
   private static final float f_6552 = 0.1F;
   private static final float f_6553 = -1.0F;
   private static final float f_6554 = -0.3F;
   private static final float f_6555 = 0.65F;
   private static final float f_6556 = 0.08F;
   private static final float f_6557 = -0.1F;
   private static final float f_6558 = -65.0F;
   private static final float f_6559 = 10.0F;
   private static final float f_6560 = 0.1F;
   private static final float f_6561 = 0.007F;
   private static final float f_6562 = 0.15F;
   private static final float f_6563 = 0.15F;
   private static final float f_6564 = 3.0F;
   private static final float f_6565 = -1.0F;
   private static final float f_6566 = -0.2F;
   private static final float f_6567 = 0.1F;
   private static final float f_6568 = -0.1F;
   private static final float f_6569 = 10.0F;
   private static final float f_6570 = 0.3F;
   private static final float f_6571 = 0.3F;
   private static final float f_6572 = 45.0F;
   private static final float f_6573 = -40.0F;
   private static final float f_6574 = 30.0F;
   private static final float f_6575 = 0.9F;
   private static final float f_6576 = 0.9F;
   private static final float f_6577 = 0.9F;
   private static final float f_6578 = -1.0F;
   private static final float f_6579 = -0.3F;
   private static final float f_6580 = 0.65F;
   private static final float f_6581 = -0.1F;
   private static final float f_6582 = -65.0F;
   private static final float f_6583 = 10.0F;
   private static final float f_6584 = -1.0F;
   private static final float f_6585 = 0.2F;
   private static final float f_6586 = -0.1F;
   private static final float f_6587 = 0.6F;
   private static final float f_6588 = 0.12506F;
   private static final float f_6589 = 12.56F;
   private static final float f_6590 = 0.62532F;
   private static final float f_6591 = 0.75038F;
   private static final float f_6592 = 12.56F;
   private static final float f_6593 = 3.14F;
   private static final float f_6594 = -60.0F;
   private static final float f_6595 = 0.1F;
   private static final float f_6596 = -0.1F;
   private static final float f_6597 = -80.0F;
   private static final float f_6598 = 30.0F;
   private static final float f_6599 = -40.0F;
   private static final float f_6600 = 0.1F;
   private static final float f_6601 = -0.1F;
   private static final float f_6602 = -25.0F;
   private static final float f_6603 = 0.05F;
   private static final float f_6604 = -0.05F;
   private static final float f_6605 = -1.0F;
   private static final float f_6606 = 0.07F;
   private static final float f_6607 = 0.05F;
   private static final float f_6608 = 90.0F;
   private static final float f_6609 = -15.0F;
   private static final float f_6610 = -1.0F;
   private static final float f_6611 = 0.6F;
   private static final float f_6612 = 0.12506F;
   private static final float f_6613 = 12.56F;
   private static final float f_6614 = 0.62532F;
   private static final float f_6615 = 0.75038F;
   private static final float f_6616 = 12.56F;
   private static final float f_6617 = 3.14F;
   private static final float f_6618 = 0.2F;
   private static final float f_6619 = 0.15F;
   private static final float f_6620 = 0.1F;
   private static final float f_6621 = 0.15F;
   private static final float f_6622 = -0.45F;
   private static final float f_6623 = 35.0F;
   private static final float f_6624 = -30.0F;
   private static final float f_6625 = -10.0F;
   private static final float f_6626 = 10.0F;
   private static final float f_6627 = (float) Math.PI;
   private static final float f_6628 = 45.0F;
   private static final float f_6629 = -45.0F;
   private static final float f_6630 = -0.1F;
   private static final float f_6631 = 35.0F;
   private static final float f_6632 = 15.0F;
   private static final float f_6633 = 75.0F;
   private static final float f_6634 = -0.1F;
   private static final float f_6635 = -45.0F;
   private static final float f_6636 = 0.3F;
   private static final float f_6637 = -0.35F;
   private static final float f_6638 = 0.1F;
   private static final float f_6639 = 1.5F;
   private static final float f_6640 = 1.5F;
   private static final float f_6641 = 1.5F;
   private static final float f_6642 = -0.1F;
   private static final float f_6643 = 5.0F;
   private static final float f_6644 = 15.0F;
   private static final float f_6645 = 75.0F;
   private static final float f_6646 = 1.5F;
   private static final float f_6647 = 1.5F;
   private static final float f_6648 = 1.5F;
   private static final float f_6649 = 25.0F;
   private static final float f_6650 = 5.0F;
   private static final float f_6651 = 75.0F;
   private static final float f_6652 = 0.2F;
   private static final float f_6653 = 0.2F;
   private static final float f_6654 = 0.05F;
   private static final float f_6655 = -0.2F;
   private static final float f_6656 = 1.1F;
   private static final float f_6657 = 1.1F;
   private static final float f_6658 = 1.1F;
   private static final float f_6659 = 25.0F;
   private static final float f_6660 = 0.35F;
   private static final float f_6661 = 0.25F;
   private static final float f_6662 = 0.37F;
   private static final float f_6663 = 0.75F;
   private static final float f_6664 = 0.75F;
   private static final float f_6665 = 0.75F;
   private static final float f_6666 = -75.0F;
   private static final float f_6667 = 35.0F;
   private static final float f_6668 = 0.85F;
   private static final float f_6669 = 0.05F;
   private static final float f_6670 = -0.2F;
   private static final float f_6671 = 5.0F;
   private static final float f_6672 = 15.0F;
   private static final float f_6673 = 75.0F;
   private static final float f_6674 = -0.05F;
   private static final float f_6675 = -0.1F;
   private static final float f_6676 = 0.7F;
   private static final float f_6677 = 0.7F;
   private static final float f_6678 = 0.7F;
   private static final float f_6679 = 160.0F;
   private static final float f_6680 = -60.0F;
   private static final float f_6681 = -70.0F;
   private static final float f_6682 = 0.75F;
   private static final float f_6683 = 0.75F;
   private static final float f_6684 = 0.75F;
   private static final float f_6685 = 0.15F;
   private static final float f_6686 = 0.45F;
   private static final float f_6687 = -0.1F;
   private static final float f_6688 = 0.17F;
   private static final float f_6689 = 0.3F;
   private static final float f_6690 = -90.0F;
   private static final float f_6691 = 75.0F;
   private static final float f_6692 = 90.0F;
   private static final float f_6693 = 45.0F;
   private static final float f_6694 = -0.3F;
   private static final float f_6695 = 1.2F;
   private static final float f_6696 = 1.2F;
   private static final float f_6697 = 1.2F;
   private static final float f_6698 = 75.0F;
   private static final float f_6699 = 70.0F;
   private static final float f_6700 = 45.0F;
   private static final float f_6701 = -0.05F;
   private static final float f_6702 = 0.08F;
   private static final float f_6703 = 75.0F;
   private static final float f_6704 = 62.0F;
   private static final float f_6705 = 70.0F;
   private static final float f_6706 = 45.0F;
   private static final float f_6707 = 1.2F;
   private static final float f_6708 = 1.2F;
   private static final float f_6709 = 1.2F;
   private static final float f_6710 = -0.1F;
   private static final float f_6711 = -0.2F;
   private static final float f_6712 = 0.015F;
   private static final float f_6713 = 0.015F;
   private static final float f_6714 = 0.1F;
   private static final float f_6715 = 0.1F;
   private static final float f_6716 = 0.88F;
   private static final float f_6717 = 0.88F;
   private static final float f_6718 = -35.0F;
   private static final float f_6719 = 35.0F;
   private static final float f_6720 = -25.0F;
   private static final float f_6721 = 25.0F;
   private static final float f_6722 = 15.0F;
   private static final float f_6723 = 0.1F;
   private static final float f_6724 = 0.09F;
   private static final float f_6725 = 0.65F;
   private static final float f_6726 = 0.22F;
   private static final float f_6727 = 0.01F;
   private static final float f_6728 = 0.015F;
   private static final float f_6729 = 0.1F;
   private static final float f_6730 = 0.88F;
   private static final float f_6731 = -0.25F;
   private static final float f_6732 = 0.25F;
   private static final float f_6733 = 0.18F;
   private static final float f_6734 = 0.78F;
   private static final float f_6735 = -0.18F;
   private static final float f_6736 = 0.18F;
   private static final float f_6737 = 0.1F;
   private static final double f_6738 = -0.25;
   private static final float f_6739 = 0.12F;
   private static final float f_6740 = -2.0F;
   private static final float f_6741 = 0.7F;
   private static final float f_6742 = 1.25F;
   private static final float f_6743 = 1.70158F;
   private static final float f_6744 = 1.525F;
   private static final float f_6745 = 0.5F;
   private static final double f_6746 = 2.0;
   private static final double f_6747 = 2.0;
   private static final double f_6748 = 2.0;
   private static final double f_6749 = 2.0;
   private static final double f_6750 = 2.0;
   private static final String f_6751 = "Мод 1";
   private static final String f_6752 = "Мод 2";
   private static final String f_6753 = "Мод 3";
   private static final String f_6754 = "Мод 4";
   private static final String f_6755 = "Мод 6";
   private static final String f_6756 = "Бумеранг";
   private static final String f_6757 = "Вертушка";
   private static final String f_6758 = "Жнец";
   private static final String f_6759 = "Разлом";
   private static final String f_6760 = "Призрак";
   private static final String f_6761 = "HMI";
   private static final String f_6762 = "Мод 2";
   private static final String f_6763 = "Мод 4";

   public void m_3155(MatrixStack var1, ItemStack var2, Hand var3, Arm var4, float var5) {
      this.m_812(var5);
      float var6 = var5 < f_6454
         ? MathHelper.sin(MathHelper.clamp(var5, 0.0F, f_6455) * f_6456)
         : MathHelper.sin(MathHelper.clamp(var5, f_6457, f_6458) * f_6459);
      float var7 = this.m_2278(MathHelper.sin(var5 * f_6460));
      float var8 = var4 == Arm.RIGHT ? 1.0F : f_6461;
      float var9 = var3 == Hand.MAIN_HAND ? 1.0F : f_6462;
      boolean var10 = this.f_6313 || var2.isIn(ItemTags.AXES) || var2.getUseAction() == UseAction.SPEAR || var2.getUseAction() == UseAction.BLOCK;
      if (var2.isIn(ItemTags.SHOVELS)) {
         var1.translate(0.0F, f_6463 * var6, f_6464 * var6);
         var1.translate(0.0F, 0.0F, f_6465 * var7);
         var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6466 * var6));
         var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6467 * var6));
         var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6468 * var7));
      } else {
         if (var10) {
            if (var2.getUseAction() == UseAction.SPEAR && !var2.isIn(ItemTags.SWORDS) && !var2.isIn(ItemTags.AXES)) {
               var1.translate(0.0F, 0.0F, f_6469 * var6);
               var1.translate(f_6470 * var9 * var7, f_6471 * var6, f_6472 * var7);
               var1.translate(0.0F, f_6473 * var7, 0.0F);
               var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6474 * var6 * var8));
               var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6475 * var6 * var8));
            } else if (this.m_3065(var2) && !var2.isIn(ItemTags.SWORDS) && !var2.isIn(ItemTags.AXES)) {
               var1.translate(f_6476 * var8 * var6, f_6477 * var6, f_6478 * var7);
               var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6479 * var6));
               var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6480 * var6 * var8));
               var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6481 * var7));
            } else if (!var2.isIn(ItemTags.SWORDS) && !var2.isIn(ItemTags.AXES) && var2.getUseAction() != UseAction.BLOCK) {
               var1.translate(f_6482 * var8 * var6, f_6483 * var6, f_6484 * var7);
               var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6485 * var6));
               var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6486 * var6 * var8));
               var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6487 * var7));
               var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6488 * var7 * var8));
            } else if (var2.getUseAction() == UseAction.BLOCK && !var2.isIn(ItemTags.SWORDS) && !var2.isIn(ItemTags.AXES)) {
               var1.translate(f_6489 * var8 * var6, f_6490 * var6, f_6491 * var7);
               var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6492 * var6));
               var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6493 * var6 * var8));
               var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6494 * var7));
            } else {
               var1.translate(f_6495 * var8 * var6, f_6496 * var6, f_6497 * var7);
               var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6498 * var6 * var8));
               var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6499 * var6));
               var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6500 * var6 * var8));
               var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var2.isIn(ItemTags.SWORDS) ? f_6501 * var7 : f_6502 * var7));
            }
         } else if (var2.isIn(ItemTags.SWORDS)) {
            var1.translate(f_6503 * var8 * var6, f_6504 * var6, f_6505 * var7);
            var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6506 * var6 * var8));
            var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6507 * var6));
            var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6508 * var6 * var8));
            var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6509 * var7));
         } else if (this.m_3065(var2)) {
            var1.translate(f_6510 * var8 * var6, f_6511 * var6, f_6512 * var7);
            var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6513 * var6));
            var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6514 * var6 * var8));
            var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6515 * var7));
         } else {
            var1.translate(f_6516 * var8 * var6, f_6517 * var6, f_6518 * var7);
            var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6519 * var6));
            var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6520 * var6 * var8));
            var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6521 * var7));
            var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6522 * var7 * var8));
         }
      }
   }

   @EventHandler
   public void m_400(EventTransformSideFirstPerson var1) {
      if (this.m_3410()) {
         if (var1.m_142() == f_5909.player.getMainArm()) {
            var1.m_684(this.f_6310.m_4046());
         }
      }
   }

   private void m_448(MatrixStack var1, ItemStack var2, Arm var3) {
      float var4 = var3 == Arm.RIGHT ? 1.0F : f_6553;
      float var5 = f_5909.player.age + f_5909.getRenderTickCounter().getTickProgress(false);
      this.m_3092();
      var1.translate(f_6554 * var4, f_6555 - this.f_6329 * f_6556, f_6557);
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6558 * var4));
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6559));
      var1.translate(0.0F, -this.f_6323, 0.0F);
      var1.translate(0.0F, MathHelper.sin(var5 * f_6560) * f_6561, 0.0F);
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6562 * MathHelper.sin(var5 * f_6563) * var4));
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6564 * this.f_6327 * var4));
   }

   private boolean m_2555(ItemStack var1) {
      return var1.isOf(Items.TORCH) || var1.isOf(Items.SOUL_TORCH) || var1.isOf(Items.REDSTONE_TORCH);
   }

   private void m_2855(MatrixStack var1, ItemStack var2, Arm var3) {
      float var4 = var3 == Arm.RIGHT ? 1.0F : f_6584;
      UseAction var5 = var2.getUseAction();
      if (var2.isIn(ItemTags.WOOL_CARPETS)) {
         var1.translate(f_6585 * var4, f_6586, 0.0F);
      }

      if (var2.getItem() instanceof BlockItem var6 && var5 != UseAction.EAT && var5 != UseAction.DRINK) {
         this.m_1117(var1, var2, var6, var4);
      } else {
         if (this.m_2936(var2, var5)) {
            this.m_1587(var1, var2, var4);
         } else if (var5 == UseAction.BLOCK) {
            this.m_912(var1, var4);
         } else if (var5 == UseAction.SPEAR) {
            this.m_3797(var1, var4);
         } else {
            this.m_3591(var1, var2, var5, var4);
         }
      }
   }

   public void m_816(MatrixStack var1, ItemStack var2, Arm var3) {
      if (var2.isIn(ItemTags.SHOVELS)) {
         float var4 = var3 == Arm.RIGHT ? 1.0F : f_6605;
         var1.translate(f_6606 * var4, 0.0F, f_6607);
         var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6608 * var4));
         var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6609));
      }
   }

   private boolean m_3065(ItemStack var1) {
      return var1.isIn(ItemTags.SWORDS) || var1.isIn(ItemTags.AXES) || var1.isIn(ItemTags.PICKAXES) || var1.isIn(ItemTags.SHOVELS) || var1.isIn(ItemTags.HOES);
   }

   private void m_1587(MatrixStack var1, ItemStack var2, float var3) {
      if (var2.getUseAction() == UseAction.BRUSH) {
         var1.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(f_6659));
         var1.translate(f_6660, f_6661, f_6662);
         var1.scale(f_6663, f_6664, f_6665);
         var1.multiply(RotationAxis.NEGATIVE_Z.rotationDegrees(f_6666 * var3));
         var1.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(f_6667));
         var1.translate(f_6668, f_6669, f_6670);
      } else {
         var1.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(f_6671 * var3));
         var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6672));
         var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6673 * var3));
         var1.translate(0.0F, f_6674, f_6675);
         var1.scale(f_6676, f_6677, f_6678);
      }

      this.m_978(var1, var2);
   }

   private boolean m_2936(ItemStack var1, UseAction var2) {
      return var2 != UseAction.BOW
         && var2 != UseAction.SPYGLASS
         && var2 != UseAction.CROSSBOW
         && var2 != UseAction.BLOCK
         && var2 != UseAction.SPEAR
         && !this.m_3065(var1)
         && !var1.isOf(Items.WARPED_FUNGUS_ON_A_STICK)
         && !var1.isOf(Items.CARROT_ON_A_STICK)
         && !var1.isOf(Items.SHEARS)
         && !(var1.getItem() instanceof FishingRodItem);
   }

   private void m_3002(MatrixStack var1, float var2, float var3) {
      float var4 = MathHelper.sin(var3 * f_6627);
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var2 * (f_6628 + var4 * 0.0F)));
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var2 * f_6629));
   }

   @EventHandler
   public void m_2560(EventSwingSpeed var1) {
      if (this.m_3410()) {
         if (var1.m_3373() == Hand.MAIN_HAND) {
            var1.m_454(this.f_6311.m_134().intValue());
            var1.m_277(true);
         }
      }
   }

   private void m_812(float var1) {
      boolean var2 = f_5909.options.attackKey.isPressed();
      if (var2 && !this.f_6314 && var1 == 0.0F) {
         this.f_6313 = !this.f_6313;
      }

      this.f_6314 = var2;
   }

   private void m_3092() {
      if (!this.f_6315) {
         this.f_6316 = f_5909.player.getYaw();
         this.f_6317 = f_5909.player.getPitch();
         this.f_6315 = true;
      }

      float var1 = MathHelper.wrapDegrees(this.f_6316 - f_5909.player.getYaw());
      float var2 = this.f_6317 - f_5909.player.getPitch();
      this.f_6316 = f_5909.player.getYaw();
      this.f_6317 = f_5909.player.getPitch();
      float var3 = (float)f_5909.player.getVelocity().horizontalLength();
      float var4 = (float)f_5909.player.getVelocity().y;
      boolean var5 = (Boolean)f_5909.options.getBobView().getValue();
      this.f_6320 = this.f_6320 + var1 * f_6712;
      this.f_6321 = this.f_6321 + var2 * f_6713;
      this.f_6320 = this.f_6320 - f_6714 * this.f_6318;
      this.f_6321 = this.f_6321 - f_6715 * this.f_6319;
      this.f_6320 = this.f_6320 * f_6716;
      this.f_6321 = this.f_6321 * f_6717;
      this.f_6318 = MathHelper.clamp(this.f_6318 + this.f_6320, f_6718, f_6719);
      this.f_6319 = MathHelper.clamp(this.f_6319 + this.f_6321, f_6720, f_6721);
      this.f_6322 = this.f_6322 + (var3 * f_6722 - this.f_6322) * f_6723;
      if (var5 && (var3 > f_6724 && f_5909.player.isOnGround() || f_5909.player.isSwimming())) {
         this.f_6320 = this.f_6320 + MathHelper.sin(f_5909.player.age * f_6725) * var3 * f_6726;
         this.f_6326 = this.f_6326 - var3 * f_6727;
      }

      this.f_6324 = this.f_6324 + var4 * f_6728;
      this.f_6324 = this.f_6324 - f_6729 * this.f_6323;
      this.f_6324 = this.f_6324 * f_6730;
      this.f_6323 = MathHelper.clamp(this.f_6323 + this.f_6324, f_6731, f_6732);
      this.f_6326 = this.f_6326 - f_6733 * this.f_6325;
      this.f_6326 = this.f_6326 * f_6734;
      this.f_6325 = MathHelper.clamp(this.f_6325 + this.f_6326, f_6735, f_6736);
      this.f_6327 = this.m_2249(this.f_6327, f_5909.player.isTouchingWater() && !f_5909.player.isSwimming() ? 1.0F : 0.0F, f_6737);
      this.f_6329 = this.m_2249(this.f_6329, !f_5909.player.isOnGround() && f_5909.player.getVelocity().y < f_6738 ? 1.0F : 0.0F, f_6739);
   }

   private boolean m_1130(ItemStack var1, BlockItem var2) {
      return var1.isOf(Items.STRING)
         || var1.isOf(Items.REDSTONE)
         || var1.isOf(Items.LEVER)
         || var1.isOf(Items.TRIPWIRE_HOOK)
         || var1.isIn(ItemTags.DOORS)
         || var2.getBlock().getDefaultState().isIn(BlockTags.RAILS)
         || var2.getBlock().getDefaultState().isIn(BlockTags.CLIMBABLE);
   }

   private void m_3591(MatrixStack var1, ItemStack var2, UseAction var3, float var4) {
      if (var2.isIn(ItemTags.SHOVELS)) {
         var1.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(f_6698 * var4));
         var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6699));
         var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6700 * var4));
         var1.translate(0.0F, f_6701, f_6702);
      } else {
         var1.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(f_6703 * var4));
         var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var3 != UseAction.BOW && var3 != UseAction.CROSSBOW ? f_6705 : f_6704));
         var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6706 * var4));
      }

      var1.scale(f_6707, f_6708, f_6709);
      if ((var3 == UseAction.BOW || var3 == UseAction.CROSSBOW) && !f_5909.player.isUsingItem()) {
         var1.translate(f_6710 * var4, f_6711, 0.0F);
      }
   }

   public void m_3750(MatrixStack var1, Arm var2, float var3) {
      float var4 = var2 == Arm.RIGHT ? 1.0F : f_6610;
      float var5 = var3 < f_6611
         ? MathHelper.sin(MathHelper.clamp(var3, 0.0F, f_6612) * f_6613)
         : MathHelper.sin(MathHelper.clamp(var3, f_6614, f_6615) * f_6616);
      float var6 = this.m_2278(MathHelper.sin(var3 * f_6617));
      var1.translate(0.0F, f_6618 * var5, f_6619 * var5);
      var1.translate(f_6620 * var4 * var6, f_6621 * var6, f_6622 * var6);
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6623 * var6 * var4));
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6624 * var6));
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6625 * var5 * var4));
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6626 * var5));
   }

   public void m_3617(MatrixStack var1, Arm var2, float var3) {
      float var4 = var2 == Arm.RIGHT ? 1.0F : f_6442;
      float var5 = this.m_2278(MathHelper.sin(var3 * f_6443));
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6444 * var4));
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6445));
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6446 * var4 * var5));
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6447 * var5));
      var1.translate(f_6448 * var4, f_6449, f_6450);
      var1.translate(0.0F, f_6451 * var5, f_6452 * var5 * f_6453);
   }

   public void m_2316(MatrixStack var1, ItemStack var2, Arm var3, float var4, float var5) {
      float var6 = var3 == Arm.RIGHT ? 1.0F : f_6565;
      if (!var2.isOf(Items.LANTERN) && !var2.isOf(Items.SOUL_LANTERN) && !var2.isIn(ItemTags.HANGING_SIGNS)) {
         if (var2.getUseAction() == UseAction.BLOCK) {
            var1.translate(0.0F, f_6566, 0.0F);
         }
      } else {
         var1.translate(f_6567 * var6, 0.0F, f_6568);
         var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6569));
      }

      var1.translate(var6, -var4 * f_6570, f_6571);
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6572 * var6));
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6573 * var6));
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6574));
      this.m_3002(var1, var6, var5);
      var1.scale(f_6575, f_6576, f_6577);
   }

   private void m_3797(MatrixStack var1, float var2) {
      var1.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(f_6691 * var2));
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6692));
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6693 * var2));
      var1.translate(f_6694 * var2, 0.0F, 0.0F);
      var1.scale(f_6695, f_6696, f_6697);
   }

   private void m_912(MatrixStack var1, float var2) {
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6679 * var2));
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6680 * var2));
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6681));
      var1.scale(f_6682, f_6683, f_6684);
      var1.translate(f_6685 * var2, f_6686, f_6687);
      var1.translate(f_6688 * var2, 0.0F, f_6689);
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6690 * var2));
   }

   public SwordAnimations() {
      super(f_6330, f_6331, Category.RENDER);
      this.f_6307 = new ModeSetting(f_6332, f_6333, f_6334, f_6335, f_6336, f_6337, f_6338, f_6339, f_6340, f_6341, f_6342, f_6343);
      this.f_6308 = new NumberSetting(f_6344, f_6345, 0.0F, f_6346, 1.0F).m_356(() -> this.f_6307.m_2073(f_6762) || this.f_6307.m_2073(f_6763));
      this.f_6309 = new NumberSetting(f_6347, f_6348, 1.0F, f_6349, 1.0F)
         .m_356(
            () -> this.f_6307.m_2073(f_6751)
               || this.f_6307.m_2073(f_6752)
               || this.f_6307.m_2073(f_6753)
               || this.f_6307.m_2073(f_6754)
               || this.f_6307.m_2073(f_6755)
               || this.f_6307.m_2073(f_6756)
               || this.f_6307.m_2073(f_6757)
               || this.f_6307.m_2073(f_6758)
               || this.f_6307.m_2073(f_6759)
               || this.f_6307.m_2073(f_6760)
               || this.f_6307.m_2073(f_6761)
         );
      this.f_6310 = new NumberSetting(f_6350, 0.0F, 0.0F, 1.0F, f_6351);
      this.f_6311 = new NumberSetting(f_6352, f_6353, 1.0F, f_6354, 1.0F);
      this.f_6312 = new BooleanSetting(f_6355, false);
   }

   public void m_772(MatrixStack var1, AbstractClientPlayerEntity var2, Hand var3, ItemStack var4, float var5, float var6) {
      float var7 = var3 == Hand.MAIN_HAND ? 1.0F : f_6523;
      double var8 = 1.0;
      if ((var2.isTouchingWater() || var2.inPowderSnow) && !var2.isSwimming() && !var2.isSubmergedInWater()) {
         this.f_6327 = Math.min(1.0F, (float)(this.f_6327 + f_6524 * var8));
      } else {
         this.f_6327 = (float)(this.f_6327 * Math.pow(f_6525, var8));
      }

      float var12 = MathHelper.clamp((float)var2.getFrozenTicks() / var2.getMinFreezeDamageTicks(), 0.0F, 1.0F);
      if (var2.inPowderSnow && var12 > f_6526) {
         this.f_6328 = Math.min(1.0F, (float)(this.f_6328 + f_6527 * var8));
      } else {
         this.f_6328 = (float)(this.f_6328 * Math.pow(f_6528, var8));
      }

      var1.translate(0.0F, f_6529 * this.f_6327, 0.0F);
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6530 * var7 * this.f_6327));
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6531 * MathHelper.sin(this.f_6328 * f_6532)));
      if (var2.getVelocity().y < f_6533 && var4.isOf(Items.MACE) && var2.getMainHandStack() == var4) {
         this.f_6329 = Math.min(1.0F, (float)(this.f_6329 + f_6534 * var8));
      } else {
         this.f_6329 = (float)(this.f_6329 * Math.pow(f_6535, var8));
      }

      if (var3 == Hand.MAIN_HAND) {
         var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6536 * this.f_6329));
         var1.translate(0.0F, f_6537 * this.f_6329, 0.0F);
      }

      this.f_6323 = (float)(this.f_6323 + var2.getVelocity().y * f_6538 * var8);
      this.f_6323 = (float)(this.f_6323 - f_6539 * this.f_6323 * var8);
      this.f_6323 = (float)(this.f_6323 * Math.pow(f_6540, var8));
      this.f_6326 = (float)(this.f_6326 + var2.getVelocity().y * f_6541 * var8);
      this.f_6326 = (float)(this.f_6326 - f_6542 * this.f_6325 * var8);
      this.f_6326 = (float)(this.f_6326 * Math.pow(f_6543, var8));
      this.f_6325 = (float)(this.f_6325 + this.f_6326 * var8);
      var1.translate(0.0F, -this.f_6323, 0.0F);
      var1.translate(0.0, Math.sin((var2.age + var6) * f_6544) * f_6545 * var7, 0.0);
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6546 * MathHelper.sin((var2.age + var6) * f_6547) * var7));
      if ((!var4.isEmpty() || var2.isInSwimmingPose() || var2.isClimbing() && !var2.isOnGround() || var2.isSwimming())
         && var4.getUseAction() != UseAction.BLOCK) {
         var1.translate(0.0F, f_6548, f_6549);
      }

      if (var4.isOf(Items.LANTERN) || var4.isOf(Items.SOUL_LANTERN) || var4.isIn(ItemTags.HANGING_SIGNS)) {
         var1.translate(0.0F, f_6550, 0.0F);
         if (var2.isSwimming()) {
            var1.translate(0.0F, f_6551, f_6552);
         }
      }
   }

   private float m_2278(float var1) {
      float var2 = f_6743;
      float var3 = var2 * f_6744;
      return var1 < f_6745
         ? (float)(Math.pow(2.0F * var1, f_6746) * ((var3 + 1.0F) * 2.0F * var1 - var3) / f_6747)
         : (float)((Math.pow(2.0F * var1 - 2.0F, f_6748) * ((var3 + 1.0F) * (var1 * 2.0F - 2.0F) + var3) + f_6749) / f_6750);
   }

   @EventHandler
   public void m_283(Util116 var1) {
      if (this.m_3410()) {
         MatrixStack var2 = var1.m_3181();
         float var3 = (float)Math.sin(var1.m_1770() * f_6356 * f_6357);
         if (var1.m_538() == Hand.MAIN_HAND) {
            boolean var4 = f_5909.player.getMainArm() == Arm.LEFT;
            String var5 = this.f_6307.m_3862();
            switch (var5) {
               case f_6358:
                  float var15 = MathHelper.sqrt(var1.m_1770());
                  float var18 = var4 ? f_6368 : 1.0F;
                  var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var18 * (f_6369 + var3 / f_6370 * f_6371)));
                  var2.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var18 * var3 * f_6372));
                  var2.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var3 * -this.f_6309.m_4046() * f_6373));
                  var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-var18 * f_6374));
                  break;
               case f_6359:
                  var2.translate(0.0F, f_6375, f_6376);
                  var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6377));
                  var2.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6378));
                  var2.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-this.f_6308.m_134().floatValue() - this.f_6309.m_134().floatValue() * f_6379 * var3));
                  break;
               case f_6360:
                  var2.translate(0.0F, f_6380, f_6381);
                  var2.translate(0.0F, 0.0F, var3 * this.f_6309.m_4046() / f_6382);
                  var2.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(f_6383));
                  var2.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6384));
                  var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-var3 * 1.0F + f_6385));
                  var2.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-var3 * 1.0F + f_6386));
                  var2.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-var3 * 1.0F - f_6387));
                  var2.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6388));
                  var2.multiply(RotationAxis.NEGATIVE_Z.rotationDegrees(f_6389));
                  var2.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(f_6390));
                  break;
               case f_6361:
                  float var14 = MathHelper.sin(MathHelper.sqrt(var1.m_1770()) * f_6391);
                  var2.translate(0.0, f_6392, f_6393);
                  var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var4 ? f_6394 : f_6395));
                  var2.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var4 ? f_6396 : f_6397));
                  var2.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-this.f_6308.m_4046() - this.f_6309.m_4046() * f_6398 * var14));
                  break;
               case f_6362:
                  var2.translate(0.0F, 0.0F - var3 * this.f_6309.m_4046() / f_6399, 0.0F);
                  break;
               case f_6363:
                  float var13 = var4 ? f_6400 : 1.0F;
                  float var17 = MathHelper.sin(var1.m_1770() * var1.m_1770() * f_6401);
                  var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var13 * (f_6402 + var17 * f_6403)));
                  float var19 = MathHelper.sin(MathHelper.sqrt(var1.m_1770()) * f_6404);
                  var2.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var13 * var19 * f_6405));
                  var2.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var19 * -this.f_6309.m_4046() * f_6406));
                  var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var13 * f_6407));
                  break;
               case f_6364:
                  float var12 = MathHelper.sqrt(var1.m_1770());
                  float var16 = MathHelper.sin(var12 * f_6408);
                  float var9 = MathHelper.sin(var1.m_1770() * f_6409);
                  float var10 = var4 ? f_6410 : 1.0F;
                  var2.translate(var10 * (f_6411 - var16 * f_6412), f_6413 + var16 * f_6414, f_6415 - var9 * f_6416);
                  var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var4 ? f_6417 : f_6418));
                  var2.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var10 * (f_6419 + var16 * f_6420)));
                  var2.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6421));
                  break;
               case f_6365:
                  float var11 = var4 ? f_6422 : 1.0F;
                  var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var11 * f_6423));
                  var2.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var11 * f_6424));
                  var2.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6425));
                  var2.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var11 * f_6426 * var3));
                  break;
               case f_6366:
                  float var7 = var4 ? f_6427 : 1.0F;
                  float var8 = MathHelper.sin(MathHelper.sqrt(var1.m_1770()) * f_6428);
                  var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var7 * f_6429));
                  var2.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var8 * f_6430));
                  var2.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var7 * var8 * f_6431));
                  var2.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var8 * f_6432));
                  var2.translate(var7 * f_6433, f_6434, f_6435);
                  var2.translate(var7 * f_6436, f_6437, 0.0F);
                  var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var7 * f_6438));
                  var2.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6439));
                  var2.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var7 * f_6440));
                  break;
               case f_6367:
                  this.m_306(var2, var1.m_1770(), var4);
            }

            var1.m_277(true);
         }
      }
   }

   public void m_1545(MatrixStack var1, ItemStack var2, Arm var3) {
      float var4 = var3 == Arm.RIGHT ? 1.0F : f_6578;
      var1.translate(f_6579 * var4, f_6580, f_6581);
      var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6582 * var4));
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6583));
      this.m_2855(var1, var2, var3);
   }

   public boolean m_907() {
      return this.m_677() && this.f_6307.m_2073(f_6441) && this.m_3410();
   }

   public void m_1220(MatrixStack var1, ItemStack var2, float var3) {
      float var4 = var3 < f_6587
         ? MathHelper.sin(MathHelper.clamp(var3, 0.0F, f_6588) * f_6589)
         : MathHelper.sin(MathHelper.clamp(var3, f_6590, f_6591) * f_6592);
      float var5 = this.m_2278(MathHelper.sin(var3 * f_6593));
      if (this.m_3065(var2)
         || var2.getUseAction() == UseAction.BOW
         || var2.getUseAction() == UseAction.SPYGLASS
         || var2.getUseAction() == UseAction.BLOCK
         || var2.isOf(Items.WARPED_FUNGUS_ON_A_STICK)
         || var2.isOf(Items.CARROT_ON_A_STICK)
         || var2.getItem() instanceof FishingRodItem
         || var2.isOf(Items.SHEARS)) {
         if (var2.isIn(ItemTags.SWORDS)) {
            var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6594 * var5));
            var1.translate(0.0F, f_6595 * var5, f_6596 * var5);
         }

         if (var2.isIn(ItemTags.SHOVELS)) {
            var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6597 * var4));
            var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6598 * var5));
         } else if (var2.getUseAction() == UseAction.SPEAR) {
            var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6599 * var4));
            var1.translate(0.0F, f_6600 * var4, f_6601 * var4);
         } else if (var2.getUseAction() != UseAction.BLOCK) {
            var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6602 * var5));
            var1.translate(0.0F, f_6603 * var5, f_6604 * var5);
         }
      }
   }

   private float m_2249(float var1, float var2, float var3) {
      return var1 < var2 ? Math.min(var2, var1 + var3) : Math.max(var2, var1 - var3);
   }

   @EventHandler
   public void m_1284(RenderUtil18 var1) {
      if (this.m_3410()) {
         if (var1.m_742() == f_5909.player.getMainArm()) {
            var1.m_4048(-this.f_6310.m_134().floatValue());
         }
      }
   }

   private void m_978(MatrixStack var1, ItemStack var2) {
      if (var2.isOf(Items.FEATHER)
         || var2.isOf(Items.SLIME_BALL)
         || var2.isOf(Items.PUFFERFISH)
         || var2.isOf(Items.SLIME_BLOCK)
         || var2.isOf(Items.HONEY_BLOCK)
         || var2.isIn(ItemTags.WOOL_CARPETS)) {
         float var3 = MathHelper.clamp(1.0F + this.f_6325 * f_6740, f_6741, f_6742);
         var1.scale(1.0F, var3, 1.0F);
      }
   }

   private void m_1117(MatrixStack var1, ItemStack var2, BlockItem var3, float var4) {
      if (var2.isOf(Items.LANTERN) || var2.isOf(Items.SOUL_LANTERN) || var2.isIn(ItemTags.HANGING_SIGNS)) {
         var1.translate(0.0F, 0.0F, f_6630);
         var1.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(f_6631 * var4 + this.f_6318));
         var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6632 + this.f_6319));
         var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6633 * var4 + this.f_6322));
         if (var2.isIn(ItemTags.HANGING_SIGNS)) {
            var1.translate(0.0F, f_6634, 0.0F);
            var1.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(f_6635 * var4));
         }

         var1.translate(f_6636 * var4, f_6637, f_6638);
         var1.scale(f_6639, f_6640, f_6641);
      } else if (this.m_1130(var2, var3)) {
         var1.translate(0.0F, 0.0F, f_6642);
         var1.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(f_6643 * var4));
         var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6644));
         var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6645 * var4));
      } else {
         if (this.m_2555(var2)) {
            var1.scale(f_6646, f_6647, f_6648);
         }

         var1.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(f_6649 * var4));
         var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_6650));
         var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(f_6651 * var4));
         var1.translate(f_6652 * var4, f_6653, f_6654);
         if (var2.isIn(ItemTags.BANNERS)) {
            var1.translate(f_6655 * var4, 0.0F, 0.0F);
            var1.scale(f_6656, f_6657, f_6658);
         }

         this.m_978(var1, var2);
      }
   }

   public boolean m_2805(AbstractClientPlayerEntity var1, ItemStack var2, boolean var3) {
      return var3
         && (
            var2.isOf(Items.EXPERIENCE_BOTTLE)
               || var2.isOf(Items.EGG)
               || var2.isOf(Items.ENDER_EYE)
               || var2.isOf(Items.SNOWBALL)
               || var2.isOf(Items.ENDER_PEARL)
               || var2.getItem() instanceof SplashPotionItem
               || var2.getItem() instanceof LingeringPotionItem
         )
         && var2.getUseAction() != UseAction.SPEAR
         && !var2.isOf(Items.FIRE_CHARGE)
         && !var1.isSwimming()
         && !var1.isInSwimmingPose()
         && !var1.isClimbing();
   }

   private void m_306(MatrixStack var1, float var2, boolean var3) {
      this.m_3155(var1, f_5909.player.getMainHandStack(), Hand.MAIN_HAND, var3 ? Arm.LEFT : Arm.RIGHT, var2);
   }

   private boolean m_3410() {
      if (!this.f_6312.m_1163()) {
         return true;
      } else {
         AttackAura var1 = InitManager.f_2740.f_2741.attackAura;
         return var1 != null && var1.m_891() != null;
      }
   }
}
