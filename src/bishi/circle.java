package bishi;
//从1-3报数
import  java.util.*;
public class circle {
    public static void help(boolean[] people){
        int i = 0,j=0,n=people.length,m=n;
        while(n>0){
            i=i%m;
            if(people[i]){
                j++;
                if(j==3){
                    people[i]=false;
                    System.out.println(i+1);
                    n--;
                    j=0;
                }
            }
            i++;
        }
    }

     public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        boolean people[]=new boolean[n];
        for(int i=0;i<n;i++)
            people[i]=true;
        help(people);
    }
}

