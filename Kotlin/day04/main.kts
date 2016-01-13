import java.security.MessageDigest
import javax.xml.bind.annotation.adapters.HexBinaryAdapter

fun findResult(secretKey: String, strToFind: String) {
    val digest = MessageDigest.getInstance("MD5")
    val length = strToFind.length - 1
    1.rangeTo(Int.MAX_VALUE)
            .first {
                val md5Bytes = digest.digest("$secretKey$it".toByteArray())
                if (HexBinaryAdapter().marshal(md5Bytes).substring(0..length) == strToFind) {
                    println("result is $it")
                    true
                } else {
                    false
                }
            }
}

val secretKey = "ckczppom"
findResult(secretKey, "00000")
findResult(secretKey, "000000")
