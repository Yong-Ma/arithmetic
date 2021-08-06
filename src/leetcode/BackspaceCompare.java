package leetcode;

public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        if(turn(S).equals(turn(T)))
            return true;
        return false;
    }
    public String turn(String str) {
        StringBuilder res=new StringBuilder();
        char[] chars=str.toCharArray();
        int length=chars.length;
        for (int i = 0; i < length; i++) {
            if(chars[i]!='#')
                res.append(chars[i]);
            if(chars[i]=='#'&&i!=0&&res.length()!=0)
                res.deleteCharAt(res.length()-1);
        }
        return res.toString();
    }

}
