package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

/**
 * @author Ayuan
 * @Description: 1206. 设计跳表
 * @date 2022/7/26 09:41
 */
public class Skiplist {

    class Node {
        private int val;
        private Node next;
        private Node down;

        public Node(int val, Node next, Node down) {
            this.val = val;
            this.next = next;
            this.down = down;
        }
    }

    private Node head;
    private Random random;

    public Skiplist() {
        this.head = new Node(-1, null, null);
        this.random = new Random();
    }

    public boolean search(int target) {
        Node curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val < target) {
                curr = curr.next;
            }
            if (curr.next != null && curr.next.val == target) {
                return true;
            }
            curr = curr.down;
        }
        return false;
    }

    public void add(int num) {
        Node curr = head;
        Deque<Node> queue = new ArrayDeque<>();
        while (curr != null) {
            while (curr.next != null && curr.next.val < num) {
                curr = curr.next;
            }
            queue.offerLast(curr);
            curr = curr.down;
        }

        boolean isInsert = true;
        Node down = null;
        while (isInsert && !queue.isEmpty()) {
            curr = queue.pollLast();
            curr.next = new Node(num, curr.next, down);
            down = curr.next;
            isInsert = random.nextDouble() < 0.5;
        }
        if (isInsert) {
            head = new Node(-1, null, head);
        }
    }

    public boolean erase(int num) {
        Node curr = head;
        boolean isFound = false;
        while (curr != null) {
            while (curr.next != null && curr.next.val < num) {
                curr = curr.next;
            }
            if (curr.next != null && curr.next.val == num) {
                curr.next = curr.next.next;
                isFound = true;
            }
            curr = curr.down;
        }
        return isFound;
    }
}


class test {
    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);

        System.out.println(skiplist.search(0));// 返回 false;
        System.out.println(skiplist.search(0));// 返回 false
        skiplist.add(4);
        System.out.println(skiplist.search(1));// 返回 true
        System.out.println(skiplist.erase(0));// 返回 false，0 不在跳表中
        System.out.println(skiplist.erase(1));// 返回 true
        System.out.println(skiplist.search(1));// 返回 false，1 已被擦除
    }
}