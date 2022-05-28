package Rekursion;

public class RecTest {
    public static void main(String[] args) {

        System.out.println(fib(5));

    }

    public static int rek1(int n) {
        if (n < 10) {
            return n;
        } else {
            return (n % 10) + rek1(n / 10);
        }
    }

    public static void rek2(int n) {
        System.out.println(n % 100);
        int m = n / 100;
        if (m > 0) {
            rek2(m);
        }
    }

    public static int fib(int i) {
        if (i <= 1)
            return i;
        else
            return fib(i - 1) + fib(i - 2);
    }

}
