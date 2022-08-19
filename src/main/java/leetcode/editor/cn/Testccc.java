package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Ayuan
 */
public class Testccc {

    public void xxx() {
        String[] strings = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        Arrays.sort(strings, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(strings));
    }

    public static void main(String[] args) {
        Testccc test = new Testccc();
        test.xxx();
    }
}
