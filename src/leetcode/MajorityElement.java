package leetcode;

import java.util.HashMap;
//求数组中出现次数超过数组一半的数字
public class MajorityElement {
        public int majorityElement(int[] nums) {
            int x = 0, votes = 0;
            for(int num : nums){
                if(votes == 0) x = num;
                votes += num == x ? 1 : -1;
            }
            return x;
        }
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i :nums) {
////            map.put(i,map.getOrDefault(i,0)+1);
////            map.putIfAbsent(i,0);
////            map.put(i,map.get(i)+1);
//            map.merge(i,1,Integer::sum);
//            if(map.get(i)>nums.length/2)
//                return i;
//        }
//        return Integer.MAX_VALUE;
//    }

    public static void main(String[] args) {
        int []nums={1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new MajorityElement().majorityElement(nums));
    }
}
