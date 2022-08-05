package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.BiFunction;

/**
 * @author Ayuan
 * @Description: 剑指 Offer II 036. 后缀表达式
 * @date 2022/8/5 11:49
 */
public class EvalRPN {
    public static void main(String[] args) {
        EvalRPN.Solution solution = new EvalRPN().new Solution();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int out = solution.evalRPN(tokens);
        System.out.println(out);
    }

    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            BiFunction<Integer, Integer, Integer> divide = (it1, it2) -> it2 / it1;
            Arrays.stream(tokens).forEachOrdered(token -> {
                switch (token) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        stack.push(divide.apply(stack.pop(), stack.pop()));
                        break;
                    default:
                        stack.push(Integer.parseInt(token));
                }
            });
            return stack.pop();
        }
    }
}

