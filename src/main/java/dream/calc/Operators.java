package dream.calc;

import dream.calc.model.MathOperators.SubtractOperator;
import dream.calc.model.MathOperators.SumOperators;
import dream.calc.model.interfaces.Task;

import java.util.HashMap;

/**
 * Created by Splayd on 09.04.2017.
 * Creating operators
 */
public class Operators {
    private static HashMap<String, Task> operatorsMap = new HashMap<>();

    public static void operatorsCreate() {
        operatorsMap.put("+", new SumOperators());
        operatorsMap.put("-", new SubtractOperator());
    }

    public static HashMap<String, Task> getOperatorsMap() {
        return operatorsMap;
    }

    public static void setOperatorsMap(HashMap<String, Task> operatorsMap) {
        Operators.operatorsMap = operatorsMap;
    }
}
