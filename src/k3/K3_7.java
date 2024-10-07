package k3;

import java.util.Arrays;

public class K3_7 {
    public static void main(String[] args) {
        int[][] test1 = {{5, 7, 5, 7}, {5}, {0, 1, 1, 0}};
        int[][] test2 = {{5, 7, 9}, {5}, {8, 5}, {2}, {3}};
        int[][] test3 = {{1, 2}, {1, 2, 3}, {}};
        String seq = "1(234)67";

        int[][] result1 = addTriangle(test1);
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = addTriangle(test2);
        System.out.println(Arrays.deepToString(result2));

        reverseBetween(test1, 2, 1);
        System.out.println(Arrays.deepToString(test1));
        reverseBetween(test2, 1, 4);
        System.out.println(Arrays.deepToString(test2));
        reverseBetween(test3, 2, 2);
        System.out.println(Arrays.deepToString(test3));
        reverseBetween(test3, 0, 2);
        System.out.println(Arrays.deepToString(test3));

        System.out.println(clean(seq));
        System.out.println(clean("123(45))"));
        System.out.println(clean("x)"));
        System.out.println(clean(")x("));
    }

    static int[][] addTriangle(int[][] input) {
        int[][] out = new int[input.length + input[0].length][];
        for (int i = 0; i < input[0].length; i++) {
            int[] row = new int[i + 1];
            for (int j = 0; j < row.length; j++) {
                row[j] = i + 1;
            }
            out[i] = row;
        }
        for (int i = input[0].length; i < out.length; i++) {
            out[i] = input[i - input[0].length];
        }
        return out;
    }

    static void reverseBetween(int[][] input, int ind1, int ind2) {
        int[][] reversed = new int[Math.abs(ind1 - ind2) + 1][];
        int index = 0;
        for (int i = Math.max(ind1, ind2); i >= Math.min(ind1, ind2); i--) {
            reversed[index] = input[i];
            index++;
        }

        for (int i = 0; i < reversed.length; i++) {
            input[Math.min(ind1, ind2) + i] = reversed[i];
        }
    }

    static String clean(String seq) {
        if (seq.length() <= 2)
            return "";
        if (seq.charAt(0) == '(' && seq.charAt(seq.length() - 1) == ')')
            return seq.substring(1, seq.length() - 1);

        if (seq.charAt(0) != '(')
            seq = seq.substring(1);
        if (seq.charAt(seq.length() - 1) != ')')
            seq = seq.substring(0, seq.length() - 1);
        return clean(seq);
    }
}
