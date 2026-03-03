import java.util.function.BiFunction;

public enum CalculatorOperator {

    ADD("+", (Double lhs, Double rhs) -> lhs + rhs),
    SUBTRACT("-", (Double lhs, Double rhs) -> lhs - rhs),
    MULTIPLY("*", (Double lhs, Double rhs) -> lhs * rhs),
    DIVIDE("/", (Double lhs, Double rhs) -> {;
        if (rhs == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return lhs / rhs;
    });

    private final String symbol;
    private final BiFunction<Double, Double, Double> operation;

    CalculatorOperator(String symbol, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public static CalculatorOperator fromSymbol(String symbol) {
        for (CalculatorOperator operator : CalculatorOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 연산자입니다: " + symbol);
    }

    public double calculate(double lhs, double rhs) {
        return operation.apply(lhs, rhs);
    }
}
