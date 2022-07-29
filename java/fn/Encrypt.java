
// Developed by the "TERMINATOR OTW"

package edcryptfab.java.fn;

import edcryptfab.java.api.File_rw;
import edcryptfab.java.api.Hex_op;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Encrypt {

    private final File_rw fileRW = new File_rw();
    private final Functions fn = new Functions();
    
    public String encryptFile(File file, String password){
        
        final byte[] x1 = new byte[]{-31};
        byte[] encArray = encryptData(fileRW.getByteData(file), password);
        
        if (encArray == null)
            return "Error!";
        
        if (encArray.length == 1 && encArray[0] == x1[0]) {
            return "Your file is already encrypted!";
        }
        
        fileRW.setByteData(file, encArray);
        
        return "Encryption Successfull";
    }
    
    private byte[] encryptData(byte[] data, String password){
        
        byte[] encVal;
        
        if (fn.detectEncryption(data))
            return new byte[]{-31};
        
        try {
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.ENCRYPT_MODE, fn.getKey(password));
            data = c.doFinal(data);
            encVal = new byte[data.length+4];
            System.arraycopy(data, 0, encVal, 0, data.length);
        } catch (
            InvalidKeyException | NoSuchAlgorithmException |
            BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            encVal = null;
        }
        
        // append encryption code (so that software understands it is an encrypted file)
        if (encVal != null) {
            encVal[encVal.length-4] = 3;
            encVal[encVal.length-3] = 1;
            encVal[encVal.length-2] = 1;
            encVal[encVal.length-1] = 2;
        }
        
        return encVal;
    }
    
}
