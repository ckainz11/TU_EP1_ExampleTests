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
        for (int i = 0; i < k; i++) {
            if (i * i == k)
                return i;
        }
        return -1;
    }

    public static String getThird(String a, String b, String c) {
        if (a.equals(b) && b.equals(c))
            return "alle gleich";
        if (a.equals(b))
            return c;
        if (b.equals(c))
            return a;
        if (a.equals(c))
            return b;

        return "alle unterschiedlich";
    }

    public static String replaceA(String s) {
        String out = "";
        int aCount = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'a')
                out += s.charAt(i);
            else {
                out += aCount;
                aCount++;
            }
        }
        return out;
    }

    public static void printBars(int i) {
        String line1 = "";
        String line2 = "";
        char line1Sep = '+';
        char line2Sep = '-';
        for (int num = 1; num <= i; num++) {
            if (num % 3 == 0) {
                line2Sep = line2Sep == '+' ? '-' : '+';
                line2 += num;
                line2 += line2Sep;
            } else {
                line1Sep = line1Sep == '-' ? '+' : '-';
                line1 += num;
                line1 += line1Sep;
            }
        }

        System.out.println(line1);
        if (line2.length() != 0)
            System.out.println(line2);
    }
}
