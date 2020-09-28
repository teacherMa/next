package algorithm.leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZConvert {
    public static void main(String[] args) {
        System.out.println(new ZConvert().convert("LEETCODEISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if (s == null || numRows <= 0) {
            throw new RuntimeException();
        }

        if (numRows == 1) {
            return s;
        }

        char[] result = new char[s.length()];

        int diff = 2 * numRows - 2;
        int count = 0;

        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < s.length()) {
                result[count] = s.charAt(index);
                count++;
                if (i != 0 && i != numRows - 1) {
                    int insert = index + diff - i * 2;
                    if (insert < s.length()) {
                        result[count] = s.charAt(insert);
                        count ++;
                    }
                }
                index = index + diff;
            }
        }
        return new String(result);
    }
}
