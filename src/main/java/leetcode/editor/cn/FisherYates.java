package leetcode.editor.cn;

import java.util.Random;

/**
 * 384. 打乱数组
 *
 * @author Ayuan
 */
public class FisherYates {
    int[] nums;
    int[] shuffle;
    Random random;

    public FisherYates(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    /**
     * Fisher-Yates洗牌算法
     * 1.从后往前遍历
     * 2.随机生成一个数和最后一位交换
     * 3.指针向前移动一位
     */
    public int[] shuffle() {
        shuffle = nums.clone();
        for (int i = shuffle.length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1);
            swap(i, j);
        }
        return shuffle;
    }

    private void swap(int i, int j) {
        int tmp = shuffle[i];
        shuffle[i] = shuffle[j];
        shuffle[j] = tmp;
    }

}
