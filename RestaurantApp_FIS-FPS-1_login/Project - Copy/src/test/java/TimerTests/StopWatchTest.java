package TimerTests;

import Timer.Time;


import logIn.exceptions.UsernameAlreadyExistsException;
import logIn.model.User;
import logIn.services.FileSystemService;
import logIn.services.UserService;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import logIn.exceptions.UsernameAlreadyExistsException;
import logIn.model.User;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;

import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
public class StopWatchTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before Class");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After Class");
    }

    @BeforeEach
    void setUp() throws Exception {
     //   FileSystemService.setAppFolder("database-registration-example");
       // FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        //UserService.initDatabase();
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each");
    }

    @Test
    void testStartStopButtons(){
        Time stopwatch=new Time();
        assertThat(stopwatch).isNotNull();
        stopwatch.start();

        stopwatch.seconds++;
        stopwatch.seconds++;

        assertThat(stopwatch.seconds).isEqualTo(2);

        stopwatch.stop();
        assertThat(stopwatch.seconds).isEqualTo(2);


    }

    @Test
    void testStartResetButtons(){
        Time stopwatch=new Time();
        assertThat(stopwatch).isNotNull();
        stopwatch.start();

        stopwatch.seconds++;
        stopwatch.seconds++;

        assertThat(stopwatch.seconds).isEqualTo(2);

        stopwatch.reset();
        assertThat(stopwatch.seconds).isEqualTo(0);


    }

}
