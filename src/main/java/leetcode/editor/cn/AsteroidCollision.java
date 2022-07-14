package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ayuan
 * @Description: 735. 行星碰撞
 * @date 2022/7/14 17:46
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        AsteroidCollision.Solution solution = new AsteroidCollision().new Solution();
    }

    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int aster : asteroids) {
                boolean alive = true;
                while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                    alive = stack.peek() < -aster; // aster 是否存在
                    if (stack.peek() <= -aster) {  // 栈顶行星爆炸
                        stack.pop();
                    }
                }
                //活着扔栈里
                if (alive) {
                    stack.push(aster);
                }
            }
            //依次出栈
            int[] ans = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                ans[i] = stack.pop();
            }
            return ans;
        }
    }
}
