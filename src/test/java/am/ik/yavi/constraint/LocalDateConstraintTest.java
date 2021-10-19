package am.ik.yavi.constraint;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalDateConstraintTest {

    @ParameterizedTest
    @ValueSource(strings = { "1970-01-01", "1969-01-01", "0001-01-01" })
    void testIsAfterFalseyDates(String value) {
        Predicate<LocalDate> predicate = new LocalDateConstraint<>().isAfter(LocalDate.of(1970, 1, 1));
        assertThat(predicate.test(LocalDate.parse(value))).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = { "1970-01-02", "1980-01-01", "2021-01-01" })
    void testIsAfterTruthyDates(String value) {
        Predicate<LocalDate> predicate = new LocalDateConstraint<>().isAfter(LocalDate.of(1970, 1, 1));
        assertThat(predicate.test(LocalDate.parse(value))).isTrue();
    }


    @ParameterizedTest
    @ValueSource(strings = { "1988-01-02", "1990-01-01", "2021-01-01" })
    void testisGreaterThanYearsAfterTruthyDates(String value) {
        Predicate<LocalDate> predicate = new LocalDateConstraint<>().isGreaterThanYearsAfter(18, LocalDate.of(1970, 1, 1));
        assertThat(predicate.test(LocalDate.parse(value))).isTrue();
    }
}
