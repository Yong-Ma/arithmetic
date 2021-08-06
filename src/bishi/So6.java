package bishi;

import java.util.Scanner;

public class So6 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        String t=in.nextLine();
        int pos=s.indexOf("*");
        String pre=s.substring(0,pos);
        String aft=s.substring(pos+1,s.length());
        int start=0,flag=0;
        while (t.indexOf(pre,start)!=-1){
            int idx1=t.indexOf(pre,start);
            int idx2=t.indexOf(aft,start+1)+aft.length()-1;
            if(idx1<idx2) {
                flag=1;
                System.out.printf(idx1+" ");
                System.out.println(idx2-idx1+1);
            }
            start++;
        }
        if(flag==0)
            System.out.println(-1+""+0);
    }
}
