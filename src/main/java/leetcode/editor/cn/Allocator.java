package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author Ayuan
 * @Description: 2502. 设计内存分配器
 * @date 2022/12/12 16:45
 */
public class Allocator {

    //用数组模拟连续内存空间
    int[] map;
    //可用内存块大小
    int totalSize;

    public Allocator(int n) {
        map = new int[n];
        totalSize = n;
    }

    public int allocate(int size, int mID) {
        int use = 0;
        for (int i = 0; i < totalSize; i++) {
            if (map[i] == 0) {
                use++;
            } else {
                use = 0;
            }
            if (use == size) {
                Arrays.fill(map, i + 1 - size, i + 1, mID);
                return i + 1 - size;
            }
        }
        return -1;
    }

    public int free(int mID) {
        //移除的块总数
        int res = 0;
        //暴力匹配mId,找到就+1，并且map置为0
        for (int i = 0; i < totalSize; i++) {
            if (map[i] == mID) {
                res++;
                map[i] = 0;
            }
        }
        return res;
    }
}
