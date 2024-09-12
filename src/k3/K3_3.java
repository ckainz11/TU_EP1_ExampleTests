package k3;

import java.util.Arrays;

public class K3_3 {

    public static void main(String[] args) {
        int[][] data0 = {{3, 0}, {0, 1}, {2, 2}};
        int[][] data1 = {{0, 1, 0, 0, 1, 0}, {}, {2, 2, 2, 2, 0, 1}};
        int[] target1 = {0, 0, 0};
        int[] target2 = {9, 9, 9, 9};

        System.out.println("----- labelPath -----");

        System.out.println(Arrays.deepToString(labelPath(3, new int[][]{})));
        System.out.println(Arrays.deepToString(labelPath(4, data0)));

        System.out.println("----- findMatches -----");

        findMatches(data0, data0[1], target1);
        System.out.println(Arrays.toString(target1));
        findMatches(data1, data0[1], target1);
        System.out.println(Arrays.toString(target1));
        findMatches(data1, data0[2], target2);
        System.out.println(Arrays.toString(target2));

        System.out.println("----- insertMiddle ----");

        System.out.println(insertMiddle("XY", "abc"));
        System.out.println(insertMiddle("01234", "abc"));
        System.out.println(insertMiddle("01234567890123", "./-"));
    }

    public static int[][] labelPath(int n, int[][] points) {
        if (n < 1 || points == null)
            throw new IllegalArgumentException();

        int[][] result = new int[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                result[y][x] = n;
            }
        }

        for (int row = 0; row < points.length; row++) {
            result[points[row][0]][points[row][1]] = -1;
        }

        return result;
    }

    public static void findMatches(int[][] data, int[] pattern, int[] target) {
        if (pattern.length == 0 || data == null || target.length < data.length)
            throw new IllegalArgumentException();

        for (int rowIndex = 0; rowIndex < data.length; rowIndex++) {
            int[] row = data[rowIndex];
            int matchCount = 0;
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                boolean match = true;
                for (int i = 0; i < pattern.length && match; i++) {
                    if (colIndex + i >= row.length || row[colIndex + i] != pattern[i])
                        match = false;
                }
                if (match)
                    matchCount++;
            }
            target[rowIndex] = matchCount;
        }
    }

    public static String insertMiddle(String input, String seps) {
        if (seps.length() == 0 || input.length() == 1)
            return input;

        int middle = input.length() / 2;
        return insertMiddle(input.substring(0, middle), seps.substring(1)) +
                seps.charAt(0) +
                insertMiddle(input.substring(middle), seps.substring(1));
    }
}
