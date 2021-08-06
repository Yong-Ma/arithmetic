package other;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 输出1,2,2,3,4,5的所有排列组合,4不能在第三位,3和5不能相邻
 */
public class zuhe {
    public static List<String> find(List<String> list) {
        List<String> rtn = new ArrayList<String>();
        String str;
        for (int i = 0; i < list.size(); i++) {
            str = list.get(i);
            list.remove(i);
            if (list.size() == 0) {
                rtn.add(str);
            } else {
                List<String> sList = find(list);
                for (String s : sList) {
                    rtn.add(str + s);
                    if (s.length() == 5) {
                        addNumber(str + s);
                    }
                }
            }
            list.add(i, str);
        }
        return rtn;
    }

    /**
     * 通过这个来排除
     * @param str
     */
    public static void addNumber(String str) {
        if (str.charAt(2) == '4' || str.contains("35") || str.contains("53")) {
            return;
        }
        set.add(str);
    }

    public static Set<String> set = new TreeSet<String>();

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        find(list);
        System.out.println(set.size());
        int cols = 10;
        for (String s : set) {
            System.out.print(s + " ");
            if (cols-- == 1) {
                System.out.println();
                cols = 10;
            }
        }
    }
}
