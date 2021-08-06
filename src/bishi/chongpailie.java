package bishi;

import java.util.*;

public class chongpailie {
    static List<int[]> list=new ArrayList<>();
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long num=in.nextLong();
        int bei=in.nextInt();
        Set<Long> set=new HashSet<>();
        String help=String.valueOf(num);
        int size=help.length();
        boolean flags[]=new boolean[size];
        int []nums=new int[size];
        dfs(0,flags,nums);
        for (int[] arr : list) {
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(help.charAt(arr[i]));
            }
            long res=Long.parseLong(sb.toString());
            set.add(res);
        }
        int count=0;
        for (long a:set) {
            if(a%bei==0)
                count++;
        }
        if(num==0)
            count=0;
        System.out.println(count);
    }
    public static  void dfs(int position,boolean[] flags,int[]nums) {
        if(position>=nums.length) {
            list.add(nums.clone());
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(!flags[i]) {
                    nums[position]=i;
                    flags[i]=true;
                    dfs(position+1,flags,nums);
                    flags[i]=false;
                }
            }
        }
    }
}
