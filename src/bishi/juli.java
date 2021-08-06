package bishi;

import java.util.*;

public class juli {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        char []arr=new char[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=in.next().toCharArray()[0];
        }
        char first=in.next().toCharArray()[0];
        char second=in.next().toCharArray()[0];
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        if(first==second) {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]==first&&list1.size()==0)
                    list1.add(i);
                else if(arr[i]==second)
                    list2.add(i);
            }
        }else {
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]==first)
                    list1.add(i);
                else if(arr[i]==second)
                    list2.add(i);
            }
        }
        int res=Integer.MAX_VALUE;
        for (int a : list1) {
            for (int b : list2) {
                res=Math.min(res,Math.abs(a-b));
            }
        }
        System.out.println(res);
    }
}
