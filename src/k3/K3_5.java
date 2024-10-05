package k3;

import java.util.Arrays;

public class K3_5 {
    public static void main(String[] args) {
        int[][] test1 = {{0, 2, 4}, {2, 0, 0}, {0, 0, 1}};
        int[][] test2 = {{1, 2, 3}, {1, 2, 3, 4, 5}, {1, 2, 3}, {1, 2, 3, 4, 5}};
        int[][] test3 = {{2}, {0, 7}, {6, 7, 8}, {6, 0}, {0, 0}};
        String seq1 = "ABA";

        int[][] result1 = removeLeadingZeros(test1);
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = removeLeadingZeros(test3);
        System.out.println(Arrays.deepToString(result2));

        mask(test2,new int[]{1,2,3},new int[]{0,1,4});
        System.out.println(Arrays.deepToString(test2));
        mask(test3,new int[]{0,2,4},new int[]{0,1});
        System.out.println(Arrays.deepToString(test3));
        mask(test1,new int[]{},new int[]{0,1});
        System.out.println(Arrays.deepToString(test1));

        System.out.println(replicateCharacters(seq1, "010"));
        System.out.println(replicateCharacters("SAMBA", "10001"));

    }

    static int[][] removeLeadingZeros(int[][] inputArray) {
        int[][] out = new int[inputArray.length][];

        for (int y = 0; y < inputArray.length; y++) {
            int newSize = inputArray[y].length;
            for (int x = 0; x < inputArray[y].length; x++) {
                if (inputArray[y][x] == 0)
                    newSize--;
                else break;
            }
            out[y] = new int[newSize];
            int index = 0;
            for (int x = 0; x < inputArray[y].length; x++) {
                if (inputArray[y][x] != 0) {
                    out[y][index] = inputArray[y][x];
                    index++;
                }
            }
        }
        return out;
    }

    static void mask(int[][] inputArray, int[] rows, int[] cols) {
        for (int y = 0; y < inputArray.length; y++) {
            for (int x = 0; x < inputArray[y].length; x++) {
                boolean isInCols = false;
                boolean isInRows = false;
                for (int row : rows) {
                    if (row == y) {
                        isInRows = true;
                        break;
                    }
                }
                for (int col : cols) {
                    if (col == x) {
                        isInCols = true;
                        break;
                    }
                }

                if (isInRows && isInCols)
                    inputArray[y][x] = 0;
            }
        }
    }

    static String replicateCharacters(String sequence, String repSequence) {
        if (sequence.isEmpty() || repSequence.isEmpty())
            return "";

        char first = sequence.charAt(0);
        if (repSequence.charAt(0) == '1')
            return "" + first + first + replicateCharacters(sequence.substring(1), repSequence.substring(1));
        else return first + replicateCharacters(sequence.substring(1), repSequence.substring(1));
    }
}
