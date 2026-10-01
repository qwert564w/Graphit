package su.energyclient.module.render;

import com.mojang.blaze3d.vertex.VertexFormat.DrawMode;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.shape.VoxelShape;
import org.joml.Matrix4f;
import su.energyclient.event.EventHandler;
import su.energyclient.event.impl.EventAttack;
import su.energyclient.manager.InitManager;
import su.energyclient.module.Category;
import su.energyclient.module.Module;
import su.energyclient.module.combat.AimBot;
import su.energyclient.module.combat.AttackAura;
import su.energyclient.render.RenderUtil12;
import su.energyclient.render.RenderUtil7;
import su.energyclient.setting.impl.ModeSetting;
import su.energyclient.setting.impl.NumberSetting;
import su.energyclient.util.Util114;
import su.energyclient.util.Util153;
import su.energyclient.util.Util165;
import su.energyclient.util.Util170;
import su.energyclient.util.Util88;
import su.energyclient.util.Util89;

public class CabbitTarget extends Module {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final float f_1977 = 0.0625F;
   private static final float f_1978 = 0.0F;
   private static final float f_1979 = 0.0F;
   private static final double f_1980 = 0.0;
   private static final double f_1981 = 0.0;
   private static final int f_1982 = 0;
   private static final int f_1983 = 0;
   private static final Identifier f_1984 = Identifier.of(CabbitTarget.f_2381, CabbitTarget.f_2382);
   private static final int f_1985 = 0;
   private static final int f_1986 = 0;
   private static final int f_1987 = 0;
   private static final int f_1988 = 0;
   private static final int f_1989 = 0;
   private static final int f_1990 = 0;
   private static final int f_1991 = 0;
   private final ModeSetting f_1992;
   private final NumberSetting f_1993;
   private final NumberSetting f_1994;
   private final NumberSetting f_1995;
   private final NumberSetting f_1996;
   private double f_1997;
   private double f_1998;
   private double f_1999;
   private double f_2000;
   private double f_2001;
   private double f_2002;
   private float f_2003;
   private float f_2004;
   private boolean f_2005;
   private int f_2006;
   private float f_2007;
   private float f_2008;
   private float f_2009;
   private float f_2010;
   private float f_2011;
   private final Util165 f_2012;
   private static final String f_2013 = "Cabbit Target";
   private static final String f_2014 = "Кот-помощник Мачкин";
   private static final String f_2015 = "Мод мяуканья";
   private static final String f_2016 = "Мяу";
   private static final String f_2017 = "Мяу";
   private static final String f_2018 = "Весло";
   private static final String f_2019 = "МЁД ПО ТЕЛУ";
   private static final String f_2020 = "Штребух";
   private static final String f_2021 = "Скорость";
   private static final float f_2022 = 0.15F;
   private static final float f_2023 = 0.05F;
   private static final float f_2024 = 0.3F;
   private static final float f_2025 = 0.01F;
   private static final String f_2026 = "Размер";
   private static final float f_2027 = 0.85F;
   private static final float f_2028 = 0.3F;
   private static final float f_2029 = 1.5F;
   private static final float f_2030 = 0.05F;
   private static final String f_2031 = "Дистанция";
   private static final float f_2032 = 1.5F;
   private static final float f_2033 = 0.5F;
   private static final float f_2034 = 4.0F;
   private static final float f_2035 = 0.25F;
   private static final String f_2036 = "Ударов для мяу";
   private static final float f_2037 = 5.0F;
   private static final float f_2038 = 20.0F;
   private static final long f_2039 = 400L;
   private static final String f_2040 = "Мяу";
   private static final String f_2041 = "Весло";
   private static final String f_2042 = "МЁД ПО ТЕЛУ";
   private static final String f_2043 = "Штребух";
   private static final double f_2044 = 0.3;
   private static final String f_2045 = "weslo";
   private static final String f_2046 = "5sim";
   private static final String f_2047 = "kozel";
   private static final float f_2048 = 0.78F;
   private static final float f_2049 = 0.015F;
   private static final double f_2050 = 28.0;
   private static final double f_2051 = 0.025;
   private static final double f_2052 = 1.12;
   private static final double f_2053 = 0.012;
   private static final double f_2054 = 0.34;
   private static final float f_2055 = 0.28F;
   private static final float f_2056 = 0.18F;
   private static final float f_2057 = 180.0F;
   private static final float f_2058 = 0.08F;
   private static final double f_2059 = 0.35;
   private static final double f_2060 = -0.42;
   private static final double f_2061 = 0.42;
   private static final double f_2062 = 0.003;
   private static final float f_2063 = 0.01F;
   private static final float f_2064 = 25.0F;
   private static final float f_2065 = 6.0F;
   private static final float f_2066 = 25.0F;
   private static final float f_2067 = 0.32F;
   private static final double f_2068 = 22.0;
   private static final float f_2069 = (float) (Math.PI * 2);
   private static final float f_2070 = (float) (Math.PI * 2);
   private static final float f_2071 = (float) (Math.PI * 2);
   private static final float f_2072 = 0.02F;
   private static final float f_2073 = 0.0625F;
   private static final float f_2074 = 0.78F;
   private static final float f_2075 = 0.22F;
   private static final float f_2076 = 25.0F;
   private static final float f_2077 = 4.2F;
   private static final float f_2078 = 2.4F;
   private static final float f_2079 = 0.14F;
   private static final float f_2080 = 0.45F;
   private static final float f_2081 = 0.42F;
   private static final float f_2082 = 1.1F;
   private static final float f_2083 = 0.5F;
   private static final float f_2084 = 0.8F;
   private static final float f_2085 = -10.0F;
   private static final float f_2086 = 3.0F;
   private static final float f_2087 = -6.0F;
   private static final float f_2088 = 20.0F;
   private static final float f_2089 = 12.0F;
   private static final float f_2090 = 18.0F;
   private static final float f_2091 = -8.5F;
   private static final float f_2092 = 10.0F;
   private static final float f_2093 = -8.0F;
   private static final float f_2094 = 17.0F;
   private static final float f_2095 = 6.0F;
   private static final float f_2096 = 15.0F;
   private static final float f_2097 = 66.0F;
   private static final int f_2098 = -13359327;
   private static final float f_2099 = -11.2F;
   private static final float f_2100 = 5.0F;
   private static final float f_2101 = -4.4F;
   private static final float f_2102 = 2.2F;
   private static final float f_2103 = 8.2F;
   private static final float f_2104 = 14.2F;
   private static final float f_2105 = 9.0F;
   private static final float f_2106 = 5.0F;
   private static final float f_2107 = -4.4F;
   private static final float f_2108 = 2.2F;
   private static final float f_2109 = 8.2F;
   private static final float f_2110 = 14.2F;
   private static final float f_2111 = -7.0F;
   private static final float f_2112 = 1.8F;
   private static final float f_2113 = -2.4F;
   private static final float f_2114 = 14.0F;
   private static final float f_2115 = 2.4F;
   private static final float f_2116 = 13.0F;
   private static final int f_2117 = -923688;
   private static final float f_2118 = -5.8F;
   private static final float f_2119 = 3.6F;
   private static final float f_2120 = -8.32F;
   private static final float f_2121 = 11.6F;
   private static final float f_2122 = 7.7F;
   private static final float f_2123 = 0.45F;
   private static final float f_2124 = -6.5F;
   private static final float f_2125 = 2.1F;
   private static final float f_2126 = -5.9F;
   private static final float f_2127 = 13.0F;
   private static final float f_2128 = 2.2F;
   private static final float f_2129 = 10.8F;
   private static final float f_2130 = 0.8F;
   private static final float f_2131 = 10.0F;
   private static final float f_2132 = 1.3F;
   private static final float f_2133 = 2.5F;
   private static final float f_2134 = 6.0F;
   private static final float f_2135 = 13.0F;
   private static final float f_2136 = -7.0F;
   private static final float f_2137 = -7.8F;
   private static final float f_2138 = -1.2F;
   private static final float f_2139 = -10.0F;
   private static final float f_2140 = 15.6F;
   private static final float I1 = 11.0F;
   private static final float f_2141 = 10.5F;
   private static final float f_2142 = 34.0F;
   private static final int Il = -13359327;
   private static final float I2 = -8.8F;
   private static final float f_2143 = 1.2F;
   private static final float f_2144 = -8.8F;
   private static final float f_2145 = 6.0F;
   private static final float f_2146 = 7.4F;
   private static final float f_2147 = 6.8F;
   private static final float f_2148 = 1.2F;
   private static final float I5 = -8.8F;
   private static final float f_2149 = 6.0F;
   private static final float f_2150 = 7.4F;
   private static final int f_2151 = -923688;
   private static final float f_2152 = -5.8F;
   private static final float f_2153 = -10.34F;
   private static final float I7 = 11.6F;
   private static final float I9 = 5.8F;
   private static final float f_2154 = 0.45F;
   private static final float I4 = -4.4F;
   private static final float f_2155 = -1.6F;
   private static final float f_2156 = -10.18F;
   private static final float f_2157 = 8.8F;
   private static final float f_2158 = 3.0F;
   private static final float f_2159 = 0.5F;
   private static final int f_2160 = -15264490;
   private static final float f_2161 = -6.7F;
   private static final float f_2162 = 4.0F;
   private static final float f_2163 = -10.45F;
   private static final float f_2164 = 5.7F;
   private static final float f_2165 = 4.9F;
   private static final float f_2166 = 0.45F;
   private static final float I3 = 4.0F;
   private static final float f_2167 = -10.45F;
   private static final float f_2168 = 5.7F;
   private static final float f_2169 = 4.9F;
   private static final float f_2170 = 0.45F;
   private static final int f_2171 = -16316665;
   private static final float IO = -5.8F;
   private static final float f_2172 = 5.1F;
   private static final float f_2173 = -10.72F;
   private static final float f_2174 = 3.0F;
   private static final float f_2175 = 3.0F;
   private static final float f_2176 = 0.35F;
   private static final float f_2177 = 2.8F;
   private static final float f_2178 = 5.1F;
   private static final float f_2179 = -10.72F;
   private static final float f_2180 = 3.0F;
   private static final float f_2181 = 3.0F;
   private static final float f_2182 = 0.35F;
   private static final float f_2183 = -5.0F;
   private static final float f_2184 = 6.4F;
   private static final float f_2185 = -11.02F;
   private static final float f_2186 = 0.8F;
   private static final float f_2187 = 0.8F;
   private static final float I_ = 0.28F;
   private static final float f_2188 = 3.6F;
   private static final float f_2189 = 6.4F;
   private static final float f_2190 = -11.02F;
   private static final float I8 = 0.8F;
   private static final float f_2191 = 0.8F;
   private static final float f_2192 = 0.28F;
   private static final int f_2193 = -4618623;
   private static final float f_2194 = -0.75F;
   private static final float f_2195 = 3.1F;
   private static final float f_2196 = -10.82F;
   private static final float f_2197 = 1.5F;
   private static final float I0 = 0.35F;
   private static final double f_2198 = Math.PI;
   private static final float f_2199 = 5.8F;
   private static final float f_2200 = 3.5F;
   private static final float I6 = -5.4F;
   private static final float f_2201 = 0.7F;
   private static final float f_2202 = -5.8F;
   private static final float f_2203 = 3.5F;
   private static final float f_2204 = -5.4F;
   private static final float f_2205 = 0.7F;
   private static final float II = 5.8F;
   private static final float f_2206 = 3.5F;
   private static final float f_2207 = 6.7F;
   private static final float f_2208 = 0.65F;
   private static final float f_2209 = -5.8F;
   private static final float f_2210 = 3.5F;
   private static final float f_2211 = 6.7F;
   private static final float f_2212 = 0.65F;
   private static final float f_2213 = 2.5F;
   private static final float f_2214 = 3.2F;
   private static final float f_2215 = 0.4F;
   private static final float f_2216 = 12.0F;
   private static final float f_2217 = 14.0F;
   private static final float f_2218 = 5.0F;
   private static final float f_2219 = 10.0F;
   private static final float f_2220 = 12.4F;
   private static final float f_2221 = 11.0F;
   private static final float f_2222 = -62.0F;
   private static final float f_2223 = -2.1F;
   private static final float f_2224 = -1.7F;
   private static final float f_2225 = 4.2F;
   private static final float f_2226 = 11.5F;
   private static final float f_2227 = 4.2F;
   private static final float f_2228 = 82.0F;
   private static final float f_2229 = 24.0F;
   private static final int f_2230 = -14870506;
   private static final float f_2231 = -2.25F;
   private static final float f_2232 = 2.3F;
   private static final float f_2233 = -1.82F;
   private static final float f_2234 = 4.5F;
   private static final float f_2235 = 4.5F;
   private static final float f_2236 = -2.25F;
   private static final float f_2237 = 5.6F;
   private static final float f_2238 = -1.82F;
   private static final float f_2239 = 4.5F;
   private static final float f_2240 = 4.5F;
   private static final float f_2241 = -2.25F;
   private static final float f_2242 = 8.9F;
   private static final float f_2243 = -1.82F;
   private static final float f_2244 = 4.5F;
   private static final float f_2245 = 4.5F;
   private static final double f_2246 = 0.001;
   private static final long f_2247 = 13L;
   private static final double f_2248 = 0.045;
   private static final double f_2249 = 0.42;
   private static final double f_2250 = 0.9;
   private static final double f_2251 = 0.78;
   private static final double f_2252 = 0.55;
   private static final double f_2253 = 0.45;
   private static final float f_2254 = 180.0F;
   private static final float f_2255 = 20.0F;
   private static final long f_2256 = 100000L;
   private static final float f_2257 = 1000.0F;
   private static final float f_2258 = 0.72F;
   private static final float f_2259 = 0.62F;
   private static final float f_2260 = 0.28F;
   private static final float f_2261 = 0.28F;
   private static final float f_2262 = 0.01F;
   private static final double f_2263 = 0.012;
   private static final double f_2264 = 24.0;
   private static final double f_2265 = Math.PI;
   private static final double f_2266 = 2.0;
   private static final float f_2267 = -2.2F;
   private static final float f_2268 = -3.6F;
   private static final float f_2269 = -2.1F;
   private static final float f_2270 = 4.4F;
   private static final float f_2271 = 4.2F;
   private static final float f_2272 = 4.2F;
   private static final float f_2273 = 82.0F;
   private static final int f_2274 = -923688;
   private static final float f_2275 = -1.7F;
   private static final float f_2276 = -3.85F;
   private static final float f_2277 = -2.25F;
   private static final float f_2278 = 3.4F;
   private static final float f_2279 = 1.2F;
   private static final float f_2280 = 4.5F;
   private static final int f_2281 = -14870506;
   private static final float f_2282 = -8.6F;
   private static final float f_2283 = 15.78F;
   private static final float f_2284 = -3.5F;
   private static final float f_2285 = 17.2F;
   private static final float f_2286 = 0.34F;
   private static final float f_2287 = 1.25F;
   private static final float f_2288 = -9.2F;
   private static final float f_2289 = 15.78F;
   private static final float f_2290 = 0.9F;
   private static final float f_2291 = 18.4F;
   private static final float f_2292 = 0.34F;
   private static final float f_2293 = 1.35F;
   private static final float f_2294 = -8.2F;
   private static final float f_2295 = 15.78F;
   private static final float f_2296 = 5.4F;
   private static final float f_2297 = 16.4F;
   private static final float f_2298 = 0.34F;
   private static final float f_2299 = 1.25F;
   private static final float f_2300 = -10.45F;
   private static final float f_2301 = 9.3F;
   private static final float f_2302 = -2.8F;
   private static final float f_2303 = 0.42F;
   private static final float f_2304 = 3.0F;
   private static final float f_2305 = -10.45F;
   private static final float f_2306 = 8.0F;
   private static final float f_2307 = 1.1F;
   private static final float f_2308 = 0.42F;
   private static final float f_2309 = 3.6F;
   private static final float f_2310 = -10.45F;
   private static final float f_2311 = 6.6F;
   private static final float f_2312 = 5.1F;
   private static final float f_2313 = 0.42F;
   private static final float f_2314 = 3.0F;
   private static final float f_2315 = 10.03F;
   private static final float f_2316 = 9.3F;
   private static final float f_2317 = -2.8F;
   private static final float f_2318 = 0.42F;
   private static final float f_2319 = 3.0F;
   private static final float f_2320 = 10.03F;
   private static final float f_2321 = 8.0F;
   private static final float f_2322 = 1.1F;
   private static final float f_2323 = 0.42F;
   private static final float f_2324 = 3.6F;
   private static final float f_2325 = 10.03F;
   private static final float f_2326 = 6.6F;
   private static final float f_2327 = 5.1F;
   private static final float f_2328 = 0.42F;
   private static final float f_2329 = 3.0F;
   private static final float f_2330 = -1.0F;
   private static final float f_2331 = 5.2F;
   private static final float f_2332 = 8.8F;
   private static final float f_2333 = -6.7F;
   private static final float f_2334 = -18.0F;
   private static final float f_2335 = -7.0F;
   private static final int f_2336 = -13359327;
   private static final float f_2337 = -1.9F;
   private static final float f_2338 = -0.6F;
   private static final float f_2339 = -1.8F;
   private static final float f_2340 = 3.8F;
   private static final float f_2341 = 5.4F;
   private static final float f_2342 = 3.6F;
   private static final int f_2343 = -923688;
   private static final float f_2344 = -0.85F;
   private static final float f_2345 = -2.05F;
   private static final float f_2346 = 1.7F;
   private static final float f_2347 = 3.2F;
   private static final float f_2348 = 0.5F;
   private static final float f_2349 = 255.0F;
   private static final float f_2350 = 255.0F;
   private static final float f_2351 = 255.0F;
   private static final float f_2352 = 255.0F;
   private static final float f_2353 = 128.0F;
   private static final float f_2354 = 128.0F;
   private static final float f_2355 = 128.0F;
   private static final float f_2356 = 128.0F;
   private static final float f_2357 = 128.0F;
   private static final float f_2358 = 128.0F;
   private static final float f_2359 = 128.0F;
   private static final float f_2360 = 128.0F;
   private static final float f_2361 = 128.0F;
   private static final float f_2362 = 128.0F;
   private static final float f_2363 = 128.0F;
   private static final float f_2364 = 128.0F;
   private static final float f_2365 = 128.0F;
   private static final float f_2366 = 128.0F;
   private static final float f_2367 = 128.0F;
   private static final float f_2368 = 128.0F;
   private static final float f_2369 = 128.0F;
   private static final float f_2370 = 128.0F;
   private static final float f_2371 = 128.0F;
   private static final float f_2372 = 128.0F;
   private static final float f_2373 = 128.0F;
   private static final float f_2374 = 128.0F;
   private static final float f_2375 = 128.0F;
   private static final float f_2376 = 128.0F;
   private static final float f_2377 = 360.0F;
   private static final float f_2378 = 540.0F;
   private static final float f_2379 = 360.0F;
   private static final float f_2380 = 180.0F;
   private static final String f_2381 = "energy";
   private static final String f_2382 = "images/cabbit/kotost.png";

