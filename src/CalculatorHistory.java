/**
 * 모든 계산 기록을 저장하는 클래스 입력된 기록과 계산 결과를 함께 저장하여, 나중에 기록을 조회할 때 사용할 수 있음
 *
 * @see InputRecord
 *
 * @author HanByeol Yang
 */
public class CalculatorHistory {

    /**
     * 계산 기록을 저장하는 필드
     */
    private final InputRecord record;
    private final double result;

    /**
     * CalculatorHistory 생성자, 입력된 기록과 계산 결과를 매개변수로 받아 초기화
     *
     * @param record 사용자의 유효한 입력값을 담은 InputRecord 객체
     * @param result 계산 결과를 나타내는 double 값
     */
    public CalculatorHistory(InputRecord record, double result){
        this.record = record;
        this.result = result;
    }

    /**
     * 계산 결과물을 반환하는 메서드
     *
     * @return 계산 결과를 나타내는 double 값
     */
    public double getResult() {
        return this.result;
    }


    @Override
    public String toString() {
        return String.format("[LHS: %.1f, Operator: %s, RHS: %.1f, Result: %.1f]",
                record.lhsOperand(), record.operator().getSymbol(), record.rhsOperand(), result);
    }
}

