package algorithm.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/4/21 16:29
 */
@Slf4j
public class GuavaDesign {
    BloomFilter<Integer> filter = BloomFilter.create(
            //Funnel 是一个接口，用于将任意类型的对象转换为字节流，
            //以便用于布隆过滤器的哈希计算。
            Funnels.integerFunnel(),
            10000,    // 插入数据条目数量
            0.001    // 误判率
    );

    public boolean maycontain(Long id) {
        return filter.mightContain(Math.toIntExact(id));
    }


}
