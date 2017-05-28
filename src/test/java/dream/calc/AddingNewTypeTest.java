package dream.calc;

import dream.calc.model.Types.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Splayd on 19.04.2017.
 * Adding new type input
 */
public class AddingNewTypeTest {
    private Separate separate;
    private List<Object> actualArgumentsByTypeArray;
    private List<Object> expectedArguments = new ArrayList<>();

    @Before
    public void setUp() {
        separate = new Separate();
        ArgumentsType.setArgumentsByTypeArray(new ArrayList<>());
        ArgumentsType.typesCreate();
        actualArgumentsByTypeArray = ArgumentsType.getArgumentsByTypeArray();
    }

    @Test
    public void ParseDouble() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("2+2");
        ArgumentsType.getMapOfTypes().put("Date", new ParseDouble());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2.0);
        expectedArguments.add(2.0);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseFloat() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("2-2");
        ArgumentsType.getMapOfTypes().put("Date", new ParseFloat());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2.0f);
        expectedArguments.add(2.0f);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseInt() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("2+2");
        ArgumentsType.getMapOfTypes().put("Date", new ParseInt());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2);
        expectedArguments.add(2);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseLong() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("2+2");
        ArgumentsType.getMapOfTypes().put("Date", new ParseLong());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2L);
        expectedArguments.add(2L);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseDoublePolish() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("+,2,2");
        ArgumentsType.getMapOfTypes().put("Date", new ParseDouble());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2.0);
        expectedArguments.add(2.0);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseFloatPolish() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("-,2,2");
        ArgumentsType.getMapOfTypes().put("Date", new ParseFloat());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2.0f);
        expectedArguments.add(2.0f);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseIntPolish() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("+,2,2");
        ArgumentsType.getMapOfTypes().put("Date", new ParseInt());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2);
        expectedArguments.add(2);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }

    @Test
    public void ParseLongPolish() throws InvalidInputException {
        Operators.operatorsCreate();
        separate.separateInput("-,2,2");
        ArgumentsType.getMapOfTypes().put("Date", new ParseLong());
        ArgumentsType.getMapOfTypes().get("Date").parse();
        Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        expectedArguments.add(2L);
        expectedArguments.add(2L);
        assertEquals(expectedArguments, actualArgumentsByTypeArray);
    }
}
