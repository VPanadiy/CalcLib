package dream.calc;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by Splayd on 04.03.2017.
 * dream.calc.SeparateTest
 */
public class SeparateTest {
    private Separate separate;
    private ArrayList<String> actualArgumentsArray;
    private ArrayList<Character> actualOperatorArray;

    @Before
    public void setUp() {
        separate = new Separate();
        Operators.operatorsCreate();
        Separate.setArgumentsArray(new ArrayList<>());
        Separate.setOperatorsArray(new ArrayList<>());
        actualArgumentsArray = Separate.argumentsArray;
        actualOperatorArray = Separate.operatorsArray;
    }

    @Test
    public void sumOperators() throws InvalidInputException {
        separate.separateInput("2+2");
        assertEquals(Arrays.asList("2", "2"), actualArgumentsArray);
        assertEquals(Collections.singletonList('+'), actualOperatorArray);
    }

    @Test
    public void sumBiggerOperators() throws InvalidInputException {
        separate.separateInput("22+22");
        assertEquals(Arrays.asList("22", "22"), actualArgumentsArray);
        assertEquals(Collections.singletonList('+'), actualOperatorArray);
    }

    @Test
    public void sumFloatOperators() throws InvalidInputException {
        separate.separateInput("2.2+2.2");
        assertEquals(Arrays.asList("2.2", "2.2"), actualArgumentsArray);
        assertEquals(Collections.singletonList('+'), actualOperatorArray);
    }

    @Test
    public void zeroFloatOperators() throws InvalidInputException {
        separate.separateInput("0.0+0.0");
        assertEquals(Arrays.asList("0.0", "0.0"), actualArgumentsArray);
        assertEquals(Collections.singletonList('+'), actualOperatorArray);
    }

    @Test
    public void zeroDoubleOperators() throws InvalidInputException {
        separate.separateInput("0101.0101+9009.909");
        assertEquals(Arrays.asList("0101.0101", "9009.909"), actualArgumentsArray);
        assertEquals(Collections.singletonList('+'), actualOperatorArray);
    }

    @Test
    public void DoubleOperators() throws InvalidInputException {
        separate.separateInput("0101.0101+9009.909+1");
        assertEquals(Arrays.asList("0101.0101", "9009.909", "1"), actualArgumentsArray);
        assertEquals(Arrays.asList('+', '+'), actualOperatorArray);
    }

    @Test
    public void maxOperators() throws InvalidInputException {
        separate.separateInput("0101.0101+9009.909+232-");
        assertEquals(Arrays.asList("0101.0101", "9009.909", "232"), actualArgumentsArray);
        assertEquals(Arrays.asList('+', '+', '-'), actualOperatorArray);
    }

    @Test(expected = InvalidInputException.class)
    public void oneOperators() throws InvalidInputException {
        separate.separateInput("+");
        assertEquals(Collections.emptyList(), actualArgumentsArray);
        assertEquals(Collections.singletonList('+'), actualOperatorArray);
    }

    @Test
    public void oneOperators2() throws InvalidInputException {
        separate.separateInput("+,");
        assertEquals(Collections.emptyList(), actualArgumentsArray);
        assertEquals(Collections.singletonList('+'), actualOperatorArray);
    }

    @Test
    public void oneNumberOperators() throws InvalidInputException {
        separate.separateInput("2");
        assertEquals(Collections.singletonList("2"), actualArgumentsArray);
        assertEquals(Collections.emptyList(), actualOperatorArray);
    }

    @Test
    public void oneNumberOperators2() throws InvalidInputException {
        separate.separateInput("232");
        assertEquals(Collections.singletonList("232"), actualArgumentsArray);
        assertEquals(Collections.emptyList(), actualOperatorArray);
    }

    @Test
    public void subsOperators() throws InvalidInputException {
        separate.separateInput("2-2");
        assertEquals(Arrays.asList("2", "2"), actualArgumentsArray);
        assertEquals(Collections.singletonList('-'), actualOperatorArray);
    }

    @Test
    public void polishSumOperators() throws InvalidInputException {
        separate.separateInput("+,2,2");
        assertEquals(Arrays.asList("2", "2"), actualArgumentsArray);
        assertEquals(Collections.singletonList('+'), actualOperatorArray);
    }

    @Test
    public void polishSubsOperators() throws InvalidInputException {
        separate.separateInput("-,2,2");
        assertEquals(Arrays.asList("2", "2"), actualArgumentsArray);
        assertEquals(Collections.singletonList('-'), actualOperatorArray);
    }

    @Test
    public void polishSeparate() throws InvalidInputException {
        separate.separateInput("-q2q2q+q-12312q");
        assertEquals(Arrays.asList("2", "2", "-12312"), actualArgumentsArray);
        assertEquals(Arrays.asList('-', '+'), actualOperatorArray);
    }

    @Test
    public void polishFloatSeparate() throws InvalidInputException {
        separate.separateInput("-q020.020q99901.901q+q-12312q");
        assertEquals(Arrays.asList("020.020", "99901.901", "-12312"), actualArgumentsArray);
        assertEquals(Arrays.asList('-', '+'), actualOperatorArray);
    }
}
