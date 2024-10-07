package k3;

import java.util.Arrays;

public class K3_8 {
    public static void main(String[] args) {
        int[] test1 = {3, 0, 6, -1, 1};
        int[][] test2 = {{0}, {6, -5}, {0, 0}, {0, 1, 2, 0}};
        int[][] test3 = {{1, 2, 7, 3, 0}, {-8}, {0, 2}, {1, 4, -2, 1}};

        boolean[][] result1 = create(new int[]{3});
        System.out.println(Arrays.deepToString(result1));
        boolean[][] result2 = create(new int[]{-2, 0});
        System.out.println(Arrays.deepToString(result2));
        boolean[][] result3 = create(new int[]{});
        System.out.println(Arrays.deepToString(result3));

        move(test2);
        System.out.println(Arrays.deepToString(test2));
        move(test3);
        System.out.println(Arrays.deepToString(test3));

        System.out.println(oddOccurrences("This is not a test!", 's'));
        System.out.println(oddOccurrences("This is not a test!", 'T'));
        System.out.println(oddOccurrences("This is not a test!", 't'));
        System.out.println(oddOccurrences("This is not a test!", ' '));
        System.out.println(oddOccurrences("",'x'));
    }

    static boolean[][] create(int[] input) {
        boolean[][] out = new boolean[input.length][];
        for (int i = 0; i < input.length; i++) {
            int num = input[i];
            boolean[] row = new boolean[Math.max(num + 1, 3)];
            if (num >= 0)
                row[num] = true;
            out[i] = row;
        }
        return out;
    }

    static void move(int[][] input) {
        for (int y = 0; y < input.length; y++) {
            int[] row = input[y];
            int[] newRow = new int[row[row.length - 1] == 0 ? row.length : row.length + 1];
            for (int x = 1; x < newRow.length; x++) {
                newRow[x] = row[x - 1];
            }
            input[y] = newRow;
        }
    }

    static boolean oddOccurrences(String s, char ch) {
        if (s.isEmpty())
            return false;
        if (s.length() == 1)
            return s.charAt(0)  == ch;

        if (s.charAt(0) == ch)
            return !oddOccurrences(s.substring(1), ch);
        else return oddOccurrences(s.substring(1), ch);

    }
}
