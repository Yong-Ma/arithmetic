package bishi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 分解质因子
 */
public class fenjie {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        fenjie fenjie=new fenjie();
        System.out.printf("n=");
        //fenjie.resolve(n,2);
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int k=2;k<=n;k++) {
            if(n%k==0) {
                arrayList.add(k);
                n=n/k;
                k=1;
            }
        }
        if(arrayList.size()==1)
            System.out.printf("1");
        else {
            for (int i=0;i<arrayList.size()-1;i++) {
                System.out.printf(arrayList.get(i)+"*");
            }
            System.out.printf(arrayList.get(arrayList.size()-1)+"");
        }
    }
    //递归
//    public void resolve(int n,int k) {
//        while(k<=n) {
//            if(k==n) {
//                System.out.println(n);
//                break;
//            }else if(k<n&&n%k==0) {
//                System.out.printf(k+"*");
//                n=n/k;
//                resolve(n,k);
//                break;
//            }else if(k<n&&n%k!=0) {
//                resolve(n, ++k);
//                break;
//            }
//        }
//    }
}
