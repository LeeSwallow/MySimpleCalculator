package level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> results;

    public Calculator() {
        results = new ArrayList<Integer>();
    }

    public int calculate(int num1, int num2, char operator) {
        int result = switch (operator) {
            case '+' -> Math.addExact(num1, num2);
            case '-' -> Math.subtractExact(num1, num2);
            case '*' -> Math.multiplyExact(num1, num2);
            case '/' -> Math.divideExact(num1, num2);
            default -> throw new RuntimeException("지원하지 않는 연산자 입니다.");
        };
        results.add(result);
        return result;
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.removeLast();
        }
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }
}
