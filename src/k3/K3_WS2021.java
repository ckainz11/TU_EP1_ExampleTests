package k3;

import java.util.Arrays;

// Angabe: https://vowi.fsinf.at/images/8/85/TU_Wien-Einf%C3%BChrung_in_die_Programmierung_1_VU_%28Podlipnig%29_-_Einstufungstest_K3_WS2021.pdf

public class K3_WS2021 {
    public static void main(String[] args) {
        int[] test1 = {1, -5, 0, 6};
        int[][] test2 = {{1},{2},{3}};
        int[][] test3 = {{1, 0, 1}, {}, {5, 5, 6, 5}, {}};
        int[][] test4 = {{7, 7, 5, 7, 3}, {2, -4}, {10, 20, 30}, {-1, -2, -3, -4, -5, -6, -7}};
        int[][] test5 = {{}, {}}, test6 = {{}};

        int[][] result1 = generate(test1);
        System.out.println(Arrays.deepToString(result1));
        System.out.println(result1[0] == test1);
        System.out.println(result1[0] == result1[1]);
        System.out.println(result1[0] == result1[2]);
        System.out.println(result1[1] == result1[2]);

        System.out.println(Arrays.deepToString(change(test2)));
        System.out.println(Arrays.deepToString(change(test3)));
        System.out.println(Arrays.deepToString(change(test4)));
        System.out.println(Arrays.deepToString(change(test5)));
        System.out.println(Arrays.deepToString(change(test6)));

        System.out.println(isEqual("blah", "blahblah"));
        System.out.println(isEqual("blah", "blah"));
        System.out.println(isEqual("", ""));
        System.out.println(isEqual(null, null));
    }

    private static int[][] generate(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0)
            throw new IllegalArgumentException();

        int[][] result = new int[inputArray.length + 1][];
        result[0] = inputArray;

        for (int i = 0; i < inputArray.length; i++) {
            result[i + 1] = new int[inputArray.length - i];
            for (int j = 0; j < result[i + 1].length; j++) {
                result[i + 1][j] = inputArray[j];
            }
        }

        return result;
    }

    private static int[][] change(int[][] inputArray) {
        if (inputArray == null || inputArray.length == 0)
            throw new IllegalArgumentException();

        int[][] result = new int[inputArray.length][inputArray.length];

        for (int row = 0; row < inputArray.length; row++) {
            if (inputArray[row] == null)
                throw new IllegalArgumentException();
            for (int col = 0; col < inputArray.length; col++) {
                if (col >= inputArray[row].length)
                    continue;
                result[col][inputArray.length - 1 - row] = inputArray[row][col];
            }
        }

        return result;
    }

    private static boolean isEqual(String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;
        if (s1 == null || s2 == null)
            return false;
        if (s1.isEmpty() && s2.isEmpty())
            return true;
        if (s1.isEmpty() || s2.isEmpty())
            return false;

        if (s1.charAt(0) == s2.charAt(0))
            return isEqual(s1.substring(1), s2.substring(1));
        else return false;
    }
}
