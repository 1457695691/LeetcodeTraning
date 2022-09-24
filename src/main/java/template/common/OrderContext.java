package template.common;

import template.selector.FilterSelect;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2022/9/8 17:05
 */
public interface OrderContext {

    BizEnum getBizCode();

    FilterSelect getFilterSelect();

    boolean continueFilter();
}
