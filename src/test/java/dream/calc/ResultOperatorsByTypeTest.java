package dream.calc;

import dream.calc.model.MathOperators.SubtractOperator;
import dream.calc.model.MathOperators.SumOperators;
import dream.calc.model.Types.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Splayd on 19.04.2017.
 * Test of result different operation on different type
 */
public class ResultOperatorsByTypeTest {

    @Before
    public void setUp() {
        Separate.setArgumentsArray(new ArrayList<>());
        Separate.setOperatorsArray(new ArrayList<>());
        ArgumentsType.setArgumentsByTypeArray(new ArrayList<>());
        ArgumentsType.setResultArray(new ArrayList<>());
    }

    @Test
    public void subsIntArguments() throws InvalidInputException {
        Operators.getOperatorsMap().put("/", new SubtractOperator());
        ArgumentsType.getMapOfTypes().put("Date", new ParseInt());
        String actual = Calc.bootCalc("/,2,2", "Date");
        assertEquals("0", actual);
    }

    @Test
    public void subsDoubleArguments() throws InvalidInputException {
        Operators.getOperatorsMap().put("/", new SubtractOperator());
        ArgumentsType.getMapOfTypes().put("Date", new ParseDouble());
        String actual = Calc.bootCalc("/,3.1,2.1", "Date");
        assertEquals("1", actual);
    }

    @Test
    public void subsFloatArguments() throws InvalidInputException {
        Operators.getOperatorsMap().put("/", new SubtractOperator());
        ArgumentsType.getMapOfTypes().put("Date", new ParseFloat());
        String actual = Calc.bootCalc("/,2.3,2.0", "Date");
        assertEquals("0.3", actual);
    }

    @Test
    public void subsLongArguments() throws InvalidInputException {
        Operators.getOperatorsMap().put("/", new SubtractOperator());
        ArgumentsType.getMapOfTypes().put("Date", new ParseLong());
        String actual = Calc.bootCalc("/,3,2", "Date");
        assertEquals("1", actual);
    }

    @Test
    public void sumIntArguments() throws InvalidInputException {
        Operators.getOperatorsMap().put("/", new SumOperators());
        ArgumentsType.getMapOfTypes().put("Date", new ParseInt());
        String actual = Calc.bootCalc("2/2", "Date");
        assertEquals("4", actual);
    }

    @Test
    public void sumDoubleArguments() throws InvalidInputException {
        Operators.getOperatorsMap().put("/", new SumOperators());
        ArgumentsType.getMapOfTypes().put("Date", new ParseDouble());
        String actual = Calc.bootCalc("3.1/2.1", "Date");
        assertEquals("5.2", actual);
    }

    @Test
    public void sumFloatArguments() throws InvalidInputException {
        Operators.getOperatorsMap().put("/", new SumOperators());
        ArgumentsType.getMapOfTypes().put("Date", new ParseFloat());
        String actual = Calc.bootCalc("2.3/2.0", "Date");
        assertEquals("4.3", actual);
    }

    @Test
    public void sumLongArguments() throws InvalidInputException {
        Operators.getOperatorsMap().put("/", new SumOperators());
        ArgumentsType.getMapOfTypes().put("Date", new ParseLong());
        String actual = Calc.bootCalc("3/2", "Date");
        assertEquals("5", actual);
    }
}
