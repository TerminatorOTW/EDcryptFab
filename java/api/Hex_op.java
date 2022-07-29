
// Developed by the TerminatorOTW

package edcryptfab.java.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Hex_op {
    
    public String[] getByteDataAsHex(File file) {
        
        byte[] byteData = getByteData(file);
        final int length = byteData.length;
        String[] hexArray = new String[length];
        
        for (int i=0; i < length; i++) {
            hexArray[i] = decimalToHex(byteData[i]);
        }
        
        return hexArray;
    }
    
    public String[] getByteDataAsHex(byte[] byteData) {
        
        final int length = byteData.length;
        String[] hexArray = new String[length];
        
        for (int i=0; i < length; i++) {
            hexArray[i] = decimalToHex(byteData[i]);
        }
        
        return hexArray;
    }
    
    public byte[] getHexDataAsByte(String[] hexData) {
        
        final int length = hexData.length;
        byte[] byteArray = new byte[length];
        
        for (int i=0; i < length; i++) {
            byteArray[i] = hexToByte(hexData[i]);
        }
        
        return byteArray;
    }
    
    public int[] getHexDataAsInteger(String[] hexData) {
        
        final int length = hexData.length;
        int[] byteArray = new int[length];
        
        for (int i=0; i < length; i++) {
            byteArray[i] = hexToDecimal(hexData[i]);
        }
        
        return byteArray;
    }
    
    public String[] readHexDataFromOffset(String[] hexData, String offset, int length) {
        
        int o = hexToDecimal(offset);
        String[] newData = new String[length];
        
        for (int i=o; i < length; i++) {
            newData[i] = hexData[o + i];
        }
        
        return newData;
    }
    
    /* Functions */
    private byte[] getByteData(File file) {
        
        byte[] byteData = new byte[(int) file.length()];
        
        try {
            InputStream is = new FileInputStream(file);
            is.read(byteData);
            is.close();
        } catch (IOException f) {}
     
        return byteData;
    }
    
    private void setByteData(File file, byte[] byteData) {
            
        try {
            OutputStream os = new FileOutputStream(file);
            os.write(byteData);
            os.close();
        } catch (IOException f) {}
            
    }
    
    public String decimalToHex(int decimal) {
        try {
            return Integer.toHexString(decimal).replace("ffffff", "");
        } catch (NumberFormatException e) {}
        return "error";
    }
    
    public int hexToDecimal(String hexString) {
        try {
            return Integer.parseInt(hexString, 16);
        } catch (NumberFormatException e) {}
        return 0;
    }
    
    public byte hexToByte(String hexString) {
        try {
            return (byte) Integer.parseInt(hexString, 16);
        } catch (NumberFormatException e) {}
        return 0;
    }
    
    public String bytesToASCIIString(byte[] byteData) {
        return new String(byteData);
    }
    
    public String byteToASCIIString(byte byteData) {
        return new String(new byte[]{byteData});
    }
    
    public String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }
    
    public int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
    
    /* only for specific use (will not work for every pointer) */
    public String hexPointerToHexOffset(int[] pointer) {
        
        String offset = "";
        
        String a = decimalToHex(pointer[2]);
        String b = decimalToHex(pointer[1]);
        String c = decimalToHex(pointer[0]);
        
        if (a.length() < 2)
            a = "0" + a;
        
        if (b.length() < 2)
            b = "0" + b;
        
        if (c.length() < 2)
            c = "0" + c;
        
        if (pointer.length == 4) {
            offset = a + b + c;
        }
        
        return offset;
    }
    
}
