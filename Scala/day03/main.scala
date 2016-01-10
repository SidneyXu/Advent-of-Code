import scala.io.Source

val houses = Source.fromFile("input.txt").mkString
        .scanLeft((0, 0)) {
            case (t, '^') => (t._1, t._2 + 1)
            case (t, 'v') => (t._1, t._2 - 1)
            case (t, '>') => (t._1 + 1, t._2)
            case (t, '<') => (t._1 - 1, t._2)
        }.distinct
println(houses.size)

var houses2 = Source.fromFile("input.txt").mkString
        .zipWithIndex
        .scanLeft(((0, 0), (0, 0))) {
            case ((t1, t2), ('^', i)) if i % 2 == 0 => ((t1._1, t1._2 + 1), t2)
            case ((t1, t2), ('^', i)) => (t1, (t2._1, t2._2 + 1))
            case ((t1, t2), ('v', i)) if i % 2 == 0 => ((t1._1, t1._2 - 1), t2)
            case ((t1, t2), ('v', i)) => (t1, (t2._1, t2._2 - 1))
            case ((t1, t2), ('>', i)) if i % 2 == 0 => ((t1._1 + 1, t1._2), t2)
            case ((t1, t2), ('>', i)) => (t1, (t2._1 + 1, t2._2))
            case ((t1, t2), ('<', i)) if i % 2 == 0 => ((t1._1 - 1, t1._2), t2)
            case ((t1, t2), ('<', i)) => (t1, (t2._1 - 1, t2._2))
        }.flatMap(it => List(it._1, it._2))
        .distinct
println(houses2.size)
