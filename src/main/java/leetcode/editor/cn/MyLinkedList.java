package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 707. 设计链表
 * @date 2022/9/23 10:16
 */
public class MyLinkedList {

    class Node {
        /**
         * 存储的元素
         */
        private int val;
        /**
         * 下一个节点，前一个节点
         */
        private Node next, prev;

        /**
         * 默认构造函数
         */
        public Node(int val) {
            this.val = val;
        }

        public Node() {
        }
    }

    /**
     * 当前链表的结点数量
     */
    private int size;
    /**
     * 指向虚拟头节点
     */
    private Node head;
    /**
     * 指向尾节点
     */
    private Node tail;

    public MyLinkedList() {
        //创建一个带头结点的虚拟节点
        this.head = new Node();
        this.tail = this.head;
        this.size = 0;
    }

    public int get(int index) {
        if (index > size - 1) {
            return -1;
        }
        Node cur = head.next;
        int i = 0;
        //找到位置
        while (i < index) {
            cur = cur.next;
            i++;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        size++;
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
        if (size == 1) {
            tail = node;
        }
    }

    public void addAtTail(int val) {
        size++;
        Node node = new Node(val);
        tail.next = node;
        tail = node;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index < 0) {
            addAtHead(val);
            return;
        }
        //遍历到index前一个元素
        Node cur = head;
        int i = 0;
        while (i < index) {
            cur = cur.next;
            i++;
        }
        Node node = new Node(val);
        node.next = cur.next;
        cur.next = node;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index > size - 1 || index < 0) {
            return;
        }
        //找到index前一个节点
        Node cur = head;
        int i = 0;
        while (i < index) {
            cur = cur.next;
            i++;
        }
        //维护尾指针
        if (cur.next == tail) {
            tail = cur;
        }
        //如果存在当前节点，删除
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        size--;
    }
}
