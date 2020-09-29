

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author ludengke
 * @create 2020-09-29 9:13
 */
object LeetCode968 extends App {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  object TreeNode{
    def apply(_value: Int, _left: TreeNode, _right: TreeNode): TreeNode = new TreeNode(_value, _left, _right)
    def apply(_value: Int): TreeNode = new TreeNode(_value)
  }

  var num = 0
  def minCameraCover(root: TreeNode): Int = {
    num = 0
    if(dfs(root) == 0){
      num += 1
    }
    num
  }

  /**
   * 0未监控,1已监控,2已设置摄像头
   * @param root
   * @return
   */
  def dfs(root: TreeNode):Int ={
    if(root == null){
      1
    }else{
      val left = dfs(root.left)
      val right = dfs(root.right)
      if(left == 0 || right == 0){
        num +=1
        2
      }else if(left == 2 || right ==2){
        1
      }else {
        0
      }
    }
  }
}
