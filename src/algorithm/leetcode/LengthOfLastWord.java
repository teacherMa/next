package algorithm.leetcode;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int length = s.length();
        int wordLength = 0;
        boolean preIsSpace = true;
        for (int i = length - 1; i > -1; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (preIsSpace) {
                    preIsSpace = false;
                    wordLength = 1;
                } else {
                    wordLength ++;
                }
            } else {
                if (!preIsSpace) {
                    return wordLength;
                }
                preIsSpace = true;
            }
        }
        return wordLength;
    }
}