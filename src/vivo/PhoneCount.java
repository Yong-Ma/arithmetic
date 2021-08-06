package vivo;

import java.util.Scanner;

/**
 * 假设第一天量产 1 台，接下来 2 天(即第二、三天)每天量产 2 件，接下来 3 天(即第四、
 * 五、六天)每天量产 3 件 ... ... 以此类推，请编程计算出第 n 天总共可以量产的手机数量。
 */
public class PhoneCount {
    public static void main(String[] args) {
        System.out.println("输入n:");
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        getDay(n);
        System.out.println("结果："+calculate(getDay(n)));
    }

    //获得n天最后一天的产量及与其相同产量的天数有多少
    public static int[] getDay(int n) {
        int [] arr=new int[]{1,0};//存放结果
        int count=0;//存放天数，后面要与n比较
        if(n<=0)
            throw new RuntimeException("the number of day is wrong");
        for (int i=1;i<=n;i++) {
            count+=i;
            if(count>n) {
                arr[1]=i-(count-n);
                break;
            }
            arr[0]=i;
        }
        return arr;
    }
    //计算出第 n 天总共可以量产的手机数量。
    public static int calculate(int [] arr) {
        int total=0;
        for(int i=1;i<=arr[0];i++) {
            total+=Math.pow(i,2);
        }
        return total+arr[1]*(arr[0]+1);
    }
}

