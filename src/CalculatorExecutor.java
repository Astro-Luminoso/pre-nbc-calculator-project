/**
 * CalculatorExecutor 클래스는 계산기의 실행을 담당하는 클래스입니다.
 * CommandLineInterface 객체를 통해 사용자와 상호작용하며, 입력된 계산식을 처리하고 결과를 출력합니다.
 * 계산 과정에서 발생할 수 있는 예외를 처리한 후 CommandLineInterface를 통해 애러메시지를 출력합니다.
 *
 * @author HanByeol Yang
 */
public class CalculatorExecutor {

    private final CommandLineInterface cli;
    private InputRecord record;
    private CalculatorHistory history;

    /**
     * CalculatorExecutor 생성자, CommandLineInterface 객체를 매개변수로 받아 초기화
     *
     * @param cli CommandLineInterface 객체, 사용자와의 상호작용을 담당하는 객체
     */
    public CalculatorExecutor(CommandLineInterface cli) {
        this.cli = cli;
    }

    /**
     * 계산기 실행 메서드, 환영 메시지를 출력한 후 계산기 메인 루프를 실행하고, 프로그램 종료 시 CommandLineInterface를 닫음
     */
    public void run() {

        cli.welcomeMessage();
        calculatorMainLoop();

        // terminate program
        cli.closeCli();
    }

    /**
     * 계산 기록을 생성하는 메서드, 입력된 문자열을 파싱하여 InputRecord 객체를 생성
     *
     * @param lhsOperand 첫 번째 숫자 입력 문자열, null인 경우 history의 결과를 사용
     * @param operator 연산자 입력 문자열, CalculatorOperator의 심볼과 일치해야 함
     * @param rhsOperand 두 번째 숫자 입력 문자열, 유효한 숫자 형식이어야 함
     *
     * @throws NumberFormatException 입력된 숫자 문자열이 유효하지 않은 경우 발생
     * @throws IllegalArgumentException 입력된 연산자 문자열이 유효하지 않은 경우
     */
    public void createCalculatorRecord(String lhsOperand, String operator, String rhsOperand) {

        // need castedLhsOperand to double for creating InputRecord, but if lhsOperand is null, use history's result as lhsOperand
        double castedLhsOperand;

        if(this.history == null && lhsOperand == null) throw new NumberFormatException();

        else if (lhsOperand == null) castedLhsOperand = history.getResult();
        else castedLhsOperand = Double.parseDouble(lhsOperand);

        this.record = new InputRecord(
                castedLhsOperand,
                CalculatorOperator.fromSymbol(operator),
                Double.parseDouble(rhsOperand));
    }

    /**
     * 계산을 수행하는 메서드, InputRecord의 연산자와 피연산자를 사용하여 계산 결과를 구하고, CalculatorHistory 객체에 기록
     *
     * @throws ArithmeticException 계산 과정에서 0으로 나누는 경우 발생
     */
    public void calculate() {
        double result = record.operator().calculate(record.lhsOperand(), record.rhsOperand());
        history = new CalculatorHistory(record, result);
    }

    /**
     * 계산기 메인 루프 메서드, 사용자로부터 입력을 받아 계산을 수행하고 결과를 출력하는 과정을 반복
     */
    public void calculatorMainLoop() {

        boolean useLhsOperand = false;

        while (true) {
            String[] inputValues = cli.initializeCalculation(useLhsOperand);

            try{
                createCalculatorRecord(inputValues[0], inputValues[1], inputValues[2]);
            } catch (NumberFormatException e) {
                cli.printMessage(cli.INVALID_NUMBER_MESSAGE);
                continue;
            } catch (IllegalArgumentException e) {
                cli.printMessage(cli.INVALID_OPERATOR_MESSAGE);
                continue;
            }

            try {
                this.calculate();
            } catch (ArithmeticException e) {
                System.out.println(cli.DIVISION_BY_ZERO_MESSAGE);
                continue;
            }


            cli.printResultMessage(history.getResult());

            useLhsOperand = cli.checkUsingResultAsLhsOperand(history.getResult());

            if (useLhsOperand) continue;
            if (!cli.checkContinue()) break;
        }
    }
}
