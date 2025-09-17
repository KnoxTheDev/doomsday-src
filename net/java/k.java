package net.java;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

public class k {
  private static byte[] a;

  private static byte[] b;

  private static byte[] c;

  private static byte[] d;

  private static byte[] e;

  private static byte[] f;

  private static byte[] g;

  private static byte[] h;

  public static byte[] a() {
    if (b == null) {
      StringBuilder stringBuilder;
      (stringBuilder = new StringBuilder()).append('d');
      stringBuilder.append('y');
      stringBuilder.append('l');
      stringBuilder.append('i');
      stringBuilder.append('b');
      stringBuilder.append('_');
      stringBuilder.append('a');
      stringBuilder.append('a');
      stringBuilder.append('r');
      stringBuilder.append('c');
      stringBuilder.append('h');
      stringBuilder.append('6');
      stringBuilder.append('4');
      b = a(stringBuilder.toString());
    }
    return b;
  }

  public static byte[] b() {
    if (a == null) {
      StringBuilder stringBuilder;
      (stringBuilder = new StringBuilder()).append('d');
      stringBuilder.append('y');
      stringBuilder.append('l');
      stringBuilder.append('i');
      stringBuilder.append('b');
      stringBuilder.append('_');
      stringBuilder.append('x');
      stringBuilder.append('8');
      stringBuilder.append('6');
      stringBuilder.append('_');
      stringBuilder.append('6');
      stringBuilder.append('4');
      a = a(stringBuilder.toString());
    }
    return a;
  }

  public static byte[] c() {
    if (c == null) {
      StringBuilder stringBuilder;
      (stringBuilder = new StringBuilder()).append('s');
      stringBuilder.append('o');
      stringBuilder.append('_');
      stringBuilder.append('x');
      stringBuilder.append('8');
      stringBuilder.append('6');
      stringBuilder.append('_');
      stringBuilder.append('6');
      stringBuilder.append('4');
      c = a(stringBuilder.toString());
    }
    return c;
  }

  public static byte[] d() {
    if (d == null) {
      StringBuilder stringBuilder;
      (stringBuilder = new StringBuilder()).append('s');
      stringBuilder.append('o');
      stringBuilder.append('_');
      stringBuilder.append('i');
      stringBuilder.append('3');
      stringBuilder.append('8');
      stringBuilder.append('6');
      d = a(stringBuilder.toString());
    }
    return d;
  }

  public static byte[] e() {
    if (d == null) {
      StringBuilder stringBuilder;
      (stringBuilder = new StringBuilder()).append('s');
      stringBuilder.append('o');
      stringBuilder.append('_');
      stringBuilder.append('a');
      stringBuilder.append('a');
      stringBuilder.append('r');
      stringBuilder.append('c');
      stringBuilder.append('h');
      stringBuilder.append('6');
      stringBuilder.append('4');
      d = a(stringBuilder.toString());
    }
    return d;
  }

  public static byte[] f() {
    if (e == null) {
      StringBuilder stringBuilder;
      (stringBuilder = new StringBuilder()).append('d');
      stringBuilder.append('l');
      stringBuilder.append('l');
      stringBuilder.append('_');
      stringBuilder.append('i');
      stringBuilder.append('3');
      stringBuilder.append('8');
      stringBuilder.append('6');
      e = a(stringBuilder.toString());
    }
    return e;
  }

  public static byte[] g() {
    if (f == null) {
      StringBuilder stringBuilder;
      (stringBuilder = new StringBuilder()).append('d');
      stringBuilder.append('l');
      stringBuilder.append('l');
      stringBuilder.append('_');
      stringBuilder.append('x');
      stringBuilder.append('8');
      stringBuilder.append('6');
      stringBuilder.append('_');
      stringBuilder.append('6');
      stringBuilder.append('4');
      f = a(stringBuilder.toString());
    }
    return f;
  }

  public static byte[] h() {
    if (g == null) {
      StringBuilder stringBuilder;
      (stringBuilder = new StringBuilder()).append('d');
      stringBuilder.append('l');
      stringBuilder.append('l');
      stringBuilder.append('_');
      stringBuilder.append('a');
      stringBuilder.append('a');
      stringBuilder.append('r');
      stringBuilder.append('c');
      stringBuilder.append('h');
      stringBuilder.append('6');
      stringBuilder.append('4');
      g = a(stringBuilder.toString());
    }
    return g;
  }

  private static byte[] a(String paramString) {
    try {
      if (h == null)
        h = l.b(l.a());
      DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(h));
      for (byte b = 0; b < 8; b++) {
        String str = dataInputStream.readUTF();
        byte[] arrayOfByte = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(arrayOfByte);
        if (str.equals(paramString))
          return arrayOfByte;
      }
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    }
    return null;
  }
}


/* Location:              /Users/apple/Downloads/9z72uyksgx.jar!/net/java/k.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */