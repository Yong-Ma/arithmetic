package leetcode;

import java.util.Arrays;

public class specialArray {
    public int specialArray(int[] nums) {
        if(nums==null||nums.length==0)
            return -1;
        int x=nums.length;
        for (int i = x; i > 0; i--) {
            int n=0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j]>=i)
                    n++;
            }
            if(n==i)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        specialArray specialArray = new specialArray();
        int nums[]={0,4,3,0,4};
        specialArray.specialArray(nums);
    }
}
