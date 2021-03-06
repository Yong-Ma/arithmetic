package leetcode;

import java.util.Scanner;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)
            return 0;
        int row=grid.length,col=grid[0].length;
        int [][]dp=new int [row][col];
        dp[0][0]=grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0]=grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i]=grid[0][i];
        }
        for (int i = 1; i <row ; i++) {
            for (int j = 1; j <col ; j++) {
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int r=in.nextInt();
        int c=in.nextInt();
        in.nextLine();
        int [][] arr=new int [r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j]=in.nextInt();
            }
        }
        MinPathSum minPathSum=new MinPathSum();
        System.out.println(minPathSum.minPathSum(arr));
    }


}
