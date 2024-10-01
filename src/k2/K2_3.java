package k2;

public class K2_3 {
    public static void main(String[] args) {
        short result = (short) sumUp(4, 9, 320_300);
        String test = "all: hallo hall";

        System.out.println("--- sumUp ---");
        System.out.println(sumUp(2, 5, 11));
        System.out.println(sumUp(8, 8, 40));
        System.out.println(sumUp(5, 1, 2000));

        System.out.println("--- addMark ---");
        System.out.println(addMark(test, "allo", 6));
        System.out.println(addMark(test, "all", 3));
        System.out.println(addMark(test, "hall", 3));
        System.out.println(addMark(test, "@all", 3));

        System.out.println("--- digitsToDistance ---");
        System.out.println(digitsToDistance("12oder34"));
        System.out.println(digitsToDistance("Ich bin 1 Berliner!11"));
        System.out.println(digitsToDistance("Heute ist der 4.März 2022"));
        System.out.println(digitsToDistance("Vier*mal*vier_=_0"));

        System.out.println("--- printPattern ---");
        printPattern(6, 2);
        System.out.println();
        printPattern(7, 3);
        System.out.println();
        printPattern(1, 1);
        System.out.println();
        printPattern(8, 5);
    }

    static int sumUp(int d, int s, int t) {
        int count = 0;
        while (s < t) {
            int remainder = s % d;
            if (remainder == 0) {
                count++;
                s++;
            } else
                s += remainder;
        }
        return count;
    }

    static String addMark(String a, String pattern, int pos) {
        if (a.substring(pos, pos + pattern.length()).equals(pattern))
            return a.substring(pos);
        if (a.substring(0, pattern.length()).equals(pattern))
            return "--" + a;
        if (a.substring(a.length() - pattern.length()).equals(pattern))
            return a + "--";
        return "--";
    }

    static String digitsToDistance(String text) {
        int lastNumIndex = -1;
        String out = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isDigit(c)) {
                if (lastNumIndex == -1)
                    out += i;
                else
                    out += (i - lastNumIndex - 1);
                lastNumIndex = i;
            } else
                out += c;
        }
        return out;
    }

    static void printPattern(int lineLength, int patternLength) {
        for (int line = 0; (line * patternLength + patternLength) <= lineLength; line++) {
            int offset = line * patternLength;
            for (int i = 0; i < offset; i++) {
                System.out.print("x");
            }
            for (int i = 0; i < patternLength; i++) {
                System.out.print("?");
            }
            for (int i = offset + patternLength; i < lineLength ; i++) {
                System.out.print("y");
            }
            System.out.println();
        }
    }
}
