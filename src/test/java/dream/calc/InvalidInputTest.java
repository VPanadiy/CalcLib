package dream.calc;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Splayd on 16.04.2017.
 * Invalid input test
 */
public class InvalidInputTest {

    @Before
    public void setUp() {
        Operators.operatorsCreate();
        Separate.setArgumentsArray(new ArrayList<>());
        Separate.setOperatorsArray(new ArrayList<>());
    }

    @Test(expected = InvalidInputException.class)
    public void invalidOperators() throws InvalidInputException {
        Calc.bootCalc("&,2,2");
    }

    @Test(expected = InvalidInputException.class)
    public void invalidOperators2() throws InvalidInputException {
        Calc.bootCalc("+,l,2");
    }

    @Test(expected = InvalidInputException.class)
    public void invalidOperators3() throws InvalidInputException {
        Calc.bootCalc("-,2,s");
    }

    @Test(expected = InvalidInputException.class)
    public void invalidOperators4() throws InvalidInputException {
        Calc.bootCalc("-,2,2.s");
    }

    @Test(expected = InvalidInputException.class)
    public void invalidOperators5() throws InvalidInputException {
        Calc.bootCalc("2&2");
    }

    @Test(expected = InvalidInputException.class)
    public void invalidOperators6() throws InvalidInputException {
        Calc.bootCalc("l+2");
    }

    @Test(expected = InvalidInputException.class)
    public void invalidOperators7() throws InvalidInputException {
        Calc.bootCalc("2-2.s");
    }
}
