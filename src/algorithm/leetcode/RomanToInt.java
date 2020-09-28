package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }
        String[] mod = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Map<String, Integer> mapping = new HashMap<>(16);
        mapping.put("M", 1000);
        mapping.put("CM", 900);
        mapping.put("D", 500);
        mapping.put("CD", 400);
        mapping.put("C", 100);
        mapping.put("XC", 90);
        mapping.put("L", 50);
        mapping.put("XL", 40);
        mapping.put("X", 10);
        mapping.put("IX", 9);
        mapping.put("V", 5);
        mapping.put("IV", 4);
        mapping.put("I", 1);

        int length = mod.length;
        int result = 0;
        int max = 0;
        while (!s.isEmpty()) {
            for (int i = max; i < length; i++) {
                if (s.startsWith(mod[i])) {
                    result += mapping.get(mod[i]);
                    s = s.replaceFirst(mod[i], "");
                    max = i;
                }
            }
        }
        return result;

    }
}
