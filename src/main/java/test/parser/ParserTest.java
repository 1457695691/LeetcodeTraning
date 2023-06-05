package test.parser;

import com.manticore.jsqlformatter.JSQLFormatter;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import org.junit.jupiter.api.Assertions;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/5/29 16:10
 */
public class ParserTest {
    public static void main(String[] args) throws Exception {
        String sqlStr = "select 1 from dual where a=b";
        String formattedSql = JSQLFormatter.format(sqlStr);
        System.out.println(formattedSql);

        Statement statement = CCJSqlParserUtil.parse(sqlStr);
        if (statement instanceof Select) {
            Select select = (Select) statement;
            PlainSelect plainSelect = (PlainSelect) select.getSelectBody();

            SelectExpressionItem selectExpressionItem = (SelectExpressionItem) plainSelect.getSelectItems().get(0);
            Assertions.assertEquals(new LongValue(1), selectExpressionItem.getExpression());

            Table table = (Table) plainSelect.getFromItem();
            Assertions.assertEquals("dual", table.getName());

            EqualsTo equalsTo = (EqualsTo) plainSelect.getWhere();
            Column a = (Column) equalsTo.getLeftExpression();
            Column b = (Column) equalsTo.getRightExpression();
            Assertions.assertEquals("a", a.getColumnName());
            Assertions.assertEquals("b", b.getColumnName());
        }
    }
}
