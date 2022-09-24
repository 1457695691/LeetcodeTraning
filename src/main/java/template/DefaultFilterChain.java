package template;

import template.common.OrderContext;

import java.util.Objects;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2022/9/8 17:12
 */
public class DefaultFilterChain<T extends OrderContext> implements OrderFilterChain<T> {
    private OrderFilterChain<T> next;
    private OrderFilter<T> filter;

    public DefaultFilterChain(OrderFilterChain<T> next, OrderFilter<T> filter) {
        this.next = next;
        this.filter = filter;
    }

    /**
     * 传递上下文
     *
     * @param context 上下文
     */
    @Override
    public void handle(T context) {
        this.filter.doFilter(context, this);
    }

    /**
     * 寻找下一个
     *
     * @param ctx 上下文
     */
    @Override
    public void fireNext(T ctx) {
        OrderFilterChain<T> nextChain = this.next;
        if (Objects.nonNull(nextChain)) {
            nextChain.handle(ctx);
        }
    }
}
