package leetcode.editor.cn;

import java.util.List;

/**
 * @author Ayuan
 * @Description: 1238. 循环码排列
 * @date 2023/2/23 09:52
 */
public class CircularPermutation {

    /**
     * 格雷码
     */
    private static final List<Integer> LIST = new java.util.AbstractList<Integer>() {
        @Override
        public Integer get(int index) {
            return (index >>> 1) ^ index ^ stt;
        }

        @Override
        public int size() {
            return size;
        }
    };
    private static int size;
    private static int stt;

    class Solution {
        public List<Integer> circularPermutation(int n, int start) {
            size = 1 << n;
            stt = start;
            return LIST;
        }
    }
}
