package utils;

import java.util.HashMap;
import java.util.Map;

public class LruUtils {
    class DLinkedNode {
        int key, value;
        DLinkedNode prev, next;

        public DLinkedNode() {
        }

        public DLinkedNode(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;


    public LruUtils(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //判断key是否存在
        DLinkedNode node = cache.get(key);
        //不存在直接返回
        if (null == node) {
            return -1;
        }
        //存在，先通过哈希表定位，再移动到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (null == node) {
            //1。创建新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            //2.添加进哈希表
            cache.put(key, newNode);
            //3.移动到链表头
            addToHead(newNode);
            //4.size加一
            ++size;
            if (size > capacity) {
                //超出容量，删除末尾节点
                DLinkedNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            //key存在 1.通过哈希表定位 2.修改value
            node.value = value;
            //3.移动到头部
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        /**
         * 1.newNode = 2
         *
         * old :   hear <-> 1 <-> tail
         * new :   head <-> 2 <-> 1 <-> tail
         *
         */
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }


    public static void main(String[] args) {

    }
}
