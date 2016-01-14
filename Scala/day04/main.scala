import java.security.MessageDigest
import javax.xml.bind.annotation.adapters.HexBinaryAdapter

def findResult(secretKey: String, strToFind: String) {
    val digest = MessageDigest.getInstance("MD5")
    def length = strToFind.length
    1.to(Int.MaxValue)
            .find(i => {
                val md5Bytes = digest.digest(s"$secretKey$i".getBytes())
                if (new HexBinaryAdapter().marshal(md5Bytes).substring(0, length) == strToFind) {
                    println(s"result is $i")
                    true
                } else {
                    false
                }
            })
}
