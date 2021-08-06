package leetcode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSubStructure {
//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        if(A==null||B==null)
//            return false;
//        System.out.println(digui(A, B));
//        System.out.println(size(B));
//       if(digui(A, B)==size(B))
//           return true;
//       else
//           return false;
//    }
//    public int digui(TreeNode A,TreeNode B) {
//        int count=0;
//        if(A!=null&&B!=null&&(A.val==B.val)) {
//            count++;
//            count+=digui(A.left,B.left);
//            count+=digui(A.right,B.right);
//        }else if(B!=null&&A!=null) {
//            count+=digui(A.left,B);
//            count+=digui(A.right,B);
//        }
//        return count;
//    }
//    public int size(TreeNode A) {
//        int sum=0;
//        if(A!=null) {
//            sum++;
//            sum+=size(A.left);
//            sum+=size(A.right);
//        }
//        return sum;
//    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        TreeNode aa = new TreeNode(4);
        TreeNode bb= new TreeNode(8);
        TreeNode cc= new TreeNode(9);
        aa.left = bb;
        aa.right = cc;
        new IsSubStructure().isSubStructure(a,aa);
    }
}
