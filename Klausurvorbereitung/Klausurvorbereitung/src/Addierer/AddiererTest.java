package Addierer;

public class AddiererTest {

    private static int parseAndAdd(String s1, String s2) {
        try {
            int a = Integer.decode(s1);
            int b = Integer.decode(s2);
            return a + b;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static int parseAndAddOne(String s1, String s2) {
        try {
            int a = Integer.decode(s1);
            int b = Integer.decode(s2);
            return a + b + 1;
        } catch (NumberFormatException e) {
            return 0 + 1;
        }
    }

    public static void main(String[] args) {

        IAddierer c = (s1, s2) -> parseAndAdd(s1, s2);
        IAddierer d = (s1, s2) -> parseAndAddOne(s1, s2);

        System.out.println(c.rechnen("12", "14"));
        System.out.println(c.rechnen("1ab", "14"));

        System.out.println(d.rechnen("12", "14"));
        System.out.println(d.rechnen("1ab", "14"));
    }
}
