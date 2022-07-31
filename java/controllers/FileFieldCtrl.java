
// Developed by the "TERMINATOR OTW"

package edcryptfab.java.controllers;

import edcryptfab.java.activities.MainActivity;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class FileFieldCtrl {

    private final FileChooser fileChooser = new FileChooser();
    private final TextField filePathField;
    
    public FileFieldCtrl(MainCtrl mainCtrl) {
        
        MainActivity mainActivity = mainCtrl.getModal().getMainActivity();
        
        this.filePathField = mainActivity.fileField;
        final Button fileSearchBtn = mainActivity.filePathBtn;
        
        // setAction
        this.setBtnActivity(fileSearchBtn);
        
        // settings
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    }
    
    private void setBtnActivity(Button fileSearchBtn) {
        
        fileSearchBtn.setOnAction(e->{
            File file = fileChooser.showOpenDialog(fileSearchBtn.getScene().getWindow());
            this.readFile(file);
        });
        
    }
    
    public void readFile(File file) {
        if (file != null && file.isFile()) {
            filePathField.setText(file.getPath());
            fileChooser.setInitialDirectory(file.getParentFile());
        }
    }
    
}
