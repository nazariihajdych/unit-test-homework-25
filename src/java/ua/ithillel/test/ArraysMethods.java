package ua.ithillel.test;

import java.util.Arrays;

public class ArraysMethods {

    public static int[] intsAfterLastFourth(int[] array){
        if (array != null){
            int lastIndex = -1;

            for (int i = 0; i < array.length; i++) {
                if (array[i] == 4) {
                    lastIndex = i;
                }
            }

            if (lastIndex == -1) {
                throw new RuntimeException("Не знайдено цифри 4");
            }

            int[] result = new int[array.length - lastIndex - 1];
            System.arraycopy(array, lastIndex + 1, result, 0, result.length);

            return result;
        }
        return null;
    }

    public static boolean containsOnlyOnesAndFours(int[] array) {
        boolean containsOne = false;
        boolean containsFour = false;

        for (int num : array) {
            if (num == 1) {
                containsOne = true;
            } else if (num == 4) {
                containsFour = true;
            } else {
                return false;
            }
        }

        return containsOne && containsFour;
    }
}
