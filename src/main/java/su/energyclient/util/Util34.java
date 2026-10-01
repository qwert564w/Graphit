package su.energyclient.util;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.util.math.MathHelper;

public final class Util34 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final int f_7725 = 9;
   private static final float f_7726 = 0.0F;
   private static final int f_7727 = 0;
   private static final int f_7728 = 0;
   private static final int f_7729 = 0;
   private static final int f_7730 = 0;
   private static final long f_7731 = 0L;
   private static final long f_7732 = 0L;
   private static final long f_7733 = 0L;
   private static final int f_7734 = 0;
   private final int[] f_7735 = new int[9];
   private final int[] f_7736 = new int[9];
   private final Deque<Util34.TXup14kZxMQBfUEp> f_7737 = new ArrayDeque<>();
   private final Deque<Util34.PJTndIh3nC5TNSU5> f_7738 = new ArrayDeque<>();
   private long f_7739 = m_3405(100);
   private static final long f_7740 = 3000000000L;
   private static final long f_7741 = 150000000L;
   private static final long f_7742 = 500000000L;
   private static final long f_7743 = 2L;
   private static final long f_7744 = 3000000000L;
   private static final float f_7745 = 100.0F;
   private static final long f_7746 = 1000000L;
   private static final float f_7747 = 90.0F;
   private static final float f_7748 = 180.0F;
   private static final float f_7749 = 45.0F;
   private static final float f_7750 = 90.0F;
   private static final float f_7751 = 5.0F;

   private static long m_3405(int var0) {
      return var0 * f_7746;
   }

   private static int m_3284(float var0) {
      float var1 = Math.abs(MathHelper.wrapDegrees(var0));
      if (var1 > f_7747) {
         var1 = f_7748 - var1;
      }

      if (var1 > f_7749) {
         var1 = f_7750 - var1;
      }

      return MathHelper.clamp((int)(var1 / f_7751), 0, 8);
   }

   private void m_3629() {
      this.f_7737.clear();
      this.f_7738.clear();
      this.f_7739 = m_3405(100);
   }

   public synchronized void m_2419() {
      Util34.TXup14kZxMQBfUEp var1 = this.f_7737.peekLast();
      long var2 = System.nanoTime();
      if (var1 != null && var2 - var1.timestampNanos() <= f_7740) {
         this.f_7738.addLast(new Util34.PJTndIh3nC5TNSU5(var2, this.f_7739));
      }
   }

   private static int m_3195(int var0) {
      return Math.max(0, var0 - 1);
   }

   private void m_1463() {
      Util34.PJTndIh3nC5TNSU5 var1;
      while ((var1 = this.f_7738.pollFirst()) != null) {
         long var2 = var1.receivedAtNanos() - var1.correctionDelayNanos();
         long var4 = Math.max(f_7741, Math.min(f_7742, var1.correctionDelayNanos() / f_7743));
         Util34.TXup14kZxMQBfUEp var6 = this.m_2147(var2, var4);
         if (var6 != null) {
            int var7 = var6.yawBucket();
            int var8 = var6.pitchBucket();
            this.f_7735[var7] = m_3195(this.f_7735[var7]);
            this.f_7736[var8] = m_3195(this.f_7736[var8]);
         }
      }
   }

   private Util34.TXup14kZxMQBfUEp m_2147(long var1, long var3) {
      Util34.TXup14kZxMQBfUEp var5 = null;
      long var6 = var3 + 1L;

      for (Util34.TXup14kZxMQBfUEp var9 : this.f_7737) {
         long var10 = Math.abs(var9.timestampNanos() - var1);
         if (var10 < var6) {
            var5 = var9;
            var6 = var10;
         }
      }

      return var5;
   }

   private synchronized Util34.mLtmL0uyhGuxQYhV m_2564(float var1, float var2, int var3) {
      long var4 = System.nanoTime();
      this.f_7739 = m_3405(MathHelper.clamp(var3, 0, 2000));
      this.m_1271(var4);
      this.m_1463();
      int var6 = m_3284(var1);
      int var7 = m_3284(var2);
      this.f_7737.addLast(new Util34.TXup14kZxMQBfUEp(var4, var6, var7));

      while (this.f_7737.size() > 128) {
         this.f_7737.removeFirst();
      }

      return new Util34.mLtmL0uyhGuxQYhV(m_2403(this.f_7735[var6]), m_2403(this.f_7736[var7]));
   }

   private static float m_2403(int var0) {
      return var0 / f_7745;
   }

   public synchronized void m_3322() {
      this.m_1463();
      this.m_3629();
   }

   public Util34.mLtmL0uyhGuxQYhV m_3385(ClientPlayerEntity var1) {
      PlayerListEntry var2 = var1.networkHandler == null ? null : var1.networkHandler.getPlayerListEntry(var1.getUuid());
      int var3 = var2 == null ? 100 : var2.getLatency();
      return this.m_2564(var1.getYaw(), var1.getPitch(), var3);
   }

   public synchronized void m_847() {
      Arrays.fill(this.f_7735, 300);
      Arrays.fill(this.f_7736, 300);
      this.m_3629();
   }

   private void m_1271(long var1) {
      while (!this.f_7737.isEmpty() && var1 - this.f_7737.peekFirst().timestampNanos() > f_7744) {
         this.f_7737.removeFirst();
      }
   }

   public Util34() {
      this.m_847();
   }

   private record PJTndIh3nC5TNSU5(long receivedAtNanos, long correctionDelayNanos) {
   }

   private record TXup14kZxMQBfUEp(long timestampNanos, int yawBucket, int pitchBucket) {
   }

   public record mLtmL0uyhGuxQYhV(float horizontal, float vertical) {
   }
}
