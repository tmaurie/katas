package fr.tmaurier.phonewords;

public class PhoneWords {


    static String[] keys = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static String phoneWords(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; str != null && i < str.length(); ) {
            int count = 0, cp = str.codePointAt(i);
            var s = keys[cp - '0'];
            while (i + count < str.length() && str.codePointAt(i + count) == cp && count < s.length()) count++;
            if (!s.isEmpty()) res.append((char) s.codePointAt(count - 1));
            i += s.isEmpty() ? 1 : count;
        }
        return res.toString();
    }


}
