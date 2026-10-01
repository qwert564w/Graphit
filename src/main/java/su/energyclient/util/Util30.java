package su.energyclient.util;

import java.util.Objects;
import su.energyclient.ui.UIElement1;

public record Util30(String id, String name, String description, Util150 slot, UIElement1 style, int color, int accent) {
   // src by @pointdlc @setsprinting @hueglotteam $$ crack by @soezproject
   public Util30(String id, String name, String description, Util150 slot, UIElement1 style, int color, int accent) {
      Objects.requireNonNull(id);
      Objects.requireNonNull(name);
      Objects.requireNonNull(description);
      Objects.requireNonNull(slot);
      Objects.requireNonNull(style);
      this.id = id;
      this.name = name;
      this.description = description;
      this.slot = slot;
      this.style = style;
      this.color = color;
      this.accent = accent;
   }
}
