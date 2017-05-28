package dream.calc;

import dream.calc.model.interfaces.ParseType;
import dream.calc.model.Types.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Splayd on 16.04.2017.
 * Find type of the arguments
 */
public class ArgumentsType {
    private static ArrayList<Object> argumentsByTypeArray = new ArrayList<>();
    private static ArrayList<Object> resultArray = new ArrayList<>();
    private static HashMap<String, ParseType> mapOfTypes = new HashMap<>();

    public static void typesCreate() {
        mapOfTypes.put("double", new ParseDouble());
        mapOfTypes.put("float", new ParseFloat());
        mapOfTypes.put("int", new ParseInt());
        mapOfTypes.put("long", new ParseLong());
    }

    public static ArrayList<Object> getArgumentsByTypeArray() {
        return argumentsByTypeArray;
    }

    public static ArrayList<Object> getResultArray() {
        return resultArray;
    }

    public static HashMap<String, ParseType> getMapOfTypes() {
        return mapOfTypes;
    }

    public static void setArgumentsByTypeArray(ArrayList<Object> argumentsByTypeArray) {
        ArgumentsType.argumentsByTypeArray = argumentsByTypeArray;
    }

    public static void setResultArray(ArrayList<Object> resultArray) {
        ArgumentsType.resultArray = resultArray;
    }

    public static void setMapOfTypes(HashMap<String, ParseType> mapOfTypes) {
        ArgumentsType.mapOfTypes = mapOfTypes;
    }
}
