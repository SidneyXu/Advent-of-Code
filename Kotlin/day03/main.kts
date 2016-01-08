import java.io.File

var currentLocation = Pair(0, 0)
var houses = File("input.txt").readText()
        .map {
            when (it) {
                '^' -> currentLocation = Pair(currentLocation.first, currentLocation.second + 1)
                'v' -> currentLocation = Pair(currentLocation.first, currentLocation.second - 1)
                '>' -> currentLocation = Pair(currentLocation.first + 1, currentLocation.second)
                '<' -> currentLocation = Pair(currentLocation.first - 1, currentLocation.second)
            }
            currentLocation
        }.distinct()
println(houses.size)

var santa = Pair(0, 0)
var robot = Pair(0, 0)
houses = File("input.txt").readText().mapIndexed { i, c ->
    if (i % 2 == 0) {
        when (c) {
            '^' -> santa = Pair(santa.first, santa.second + 1)
            'v' -> santa = Pair(santa.first, santa.second - 1)
            '>' -> santa = Pair(santa.first + 1, santa.second)
            '<' -> santa = Pair(santa.first - 1, santa.second)
        }
    } else {
        when (c) {
            '^' -> robot = Pair(robot.first, robot.second + 1)
            'v' -> robot = Pair(robot.first, robot.second - 1)
            '>' -> robot = Pair(robot.first + 1, robot.second)
            '<' -> robot = Pair(robot.first - 1, robot.second)
        }
    }
    Pair(santa, robot)
}.flatMap { listOf(it.first, it.second) }
        .distinct()
println(houses.size)
