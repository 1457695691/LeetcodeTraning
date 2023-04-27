package design.template;

import design.template.common.OrderContext;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2022/9/8 17:10
 */
public interface OrderFilter<T extends OrderContext> {

    /**
     * 处理业务逻辑
     *
     * @param var1 上下文
     * @param var2 chain
     */
    void doFilter(T var1, OrderFilterChain var2);

}
