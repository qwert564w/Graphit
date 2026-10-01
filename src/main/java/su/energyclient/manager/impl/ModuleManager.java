package su.energyclient.manager.impl;

import java.util.Arrays;
import java.util.Optional;
import net.minecraft.client.option.Perspective;
import net.minecraft.util.math.MathHelper;
import su.energyclient.EnergyClient;
import su.energyclient.QuickImports;
import su.energyclient.event.EventHandler;
import su.energyclient.manager.Manager;
import su.energyclient.module.Module;
import su.energyclient.module.combat.AimBot;
import su.energyclient.module.combat.AntiBot;
import su.energyclient.module.combat.AntiThorns;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.module.combat.AutoExplosion;
import su.energyclient.module.combat.AutoMace;
import su.energyclient.module.combat.AutoPotion;
import su.energyclient.module.combat.AutoSwap;
import su.energyclient.module.combat.AutoTotem;
import su.energyclient.module.combat.BowSpammer;
import su.energyclient.module.combat.Criticals;
import su.energyclient.module.combat.CrystalAura;
import su.energyclient.module.combat.FastCriticals;
import su.energyclient.module.combat.Macetarget;
import su.energyclient.module.combat.NoFriendDamage;
import su.energyclient.module.combat.NoSlotChange;
import su.energyclient.module.combat.Velocity;
import su.energyclient.module.combat.WebTrap;
import su.energyclient.module.miscellaneous.AutoAccept;
import su.energyclient.module.miscellaneous.AutoBrewPotion;
import su.energyclient.module.miscellaneous.AutoBrewerBuilder;
import su.energyclient.module.miscellaneous.AutoBuy;
import su.energyclient.module.miscellaneous.AutoDuel;
import su.energyclient.module.miscellaneous.AutoDupe;
import su.energyclient.module.miscellaneous.AutoPvp;
import su.energyclient.module.miscellaneous.ClickFriend;
import su.energyclient.module.miscellaneous.ClientSounds;
import su.energyclient.module.miscellaneous.CrystalOptimizer;
import su.energyclient.module.miscellaneous.DeathCoords;
import su.energyclient.module.miscellaneous.ElytraHelper;
import su.energyclient.module.miscellaneous.Fixhp;
import su.energyclient.module.miscellaneous.FullBright;
import su.energyclient.module.miscellaneous.FuntimeHelper;
import su.energyclient.module.miscellaneous.HolyworldHelper;
import su.energyclient.module.miscellaneous.KeyFinderTeleport;
import su.energyclient.module.miscellaneous.LonygriefHelper;
import su.energyclient.module.miscellaneous.LootAlert;
import su.energyclient.module.miscellaneous.NameProtect;
import su.energyclient.module.miscellaneous.ObsidianFarm;
import su.energyclient.module.miscellaneous.PotionCombiner;
import su.energyclient.module.miscellaneous.PotionTracker;
import su.energyclient.module.miscellaneous.ReallyworldHelper;
import su.energyclient.module.miscellaneous.SmartHelper;
import su.energyclient.module.miscellaneous.SrpSpoofer;
import su.energyclient.module.miscellaneous.StaffExploit;
import su.energyclient.module.miscellaneous.TapeMouse;
import su.energyclient.module.miscellaneous.TickrateSync;
import su.energyclient.module.miscellaneous.UseTracker;
import su.energyclient.module.movement.AirStuck;
import su.energyclient.module.movement.AntiPredict;
import su.energyclient.module.movement.AutoSprint;
import su.energyclient.module.movement.DamageSpeed;
import su.energyclient.module.movement.Disabler;
import su.energyclient.module.movement.DragonFly;
import su.energyclient.module.movement.ElytraBooster;
import su.energyclient.module.movement.ElytraDesync;
import su.energyclient.module.movement.ElytraExploit;
import su.energyclient.module.movement.ElytraResolver;
import su.energyclient.module.movement.ElytraSample;
import su.energyclient.module.movement.ElytraWhatsapp;
import su.energyclient.module.movement.FreeCamera;
import su.energyclient.module.movement.GrimHop;
import su.energyclient.module.movement.GuiMove;
import su.energyclient.module.movement.NoClip;
import su.energyclient.module.movement.NoFallExploit;
import su.energyclient.module.movement.NoJumpDelay;
import su.energyclient.module.movement.NoPush;
import su.energyclient.module.movement.NoSlow;
import su.energyclient.module.movement.NoWeb;
import su.energyclient.module.movement.PlayerFakelags;
import su.energyclient.module.movement.ShulkerJump;
import su.energyclient.module.movement.SpearExploit;
import su.energyclient.module.movement.SpeedExploit;
import su.energyclient.module.movement.Timer;
import su.energyclient.module.movement.WindHop;
import su.energyclient.module.player.AimingItems;
import su.energyclient.module.player.AutoTool;
import su.energyclient.module.player.ClickPearl;
import su.energyclient.module.player.FastBreak;
import su.energyclient.module.player.FastExpBottle;
import su.energyclient.module.player.ItemScroller;
import su.energyclient.module.player.ItemsCooldown;
import su.energyclient.module.player.KillMessage;
import su.energyclient.module.player.KtLeave;
import su.energyclient.module.player.NoInteract;
import su.energyclient.module.player.PearlTarget;
import su.energyclient.module.render.Ambience;
import su.energyclient.module.render.Animations;
import su.energyclient.module.render.AspectRatio;
import su.energyclient.module.render.BlockEsp;
import su.energyclient.module.render.BlockHighlight;
import su.energyclient.module.render.CabbitTarget;
import su.energyclient.module.render.ChinaHat;
import su.energyclient.module.render.CosmicSwarm;
import su.energyclient.module.render.Dashtrail;
import su.energyclient.module.render.Fakeplayer;
import su.energyclient.module.render.FireworkEsp;
import su.energyclient.module.render.Fogblur;
import su.energyclient.module.render.Holeesp;
import su.energyclient.module.render.Interface;
import su.energyclient.module.render.InvisibleOpacity;
import su.energyclient.module.render.JumpCircle;
import su.energyclient.module.render.KillEffect;
import su.energyclient.module.render.Lineglyphs;
import su.energyclient.module.render.LootTracker;
import su.energyclient.module.render.Notifications;
import su.energyclient.module.render.Particles;
import su.energyclient.module.render.PlayerAlert;
import su.energyclient.module.render.Prediction;
import su.energyclient.module.render.Removals;
import su.energyclient.module.render.ShaderEsp;
import su.energyclient.module.render.Shaderhands;
import su.energyclient.module.render.Shadersky;
import su.energyclient.module.render.ShulkerPreview;
import su.energyclient.module.render.Sonar;
import su.energyclient.module.render.SwordAnimations;
import su.energyclient.module.render.Tags;
import su.energyclient.module.render.TargetEsp;
import su.energyclient.module.render.Trails;
import su.energyclient.module.render.Trajectory;
import su.energyclient.module.render.Triangle;
import su.energyclient.module.render.ViewModel;
import su.energyclient.module.render.Wings;
import su.energyclient.util.Util10;
import su.energyclient.util.Util164;
import su.energyclient.util.Util170;
import su.energyclient.util.Util36;
import su.energyclient.util.Util39;
import su.energyclient.util.Util54;

