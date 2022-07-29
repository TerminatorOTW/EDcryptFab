
// Developed by the "TERMINATOR OTW"

package edcryptfab.java.controllers;

import edcryptfab.java.activities.MainActivity;
import edcryptfab.java.fn.Encrypt;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EncryptCtrl {

    private final Encrypt encrypt = new Encrypt();
    
    public EncryptCtrl(MainCtrl mainCtrl) {
        
        MainActivity activity = mainCtrl.getModal().getMainActivity();
        
        Button encryptBtn = activity.encryptBtn;
        Label statusLabel = activity.statusLabel;
        
        // setActivity
        setEncryptBtnActivity(
            encryptBtn, statusLabel, activity.keyField, activity.keyHiddenField, activity.fileField);
    }
    
    private void setEncryptBtnActivity(
        Button encryptBtn, Label statusLabel, TextField keyField, 
            TextField keyHiddenField, TextField fileField) {
        
        encryptBtn.setOnAction(e->{
            
            final String text;
            
            if (keyField.isVisible())
                text = keyField.getText();
            else
                text = keyHiddenField.getText();
            
            if (text.length() > 16){
                statusLabel.setText("Status: Your Password is greater than 16-digit");
            } else {
                File file = new File(fileField.getText());
                if (file == null || !(file.isFile())) {
                    statusLabel.setText("Status: File not found");
                } else {
                    statusLabel.setText("Status: " + encrypt.encryptFile(file, text));
                }
            }
        });
        
    }
    
}
