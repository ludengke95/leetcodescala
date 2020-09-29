import scala.collection.mutable._

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author ludengke
 * @create 2020-09-29 9:13
 */
object LeetCode117 extends App {
  class Node(var _value: Int) {
    var value: Int = _value
    var left: Node = null
    var right: Node = null
    var next: Node = null
  }

  def connect(root: Node): Node = {
    var queue: ListBuffer[(Int,Node)] = ListBuffer[(Int,Node)]((1,root))
    var lastNode: (Int,Node) = null
    while(!queue.isEmpty){
      if(null != lastNode){
        if(lastNode._1 == queue.head._1){
          lastNode._2.next = queue.head._2
        }
        else{
          lastNode._2.next = null
        }
      }
      if(queue.head._2 != null){
        lastNode = queue.head
        queue.+=((queue.head._1+1,queue.head._2.left))
        queue.+=((queue.head._1+1,queue.head._2.right))
      }
      queue = queue.drop(1)
    }
    root
  }
}
