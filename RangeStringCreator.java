package com.proftelran.org.algorithms.algorithmshomeworkseven;

import java.util.ArrayList;
import java.util.List;

//        дан массив чисел, нужно создать строку с указанием ренжей
//        Пример: 0,1,2,3,4,5,6,9,11,12 -> "0-6,9,11-12"

public class RangeStringCreator {

    public static String createRangeString(int[] arr) {
        List<String> result = new ArrayList<>();
        int start = arr[0];
        int end = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == end + 1) {
                end = arr[i];
            } else {
                if (start == end) {
                    result.add(Integer.toString(start));
                } else {
                    result.add(start + "-" + end);
                }
                start = end = arr[i];
            }
        }

        if (start == end) {
            result.add(Integer.toString(start));
        } else {
            result.add(start + "-" + end);
        }

        return String.join(",", result);
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 9, 11, 12};
        String resultString = createRangeString(arr);
        System.out.println(resultString);
    }
}

