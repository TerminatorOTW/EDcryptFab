
// Developed by the "TERMINATOR OTW"

package edcryptfab.java.activities;

import edcryptfab.ResourceLoader;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class MainActivity {

    public BorderPane mainLayout;
    
    public Label fileLabel, folderLabel, keyLabel, statusLabel, orLabel;
    public TextField fileField, folderField, keyField;
    public PasswordField keyHiddenField;
    public StackPane keyLayout;
    public Button filePathBtn, folderPathBtn, hideKeyBtn, encryptBtn, decryptBtn;
    public HBox titleBar, bottomBar;
    public GridPane centreLayout;
    public ImageView invisibleView, visibleView;
    public Image visibleIcon, invisibleIcon, folderIconBlack, folderIconGrey;
    
    private final ResourceLoader resLoader = new ResourceLoader();
    
    public MainActivity() {
        
        this.mainLayout = new BorderPane();
        this.mainLayout.getStyleClass().add("main-layout");
        
        // intialize images
        this.visibleIcon = resLoader.loadImages("visible_icon.png");
        this.invisibleIcon = resLoader.loadImages("invisible_icon.png");
        this.folderIconBlack = resLoader.loadImages("folder_black_icon.png");
        this.folderIconGrey = resLoader.loadImages("folder_grey_icon.png");
        
        // intialize layouts
        this.init_centreLayout();
        this.init_BottomBar();
        
        //mainLayout.setTop(titleBar);
        this.mainLayout.setCenter(centreLayout);
        this.mainLayout.setBottom(bottomBar);
        
        // set stylesheet
        this.mainLayout.getStylesheets().add(
            new ResourceLoader().loadStylesheet("myStyle.css").toExternalForm()
        );
        
    }
    
    private void init_centreLayout() {
        
        final Insets margin = new Insets(0, 0, 0, 10);
        
        this.fileLabel = new Label("File Path");
        GridPane.setConstraints(fileLabel, 0, 0);
        //GridPane.setMargin(fileLabel, margin1);
        
        this.fileField = new TextField();
        fileField.setEditable(false);
        GridPane.setConstraints(fileField, 0, 1);
        
        ImageView fileImageView = new ImageView();
        fileImageView.setFitHeight(28);
        fileImageView.setFitWidth(28);
        fileImageView.setImage(folderIconBlack);
        
        this.filePathBtn = new Button();
        this.filePathBtn.setGraphic(fileImageView);
        GridPane.setConstraints(filePathBtn, 1, 1);
        GridPane.setMargin(filePathBtn, margin);
        /*
        this.orLabel = new Label("or,");
        this.orLabel.getStyleClass().add("or-label");
        GridPane.setConstraints(orLabel, 0, 2);
        GridPane.setHalignment(orLabel, HPos.CENTER);
        
        this.folderLabel = new Label("Folder Path");
        GridPane.setConstraints(folderLabel, 0, 3);
        //GridPane.setMargin(folderLabel, margin);
        
        this.folderField = new TextField();
        folderField.setEditable(false);
        GridPane.setConstraints(folderField, 0, 4);
        
        ImageView folderImageView = new ImageView();
        folderImageView.setFitHeight(28);
        folderImageView.setFitWidth(28);
        folderImageView.setImage(folderIconBlack);
        
        this.folderPathBtn = new Button();
        this.folderPathBtn.setGraphic(folderImageView);
        GridPane.setConstraints(folderPathBtn, 1, 4);
        //GridPane.setMargin(folderPathBtn, margin);
        */
        this.keyLabel = new Label("Key (Maximum upto 16-digit)");
        GridPane.setConstraints(keyLabel, 0, 5);
        
        this.keyLayout = new StackPane();
        GridPane.setConstraints(keyLayout, 0, 6);
        
        this.keyField = new TextField();
        this.keyField.setVisible(false);
        
        this.keyHiddenField = new PasswordField();
        
        this.keyLayout.getChildren().addAll(keyField, keyHiddenField);
        
        visibleView = new ImageView();
        visibleView.setFitHeight(28);
        visibleView.setFitWidth(28);
        visibleView.setImage(visibleIcon);
        
        invisibleView = new ImageView();
        invisibleView.setFitHeight(28);
        invisibleView.setFitWidth(28);
        invisibleView.setImage(invisibleIcon);
        
        this.hideKeyBtn = new Button();
        this.hideKeyBtn.setGraphic(invisibleView);
        GridPane.setConstraints(hideKeyBtn, 1, 6);
        GridPane.setMargin(hideKeyBtn, margin);
        
        this.statusLabel = new Label("Status: IDLE");
        GridPane.setConstraints(statusLabel, 0, 7);
        
        this.centreLayout = new GridPane();
        this.centreLayout.getStyleClass().add("centre-layout");
        this.centreLayout.getChildren().addAll(
            fileLabel, fileField, filePathBtn,/* orLabel, folderLabel, folderField, folderPathBtn,*/
            keyLabel, keyLayout, hideKeyBtn, statusLabel
        );
        
    }
    
    private void init_BottomBar() {
        
        this.encryptBtn = new Button("Encrypt");
        this.encryptBtn.getStyleClass().add("encrypt-btn");
        
        this.decryptBtn = new Button("Decrypt");
        this.decryptBtn.getStyleClass().add("decrypt-btn");
        
        this.bottomBar = new HBox();
        this.bottomBar.getStyleClass().add("bottom-bar");
        this.bottomBar.getChildren().addAll(encryptBtn, decryptBtn);
        
        Platform.runLater(()->{
            double width = this.bottomBar.getWidth()/2;
            this.encryptBtn.setPrefWidth(width);
            this.decryptBtn.setPrefWidth(width);
        });
        
    }
    
}
