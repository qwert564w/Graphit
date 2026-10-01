package su.energyclient.util;

import su.energyclient.QuickImports;

public enum Util40 implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   A("A", 65),
   B("B", 66),
   C("C", 67),
   D("D", 68),
   E("E", 69),
   F("F", 70),
   G("G", 71),
   H("H", 72),
   I("I", 73),
   J("J", 74),
   K("K", 75),
   L("L", 76),
   M("M", 77),
   N("N", 78),
   O("O", 79),
   P("P", 80),
   Q("Q", 81),
   R("R", 82),
   S("S", 83),
   T("T", 84),
   U("U", 85),
   V("V", 86),
   W("W", 87),
   X("X", 88),
   Y("Y", 89),
   Z("Z", 90),
   ZERO("0", 48),
   ONE("1", 49),
   TWO("2", 50),
   THREE("3", 51),
   FOUR("4", 52),
   FIVE("5", 53),
   SIX("6", 54),
   SEVEN("7", 55),
   EIGHT("8", 56),
   NINE("9", 57),
   F1("F1", 290),
   F2("F2", 291),
   F3("F3", 292),
   F4("F4", 293),
   F5("F5", 294),
   F6("F6", 295),
   F7("F7", 296),
   F8("F8", 297),
   F9("F9", 298),
   F10("F10", 299),
   F11("F11", 300),
   F12("F12", 301),
   NUM1("NUM1", 321),
   NUM2("NUM2", 322),
   NUM3("NUM3", 323),
   NUM4("NUM4", 324),
   NUM5("NUM5", 325),
   NUM6("NUM6", 326),
   NUM7("NUM7", 327),
   NUM8("NUM8", 328),
   NUM9("NUM9", 329),
   SPACE("SPCE", 32),
   ENTER("ENTR", 257),
   ESC("ESC", 256),
   LSHIFT("LSHF", 340),
   RSHIFT("RSHF", 344),
   LCTRL("LCTR", 341),
   RCTRL("RCTR", 345),
   LALT("LALT", 342),
   RALT("RALT", 346),
   LSUPER("LSUP", 343),
   RSUPER("RSUP", 347),
   UP("UP", 265),
   DOWN("DOWN", 264),
   LEFT("LEFT", 263),
   RIGHT("RIGHT", 262),
   BACK("BACK", 259),
   HOME("HOME", 268),
   INS("INS", 260),
   DEL("DEL", 261),
   END("END", 269),
   PUP("PUP", 266),
   TAB("TAB", 258),
   PDOWN("PDWN", 267),
   MENU("MENU", 348),
   CAPS("CAPS", 280),
   NUM("NUM", 282),
   SCROL("SCRL", 281),
   KP_DECIMAL("DCML", 330),
   KP_DIVIDE("DVDE", 331),
   KP_MULTIPLY("MULT", 332),
   KP_SUBTRACT("SUBT", 333),
   KP_PLUS("PLUS", 334),
   KP_ENTER("ENTR", 335),
   KP_EQUAL("EQUL", 336),
   APOSTROPHE("'", 39),
   SLASH("/", 47),
   MINUS("-", 45),
   PLUS("+", 61),
   BACKSLASH("SLSH", 92),
   PERIOD(".", 46),
   COMMA("COMA", 44),
   PAUSE("PAUS", 284),
   GRAVE("`", 96),
   MOUSE_LEFT("LMB", m_3418(0), true),
   MOUSE_RIGHT("RMB", m_3418(1), true),
   MOUSE_MIDDLE("MMB", m_3418(2), true),
   MOUSE_BUTTON_4("M4", m_3418(3), true),
   MOUSE_BUTTON_5("M5", m_3418(4), true),
   MOUSE_BUTTON_6("M6", m_3418(5), true),
   MOUSE_BUTTON_7("M7", m_3418(6), true),
   MOUSE_BUTTON_8("M8", m_3418(7), true);

   private final String f_7682;
   private final int f_7683;
   private final boolean f_7684;
   private static final int f_7685 = 100;

   private Util40(String var3, int var4) {
      this(var3, var4, false);
   }

   private Util40(String var3, int var4, boolean var5) {
      this.f_7682 = var3;
      this.f_7683 = var4;
      this.f_7684 = var5;
   }

   public static int m_3418(int var0) {
      return -(100 - var0);
   }

   public static int m_1917(int var0) {
      return var0 >= 0 && var0 <= 7 ? m_3418(var0) : var0;
   }

   public static String m_2030(int var0) {
      int var1 = m_1917(var0);

      for (Util40 var5 : values()) {
         if (var5.f_7683 == var0 || var5.f_7683 == var1) {
            return var5.f_7682;
         }
      }

      return "unk";
   }

   public static Util40 m_1690(String var0) {
      try {
         return valueOf(var0.toUpperCase());
      } catch (IllegalArgumentException var2) {
         return null;
      }
   }

   public String m_3982() {
      return this.f_7682;
   }

   public int m_3576() {
      return this.f_7683;
   }

   public boolean O8() {
      return this.f_7684;
   }
}
