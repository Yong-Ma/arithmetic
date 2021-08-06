package bishi;

import java.util.Arrays;
import java.util.Scanner;

public class So3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.next();
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        StringBuilder stringBuilder=new StringBuilder();
        for (char c : chars) {
            stringBuilder.append(c);
        }
        str=stringBuilder.toString();
        boolean[]flags=new boolean[str.length()];
        dfs(0,flags,chars,str);
    }
    public static  void dfs(int position,boolean[] flags,char[]chars,String str) {
        if(position>=chars.length) {
            for(char c:chars) {
                System.out.print(c+" ");
            }
            System.out.println();
        }else {
            for (int i = 0; i < chars.length; i++) {
                if(!flags[i]) {
                    chars[position]=str.charAt(i);
                    flags[i]=true;
                    dfs(position+1,flags,chars,str);
                    flags[i]=false;
                }
            }
        }
    }
}
