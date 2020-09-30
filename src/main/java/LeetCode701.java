/**
 * 描述:
 *
 * @author ludengke
 * @create 2020-09-29 11:42
 */
public class LeetCode701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = dfs(root, val);
        if(node == null){
            root = new TreeNode(val);
        } else if(val < node.val){
            node.left = new TreeNode(val);
        }else {
            node.right = new TreeNode(val);
        }
        return root;
    }

    /**
     * dfs找到需要添加节点的位置,节点必须有一个子树为null
     * @param root
     * @param val
     * @return
     */
    public TreeNode dfs(TreeNode root, int val) {
        if(root == null){
            return null;
        }else {
            if((root.left == null && val < root.val) || (root.right == null && val > root.val)){
                return root;
            }else {
                if(val < root.val){
                    return dfs(root.left,val);
                }else {
                    return dfs(root.right,val);
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode701 l = new LeetCode701();
        TreeNodeUtil.printTree(l.insertIntoBST(TreeNodeUtil.listToTree(4,2,7,null,null,5),6));
    }
}
