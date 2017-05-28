package dream.calc;

/**
 * Created by Splayd on 04.03.2017.
 * Simple calculation library.
 * Parse String two Integer.
 * Could calculate four operation (sum, sub, multiply and div) with two digits
 * To use call: Parse.parseString(String);
 * To see digits call: data.getIntegerArrayList()
 */
public class Calc {
//    public static void main(String[] args) throws InvalidInputException {
//        if (args.length == 1) {
//            bootCalc(args[0]);
//        } else {
//            bootCalc(args[0], args[1]);
//        }
//    }

    public static String bootCalc(String input) throws InvalidInputException {
        boot(input);

        if (Operators.getOperatorsMap().containsKey(Separate.getOperatorsArray().get(0).toString())) {
            Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        } else {
            throw new InvalidInputException();
        }

        return isZeroEnding(ArgumentsType.getResultArray().get(0).toString());
    }

    public static String bootCalc(String input, String type) throws InvalidInputException {
        boot(input);

        if (Operators.getOperatorsMap().containsKey(Separate.getOperatorsArray().get(0).toString())) {
            ArgumentsType.getMapOfTypes().get(type).parse();
            Operators.getOperatorsMap().get(Separate.getOperatorsArray().get(0).toString()).calc();
        } else {
            throw new InvalidInputException();
        }

        return isZeroEnding(ArgumentsType.getResultArray().get(0).toString());
    }

    private static void boot(String input) throws InvalidInputException {
        Operators.operatorsCreate();
        ArgumentsType.typesCreate();
        Separate separate = new Separate();
        separate.separateInput(input);

        if (Separate.getOperatorsArray().size() == 0) {
            throw new InvalidInputException();
        }
    }

    private static String isZeroEnding(String checkZeroEnding) {
        StringBuilder afterDot = new StringBuilder();
        StringBuilder beforeDot = new StringBuilder();
        boolean flag = false;

        for (int i = 0; i < checkZeroEnding.length(); i++) {

            if ('.' == checkZeroEnding.charAt(i)) {
                flag = true;
                afterDot.append("0");
            }

            if (flag) {
                afterDot.append(checkZeroEnding.charAt(i));
            } else {
                beforeDot.append(checkZeroEnding.charAt(i));
            }
        }

        if (afterDot.toString().equals("0.0")) {
            return beforeDot.toString();
        } else {
            return checkZeroEnding;
        }
    }
}

