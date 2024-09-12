package k3;

import java.util.Arrays;

public class K3_2 {
    public static void main(String[] args) {
        int[][] test1 = { {1, 2, 0, -1, -2, 3}, {-1, 2, 3}, {0, 0}, {}, {4, 5, -1} };
        int[][] test2 = { {1, 2, 3}, {4, 5, 2}, {-2, -3, 2, -1}, {3, 2, 1, 5}, {4, 5, 1, 4} };
        int[][] test3 = { {1, -1, 2, -2, 3}, {1, 2, 3}, {-3, -1, -2} };
        char[] age1 = {'d', 'u', '-', 'd', 'u', '-', 'd', 'a', '-', 'd', 'a'};
        char[] age2 = {'m', 'a', 'm', 'a', '!', 'n', 'e', 'i', 'n'};

        int[][] result1 = generate(test1);
        int[][] result2 = generate(test2);

        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));

        fill(test1, test2[3], test2[4]);
        fill(result1, test2[2], test2[4]);
        fill(test3, test2[2], test2[3]);

        System.out.println(Arrays.deepToString(test1));
        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(test3));

        System.out.println(extractString(age1, 0, age1.length, '-'));
        System.out.println(extractString(age1, 1, 7, 'u'));
        System.out.println(extractString(age2, 0, 5, 'a'));
        System.out.println(extractString(age2, 5, age2.length, 'n'));
    }

    public static int[][] generate(int[][] input) {
        if (input == null)
            throw new IllegalArgumentException();
        int[][] result = new int[input.length][];
        for (int row = 0; row < input.length; row++) {
            result[row] = new int[input[row].length];

            int negativeIndex = 0;
            for (int col = 0; col < input[row].length; col++) {
                int val = input[row][col];
                if (val < 0) {
                    result[row][negativeIndex] = val;
                    negativeIndex++;
                }
            }
            int positiveIndex = negativeIndex;
            for (int col = 0; col < input[row].length; col++) {
                int val = input[row][col];
                if (val >= 0) {
                    result[row][positiveIndex] = val;
                    positiveIndex++;
                }
            }
        }

        return result;
    }

    public static void fill(int[][] target, int[] values, int[] times) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            int time = times[i];
                for (int t = 0; t < time; t++) {
                    if (target[row].length == 0)
                        row++;
                    target[row][col] = value;
                    col++;
                    if (col >= target[row].length) {
                        col = 0;
                        row++;
                    }
                }
        }
    }

    public static String extractString(char[] sequence, int start, int end, char omit) {
        if (start == end)
            return "";
        if (sequence[start] == omit)
            return extractString(sequence, start + 1, end, omit);
        else return sequence[start] + extractString(sequence, start + 1, end, omit);
    }
}
