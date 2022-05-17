package firstTest;

import com.example.project.TestingCalculation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;



public class TestingTests{


private final TestingCalculation calculator = new TestingCalculation();


        @Test
public void testAddition(){
        int actualResult = calculator.add(1, 1);

        Assertions.assertEquals(2, actualResult);

        }


        }