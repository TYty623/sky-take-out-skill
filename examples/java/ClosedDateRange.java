package examples;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/** A validated, inclusive calendar-date range for reporting requests. */
public record ClosedDateRange(LocalDate start, LocalDate end) {
    public ClosedDateRange {
        Objects.requireNonNull(start, "start");
        Objects.requireNonNull(end, "end");
        if (end.isBefore(start)) {
            throw new IllegalArgumentException("end must not be before start");
        }
    }

    public boolean contains(LocalDate date) {
        Objects.requireNonNull(date, "date");
        return !date.isBefore(start) && !date.isAfter(end);
    }

    public long dayCount() {
        return ChronoUnit.DAYS.between(start, end) + 1;
    }

    public void requireNoLongerThan(long maximumDays) {
        if (maximumDays < 1) {
            throw new IllegalArgumentException("maximumDays must be positive");
        }
        if (dayCount() > maximumDays) {
            throw new IllegalArgumentException("date range exceeds " + maximumDays + " days");
        }
    }
}
