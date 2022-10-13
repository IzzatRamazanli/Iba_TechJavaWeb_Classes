package lesson1practice;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CalculatorHistory {
    private final List<String> history;

    public void save(String  result) {
        history.add(result);
    }

    public void getHistory() {
        history.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "CalculatorHistory{history=%s}".formatted(history);
    }
}
