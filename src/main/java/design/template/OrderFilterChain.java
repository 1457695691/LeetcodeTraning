package design.template;

import design.template.common.OrderContext;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2022/9/8 17:05
 */
public interface OrderFilterChain<T extends OrderContext> {


    /**
     * 传递上下文
     *
     * @param var1 上下文
     */
    void handle(T var1);


    /**
     * 寻找下一个
     *
     * @param var1 上下文
     */
    void fireNext(T var1);
}
