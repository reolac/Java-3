package calculator;

/**
 * Creates the logic and arithmetic for the calculator, each method is called
 * from Calculator.java to manipulate the number and make the buttons and
 * numbers perform as a calculator should, numbers are passed in and out then
 * stored in strings to be printed out in the UI, which Calculator.java
 * controls.
 *
 * @author Michael
 * @since 13/11/2014
 * @version 3.23
 */
public class Logic {

    static double total;
    static int size = 0;
    static double decimalNumber = 10;
    static boolean decimalFlag = false;
    static boolean plusFlag = false;
    static boolean minusFlag = false;
    static boolean timesFlag = false;
    static boolean divideFlag = false;
    static boolean sqrtFlag = false;
    static boolean percentFlag = false;

    static double op1;
    static double op2;

    /**
     * Gets the number from the last button inputted and stores it as a double,
     * everytime a new number is pressed, the current numbers are increased by
     * *10 If Decimal is pressed the opposite happens, every new number is
     * decreased by /10*n with n being the amount of decimal numbers
     *
     *
     * @param number the current number in the textField
     * @return numbers to the textField, which update everytime another button
     * is pressed
     */
    public static double getNumber(double number) {
        Calculator.pasteFlag = true;

        if (size == 8) {
            return total;
        }
        if (decimalFlag == true) {
            number = (number / decimalNumber);
            decimalNumber = decimalNumber * 10;
            System.out.println("number = " + decimalNumber);
            total = total + number;
        } else {
            total = (total * 10) + number;
        }
        size++;

        return total;
    }

    /**
     * Inverts the number in the textField by taking the number and multiplying
     * the number by -
     *
     * @param number the current number in the textField
     * @return the inverted number to the textField
     */
    public static double invertNumber(double number) {
        number = number * -1;
        return number;
    }

    /**
     * Gets the first operand from the text field then waits until a second
     * operand is inputted, then does the calculation of operand 1 + operand 2,
     * then returns the total back to the field
     *
     * @param number the current number in the textField
     * @return the added total back to the textField
     */
    public static double plus(double number) {

        decimalNumber = 10;
        decimalFlag = false;

        minusFlag = false;
        timesFlag = false;
        divideFlag = false;

        double plusTotal = number;
        if (plusFlag == false) {
            op1 = number;

            plusFlag = true;
        } else if (plusFlag == true) {
            op2 = number;
            plusTotal = op1 + op2;
            op1 = plusTotal;
        }
        return plusTotal;
    }

    /**
     * Gets the first operand from the text field then waits until a second
     * operand is inputted, then does the calculation of operand 1 - operand 2,
     * then returns the total back to the field
     *
     * @param number the current number in the textField
     * @return the subtracted total back to the textField
     */
    public static double minus(double number) {
        decimalNumber = 10;
        decimalFlag = false;

        plusFlag = false;
        timesFlag = false;
        divideFlag = false;

        double minusTotal = number;
        if (minusFlag == false) {
            op1 = number;
            minusFlag = true;
        } else if (minusFlag == true) {
            op2 = number;
            minusTotal = op1 - op2;
            op1 = minusTotal;
            minusFlag = false;
        }
        return minusTotal;
    }

    /**
     * Gets the first operand from the text field then waits until a second
     * operand is inputted, then does the calculation of operand 1 * operand 2,
     * then returns the total back to the field
     *
     * @param number the current number in the textField
     * @return the multiplied total back to the textField
     */
    public static double times(double number) {
        decimalNumber = 10;
        decimalFlag = false;

        plusFlag = false;
        minusFlag = false;
        divideFlag = false;

        double timesTotal = number;
        if (timesFlag == false) {
            op1 = number;
            timesFlag = true;
        } else if (timesFlag == true) {
            op2 = number;
            timesTotal = op1 * op2;
            op1 = timesTotal;
            timesFlag = false;
        }
        return timesTotal;
    }

    /**
     * Gets the first operand from the text field then waits until a second
     * operand is inputted, then does the calculation of operand 1 / operand 2,
     * then returns the total back to the field
     *
     * @param number the current number in the textField
     * @return the divided total back to the textField
     */
    public static double divide(double number) {
        decimalNumber = 10;
        decimalFlag = false;

        plusFlag = false;
        minusFlag = false;
        timesFlag = false;

        double divideTotal = number;
        if (divideFlag == false) {
            op1 = number;
            divideFlag = true;
        } else if (divideFlag == true) {
            op2 = number;
            divideTotal = op1 / op2;
            if (op2 == 0)
            {
                divideTotal = 0;
            }
            
            op1 = divideTotal;
            divideFlag = false;
        }
        return divideTotal;
    }

