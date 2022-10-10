package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 801. 使序列递增的最小交换次数
 * @date 2022/10/10 09:31
 */
public class MinSwap {
    class Solution {
        public int minSwap(int[] nums1, int[] nums2) {
            //1.初始化dp[i][j]，标识当前累积的操作次数
            int[][] dp = new int[nums1.length][2];
            //2.默认值 j = 1代表交换， j=0代表不交换
            dp[0][0] = 0;
            dp[0][1] = 1;
            //3.遍历数组并分情况讨论
            for (int i = 1; i < nums1.length; i++) {
                int a1 = nums1[i - 1];
                int a2 = nums1[i];
                int b1 = nums2[i - 1];
                int b2 = nums2[i];
                //3.1 nums1和nums2递增，a1,b1、a2,b2随便换
                if ((a1 < a2 && b1 < b2) && (b1 < a2 && a1 < b2)) {
                    // 如果i【不互换】，则i-1可【互换】也可【不互换】
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                    // 如果i【互换】，则i-1可【互换】也可【不互换】
                    dp[i][1] = dp[i][0] + 1;
                }
                //3.2 nums1和nums2递增，a1,b1互换之后a2,b2也必须互换
                else if (a1 < a2 && b1 < b2) {
                    // 如果i【不互换】，则i-1必须【不互换】
                    dp[i][0] = dp[i - 1][0];
                    // 如果i【互换】，则i-1必须【互换】
                    dp[i][1] = dp[i - 1][1] + 1;
                }
                //3.3 nums1和nums2不递增，a1,b1互换或者a2,b2互换
                else {
                    // 如果i【不互换】，则i-1必须【互换】
                    dp[i][0] = dp[i - 1][1];
                    // 如果i【互换】，则i-1必须【不互换】
                    dp[i][1] = dp[i - 1][0] + 1;
                }
            }
            return Math.min(dp[nums1.length - 1][0], dp[nums1.length - 1][1]);
        }
    }
}
