package leetcode;

import java.util.Scanner;

public class Reverse {
    public int reverse(int x) {
        if(x==0)
            return 0;
        long abs=Math.abs(x);
        long sum=0;
        int weishu=0;
        while(abs>0) {
            long num=abs%10;
            if(sum*10+num>Integer.MAX_VALUE)
                return 0;
            sum=sum*10+num;
            weishu++;
            abs/=10;
        }
        return (int) (x<0?-sum:sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x=scanner.nextInt();
        new Reverse().reverse(x);
        System.out.println("结果是："+new Reverse().reverse(x));
    }
}