    /**
     * Calculates the square root of the number in the text field by bringing in
     * the number and using Math.sqrt then returning the number to the text
     * field
     *
     * @param number the current number in the textField
     * @return the square root of the number to the textField
     */
    public static double sqrt(double number) {
        decimalNumber = 10;
        decimalFlag = false;

        plusFlag = false;
        minusFlag = false;
        timesFlag = false;
        divideFlag = false;

        double sqrtTotal = Math.sqrt(number);
        
        if (number < 0)
        {
            sqrtTotal = 0;
        }

        return sqrtTotal;
    }

    /**
     * Calculates the reciprocal of the number inputted into the text field by,
     * getting the number and seeing how many times it goes into 1
     *
     * @param number the current number in the textField
     * @return the reciprocal of the number in the textField
     */
    public static double reciprocal(double number) {
        decimalNumber = 10;
        decimalFlag = false;

        plusFlag = false;
        minusFlag = false;
        timesFlag = false;
        divideFlag = false;

        double reciprocalTotal = 1 / number;

        return reciprocalTotal;
    }

    /**
     * Takes the number from the text field, stores it as the first operand,
     * waits for an operator and second operand before calculating the
     * percentage, using operand1 + (operand1 operator operand2)
     *
     * @param number the current number in the textField
     * @return the percentage + operand of the first operand
     */
    public static double percent(double number) {
        decimalNumber = 10;
        decimalFlag = false;

        double percentTotal = number;
        op2 = number / 100;
        if (plusFlag == true) {
            percentTotal = op1 + (op1 * op2);
            plusFlag = false;
        }
        if (minusFlag == true) {
            percentTotal = op1 - (op1 * op2);
            minusFlag = false;
        }
        if (timesFlag == true) {
            percentTotal = op1 * (op1 * op2);
            timesFlag = false;
        }
        if (divideFlag == true) {
            percentTotal = op1 / (op1 * op2);
            divideFlag = false;
        }
        return percentTotal;
    }

    /**
     * Updates the textField to show the latest arithmetic by forcing the second
     * conditions in each operator to trigger and return it to the field without
     * having to click on the operator, it passes the number from the text field
     * to the correct method based on what operator was flagged.
     *
     * @param number the current number in the textField
     * @return the result of the latest arithmetic
     */
    public static double equals(double number) {
        decimalNumber = 10;
        decimalFlag = false;

        if (plusFlag == true) {
            number = plus(number);

        }
        if (minusFlag == true) {
            number = minus(number);
            minusFlag = false;
        }
        if (timesFlag == true) {
            number = times(number);
            timesFlag = false;
        }
        if (divideFlag == true) {
            number = divide(number);
            divideFlag = false;
        }

        double equalsTotal = number;

        return equalsTotal;
    }

    /**
     * This deletes the latest entry from the field, until you run out of
     * entries to delete
     *
     * @param number the current number in the textField
     * @return the number with it's length - 1 to represent the last element
     * being taken off
     */
    public static double backSpace(double number) {
        String back;
        if (number % 1 == 0) {
            back = String.valueOf((int) number);
        } else {
            back = String.valueOf(number);
        }
        if (back.length() > 1) {

            back = back.substring(0, back.length() - 1);
            size--;
            number = Double.parseDouble(back);
            op1 = Double.parseDouble(back);
        } else {
            op1 = 0;
            number = 0;
            reset(number);
        }

        if (decimalNumber == 10) {
            decimalFlag = false;
        }

        if (decimalFlag == true) {
            decimalNumber = decimalNumber / 10;
        }

        return number;
    }

    /**
     * This resets all of the flags, operands and sets the number(text field) to
     * be the first operand, this mimics clear entry and returns back to the
     * last first operand, if you added a clearance of the first operand this
     * also mimics clear all
     *
     * @param number the current number in the textField
     * @return the number resets to 0
     */
    public static double reset(double number) {
        number = op1;
        total = op1;

        size = 0;
        decimalNumber = 10;
        decimalFlag = false;
        plusFlag = false;
        minusFlag = false;
        timesFlag = false;
        divideFlag = false;
        sqrtFlag = false;
        percentFlag = false;

        return number;
    }
}
