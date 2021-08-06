package leetcode;

import java.util.Scanner;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 */
public class HammingWeight {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        System.out.println(hammingWeight(a));
    }
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        String binaryInt=Integer.toBinaryString(n);
        char[] chars=binaryInt.toCharArray();
        int count=0;
        for(char c:chars) {
            if(c=='1')
                count++;
        }
        return count;
    }
}
