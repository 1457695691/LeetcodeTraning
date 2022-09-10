package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1598. 文件夹操作日志搜集器
 * @date 2022/9/9 09:30
 */
public class MinOperations {
    class Solution {
        public int minOperations(String[] logs) {
            int res = 0;
            for (String log : logs) {
                switch (log) {
                    case "../":
                        //返回上一层，结果-1
                        res = res == 0 ? 0 : res - 1;
                        break;
                    case "./":
                        //停留在本层，结果不变
                        continue;
                    default:
                        //子文件夹，结果+1
                        res ++;
                }
            }
            return res;
        }
    }
}
