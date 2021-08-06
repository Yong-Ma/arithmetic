package leetcode;

/**
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 * 例如, 
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 *
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        digui(root,val);
        return root;
    }
    public void digui(TreeNode node,int val) {
        if(node.left==null&&val<node.val) {
            node.left=new TreeNode(val);
            return ;
        }
        if(node.right==null&&val>node.val) {
            node.right=new TreeNode(val);
            return ;
        }
        if(val>node.val)
            digui(node.right,val);
        else
            digui(node.left,val);

    }

}