public class ModuleManager extends Manager<Module> {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private boolean f_2541;
   private boolean f_2542;
   private boolean f_2543;
   private float f_2544 = 0.0F;
   private boolean f_2545;
   private Util10 f_2546;
   public AttackAura attackAura;
   public AimBot aimBot;
   public Velocity velocity;
   public Criticals criticals;
   public FastCriticals fastCriticals;
   public Macetarget macetarget;
   public AutoSwap autoSwap;
   public AutoTotem autoTotem;
   public AutoSprint autoSprint;
   public ElytraSample elytraSample;
   public ElytraResolver elytraResolver;
   public ElytraBooster elytraBooster;
   public GuiMove guiMove;
   public ElytraHelper elytraHelper;
   public Interface moduleInterface;
   public Animations animations;
   public Tags tags;
   public Sonar sonar;
   public Shaderhands shaderhands;
   public Fogblur fogblur;
   public BlockHighlight blockHighlight;
   public LootTracker lootTracker;
   public ShulkerPreview shulkerPreview;
   public SwordAnimations swordAnimations;
   public Notifications notifications;
   public InvisibleOpacity invisibleOpacity;
   public Timer timer;
   public FullBright fullBright;
   public Fixhp fixhp;
   public CrystalOptimizer crystalOptimizer;
   public ClientSounds clientSounds;
   public NameProtect nameProtect;
   public AutoBuy autoBuy;
   public LootAlert lootAlert;
   public UseTracker useTracker;
   public TickrateSync tickrateSync;
   public Disabler disabler;
   public StaffExploit staffExploit;
   private static final String f_2547 = "HolyWorld";
   private static final String f_2548 = "Ares/FT";
   private static final float f_2549 = 180.0F;
   private static final float f_2550 = 0.009F;
   private static final float f_2551 = 0.2F;
   private static final float f_2552 = 0.009F;
   private static final float f_2553 = -0.2F;
   private static final float f_2554 = 20.0F;
   private static final float f_2555 = 5.0F;
   private static final float f_2556 = 9.0F;
   private static final float f_2557 = 9.0F;
   private static final float f_2558 = 5.0F;
   private static final float f_2559 = 5.0F;
   private static final float f_2560 = 0.1F;
   private static final float f_2561 = 0.2F;
   private static final float f_2562 = 0.85F;
   private static final float f_2563 = 0.95F;
   private static final float f_2564 = 20.0F;
   private static final float f_2565 = 20.0F;
   private static final float f_2566 = 999999.0F;
   private static final float f_2567 = 2.3F;
   private static final float f_2568 = 999999.0F;
   private static final float f_2569 = 360.0F;
   private static final float f_2570 = 360.0F;
   private static final float f_2571 = 360.0F;
   private static final float f_2572 = 360.0F;
   private static final float f_2573 = 1.5F;
   private static final float f_2574 = 0.35F;
   private static final float f_2575 = 360.0F;
   private static final float f_2576 = 360.0F;
   private static final float f_2577 = 360.0F;
   private static final float f_2578 = 360.0F;

