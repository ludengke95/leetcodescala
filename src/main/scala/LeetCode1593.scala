import scala.collection.mutable._

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author ludengke
 * @create 2020-09-29 9:13
 */
object LeetCode1593 extends App {
  var min = 0
  def maxUniqueSplit(s: String): Int = {
    min = 0
    dfs(s,s.length,0,new HashSet[String]())
    min
  }
  def dfs(s: String,length: Int,index: Int,use: Set[String]):Int = {
    if(index == length){
      if(use.size > min){
        min = use.size
      }
    }else{
      for(i <- index until length){
        if(!use.contains(s.substring(index,i+1))) {
          dfs(s, length, i + 1, use + s.substring(index, i+1))
        }
      }
    }
    0
  }
}
