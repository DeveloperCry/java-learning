package learning.expression.support;

import learning.expression.Expression;

import java.util.HashMap;

/**
 * TerminalExpression
 */
public class VarExpression extends Expression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(key);
    }
}
