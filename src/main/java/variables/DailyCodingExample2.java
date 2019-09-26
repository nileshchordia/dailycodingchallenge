package variables;

import java.util.ArrayList;
import java.util.List;

public class DailyCodingExample2 {
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] finalResult = new int[arr.length];

        /**
         * Approach 1 orderof(n)  -->using division
         */
        int mul = arr[0];
        for (int i = 1; i < arr.length; i++) {
            mul *= arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            finalResult[i] = mul / arr[i];
        }
        System.out.println("Using Division");
        print(finalResult);

        /**
         * Approach 2 orderof(n)  -->with out using division
         */
        int[] finalA = new int[arr.length];
        int[] finalB = new int[arr.length];
        int[] finalResult2 = new int[arr.length];


        mul = arr[0];
        finalA[0] = mul;
        for (int i = 1; i < arr.length; i++) {
            mul *= arr[i];
            finalA[i] = mul;
        }

        int length = arr.length - 1;
        mul = arr[length];
        finalB[length] = arr[length];

        for (int i = length - 1; i >= 0; i--) {
            mul *= arr[i];
            finalB[i] = mul;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && i < arr.length - 1) {
                count = finalA[i - 1] * finalB[i + 1];
            }
            if (i == 0) {
                count = finalB[i + 1];
            }
            if (i == arr.length - 1) {
                count = finalA[i - 1];
            }
            finalResult2[i] = count;
        }
        System.out.println("WITH OUT USING DIVISION");
        print(finalResult2);
    }

    private static void print(int[] finalResult) {
        for (int i = 0; i < finalResult.length; i++) {
            System.out.println(finalResult[i]);
        }
    }
}
