package algorithm.kmp;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/6/13 11:54
 */
public class KMPExample {

    public static int[] getNext(String pattern) {

        int[] next = new int[pattern.length()];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < pattern.length() - 1) {

            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {

                i++;
                j++;
                next[i] = j;
            } else {

                j = next[j];
            }
        }
        return next;
    }

    public static int kmp(String text, String pattern) {

        int[] next = getNext(pattern);
        int i = 0, j = 0;
        while (i < text.length() && j < pattern.length()) {

            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {

                i++;
                j++;
            } else {

                j = next[j];
            }
        }
        if (j == pattern.length()) {

            return i - j;
        } else {

            return -1;
        }
    }

    public static void main(String[] args) {

        String text = "为程序员一定学习编程之道，一定要对代码的编写有追求，不能实现就完事了。我们应该让自己写的代码更加优雅，即使这会费时费力";
        String pattern = "不能实现就完事了";
        int index = kmp(text, pattern);
        if (index != -1) {

            System.out.println("Pattern found at index " + index);
        } else {

            System.out.println("Pattern not found");
        }
    }
}

