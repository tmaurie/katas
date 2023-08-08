package fr.tmaurier.creditcardmask;

import java.util.stream.IntStream;

public class CreditCardMask {
    public static String maskify(String str) {
        char[] chars = str.toCharArray();
        IntStream.range(0, chars.length - 4).forEach(i -> chars[i] = '#');
        return new String(chars);
    }
}
