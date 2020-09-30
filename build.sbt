name := "leetcode"

version := "0.1"

scalaVersion := "2.13.3"

libraryDependencies ++= Seq( //依赖库
  "cn.hutool" % "hutool-all" % "5.2.4",
)

resolvers ++= Seq( //额外仓库添加
  "Aliyun Repository" at "https://maven.aliyun.com/repository/central",
  "Local Maven Repository" at "file:///c/Users/Administrator/.m2/repository"
)