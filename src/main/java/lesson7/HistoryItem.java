package lesson7;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class HistoryItem {
    public final int x;
    public final int y;
    public final int z;
    public final LocalDateTime ldt = LocalDateTime.now();

    @Override
    public String toString() {
        return "{x=%d, y=%d, z=%d, ldt=%s}".formatted(x, y, z, ldt.toString());
    }
}
