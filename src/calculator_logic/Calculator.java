package calculator_logic;

public class Calculator implements Calculation {

    private double leftOperand;
    private double rightOperand;
    private String operator;

    public Calculator(double leftOperand, double rightOperand, String operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public double calculateResult() {
        double result = 0;

        switch (this.operator) {
            case "-":
                result = this.Subtraction();
                break;
            case "/":
                result = this.Division();
                break;
            default:
                result = 0;
                break;
        }

        return result;
    }


    @Override
    public double Subtraction() {
        return this.leftOperand - this.rightOperand;

    }

    @Override
    public double Division() {
        return this.leftOperand / this.rightOperand;
    }
}
