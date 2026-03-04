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

    /**
     * CalculatorOperator 생성자
     *
     * @param symbol
     * @param operation
     */
    CalculatorOperator(String symbol, BiFunction<Double, Double, Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    /**
     * 연산자의 기호를 반환하는 메서드
     *
     * @return 연산자의 심볼 문자열
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * 전달된 문자열에서 해당하는 연산자를 찾아 반환함
     *
     * @param symbol 연산자의 심볼 문자열, 예: "+", "-", "*", "/"
     * @return 해당하는 CalculatorOperator 열거형 값
     *
     * @throws IllegalArgumentException 전달된 문자열이 유효한 연산자 기호가 아닌 경우 발생
     */
    public static CalculatorOperator fromSymbol(String symbol) {
        for (CalculatorOperator operator : CalculatorOperator.values()) {
            if (operator.getSymbol().equals(symbol)) {
                return operator;
            }
        }
        throw new IllegalArgumentException();
    }

    public double calculate(double lhs, double rhs) {
        return operation.apply(lhs, rhs);
    }
}
