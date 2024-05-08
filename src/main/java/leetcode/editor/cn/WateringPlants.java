package leetcode.editor.cn;

//2079.给植物浇水
public class WateringPlants {
    public static void main(String[] args) {
        Solution solution = new WateringPlants().new Solution();
        int[] plants = {2, 2, 3, 3};
        int capacity = 5;
        int res = solution.wateringPlants(plants, capacity);
        System.out.println(res);
    }

    class Solution {
        public int wateringPlants(int[] plants, int capacity) {
            int max = capacity;
            int res = 0;
            for (int i = 0; i < plants.length; i++) {
                if (capacity < plants[i]) {
                    res += (2 * i + 1);
                    capacity = max - plants[i];
                } else {
                    res++;
                    capacity -= plants[i];
                }
            }
            return res;
        }
    }
}
