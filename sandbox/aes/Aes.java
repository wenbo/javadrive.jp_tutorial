import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Aes {

  private static Encryptor enc = new Encryptor("73hak32rw290W@@t", "7623962845038274");

  static String auth = System.getProperty("iapi.auth", "12345678");

  private static String getAuth(String username, long cusId) {
    return enc
      .enc(new String[] { auth, cusId + "", username, "" + "1418804983" });
  }

  static class Encryptor {
    private SecretKey aesKey;
    private IvParameterSpec ivSpec;

    public Encryptor(String key, String iv) {
      aesKey = new SecretKeySpec(key.getBytes(), "AES");
      ivSpec = new IvParameterSpec(iv.getBytes());
    }

    byte[] aesEncrypt(byte[] src) {

      Cipher aesCipher;
      try {
        aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aesCipher.init(Cipher.ENCRYPT_MODE, aesKey, ivSpec);
        return aesCipher.doFinal(src);
      } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
      } catch (NoSuchPaddingException e) {
        throw new RuntimeException(e);
      } catch (InvalidKeyException e) {
        throw new RuntimeException(e);
      } catch (IllegalBlockSizeException e) {
        throw new RuntimeException(e);
      } catch (BadPaddingException e) {
        throw new RuntimeException(e);
      } catch (InvalidAlgorithmParameterException e) {
        throw new RuntimeException(e);
      }

    }

    public String enc(String[] from) {
      StringBuilder sb = new StringBuilder();
      for (String t : from) {
        sb.append(t).append("\n");
      }
      return new String(encodeHex(aesEncrypt(sb.toString().getBytes()), DIGITS_UPPER));
    }

    static final char[] DIGITS_UPPER = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
      'B', 'C', 'D', 'E', 'F' };

    char[] encodeHex(final byte[] data, final char[] toDigits) {
      final int l = data.length;
      final char[] out = new char[l << 1];
      // two characters form the hex value.
      for (int i = 0, j = 0; i < l; i++) {
        out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
        out[j++] = toDigits[0x0F & data[i]];
      }
      return out;
    }
  }

  public static void main(String[] args) {
    String auth_result = getAuth("wuxp@anchnet.com", 10579);
    System.out.println(auth_result);
  }

}
