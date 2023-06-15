package test;

public class KMPTest {
    //实测  KMP 与 indexOf
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sb.append("0");
        }
        sb.append("1");

        String str = sb.toString();


        String match = "0000001";
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            getIndexOf(str, match);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("KMP:" + (t2 - t1));


        t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            str.indexOf(match);
        }
        t2 = System.currentTimeMillis();
        System.out.println("indexof:" + (t2 - t1));


    }

    public static void getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || m.length() > s.length())
            return;

        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();

        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);

        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }

        }
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;

        while (pos < ms.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;

    }

}