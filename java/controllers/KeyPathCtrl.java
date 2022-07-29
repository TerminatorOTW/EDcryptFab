
// Developed by the "TERMINATOR OTW"

package edcryptfab.java.controllers;

import edcryptfab.java.activities.MainActivity;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class KeyPathCtrl {
    
    private TextField keyField;
    private PasswordField keyHiddenField;
    private Button keyVisibilityBtn;
    
    public KeyPathCtrl(MainCtrl mainCtrl) {
        
        MainActivity activity = mainCtrl.getModal().getMainActivity();
        
        this.keyField = activity.keyField;
        this.keyHiddenField = activity.keyHiddenField;
        this.keyVisibilityBtn = activity.hideKeyBtn;
        
        // setAction
        setVisibility(activity);
    }
    
    private void setVisibility(MainActivity activity) {
        
        keyVisibilityBtn.setOnAction(e->{
            if (keyHiddenField.isVisible()) {
                keyField.setVisible(true);
                keyHiddenField.setVisible(false);
                keyField.setText(keyHiddenField.getText());
                keyVisibilityBtn.setGraphic(activity.visibleView);
            } else {
                keyField.setVisible(false);
                keyHiddenField.setVisible(true);
                keyHiddenField.setText(keyField.getText());
                keyVisibilityBtn.setGraphic(activity.invisibleView);
            }
        });
        
    }
    
    private void setKeyText(String text) {
        keyField.setText(text);
    }
    
    private void setHiddenKeyText(String text) {
        keyHiddenField.setText(text);
    }

}
