import java.util.ArrayList;
import java.util.List;

public class CalculatorExecutor {

    private final CommandLineInterface cli;
    private List<CalculatorHistory> historyList;

    public CalculatorExecutor() {
        this.cli = new CommandLineInterface();
        this.historyList = new ArrayList<>();
    }

    public void play() {

        boolean isRunning = true;

        while (isRunning) {

            // TODO: Implement
            String lhsOperand = cli.returnValue("첫 번째 피연산자를 입력하세요");
            String operator = cli.returnValue("연산자를 입력하세요 (+, -, *, /)");
            String rhsOperand = cli.returnValue("두 번째 피연산자를 입력하세요");
            CalculatorHistory history;

            try {
                history = new CalculatorHistory(
                        Double.parseDouble(lhsOperand),
                        Double.parseDouble(rhsOperand),
                        CalculatorOperator.fromSymbol(operator)).calculate();
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

            cli.printResultMessage(history);
//            System.out.println(history);

            isRunning = cli.returnContinueValue("계속하시겠습니까? (y/n)");

            if(!isRunning) {
               cli.closeCli();
           } else {
                historyList.add(history);
                System.out.println(historyList.toString());
           }





        }
    }
}
