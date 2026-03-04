import java.util.Scanner;

public class CommandLineInterface {

    Scanner scanner;

    public final String INVALID_NUMBER_MESSAGE = "유효한 숫자를 입력하세요.";
    public final String INVALID_OPERATOR_MESSAGE = "지원하지 않는 연산자입니다.";
    public final String DIVISION_BY_ZERO_MESSAGE = "0으로 나눌 수 없습니다.";

    /**
     * CommandLineInterface 생성자, Scanner 초기화
     */
    public CommandLineInterface() {
        scanner = new Scanner(System.in);
    }


    public void welcomeMessage() {
        System.out.println("=== Java 계산기 ===");
    }


    /**
     * 사용자에게 입력 메시지를 출력하는 메서드
     *
     * @param message 출력 메시지 문자열
     */
    public void printPrompt(String message) {
        System.out.print(message + ": ");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }


    /**
     * 사용자로부터 입력을 받아 배열로 반환하는 메서드
     *
     * @param useLhsOperand 첫 번째 숫자 입력 여부를 결정하는 boolean 값, false인 경우 첫 번째 숫자를 입력받음
     * @return 입력된 값들을 담은 String 배열, 첫 번째 요소는 첫 번째 숫자(입력받는 경우), 두 번째 요소는 연산자, 세 번째 요소는 두 번째 숫자
     */
    public String[] initializeCalculation(boolean useLhsOperand) {
       String[] inputValues = new String[3];
        if(!useLhsOperand){
            printPrompt("첫 번째 숫자를 입력하세요");
            inputValues[0] = scanner.nextLine().trim();
        }
        printPrompt("연산자를 입력하세요 (+, -, *, /)");
        inputValues[1] = scanner.nextLine().trim();
        printPrompt("두 번째 숫자를 입력하세요");
        inputValues[2] = scanner.nextLine().trim();

        return inputValues;
    }

    public void printResultMessage(double result) {
        this.printPrompt("출력");
        System.out.printf("%.1f%n",result);
    }

    public boolean checkUsingResultAsLhsOperand(double result) {
        this.printPrompt(String.format("이전 결과(%.1f)f를 사용하시겠습니까? (y/n)", result));
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y");
    }

    public boolean checkContinue() {
        this.printPrompt("계속 계산하시겠습니까? (y/n)");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("y");
    }


    /**
     * Scanner를 닫은 후 종료 메시지 출력
     */
    public void closeCli() {
        scanner.close();
        System.out.println("계산기를 종료합니다.");
    }
}
