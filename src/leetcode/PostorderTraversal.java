package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 */
public class PostorderTraversal {
    /**递归实现**/
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> arrayList = new ArrayList<>();
//        if(root==null)
//            return arrayList;
//        digui(root,arrayList);
//        return arrayList;
//    }
//    public void digui(TreeNode node,List<Integer> list) {
//        if (node.left==null&&node.right==null) {
//            list.add(node.val);
//            return;
//        }
//        if(node.left!=null)
//            digui(node.left,list);
//        if(node.right!=null)
//            digui(node.right,list);
//        list.add(node.val);
//    }
    /**迭代算法实现**/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        if(root==null)
            return arrayList;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current=stack.peek();
            if(current.right==null&&current.left==null)
                arrayList.add(stack.pop().val);
            if(current.right!=null) {
                stack.push(current.right);
                current.right=null;
            }
            if(current.left!=null) {
                stack.push(current.left);
                current.left=null;
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(1);
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode2;
        PostorderTraversal postorderTraversal = new PostorderTraversal();
        System.out.println(postorderTraversal.postorderTraversal(treeNode1));
    }


}
