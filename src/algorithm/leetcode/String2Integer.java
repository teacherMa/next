package algorithm.leetcode;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class String2Integer {
    public static void main(String[] args) {
        new String2Integer().myAtoi(" -42");
    }

    public int myAtoi(String str) {
        int[] table = new int[127];

        table['0'] = 0;
        table['1'] = 1;
        table['2'] = 2;
        table['3'] = 3;
        table['4'] = 4;
        table['5'] = 5;
        table['6'] = 6;
        table['7'] = 7;
        table['8'] = 8;
        table['9'] = 9;

        char[] cstr = str.toCharArray();
        int length = cstr.length;

        boolean findSymbol = false;
        boolean isFirst = true;
        long result = 0;
        char symbol = '+';
        for (int i = 0; i < length; i++) {
            if (cstr[i] == ' ') {
                continue;
            }
            if (!findSymbol) {
                if ((cstr[i] >= '0' && cstr[i] <= '9')) {
                    findSymbol = true;
                    isFirst = false;
                    symbol = '+';
                } else {
                    if (cstr[i] == '0' || (cstr[i] != '-' && cstr[i] != '+')) {
                        return 0;
                    }
                    symbol = cstr[i];
                    findSymbol = true;
                    continue;
                }
            }
            if (isFirst) {
                if (cstr[i] <= '0' || cstr[i] > '9') {
                    return 0;
                }
                isFirst = false;
            }
            if (cstr[i] >= '0' && cstr[i] <= '9') {
                result = result * 10 + table[cstr[i]];
            } else {
                break;
            }
        }
        result = result * (symbol == '-' ? -1 : 1);
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }
        return (int) result;
    }
}