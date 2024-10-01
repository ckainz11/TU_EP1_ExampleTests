package k2;

public class K2_1 {

    public static void main(String[] args) {
        short result = 0;
        String test = "Teststring_Einstufungstest";

        result = (short) countDivisors(299, 305);

        System.out.println("----- countDivisors -----");
        System.out.println(countDivisors(1, 28));
        System.out.println(countDivisors(101, 2001));
        System.out.println(countDivisors(8, 8));

        System.out.println("----- findDoubles -----");

        System.out.println(findDoubles(test));
        System.out.println(findDoubles("Haarspangenaal"));
        System.out.println(findDoubles("The Black Beast of Aaaaargh!"));
        System.out.println(findDoubles("Schokoladenkuchen"));

        System.out.println("----- reverseInsert -----");
        System.out.println(reverseInsert(test, '.'));
        System.out.println(reverseInsert("qwerty", '-'));
        System.out.println(reverseInsert("Pinkie Pie", '!'));

        System.out.println("----- printPattern -----");
        printPattern(4, '!');
        printPattern(5, '*');
    }

    private static int countDivisors(int x, int y) {
        int count = 0;
        for (int i = x; i <= y; i++) {
            if (i % 4 == 0 && i % 6 != 0)
                count++;
        }
        return count;
    }

    private static int findDoubles(String text) {
        int count = 0;
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == 'a' && text.charAt(i + 1) == 'a')
                count++;
        }
        return count;
    }

    private static String reverseInsert(String text, char character) {
        String result = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            result += text.charAt(i);
            if (i != 0)
                result += character;
        }
        return result;
    }

    public static void printPattern(int n, char character) {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                for (int j = 0; j < 2 * n; j++) { System.out.print(character); }
            else
                for (int j = 0; j < n; j++) { System.out.print(character + "."); }
            System.out.println(i);
        }
    }
}
