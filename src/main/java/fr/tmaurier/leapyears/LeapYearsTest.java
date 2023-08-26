package fr.tmaurier.leapyears;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeapYearsTest {

    private final LeapYears leapYears = new LeapYears();

    @Test
    void shouldReturnTrueWhenYearIsDivisibleBy400() {
        assertThat(leapYears.isLeapYear(2000)).isTrue();
    }

    @Test
    void shouldReturnFalseWhenYearIsDivisibleBy100ButNotBy400() {
        assertThat(leapYears.isLeapYear(1700)).isFalse();
    }

    @Test
    void shouldReturnTrueWhenYearIsDivisibleBy4ButNotBy100() {
        assertThat(leapYears.isLeapYear(2008)).isTrue();
    }

    @Test
    void shouldReturnFalseWhenYearIsNotDivisibleBy4() {
        assertThat(leapYears.isLeapYear(2017)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"2000, true", "1700, false", "1800, false", "1900, false", "2008, true", "2012, true", "2016, true", "2017, false", "2018, false", "2019, false", "2020, true" })
    void shouldDetermineIfTheYearIsLeap(int year, boolean expected) {
        assertEquals(expected, leapYears.isLeapYear(year));
    }


}
