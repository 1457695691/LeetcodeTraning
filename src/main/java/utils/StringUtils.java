package utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ayuan
 */
public class StringUtils {
    public static void main(String[] args) {
        List<String> x = Collections.singletonList("1");
        List<String> y = x.stream().limit(2).collect(Collectors.toList());
        System.out.println(y);
    }
}
