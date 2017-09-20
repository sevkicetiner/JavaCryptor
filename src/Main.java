import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

public class Main {


    public static void main(String[] args) {

        MyAESCrypt cryptor = new MyAESCrypt();
        System.out.println(cryptor.encrypt("this text wil crypt"));

        // Pd6khmtR10uKqadktHoxsyeZqbX0hGXiVlLBDjRAgss=

        System.out.println(cryptor.decrypt("Pd6khmtR10uKqadktHoxsyeZqbX0hGXiVlLBDjRAgss="));

        //this text wil crypt

    }



}
