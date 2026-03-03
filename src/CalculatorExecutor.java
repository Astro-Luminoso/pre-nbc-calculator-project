public class CalculatorExecutor {

    private final CommandLineInterface cli;

    public CalculatorExecutor() {
        this.cli = new CommandLineInterface();
    }

    public void play() {
        while (true) {

            // TODO: Implement
            int lhsOperand = cli.returnOperand("첫 번째 피연산자를 입력하세요");
            String operator = cli.returnOperator("연산자를 입력하세요 (+, -, *, /)");
            int rhsOperand = cli.returnOperand("두 번째 피연산자를 입력하세요");
        }
    }
}
