package leetcode.editor.cn;

import java.util.Random;

/**
 * 382. 链表随机节点
 *
 * @author Ayuan
 */
public class Cistern {
    ListNode head;
    Random random;

    public Cistern(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /**
     * 蓄水池抽样算法
     */
    public int getRandom() {
        int i = 0, res = 0;
        ListNode cur = head;
        while (cur != null) {
            i++;
            if (random.nextInt(i) == 0) {
                res = cur.val;
            }
            cur = cur.next;
        }
        return res;
    }
}
