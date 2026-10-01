package su.energyclient.util;

import java.util.function.Consumer;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.util.Identifier;
import su.energyclient.QuickImports;
import su.energyclient.render.RenderUtil28;
import su.energyclient.render.RenderUtil6;

public class Util139 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public String f_10504;
   public String f_10505;
   public Util134 f_10506;
   public Framebuffer f_10507;
   public Framebuffer f_10508;
   public boolean f_10509 = false;
   private static final String f_10510 = "energy";
   private static final String f_10511 = "bufIn";
   private static final String f_10512 = "bufOut";
   private static final String f_10513 = "PrevSampler";
   private static final String f_10514 = "GameTime";
   private static final String f_10515 = "ModelViewMat";
   private static final String f_10516 = "bufIn";
   private static final String f_10517 = "bufOut";
   private static final String f_10518 = "bufIn";
   private static final String f_10519 = "bufOut";

   public void m_2339() {
      if (!this.f_10509) {
         this.f_10507 = new SimpleFramebuffer(null, f_5909.getWindow().getFramebufferWidth(), f_5909.getWindow().getFramebufferHeight(), false);
         this.f_10508 = new SimpleFramebuffer(null, f_5909.getWindow().getFramebufferWidth(), f_5909.getWindow().getFramebufferHeight(), false);
         this.f_10506 = new Util134(Identifier.of(this.f_10505, this.f_10504 + ".json"));
         this.f_10506.m_1485(f_10511, this.f_10507);
         this.f_10506.m_1485(f_10512, this.f_10508);
         this.f_10509 = true;
      }
   }

   public void m_533() {
      Util114.m_1481();
      RenderUtil6.m_4071(this.f_10507, false);
      RenderUtil28.f_1130 = false;
   }

   public void m_410() {
      RenderUtil28.f_1130 = true;
      Util114.m_963();
      RenderUtil6.m_2660(this.f_10507);
      RenderUtil6.m_4071(f_5909.getFramebuffer(), false);
   }

   public Util139(String var1) {
      this(f_10510, var1);
   }

   public void m_222(Consumer<Util134.AUOfBKNWVIeMtDlp> var1) {
      for (Util134.Inner_9mk4GwN4EhqDDhDZ var3 : this.f_10506.f_10572) {
         var1.accept(var3.f_11013);
      }
   }

   public Util139(String var1, String var2) {
      this.f_10505 = var1;
      this.f_10504 = var2;
   }

   public void m_1079() {
      this.f_10506.m_1485(f_10516, f_5909.getFramebuffer());
      this.f_10506.m_1485(f_10517, f_5909.getFramebuffer());
      this.m_487();
      this.f_10506.m_254();
   }

   public void m_843() {
      this.f_10506.m_1485(f_10518, this.f_10507);
      this.f_10506.m_1485(f_10519, this.f_10508);
      this.m_487();
      this.f_10506.m_254();
      Util114.m_1562();
      Util114.m_1481();
      Util114.m_542();
      RenderUtil6.m_4071(f_5909.getFramebuffer(), false);
      RenderUtil28.m_2280(this.f_10508, f_5909.getWindow().getFramebufferWidth(), f_5909.getWindow().getFramebufferHeight());
      Util114.m_963();
      Util114.m_542();
      RenderUtil6.m_676(this.f_10507);
      RenderUtil6.m_676(this.f_10508);
      RenderUtil6.m_4071(f_5909.getFramebuffer(), false);
   }

   public void m_487() {
      for (Util134.Inner_9mk4GwN4EhqDDhDZ var2 : this.f_10506.f_10572) {
         var2.f_11013.m_1503(f_10513, () -> RenderUtil6.m_668(this.f_10507.getColorAttachment()));
         var2.f_11013.m_3395(f_10514).O(Util114.m_3256());
         var2.f_11013.m_3395(f_10515).m_23(Util114.m_1712());
      }
   }

   public void m_2553(int var1, int var2) {
      this.f_10507.resize(var1, var2);
      this.f_10508.resize(var1, var2);
      this.f_10506.m_3602(var1, var2);
   }
}
