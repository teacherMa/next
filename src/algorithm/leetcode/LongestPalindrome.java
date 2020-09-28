package algorithm.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        new LongestPalindrome().longestPalindrome("bb");
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            throw new RuntimeException();
        }

        if (s.length() == 0) {
            return "";
        }

        int length = s.length();
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            int l1 = expandLength(s, i, i);
            int l2 = expandLength(s, i - 1, i);
            if (l1 > max) {
                max = l1;
                start = i - l1 / 2;
                end = i + l1 / 2 ;
            }
            if (l2 > max) {
                max = l2;
                start = i - max / 2;
                end = i + max / 2 - 1;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandLength(String s, int left, int right) {
        int length = 0;
        for (; left >= 0 && right < s.length(); left--, right++) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            length = (right - left + 1);
        }
        return length;
    }
}
