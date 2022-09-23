package template.selector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2022/9/9 10:04
 */
public class LocalListBasedFilterSelector implements FilterSelect {
    private List<String> filterNames = new ArrayList<>();


    @Override
    public boolean matchFilter(String classSimpleName) {
        return this.filterNames.stream().anyMatch((s) -> Objects.equals(s, classSimpleName));
    }

    @Override
    public List<String> getFilterNames() {
        return this.filterNames;
    }


    public LocalListBasedFilterSelector() {
    }

    public LocalListBasedFilterSelector(List<String> filterNames) {
        this.filterNames = filterNames;
    }


}
