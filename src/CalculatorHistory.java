public class CalculatorHistory {

    private final double lhsOperand;
    private final double rhsOperand;
    private final CalculatorOperator operator;
    private double result;

    public CalculatorHistory(double lhsOperand, double rhsOperand, CalculatorOperator operator){
        this.lhsOperand = lhsOperand;
        this.rhsOperand = rhsOperand;
        this.operator = operator;
    }

    public CalculatorHistory calculate() {

        this.result = operator.calculate(lhsOperand, rhsOperand);
        return this;

    }

    public double getResult() {
        return this.result;
    }


    @Override
    public String toString() {
        return String.format("[LHS: %.1f, Operator: %s, RHS: %.1f, Result: %.1f]",
                lhsOperand, operator.getSymbol(), rhsOperand, result);
    }
}

