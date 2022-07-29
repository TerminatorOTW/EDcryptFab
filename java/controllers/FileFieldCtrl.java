
// Developed by the "TERMINATOR OTW"

package edcryptfab.java.controllers;

import edcryptfab.java.activities.MainActivity;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class FileFieldCtrl {

    private final FileChooser fileChooser = new FileChooser();
    
    public FileFieldCtrl(MainCtrl mainCtrl) {
        
        MainActivity mainActivity = mainCtrl.getModal().getMainActivity();
        
        final TextField filePathField = mainActivity.fileField;
        final Button fileSearchBtn = mainActivity.filePathBtn;
        
        // setAction
        this.setBtnActivity(fileSearchBtn, filePathField);
        
        // settings
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    }
    
    private void setBtnActivity(Button fileSearchBtn, TextField filePathField) {
        
        fileSearchBtn.setOnAction(e->{
            File file = fileChooser.showOpenDialog(fileSearchBtn.getScene().getWindow());
            if (file != null && file.isFile()) {
                filePathField.setText(file.getPath());
                fileChooser.setInitialDirectory(file.getParentFile());
            }
        });
        
    }
    
}
