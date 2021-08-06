package leetcode;

import java.util.Scanner;

public class Fib {
    public int fib(int n) {
        int constant = 1000000007;
        int first = 0;
        int second = 1;
        while (n-- > 0) {
            int temp = first + second;
            first = second % constant;
            second = temp % constant;
        }
        return first;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        Fib fib = new Fib();
        fib.fib(n);
        System.out.println(fib.fib(n));
    }
}
