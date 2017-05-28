package dream.calc.model.MathOperators;

import dream.calc.ArgumentsType;
import dream.calc.InvalidInputException;
import dream.calc.Separate;
import dream.calc.model.interfaces.Task;
import org.apache.commons.math3.util.Precision;

/**
 * Created by Splayd on 09.04.2017.
 * Summing operator that implements dream.calc.model.interfaces.Task
 */
public class SumOperators implements Task {

    @Override
    public void calc() throws InvalidInputException {
        try {
            if (ArgumentsType.getArgumentsByTypeArray().size() == 0) {
                ArgumentsType.getResultArray().add(Precision.round(Double.parseDouble(Separate.getArgumentsArray().get(0)) + Double.parseDouble(Separate.getArgumentsArray().get(1)), 7));
            } else {
                if (ArgumentsType.getArgumentsByTypeArray().get(0) instanceof Double && ArgumentsType.getArgumentsByTypeArray().get(1) instanceof Double) {
                    ArgumentsType.getResultArray().add(Precision.round(Double.parseDouble(Separate.getArgumentsArray().get(0)) + Double.parseDouble(Separate.getArgumentsArray().get(1)), 7));
                } else if (ArgumentsType.getArgumentsByTypeArray().get(0) instanceof Float && ArgumentsType.getArgumentsByTypeArray().get(1) instanceof Float) {
                    ArgumentsType.getResultArray().add(Precision.round(Float.parseFloat(Separate.getArgumentsArray().get(0)) + Float.parseFloat(Separate.getArgumentsArray().get(1)), 7));
                } else if (ArgumentsType.getArgumentsByTypeArray().get(0) instanceof Integer && ArgumentsType.getArgumentsByTypeArray().get(1) instanceof Integer) {
                    ArgumentsType.getResultArray().add(Integer.parseInt(Separate.getArgumentsArray().get(0)) + Integer.parseInt(Separate.getArgumentsArray().get(1)));
                } else if (ArgumentsType.getArgumentsByTypeArray().get(0) instanceof Long && ArgumentsType.getArgumentsByTypeArray().get(1) instanceof Long) {
                    ArgumentsType.getResultArray().add(Long.parseLong(Separate.getArgumentsArray().get(0)) + Long.parseLong(Separate.getArgumentsArray().get(1)));
                } else {
                    throw new InvalidInputException();
                }
            }
        } catch (Exception e) {
            throw new InvalidInputException();
        }
    }
}
