package other;

import leetcode.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 *
 * 该二叉树层序遍历的结果是
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * 示例1
 * 输入
 * 复制
 * {1,2}
 * 输出
 * 复制
 * [[1],[2]]
 * 示例2
 * 输入
 * 复制
 * {1,2,3,4,#,#,5}
 * 输出
 * 复制
 * [[1],[2,3],[4,5]]
 */
public class LevelOrders {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        if(root==null)
            return null;
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayDeque<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> temp=new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                if(queue.getFirst().left!=null)
                    queue.offerLast(queue.getFirst().left);
                if(queue.getFirst().right!=null)
                    queue.offerLast(queue.getFirst().right);
                temp.add(queue.getFirst().val);
                queue.pollFirst();
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        root.left=b;
        System.out.println(new LevelOrders().levelOrder(root));
    }
}
