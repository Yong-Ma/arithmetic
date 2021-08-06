package leetcode;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {
        if(k==0)
            return 1;
        int [][]nums=new int [m][n];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j]=getnum(i,j);
            }
        }
        return guangdu(nums,k,0,0);
    }
    public int guangdu(int[][] nums, int k,int i,int j ) {
        int sum=0;
        if(nums[i][j]<=k) {
            sum++;
            nums[i][j]=k+1;
            if(i-1>=0)
                sum+=guangdu(nums,k,i-1,j);
            if(i+1<nums.length)
                sum+=guangdu(nums,k,i+1,j);
            if(j-1>=0)
                sum+=guangdu(nums,k,i,j-1);
            if(j+1<nums[0].length)
                sum+=guangdu(nums,k,i,j+1);
        }
        return sum;
    }
    public int getnum(int i,int j) {
        int num1=0,num2=0;
        while (i>0) {
            num1+=i%10;
            i/=10;
        }
        while (j>0) {
            num2+=j%10;
            j/=10;
        }
        return num1+num2;
    }

    public static void main(String[] args) {
        int m=2,n=3,k=1;
        System.out.println(new MovingCount().movingCount(m,n,k));
    }
}
