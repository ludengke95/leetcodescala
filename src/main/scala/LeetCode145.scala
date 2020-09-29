import scala.collection.mutable._

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author ludengke
 * @create 2020-09-29 9:13
 */
object LeetCode145 extends App {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  object TreeNode{
    def apply(_value: Int, _left: TreeNode, _right: TreeNode): TreeNode = new TreeNode(_value, _left, _right)
    def apply(_value: Int): TreeNode = new TreeNode(_value)
  }

  def postorderTraversal(root: TreeNode): List[Int] = {
    val list = ListBuffer[Int]()
    if(root != null){
      val stack = Stack[(Boolean,TreeNode)]()
      stack.push((false,root))
      while (stack.size > 0){
        val t = stack.pop()
        if(t._1 || (t._2.right == null && t._2.left == null)){
          list += t._2.value
        }else{
          stack.push((!t._1,t._2))
          if(t._2.right != null){
            stack.push((false,t._2.right))
          }
          if(t._2.left != null){
            stack.push((false,t._2.left))
          }
        }
      }
    }
    list.toList
  }

  println(postorderTraversal(TreeNode(1,TreeNode(2,TreeNode(4),TreeNode(5)),TreeNode(3,TreeNode(6),TreeNode(7)))))
}
