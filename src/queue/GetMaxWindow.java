package queue;
import java.util.ArrayDeque;
import java.util.LinkedList;
/**
 * 【题目】
 * 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边，窗口每次向右边
 * 滑一个位置。
 * 例如，数组为[4,3,5,4,3,3,6,7]，窗口大小为 3 时：
 * [4 3 5] 4 3 3 6 7 窗口中最大值为 5
 * 4 [3 5 4] 3 3 6 7 窗口中最大值为 5
 * 4 3 [5 4 3] 3 6 7 窗口中最大值为 5
 * 4 3 5 [4 3 3] 6 7 窗口中最大值为 4
 * 4 3 5 4 [3 3 6] 7 窗口中最大值为 6
 * 4 3 5 4 3 [3 6 7] 窗口中最大值为 7
 * 如果数组长度为 n，窗口大小为 w，则一共产生 n-w+1 个窗口的最大值。
 * 请实现一个函数。
 *  输入：整型数组 arr，窗口大小为 w。
 *  输出：一个长度为 n-w+1 的数组 res，res[i]表示每一种窗口状态下的最大值。
 * 以本题为例，结果应该返回{5,5,5,4,6,7}。
 */


/**
 * 【解答】
 * 假设数组长度为 N，窗口大小为 w，如果做出时间复杂度为 O(N×w)的解法是不能让面试
 * 官满意的，本题要求面试者想出时间复杂度为 O(N)的实现。
 * 本题的关键在于利用双端队列来实现窗口最大值的更新。首先生成双端队列 qmax，qmax
 * 中存放数组 arr 中的下标
 * 假设遍历到 arr[i]，qmax 的放入规则为：
 * 1．如果 qmax 为空，直接把下标 i 放进 qmax，放入过程结束。
 * 2．如果 qmax 不为空，取出当前 qmax 队尾存放的下标，假设为 j。
 * 1）如果 arr[j]>arr[i]，直接把下标 i 放进 qmax 的队尾，放入过程结束。
 * 2）如果 arr[j]<=arr[i]，把 j 从 qmax 中弹出，重复 qmax 的放入规则。
 * 也就是说，如果 qmax 是空的，就直接放入当前的位置。如果 qmax 不是空的，qmax 队尾
 * 的位置所代表的值如果不比当前的值大，将一直弹出队尾的位置，直到 qmax 队尾的位置所代
 * 表的值比当前的值大，当前的位置才放入 qmax 的队尾
 */
public class GetMaxWindow {
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();//双端
        int[] res = new int[arr.length - w + 1];//存放结果
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
