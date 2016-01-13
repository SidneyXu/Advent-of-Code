require 'digest/md5'

def findResult(secret_key, str_to_find)
  length = str_to_find.length
  i = 1
  while true
    break if Digest::MD5.hexdigest("#{secret_key}#{i}")[0...length] == str_to_find
    i += 1
  end
  puts "result is #{i}"
end

secret_key = 'ckczppom'
findResult(secret_key, '00000')
findResult(secret_key, '000000')