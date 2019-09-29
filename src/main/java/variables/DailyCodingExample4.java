package variables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DailyCodingExample4 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 0};
//        int[] array = new int[]{3, 4, -1, 1};
//        int[] array = new int[]{2, 3, -7, 6, 8, 1, -10, 15};
//        int[] array = new int[]{2, 3, 7, 6, 8, -1, -10, 15};


        /**
         * naive approach orderof(n**2)
         *start from 1 and iterate until we found the missing positive element
         */


        /**
         * general approach  --> sort and iterate ---> orderof(nlogn)
         */
        Arrays.sort(array);
        boolean gotNumber = false;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1] + 1 && array[i] > 1) {
                if (array[i - 1] <= 0) {
                    System.out.println(array[i] - 1);
                } else {
                    System.out.println(array[i - 1] + 1);
                }
                gotNumber = true;
                break;
            }
        }

        if (gotNumber == false) {
            System.out.println(array[array.length - 1] + 1);
        }

/**
         *  hashset approach  -----> t.c =orderof(n)  and s.c = orderof(n)
 *
 *  **/



        int min = array[0];
        int max = array[0];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }

        }

        for (int i = min; i <= max + 1; i++) {
            if (i <= 0) {
                continue;
            }
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }

        }

        /**
         * special Approach t.c=orderof(n) and s.c =orderof(1)
         */
        System.out.println(findMissing(array, array.length));

    }

    private static int findMissing(int[] array, int length) {
        int shift = segerate(array, length);
        int[] arr2 = new int[length - shift];
        int j = 0;
        for (int i = shift; i < length; i++) {
            arr2[j] = array[i];
            j++;
        }
        return findMisingPositiveNumber(arr2, j);
    }

    private static int findMisingPositiveNumber(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            int abs = Math.abs(array[i]);

            if(abs-1<size && abs>0){
                array[abs-1]=-array[abs-1];
            }

        }

        for (int i = 0; i < size; i++) {
            if(array[i]>0){
                return i+1;
            }
        }
        return size+1;

    }

    private static int segerate(int[] array, int length) {
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 0) {
                int temp = array[i];
                array[i] = array[j];
                j++;
            }
        }
        return j;
    }
}
