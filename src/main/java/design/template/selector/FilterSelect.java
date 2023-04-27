package design.template.selector;

import java.util.List;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2022/9/8 17:24
 */
public interface FilterSelect {
    boolean matchFilter(String var1);

    List<String> getFilterNames();
}
