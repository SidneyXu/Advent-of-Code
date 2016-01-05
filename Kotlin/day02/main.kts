import java.io.File

var totalWrapping = 0
File("input.txt").forEachLine {
    val lwh = it.split('x').map { it.toInt() }
    val minSide = lwh.sorted().take(2).reduce { x, y -> x * y }
    totalWrapping += 2 * (lwh[0] * lwh[1] + lwh[1] * lwh[2] + lwh[0] * lwh[2]) + minSide
}
println(totalWrapping)

var totalLength = 0
File("input.txt").forEachLine {
    val lwh = it.split('x').map { it.toInt() }
    val minPerimeter = 2 * lwh.sorted().take(2).sum()
    totalLength += lwh[0] * lwh[1] * lwh[2] + minPerimeter
}
println(totalLength)