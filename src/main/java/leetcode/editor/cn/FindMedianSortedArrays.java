package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * @author Ayuan
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        FindMedianSortedArrays.Solution solution = new FindMedianSortedArrays().new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double out = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(out);
    }

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            //todo:优化思路:二分法 为了代码好看,直接用api了.但是nums3数组元素前一半根本没必要存.一次遍历赋值的时候根据长度就可以拿到奇偶性,遍历的时候直接取到需要的值返回就完事了
            //1.数组合并并排序
            int[] nums3 = Arrays.copyOf(nums1, nums1.length + nums2.length);
            System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);
            Arrays.sort(nums3);
            //2.判断长度奇偶性
            if ((nums3.length & 1) == 1) {
                //3.奇数->取中间
                return nums3[nums3.length / 2];
            } else {
                //4.偶数->中间俩值得平均数
                return (nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2.0;
            }
        }
    }

}
