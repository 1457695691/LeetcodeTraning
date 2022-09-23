package template;

import template.common.OrderContext;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2022/9/8 17:18
 */
public abstract class AbstractOrderFilter<T extends OrderContext> implements OrderFilter<T> {
    public AbstractOrderFilter() {
    }

    @Override
    public void doFilter(T context, OrderFilterChain chain) {
        //跳链用，在上下文里存名字
        if (context.getFilterSelect().matchFilter(this.getClass().getSimpleName())) {
            this.handle(context);
        }

        if (context.continueFilter()) {
            chain.fireNext(context);
        }
    }


    public abstract void handle(T var1);
}
