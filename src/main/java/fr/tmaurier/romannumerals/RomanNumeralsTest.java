package fr.tmaurier.romannumerals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsTest {

    @ParameterizedTest(name = "should convert {0} to {1}")
    @CsvSource({"1, I", "2, II", "3, III", "4, IV", "5, V", "6, VI", "7, VII", "8, VIII", "9, IX", "10, X", "79, LXXIX", "99, XCIX", "100, C", "400, CD", "500, D", "900, CM", "1000, M", "1984, MCMLXXXIV", "3999, MMMCMXCIX", "2023, MMXXIII"})
    void shouldConvertToRomanNumerals(int arabicNumeral, String romanNumeral) {
        assertEquals(romanNumeral, RomanNumerals.arabicToRoman(arabicNumeral));
    }
}
