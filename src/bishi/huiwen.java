package bishi;

import java.util.Scanner;

public class huiwen {
    static int flag=0;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String text=in.next();
        digu(text,0,text.length()-1);
        if(flag==1)
            System.out.println(text+"是回文串！");
        else
            System.out.println(text+"不是回文串！");
    }
    public static void digu(String text,int a,int b) {
        if(a>=b) {
            flag=1;
            return ;
        }
        if(text.charAt(a)==text.charAt(b))
            digu(text,a+1,b-1);
    }

}
