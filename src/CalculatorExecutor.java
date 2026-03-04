public class CalculatorExecutor {

    private final CommandLineInterface cli;
    private InputRecord record;
    private CalculatorHistory history;

    public CalculatorExecutor(CommandLineInterface cli) {
        this.cli = cli;
    }

    public void run() {

        cli.welcomeMessage();
        calculatorMainLoop();

        // terminate program
        cli.closeCli();
    }

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

    public void calculate() {
        double result = record.operator().calculate(record.lhsOperand(), record.rhsOperand());
        history = new CalculatorHistory(record, result);
    }

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
