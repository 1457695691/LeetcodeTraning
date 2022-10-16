package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1790. 仅执行一次字符串交换能否使两个字符串相等
 * @date 2022/10/11 09:16
 */
public class AreAlmostEqual {

    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            //长度为2的数组存储不一样的索引
            int[] diff = new int[2];
            //存储一共有几个不一样的字符
            int count = 0;
            //遍历两个字符串，找不同
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    //有多个不一样的直接返回false
                    if (count >= 2) {
                        return false;
                    }
                    diff[count] = i;
                    count++;
                }
            }
            //交换位置比较是否相等
            return s1.charAt(diff[0]) == s2.charAt(diff[1]) && s2.charAt(diff[0]) == s1.charAt(diff[1]);
        }
    }
}
