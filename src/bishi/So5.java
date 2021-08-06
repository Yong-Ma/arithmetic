package bishi;

import java.util.Scanner;

public class So5 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String t=in.nextLine();
        int pos=in.nextInt();
        int length=s.length();
        if(pos<0||pos>=length)
            System.out.println("error");
        else {
            StringBuilder stringBuilder=new StringBuilder();
            if(pos==0) {
                stringBuilder.append(t);
                stringBuilder.append(s);
            }else {
                stringBuilder.append(s.substring(0,pos));
                stringBuilder.append(t);
                stringBuilder.append(s.substring(pos,s.length()));
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
