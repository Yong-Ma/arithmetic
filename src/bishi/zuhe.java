package bishi;

import java.util.ArrayList;
import java.util.List;

//求由1 2 3 4组成的不重复三位数
public class zuhe {
    public static void main(String[] args) {
        List<Integer> res=new ArrayList<>();
        int count=0;
        for (int i = 1; i <= 4; i++)
            for (int j = 1; j <=4 ; j++)
                for (int k = 1; k <=4 ; k++) {
                    if(i!=k&&i!=j&&k!=j) {
                        res.add(i*100+j*10+k);
                        count++;
                    }
                }
        System.out.printf("有%d种组合，如下：",count);
        System.out.println();
        for (int a : res) {
            System.out.println(a);
        }
    }
}
