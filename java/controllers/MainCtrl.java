
// Developed by the "TERMINATOR OTW"

package edcryptfab.java.controllers;

import edcryptfab.java.Modal;

public class MainCtrl {

    private final Modal modal;
    
    public FileFieldCtrl fileFieldCtrl;
    public KeyPathCtrl keyPathCtrl;
    public EncryptCtrl encryptCtrl;
    public DecryptCtrl decryptCtrl;
    public KeyCtrl keyCtrl;
    public DragDropCtrl dragDropCtrl;
    
    public MainCtrl(Modal modal) {
        this.modal = modal;
        
        // setControllers
        this.fileFieldCtrl = new FileFieldCtrl(this);
        this.keyPathCtrl = new KeyPathCtrl(this);
        this.encryptCtrl = new EncryptCtrl(this);
        this.decryptCtrl = new DecryptCtrl(this);
        this.keyCtrl = new KeyCtrl(this);
        this.dragDropCtrl = new DragDropCtrl(this);
        
    }
    
    public Modal getModal() {
        return modal;
    }
    
}
