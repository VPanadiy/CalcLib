package dream.calc;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Splayd on 19.04.2017.
 * Parse test
 */
public class ParseTest {
    private Separate separate;
    private ArrayList<Object> actualArgumentsByTypeArray;
    private ArrayList<Object> expectedArguments;

    @Before
    public void setUp() {
        separate = new Separate();
        Separate.setArgumentsArray(new ArrayList<>());
        Separate.setOperatorsArray(new ArrayList<>());
        ArgumentsType.setArgumentsByTypeArray(new ArrayList<>());
        Operators.operatorsCreate();
        ArgumentsType.typesCreate();
        expectedArguments = new ArrayList<>();
        actualArgumentsByTypeArray = ArgumentsType.getArgumentsByTypeArray();
    }

    @Test
    public void ParseLong() throws InvalidInputException {
        separate.separateInput("2+2");
        ArgumentsType.getMapOfTypes().get("long").parse();
        expectedArguments.add(2L);
        expectedArguments.add(2L);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseInt() throws InvalidInputException {
        separate.separateInput("2+2");
        ArgumentsType.getMapOfTypes().get("int").parse();
        expectedArguments.add(2);
        expectedArguments.add(2);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseDouble() throws InvalidInputException {
        separate.separateInput("2.0+2.0");
        ArgumentsType.getMapOfTypes().get("double").parse();
        expectedArguments.add(2.0);
        expectedArguments.add(2.0);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseFloat() throws InvalidInputException {
        separate.separateInput("2+2");
        ArgumentsType.getMapOfTypes().get("float").parse();
        expectedArguments.add(2.0f);
        expectedArguments.add(2.0f);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseLongPolish() throws InvalidInputException {
        separate.separateInput("-,2,2");
        ArgumentsType.getMapOfTypes().get("long").parse();
        expectedArguments.add(2L);
        expectedArguments.add(2L);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseIntPolish() throws InvalidInputException {
        separate.separateInput("-,2,2");
        ArgumentsType.getMapOfTypes().get("int").parse();
        expectedArguments.add(2);
        expectedArguments.add(2);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseDoublePolish() throws InvalidInputException {
        separate.separateInput("-,2.0,2.0");
        ArgumentsType.getMapOfTypes().get("double").parse();
        expectedArguments.add(2.0);
        expectedArguments.add(2.0);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseFloatPolish() throws InvalidInputException {
        separate.separateInput("-,2.0,2.0");
        ArgumentsType.getMapOfTypes().get("float").parse();
        expectedArguments.add(2.0f);
        expectedArguments.add(2.0f);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }
}
