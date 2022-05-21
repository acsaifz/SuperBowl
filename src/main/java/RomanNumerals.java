import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    private String romanNumerals;

    public void setRomanNumerals(String ujErtek) {
        this.romanNumerals = ujErtek;
    }

    private static final Map<Character, Integer> romanMap = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public String getArabSsz() {
        int value = 0;
        String romanNumber = romanNumerals.replace(".", "");
        for (int i = 0; i < romanNumber.length(); i++) {
            if (i + 1 < romanNumber.length() &&
                    romanMap.get(romanNumber.charAt(i)) < romanMap.get(romanNumber.charAt(i + 1))) {
                value -= romanMap.get(romanNumber.charAt(i));
            } else {
                value += romanMap.get(romanNumber.charAt(i));
            }
        }
        return value + ".";
    }

    public RomanNumerals(String romaiSsz) {
        this.romanNumerals = romaiSsz.toUpperCase();
    }
}
