package ua.ithillel.test.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.ithillel.test.ArraysMethods;

public class ArraysMethodsTest {

    @Test
    public void intsAfterLastFourthTest_success(){
        int[] innerArray = new int[]{1, 2, 3 ,5, 4, 5, 5, 6};
        int[] result = new int[]{5, 5, 6};

        int[] actualResult = ArraysMethods.intsAfterLastFourth(innerArray);

        Assertions.assertArrayEquals(result, actualResult);
    }

    @Test
    public void intsAfterLastFourthTest_throeException(){
        int[] innerArray = new int[]{1, 2, 3 ,5, 5, 5, 6};
        Assertions.assertThrows(RuntimeException.class, () -> {
            ArraysMethods.intsAfterLastFourth(innerArray);
        });
    }

    @Test
    public void intsAfterLastFourthTest_returnNull(){
        int[] innerArray = null;
        Assertions.assertNull(ArraysMethods.intsAfterLastFourth(innerArray));
    }

    @Test
    public void containsOnlyOnesAndFours_success(){
        int[] innerArray = new int[]{1, 4, 1, 4, 4, 1};
        Assertions.assertTrue(ArraysMethods.containsOnlyOnesAndFours(innerArray));
    }

    @Test
    public void containsOnlyOnesAndFours_failedJustOne(){
        int[] innerArray = new int[]{1, 1, 1};
        Assertions.assertFalse(ArraysMethods.containsOnlyOnesAndFours(innerArray));
    }

    @Test
    public void containsOnlyOnesAndFours_failedJustFour(){
        int[] innerArray = new int[]{4, 4, 4};
        Assertions.assertFalse(ArraysMethods.containsOnlyOnesAndFours(innerArray));
    }

    @Test
    public void containsOnlyOnesAndFours_failedJustOtherDigits(){
        int[] innerArray = new int[]{1, 1, 4, 4, 4, 5};
        Assertions.assertFalse(ArraysMethods.containsOnlyOnesAndFours(innerArray));
    }

}
