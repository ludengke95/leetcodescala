

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author ludengke
 * @create 2020-09-29 9:13
 */
object LeetCode538 extends App {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  object TreeNode{
    def apply(_value: Int, _left: TreeNode, _right: TreeNode): TreeNode = new TreeNode(_value, _left, _right)
    def apply(_value: Int): TreeNode = new TreeNode(_value)
  }

  def convertBST(root: TreeNode): TreeNode = {
    if(root !=null){
      convertBST(root,0)
    }
    root
  }

  /**
   *
   * @param root
   * @return
   */
  def convertBST(root: TreeNode,num: Int): TreeNode = {
    if(root != null){
      convertBST(root.right,num)
      if(root.right!=null){
        var tmp = root.right
        while(tmp.left!=null){
          tmp = tmp.left
        }
        root.value += tmp.value
      }else{
        root.value += num
      }
      convertBST(root.left,root.value)
    }
    root
  }
}
