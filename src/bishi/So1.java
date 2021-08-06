package bishi;

import java.util.*;

public class So1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int[] arr=new int [n];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> aEntry:entrySet){
            if(res.isEmpty()&&aEntry.getValue()>=k)
                res.put(aEntry.getKey(),aEntry.getValue());
            else if(!res.isEmpty()&&aEntry.getValue()>=k){
                int key=0,val=0;
                Set<Map.Entry<Integer, Integer>> set = res.entrySet();
                for (Map.Entry<Integer, Integer> aentry:set){
                    key=aentry.getKey();
                    val=aentry.getValue();
                }
                if(val<aEntry.getValue()) {
                    res.clear();
                    res.put(aEntry.getKey(),aEntry.getValue());
                }else if(val==aEntry.getValue()) {
                    int index1=0,index2=0,flag=0;
                    for (int i = 0; i < n; i++) {
                        if(arr[i]==key) {
                            index1=i;
                            flag++;
                        }

                        if(arr[i]==aEntry.getKey()) {
                            flag++;
                            index2=i;
                        }
                        if(flag==2)
                            break;
                    }
                    if(index1>index2) {
                        res.clear();
                        res.put(aEntry.getKey(),aEntry.getValue());
                    }
                }
            }
        }
        if(!res.isEmpty()) {
            Set<Integer> set = res.keySet();
            Iterator<Integer> iterator = set.iterator();
            int result=iterator.next();
            System.out.println(result);
        }
        else
            System.out.println(-1);
    }
}
