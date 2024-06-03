package digito_unico.Service;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Service;

import java.security.*;
import java.util.Base64;
import java.security.NoSuchProviderException;
import javax.crypto.Cipher;

@Service
public class CriptografiaService {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }
    public KeyPair generateKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException {
      try {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA", "BC");
        keyGen.initialize(2048);
        return keyGen.generateKeyPair();
      } catch (NoSuchProviderException e) {
        // Handle the exception here
        e.printStackTrace();
        return null; // Or throw a custom exception
      }
    }

    public String encrypt(String data, PublicKey publicKey) throws Exception {
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
      cipher.init(Cipher.ENCRYPT_MODE, publicKey);
      return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    public String decrypt(String data, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }
}
