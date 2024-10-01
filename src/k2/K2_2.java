package k2;

public class K2_2 {

    public static void main(String[] args) {
        short result = 0;
        String test = "Blaukraut";

        result = (short) getIntegerRoot(25);
        System.out.println(result);
        System.out.println(getIntegerRoot(144));
        System.out.println(getIntegerRoot(13));
        System.out.println(getIntegerRoot(1));

        System.out.println(getThird("toss", "a", "coin"));
        System.out.println(getThird("Blaukraut", "bleibt", test));
        System.out.println(getThird("badger", "badger", "badger"));

        System.out.println(replaceA("TU Wien"));
        System.out.println(replaceA("Hubba bubba!"));
        System.out.println(replaceA("aaaa"));

        printBars(2);
        printBars(19);
        printBars(20);
        printBars(21);
    }

    public static int getIntegerRoot(int k) {
        for (int i = 1; (i * i) <= k; i++) {
             if ((i * i) == k)
                 return i;
        }
        return -1;
    }

    public static String getThird(String a, String b, String c) {
        boolean firstEqualsSecond = a.equals(b);
        boolean firstEqualsThird = a.equals(c);
        boolean secondEqualsThird = b.equals(c);

        if (firstEqualsSecond && firstEqualsThird)
            return "alle gleich";
        if (firstEqualsSecond)
            return c;
        if (firstEqualsThird)
            return b;
        if (secondEqualsThird)
            return a;

        return "alle unterschiedlich";
    }

    public static String replaceA(String s) {
        int count = 1;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                result += count;
                count++;
            } else
                result += s.charAt(i);
        }

        return result;
    }

    public static void printBars(int i) {
        String line1 = "";
        String line2 = "";
        for (int num = 1; num <= i; num++) {
            if (num % 3 == 0) {
                line2 += num;
                line2 += num % 2 == 0 ? '-' : '+';
            }
            else {
                line1 += num;
                line1 += num % 2 == 0 ? '+' : '-';
            }
        }
        System.out.println(line1);
        if (line2.length() != 0)
            System.out.println(line2);
    }
}
