package bilibili;

/**
 * 有为 N 件物品，它们的重量 w 分别是 w1,w2,...,wn，它们的价值 v 分别是 v1,v2,...,vn，每
 * 件物品数量有且仅有一个，现在给你个承重为 M 的背包，求背包里装入的物品具有的价值
 * 最大总和？
 * 输入描述:
 * 物品数量 N=5 件
 * 重量 w 分别是 2 2 6 5 4
 * 价值 v 分别是 6 3 5 4 6
 * 背包承重为 M=10
 */
public class Bag {
    public static int ZeroOnePack2(int M,int N,int[] weight,int[] value){
        //动态规划
        int[] dp = new int[M+1];
        for(int i=1;i<N+1;i++){
            //逆序实现
            for(int j=M;j>=weight[i-1];j--){
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
        return dp[M];
    }

    public static void main(String[] args) {
        int []w={2, 2 ,6 ,5 ,4};
        int [] v={6, 3, 5, 4 ,6};
        System.out.println(ZeroOnePack2(10,5,w,v));
    }
}
