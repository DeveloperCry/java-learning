package learning.expression;

import org.junit.Test;

import java.util.HashMap;

public class ExpressionTest {
    @Test
    public void testExpression() {
        String expStr = getExpStr();
        HashMap<String, Integer> var = getValue(expStr);
        Calculator calculator = new Calculator(expStr);
        System.out.println("运算结果：" + expStr + "=" + calculator.run(var));
    }

    //获得表达式
    public String getExpStr(){
        return "a+b-c-d";
    }

    //获得值映射
    public HashMap<String, Integer> getValue(String expStr){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 100);
        map.put("c", 30);
        map.put("d", 20);
        map.put("b", 10);

        return map;
    }
}
