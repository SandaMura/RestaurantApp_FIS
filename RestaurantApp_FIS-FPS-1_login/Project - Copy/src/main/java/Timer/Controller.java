package Timer;

import App.RestaurantApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.*;
import logIn.services.DBUtils;

import java.io.IOException;
import java.util.Objects;


import javafx.fxml.FXML;

import Timer.Time;

//import javax.swing.text.html.ImageView;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static logIn.services.DBUtils.AlertBox;

public class Controller{

    @FXML
         private Button stopwatchCook;

    @FXML
         private Button stopwatchClient;

    @FXML
            private ImageView picture;

    Time stopwatch;
    public void stopwatchCook(ActionEvent actionEvent) {
        stopwatch = new Time();

    }


    public void stopwatchClient(ActionEvent actionEvent) {
          AlertBox(" Your order is in progress for : \n" +  stopwatch.hours_string+ " hours, "+ stopwatch.minutes_string+ " minutes, "+ stopwatch.seconds_string+ " seconds  ! \n It will take approximately as the prep time specified in the menu! Thank you for your patience!");
    }
}