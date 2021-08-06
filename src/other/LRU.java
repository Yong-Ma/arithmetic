package other;

import java.util.*;

public class LRU {
    public int[] LRU (int[][] operators, int k) {
        Map<Integer,Integer> map=new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<operators.length;i++) {
            if(operators[i][0]==1) {
                if(map.size()<k)
                    map.put(operators[i][1],operators[i][2]);
                else if(map.size()==k) {
                    Set<Map.Entry<Integer,Integer>> set=map.entrySet();
                    Iterator<Map.Entry<Integer,Integer>> iterator=set.iterator();
                    Map.Entry e=iterator.next();
                    map.remove(e.getKey());
                    map.put(operators[i][1],operators[i][2]);
                }
            }else {
                if(map.containsKey(operators[i][1])) {
                    int value=map.get(operators[i][1]);
                    map.remove(operators[i][1]);
                    map.put(operators[i][1],value);
                    list.add(map.get(operators[i][1]));
                }
                else
                    list.add(-1);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[][]a={{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int K=3;
        System.out.println(Arrays.toString(new LRU().LRU(a, K)));
    }
}
