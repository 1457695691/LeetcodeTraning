package leetcode.editor.cn;

/**
 * 165. 比较版本号
 *
 * @author Ayuan
 */
public class CompareVersion {
    public static void main(String[] args) {
        CompareVersion.Solution solution = new CompareVersion().new Solution();
        System.out.println(solution.compareVersion("0.1", "1.1"));
    }

    class Solution {
        public int compareVersion(String version1, String version2) {
            //1.按照'.'分割两个字符串
            //2.选择最长数组遍历
            //3.按位取值,为空赋值0
            //4.模拟比较
            String[] s1 = version1.split("\\.");
            String[] s2 = version2.split("\\.");
            for (int i = 0; i < Math.max(s1.length, s2.length); i++) {
                int x = i < s1.length ? Integer.parseInt(s1[i]) : 0;
                int y = i < s2.length ? Integer.parseInt(s2[i]) : 0;
                if (x != y) {
                    return x > y ? 1 : -1;
                }
            }
            return 0;
        }
    }
}
