package bishi;

import java.math.BigInteger;
import java.util.Scanner;

public class So4 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String num10=in.next();
        BigInteger bigInteger=new BigInteger(num10);
        System.out.println(bigInteger.toString(2));

    }
}
