package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 1487. 保证文件名唯一
 * @date 2022/9/7 14:48
 */
public class GetFolderNames {
    public static void main(String[] args) {
        Solution solution = new GetFolderNames().new Solution();
        String[] names = {"kaido", "kaido(1)", "kaido", "kaido(1)"};
        String[] out = solution.getFolderNames(names);
        System.out.println(Arrays.toString(out));
    }

    /**
     * 思路：map k：文件名 v：k
     */
    class Solution {
        public String[] getFolderNames(String[] names) {
            String[] res = new String[names.length];
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < names.length; i++) {
                int k = map.getOrDefault(names[i], -1) + 1;
                //由于存在原始文件名 xxx(1) 这种情况，需要先拆解对应的文件名和k
                String name = names[i] + (k == 0 ? "" : "(" + k + ")");
                //循环找到不重名的文件名和对应的k
                while (map.containsKey(name)) {
                    k++;
                    name = names[i] + (k == 0 ? "" : "(" + k + ")");
                }
                res[i] = name;
                //老文件名对应的k+1
                map.put(names[i], map.getOrDefault(names[i], -1) + 1);
                //新文件名也要扔进去并把k设置为0
                map.put(res[i], 0);
            }
            return res;
        }
    }
}
