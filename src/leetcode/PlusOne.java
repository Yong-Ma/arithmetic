package leetcode;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne {
//    public int[] plusOne(int[] digits) {
//        if(digits.length==2&&digits[0]==0&&digits[1]==0)
//            return new int[]{1};
//        BigInteger num=new BigInteger("0");
//        for (int a : digits) {
//            num=num.multiply(BigInteger.valueOf(10));
//            num=num.add(BigInteger.valueOf(a));
//        }
//        num=num.add(BigInteger.valueOf(1));
//        String help=String.valueOf(num);
//        int len=help.length();
//        int []res=new int[len];
//        for (int i = 0; i < len; i++) {
//            res[i]=help.charAt(i)-48;
//        }
//        return res;
//    }
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits={9,9,9};
        PlusOne plusOne = new PlusOne();
        plusOne.plusOne(digits);
    }
}
