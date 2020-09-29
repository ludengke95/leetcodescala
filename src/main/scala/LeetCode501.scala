

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author ludengke
 * @create 2020-09-29 9:13
 */
object LeetCode501 extends App {
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  object TreeNode{
    def apply(_value: Int, _left: TreeNode, _right: TreeNode): TreeNode = new TreeNode(_value, _left, _right)
    def apply(_value: Int): TreeNode = new TreeNode(_value)
  }

  var maxValue = Int.MinValue
  var count = 0
  var curCount = 0
  var result = Array[Int]()
  var lastValue = Int.MinValue
  def update(value: Int) = {
    if(lastValue==value){
      curCount +=1
    }else{
      curCount = 1
    }
    if(curCount > count){
      result = Array[Int](value)
      count = curCount
    }else if(curCount == count){
      result = result :+ value
    }
    lastValue = value
  }

  def dfs(root: TreeNode): Unit = {
    if(root!=null){
      dfs(root.left)
      update(root.value)
      dfs(root.right)
    }
  }

  def findMode(root: TreeNode): Array[Int] = {
    maxValue = Int.MinValue
    count = 0
    curCount =0
    result = Array[Int]()
    dfs(root)
    result
  }
}
