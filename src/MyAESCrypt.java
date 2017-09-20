import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

/**
 * Created by admin on 19.09.2017.
 */
public class MyAESCrypt {
    String KEY_AES = "passwordpassword"; // max 15 character but you can us md5
    String IV_AES = "ivpasswordivpass"; // max 16 character


    public String encrypt(String value) {
        try {
            byte[] key = KEY_AES.getBytes("UTF-8");
            byte[] ivs = IV_AES.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(ivs);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, paramSpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String decrypt(String value) {
        try {

            byte[] key = KEY_AES.getBytes("UTF-8");
            byte[] ivs = IV_AES.getBytes("UTF-8");

            byte[] decodeText = Base64.getDecoder().decode(value);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(ivs);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, paramSpec);

            return new String(cipher.doFinal(decodeText));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
