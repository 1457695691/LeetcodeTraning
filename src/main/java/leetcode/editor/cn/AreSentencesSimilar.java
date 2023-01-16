package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/1/16 09:57
 */
public class AreSentencesSimilar {
    class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            //1.初始化两个双端队列
            Deque<String> queue1 = new ArrayDeque<>(Arrays.asList(sentence1.split(" ")));
            Deque<String> queue2 = new ArrayDeque<>(Arrays.asList(sentence2.split(" ")));
            //2.挨个比较单词是否相等，相等的出队列
            while (!queue1.isEmpty() && !queue2.isEmpty() && queue1.peekFirst().equals(queue2.peekFirst())) {
                queue1.pollFirst();
                queue2.pollFirst();
            }
            //3.挨个比较单词尾部是否相等，相等的出队列
            while (!queue1.isEmpty() && !queue2.isEmpty() && queue1.peekLast().equals(queue2.peekLast())) {
                queue1.pollLast();
                queue2.pollLast();
            }
            //4.比较两个队列是不是为空
            return queue1.isEmpty() || queue2.isEmpty();
        }
    }
}
