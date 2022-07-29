
// Developed by the TerminatorOTW

package edcryptfab.java.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class File_rw {
    
    public byte[] getByteData(File file) {
        
        byte[] byteData = new byte[(int) file.length()];
        
        try {
            InputStream is = new FileInputStream(file);
            is.read(byteData);
            is.close();
        } catch (IOException f) {}
     
        return byteData;
    }
    
    public void setByteData(File file, byte[] byteData) {
            
        try {
            OutputStream os = new FileOutputStream(file);
            os.write(byteData);
            os.close();
        } catch (IOException f) {}
            
    }
    
    public String getText(File file) {
        
        if (file == null)
            return "";
        
        String text = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                text += line + '\n';
            }
            
            if (!text.isEmpty()) {
                if (text.charAt(text.length() - 1) == '\n') {
                    text = text.substring(0, text.length() - 1);
                }
            }
        } catch (Exception e) {}
        
        return text;
    }
    
    public boolean setText(String text, File file) {
        
        if (file == null)
            return false;
        
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            br.write(text);
            br.flush();
            br.close();
            return true;
        } catch (Exception e) {}
        
        return false;
    }
    
    public boolean setText(String text, File file, String os) {
        
        if (file == null)
            return false;
        
        switch(os) {
            case "windows":
                text = text.replace("\n", "\r\n");
                break;
            case "unix":
                break;
            case "mac":
                text = text.replace("\n", "\r");
                break;
            default:
                text = text.replace("\n", System.lineSeparator());
                break;
        }
        
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
            br.write(text);
            br.flush();
            br.close();
            return true;
        } catch (Exception e) {}
        
        return false;
    }
    
    public File[] getFilesFromFolder(File path) {
        File[] files = null;
        
        try {
            files = path.listFiles();
        } catch (Exception g) {}
        
        return files;
    }
    
}
