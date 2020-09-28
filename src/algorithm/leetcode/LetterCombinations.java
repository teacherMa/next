package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射与九宫格按键相同，注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations {

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        List<String> letter = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String sub = digits.substring(i, i + 1);
            String symbol = getSymbol(sub);

            int symbolLength = symbol.length();
            if (letter.isEmpty()) {
                for (int j = 0; j < symbolLength; j++) {
                    letter.add(String.valueOf(symbol.charAt(j)));
                }
                continue;
            }

            List<String> origin = new ArrayList<>(letter);
            int originSize = origin.size();
            for (int j = 0; j < originSize; j++) {
                letter.set(j, origin.get(j) + symbol.charAt(0));
            }
            for (int j = 0; j < originSize; j++) {
                for (int k = 1; k < symbolLength; k++) {
                    letter.add(origin.get(j) + symbol.charAt(k));
                }
            }
        }
        return letter;
    }

    private String getSymbol(String num) {
        switch (num) {
            case "2":
                return "abc";
            case "3":
                return "def";
            case "4":
                return "ghi";
            case "5":
                return "jkl";
            case "6":
                return "mno";
            case "7":
                return "pqrs";
            case "8":
                return "tuv";
            case "9":
                return "wxyz";
            default:
                return "";
        }
    }
}
