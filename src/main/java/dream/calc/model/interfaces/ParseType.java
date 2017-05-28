package dream.calc.model.interfaces;

import dream.calc.InvalidInputException;

/**
 * Created by Splayd on 17.04.2017.
 * Interface of parsing input type
 */
public interface ParseType {
    void parse() throws InvalidInputException;
}
