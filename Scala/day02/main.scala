import scala.io.Source

val totalWrapping = Source.fromFile("input.txt").getLines().map { line =>
    val lwh = line.split("x").map(_.toInt)
    val Array(l, w, h) = lwh
    val minSide = lwh.sorted.take(2).product
    2 * (l * w + w * h + l * h) + minSide
}.sum
println(totalWrapping)

val totalLength = Source.fromFile("input.txt").getLines().map { line =>
    val lwh = line.split("x").map(_.toInt)
    val minPerimeter = 2 * lwh.sorted.take(2).sum
    lwh.product + minPerimeter
}.sum
println(totalLength)