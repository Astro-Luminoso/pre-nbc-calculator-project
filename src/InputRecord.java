/**
 * 사용자의 유효한 입력값을 기록하는 레코드 클래스
 *
 * @param lhsOperand 첫 번째 숫자 피연산자, double 형식
 * @param operator 연산자, CalculatorOperator 열거형의 값으로 표현
 * @param rhsOperand 두 번째 숫자 피연산자, double 형식
 */
public record InputRecord(double lhsOperand, CalculatorOperator operator, double rhsOperand) {
}
