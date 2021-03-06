package leetcode;
import java.util.*;
/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        for (int i = 0; i < s1.length; i++) {
            if(s1[i]!=t1[i])
                return false;
        }
        return true;
    }
}
