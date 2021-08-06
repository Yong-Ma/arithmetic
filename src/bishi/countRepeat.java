package bishi;

import java.util.ArrayList;

public class countRepeat {
    public int count(String str) {
        int length=str.length();
        int res=0;
        for (int i = 0; i < length-1; i++) {
            for (int l = 1; i+2*l <length ; l++) {
                int j=i+l;
                if(str.substring(i,j).equals(str.substring(j,j+l)))
                    res=Math.max(res,l);
            }
        }
        return 2*res;

    }

    public static void main(String[] args) {
        String str="xabcaca";
        countRepeat countRepeat = new countRepeat();
        System.out.println(countRepeat.count(str));
    }
}
