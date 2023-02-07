package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Ayuan
 * @Description: 1604. 警告一小时内使用相同员工卡大于等于三次的人
 * @date 2023/2/7 09:25
 */
public class AlertNames {

    class Solution {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            List<String> ans = new ArrayList<>();
            TreeMap<String, List<Integer>> map = new TreeMap<>();

            for (int i = 0; i < keyName.length; i++) {
                String name = keyName[i];
                String time = keyTime[i];
                String[] split = time.split(":");
                int temp = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
                List<Integer> timeList;
                if (map.containsKey(name)) {
                    timeList = map.get(name);
                } else {
                    timeList = new ArrayList<>();
                }
                timeList.add(temp);
                map.put(name, timeList);
            }

            for (String name : map.keySet()) {
                List<Integer> timeList = map.get(name);
                Collections.sort(timeList);
                if (timeList.size() >= 3) {
                    for (int i = 2; i < timeList.size(); i++) {
                        if (timeList.get(i) - timeList.get(i - 2) <= 60) {
                            // 一小时内打卡三次
                            ans.add(name);
                            break;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
