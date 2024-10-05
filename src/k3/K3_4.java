package k3;

import java.util.Arrays;

public class K3_4 {
    public static void main(String[] args) {
        int[][] test1 = {{5, 2, 4}, {8, 5, 4}, {9, 6, 8, 7}};
        int[][] test2 = {{0, 1, 2}, {0, 1, 2}, {0, 1, 2}};
        int[][] test3 = {{6}, {2, 4}, {2, 4}, {2, 4}, {4, 2}};
        int[] seq1 = {4, 3, 2, 1, 10, 5, 5, 5};

        int[][] result1 = rearrange(test1);
        int[][] result2 = rearrange(test3);

        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));
        System.out.println(Arrays.deepToString(rearrange(new int[][]{})));

        label(test1);
        System.out.println(Arrays.deepToString(test1));
        label(test2);
        System.out.println(Arrays.deepToString(test2));
        label(test3);
        System.out.println(Arrays.deepToString(test3));

        System.out.println(findMaxOppositeSum(seq1, 0, 7));
        System.out.println(findMaxOppositeSum(seq1, 0, 5));
        System.out.println(findMaxOppositeSum(seq1, 4, 7));
    }

    static int[][] rearrange(int[][] inputArray) {
        int elemCount = 0;
        for (int i = 0; i < inputArray.length; i++) {
            elemCount += inputArray[i].length;
        }
        int[][] out = new int[(int) Math.ceil(elemCount / 4.0)][4];

        int count = 0;
        for (int y = 0; y < inputArray.length; y++) {
            int[] row = inputArray[y];
            for (int x = 0; x < row.length; x++) {
                int newY = count / 4;
                int newX = (newY % 2 == 0) ? count % 4 : (3 - (count % 4));
                out[newY][newX] = inputArray[y][x];
                count++;
            }
        }
        return out;
    }

    static void label(int[][] inputArray) {
        for (int y = 1; y < inputArray.length; y++) {
            int[] row = inputArray[y];
            int[] previousRow = inputArray[y - 1];

            if (row.length != previousRow.length)
                continue;
            boolean match = true;
            for (int x = 0; x < row.length; x++) {
                match = match && (row[x] == previousRow[x]);
            }

            if (!match)
                continue;

            for (int x = 0; x < row.length; x++) {
                inputArray[y - 1][x] = -9;
            }
        }
    }

    static int findMaxOppositeSum(int[] sequence, int start, int end) {
        if (start >= end)
            return 0;

        int sum = sequence[start] + sequence[end];
        return Math.max(sum, findMaxOppositeSum(sequence, start + 1, end - 1));
    }
}
