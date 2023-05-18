package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2446. 判断两个事件是否存在冲突
 * @date 2023/5/17 09:40
 */
public class HaveConflict {
    class Solution {
        public boolean haveConflict(String[] event1, String[] event2) {
            return !(event2[0].compareTo(event1[1]) > 0 || event2[1].compareTo(event1[0]) < 0);
        }
    }
}
