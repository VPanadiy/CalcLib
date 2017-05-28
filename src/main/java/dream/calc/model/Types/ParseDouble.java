package dream.calc.model.Types;

import dream.calc.ArgumentsType;
import dream.calc.InvalidInputException;
import dream.calc.Separate;
import dream.calc.model.interfaces.ParseType;
import org.apache.commons.math3.util.Precision;

/**
 * Created by Splayd on 17.04.2017.
 * Parse to Double
 */
public class ParseDouble implements ParseType {
    @Override
    public void parse() throws InvalidInputException {
        try {
            ArgumentsType.getArgumentsByTypeArray().add(Precision.round(Double.parseDouble(Separate.getArgumentsArray().get(0)), 7));
            ArgumentsType.getArgumentsByTypeArray().add(Precision.round(Double.parseDouble(Separate.getArgumentsArray().get(1)), 7));
        } catch (Exception e) {
            throw new InvalidInputException();
        }
    }
}
