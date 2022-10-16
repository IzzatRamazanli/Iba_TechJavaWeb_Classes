package lesson7;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


public class HistoryItem {
    public final int x;
    public final int y;
    public final int z;
    public final LocalDateTime ldt;

    public HistoryItem(int x, int y, int z, LocalDateTime ldt) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.ldt = ldt;
    }

    public HistoryItem(int x, int y, int z) {
        this(x, y, z, LocalDateTime.now());
    }


    @Override
    public String toString() {
        return "{x=%d, y=%d, z=%d, ldt=%s}".formatted(x, y, z, ldt.toString());
    }
}
