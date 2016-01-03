total_wrapping = 0
total_length = 0
IO.foreach('input.txt') { |line|
  l, w, h = line.split('x').map do |item|
    item.to_i
  end

  min_side = [l * w, w * h, l * h].min
  wrapping = 2 * (l * w + w * h + h * l) + min_side
  total_wrapping += wrapping

  min_perimeter = [2 * (l + w), 2 * (w + h), 2 * (l + h)].min
  bow = l * w * h
  total_length += min_perimeter + bow
}

puts total_wrapping
puts total_length