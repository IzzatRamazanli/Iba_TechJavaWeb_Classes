package lesson1practice;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class CalculatorHistory {
    private final List<String> history;

    public void save(String result) {
        history.add(result);
    }

    public void getHistory() {
        history.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return getString();
    }

    public String getString() {
        StringBuilder[] sb = {new StringBuilder()};
        AtomicInteger counter = new AtomicInteger(1);
        history.forEach(x -> sb[0].append(counter.getAndIncrement()).append(". ").append(x).append("\n"));
        return sb[0].toString();
    }


}
