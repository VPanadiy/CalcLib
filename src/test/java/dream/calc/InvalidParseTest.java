package dream.calc;

import dream.calc.model.Types.ParseLong;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Splayd on 19.04.2017.
 * Invalid input parse test
 */
public class InvalidParseTest {
    private Separate separate;
    private ArrayList<Object> actualArgumentsByTypeArray;
    private ArrayList<Object> expectedArguments;

    @Before
    public void setUp() {
        separate = new Separate();
        Separate.setArgumentsArray(new ArrayList<>());
        Separate.setOperatorsArray(new ArrayList<>());
        expectedArguments = new ArrayList<>();
        actualArgumentsByTypeArray = new ArrayList<>();
    }

    @Test(expected = InvalidInputException.class)
    public void ParseDouble() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("2.0+2.0");
        ArgumentsType.getMapOfTypes().put("Date", new ParseLong());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2.0);
        expectedArguments.add(2.0);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test(expected = InvalidInputException.class)
    public void ParseDoublePolish() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("-,2.0,2.0");
        ArgumentsType.getMapOfTypes().put("Date", new ParseLong());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2.0);
        expectedArguments.add(2.0);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test(expected = InvalidInputException.class)
    public void ParseInvalidPolish2() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("-,2,2.0");
        ArgumentsType.getMapOfTypes().put("Date", new ParseLong());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2.0);
        expectedArguments.add(2.0);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test(expected = InvalidInputException.class)
    public void ParseInvalidPolish() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("+,&,2");
        ArgumentsType.getMapOfTypes().put("Date", new ParseLong());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2.0);
        expectedArguments.add(2.0);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test(expected = InvalidInputException.class)
    public void ParseInvalid() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("2.0-2");
        ArgumentsType.getMapOfTypes().put("Date", new ParseLong());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2.0);
        expectedArguments.add(2.0);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test(expected = InvalidInputException.class)
    public void ParseInvalid2() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("2+%");
        ArgumentsType.getMapOfTypes().put("Date", new ParseLong());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2.0);
        expectedArguments.add(2.0);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }
}
