
// Developed by the "TERMINATOR OTW"

package edcryptfab.java.controllers;

import edcryptfab.java.activities.MainActivity;
import edcryptfab.java.fn.Decrypt;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class DecryptCtrl {

    private final Decrypt decrypt = new Decrypt();
    
    public DecryptCtrl(MainCtrl mainCtrl) {
        
        MainActivity activity = mainCtrl.getModal().getMainActivity();
        
        Button decryptBtn = activity.decryptBtn;
        Label statusLabel = activity.statusLabel;
        
        // setActivity
        setDecryptBtnActivity(
            decryptBtn, statusLabel, activity.keyField, activity.keyHiddenField, activity.fileField);
    }
    
    private void setDecryptBtnActivity(
        Button decryptBtn, Label statusLabel, TextField keyField, 
            PasswordField keyHiddenField, TextField fileField) {
        
        decryptBtn.setOnAction(e->{
            
            String text;
            
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
                    statusLabel.setText("Status: " + decrypt.decryptFile(file, text));
                }
            }
        });
        
    }
    
}
