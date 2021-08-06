package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CommonChars {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        Map<Integer, Map<Character, Integer>> map = new HashMap<>();
        for (int i = 1; i < A.length; i++) {
            Map<Character, Integer> hashMap = new HashMap<>();
            String str=A[i];
            char[] chars = str.toCharArray();
            for (char c : chars) {
                hashMap.merge(c,1,Integer::sum);
            }
            map.put(i,hashMap);
        }
        char[] chars=A[0].toCharArray();
        for (char c : chars) {
            int start=1;
            for (int i = 1; i <A.length ; i++) {
                Map<Character,Integer> temp1=map.get(i);
                if(temp1.get(c)==null||temp1.get(c)==0)
                    break;
                start=i;
            }
            if(start==A.length-1) {
                res.add(String.valueOf(c));
                for (int i = 1; i <A.length ; i++) {
                    Map<Character,Integer> temp2=map.get(i);
                    temp2.put(c,temp2.get(c)-1);
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String []A={"bella","label","roller"};
        System.out.println(new CommonChars().commonChars(A).toString());
    }
}
