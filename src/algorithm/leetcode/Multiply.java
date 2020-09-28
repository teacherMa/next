package algorithm.leetcode;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Multiply {

    public static void main(String[] args) {
        System.out.println(new Multiply().multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int[] sum = new int[l1 + l2];
        for (int i = 0; i < l1 + l2; i++) {
            sum[i] = 0;
        }

        for (int i = l1 - 1; i > -1; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = l2 - 1; j > -1; j--) {
                int n2 = num2.charAt(j) - '0';
                int s = sum[i + j + 1] + n1 * n2;
                sum[i + j + 1] = s % 10;
                sum[i + j] += s / 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int start = 0;
        if (sum[start] == 0) {
            start ++;
        }
        for (int i = start; i < l1 + l2; i++) {
            stringBuilder.append(sum[i]);
        }
        return stringBuilder.toString();
    }
}
