package leetcode;

import java.util.Scanner;

/**
 * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
 *
 * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 *
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 *输入：S = "5F3Z-2e-9-w", K = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 *      注意，两个额外的破折号需要删掉。
 */
public class TurnKey {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String S=in.next();
        int K=in.nextInt();
        licenseKeyFormatting(S,K);
        System.out.println(licenseKeyFormatting(S,K));
    }
    public static String licenseKeyFormatting(String S, int K) {
        String[] strings=S.split("-");
        int length=0;
        StringBuilder temp=new StringBuilder();
        //去除‘-’并计算长度
        for(String str:strings) {
            length+=str.length();
            temp.append(str);
        }
        String upperCase = temp.toString().toUpperCase();//把字母转为大写
        if(upperCase.length()<=K)
            return upperCase;
        int firstNum=length%K;//第一个分组所含字符的个数

        StringBuilder result=new StringBuilder();
        if (firstNum!=0) {
            result.append(upperCase, 0, firstNum);
            result.append("-");
        }
        for(int i=firstNum;i<upperCase.length();i+=K) {
            result.append(upperCase,i,i+K);
            if(i+K<upperCase.length())
                result.append("-");
        }
        return result.toString();
    }
}
