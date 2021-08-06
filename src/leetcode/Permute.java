package leetcode;

import java.util.*;
/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int length=nums.length;
        boolean []flag=new boolean[length];
        help(0,length,nums,flag,new ArrayList<>());
        return res;
    }
    public void help(int position,int length,int []nums,boolean []flag,List<Integer> list) {
        if(position>=length) {
            res.add(new ArrayList<>(list));
        }else {
            for (int i = 0; i < length; i++) {
                if(!flag[i]) {
                    flag[i]=true;
                    list.add(nums[i]);
                    help(position+1,length,nums,flag,list);
                    list.remove(list.size()-1);
                    flag[i]=false;
                }
            }
        }
    }

}
