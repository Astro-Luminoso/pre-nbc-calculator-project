
public class Calculator {

    public static void main(String[] args) {

        CommandLineInterface cli = new CommandLineInterface();

        CalculatorExecutor executor = new CalculatorExecutor(cli);
        executor.run();
    }

}