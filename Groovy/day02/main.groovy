package day02

/**
 * Created by SidneyXu on 2016/01/07.
 */
def totalWrapping = new File("input.txt")
        .readLines()
        .collect {
    def lwh = it.split("x").collect { it.toInteger() }.sort()
    def minSide = lwh[0] * lwh[1]
    2 * (lwh[0] * lwh[1] + lwh[1] * lwh[2] + lwh[0] * lwh[2]) + minSide
}.inject { n1, n2 -> n1 + n2 }
println(totalWrapping)

def totalLength = new File("input.txt")
        .readLines()
        .collect {
    def lwh = it.split("x").collect { it.toInteger() }.sort()
    def minPerimeter = 2 * (lwh[0] + lwh[1])
    lwh[0] * lwh[1] * lwh[2] + minPerimeter
}.inject { n1, n2 -> n1 + n2 }

println(totalLength)