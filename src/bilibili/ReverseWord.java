package bilibili;

import java.util.Arrays;

/**
 * 原地翻转句子中单词的顺序， 但单词内字符的顺序不变。 要求： 空间复杂度 O(1)， 时间复杂度O(n)
 * 输入例子 1:
 * I am a student.
 * 输出例子 1:
 * student. a am I
 */
public class ReverseWord {
    public String[] turn(String s) {
        if(s==null||s.length()==0)
            return null;
        String [] strings=s.split(" ");
        int mid=(strings.length)/2;
        for (int i = 0; i <= mid - 1; i++) {
            String temp=strings[i];
            strings[i]=strings[strings.length-1-i];
            strings[strings.length-1-i]=temp;
        }
        return strings;
    }

    public static void main(String[] args) {
        String s="a b c d";
        System.out.println(Arrays.toString(new ReverseWord().turn(s)));
    }
}
