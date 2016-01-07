import scala.io.Source

val santaHouses = Source.fromFile("input.txt").mkString
  .split("")
  .scanLeft((0, 0)) {
  case (t, "^") => (t._1, t._2 + 1)
  case (t, "v") => (t._1, t._2 - 1)
  case (t, ">") => (t._1 + 1, t._2)
  case (t, "<") => (t._1 - 1, t._2)
}.distinct.length
println(santaHouses)
