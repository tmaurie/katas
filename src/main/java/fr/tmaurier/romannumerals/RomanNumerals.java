package fr.tmaurier.romannumerals;

public class RomanNumerals {
    private static final String[] ROMAN_NUMERALS = {"I", "V", "X", "L", "C", "D", "M"};

    public static String arabicToRoman(int arabicNumeral) {
        StringBuilder romanNumeral = new StringBuilder();
        int i = 0;
        while (arabicNumeral > 0) {
            int digit = arabicNumeral % 10;
            romanNumeral.insert(0, convertDigitToRomanNumeral(digit, i));
            arabicNumeral /= 10;
            i += 2;
        }
        return romanNumeral.toString();
    }

    private static String convertDigitToRomanNumeral(int digit, int index) {
        StringBuilder romanNumeral = new StringBuilder();

        if (digit == 9) {
            romanNumeral.append(ROMAN_NUMERALS[index]).append(ROMAN_NUMERALS[index + 2]);
        } else if (digit >= 5) {
            romanNumeral.append(ROMAN_NUMERALS[index + 1]);
            romanNumeral.append(ROMAN_NUMERALS[index].repeat(digit - 5));
        } else if (digit == 4) {
            romanNumeral.append(ROMAN_NUMERALS[index]).append(ROMAN_NUMERALS[index + 1]);
        } else {
            romanNumeral.append(ROMAN_NUMERALS[index].repeat(Math.max(0, digit)));
        }

        return romanNumeral.toString();
    }
}
