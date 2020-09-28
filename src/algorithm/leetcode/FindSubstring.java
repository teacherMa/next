package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubstring {
    public static void main(String[] args) {
        new FindSubstring().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0) {
            return null;
        }
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            int time = count.getOrDefault(word, 0);
            count.put(word, time + 1);
        }

        List<Integer> result = new ArrayList<>();
        int wLength = words[0].length();
        int wCount = words.length;
        int length = s.length() - wLength * wCount;
        for (int i = 0; i < length + 1; ) {
            Map<String, Integer> copy = new HashMap<>(count);
            boolean find = false;
            for (int j = 0; j < wCount; j++) {
                int start = i + j * wLength;
                String sub = s.substring(start, start + wLength);
                int time = copy.getOrDefault(sub, 0);
                if (time <= 0) {
                    if (copy.containsKey(sub)) {
                        i = i + wLength;
                    } else {
                        i = i + 1;
                    }
                    find = false;
                    break;
                }
                find = true;
                copy.put(sub, time - 1);
            }
            if (find) {
                result.add(i);
                i = i + wLength;
            }
        }
        return result;
    }
}
