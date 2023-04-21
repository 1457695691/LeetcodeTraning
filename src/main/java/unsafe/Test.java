package unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/4/21 17:57
 */
public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Guard guard = new Guard();
        boolean a = guard.giveAccess();// false, no access
        System.out.println(a);

        // bypass
//        Unsafe unsafe = getUnsafe();
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        Field f = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
        unsafe.putInt(guard, unsafe.objectFieldOffset(f), 42);
        boolean b = guard.giveAccess();
        System.out.println(b);
    }
}
