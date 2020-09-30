/**
 * 描述:
 *
 * @author ludengke
 * @create 2020-09-29 11:42
 */
public class LeetCode617 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        LeetCode617 l = new LeetCode617();
//        System.out.println(l.getTriggerTime());
    }
}
