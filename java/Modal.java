
// Developed by the "TERMINATOR OTW"

package edcryptfab.java;

import edcryptfab.java.activities.MainActivity;
import edcryptfab.java.controllers.MainCtrl;
import javafx.scene.layout.BorderPane;

public class Modal {

    private final MainActivity mainActivity;
    private final MainCtrl mainCtrl;
    
    public Modal() {
        this.mainActivity = new MainActivity();
        this.mainCtrl = new MainCtrl(this);
    }
    
    public MainActivity getMainActivity() {
        return this.mainActivity;
    }
    public MainCtrl getMainCtrl() {
        return mainCtrl;
    }
    
}
