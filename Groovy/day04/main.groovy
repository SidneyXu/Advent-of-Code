import javax.xml.bind.annotation.adapters.HexBinaryAdapter
import java.security.MessageDigest

def findResult(String secretKey, String strToFind) {
    def digest = MessageDigest.getInstance("MD5")
    def length = strToFind.length() - 1
    (1..Integer.MAX_VALUE)
            .find {
        def md5Bytes = digest.digest("$secretKey$it".bytes)
        if (new HexBinaryAdapter().marshal(md5Bytes)[0..length] == strToFind) {
            println("result is $it")
            true
        } else {
            false
        }
    }
}

def secretKey = "ckczppom"
findResult(secretKey, '00000')
findResult(secretKey, '000000')