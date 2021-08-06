package bishi;

import java.util.Scanner;

public class So2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        if(n==1)
            System.out.println(1);
        else if(n==2)
            System.out.println(4);
        else{
            int result=1+n+n*(n-1)/2;
            System.out.println(result);
        }
    }

}
