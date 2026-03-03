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
     * 사용자로부터 연산자 입력을 받는 메서드
     * @param message 사용자에게 보여줄 입력 메시지 문자열
     * @return 사용자가 입력한 연산자 문자열
     */
    public String returnOperator(String message) {
        this.printCustomInputMessage(message);
        return scanner.nextLine();
    }

    /**
     * 사용자로부터 피연산자 입력을 받는 메서드
     * @param message 사용자에게 보여줄 입력 메시지 문자열
     * @return 사용자가 입력한 피연산자 정수값, 유효하지 않은 입력이 들어올 경우 재귀적으로 다시 입력을 받음
     */
    public int returnOperand(String message){
        this.printCustomInputMessage(message);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("유효한 숫자를 입력해주세요.");
            return this.returnOperand(message);    // return value in recursion until valid input is received
        }
    }

    /**
     * Scanner를 닫은 후 종료 메시지 출력
     */
    public void closeCli() {
        scanner.close();
        System.out.println("계산기를 종료합니다.");
    }
}
