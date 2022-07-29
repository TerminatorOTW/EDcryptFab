
// Developed by the "TERMINATOR OTW"

package edcryptfab.java.fn;

import edcryptfab.java.api.File_rw;
import java.io.File;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Functions {
    
    public Key getKey(String password) {
        return new SecretKeySpec(generateSecretKey(password), "AES");
    }
    
    public boolean detectEncryption(byte[] data) {
        final int len = data.length;
        if (data[len-4] == 3 && data[len-3] == 1 && data[len-2] == 1 && data[len-1] == 2)
            return true;
        else
            return false;
    }
    
    private String getSecretKey(String password) {
        String key = "";
        int pwdLength = password.length();
        for(int i=0; i < 16; i++) {
            if (i < pwdLength)
                key += password.charAt(i);
            else
                key += "x";
        }
        return key;
    }
    
    private byte[] generateSecretKey(String password) {
        return getSecretKey(password).getBytes();
    }
    
}
