package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 670. 最大交换
 * @date 2022/9/13 09:35
 */
public class MaximumSwap {
    public static void main(String[] args) {
        MaximumSwap.Solution solution = new MaximumSwap().new Solution();
        int out = solution.maximumSwap(1993);
        System.out.println(out);

    }

    class Solution {
        public int maximumSwap(int num) {
            //1.定义排序数组和原数组
            char[] orderArray = Integer.toString(num).toCharArray();
            char[] oldArray = Integer.toString(num).toCharArray();
            //2.将排序数组排好序，
            Arrays.sort(orderArray);
            //3.两个数组的差
            int diff = -1;
            //4.遍历排序数组找到第一个不同的元素
            for (int i = 0; i < orderArray.length; i++) {
                if (oldArray[i] != orderArray[orderArray.length - i - 1]) {
                    diff = i;
                    break;
                }
            }
            //5.如果差值==-1，则表示俩数组相同，直接返回
            if (diff == -1) {
                return num;
            }
            //6.如果差值>-1,则两两交换
            for (int i = oldArray.length - 1; i >= diff; i--) {
                if (oldArray[i] == orderArray[orderArray.length - diff - 1]) {
                    char tmp = oldArray[diff];
                    oldArray[diff] = oldArray[i];
                    oldArray[i] = tmp;
                    break;
                }
            }
            return Integer.parseInt(new String(oldArray));
        }
    }

}
