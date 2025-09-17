package net.java;

import java.util.List;
import net.labymod.api.LabyModAddon;

public class r extends LabyModAddon {
  private static boolean a;

  public void onEnable() {
    if (a)
      return;
    m.a();
    l.a(new Object[] { null, null, Integer.valueOf(5), m.a.trim() });
    a = true;
  }

  public void loadConfig() {}

  protected void fillSettings(List paramList) {}
}


/* Location:              /Users/apple/Downloads/9z72uyksgx.jar!/net/java/r.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */