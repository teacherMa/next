package algorithm.leetcode;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) {
            return false;
        }

        int[][] smallTable = new int[9][9];
        int[][] linesTable = new int[9][9];

        for (int i = 0; i < 9; i++) {
            char[] row = board[i];
            int[] rowTable = new int[9];
            for (int j = 0; j < 9; j++) {
                if (row[j] == '.') {
                    continue;
                }
                int toInteger = row[j] - '1';
                int smallTableIndex = getSmallTableIndex(i, j);
                if (rowTable[toInteger] == 1
                        || smallTable[smallTableIndex][toInteger] == 1
                        || linesTable[j][toInteger] == 1) {
                    return false;
                }
                rowTable[toInteger] = 1;
                smallTable[smallTableIndex][toInteger] = 1;
                linesTable[j][toInteger] = 1;
            }
        }
        return true;
    }

    /**
     * find int[i][j]
     */
    private int getSmallTableIndex(int i, int j) {
        return (i / 3) * 3 + j / 3;
    }
}
