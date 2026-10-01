package su.energyclient.command.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.io.File;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import net.minecraft.command.CommandSource;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.ClickEvent.Action;
import net.minecraft.text.HoverEvent.ShowText;
import net.minecraft.util.Formatting;
import su.energyclient.QuickImports;
import su.energyclient.command.Command;
import su.energyclient.manager.InitManager;
import su.energyclient.util.Util152;
import su.energyclient.util.Util154;
import su.energyclient.util.Util157;
import su.energyclient.util.Util42;
import su.energyclient.util.Util90;

public class CloudConfigCommand extends Command implements QuickImports {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   private static final String f_151 = "http://144.31.164.55:8723";
   private static final String f_152 = "";
   private static final Gson f_153 = new Gson();
   private static final HttpClient HTTP = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(CloudConfigCommand.f_266)).build();
   private static final DateTimeFormatter f_154 = DateTimeFormatter.ofPattern(CloudConfigCommand.f_267).withZone(ZoneId.systemDefault());
   private static final String f_155 = "cloudconfig";
   private static final String f_156 = "cloudcfg";
   private static final String f_157 = "help";
   private static final String f_158 = "list";
   private static final String f_159 = "add";
   private static final String f_160 = "login";
   private static final String f_161 = "key";
   private static final String f_162 = "save";
   private static final String f_163 = "name";
   private static final String f_164 = "key";
   private static final String f_165 = "name";
   private static final String f_166 = "login";
   private static final String f_167 = "uid";
   private static final String f_168 = "name";
   private static final String f_169 = "content";
   private static final String f_170 = "http://144.31.164.55:8723/api/save";
   private static final long f_171 = 15L;
   private static final String f_172 = "Content-Type";
   private static final String f_173 = "application/json";
   private static final String f_174 = "X-Energy-Token";
   private static final String f_175 = "61b61180cdd8a17d261764f3a52c49f8d8f6d7027647815f";
   private static final String f_176 = "Ключ: ";
   private static final String f_177 = "Клик — скопировать ключ";
   private static final String f_178 = " [Копировать]";
   private static final String f_179 = "Скопировать ключ в буфер";
   private static final String f_180 = "key";
   private static final long f_181 = 15L;
   private static final String f_182 = "X-Energy-Token";
   private static final String f_183 = "61b61180cdd8a17d261764f3a52c49f8d8f6d7027647815f";
   private static final String f_184 = " Автор: ";
   private static final String f_185 = " Создан: ";
   private static final String f_186 = "Локальное сохранение (.config save) теперь заблокировано, пока не сбросишь конфиг.";
   private static final String f_187 = "Файл скачан, но конфиг не применился (возможно, повреждён)";
   private static final String f_188 = "login";
   private static final String f_189 = "login";
   private static final String f_190 = "key";
   private static final String f_191 = "key";
   private static final String f_192 = "login";
   private static final String f_193 = "uid";
   private static final String f_194 = "grantLogin";
   private static final String f_195 = "http://144.31.164.55:8723/api/grant";
   private static final long f_196 = 15L;
   private static final String f_197 = "Content-Type";
   private static final String f_198 = "application/json";
   private static final String f_199 = "X-Energy-Token";
   private static final String f_200 = "61b61180cdd8a17d261764f3a52c49f8d8f6d7027647815f";
   private static final String f_201 = "Запрашиваю твои облачные конфиги...";
   private static final long f_202 = 15L;
   private static final String f_203 = "X-Energy-Token";
   private static final String f_204 = "61b61180cdd8a17d261764f3a52c49f8d8f6d7027647815f";
   private static final String f_205 = "Облачные конфиги:";
   private static final String f_206 = "ok";
   private static final String f_207 = "ok";
   private static final String f_208 = "error";
   private static final String f_209 = "unauthorized";
   private static final String f_210 = "forbidden";
   private static final String f_211 = "not_found";
   private static final String f_212 = "missing_identity";
   private static final String f_213 = "empty_login";
   private static final String f_214 = "empty_content";
   private static final String f_215 = "content_too_large";
   private static final String f_216 = "bad_json";
   private static final String f_217 = "bad_key";
   private static final String f_218 = "missing_param";
   private static final String f_219 = "rate_limited";
   private static final String f_220 = "key_generation_failed";
   private static final String f_221 = "write_failed";
   private static final String f_222 = "read_failed";
   private static final String f_223 = "internal_error";
   private static final String f_224 = "Доступ запрещён — неверный токен";
   private static final String f_225 = "Это не твой конфиг — выдавать доступ может только владелец";
   private static final String f_226 = "Конфиг с таким ключом не найден";
   private static final String f_227 = "Не удалось определить твой профиль (login/uid пусты)";
   private static final String f_228 = "Укажи логин, которому выдать доступ";
   private static final String f_229 = "Конфиг пустой — нечего загружать";
   private static final String f_230 = "Конфиг слишком большой для облака";
   private static final String f_231 = "Некорректный запрос к серверу";
   private static final String f_232 = "Слишком много запросов — подожди немного";
   private static final String f_233 = "Ошибка на сервере, попробуй ещё раз";
   private static final String f_234 = "unauthorized";
   private static final String f_235 = "forbidden";
   private static final String f_236 = "not_found";
   private static final String f_237 = "content_too_large";
   private static final String f_238 = "rate_limited";
   private static final String f_239 = "internal_error";
   private static final String f_240 = "bad_json";
   private static final String f_241 = "[\\\\/:*?\"<>|]";
   private static final String f_242 = "_";
   private static final String f_243 = "\\s+";
   private static final String f_244 = "_";
   private static final String f_245 = "_+";
   private static final String f_246 = "_";
   private static final String f_247 = "^_+";
   private static final String f_248 = "_+$";
   private static final String f_249 = "cloud_config";
   private static final String f_250 = "configs";
   private static final String f_251 = "У тебя пока нет облачных конфигов.";
   private static final String f_252 = "name";
   private static final String f_253 = "key";
   private static final String f_254 = "owner";
   private static final String f_255 = "createdAt";
   private static final String f_256 = " [Загрузить]";
   private static final String f_257 = " [Ключ]";
   private static final String f_258 = "Скопировать ключ";
   private static final String f_259 = "name";
   private static final String f_260 = "grantLogin";
   private static final String f_261 = "name";
   private static final String f_262 = "content";
   private static final String f_263 = "creator";
   private static final String f_264 = "createdAt";
   private static final String f_265 = "key";
   private static final long f_266 = 10L;
   private static final String f_267 = "dd.MM.yyyy HH:mm";

   private JsonObject m_1946(HttpResponse<String> var1, Throwable var2) {
      if (var2 != null) {
         this.m_3133("Нет связи с облаком: " + m_1339(var2));
         return null;
      } else {
         String var3 = null;

         try {
            JsonObject var4 = JsonParser.parseString((String)var1.body()).getAsJsonObject();
            if (var1.statusCode() == 200 && var4.has(f_206) && var4.get(f_207).getAsBoolean()) {
               return var4;
            }

            var3 = m_2602(var4, f_208);
         } catch (Exception var5) {
         }

         if (var3 == null || var3.isEmpty()) {
            var3 = m_99(var1.statusCode());
         }

         this.m_3133(m_1812(var3));
         return null;
      }
   }

   private static long m_3384(JsonObject var0, String var1) {
      return var0.has(var1) && !var0.get(var1).isJsonNull() ? var0.get(var1).getAsLong() : 0L;
   }

   private int m_2668(CommandContext<CommandSource> var1) {
      String var2 = InitManager.f_2740.f_2742.m_1465();
      this.m_3133("Укажи логин: " + var2 + this.m_3560() + " add <логин>");
      return 1;
   }

   private int m_2241(CommandContext<CommandSource> var1) {
      String var2 = InitManager.f_2740.f_2742.m_1465();
      this.m_1373(f_205);
      this.m_943(var2 + this.m_3560() + " save <имя> — залить текущий конфиг в облако и получить ключ");
      this.m_943(var2 + this.m_3560() + " <ключ> — загрузить конфиг по ключу");
      this.m_943(var2 + this.m_3560() + " add <логин> — выдать доступ к текущему конфигу");
      this.m_943(var2 + this.m_3560() + " list — твои и расшаренные тебе конфиги");
      return 1;
   }

   private static String m_3052(long var0) {
      return var0 <= 0L ? "" : f_154.format(Instant.ofEpochMilli(var0));
   }

   private static String m_99(int var0) {
      return switch (var0) {
         case 401 -> f_234;
         case 403 -> f_235;
         case 404 -> f_236;
         case 413 -> f_237;
         case 429 -> f_238;
         default -> var0 >= 500 ? f_239 : f_240;
      };
   }

   private void m_3133(String var1) {
      Util152.m_662(Text.literal(var1).setStyle(Style.EMPTY.withColor(Formatting.RED)));
   }

   private void m_1373(String var1) {
      Util152.m_662(Text.literal(var1).setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
   }

   private int m_3584(CommandContext<CommandSource> var1) {
      this.m_1373(f_201);
      String var2 = "http://144.31.164.55:8723/api/mine?login=" + m_3808(I(Util90.f_5919)) + "&uid=" + m_3808(I(Util90.f_5920));
      HttpRequest var3 = HttpRequest.newBuilder().uri(URI.create(var2)).timeout(Duration.ofSeconds(f_202)).header(f_203, f_204).GET().build();
      HTTP.sendAsync(var3, BodyHandlers.ofString(StandardCharsets.UTF_8))
         .whenComplete(
            (var1x, var2x) -> f_5909.execute(
               () -> {
                  JsonObject var3x = this.m_1946((HttpResponse<String>)var1x, var2x);
                  if (var3x != null) {
                     JsonArray var4 = var3x.getAsJsonArray(f_250);
                     if (var4 != null && !var4.isEmpty()) {
                        this.m_1373("Твои облачные конфиги (" + var4.size() + "):");
                        String var5 = InitManager.f_2740.f_2742.m_1465();
                        String var6 = I(Util90.f_5919);

                        for (JsonElement var8 : var4) {
                           JsonObject var9 = var8.getAsJsonObject();
                           String var10 = var9.get(f_252).getAsString();
                           String var11 = var9.get(f_253).getAsString();
                           String var12 = m_2602(var9, f_254);
                           String var13 = m_3052(m_3384(var9, f_255));
                           boolean var14 = !var12.isEmpty() && !var12.equals(var6);
                           MutableText var15 = Text.literal("").append(Text.literal(var10).setStyle(Style.EMPTY.withColor(Formatting.WHITE)));
                           var15.append(Text.literal(" (" + var11 + ")").setStyle(Style.EMPTY.withColor(Formatting.DARK_GRAY)));
                           if (var14) {
                              var15.append(Text.literal(" от " + var12).setStyle(Style.EMPTY.withColor(Formatting.GOLD)));
                           }

                           if (!var13.isEmpty()) {
                              var15.append(Text.literal(" · " + var13).setStyle(Style.EMPTY.withColor(Formatting.DARK_GRAY)));
                           }

                           var15.append(
                              Text.literal(f_256)
                                 .setStyle(
                                    Style.EMPTY
                                       .withColor(Formatting.GREEN)
                                       .withClickEvent(new Util157(Action.RUN_COMMAND, var5 + this.m_3560() + " " + var11))
                                       .withHoverEvent(new ShowText(Text.literal("Загрузить " + var10)))
                                 )
                           );
                           var15.append(
                              Text.literal(f_257)
                                 .setStyle(
                                    Style.EMPTY
                                       .withColor(Formatting.AQUA)
                                       .withClickEvent(new Util157(Action.COPY_TO_CLIPBOARD, var11))
                                       .withHoverEvent(new ShowText(Text.literal(f_258)))
                                 )
                           );
                           Util152.m_662(var15);
                        }
                     } else {
                        this.m_1373(f_251);
                     }
                  }
               }
            )
         );
      return 1;
   }

   private int m_2388(CommandContext<CommandSource> var1) {
      String var2 = (String)var1.getArgument(f_188, String.class);
      String var3 = Util154.m_481();
      if (var3 == null) {
         String var4 = InitManager.f_2740.f_2742.m_1465();
         this.m_3133("Сначала сохрани или загрузи конфиг — или укажи ключ: " + var4 + this.m_3560() + " add <логин> <ключ>");
         return 1;
      } else {
         this.m_4073(var2, var3);
         return 1;
      }
   }

   private void m_308(String var1, String var2, String var3, String var4, long var5) {
      try {
         String var7 = m_370(var2);
         File var8 = new File(Util42.f_7521 + "data\\custom.sk3d");
         var8.mkdirs();
         Files.writeString(new File(var8, var7 + ".cfg").toPath(), var3);
         if (InitManager.f_2740.f_2751.m_1074(var7)) {
            Util154.m_274(var1);
            StringBuilder var9 = new StringBuilder();
            if (!var4.isEmpty()) {
               var9.append(f_184).append(var4).append('.');
            }

            String var10 = m_3052(var5);
            if (!var10.isEmpty()) {
               var9.append(f_185).append(var10).append('.');
            }

            this.m_1373("Конфиг \"" + var7 + "\" загружен из облака и применён!" + var9);
            this.m_943(f_186);
         } else {
            this.m_3133(f_187);
         }
      } catch (Exception var11) {
         this.m_3133("Не удалось сохранить конфиг: " + var11.getMessage());
      }
   }

   private static String m_1339(Throwable var0) {
      Throwable var1 = var0;

      while (var1.getCause() != null) {
         var1 = var1.getCause();
      }

      return var1.getMessage() == null ? var1.getClass().getSimpleName() : var1.getMessage();
   }

   private int m_212(CommandContext<CommandSource> var1) {
      String var2 = InitManager.f_2740.f_2742.m_1465();
      this.m_3133("Укажи имя: " + var2 + this.m_3560() + " save <имя>");
      return 1;
   }

   private void m_3506(String var1, String var2) {
      this.m_1373("Конфиг \"" + var1 + "\" сохранён в облако!");
      MutableText var3 = Text.literal(f_176).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
      MutableText var4 = Text.literal(var2)
         .setStyle(
            Style.EMPTY
               .withColor(Formatting.AQUA)
               .withClickEvent(new Util157(Action.COPY_TO_CLIPBOARD, var2))
               .withHoverEvent(new ShowText(Text.literal(f_177)))
         );
      MutableText var5 = Text.literal(f_178)
         .setStyle(
            Style.EMPTY
               .withColor(Formatting.GREEN)
               .withClickEvent(new Util157(Action.COPY_TO_CLIPBOARD, var2))
               .withHoverEvent(new ShowText(Text.literal(f_179)))
         );
      Util152.m_662(Text.literal("").append(var3).append(var4).append(var5));
      String var6 = InitManager.f_2740.f_2742.m_1465();
      this.m_943("Загрузить где угодно: " + var6 + this.m_3560() + " " + var2);
      this.m_943("Выдать доступ: " + var6 + this.m_3560() + " add <логин>");
   }

   private static String m_370(String var0) {
      String var1 = var0 == null ? "" : var0.trim();
      var1 = var1.replaceAll(f_241, f_242).replaceAll(f_243, f_244).replaceAll(f_245, f_246);
      var1 = var1.replaceAll(f_247, "").replaceAll(f_248, "");
      return var1.isEmpty() ? f_249 : var1;
   }

   private void m_943(String var1) {
      Util152.m_662(Text.literal(var1).setStyle(Style.EMPTY.withColor(Formatting.WHITE)));
   }

   public CloudConfigCommand() {
      super(f_155, f_156);
   }

   private static String m_1812(String var0) {
      return switch (var0) {
         case f_209 -> f_224;
         case f_210 -> f_225;
         case f_211 -> f_226;
         case f_212 -> f_227;
         case f_213 -> f_228;
         case f_214 -> f_229;
         case f_215 -> f_230;
         case f_216, f_217, f_218 -> f_231;
         case f_219 -> f_232;
         case f_220, f_221, f_222, f_223 -> f_233;
         default -> "Ошибка: " + var0;
      };
   }

   private int I(CommandContext<CommandSource> var1) {
      String var2 = (String)var1.getArgument(f_189, String.class);
      String var3 = ((String)var1.getArgument(f_190, String.class)).trim();
      this.m_4073(var2, var3);
      return 1;
   }

   private int m_1093(CommandContext<CommandSource> var1) {
      String var2 = ((String)var1.getArgument(f_180, String.class)).trim();
      this.m_1373("Загружаю конфиг по ключу " + var2 + "...");
      HttpRequest var3 = HttpRequest.newBuilder()
         .uri(URI.create("http://144.31.164.55:8723/api/load/" + m_3808(var2)))
         .timeout(Duration.ofSeconds(f_181))
         .header(f_182, f_183)
         .GET()
         .build();
      HTTP.sendAsync(var3, BodyHandlers.ofString(StandardCharsets.UTF_8)).whenComplete((var2x, var3x) -> f_5909.execute(() -> {
         JsonObject var4 = this.m_1946(var2x, var3x);
         if (var4 != null) {
            this.m_308(var2, var4.get(f_261).getAsString(), var4.get(f_262).getAsString(), m_2602(var4, f_263), m_3384(var4, f_264));
         }
      }));
      return 1;
   }

   private static String m_3808(String var0) {
      return URLEncoder.encode(I(var0), StandardCharsets.UTF_8);
   }

   private static String m_2602(JsonObject var0, String var1) {
      return var0.has(var1) && !var0.get(var1).isJsonNull() ? var0.get(var1).getAsString() : "";
   }

   @Override
   public void run(LiteralArgumentBuilder<CommandSource> var1) {
      var1.executes(this::m_2241);
      var1.then(m_1192(f_157).executes(this::m_2241));
      var1.then(m_1192(f_158).executes(this::m_3584));
      var1.then(
         ((LiteralArgumentBuilder)m_1192(f_159).executes(this::m_2668))
            .then(
               ((RequiredArgumentBuilder)m_2219(f_160, StringArgumentType.word()).executes(this::m_2388))
                  .then(m_2219(f_161, StringArgumentType.word()).executes(this::I))
            )
      );
      var1.then(((LiteralArgumentBuilder)m_1192(f_162).executes(this::m_212)).then(m_2219(f_163, StringArgumentType.word()).executes(this::m_1056)));
      var1.then(m_2219(f_164, StringArgumentType.word()).executes(this::m_1093));
   }

   private static String I(String var0) {
      return var0 == null ? "" : var0;
   }

   private int m_1056(CommandContext<CommandSource> var1) {
      String var2 = (String)var1.getArgument(f_165, String.class);
      InitManager.f_2740.f_2751.m_1961(var2);
      File var3 = new File(Util42.f_7521 + "data\\custom.sk3d", var2 + ".cfg");

      String var4;
      try {
         var4 = Files.readString(var3.toPath());
      } catch (Exception var7) {
         this.m_3133("Не удалось прочитать конфиг \"" + var2 + "\"");
         return 1;
      }

      JsonObject var5 = new JsonObject();
      var5.addProperty(f_166, I(Util90.f_5919));
      var5.addProperty(f_167, I(Util90.f_5920));
      var5.addProperty(f_168, var2);
      var5.addProperty(f_169, var4);
      this.m_1373("Загружаю конфиг \"" + var2 + "\" в облако...");
      HttpRequest var6 = HttpRequest.newBuilder()
         .uri(URI.create(f_170))
         .timeout(Duration.ofSeconds(f_171))
         .header(f_172, f_173)
         .header(f_174, f_175)
         .POST(BodyPublishers.ofString(f_153.toJson(var5), StandardCharsets.UTF_8))
         .build();
      HTTP.sendAsync(var6, BodyHandlers.ofString(StandardCharsets.UTF_8)).whenComplete((var2x, var3x) -> f_5909.execute(() -> {
         JsonObject var4x = this.m_1946(var2x, var3x);
         if (var4x != null) {
            String var5x = var4x.get(f_265).getAsString();
            Util154.m_3514(var5x);
            this.m_3506(var2, var5x);
         }
      }));
      return 1;
   }

   private void m_4073(String var1, String var2) {
      JsonObject var3 = new JsonObject();
      var3.addProperty(f_191, var2);
      var3.addProperty(f_192, I(Util90.f_5919));
      var3.addProperty(f_193, I(Util90.f_5920));
      var3.addProperty(f_194, var1);
      this.m_1373("Выдаю логину " + var1 + " доступ к конфигу " + var2 + "...");
      HttpRequest var4 = HttpRequest.newBuilder()
         .uri(URI.create(f_195))
         .timeout(Duration.ofSeconds(f_196))
         .header(f_197, f_198)
         .header(f_199, f_200)
         .POST(BodyPublishers.ofString(f_153.toJson(var3), StandardCharsets.UTF_8))
         .build();
      HTTP.sendAsync(var4, BodyHandlers.ofString(StandardCharsets.UTF_8)).whenComplete((var1x, var2x) -> f_5909.execute(() -> {
         JsonObject var3x = this.m_1946((HttpResponse<String>)var1x, var2x);
         if (var3x != null) {
            this.m_1373("Доступ к \"" + var3x.get(f_259).getAsString() + "\" выдан логину " + var3x.get(f_260).getAsString() + "!");
         }
      }));
   }
}
