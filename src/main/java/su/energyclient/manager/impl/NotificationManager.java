package su.energyclient.manager.impl;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Arrays;
import su.energyclient.QuickImports;
import su.energyclient.util.Util43;
import su.energyclient.util.Util71;

public class NotificationManager implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private ObjectArrayList<NotificationManager.H23Ah8NaSwstUmgo> f_2845 = new ObjectArrayList();
   private NotificationManager.H23Ah8NaSwstUmgo f_2846;

   public void m_1330(NotificationManager.H23Ah8NaSwstUmgo var1) {
      this.f_2846 = var1;
   }

   public NotificationManager() {
      this.m_3236();
   }

   public NotificationManager.H23Ah8NaSwstUmgo m_3510() {
      return this.f_2846;
   }

   public void m_630(ObjectArrayList<NotificationManager.H23Ah8NaSwstUmgo> var1) {
      this.f_2845 = var1;
   }

   public ObjectArrayList<NotificationManager.H23Ah8NaSwstUmgo> m_801() {
      return this.f_2845;
   }

   private void m_3236() {
      this.f_2845.addAll(Arrays.asList(NotificationManager.H23Ah8NaSwstUmgo.CUSTOM, NotificationManager.H23Ah8NaSwstUmgo.AQUA));
      this.f_2846 = (NotificationManager.H23Ah8NaSwstUmgo)this.f_2845.get(1);
   }

   public static enum H23Ah8NaSwstUmgo {
      CUSTOM(new Util43("Кастомная настройки цвета", Util71.m_1415(165, 173, 255))),
      AQUA(new Util43("Тема кодера (моя)", Util71.m_1415(165, 173, 255)));

      final Util43 f_4126;

      private H23Ah8NaSwstUmgo(Util43 var3) {
         this.f_4126 = var3;
      }

      public Util43 m_3941() {
         return this.f_4126;
      }
   }
}
