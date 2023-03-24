package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Ayuan
 * @Description: 1032. 字符流
 * @date 2023/3/24 09:34
 */
public class StreamChecker {
    /**
     * # AC自动机:字符串多模式多次匹配
     * 匹配从输入字符串变为输入字符流，这样只需在AC自动机的基础实现上保存前一个字符匹配的AC树结点，当前字符从这个结点继续开始匹配。
     */
    ACNode root;
    ACNode p;

    public StreamChecker(String[] words) {
        // 构造字典树
        this.root = new ACNode(' ');
        this.p = root;
        for (String word : words) {
            ACNode temp = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (temp.children[idx] == null) {
                    temp.children[idx] = new ACNode(c);
                }
                temp = temp.children[idx];
            }
            temp.isEnding = true;
            temp.length = word.length();
        }
        // 维护失败指针
        buildFailPointer();
    }

    private void buildFailPointer() {
        Queue<ACNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ACNode p = queue.poll();
            for (int i = 0; i < 26; i++) {
                ACNode pc = p.children[i];
                if (pc == null) {
                    continue;
                }
                if (p == root) {
                    pc.fail = root;
                } else {
                    ACNode q = p.fail;
                    while (q != null && q.children[i] == null) {
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    } else {
                        pc.fail = q.children[i];
                    }
                }
                queue.add(pc);
            }
        }
    }

    public boolean query(char letter) {
        int idx = letter - 'a';
        while (this.p != root && p.children[idx] == null) {
            p = p.fail;
        }
        p = p.children[idx];
        if (p == null) {
            p = root;
        }
        ACNode temp = p;
        while (temp != root) {
            if (temp.isEnding) {
                return true;
            }
            temp = temp.fail;
        }
        return false;
    }
}

class ACNode {
    char c;
    boolean isEnding;
    int length = -1;

    ACNode[] children = new ACNode[26];
    ACNode fail;

    ACNode(char c) {
        this.c = c;
    }
}

