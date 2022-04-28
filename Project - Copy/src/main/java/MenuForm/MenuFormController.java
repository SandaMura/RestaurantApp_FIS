package MenuForm;


import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;


public class MenuFormController{

    @FXML
    private Button Button_attach;
    private Button Button_submit;
    @FXML
    private ScrollPane ScrollingForm1;

    Stage stage;

    public void setButton_attach(ActionEvent event){
       /* stage = (Stage) ScrollingForm1.getScene().getWindow();
        System.out.println("You successfully logged out");
        stage.close();*/

        /*JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        //txt_filename.setText(filename);///show address of the image
        Image getPath = null;
        ImageIcon icon = new ImageIcon(filename);
        Image image = icon.getImage().getScaledInstance(100, 200,Image.SCALE_SMOOTH );*/

    }

    public void setButton_submit(ActionEvent event){

    }
}

