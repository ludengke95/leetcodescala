

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author ludengke
 * @create 2020-09-29 9:13
 */
object LeetCode1592 extends App {
  def reorderSpaces(text: String): String = {
    var spaceNum = text.count(_.equals(' '))
    var str = text.split(" ")
    val s = new StringBuffer()
    val wordNum = str.count(!_.equals(""))
    var everySpaceNum = 0
    if(wordNum > 1){
      everySpaceNum = spaceNum / (wordNum - 1)
    }else{
      everySpaceNum = 0
    }
    str = str.filter(!"".equals(_))
    for(i <- 0 until str.length){
      s.append(str(i))
      if(i != str.length -1){
        s.append(" " * everySpaceNum)
        spaceNum -= everySpaceNum
      }
    }
    s.append(" " * spaceNum).toString
  }
}
