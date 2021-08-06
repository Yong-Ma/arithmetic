package bishi;
import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        String str=in.next();
        String num=str.substring(4,str.length()-1);
        String nums[]=num.split(",");
        String []er=new String [nums.length];
        for(int i=0;i<nums.length;i++) {
            er[i]=Integer.toBinaryString(Integer.parseInt(nums[i]));
            if(er[i].length()<8){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<8-er[i].length();j++){
                    sb.append("0");
                }
                sb.append(er[i]);
                er[i]=sb.toString();
            }
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<nums.length;i++) {
            res.append(er[i]);
        }
        int rs=Integer.parseInt(res.toString(),2);
        System.out.println(rs);
    }
}