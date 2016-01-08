require 'set'
content = File.open('input.txt').read

current_location = [0, 0]
houses = Set.new
houses.add([0, 0])

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
  houses.add(current_location.dup)
end

puts houses.count

houses.clear
houses.add([0, 0])
santa = [0, 0]
robot = [0, 0]

content.each_char.with_index do |c, i|
  if i % 2 == 0
    location = santa
  else
    location = robot
  end
  case c
    when '^'
      location[1] += 1
    when 'v'
      location[1] -= 1
    when '>'
      location[0] += 1
    when '<'
      location[0] -= 1
    else
  end
  houses.add(santa.dup)
  houses.add(robot.dup)
end

puts houses.count

