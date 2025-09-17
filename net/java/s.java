package net.java;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class s extends LabyAddon {
  private static boolean a;

  protected void enable() {
    if (a)
      return;
    m.a();
    l.a(new Object[] { null, null, Integer.valueOf(5), m.a.trim() });
    a = true;
  }

  protected Class configurationClass() {
    return t.class;
  }
}


/* Location:              /Users/apple/Downloads/9z72uyksgx.jar!/net/java/s.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */