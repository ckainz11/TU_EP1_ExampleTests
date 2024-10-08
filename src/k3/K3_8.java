package k3;

import java.util.Arrays;

public class K3_8 {
    public static void main(String[] args) {
        int[][] test1 = {{1}, {1, 2, 3}, {1, 2, 3, 4}, {1, 2}};
        int[][] test2 = {{1, 2, 3}, {0}, {1, 2}, {0}, {1}};
        int[] seq = {2, 8, 8, 5, 2, 5, 7, 3};

        int[][] result1 = repeat(test1, new int[]{1, -2, 1, 0});
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = repeat(test2, new int[]{1, 0, -3, 2, 0});
        System.out.println(Arrays.deepToString(result2));

        rasp(test1);
        System.out.println(Arrays.deepToString(test1));
        rasp(test2);
        System.out.println(Arrays.deepToString(test2));

        System.out.println(hasNOrderedPairs(seq, 4, 0));
        System.out.println(hasNOrderedPairs(seq, 2, 2));
        System.out.println(hasNOrderedPairs(seq, 1, 3));
        System.out.println(hasNOrderedPairs(seq, 3, 3));
        System.out.println(hasNOrderedPairs(seq, 0, 6));
    }

    static int[][] repeat(int[][] input, int[] reps) {
        int[][] out = new int[input.length][];
        for (int i = 0; i < reps.length; i++) {
            int rep = Math.abs(reps[i]) + 1;
            int[] row = input[i];
            out[i] = new int[rep * row.length];
            // reverse row
            if (reps[i] < 0) {
                int[] newRow = new int[input[i].length];
                for (int x = 0; x < row.length; x++) {
                    newRow[row.length - x - 1] = row[x];
                }
                row = newRow;
            }
            for (int j = 0; j < rep; j++) {
                for (int x = 0; x < out[i].length; x++) {
                    out[i][x] = row[x % row.length];
                }
            }

        }
        return out;
    }

    static void rasp(int[][] input) {
        for (int i = 0; i < input.length - 1; i+=2) {
            // line 1
            int last = input[i][input[i].length - 1];
            int[] row = input[i];
            input[i] = new int[input[i].length - 1];
            for (int j = 0; j < input[i].length; j++) {
                input[i][j] = row[j];
            }
            // line 2
            int[] nextRow = input[i + 1];
            input[i + 1] = new int[input[i + 1].length + 1];
            for (int j = 0; j < nextRow.length; j++) {
                input[i+1][j] = nextRow[j];
            }
            input[i+1][nextRow.length] = last;
        }
    }

    static boolean hasNOrderedPairs(int[] seq, int n, int index) {
        if (index >= seq.length - 1)
            return n == 0;

        if (seq[index] <= seq[index + 1])
            return hasNOrderedPairs(seq, n - 1, index + 1);
        return hasNOrderedPairs(seq, n, index + 1);
    }
}
