import java.util.Scanner;

public class CommandLineInterface {

    Scanner scanner;

    /**
     * CommandLineInterface 생성자, Scanner 초기화 후 시작 메시지 출력
     */
    public CommandLineInterface() {
        scanner = new Scanner(System.in);
        System.out.println("=== Java 계산기 ===");
    }

    /**
     * 사용자에게 입력 메시지를 출력하는 메서드
     * @param message 출력 메시지 문자열
     */
    private void printCustomInputMessage(String message) {
        System.out.print(message + ": ");
    }

    /**
     * 사용자로부터 입력값을 받는 메서드
     * @param message 사용자에게 보여줄 입력 메시지 문자열
     * @return 사용자가 입력한 값
     */
    public String returnValue(String message) {
        this.printCustomInputMessage(message);
        return scanner.nextLine();
    }

    public void printResultMessage(CalculatorHistory history) {
        this.printCustomInputMessage("출력");
        System.out.printf("%.1f%n", history.getResult());
    }

    public boolean returnContinueValue(String message) {
        this.printCustomInputMessage(message);
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }

    /**
     * Scanner를 닫은 후 종료 메시지 출력
     */
    public void closeCli() {
        scanner.close();
        System.out.println("계산기를 종료합니다.");
    }
}
