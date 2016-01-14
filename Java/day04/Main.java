import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String secretKey = "ckczppom";
        findResult(secretKey, "00000");
        findResult(secretKey, "000000");
    }

    private static void findResult(String secretKey, String strToFind) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        int endIndex = strToFind.length();
        IntStream.range(1, Integer.MAX_VALUE)
                .anyMatch(value -> {
                    byte[] md5Bytes = digest.digest((secretKey + value).getBytes());
                    if (strToFind.equals(new HexBinaryAdapter().marshal(md5Bytes).substring(0, endIndex))) {
                        System.out.println("result is " + value);
                        return true;
                    }
                    return false;
                });
    }
}
