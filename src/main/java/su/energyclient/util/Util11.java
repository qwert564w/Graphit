package su.energyclient.util;

public final class Util11 {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public static final double f_2922 = 1.70158;
   public static final double f_2923 = 0.0;
   public static final double f_2924 = 0.0;
   public static final double f_2925 = 0.0;
   public static final double f_2926 = 0.0;
   public static final Util97 f_2927 = var0 -> var0;
   public static final Util97 f_2928 = m_908(2);
   public static final Util97 f_2929 = m_3567(2);
   public static final Util97 f_2930 = m_2931(Util11.f_3062);
   public static final Util97 f_2931 = m_908(3);
   public static final Util97 l = m_3567(3);
   public static final Util97 f_2932 = m_2931(Util11.f_3063);
   public static final Util97 f_2933 = m_908(4);
   public static final Util97 f_2934 = m_3567(4);
   public static final Util97 f_2935 = m_2931(Util11.f_3064);
   public static final Util97 f_2936 = m_908(5);
   public static final Util97 f_2937 = m_3567(5);
   public static final Util97 f_2938 = m_2931(Util11.f_3065);
   public static final Util97 f_2939 = var0 -> 1.0 - Math.cos(var0 * Util11.f_3060 / Util11.f_3061);
   public static final Util97 f_2940 = var0 -> Math.sin(var0 * Util11.f_3058 / Util11.f_3059);
   public static final Util97 f_2941 = var0 -> -(Math.cos(Util11.f_3056 * var0) - 1.0) / Util11.f_3057;
   public static final Util97 f_2942 = var0 -> 1.0 - Math.sqrt(1.0 - Math.pow(var0, Util11.f_3055));
   public static final Util97 f_2943 = var0 -> Math.sqrt(1.0 - Math.pow(var0 - 1.0, Util11.f_3054));
   public static final Util97 f_2944 = var0 -> var0 < Util11.f_3046
      ? (1.0 - Math.sqrt(1.0 - Math.pow(Util11.f_3047 * var0, Util11.f_3048))) / Util11.f_3049
      : (Math.sqrt(1.0 - Math.pow(Util11.f_3050 * var0 + Util11.f_3051, Util11.f_3052)) + 1.0) / Util11.f_3053;
   public static final Util97 f_2945 = var0 -> var0 != 0.0 && var0 != 1.0
      ? Math.pow(Util11.f_3040, Util11.f_3041 * var0 - Util11.f_3042) * Math.sin((var0 * Util11.f_3043 - Util11.f_3044) * Util11.f_3045)
      : var0;
   public static final Util97 f_2946 = var0 -> var0 != 0.0 && var0 != 1.0
      ? Math.pow(Util11.f_3035, Util11.f_3036 * var0) * Math.sin((var0 * Util11.f_3037 - Util11.f_3038) * Util11.f_3039) + 1.0
      : var0;
   public static final Util97 f_2947 = var0 -> {
      if (var0 != 0.0 && var0 != 1.0) {
         return var0 < Util11.f_3020
            ? -(Math.pow(Util11.f_3021, Util11.f_3022 * var0 - Util11.f_3023) * Math.sin((Util11.f_3024 * var0 - Util11.f_3025) * Util11.f_3026))
               / Util11.f_3027
            : Math.pow(Util11.f_3028, Util11.f_3029 * var0 + Util11.f_3030) * Math.sin((Util11.f_3031 * var0 - Util11.f_3032) * Util11.f_3033) / Util11.f_3034
               + 1.0;
      } else {
         return var0;
      }
   };
   public static final Util97 f_2948 = var0 -> var0 != 0.0 ? Math.pow(Util11.f_3017, Util11.f_3018 * var0 - Util11.f_3019) : var0;
   public static final Util97 f_2949 = var0 -> var0 != 1.0 ? 1.0 - Math.pow(Util11.f_3015, Util11.f_3016 * var0) : var0;
   public static final Util97 f_2950 = var0 -> {
      if (var0 != 0.0 && var0 != 1.0) {
         return var0 < Util11.f_3005
            ? Math.pow(Util11.f_3006, Util11.f_3007 * var0 - Util11.f_3008) / Util11.f_3009
            : (Util11.f_3010 - Math.pow(Util11.f_3011, Util11.f_3012 * var0 + Util11.f_3013)) / Util11.f_3014;
      } else {
         return var0;
      }
   };
   public static final Util97 f_2951 = var0 -> Util11.f_3001 * Math.pow(var0, Util11.f_3002) - Util11.f_3003 * Math.pow(var0, Util11.f_3004);
   public static final Util97 f_2952 = var0 -> 1.0 + Util11.f_2997 * Math.pow(var0 - 1.0, Util11.f_2998) + Util11.f_2999 * Math.pow(var0 - 1.0, Util11.f_3000);
   public static final Util97 f_2953 = var0 -> var0 < Util11.f_2982
      ? Math.pow(Util11.f_2983 * var0, Util11.f_2984) * (Util11.f_2985 * var0 - Util11.f_2986) / Util11.f_2987
      : (
            Math.pow(Util11.f_2988 * var0 - Util11.f_2989, Util11.f_2990) * (Util11.f_2991 * (var0 * Util11.f_2992 - Util11.f_2993) + Util11.f_2994)
               + Util11.f_2995
         )
         / Util11.f_2996;
   public static final Util97 f_2954 = var0 -> {
      double var2 = Util11.f_2968;
      double var4 = Util11.f_2969;
      if (var0 < 1.0 / var4) {
         return var2 * Math.pow(var0, Util11.f_2970);
      } else if (var0 < Util11.f_2971 / var4) {
         return var2 * Math.pow(var0 - Util11.f_2972 / var4, Util11.f_2973) + Util11.f_2974;
      } else {
         return var0 < Util11.f_2975 / var4
            ? var2 * Math.pow(var0 - Util11.f_2976 / var4, Util11.f_2977) + Util11.f_2978
            : var2 * Math.pow(var0 - Util11.f_2979 / var4, Util11.f_2980) + Util11.f_2981;
      }
   };
   public static final Util97 f_2955 = var0 -> 1.0 - f_2954.m_1934(1.0 - var0);
   public static final Util97 f_2956 = var0 -> var0 < Util11.f_2963
      ? (1.0 - f_2954.m_1934(1.0 - Util11.f_2964 * var0)) / Util11.f_2965
      : (1.0 + f_2954.m_1934(Util11.f_2966 * var0 - 1.0)) / Util11.f_2967;
   private static final String f_2957 = "This is a utility class and cannot be instantiated";
   private static final double f_2958 = 0.5;
   private static final double f_2959 = 2.0;
   private static final double f_2960 = -2.0;
   private static final double f_2961 = 2.0;
   private static final double f_2962 = 2.0;
   private static final double f_2963 = 0.5;
   private static final double f_2964 = 2.0;
   private static final double f_2965 = 2.0;
   private static final double f_2966 = 2.0;
   private static final double f_2967 = 2.0;
   private static final double f_2968 = 7.5625;
   private static final double f_2969 = 2.75;
   private static final double f_2970 = 2.0;
   private static final double f_2971 = 2.0;
   private static final double f_2972 = 1.5;
   private static final double f_2973 = 2.0;
   private static final double f_2974 = 0.75;
   private static final double f_2975 = 2.5;
   private static final double f_2976 = 2.25;
   private static final double f_2977 = 2.0;
   private static final double f_2978 = 0.9375;
   private static final double f_2979 = 2.625;
   private static final double f_2980 = 2.0;
   private static final double f_2981 = 0.984375;
   private static final double f_2982 = 0.5;
   private static final double f_2983 = 2.0;
   private static final double f_2984 = 2.0;
   private static final double f_2985 = 7.189819;
   private static final double f_2986 = 2.5949095;
   private static final double f_2987 = 2.0;
   private static final double f_2988 = 2.0;
   private static final double f_2989 = 2.0;
   private static final double f_2990 = 2.0;
   private static final double f_2991 = 3.5949095;
   private static final double f_2992 = 2.0;
   private static final double f_2993 = 2.0;
   private static final double f_2994 = 2.5949095;
   private static final double f_2995 = 2.0;
   private static final double f_2996 = 2.0;
   private static final double f_2997 = 2.70158;
   private static final double f_2998 = 3.0;
   private static final double f_2999 = 1.70158;
   private static final double f_3000 = 2.0;
   private static final double f_3001 = 2.70158;
   private static final double f_3002 = 3.0;
   private static final double f_3003 = 1.70158;
   private static final double f_3004 = 2.0;
   private static final double f_3005 = 0.5;
   private static final double f_3006 = 2.0;
   private static final double f_3007 = 20.0;
   private static final double f_3008 = 10.0;
   private static final double f_3009 = 2.0;
   private static final double f_3010 = 2.0;
   private static final double f_3011 = 2.0;
   private static final double f_3012 = -20.0;
   private static final double f_3013 = 10.0;
   private static final double f_3014 = 2.0;
   private static final double f_3015 = 2.0;
   private static final double f_3016 = -10.0;
   private static final double f_3017 = 2.0;
   private static final double f_3018 = 10.0;
   private static final double f_3019 = 10.0;
   private static final double f_3020 = 0.5;
   private static final double f_3021 = 2.0;
   private static final double f_3022 = 20.0;
   private static final double f_3023 = 10.0;
   private static final double f_3024 = 20.0;
   private static final double f_3025 = 11.125;
   private static final double f_3026 = Math.PI * 4.0 / 9.0;
   private static final double f_3027 = 2.0;
   private static final double f_3028 = 2.0;
   private static final double f_3029 = -20.0;
   private static final double f_3030 = 10.0;
   private static final double f_3031 = 20.0;
   private static final double f_3032 = 11.125;
   private static final double f_3033 = Math.PI * 4.0 / 9.0;
   private static final double f_3034 = 2.0;
   private static final double f_3035 = 2.0;
   private static final double f_3036 = -10.0;
   private static final double f_3037 = 10.0;
   private static final double f_3038 = 0.75;
   private static final double f_3039 = Math.PI * 2.0 / 3.0;
   private static final double f_3040 = -2.0;
   private static final double f_3041 = 10.0;
   private static final double f_3042 = 10.0;
   private static final double f_3043 = 10.0;
   private static final double f_3044 = 10.75;
   private static final double f_3045 = Math.PI * 2.0 / 3.0;
   private static final double f_3046 = 0.5;
   private static final double f_3047 = 2.0;
   private static final double f_3048 = 2.0;
   private static final double f_3049 = 2.0;
   private static final double f_3050 = -2.0;
   private static final double f_3051 = 2.0;
   private static final double f_3052 = 2.0;
   private static final double f_3053 = 2.0;
   private static final double f_3054 = 2.0;
   private static final double f_3055 = 2.0;
   private static final double f_3056 = Math.PI;
   private static final double f_3057 = 2.0;
   private static final double f_3058 = Math.PI;
   private static final double f_3059 = 2.0;
   private static final double f_3060 = Math.PI;
   private static final double f_3061 = 2.0;
   private static final double f_3062 = 2.0;
   private static final double f_3063 = 3.0;
   private static final double f_3064 = 4.0;
   private static final double f_3065 = 5.0;

   public static Util97 m_2931(double var0) {
      return var2 -> var2 < f_2958 ? Math.pow(f_2959, var0 - 1.0) * Math.pow(var2, var0) : 1.0 - Math.pow(f_2960 * var2 + f_2961, var0) / f_2962;
   }

   public static Util97 m_908(int var0) {
      return m_168(var0);
   }

   public static Util97 m_168(double var0) {
      return var2 -> Math.pow(var2, var0);
   }

   public static Util97 m_3567(int var0) {
      return m_1416(var0);
   }

   public static Util97 m_1416(double var0) {
      return var2 -> 1.0 - Math.pow(1.0 - var2, var0);
   }

   private Util11() {
      throw new UnsupportedOperationException(f_2957);
   }
}
