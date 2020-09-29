import scala.collection.mutable._

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author ludengke
 * @create 2020-09-29 9:13
 */
object LeetCode235 extends App {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  object TreeNode{
    def apply(_value: Int, _left: TreeNode, _right: TreeNode): TreeNode = new TreeNode(_value, _left, _right)
    def apply(_value: Int): TreeNode = new TreeNode(_value)
  }

  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    if(p.value < root.value && q.value > root.value || (p.value > root.value && q.value < root.value)){
      root
    }else{
      if(p.value == root.value){
        p
      }else if(q.value == root.value){
        q
      }
      else if(p.value < root.value && q.value < root.value){
        lowestCommonAncestor(root.left,p,q)
      }else{
        lowestCommonAncestor(root.right,p,q)
      }
    }
  }

//  println(lowestCommonAncestor(TreeNode(1,TreeNode(2,TreeNode(4),TreeNode(5)),TreeNode(3,TreeNode(6),TreeNode(7)))))
}
