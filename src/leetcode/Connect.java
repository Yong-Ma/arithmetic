package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 */
public class Connect {
    public Node connect(Node root) {
        if(root==null)
            return null;
        Queue<Node> list=new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            int size=list.size();
            Node pre=null;
            for (int i = 1; i <=size ; i++) {
                Node current=list.poll();
                if (current.left!=null)
                    list.offer(current.left);
                if(current.right!=null)
                    list.offer(current.right);
                if(i!=1)
                    pre.next=current;
                pre=current;
            }
        }
        return root;
    }
}
