package leetcode.editor.cn;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 *
 * @author Ayuan
 */
public class MyQueue {

    Stack<Integer> stack1, stack2;

    public MyQueue() {
        //先入先出
        stack1 = new Stack<>();
        //先入后出
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
