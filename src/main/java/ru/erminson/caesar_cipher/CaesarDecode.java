package main.java.ru.erminson.caesar_cipher;

import java.util.HashMap;
import java.util.Map;

public class CaesarDecode {
    private final String LOWER_CASE = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final String UPPER_CASE = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private final Map<Boolean, String> table = new HashMap<>();

    private int shift;

    public CaesarDecode(final int shift) {
        this.shift = shift;

        table.put(true, LOWER_CASE);
        table.put(false, UPPER_CASE);
    }

    public String decode(final String encodedText) {
        final int size = encodedText.length();
        final StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            char ch = encodedText.charAt(i);

            if (ch == 10 || ch == 32 || ch == 44 || ch == 46 ) {
                sb.append(ch);
            } else {
                boolean isLower = Character.isLowerCase(ch);
                String alphabet = table.get(isLower);
                int index = alphabet.indexOf(ch);
                int decodedIndex = (index + shift) % 33;
                char decodedChar = alphabet.charAt(decodedIndex);
                sb.append(decodedChar);
            }
        }

        return sb.toString();
    }
}
