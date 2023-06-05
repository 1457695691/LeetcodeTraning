package test.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Ayuan
 * @Description: Unsafe分配
 * @date 2023/4/21 17:48
 */
public final class UnsafeAllocator {
    static final Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public long allocate(long size) {
        return unsafe.allocateMemory(size);
    }

    public void free(long peer) {
        unsafe.freeMemory(peer);
    }

}
