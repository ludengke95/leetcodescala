import scala.collection.mutable._

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author ludengke
 * @create 2020-09-29 9:13
 */
object LeetCode106 extends App {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  object TreeNode{
    def apply(_value: Int, _left: TreeNode, _right: TreeNode): TreeNode = new TreeNode(_value, _left, _right)
    def apply(_value: Int): TreeNode = new TreeNode(_value)
  }

  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
    buildTree(inorder,0,inorder.length-1,postorder,0,inorder.length-1)
  }

  def buildTree(inOrder: Array[Int], inStart: Int, inEnd: Int, postOrder: Array[Int], postStart: Int, postEnd: Int): TreeNode = {
    if(inEnd < inStart ||postStart > postEnd){
      null
    }else{
      val nodeValue = postOrder(postEnd)
      val index = inOrder.indexOf(nodeValue)
      val node = new TreeNode(nodeValue)
      node.left = buildTree(inOrder,inStart,index - 1,postOrder,postStart,index - 1 - inStart + postStart)
      node.right = buildTree(inOrder,index + 1,inEnd,postOrder,index - inStart + postStart,postEnd - 1)
      node
    }
  }

  buildTree(Array(9,3,15,20,7),Array(9,15,7,20,3))
}
