package other;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 *
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 *
 * 测试样例：
 * [1,3,5,2,2],5,3
 * 返回：2
 */
public class FindKth {
    public int findKth(int[] a, int n, int K) {
        // write code here
        Integer[]b=new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i]=a[i];
        }
        Collection<Integer> collection=Arrays.asList(b);
        Set<Integer> set=new HashSet<>(collection);
        Integer[] array = set.toArray(new Integer[0]);
        Arrays.sort(array);
        return array[n-K];

    }
}
