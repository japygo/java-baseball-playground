package study;

public class StringCalculator {

    private int result;
    private Operation operation;

    public int calculateFormula(String formula) {
        this.result = 0;
        this.operation = Operation.ADDITION;

        String[] values = splitFormula(formula);
        for (String value : values) {
            calculate(value);
        }

        return this.result;
    }

    private void calculate(String value) {
        switch (value) {
            case "+":
                this.operation = Operation.ADDITION;
                break;
            case "-":
                this.operation = Operation.SUBTRACTION;
                break;
            case "*":
                this.operation = Operation.MULTIPLICATION;
                break;
            case "/":
                this.operation = Operation.DIVISION;
                break;
            default:
                int number = parseInt(value);
                calculate(number);
                break;
        }
    }

    private void calculate(int number) {
        switch (this.operation) {
            case ADDITION:
                this.result += number;
                break;
            case SUBTRACTION:
                this.result -= number;
                break;
            case MULTIPLICATION:
                this.result *= number;
                break;
            case DIVISION:
                this.result /= number;
                break;
        }
    }

    private int parseInt(String number) {
        return Integer.parseInt(number);
    }

    private String[] splitFormula(String formula) {
        return formula.split(" ");
    }

    private enum Operation {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        ;
    }
}
