import java.util.function.BiFunction;

/**
 * CalculatorOperator는 계산기의 연산자와 해당 연산을 수행하는 기능을 정의함
 * 각 연산자는 심볼과 연산을 수행하는 BiFunction을 가지고 있으며, fromSymbol 메서드를 통해 문자열로부터 연산자를 찾을 수 있음
 */
public enum CalculatorOperator {

    ADD("+", (Double lhs, Double rhs) -> lhs + rhs),
    SUBTRACT("-", (Double lhs, Double rhs) -> lhs - rhs),
    MULTIPLY("*", (Double lhs, Double rhs) -> lhs * rhs),
    DIVIDE("/", (Double lhs, Double rhs) -> {;
        if (rhs == 0) {
            throw new ArithmeticException();
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
