require 'set'
content = File.open('input.txt').read

current_location = [0, 0]
set = Set.new
set.add([0, 0])

content.each_char do |c|
  case c
    when '^'
      current_location[1] += 1
    when 'v'
      current_location[1] -= 1
    when '>'
      current_location[0] += 1
    when '<'
      current_location[0] -= 1
  end
  set.add(current_location.dup)
end

puts set.count

set.clear
set.add([0, 0])
santa = [0, 0]
robot = [0, 0]

content.each_char.with_index do |c, i|
  case c
    when '^'
      if i % 2 == 0
        santa[1] += 1
      else
        robot[1] += 1
      end
    when 'v'
      if i % 2 == 0
        santa[1] -= 1
      else
        robot[1] -= 1
      end
    when '>'
      if i % 2 == 0
        santa[0] += 1
      else
        robot[0] += 1
      end
    when '<'
      if i % 2 == 0
        santa[0] -= 1
      else
        robot[0] -= 1
      end
  end
  set.add(santa.dup)
  set.add(robot.dup)
end

puts set.count

