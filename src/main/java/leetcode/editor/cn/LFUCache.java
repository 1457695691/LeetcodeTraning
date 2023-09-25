package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @author Ayuan
 * @Description: 460. LFU 缓存
 * 最不经常使用（LFU）
 * @date 2023/9/25 09:06
 */
public class LFUCache {

    // key 到 val 的映射
    HashMap<Integer, Integer> keyToVal;
    // key 到 freq 的映射
    HashMap<Integer, Integer> keyToFreq;
    // freq 到 key 的映射
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存的最大容量
    int capacity;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        minFreq = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        //1.查找 key 是否存在
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        //2.若存在,返回对应 key 并且增加访问频次
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        //1.若 key 存在
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }
        //2.key 不存在,容量已满,淘汰一个 freq 最小的 key
        if (capacity <= keyToVal.size()) {
            removeMinFreqKey();
        }
        //3.新插入 key 和 value，对应的 freq 为 1
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }


    private void increaseFreq(int key) {
        //1.获取当前 key 的频次
        Integer freq = keyToFreq.get(key);
        //2.更新频次
        keyToFreq.put(key, freq + 1);
        //3.在当前频次列表中删除 key
        freqToKeys.get(freq).remove(key);
        //4.频次+1的列表加入 key
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);
        //5.如果当前频率队列中只有一个待移除 key 了，队列清空
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            //如果原来的频率是最小频率，那就+1
            if (freq == minFreq) {
                minFreq++;
            }
        }
    }

    private void removeMinFreqKey() {
        //1.获取 freq 最小的 key 集合
        LinkedHashSet<Integer> keyList = freqToKeys.get(minFreq);
        //2.最先被插入的 key 就是该淘汰的 key
        Integer deletedKey = keyList.iterator().next();
        //3.移除这个 key
        keyList.remove(deletedKey);
        keyToVal.remove(deletedKey);
        keyToFreq.remove(deletedKey);
        //4.如果当前 key 是列表中的最后一个数，就把整个列表都移除
        if (keyList.isEmpty()) {
            freqToKeys.remove(minFreq);
        }
    }


    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(1));
        lfuCache.put(2, 2);
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(4));
    }
}


