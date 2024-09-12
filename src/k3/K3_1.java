package k3;

import java.util.Arrays;

public class K3_1 {

    public static void main(String[] args) {
        int[][] test1 = { {5, 2, 4}, {2, 7, 3}, {9, 5, 8} };
        int[][] test2 = { {1} };
        int[][] test3 = { {6, 7, 8}, {7, 5, 3, 1}, {2} };
        String seq1 = "ABBAACBA";

        int[][] result1 = generate(test1);
        int[][] result2 = generate(test2);

        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));

        reorder(result1);
        reorder(result2);
        reorder(test3);

        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));
        System.out.println(Arrays.deepToString(test3));

        System.out.println(isPresentNTimes(seq1, 'A', 4));
        System.out.println(isPresentNTimes(seq1, 'A', 3));
        System.out.println(isPresentNTimes(seq1, 'A', 5));
        System.out.println(isPresentNTimes(seq1, 'Z', 0));
    }

    public static int[][] generate(int[][] input) {
        int[][] result = new int[input.length * 2 - 1][];
        for (int row = 0; row < input.length; row++) {
            result[row] = new int[input[row].length - row];
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = input[row][col];
            }
        }
        for (int row = input.length; row < result.length; row++) {
            result[row] = result[input.length - row + 1];
        }
        return result;
    }

    public static void reorder(int[][] input) {
        for (int row = 0; row < input.length; row++) {
            int[] newRow = new int[input[row].length];
            for (int col = 0; col < newRow.length; col++) {
                newRow[col] = input[row][newRow.length - 1 - col];
            }
            input[row] = newRow;
        }
    }

    public static boolean isPresentNTimes(String sequence, char marker, int count) {
        if (sequence.length() == 0)
            return count == 0;

        if (sequence.charAt(0) == marker)
            return isPresentNTimes(sequence.substring(1), marker, count - 1);
        else return isPresentNTimes(sequence.substring(1), marker, count);
    }


}
