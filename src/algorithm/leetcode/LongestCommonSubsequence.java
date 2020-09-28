package algorithm.leetcode;

public class LongestCommonSubsequence {
    public static final int DATA_SIZE = 20;

    public static void main(String[] args) {
        char[] s1 = new char[DATA_SIZE];
        char[] s2 = new char[DATA_SIZE];
        for (int i = 0; i < DATA_SIZE; i++) {
            s1[i] = (char) ('A' + (int) (Math.random() * 26));
            s2[i] = (char) ('A' + (int) (Math.random() * 26));
        }

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(new LongestCommonSubsequence().commonSub(new String(s1), new String(s2)));
    }

    private String commonSub(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return "";
        }
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] lengthTable = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < l1 + 1; i++) {
            for (int j = 0; j < l2 + 1; j++) {
                lengthTable[i][j] = 0;
            }
        }

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lengthTable[i][j] = lengthTable[i - 1][j - 1] + 1;
                } else {
                    lengthTable[i][j] = Math.max(lengthTable[i - 1][j], lengthTable[i][j - 1]);
                }
            }
        }

        printAA(lengthTable);

        int maxLength = lengthTable[l1][l2];

        if (maxLength == 0) {
            return "";
        }

        char[] result = new char[maxLength];

        for (int i = l1; i > 0; i--) {
            for (int j = l2; j > 0; j--) {
                if (lengthTable[i][j] == lengthTable[i - 1][j - 1] + 1) {
                    result[maxLength - 1] = s2.charAt(j - 1);
                    maxLength--;
                    System.out.println(i + " " + j);
                    if (maxLength == 0) {
                        return new String(result);
                    }
                    l2 = j - 1;
                    break;
                }
            }
        }

        return new String(result);
    }

    private static void printAA(int[][] aa) {
        int l1 = aa.length;
        int l2 = aa[0].length;

        System.out.println(" ");
        for (int[] ints : aa) {
            for (int j = 0; j < l2; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
