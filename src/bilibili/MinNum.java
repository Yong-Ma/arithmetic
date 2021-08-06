package bilibili;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数数组，将它们连接起来排成一个数，输出能排出的所有数字中最小的一个
 * 一行输入， 数组中的数字用逗号隔开。 例如：
 * 输入为：
 * 32,231
 * 则表示数组{32, 231}
 */
public class MinNum {
    public String minNumber(int[] nums) {
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        strList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
        }
        return sb.toString();
    }

}