   private double m_2756(double var1, double var3, double var5) {
      int var7 = MathHelper.floor(var3);

      for (int var8 = 0; var8 >= -8; var8--) {
         BlockPos var9 = BlockPos.ofFloored(var1, var7 + var8, var5);
         BlockState var10 = f_5909.world.getBlockState(var9);
         VoxelShape var11 = var10.getCollisionShape(f_5909.world, var9);
         if (!var11.isEmpty()) {
            return var9.getY() + var11.getMax(Axis.Y);
         }
      }

      return var3;
   }

   private void m_164(MatrixStack var1, float var2) {
      this.m_206(
         var1,
         f_2281,
         var2,
         new float[]{f_2282, f_2283, f_2284, f_2285, f_2286, f_2287},
         new float[]{f_2288, f_2289, f_2290, f_2291, f_2292, f_2293},
         new float[]{f_2294, f_2295, f_2296, f_2297, f_2298, f_2299},
         new float[]{f_2300, f_2301, f_2302, f_2303, f_2304, 1.0F},
         new float[]{f_2305, f_2306, f_2307, f_2308, f_2309, 1.0F},
         new float[]{f_2310, f_2311, f_2312, f_2313, f_2314, 1.0F},
         new float[]{f_2315, f_2316, f_2317, f_2318, f_2319, 1.0F},
         new float[]{f_2320, f_2321, f_2322, f_2323, f_2324, 1.0F},
         new float[]{f_2325, f_2326, f_2327, f_2328, f_2329, 1.0F}
      );
   }

