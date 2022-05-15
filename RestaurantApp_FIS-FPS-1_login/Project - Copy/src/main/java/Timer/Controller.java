/*package Timer;

import App.RestaurantApplication;
import Timer.Time;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static logIn.services.DBUtils.AlertBox;


public class Controller implements Initializable {
        Time time = new Time("0:0:0");


        @FXML
        private Text timer;

        @FXML
        private TextField alarmTime;

        Timeline timeline= new Timeline(
                new KeyFrame(Duration.seconds(0.1),
                        e-> {
                            if(time.getCurrentTime().equals(alarmTime.getText())){
                                System.out.println("TIME IS UP!");
                                Stage stage;
                                Parent root;
                                stage = (Stage) timer.getScene().getWindow();
                                try {
                                    root = FXMLLoader.load(RestaurantApplication.class.getClassLoader().getResource("Customer_view.fxml"));
                                    stage.setScene(new Scene(root, 600, 450));
                                    stage.show();
                                } catch (IOException exception) {
                                    exception.printStackTrace();
                                }
                                AlertBox("TIME IS UP! You will soon recieve your order");

                            }
                            time.oneSecondPassed();
                            timer.setText(time.getCurrentTime());
                        }));


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            timer.setText(time.getCurrentTime());

            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
    }
*/
