package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 2325. 解密消息
 * @date 2023/2/1 09:39
 */
public class DecodeMessage {

    class Solution {
        public String decodeMessage(String key, String message) {
            char[] map = new char[26];
            char c = 'a';
            //数组模拟map，去掉key空格
            for (char i : key.toCharArray()) {
                if (i != ' ' && map[i - 'a'] == 0) {
                    map[i - 'a'] = c++;
                }
            }
            //替换对应字符
            char[] mess = message.toCharArray();
            for (int i = 0; i < mess.length; i++) {
                if (mess[i] != ' ') {
                    mess[i] = map[mess[i] - 'a'];
                }
            }
            //转为string
            return new String(mess);
        }
    }
}
