package ua.ithillel.test.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.ithillel.test.SimpleMathLibrary;

public class SimpleMathLibraryTest {

    private SimpleMathLibrary simpleMathLibrary;

    @BeforeEach
    public void setUp(){
        simpleMathLibrary = new SimpleMathLibrary();
    }

    @Test
    public void addTest_success(){
        double a = 12;
        double b = 7;

        double result = 19;
        double actualResult = simpleMathLibrary.add(a, b);

        if (result == actualResult) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
        Assertions.assertEquals(result, actualResult);
    }

    @Test
    public void subtractTest_success(){
        double a = 12;
        double b = 7;

        double result = 5;
        double actualResult = simpleMathLibrary.subtract(a, b);

        if (result == actualResult) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }

        Assertions.assertEquals(result, actualResult);
    }
}
