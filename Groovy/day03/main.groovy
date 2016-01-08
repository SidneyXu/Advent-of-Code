def currentLocation = [0, 0]
def houses = new File("input.txt")
        .text
        .collect {
    switch (it as char) {
        case '^':
            currentLocation[1]++
            break
        case 'v':
            currentLocation[1]--
            break
        case '>':
            currentLocation[0]++
            break
        case '<':
            currentLocation[0]--
            break
    }
    currentLocation.clone()
}.unique()
println(houses.size())

def santa = [0, 0]
def robot = [0, 0]
houses = new File("input.txt")
        .bytes
        .toList()
        .withIndex()
        .collect { c, i ->
    if (i % 2 == 0) {
        switch (c as char) {
            case '^':
                santa[1]++
                break
            case 'v':
                santa[1]--
                break
            case '>':
                santa[0]++
                break
            case '<':
                santa[0]--
                break
        }
    } else {
        switch (c as char) {
            case '^':
                robot[1]++
                break
            case 'v':
                robot[1]--
                break
            case '>':
                robot[0]++
                break
            case '<':
                robot[0]--
                break
        }
    }
    [santa.clone(), robot.clone()]
}.collectMany { it }
        .unique()
println(houses.size())