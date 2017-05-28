package dream.calc;

import dream.calc.model.MathOperators.SubtractOperator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by Splayd on 09.04.2017.
 * Test of adding new operators
 */
public class AddingOperatorsTest {
    private Separate separate;
    private ArrayList<String> actualArgumentsArray;
    private ArrayList<Character> actualOperatorArray;

    @Before
    public void setUp() {
        separate = new Separate();
        Separate.setArgumentsArray(new ArrayList<>());
        Separate.setOperatorsArray(new ArrayList<>());
        actualArgumentsArray = Separate.argumentsArray;
        actualOperatorArray = Separate.operatorsArray;
    }

    @Test
    public void multiplyOperators() throws InvalidInputException {
        Operators.operatorsCreate();
        Operators.getOperatorsMap().put("*", new SubtractOperator());
        separate.separateInput("2*2");
        assertEquals(Arrays.asList("2", "2"), actualArgumentsArray);
        assertEquals(Collections.singletonList('*'), actualOperatorArray);
    }

    @Test
    public void divPolishOperators() throws InvalidInputException {
        Operators.operatorsCreate();
        Operators.getOperatorsMap().put("/", new SubtractOperator());
        separate.separateInput("/,3,3");
        assertEquals(Arrays.asList("3", "3"), actualArgumentsArray);
        assertEquals(Collections.singletonList('/'), actualOperatorArray);
    }
}
