package su.energyclient.util;

import net.minecraft.client.util.math.MatrixStack;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4f;

public final class Util7 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private Util7() {
   }

   public static Matrix4f m_1924(Matrix3x2fc var0) {
      return new Matrix4f().m00(var0.m00()).m01(var0.m01()).m10(var0.m10()).m11(var0.m11()).m30(var0.m20()).m31(var0.m21());
   }

   public static MatrixStack m_2022(Matrix3x2fc var0) {
      MatrixStack var1 = new MatrixStack();
      var1.peek().getPositionMatrix().set(m_1924(var0));
      return var1;
   }
}
