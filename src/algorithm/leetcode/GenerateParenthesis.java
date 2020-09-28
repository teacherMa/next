package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        if (n < 0) {
            throw new RuntimeException();
        }
        List<String> result = new ArrayList<>();

        if (n == 1) {
            result.add("()");
            return result;
        }

        List<String> subList = generateParenthesis(n - 1);
        int subLength = subList.size();
        Map<String, String> mapping = new HashMap<>();
        for (int i = 0; i < subLength; i++) {
            String str = subList.get(i);
            int strLength = str.length();
            for (int j = 0; j < strLength; j++) {
                String s = str.substring(0, j) + "()" + str.substring(j, strLength);
                if (!mapping.containsKey(s)) {
                    result.add(s);
                    mapping.put(s,"");
                }
            }
        }
        return result;
    }
}
