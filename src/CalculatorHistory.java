public class CalculatorHistory {

    private final double lhsOperand;
    private final double rhsOperand;
    private final CalculatorOperator operator;
    private double result;

    public CalculatorHistory(double lhsOperand, double rhsOperand, CalculatorOperator operator) throws IllegalArgumentException{
        this.lhsOperand = lhsOperand;
        this.rhsOperand = rhsOperand;
        this.operator = operator;
    }

    public CalculatorHistory calculate() {
        switch (operator) {
            case ADD:
                result = lhsOperand + rhsOperand;
                break;
            case SUBTRACT:
                result = lhsOperand - rhsOperand;
                break;
            case MULTIPLY:
                result = lhsOperand * rhsOperand;
                break;
            case DIVIDE:
                if (rhsOperand == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                result = lhsOperand / rhsOperand;
                break;
        }

        return this;
    }

    public double getResult() {
        return this.result;
    }


    @Override
    public String toString() {
        return String.format("%.1f %s %.1f, %.1f", lhsOperand, operator.getSymbol(), rhsOperand, result);
    }
}

