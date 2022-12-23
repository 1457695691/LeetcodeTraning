package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2011. 执行操作后的变量值
 * @date 2022/12/23 09:52
 */
public class FinalValueAfterOperations {
    class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int res = 0;
            for (String operation : operations) {
                res += operation.charAt(1) == '-' ? -1 : 1;
            }
            return res;
        }
    }
}
