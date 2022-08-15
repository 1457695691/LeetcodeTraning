package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 641. 设计循环双端队列
 * @Date 2022/8/15 09:27
 */
public class MyCircularDeque {

    /**
     * 模拟队列
     */
    private final int[] queue;
    /**
     * 头下标
     */
    private int head = 0;
    /**
     * 元素个数
     */
    private int num = 0;

    private final int size;

    public MyCircularDeque(int k) {
        size = k;
        queue = new int[size];
    }

    public boolean insertFront(int value) {
        if (num == size) {
            return false;
        }
        head = (head + size - 1) % size;
        queue[head] = value;
        num++;
        return true;
    }

    public boolean insertLast(int value) {
        if (num == size) {
            return false;
        }
        num++;
        queue[(head + num - 1) % size] = value;
        return true;
    }

    public boolean deleteFront() {
        if (num == 0) {
            return false;
        }
        num--;
        head = (head + 1) % size;
        return true;
    }

    public boolean deleteLast() {
        if (num == 0) {
            return false;
        }
        num--;
        return true;
    }

    public int getFront() {
        if (num == 0) {
            return -1;
        }
        return queue[head];
    }

    public int getRear() {
        if (num == 0) {
            return -1;
        }
        return queue[(head + num - 1) % size];
    }

    public boolean isEmpty() {
        return num == 0;
    }

    public boolean isFull() {
        return num == size;
    }
}
