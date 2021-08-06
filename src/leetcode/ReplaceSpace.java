package leetcode;

import java.util.Scanner;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace {
    public static String replaceSpace(String s) {
//        if (s==null)
//            return null;
//        return s.replaceAll(" ","%20");
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        replaceSpace(s);
        System.out.println("结果是："+replaceSpace(s));
    }
}
