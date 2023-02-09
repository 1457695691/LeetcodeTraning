package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ayuan
 * @Description: 1797. 设计一个验证系统
 * @date 2023/2/9 09:40
 */
public class AuthenticationManager {
    final int timeToLive;
    Map<String, Integer> map;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.getOrDefault(tokenId, -1) > currentTime) {
            map.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        return (int) map.values().stream().filter(t -> t > currentTime).count();
    }
}