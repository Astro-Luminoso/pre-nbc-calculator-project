public class CalculatorHistory {

    private final InputRecord record;
    private final double result;

    public CalculatorHistory(InputRecord record, double result){
        this.record = record;
        this.result = result;
    }
    
    public double getResult() {
        return this.result;
    }


    @Override
    public String toString() {
        return String.format("[LHS: %.1f, Operator: %s, RHS: %.1f, Result: %.1f]",
                record.lhsOperand(), record.operator().getSymbol(), record.rhsOperand(), result);
    }
}

