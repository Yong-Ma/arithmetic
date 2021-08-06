package bishi;

import java.util.Scanner;

//计算四则运算式
public class Cal {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.next();
        if(str.contains("+")) {
            int idx=str.indexOf("+");
            String num1=str.substring(0,idx);
            String num2=str.substring(idx+1);
            int first=Integer.parseInt(num1);
            int second=Integer.parseInt(num2);
            System.out.println(first+second);
        }else if(str.contains("-")) {
            int idx=str.indexOf("-");
            String num1=str.substring(0,idx);
            String num2=str.substring(idx+1);
            int first=Integer.parseInt(num1);
            int second=Integer.parseInt(num2);
            System.out.println(first-second);
        }else if(str.contains("*")) {
            int idx=str.indexOf("*");
            String num1=str.substring(0,idx);
            String num2=str.substring(idx+1);
            int first=Integer.parseInt(num1);
            int second=Integer.parseInt(num2);
            System.out.println(first*second);
        }else{
             int idx=str.indexOf("/");
             String num1=str.substring(0,idx);
             String num2=str.substring(idx+1);
             int first=Integer.parseInt(num1);
             int second=Integer.parseInt(num2);
             int res=first/second;
             System.out.println(res);
        }
    }
}
