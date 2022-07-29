
// Developed by the "TERMINATOR OTW"

package edcryptfab.java.fn;

import edcryptfab.java.api.File_rw;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Decrypt {

    private final File_rw fileRW = new File_rw();
    private final Functions fn = new Functions();
    
    public String decryptFile(File file, String password){

        final byte[] x1 = new byte[]{-31};
        final byte[] x2 = new byte[]{-32};
        byte[] decArray = decryptData(fileRW.getByteData(file), password);

        if (decArray == null)
            return "Error!";

        if (decArray.length == 1) {
            if (decArray[0] == x1[0]) {
                return "Your file is not encrypted!";
            } else if (decArray[0] == x2[0]){
                return "Incorrect password(key)";
            }
        }
        
        fileRW.setByteData(file, decArray);
        return "Decryption Successfull";
    }
    
    private byte[] decryptData(byte[] data, String password){
        
        final int len = data.length;
        byte[] decVal = new byte[len-4];
        
        // check if encrypted
        if (fn.detectEncryption(data))
            System.arraycopy(data, 0, decVal, 0, len-4);
        else
            return new byte[]{-31};
        
        try {
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, fn.getKey(password));
            decVal = c.doFinal(decVal);
        } catch (
            InvalidKeyException | NoSuchAlgorithmException |
            BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            if (e instanceof BadPaddingException) {
                return new byte[]{-32};
            } else {
                decVal = null;
            }
        }
        
        return decVal;
    }
    
}
