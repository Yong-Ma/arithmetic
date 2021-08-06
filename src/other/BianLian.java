package other;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BianLian {
    List<Integer> pre=new ArrayList<>();
    List<Integer> mid=new ArrayList<>();
    List<Integer> aft=new ArrayList<>();
    public int[][] threeOrders (TreeNode root) {
        // write code here
        pre(root);
        mid(root);
        aft(root);
        int [][]res=new int[3][pre.size()];
        for(int i=0;i<pre.size();i++) {
            res[0][i]=pre.get(i);
        }
        for(int i=0;i<pre.size();i++) {
            res[1][i]=mid.get(i);
        }
        for(int i=0;i<pre.size();i++) {
            res[2][i]=aft.get(i);
        }
        return res;
    }
    public void pre(TreeNode node) {
        if(node==null)
            return ;
        pre.add(node.val);
        pre(node.left);
        pre(node.right);
    }
    public void mid(TreeNode node) {
        if(node==null)
            return ;
        mid(node.left);
        mid.add(node.val);
        mid(node.right);
    }
    public void aft(TreeNode node) {
        if(node==null)
            return ;
        aft(node.left);
        aft(node.right);
        aft.add(node.val);
    }

    public static void main(String[] args) {
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        a.left=b;a.right=c;
        System.out.println(Arrays.deepToString(new BianLian().threeOrders(a)));
    }
}
