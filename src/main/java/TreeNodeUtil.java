import cn.hutool.core.collection.CollUtil;

import java.util.*;

/**
 * 描述:
 * TreeNode工具类
 *
 * @author ludengke
 * @create 2020-09-30 9:17
 */
public class TreeNodeUtil {
    private static TreeNode listToTree(List<Integer> list){
        TreeNode t = null;
        if(list.size() != 0){
            t = new TreeNode(list.get(0));
            buildTree(t,list,0);
        }
        return t;
    }

    private static void buildTree(TreeNode root,List<Integer> list,Integer index){
        if(2*index + 1 < list.size()){
            if(list.get(2*index + 1) !=null){
                root.left = new TreeNode(list.get(2*index + 1));
                buildTree(root.left,list,2*index + 1);
            }
        }
        if(2*index + 2 < list.size()){
            if(list.get(2*index + 2) !=null){
                root.right = new TreeNode(list.get(2*index + 2));
                buildTree(root.right,list,2*index + 2);
            }
        }
    }

    public static TreeNode listToTree(Integer... list){
        return listToTree(CollUtil.toList(list));
    }

    public static void printTree(TreeNode root){
        List<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> q = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode t = q.get(0);
            q.remove(0);
            list.add(t==null?null:t.val);
            if(t!=null){
                q.add(t.left);
                q.add(t.right);
            }
            if(q.stream().filter(Objects::isNull).count() == q.size()){
                break;
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        TreeNodeUtil.printTree(TreeNodeUtil.listToTree(4,2,7,null,null,3));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