   private LivingEntity m_609() {
      if (InitManager.f_2740 != null && InitManager.f_2740.f_2741 != null) {
         AimBot var1 = InitManager.f_2740.f_2741.aimBot;
         if (var1 != null && var1.m_677() && this.m_1662(var1.m_3028())) {
            return var1.m_3028();
         } else {
            AttackAura var2 = InitManager.f_2740.f_2741.attackAura;
            return var2 != null && var2.m_677() && this.m_1662(var2.m_891()) ? var2.m_891() : null;
         }
      } else {
         return null;
      }
   }

   private void m_1316(Util165 var1, double var2) {
      var1.m_2214(var2);
      var1.m_2946(var2);
      var1.m_1829(var2);
      var1.m_1876(System.currentTimeMillis());
      var1.l(true);
   }

   private void m_206(MatrixStack var1, int var2, float var3, float[]... var4) {
      Util114.m_3784(RenderUtil7.f_13885);
      Matrix4f var5 = var1.peek().getPositionMatrix();
      BufferBuilder var6 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
      float var7 = (var2 >> 16 & 0xFF) / f_2349;
      float var8 = (var2 >> 8 & 0xFF) / f_2350;
      float var9 = (var2 & 0xFF) / f_2351;
      float var10 = (var2 >> 24 & 0xFF) / f_2352 * MathHelper.clamp(var3, 0.0F, 1.0F);

      for (float[] var14 : var4) {
         this.m_3522(var6, var5, var14[0], var14[1], var14[2], var14[3], var14[4], var14[5], var7, var8, var9, var10);
      }

      RenderUtil12.I(var6.end());
   }

