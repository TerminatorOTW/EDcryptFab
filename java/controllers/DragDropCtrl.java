
package edcryptfab.java.controllers;

import java.io.File;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.TransferMode;

public class DragDropCtrl {
    
    public DragDropCtrl(MainCtrl ctrl) {
        
        Platform.runLater(()->{
            Scene scene = ctrl.getModal().getMainActivity().centreLayout.getScene();
            scene.setOnDragOver(e->{
                if(e.getDragboard().hasFiles())
                    e.acceptTransferModes(TransferMode.COPY);
            });
            scene.setOnDragDropped(e->{
                File file = e.getDragboard().getFiles().get(0);
                ctrl.fileFieldCtrl.readFile(file);
            });
        });
        
    }
    
}
