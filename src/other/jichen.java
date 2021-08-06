package other;

import java.math.BigInteger;
import java.util.Scanner;

public class jichen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        BigInteger res=help(N);
        System.out.println(res.toString(10));
    }
    public static BigInteger help(int N) {
        if(N==1)
            return new BigInteger("1");
        String str=String.valueOf(N);
        BigInteger big=new BigInteger(str);
        return big.multiply(help(N-1));
    }

}
