package bishi;

import java.util.Scanner;

/**
 * 1-n的全排列
 */
public class pailie {
    public static  void dfs(int position,boolean[] flags,int[]nums) {
        if(position>=nums.length) {
            for(int num:nums) {
                System.out.print(num+" ");
            }
            System.out.println();
        }else {
            for (int i = 0; i < nums.length; i++) {
                if(!flags[i]) {
                    nums[position]=i+1;
                    flags[i]=true;
                    dfs(position+1,flags,nums);
                    flags[i]=false;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        boolean []flags=new boolean[n];
        int []nums=new int[n];
        dfs(0,flags,nums);
    }
}
