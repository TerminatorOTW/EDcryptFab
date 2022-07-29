
// Developed by the "TERMINATOR OTW"

package edcryptfab.java.controllers;

import edcryptfab.java.Modal;

public class MainCtrl {

    private Modal modal;
    
    public MainCtrl(Modal modal) {
        this.modal = modal;
        
        // setControllers
        FileFieldCtrl fileFieldCtrl = new FileFieldCtrl(this);
        KeyPathCtrl keyPathCtrl = new KeyPathCtrl(this);
        EncryptCtrl encryptCtrl = new EncryptCtrl(this);
        DecryptCtrl decryptCtrl = new DecryptCtrl(this);
        KeyCtrl keyCtrl = new KeyCtrl(this);
        
    }
    
    public Modal getModal() {
        return modal;
    }
    
}
