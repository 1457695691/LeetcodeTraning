package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2831. 找出最长等值子数组
 */
public class LongestEqualSubarray {
    public static void main(String[] args) {
        Solution solution = new LongestEqualSubarray().new Solution();
        List<Integer> nums = new ArrayList<>();
        int k = 2;
        int res = solution.longestEqualSubarray(nums, k);
        System.out.println(res);
    }


        class Solution {
            public int longestEqualSubarray(List<Integer> nums, int k) {
                int n = nums.size();
                int[] cnt = new int[n + 1];
                int ans = 0;
                for (int l = 0,r = 0;r < n;r++){
                    int cur = nums.get(r);
                    cnt[cur]++;
                    ans = Math.max(ans,cnt[cur]);
                    if(r - l + 1 - ans > k){
                        cnt[nums.get(l++)]--;
                    }
                }
                return ans;
            }
        }
}
