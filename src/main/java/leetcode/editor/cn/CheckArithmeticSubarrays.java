package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Ayuan
 * @Description: 1630. 等差子数组
 * @date 2023/3/23 09:57
 */
public class CheckArithmeticSubarrays {


    /**
     * # 暴力法当然是找到每个区间切片排序后比较差值
     * # 优化的话 首先获取子区间切片 然后不排序
     * # 扫一次记录最大最小值 依据大小值和长度算出差值
     * # 然后再扫一遍 判断当前元素是等差数列中的第几项 每个项位置都只能出现1次
     * # 满足的话就是能排成等差 不满足的话就False 空间换时间
     */
    class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            return IntStream.range(0, l.length)
                    .sorted()
                    .mapToObj(it -> isTrue(nums, l[it], r[it]))
                    .collect(Collectors.toList());
        }

        public boolean isTrue(int[] nums, int l, int r) {
            int[] its = Arrays.stream(nums)
                    .skip(l)
                    .limit(r - l + 1)
                    .sorted()
                    .toArray();
            return IntStream.range(1, its.length)
                    .sorted()
                    .map(i -> its[i] - its[i - 1])
                    .distinct()
                    .limit(2)
                    .count() <= 1;
        }
    }
}
