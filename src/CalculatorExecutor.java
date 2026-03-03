public class CalculatorExecutor {

    private final CommandLineInterface cli;

    public CalculatorExecutor() {
        this.cli = new CommandLineInterface();
    }

    public void play() {
        while (true) {

            // TODO: Implement
            String lhsOperand = cli.returnValue("첫 번째 피연산자를 입력하세요");
            String operator = cli.returnValue("연산자를 입력하세요 (+, -, *, /)");
            String rhsOperand = cli.returnValue("두 번째 피연산자를 입력하세요");
            CalculatorHistory history;

            try {
                history = new CalculatorHistory(Double.parseDouble(lhsOperand), Double.parseDouble(rhsOperand), CalculatorOperator.fromSymbol(operator)).calculate();

            } catch (NumberFormatException e){
                System.out.println("유효하지 않은 숫자입니다. 다시 입력해주세요.");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("유효하지 않은 연산자입니다. 다시 입력해주세요.");
                continue;
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            }

            System.out.println(history);



        }
    }
}
