package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {
    private List<Number> results;

    private boolean isDoubleDomain(Number number) {
        return (number instanceof Float) || (number instanceof Double);
    }

    public ArithmeticCalculator() {
        results = new ArrayList<>();
    }

    public ArithmeticCalculator(List<Number> numbers) {
        results = numbers;
    }

    public <T extends Number> T calculate(T num1, T num2, OperatorType operator) {

        if (isDoubleDomain(num1) || isDoubleDomain(num2)) {
            double bind1 = num1.doubleValue();
            double bind2 = num2.doubleValue();

            Double result = switch (operator) {
                case ADD -> bind1 + bind2;
                case SUBTRACT -> bind1 - bind2;
                case MULTIPLY -> bind1 * bind2;
                case DIVIDE -> bind1 / bind2;
            };
            results.add(result);
            return (T) result;
        } else {
            int bind1 = num1.intValue();
            int bind2 = num2.intValue();

            Integer result = switch (operator) {
                case ADD -> Math.addExact(bind1, bind2);
                case SUBTRACT -> Math.subtractExact(bind1, bind2);
                case MULTIPLY -> Math.multiplyExact(bind1, bind2);
                case DIVIDE -> Math.divideExact(bind1, bind2);
            };
            results.add(result);
            return (T) result;
        }
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.removeLast();
        }
    }

    public List<Number> getResults() {
        return results;
    }

    public void setResults(List<Number> results) {
        this.results = results;
    }

    public List<Number> getGreaterResults(double boundary) {
        return results.stream()
            .filter(num -> num.doubleValue() > boundary)
            .collect(Collectors.toList());
    }
}
