package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1656. 设计有序流
 *
 * @author Ayuan
 */
public class OrderedStream {

    HashMap<Integer, String> map;
    int ptr;

    public OrderedStream(int n) {
        map = new HashMap<>(n);
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<>();
        map.put(idKey, value);
        while (map.containsKey(ptr)) {
            res.add(map.get(ptr));
            ptr++;
        }
        return res;
    }
}
