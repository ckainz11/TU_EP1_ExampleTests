package k3;

import java.util.Arrays;

public class K3_6 {
    public static void main(String[] args) {
        int[][] test1 = {{5}, {5, 7, 9}, {8, 5}, {}};
        int[][] test2 = {{1, 2}, {1, 2, 3}, {1, 2, 3, 4}};
        int[][] test3 = {{}, {1, 2, 3, 4}, {1}};
        int[] seq = {1, 2, -5, 3, -1, 6, -3, 3};

        int[][] result1 = getRectangular(test1);
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = getRectangular(test2);
        System.out.println(Arrays.deepToString(result2));
        int[][] result3 = getRectangular(test3);
        System.out.println(Arrays.deepToString(result3));
        int[][] result4 = getRectangular(new int[][]{{}});
        System.out.println(Arrays.deepToString(result4));

        removeEntry(test2, 2);
        System.out.println(Arrays.deepToString(test2));
        removeEntry(test3, 0);
        System.out.println(Arrays.deepToString(test3));

        System.out.println(isAlternating(seq, 0));
        System.out.println(isAlternating(seq, 1));
        System.out.println(isAlternating(seq, 6));
        System.out.println(isAlternating(seq, 7));
    }

    static int[][] getRectangular(int[][] input) {
        int maxLength = 0;
        for (int[] row : input) {
            maxLength = Math.max(maxLength, row.length);
        }
        int[][] out = new int[input.length][maxLength];

        for (int y = 0; y < out.length; y++) {
            int[] row = out[y];
            for (int x = 0; x < row.length; x++) {
                if (input[y].length == 0)
                    out[y][x] = 0;
                else
                    out[y][x] = input[y][x % input[y].length];
            }
        }
        return out;
    }

    static void removeEntry(int[][] input, int col) {
        for (int y = 0; y < input.length; y++) {
            int[] row = input[y];
            int[] newRow = new int[row.length > col ? row.length - 1 : row.length];
            int index = 0;
            for (int x = 0; x < row.length; x++) {
                if (x != col) {
                    newRow[index] = row[x];
                    index++;
                }
            }
            input[y] = newRow;
        }
    }

    static boolean isAlternating(int[] seq, int index) {
        if (index == seq.length - 1)
            return true;

        if (seq[index] > 0 && seq[index + 1] < 0)
            return isAlternating(seq, index + 1);
        if (seq[index] < 0 && seq[index + 1] > 0)
            return isAlternating(seq, index + 1);
        return false;
    }
}
