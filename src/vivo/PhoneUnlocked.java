package vivo;

import java.util.Scanner;

/**
 * 现有一个 3x3 规格的 Android 智能手机锁屏程序和两个正整数 m 和 n ，请计算出使用最少m 个键和最多 n个键可以解锁该屏幕的所有有效模式总数。
 *
 * 其中有效模式是指：
 *
 * 1、每个模式必须连接至少m个键和最多n个键；
 *
 * 2、所有的键都必须是不同的；
 *
 * 3、如果在模式中连接两个连续键的行通过任何其他键，则其他键必须在模式中选择，不允许跳过非选择键（如图）；
 *
 * 4、顺序相关，单键有效（这里可能跟部分手机不同）。
 *
 * 输入：m,n
 *
 * 代表允许解锁的最少m个键和最多n个键
 * 输出：
 *
 * 满足m和n个键数的所有有效模式的总数
 */
public class PhoneUnlocked {
    public static void main(String[] args) {
        System.out.println("请输入m,n");
        Scanner in=new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();
        System.out.println(solution(m,n));
    }
    private static int f[][]=new int[10][10];//用来存储8组跨越情况
    private static boolean select[]=new boolean[10];

    public static int solution (int m, int n){
        // TODO Auto-generated method stub

        //横着的三个
        f[1][3]=f[3][1]=2;//一三连线必须确保2已经连入
        f[4][6]=f[6][4]=5;
        f[7][9]=f[9][7]=8;
        //竖着的三个
        f[1][7]=f[7][1]=4;
        f[2][8]=f[8][2]=5;
        f[3][9]=f[9][3]=6;
        //斜叉
        f[3][7]=f[7][3]=5;
        f[1][9]=f[9][1]=5;

        select[0]=true;  //用于之后判断是否连入，二位数组 int默认值为0，都会来select[0]中进行匹配


        if(n<0||n-m<0) {
            return 0;
        }
        //  1 3 7 9 类似情况合并   2 4 6 8 类似情况合并   5又是一种情况
        int total=4*cal(m,n,1,1)+4*cal(m,n,2,1)+cal(m,n,5,1);
        return total;

    }
    public static int cal(int from,int to,int start,int len) {
        int count=0;    //用于计数，符合要求的情况
        if(len>to)      //递归退出条件
            return 0;
        if(len>=from)    //符合连接点数最少的要求，算一种有效模式
            count++;
        select[start]=true;
        for(int i=1;i<10;i++) {
            //  当前i尚未连入，且 从start到i没有跨越为连入点，
            if(!select[i]&&select[f[start][i]]) {
                count+=cal(from,to,i,len+1);
            }
        }
        select[start]=false;
        return count;
    }
}

