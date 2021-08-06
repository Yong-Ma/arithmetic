package leetcode;

import java.util.Scanner;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 */
public class ReverseLeftWords {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int n=in.nextInt();
        System.out.println("结果是："+reverseLeftWords(s,n));
    }
    public static String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(s.substring(n,s.length()));
        stringBuilder.append(s.substring(0,n));
        return stringBuilder.toString();
    }
}
