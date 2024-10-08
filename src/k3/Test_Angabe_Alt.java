package k3;

import java.util.Arrays;

public class Test_Angabe_Alt {


    //TODO: Ergänze Sie hier die geforderten Methoden.

    public static int[][] generate(int[] input){
        int iterations = input.length;
        int[][] out = new int[iterations][];
        for (int i = 0; i < iterations; i++) {
            out[i] = new int[iterations + i];
            // populate with old values
            for (int j = 0; j < input.length; j++) {
                out[i][out[i].length - j - 1] = input[j];
            }

            for (int j = 0; j < i; j++) {
                int sum = 0;
                for (int k = 0; k < out[i].length; k++) {
                    sum += out[i][k];
                }

                out[i][out[i].length - input.length - j - 1] = sum;
            }
        }
        return out;
    }

    public static void keep(int[][] input,int fromIndex){
        for (int y = 0; y < input.length; y++) {
            int[] row = new int[Math.max(input[y].length - fromIndex, 0)];
            for (int x = fromIndex; x < input[y].length ; x++) {
                row[x - fromIndex] = input[y][x];
            }
            input[y] = row;
        }
    }

    public static int digitZeroCount(int number) {
        if (number == 0)
            return 1;
        if (Math.abs(number) < 10)
            return 0;

        int next = number / 10;
        if (number % 10 == 0)
            return 1 + digitZeroCount(next);
        return digitZeroCount(next);
    }


    public static void main(String[] args) {
        //Cserich Philipp K3 Test Reimagined
        /*TODO:
         * Testcases are already implemented (not as in the K3 test)
         * This task is just a reimagined form of the original!
         */

        /*
         * The following arrays should be used (test values)
         */
        int[][] test1 = {{1, 0, 1}, {}, {5, 5, 6, 5}, {}};
        int[][] test2 = {{7, 7, 5, 7, 3}, {2, -4}, {10, 20, 30}, {-1, -2, -3, -4, -5, -6, -7}};
        int[][] test3 = {{}, {1, 2}};

        /*
         * Write a method generate which takes a one dimensional array as input and creates a new two dimensional array that performs a left shift for each column.
         * Add the sum of the elements of the previous numbers to the front of the array.
         * Perform this iteration for the exact number of columns provided in the input array
         * dimensions :
         * (2) -> ((2)(3))
         * (4) -> ((4)(5)(6)(7))
         *
         * example:
         * input : [2,1,0]
         * output : [[2,1,0][3,2,1,0][6,3,2,1,0]]
         *
         */

        System.out.println("\n TESTCASES - GENERATE \n ");

        System.out.println("Actual : " + Arrays.deepToString(generate(test1[0])) + "\nExpected : [[1,0,1],[2,1,0,1],[4,2,1,0,1]]\n");
        System.out.println("Actual : " + Arrays.deepToString(generate(new int[]{1, 1})) + "\nExpected : [[1,1],[2,1,1]]\n");
        System.out.println("Actual : " + Arrays.deepToString(generate(new int[]{3})) + "\nExpected : [[3]]\n");

        /*
         * Write a function "keep" that keeps all values after the specified index in every inner array.
         * The form of the array should not change at all
         * (input)
         * index i , array a (int) - dim 2
         *
         * example:
         * input - 2 , [[1,2,3],[],[3,4,5,7,8]]
         * output - [[3],[],[5,7,8]]
         */

        System.out.println("\n TESTCASES - KEEP \n");

        keep(test1,2);
        System.out.println("Actual : " + Arrays.deepToString(test1)+ " \nExpected : [[1],[],[6,5],[]]\n");
        keep(test2,5);
        System.out.println("Actual : " + Arrays.deepToString(test2)+ " \nExpected : [[],[],[],[-6,-7]]\n");
        keep(test3,2);
        System.out.println("Actual : " + Arrays.deepToString(test3)+ " \nExpected : [[],[]]\n");


        /*
         * Write a function "digitZeroCount" that counts how many zeros are present in the input integer.
         * (recursive solution required)
         * (input)
         * integer number
         *
         * example:
         * input - 20000
         * output - 4
         */

        System.out.println("\n TESTCASES - DIGITZEROCOUNT \n");

        System.out.println("Actual : " + digitZeroCount(10508) +"| Expected : 2\n");
        System.out.println("Actual : " + digitZeroCount(101020)+"| Expected : 3\n");
        System.out.println("Actual : " + digitZeroCount(0)+"| Expected : 1\n");
        System.out.println("Actual : " + digitZeroCount(-100)+"| Expected : 2\n");
        System.out.println("Actual : " + digitZeroCount(1)+"| Expected : 0\n");
        System.out.println("Actual : " + digitZeroCount(-11)+"| Expected : 0\n");

    }
}
