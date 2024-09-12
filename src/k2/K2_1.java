package k2;

// Angabe: https://vowi.fsinf.at/images/e/e5/TU_Wien-Einf%C3%BChrung_in_die_Programmierung_1_VU_%28Podlipnig%29_-_Einstufungstest_2018.pdf

public class K2_1 {
    public static void main(String[] args) {
        short result = (short) myMult(3,7);
        String test = "Teststring_Einstufungstest";

        System.out.println(result);

        System.out.println(findMaxChar(test));
        System.out.println(findMaxChar("abcdefg"));
        System.out.println(findMaxChar("4321"));

        System.out.println(replaceNthChar(test, 1, '0'));
        System.out.println(replaceNthChar(test, 3, '#'));
        System.out.println(replaceNthChar(test, 10, '-'));
        System.out.println(replaceNthChar(test, 30, 'X'));
        System.out.println(replaceNthChar("A", 1, '#'));

        printPattern(3, '*');
        printPattern(5, '+');
    }

    public static int myMult(int x, int y) {
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += y;
        }
        return sum;
    }

    public static char findMaxChar(String text) {
        if (text == null || text.isEmpty())
            throw new IllegalArgumentException();

        char highest = text.charAt(0);
        for (int i = 1; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c > highest)
                highest = c;
        }
        return highest;
    }

    public static String replaceNthChar(String text, int n, char replaceChar) {
        if (text == null || text.length() == 0 || n < 0)
            throw new IllegalArgumentException();

        String s = "" + text.charAt(0);
        for (int i = 1; i < text.length(); i++) {
            s += (i % n == 0) ? replaceChar : text.charAt(i);
        }

        return s;
    }

    public static void printPattern(int n, char character) {
        if (n < 0)
            throw new IllegalArgumentException();

        for (int i = 0; i < n; i++) {
            //spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            //characters
            for (int k = 0; k < n + i; k++) {
                System.out.print(character);
            }

            System.out.println();
        }
    }
}