   private float m_3006(float var1) {
      return var1 < 0.0F ? 0.0F : Math.min(var1, 1.0F);
   }

   public ModuleManager() {
      this.m_2917();
      EnergyClient.f_1622.f_1624.m_32(this);
   }

   private void m_2917() {
      this.m_3064(
         this.attackAura = new AttackAura(),
         this.aimBot = new AimBot(),
         this.velocity = new Velocity(),
         this.criticals = new Criticals(),
         this.fastCriticals = new FastCriticals(),
         new CrystalAura(),
         this.autoSwap = new AutoSwap(),
         this.autoTotem = new AutoTotem(),
         this.autoSprint = new AutoSprint(),
         this.elytraSample = new ElytraSample(),
         this.elytraResolver = new ElytraResolver(),
         this.elytraBooster = new ElytraBooster(),
         this.guiMove = new GuiMove(),
         this.moduleInterface = new Interface(),
         this.animations = new Animations(),
         this.tags = new Tags(),
         this.timer = new Timer(),
         this.fullBright = new FullBright(),
         this.elytraHelper = new ElytraHelper(),
         this.disabler = new Disabler(),
         this.fixhp = new Fixhp(),
         this.crystalOptimizer = new CrystalOptimizer(),
         this.clientSounds = new ClientSounds(),
         this.nameProtect = new NameProtect(),
         this.blockHighlight = new BlockHighlight(),
         this.shulkerPreview = new ShulkerPreview(),
         this.sonar = new Sonar(),
         this.fogblur = new Fogblur(),
         this.autoBuy = new AutoBuy(),
         this.lootAlert = new LootAlert(),
         this.invisibleOpacity = new InvisibleOpacity(),
         this.useTracker = new UseTracker(),
         this.notifications = new Notifications(),
         this.tickrateSync = new TickrateSync(),
         new NoSlotChange(),
         new DamageSpeed(),
         new AutoDupe(),
         new AutoDuel(),
         new ClickFriend(),
         new SpearExploit(),
         new DragonFly(),
         new AutoExplosion(),
         new AntiBot(),
         new AntiThorns(),
         new NoFriendDamage(),
         new WebTrap(),
         new BowSpammer(),
         new AspectRatio(),
         new NoFallExploit(),
         new NoPush(),
         new NoClip(),
         new Removals(),
         new NoJumpDelay(),
         new NoWeb(),
         new ReallyworldHelper(),
         new KeyFinderTeleport(),
         this.staffExploit = new StaffExploit(),
         new LonygriefHelper(),
         new HolyworldHelper(),
         new SmartHelper(),
         new TapeMouse(),
         new KillMessage(),
         new FuntimeHelper(),
         new KillEffect(),
         new ElytraWhatsapp(),
         new NoSlow(),
         new AirStuck(),
         new PlayerFakelags(),
         new AntiPredict(),
         new ElytraDesync(),
         new ClickPearl(),
         new AutoTool(),
         new NoInteract(),
         new FastBreak(),
         new FreeCamera(),
         new ItemScroller(),
         new ItemsCooldown(),
         new PearlTarget(),
         new Ambience(),
         new TargetEsp(),
         new BlockEsp(),
         new Holeesp(),
         new CabbitTarget(),
         new Trails(),
         new Dashtrail(),
         new JumpCircle(),
         new WindHop(),
         new ChinaHat(),
         new Wings(),
         new Fakeplayer(),
         this.swordAnimations = new SwordAnimations(),
         new ViewModel(),
         new Triangle(),
         new PlayerAlert(),
         new Particles(),
         new Lineglyphs(),
         new Trajectory(),
         new ShulkerJump(),
         new AutoMace(),
         this.macetarget = new Macetarget(),
         new SrpSpoofer(),
         new DeathCoords(),
         new PotionTracker(),
         new AimingItems(),
         new Prediction(),
         new FireworkEsp(),
         new CosmicSwarm(),
         this.lootTracker = new LootTracker(),
         new ElytraExploit(),
         new ShaderEsp(),
         new Shadersky(),
         this.shaderhands = new Shaderhands(),
         new KtLeave(),
         new FastExpBottle(),
         new AutoPotion(),
         new SpeedExploit(),
         new PotionCombiner(),
         new AutoBrewPotion(),
         new AutoBrewerBuilder(),
         new ObsidianFarm(),
         new GrimHop(),
         new AutoAccept(),
         new AutoPvp()
      );
   }

