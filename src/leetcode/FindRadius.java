package leetcode;

import java.util.Arrays;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 *
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 *
 * 说明:
 *
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 示例 1:
 *
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 *
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 */
public class FindRadius {
    public int findRadius(int[] houses, int[] heaters) {
        // 1. 排序
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int res = 0;
        int i = 0;
        // 2. 双指针计算最大半径
        // 下面的代码最难懂的地方是 Math.abs(heaters[i] - house) >= Math.abs(heaters[i + 1] - house)
        // 我们举一个例子来说明这行代码的意思：
        // houses：1，2，3，4
        // heaters：1，4
        // 对于 house 1，heater 1 比 heater 4 更接近 house1，所以不将 i 移动到 i + 1
        // 对于 house 2，heater 1 比 heater 4 更接近 house2，所以不将 i 移动到 i + 1
        // 对于 house 3，heater 4 比 heater 1 更接近 house3，所以将 i 移动到 i + 1
        // 对于 house 4，依次类推
        for (int house : houses) {
            while (i < heaters.length - 1 &&
                    Math.abs(heaters[i] - house) >= Math.abs(heaters[i + 1] - house)) {
                i++;
            }
            // 更新最大半径
            res = Math.max(res, Math.abs(heaters[i] - house));
        }

        return res;
    }

    public static void main(String[] args) {
        int [] house={1,2,3,4,5,6};
        int [] heaters={3,5};
        FindRadius findRadius = new FindRadius();
        System.out.println("结果是："+findRadius.findRadius(house,heaters));

    }
}
