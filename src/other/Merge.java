package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/0596b6232ce74b18b60ba0367d7f2492
 * 来源：牛客网
 *
 * 用x,y表示一个整数范围区间，现在输入一组这样的范围区间(用空格隔开)，请输出这些区间的合并。
 *
 * 输入描述:
 * 一行整数，多个区间用空格隔开。区间的逗号是英文字符。
 *
 *
 * 输出描述:
 * 合并后的区间，用过空格隔开，行末无空格
 * 示例1
 * 输入
 * 1,3 2,5
 * 输出
 * 1,5
 * 示例2
 * 输入
 * 1,3 2,5 8,10 11,15
 * 输出
 * 1,5 8,10 11,15
 */
public class Merge {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        Interval[] ins = new Interval[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String[] arr = strs[i].split(",");
            ins[i] = new Interval(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }

        Arrays.sort(ins, Comparator.comparingInt(o -> o.lower));

        int cur = 0;
        for (int i = 1; i < ins.length; i++) {
            if (ins[i].lower <= ins[cur].upper) {
                ins[cur].upper = Math.max(ins[cur].upper, ins[i].upper);
            } else {
                System.out.print(ins[cur].lower + "," + ins[cur].upper + " ");
                cur = i;
            }
        }

        System.out.println(ins[cur].lower + "," + ins[cur].upper);
    }
}

class Interval {
    int lower;
    int upper;

    Interval(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }
}
