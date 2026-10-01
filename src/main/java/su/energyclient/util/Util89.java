package su.energyclient.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Objects;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.sound.sampled.FloatControl.Type;
import su.energyclient.QuickImports;
import su.energyclient.manager.InitManager;

public class Util89 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_6194 = 100.0F;
   private static final double f_6195 = 20.0;

   public static void m_3138(String var0) {
      if (f_5909.player != null) {
         if (f_5909.player.getEntityWorld() != null) {
            try (AudioInputStream var1 = AudioSystem.getAudioInputStream(
                  new BufferedInputStream(Objects.requireNonNull(Util89.class.getResourceAsStream("/assets/energy/sounds/" + var0 + ".wav")))
               )) {
               AudioFormat var2 = var1.getFormat();
               AudioFormat var3 = new AudioFormat(
                  Encoding.PCM_SIGNED, var2.getSampleRate(), 16, var2.getChannels(), var2.getChannels() * 2, var2.getSampleRate(), false
               );

               try (AudioInputStream var4 = AudioSystem.getAudioInputStream(var3, var1)) {
                  Clip var5 = AudioSystem.getClip();
                  var5.open(var4);
                  m_2188(var5, InitManager.f_2740.f_2741.clientSounds.f_5041.m_4046() / f_6194);
                  var5.start();
               }
            } catch (IOException | LineUnavailableException | UnsupportedAudioFileException var11) {
               var11.printStackTrace();
            }
         }
      }
   }

   private static void m_2188(Clip var0, double var1) {
      if (var1 < 0.0) {
         var1 = 0.0;
      }

      if (var1 > 1.0) {
         var1 = 1.0;
      }

      FloatControl var3 = (FloatControl)var0.getControl(Type.MASTER_GAIN);
      float var4 = var3.getMinimum();
      float var5 = var3.getMaximum();
      if (var1 == 0.0) {
         var3.setValue(var4);
      } else {
         float var6 = (float)(f_6195 * Math.log10(var1));
         if (var6 < var4) {
            var6 = var4;
         }

         if (var6 > var5) {
            var6 = var5;
         }

         var3.setValue(var6);
      }
   }
}
