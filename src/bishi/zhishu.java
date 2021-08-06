package bishi;

import java.util.Scanner;

//1-M的求质数
public class zhishu {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int M=in.nextInt();
        for (int i = 2; i <=M ; i++) {
            if(cal(i))
                System.out.println(i);
        }
    }
    public static boolean cal(int n) {
        for (int i = 2; i <=n/2 ; i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