   private void m_3228() {
      Util54 var1 = Util54.m_1085();
      if (this.f_2546 != null && var1.m_340() == this.f_2546 && var1.m_2266() == 6) {
         Util54.m_2145(null, f_2575, f_2576, f_2577, f_2578, 0, 6, false);
      }

      this.f_2545 = false;
      this.f_2546 = null;
   }

   public Optional<Module> m_887(String var1) {
      return this.m_3515().stream().filter(var1x -> var1x.m_1199().equalsIgnoreCase(var1)).findFirst();
   }

   private void m_3064(Module... var1) {
      this.m_3515().addAll(Arrays.asList(var1));
   }

   @EventHandler
   public void m_2651(Util164 var1) {
      if (!Macetarget.m_329()) {
         if (QuickImports.f_5909.player != null && QuickImports.f_5909.world != null) {
            AttackAura var2 = this.attackAura;
            if (var2 == null) {
               this.m_3228();
               this.f_2541 = false;
               this.f_2542 = false;
            } else {
               boolean var3 = var2.m_2597().m_2073(f_2547);
               boolean var4 = var2.m_2597().m_2073(f_2548);
               boolean var5 = var2.m_891() != null;
               if (var4 && var5) {
                  this.f_2545 = true;
                  this.f_2546 = null;
               } else if (!var4) {
                  this.m_3228();
               }

               boolean var6 = !var5 && (var3 || var4 && this.f_2545);
               if (!var6) {
                  this.f_2541 = false;
                  this.f_2542 = false;
               } else {
                  Util10 var7 = new Util10(QuickImports.f_5909.gameRenderer.getCamera().getYaw(), QuickImports.f_5909.gameRenderer.getCamera().getPitch());
                  if (QuickImports.f_5909.options.getPerspective() == Perspective.THIRD_PERSON_FRONT) {
                     var7 = new Util10(QuickImports.f_5909.gameRenderer.getCamera().getYaw() + f_2549, -QuickImports.f_5909.gameRenderer.getCamera().getPitch());
                  }

                  if (!this.f_2543) {
                     this.f_2544 = this.f_2544 + f_2550;
                     if (this.f_2544 > f_2551) {
                        this.f_2543 = true;
                     }
                  } else {
                     this.f_2544 = this.f_2544 - f_2552;
                     if (this.f_2544 < f_2553) {
                        this.f_2543 = false;
                     }
                  }

                  if (!this.f_2542) {
                     var7.m_3216(var7.m_2643() + this.f_2544 * f_2554);
                     var7.m_1782(var7.m_2573() + this.f_2544 * f_2555);
                  }

                  float var8 = MathHelper.wrapDegrees(var7.m_2643() - QuickImports.f_5909.player.getYaw());
                  float var9 = var7.m_2573() - QuickImports.f_5909.player.getPitch();
                  if (Math.abs(var8) <= f_2556 && Math.abs(var9) <= f_2557) {
                     this.f_2541 = true;
                  }

                  if (Math.abs(var8) <= f_2558 && Math.abs(var9) <= f_2559) {
                     this.f_2542 = true;
                  }

                  double var10 = QuickImports.f_5909.mouse.cursorDeltaX;
                  double var12 = QuickImports.f_5909.mouse.cursorDeltaY;
                  float var14 = (float)Math.hypot(var10, var12);
                  float var15 = Util39.m_2499(f_2560, f_2561);
                  float var16 = Util39.m_2499(f_2562, f_2563);
                  float var17 = f_2564;
                  float var18 = this.m_3006(var15 + var16 * this.m_3006(var14 / f_2565));
                  if (this.f_2542) {
                     var18 = 1.0F;
                  }

                  float var19 = Math.abs(var8);
                  float var20 = Math.abs(var9);
                  float var21 = MathHelper.clamp(var19 * var18, 0.0F, f_2566);
                  float var22 = MathHelper.clamp(var20 * var18 / f_2567, 0.0F, f_2568);
                  float var23 = MathHelper.clamp(var8, -var21, var21);
                  float var24 = MathHelper.clamp(var9, -var22, var22);
                  float var25 = QuickImports.f_5909.player.getYaw() + var23;
                  float var26 = QuickImports.f_5909.player.getPitch() + var24;
                  var25 -= (var25 - QuickImports.f_5909.player.getYaw()) % Util36.m_399();
                  var26 -= (var26 - QuickImports.f_5909.player.getPitch()) % Util36.m_399();
                  Util10 var27 = new Util10(var25, var26);
                  int var28 = var4 ? 6 : 4;
                  Util54.m_2145(var27, f_2569, f_2570, f_2571, f_2572, 0, var28, false);
                  if (var4) {
                     Util54 var29 = Util54.m_1085();
                     if (var29.m_340() == var27) {
                        this.f_2546 = var27;
                        float var30 = Math.max(Util36.m_399() * f_2573, f_2574);
                        float var31 = Math.abs(MathHelper.wrapDegrees(var7.m_2643() - QuickImports.f_5909.player.getYaw()));
                        float var32 = Math.abs(var7.m_2573() - QuickImports.f_5909.player.getPitch());
                        if (this.f_2542 && var31 <= var30 && var32 <= var30) {
                           var29.m_2951();
                           this.f_2545 = false;
                           this.f_2546 = null;
                           this.f_2541 = true;
                           this.f_2542 = false;
                        }
                     }
                  }
               }
            }
         } else {
            this.f_2545 = false;
            this.f_2546 = null;
            this.f_2541 = false;
            this.f_2542 = false;
         }
      }
   }

   @EventHandler(
      priority = -200
   )
   public void m_2076(Util170 var1) {
      if (this.attackAura != null) {
         this.attackAura.m_1616();
      }
   }
}
