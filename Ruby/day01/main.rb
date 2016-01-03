floor = 0
pos = 0
found = false
File.open('input.txt').each_char do |c|
  if !found && floor != -1
    pos += 1
  elsif floor == -1
    found = true
  end

  if c == '('
    floor += 1
  elsif c == ')'
    floor += -1
  end
end

puts floor
puts pos

