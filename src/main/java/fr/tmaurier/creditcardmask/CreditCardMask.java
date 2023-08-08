package fr.tmaurier.creditcardmask;

public class CreditCardMask {
    public static String maskify(String str) {
        if (str.length() <= 4) {
            return str;
        }

        return str.substring(0, str.length() - 4).replaceAll(".", "#").concat(str.substring(str.length() - 4));

    }
}
