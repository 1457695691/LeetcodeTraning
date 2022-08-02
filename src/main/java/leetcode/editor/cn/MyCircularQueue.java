package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 622. 设计循环队列
 * @date 2022/8/2 11:48
 */
public class MyCircularQueue {

    private int[] queue;
    /**
     * 队首下标
     */
    private int head;
    /**
     * 当前队列元素个数
     */
    private int num;
    /**
     * 数组总空间大小
     */
    private int size;

    public MyCircularQueue(int k) {
        size = k;
        queue = new int[size];
    }

    /**
     * 入队列
     */
    public boolean enQueue(int value) {
        if (size == num) {
            return false;
        }
        num++;
        queue[(head + num - 1) % size] = value;
        return true;
    }

    /**
     * 出队列
     */
    public boolean deQueue() {
        if (num == 0) {
            return false;
        }
        num--;
        head = (head + 1) % size;
        return true;
    }

    public int Front() {
        if (num == 0) {
            return -1;
        }
        return queue[head];
    }

    public int Rear() {
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
