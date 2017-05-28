package dream.calc;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Splayd on 09.04.2017.
 * Test result operations
 */
public class ResultOperatorsTest {

    @Before
    public void setUp() {
        Separate.setArgumentsArray(new ArrayList<>());
        Separate.setOperatorsArray(new ArrayList<>());
        ArgumentsType.setArgumentsByTypeArray(new ArrayList<>());
        ArgumentsType.setResultArray(new ArrayList<>());
    }

    @Test
    public void subsOperators() throws InvalidInputException {
        String actual = Calc.bootCalc("-,2,2");
        assertEquals("0", actual);
    }

    @Test
    public void sumOperators() throws InvalidInputException {
        String actual = Calc.bootCalc("+,2,2");
        assertEquals("4", actual);
    }

    @Test
    public void subsDoubleOperators() throws InvalidInputException {
        String actual = Calc.bootCalc("-,2.0,2.0");
        assertEquals("0", actual);
    }

    @Test
    public void sumDoubleOperators() throws InvalidInputException {
        String actual = Calc.bootCalc("+,2.2,2.2");
        assertEquals("4.4", actual);
    }

    @Test
    public void sumDoubleOperators2() throws InvalidInputException {
        String actual = Calc.bootCalc("+,0002.0002,0002.0002");
        assertEquals("4.0004", actual);
    }

    @Test
    public void subsDoubleOperators2() throws InvalidInputException {
        String actual = Calc.bootCalc("-,20202.20202,20202.20202");
        assertEquals("0", actual);
    }

    @Test
    public void subsDoubleOperators3() throws InvalidInputException {
        String actual = Calc.bootCalc("+,20202.20,20202.20");
        assertEquals("40404.4", actual);
    }
}
