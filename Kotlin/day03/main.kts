import java.io.File

var currentLocation = arrayOf(0, 0)
val set = hashSetOf<Array<Int>>()
set.add(arrayOf(0, 0))
val x = File("input.txt").readText()
        .split("")
        .map {
            when (it) {
                "^" -> currentLocation[1] += 1
                "v" -> currentLocation[1] -= 1
                ">" -> currentLocation[0] += 1
                "<" -> currentLocation[0] -= 1
            }
            set.add(currentLocation.clone())
            currentLocation.clone()
        }
println(set.size)
println(x.groupBy { it.hashCode() }.size)

set.clear()
set.add(arrayOf(0, 0))
val santa = arrayOf(0, 0)
val robot = arrayOf(0, 0)
File("input.txt").readText()
        .split("")
        .mapIndexed { i, s ->
            when (s) {
                "^" ->
                    if (i % 2 == 0)
                        santa[1] += 1
                    else
                        robot[1] += 1
                "v" ->
                    if (i % 2 == 0)
                        santa[1] -= 1
                    else
                        robot[1] -= 1
                ">" ->
                    if (i % 2 == 0)
                        santa[0] += 1
                    else
                        robot[0] += 1
                "<" ->
                    if (i % 2 == 0)
                        santa[0] -= 1
                    else
                        robot[0] -= 1
            }
            set.add(santa.clone())
            set.add(robot.clone())
        }
println(set.size)