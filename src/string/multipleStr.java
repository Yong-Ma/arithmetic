package string;

import java.util.Scanner;

/**
 * TODO
 *
 * @author mazhiyong
 * @date 2021/6/26 16:06
 */
public class multipleStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s = scanner.next();
        int len = s.length();
        getMultipleStr(s, len);
    }
    public static void getMultipleStr(String s, int len) {
        int [] arr = new int[128];
        for (int i = 0; i < len; i++) {
            int num =  s.charAt(i);
            if (arr[num]>0) {
                System.out.println(s.charAt(i));
                break;
            }
            arr[num]++;
        }
    }

}
