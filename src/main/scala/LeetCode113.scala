import scala.collection.mutable._

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author ludengke
 * @create 2020-09-29 9:13
 */
object LeetCode113 extends App {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  object TreeNode{
    def apply(_value: Int, _left: TreeNode, _right: TreeNode): TreeNode = new TreeNode(_value, _left, _right)
    def apply(_value: Int): TreeNode = new TreeNode(_value)
  }

  def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
    pathSum(root,sum,List[Int]())
  }

  def pathSum(root: TreeNode, sum: Int,path: List[Int]): List[List[Int]] = {
    var result = ListBuffer[List[Int]]()
    if(root != null){
      if(root.left == null &&  root.right == null){
        if(sum - root.value ==0){
          result += path :+ root.value
        }
      }
      if(root.left != null){
        result ++= pathSum(root.left,sum - root.value,path :+ root.value)
      }
      if(root.right != null){
        result ++= pathSum(root.right,sum - root.value,path :+ root.value)
      }
    }
    result.toList
  }
}
