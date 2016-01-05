import scala.io.Source

val content = Source.fromFile("input.txt").mkString
val floor = content.map {
    case '(' => 1
    case ')' => -1
}.sum
println(floor)

val pos = content.scanLeft(0) {
    case (c, '(') => c + 1
    case (c, ')') => c - 1
}.indexOf(-1)
println(pos)