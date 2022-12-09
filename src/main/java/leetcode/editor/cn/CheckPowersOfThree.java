package leetcode.editor.cn;

/**
 * @author Ayuan
 * @Description: 1780. 判断一个数字是否可以表示成三的幂的和
 * @date 2022/12/9 11:14
 */
public class CheckPowersOfThree {
    class Solution {
        public boolean checkPowersOfThree(int n) {
            while(n != 0){
                if(n%3 > 1)
                    return false;
                n /= 3;
            }
            return true;
        }
    }
}
