package dream.calc;

import java.util.ArrayList;

/**
 * Created by Splayd on 08.04.2017.
 * dream.calc.Separate input string on Arrays of arguments and operators
 */
public class Separate {

    static ArrayList<String> argumentsArray = new ArrayList<>();
    static ArrayList<Character> operatorsArray = new ArrayList<>();

    public void separateInput(String input) throws InvalidInputException {
        if (input.charAt(0) >= 48 && input.charAt(0) <= 57) {
            addValuesToArrays(input);
        } else if (Operators.getOperatorsMap().containsKey(String.valueOf(input.charAt(0)))) {
            addValuesToArraysByPolish(input);
        } else {
            throw new InvalidInputException();
        }
    }

    private void addValuesToArrays(String inputForSplit) throws InvalidInputException {
        ArrayList<Character> inputString = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < inputForSplit.length(); i++) {
            inputString.add(inputForSplit.charAt(i));
        }

        for (Character anInputString : inputString) {
            if ((anInputString >= 48 && anInputString <= 57) || anInputString == 46) {
                builder.append(anInputString);
            } else if (Operators.getOperatorsMap().containsKey(anInputString.toString())) {
                operatorsArray.add(anInputString);
                argumentsArray.add(builder.toString());
                builder = new StringBuilder();
            } else {
                throw new InvalidInputException();
            }
        }

        if (builder.length() != 0) {
            argumentsArray.add(builder.toString());
        }
    }

    private void addValuesToArraysByPolish(String inputForSplit) throws InvalidInputException {

        if (inputForSplit.length() == 1) {
            throw new InvalidInputException();
        }

        String separate = String.valueOf(inputForSplit.charAt(1));

        String[] splitArray = inputForSplit.split(separate);

        for (String temp : splitArray) {
            if (Operators.getOperatorsMap().containsKey(temp) && temp.length() == 1) {
                operatorsArray.add(temp.charAt(0));
            } else {
                argumentsArray.add(temp);
            }
        }
    }

    public static ArrayList<String> getArgumentsArray() {
        return argumentsArray;
    }

    public static ArrayList<Character> getOperatorsArray() {
        return operatorsArray;
    }

    public static void setArgumentsArray(ArrayList<String> argumentsArray) {
        Separate.argumentsArray = argumentsArray;
    }

    public static void setOperatorsArray(ArrayList<Character> operatorsArray) {
        Separate.operatorsArray = operatorsArray;
    }
}
