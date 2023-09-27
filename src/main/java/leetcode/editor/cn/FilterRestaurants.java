package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ayuan
 * @Description: 1333. 餐厅过滤器
 * @date 2023/9/27 09:17
 */
public class FilterRestaurants {

    /**
     * restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]
     * veganFriendly为true or false
     */

    class Solution {
        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            return Arrays.stream(restaurants)
                    .filter(i -> veganFriendly == 0 || i[2] == 1)
                    .filter(i -> i[3] <= maxPrice)
                    .filter(i -> i[4] <= maxDistance)
                    .sorted((o1, o2) -> o1[1] != o2[1] ? o2[1] - o1[1] : o2[0] - o1[0])
                    .map(o -> o[0])
                    .collect(Collectors.toList());

        }
    }
}
