package dream.calc.model.Types;

import dream.calc.ArgumentsType;
import dream.calc.InvalidInputException;
import dream.calc.Separate;
import dream.calc.model.interfaces.ParseType;

/**
 * Created by Splayd on 17.04.2017.
 * Parse to int
 */
public class ParseInt implements ParseType {
    @Override
    public void parse() throws InvalidInputException {
        try {
            ArgumentsType.getArgumentsByTypeArray().add(Integer.parseInt(Separate.getArgumentsArray().get(0)));
            ArgumentsType.getArgumentsByTypeArray().add(Integer.parseInt(Separate.getArgumentsArray().get(1)));
        } catch (Exception e) {
            throw new InvalidInputException();
        }
    }
}
