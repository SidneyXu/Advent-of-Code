import java.io.File

val content = File("input.txt").readText("UTF-8")
var floor = content.split("").map {
    if (it == "(")
        1
    else if (it == ")")
        -1
    else 0
}.reduce { n1, n2 -> n1 + n2 }
println(floor)

var pos = 0
content.fold(0) { n, chr ->
    if (n == -1) return@fold n
    pos++
    if (chr == '(')
        n + 1
    else if (chr == ')')
        n - 1
    else n
}
println(pos)