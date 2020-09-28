package algorithm.leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ParenthesesIsValid {
    public static void main(String[] args) {
        System.out.println(Math.abs((int)'{' - (int)'}'));
        System.out.println(Math.abs((int)'(' - (int)')'));
        System.out.println(Math.abs((int)'[' - (int)']'));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (isLeft(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char in = stack.pop();
                if (!pair(in, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean pair(char c1, char c2) {
        int abs = Math.abs(c1 - c2);
        return abs == 2 || abs == 1;
    }
}
