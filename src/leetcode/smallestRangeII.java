package leetcode;

import java.util.Arrays;

/**
 * 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
 *
 * 在此过程之后，我们得到一些数组 B。
 *
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 * 输入：A = [1,3,6], K = 3
 * 输出：3
 * 解释：B = [4,6,3]
 */
public class smallestRangeII {
    public static void main(String[] args) {

    }
    public int smallestRangeII(int[] A, int K) {
        for (int i = 0; i < A.length; i++) {
            A[i] += K;
        }

        Arrays.sort(A);

        int min = A[0];
        int max = A[A.length-1];
        int res = max - min;

        int secondMax = max - 2*K;
        for (int i = A.length-1; i >0 ; i--) {
            A[i] -= 2*K;

            max = Math.max(A[i-1], secondMax);
            min = Math.min(min,A[i]);
            res = Math.min(res, max-min);
        }
        return res;

    }
}
