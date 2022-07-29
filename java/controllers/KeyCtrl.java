
// Developed by the TerminatorOTW

package edcryptfab.java.controllers;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.input.KeyCode;

public class KeyCtrl {
    
    private final MainCtrl mainCtrl;
    
    private boolean controlIsOn = false;
    
    public KeyCtrl(MainCtrl mC) {
        this.mainCtrl = mC;
        
        // methods to run
        Platform.runLater(()->{
            this.setKeyHandler();
        });
    }
    
    private void setKeyHandler() {
        
        mainCtrl.getModal().getMainActivity().mainLayout.getScene().setOnKeyPressed(e->{
            if (controlIsOn) {
                controlFunctions(e, e.getCode());
            }
            
            switch (e.getCode()) {
                case CONTROL:
                    controlIsOn = true;
                    break;
                default:
                    break;
            }
        });
        
        mainCtrl.getModal().getMainActivity().mainLayout.getScene().setOnKeyReleased(e->{
            switch (e.getCode()) {
                case CONTROL:
                    controlIsOn = false;
                    break;
                default:
                    break;
            }
        });
        
    }
    
    private void controlFunctions(Event e, KeyCode key) {
        
        switch (key) {
            case O:
                e.consume();
                mainCtrl.getModal().getMainActivity().filePathBtn.fire();
                break;
            case E:
                e.consume();
                mainCtrl.getModal().getMainActivity().encryptBtn.fire();
                break;
            case D:
                e.consume();
                mainCtrl.getModal().getMainActivity().decryptBtn.fire();
                break;
            case Q:
                e.consume();
                mainCtrl.getModal().getMainActivity().hideKeyBtn.fire();
                break;
            default:
                break;
        }
        
        controlIsOn = false;
    }
    
}