   private boolean m_1662(LivingEntity var1) {
      return var1 != null && var1 != f_5909.player && var1.isAlive() && !var1.isRemoved();
   }

   private void m_853(MatrixStack var1, float var2) {
      this.m_964(var1, f_2330, var2);
      this.m_964(var1, 1.0F, var2);
   }

   private void m_3180(Vec3d var1, LivingEntity var2) {
      this.f_1997 = var1.x;
      this.f_1998 = var1.y;
      this.f_1999 = var1.z;
      this.f_2003 = var2 != null ? this.m_1641(this.f_1997, this.f_1999, var2.getX(), var2.getZ()) : f_5909.player.getYaw() + f_2254;
      this.f_2000 = this.f_1997;
      this.f_2001 = this.f_1998;
      this.f_2002 = this.f_1999;
      this.f_2004 = this.f_2003;
      this.f_2009 = this.f_2008;
      this.f_2011 = this.f_2010;
   }

   private void m_964(MatrixStack var1, float var2, float var3) {
      var1.push();
      var1.translate(var2 * f_2331, f_2332, f_2333);
      var1.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var2 * f_2334));
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_2335));
      this.m_206(var1, f_2336, var3, new float[]{f_2337, f_2338, f_2339, f_2340, f_2341, f_2342});
      this.m_206(var1, f_2343, var3, new float[]{f_2344, 0.0F, f_2345, f_2346, f_2347, f_2348});
      var1.pop();
   }

   private float m_1950(float var1, float var2, float var3) {
      float var4 = ((var2 - var1) % f_2377 + f_2378) % f_2379 - f_2380;
      return var1 + var4 * var3;
   }

   private void m_4134(MatrixStack var1, float var2, float var3, float var4, float var5, float[]... var6) {
      Util114.m_3784(RenderUtil7.f_13886);
      Util114.m_2037(0, f_1984);
      Matrix4f var7 = var1.peek().getPositionMatrix();
      BufferBuilder var8 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

      for (float[] var12 : var6) {
         this.m_2166(var8, var7, var12[0], var12[1], var12[2], var12[3], var12[4], var12[5], (int)var12[6], (int)var12[7], var2, var3, var4, var5);
      }

      RenderUtil12.I(var8.end());
   }

   @EventHandler
   private void m_4139(Util88 var1) {
      if (f_5909.player != null && f_5909.world != null && this.f_2005) {
         this.f_2012.m_3631(1.0);
         float var2 = (float)this.f_2012.m_2276();
         if (!(var2 <= f_2072)) {
            MatrixStack var3 = var1.m_213();
            Camera var4 = f_5909.gameRenderer.getCamera();
            Vec3d var5 = var4.getCameraPos();
            float var6 = var1.m_191();
            double var7 = MathHelper.lerp(var6, this.f_2000, this.f_1997) - var5.x;
            double var9 = MathHelper.lerp(var6, this.f_2001, this.f_1998) - var5.y;
            double var11 = MathHelper.lerp(var6, this.f_2002, this.f_1999) - var5.z;
            float var13 = this.m_1950(this.f_2004, this.f_2003, var6);
            float var14 = 1.0F;
            float var15 = 1.0F;
            float var16 = 1.0F;
            float var17 = MathHelper.clamp(var2, 0.0F, 1.0F);
            this.m_1688(var3, var7, var9, var11, this.f_1994.m_4046(), var17);
            Util114.m_3784(RenderUtil7.f_13886);
            Util114.m_2037(0, f_1984);
            Util114.m_1481();
            Util114.m_542();
            Util114.m_3978();
            Util114.m_100();
            Util114.m_1878(true);
            var3.push();
            var3.translate(var7, var9, var11);
            var3.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var13));
            float var18 = f_2073 * this.f_1994.m_4046() * (f_2074 + f_2075 * var2);
            var3.scale(var18, var18, var18);
            float var19 = this.m_1982(var6);
            float var20 = MathHelper.lerp(var6, this.f_2009, this.f_2008);
            float var21 = MathHelper.lerp(var6, this.f_2011, this.f_2010);
            float var22 = MathHelper.clamp(var21 / f_2076, 0.0F, 1.0F);
            float var23 = this.f_2007 * this.f_2007 * f_2077;
            float var24 = (float)Math.sin(var19 * f_2078) * f_2079 * (1.0F - var22 * f_2080);
            float var25 = Math.abs((float)Math.sin(var20)) * var22 * f_2081;
            var3.translate(0.0F, var23 + var24 + var25, 0.0F);
            var3.multiply(RotationAxis.POSITIVE_X.rotationDegrees((float)Math.sin(var20) * var22 * f_2082));
            var3.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)Math.sin(var20 * f_2083) * var22 * f_2084));
            this.m_4134(
               var3,
               var14,
               var15,
               var16,
               var17,
               new float[]{f_2085, f_2086, f_2087, f_2088, f_2089, f_2090, 0.0F, 0.0F},
               new float[]{f_2091, f_2092, f_2093, f_2094, f_2095, f_2096, 0.0F, f_2097}
            );
            this.m_206(
               var3,
               f_2098,
               var17,
               new float[]{f_2099, f_2100, f_2101, f_2102, f_2103, f_2104},
               new float[]{f_2105, f_2106, f_2107, f_2108, f_2109, f_2110},
               new float[]{f_2111, f_2112, f_2113, f_2114, f_2115, f_2116}
            );
            this.m_206(
               var3, f_2117, var17, new float[]{f_2118, f_2119, f_2120, f_2121, f_2122, f_2123}, new float[]{f_2124, f_2125, f_2126, f_2127, f_2128, f_2129}
            );
            this.m_164(var3, var17);
            float var26 = 1.0F - var22;
            float var27 = (float)Math.sin(var19 * f_2130) * f_2131 * var26 + (float)Math.sin(var20) * var22 * 2.0F;
            float var28 = (float)Math.sin(var19 * f_2132) * f_2133 * var26 - this.f_2007 * f_2134;
            var3.push();
            var3.translate(0.0F, f_2135, f_2136);
            var3.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(var27));
            var3.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var28));
            this.m_4134(var3, var14, var15, var16, var17, new float[]{f_2137, f_2138, f_2139, f_2140, I1, f_2141, 0.0F, f_2142});
            this.m_206(var3, Il, var17, new float[]{I2, f_2143, f_2144, 2.0F, f_2145, f_2146}, new float[]{f_2147, f_2148, I5, 2.0F, f_2149, f_2150});
            this.m_206(var3, f_2151, var17, new float[]{f_2152, 0.0F, f_2153, I7, I9, f_2154}, new float[]{I4, f_2155, f_2156, f_2157, f_2158, f_2159});
            this.m_206(var3, f_2160, var17, new float[]{f_2161, f_2162, f_2163, f_2164, f_2165, f_2166}, new float[]{1.0F, I3, f_2167, f_2168, f_2169, f_2170});
            this.m_206(
               var3, f_2171, var17, new float[]{IO, f_2172, f_2173, f_2174, f_2175, f_2176}, new float[]{f_2177, f_2178, f_2179, f_2180, f_2181, f_2182}
            );
            this.m_206(var3, -1, var17, new float[]{f_2183, f_2184, f_2185, f_2186, f_2187, I_}, new float[]{f_2188, f_2189, f_2190, I8, f_2191, f_2192});
            this.m_206(var3, f_2193, var17, new float[]{f_2194, f_2195, f_2196, f_2197, 1.0F, I0});
            this.m_853(var3, var17);
            var3.pop();
            float var29 = (float)Math.sin(var20) * var21;
            float var30 = (float)Math.sin(var20 + f_2198) * var21;
            this.m_1897(var3, f_2199, f_2200, I6, var29 * f_2201, var14, var15, var16, var17);
            this.m_1897(var3, f_2202, f_2203, f_2204, var30 * f_2205, var14, var15, var16, var17);
            this.m_1897(var3, II, f_2206, f_2207, var30 * f_2208, var14, var15, var16, var17);
            this.m_1897(var3, f_2209, f_2210, f_2211, var29 * f_2212, var14, var15, var16, var17);
            float var33 = (float)Math.sin(var19 * (f_2213 + var22 * f_2214) + var20 * f_2215) * (f_2216 + var22 * f_2217);
            float var34 = (float)Math.sin(var19 * 2.0F) * f_2218 + this.f_2007 * f_2219;
            var3.push();
            var3.translate(0.0F, f_2220, f_2221);
            var3.multiply(RotationAxis.POSITIVE_X.rotationDegrees(f_2222 + var34));
            var3.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(var33));
            this.m_4134(var3, var14, var15, var16, var17, new float[]{f_2223, 0.0F, f_2224, f_2225, f_2226, f_2227, f_2228, f_2229});
            this.m_206(
               var3,
               f_2230,
               var17,
               new float[]{f_2231, f_2232, f_2233, f_2234, 1.0F, f_2235},
               new float[]{f_2236, f_2237, f_2238, f_2239, 1.0F, f_2240},
               new float[]{f_2241, f_2242, f_2243, f_2244, 1.0F, f_2245}
            );
            var3.pop();
            var3.pop();
            Util114.m_1562();
            Util114.m_963();
            Util114.m_3158(1.0F, 1.0F, 1.0F, 1.0F);
         }
      }
   }

   private void m_1688(MatrixStack var1, double var2, double var4, double var6, float var8, float var9) {
      float var10 = f_2258 * var8;
      float var11 = f_2259 * var8;
      float var12 = MathHelper.clamp(var9 * f_2260, 0.0F, f_2261);
      if (!(var12 <= f_2262)) {
         Util114.m_1481();
         Util114.m_542();
         Util114.m_100();
         Util114.m_1878(false);
         Util114.m_3978();
         Util114.m_3784(RenderUtil7.f_13885);
         var1.push();
         var1.translate(var2, var4 + f_2263, var6);
         Matrix4f var13 = var1.peek().getPositionMatrix();
         BufferBuilder var14 = Tessellator.getInstance().begin(DrawMode.TRIANGLE_FAN, VertexFormats.POSITION_COLOR);
         var14.vertex(var13, 0.0F, 0.0F, 0.0F).color(0.0F, 0.0F, 0.0F, var12);

         for (int var15 = 0; var15 <= 24; var15++) {
            double var16 = var15 / f_2264 * f_2265 * f_2266;
            var14.vertex(var13, (float)Math.cos(var16) * var10, 0.0F, (float)Math.sin(var16) * var11).color(0.0F, 0.0F, 0.0F, 0.0F);
         }

         RenderUtil12.I(var14.end());
         var1.pop();
         Util114.m_1878(true);
         Util114.m_1562();
         Util114.m_963();
      }
   }

   private void m_2166(
      BufferBuilder var1,
      Matrix4f var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int var9,
      int var10,
      float var11,
      float var12,
      float var13,
      float var14
   ) {
      float var15 = var3 + var6;
      float var16 = var4 + var7;
      float var17 = var5 + var8;
      float var18 = var9 / f_2353;
      float var19 = (var9 + var8) / f_2354;
      float var20 = (var10 + var8) / f_2355;
      float var21 = (var10 + var8 + var7) / f_2356;
      float var22 = (var9 + var8) / f_2357;
      float var23 = (var9 + var8 + var6) / f_2358;
      float var24 = (var10 + var8) / f_2359;
      float var25 = (var10 + var8 + var7) / f_2360;
      float var26 = (var9 + var8 + var6) / f_2361;
      float var27 = (var9 + 2.0F * var8 + var6) / f_2362;
      float var28 = (var10 + var8) / f_2363;
      float var29 = (var10 + var8 + var7) / f_2364;
      float var30 = (var9 + 2.0F * var8 + var6) / f_2365;
      float var31 = (var9 + 2.0F * var8 + 2.0F * var6) / f_2366;
      float var32 = (var10 + var8) / f_2367;
      float var33 = (var10 + var8 + var7) / f_2368;
      float var34 = (var9 + var8) / f_2369;
      float var35 = (var9 + var8 + var6) / f_2370;
      float var36 = var10 / f_2371;
      float var37 = (var10 + var8) / f_2372;
      float var38 = (var9 + var8 + var6) / f_2373;
      float var39 = (var9 + var8 + 2.0F * var6) / f_2374;
      float var40 = var10 / f_2375;
      float var41 = (var10 + var8) / f_2376;
      var1.vertex(var2, var3, var4, var5).texture(var23, var25).color(var11, var12, var13, var14);
      var1.vertex(var2, var15, var4, var5).texture(var22, var25).color(var11, var12, var13, var14);
      var1.vertex(var2, var15, var16, var5).texture(var22, var24).color(var11, var12, var13, var14);
      var1.vertex(var2, var3, var16, var5).texture(var23, var24).color(var11, var12, var13, var14);
      var1.vertex(var2, var15, var4, var17).texture(var30, var33).color(var11, var12, var13, var14);
      var1.vertex(var2, var3, var4, var17).texture(var31, var33).color(var11, var12, var13, var14);
      var1.vertex(var2, var3, var16, var17).texture(var31, var32).color(var11, var12, var13, var14);
      var1.vertex(var2, var15, var16, var17).texture(var30, var32).color(var11, var12, var13, var14);
      var1.vertex(var2, var3, var4, var17).texture(var18, var21).color(var11, var12, var13, var14);
      var1.vertex(var2, var3, var4, var5).texture(var19, var21).color(var11, var12, var13, var14);
      var1.vertex(var2, var3, var16, var5).texture(var19, var20).color(var11, var12, var13, var14);
      var1.vertex(var2, var3, var16, var17).texture(var18, var20).color(var11, var12, var13, var14);
      var1.vertex(var2, var15, var4, var5).texture(var26, var29).color(var11, var12, var13, var14);
      var1.vertex(var2, var15, var4, var17).texture(var27, var29).color(var11, var12, var13, var14);
      var1.vertex(var2, var15, var16, var17).texture(var27, var28).color(var11, var12, var13, var14);
      var1.vertex(var2, var15, var16, var5).texture(var26, var28).color(var11, var12, var13, var14);
      var1.vertex(var2, var3, var16, var17).texture(var34, var37).color(var11, var12, var13, var14);
      var1.vertex(var2, var15, var16, var17).texture(var35, var37).color(var11, var12, var13, var14);
      var1.vertex(var2, var15, var16, var5).texture(var35, var36).color(var11, var12, var13, var14);
      var1.vertex(var2, var3, var16, var5).texture(var34, var36).color(var11, var12, var13, var14);
      var1.vertex(var2, var3, var4, var5).texture(var38, var40).color(var11, var12, var13, var14);
      var1.vertex(var2, var15, var4, var5).texture(var39, var40).color(var11, var12, var13, var14);
      var1.vertex(var2, var15, var4, var17).texture(var39, var41).color(var11, var12, var13, var14);
      var1.vertex(var2, var3, var4, var17).texture(var38, var41).color(var11, var12, var13, var14);
   }

   public CabbitTarget() {
      super(f_2013, f_2014, Category.RENDER);
      this.f_1992 = new ModeSetting(f_2015, f_2016, f_2017, f_2018, f_2019, f_2020);
      this.f_1993 = new NumberSetting(f_2021, f_2022, f_2023, f_2024, f_2025);
      this.f_1994 = new NumberSetting(f_2026, f_2027, f_2028, f_2029, f_2030);
      this.f_1995 = new NumberSetting(f_2031, f_2032, f_2033, f_2034, f_2035);
      this.f_1996 = new NumberSetting(f_2036, f_2037, 1.0F, f_2038, 1.0F);
      this.f_2012 = new Util165(Util153.EASE_OUT_CUBIC, f_2039);
   }

   private float m_1641(double var1, double var3, double var5, double var7) {
      return (float)Math.toDegrees(Math.atan2(-(var5 - var1), var7 - var3));
   }

   private Vec3d m_674(LivingEntity var1) {
      if (var1 != null) {
         double var26 = var1.getX() - f_5909.player.getX();
         double var4 = var1.getZ() - f_5909.player.getZ();
         double var6 = Math.sqrt(var26 * var26 + var4 * var4);
         if (var6 < f_2246) {
            float var8 = (float)Math.toRadians(f_5909.player.getYaw());
            var26 = -Math.sin(var8);
            var4 = Math.cos(var8);
            var6 = 1.0;
         }

         double var27 = var26 / var6;
         double var10 = var4 / var6;
         double var12 = -var10;
         double var16 = (f_5909.world.getTime() + var1.getId() * f_2247) * f_2248;
         double var18 = Math.sin(var16) * f_2249;
         double var20 = Math.max(f_2250, this.f_1995.m_4046() * f_2251 + var1.getWidth() * f_2252);
         double var22 = var1.getX() - var27 * var20 + var12 * var18;
         double var24 = var1.getZ() - var10 * var20 + var27 * var18;
         return new Vec3d(var22, this.m_2756(var22, var1.getY(), var24), var24);
      } else {
         float var2 = (float)Math.toRadians(f_5909.player.getYaw());
         double var3 = this.f_1995.m_4046();
         double var5 = -var3;
         double var7 = var3 * f_2253;
         double var9 = f_5909.player.getX() - Math.sin(var2) * var5 + Math.cos(var2) * var7;
         double var11 = f_5909.player.getZ() + Math.cos(var2) * var5 + Math.sin(var2) * var7;
         return new Vec3d(var9, this.m_2756(var9, f_5909.player.getY(), var11), var11);
      }
   }

   @EventHandler
   private void m_1484(Util170 var1) {
      if (f_5909.player != null && f_5909.world != null) {
         LivingEntity var2 = this.m_609();
         Vec3d var3 = this.m_674(var2);
         if (!this.f_2005) {
            this.m_3180(var3, var2);
            this.f_2005 = true;
         } else {
            this.f_2000 = this.f_1997;
            this.f_2001 = this.f_1998;
            this.f_2002 = this.f_1999;
            this.f_2004 = this.f_2003;
            this.f_2009 = this.f_2008;
            this.f_2011 = this.f_2010;
            this.f_2007 = this.f_2007 * f_2048;
            if (this.f_2007 < f_2049) {
               this.f_2007 = 0.0F;
            }

            double var4 = var3.x - this.f_1997;
            double var6 = var3.y - this.f_1998;
            double var8 = var3.z - this.f_1999;
            double var10 = Math.sqrt(var4 * var4 + var8 * var8);
            if (Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8) > f_2050) {
               this.m_3180(var3, var2);
            } else {
               double var12 = 0.0;
               if (var10 > f_2051) {
                  double var14 = this.f_1993.m_4046() * (var2 != null ? f_2052 : 1.0);
                  var12 = Math.min(var10, Math.min(var14, Math.max(f_2053, var10 * f_2054)));
                  this.f_1997 += var4 / var10 * var12;
                  this.f_1999 += var8 / var10 * var12;
                  float var16 = (float)Math.toDegrees(Math.atan2(-var4, var8));
                  this.f_2003 = this.m_1950(this.f_2003, var16, f_2055);
               } else if (var2 != null) {
                  this.f_2003 = this.m_1950(this.f_2003, this.m_1641(this.f_1997, this.f_1999, var2.getX(), var2.getZ()), f_2056);
               } else {
                  float var17 = f_5909.player.getYaw() + f_2057;
                  this.f_2003 = this.m_1950(this.f_2003, var17, f_2058);
               }

               this.f_1998 = this.f_1998 + MathHelper.clamp(var6 * f_2059, f_2060, f_2061);
               double var18 = Math.sqrt((this.f_1997 - this.f_2000) * (this.f_1997 - this.f_2000) + (this.f_1999 - this.f_2002) * (this.f_1999 - this.f_2002));
               float var19 = var18 > f_2062 ? MathHelper.clamp((float)(var18 / Math.max(f_2063, this.f_1993.m_4046())) * f_2064, f_2065, f_2066) : 0.0F;
               this.f_2010 = this.f_2010 + (var19 - this.f_2010) * f_2067;
               if (var12 > 0.0) {
                  this.f_2008 = this.f_2008 + (float)(var18 * f_2068);
                  if (this.f_2008 > f_2069) {
                     this.f_2008 = this.f_2008 - f_2070;
                     this.f_2009 = this.f_2009 - f_2071;
                  }
               }
            }
         }
      }
   }

   private void m_3522(
      BufferBuilder var1,
      Matrix4f var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12
   ) {
      float var13 = var3 + var6;
      float var14 = var4 + var7;
      float var15 = var5 + var8;
      var1.vertex(var2, var3, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var13, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var13, var14, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var14, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var13, var4, var15).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var15).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var14, var15).color(var9, var10, var11, var12);
      var1.vertex(var2, var13, var14, var15).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var15).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var14, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var14, var15).color(var9, var10, var11, var12);
      var1.vertex(var2, var13, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var13, var4, var15).color(var9, var10, var11, var12);
      var1.vertex(var2, var13, var14, var15).color(var9, var10, var11, var12);
      var1.vertex(var2, var13, var14, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var14, var15).color(var9, var10, var11, var12);
      var1.vertex(var2, var13, var14, var15).color(var9, var10, var11, var12);
      var1.vertex(var2, var13, var14, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var14, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var13, var4, var5).color(var9, var10, var11, var12);
      var1.vertex(var2, var13, var4, var15).color(var9, var10, var11, var12);
      var1.vertex(var2, var3, var4, var15).color(var9, var10, var11, var12);
   }

   private float m_1982(float var1) {
      return f_5909.world != null ? ((float)f_5909.world.getTime() + var1) / f_2255 : (float)(System.currentTimeMillis() % f_2256) / f_2257;
   }

   @Override
   public void m_1() {
      this.f_2005 = false;
      super.m_1();
   }

   @EventHandler
   private void m_3887(EventAttack var1) {
      if (f_5909.player != null && f_5909.world != null) {
         this.f_2006++;
         if (this.f_2006 >= this.f_1996.m_134().intValue()) {
            this.f_2006 = 0;
            this.f_2007 = 1.0F;
            String var2 = this.f_1992.m_3862();
            switch (var2) {
               case f_2040:
                  f_5909.world
                     .playSound(
                        f_5909.player,
                        f_5909.player.getBlockPos(),
                        SoundEvents.ENTITY_CAT_AMBIENT,
                        SoundCategory.PLAYERS,
                        1.0F,
                        1.0F + (float)(Math.random() * f_2044)
                     );
                  break;
               case f_2041:
                  Util89.m_3138(f_2045);
                  break;
               case f_2042:
                  Util89.m_3138(f_2046);
                  break;
               case f_2043:
                  Util89.m_3138(f_2047);
            }
         }
      }
   }

   private void m_1897(MatrixStack var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      var1.push();
      var1.translate(var2, var3, var4);
      var1.multiply(RotationAxis.POSITIVE_X.rotationDegrees(var5));
      this.m_4134(var1, var6, var7, var8, var9, new float[]{f_2267, f_2268, f_2269, f_2270, f_2271, f_2272, f_2273, 0.0F});
      this.m_206(var1, f_2274, var9, new float[]{f_2275, f_2276, f_2277, f_2278, f_2279, f_2280});
      var1.pop();
   }

   @Override
   public void m_2() {
      super.m_2();
      this.f_2005 = false;
      this.f_2006 = 0;
      this.f_2007 = 0.0F;
      this.f_2008 = 0.0F;
      this.f_2009 = 0.0F;
      this.f_2010 = 0.0F;
      this.f_2011 = 0.0F;
      this.m_1316(this.f_2012, 0.0);
   }
}
