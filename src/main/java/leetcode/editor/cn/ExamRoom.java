package leetcode.editor.cn;

import java.util.TreeSet;

/**
 * @author Ayuan
 * @Description: 855. 考场就座
 * @date 2022/12/30 09:25
 */
public class ExamRoom {

    int n;
    //有序set集合
    TreeSet<Integer> treeSet;

    public ExamRoom(int n) {
        this.n = n - 1;
        this.treeSet = new TreeSet<>();
    }

    public int seat() {
        int student = 0;
        if (treeSet.size() > 0) {
            //距离
            int dist = treeSet.first();
            //前驱节点
            Integer prev = null;
            for (Integer s : treeSet) {
                if (prev != null) {
                    //找中间节点
                    int mid = (s - prev) / 2;
                    if (mid > dist) {
                        dist = mid;
                        student = prev + mid;
                    }
                }
                prev = s;
            }
            //判断距离哪个长
            if (n - treeSet.last() > dist) {
                student = n;
            }

        }
        treeSet.add(student);
        return student;
    }

    public void leave(int p) {
        treeSet.remove(p);
    }
}
