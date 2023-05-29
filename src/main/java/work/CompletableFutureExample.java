package work;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/5/16 10:44
 */
public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<List<Integer>> partition = Lists.partition(integers, 3);
        System.out.println(partition);

    }
}