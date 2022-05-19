package firstTest;

import com.example.project.TestingCalculation;
/*
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.io.;

import org.testfx.api.FxAssert;

import org.testfx.matcher.control.LabeledMatchers;

import org.testfx.assertions.api.Assertions;*/

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.loose.fis.sre.services.FileSystemService;
//import org.loose.fis.sre.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.testfx.assertions.api.Assertions.assertThat;



import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
//import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
//mport org.loose.fis.sre.model.User;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;
public class TestingTests{


private final TestingCalculation calculator = new TestingCalculation();


        @Test
public void testAddition(){
        int actualResult = calculator.add(1, 1);

        Assertions.assertThat(2).isEqualTo(actualResult);

        }


        }