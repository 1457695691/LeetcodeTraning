package leetcode.editor.cn;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ayuan
 * @Description: 753. 破解保险箱
 * @date 2023/1/10 10:36
 */
public class CrackSafe {

    public static void main(String[] args) {
        CrackSafe.Solution solution = new CrackSafe().new Solution();
        String out = solution.crackSafe(3, 2);
        System.out.println(out);
    }


    /**
     * 思路：欧拉回路
     */
    class Solution {
        StringBuilder sb = new StringBuilder();
        int n, k, mod;
        Set<Integer> vis = new HashSet<>(); //判断每条边是否访问过

        public String crackSafe(int n, int k) {
            this.n = n;
            this.k = k;
            mod = (int) Math.pow(10, n - 1);
            dfs(0); //从0点出发
            sb.append(StringUtils.repeat("0", n - 1));
            return sb.toString();
        }

        void dfs(int u) {
            for (int i = 0; i < k; i++) { //对于每个点循环k条边即可
                int v = u * 10 + i; //即边的编号
                if (vis.contains(v)) {
                    continue;
                }
                vis.add(v);    //标记该边已经访问
                dfs(v % mod); //去掉第一位为结点编号
                sb.append(i); //添加最后一个数字
            }
        }
    }
}
