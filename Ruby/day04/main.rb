require 'digest/md5'

def findResult(secret_key, str_to_find)
  length = str_to_find.length
  1.upto(Float::MAX) do |n|
    if Digest::MD5.hexdigest("#{secret_key}#{n}")[0...length] == str_to_find
      puts "result is #{n}"
      break
    end
  end
end

secret_key = 'ckczppom'
findResult(secret_key, '00000')
findResult(secret_key, '000000')
