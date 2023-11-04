package com.proftelran.org.algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class AlgorithmsHWfour {
    public static void main(String[] args) {
        int count = 10;
        Random random = new Random();

        int[] a = IntStream.range(1, count)
                .map(e -> random.nextInt(10))
                .toArray();

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(mergeSort(a)));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2)
            return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int pos = 0;
        int i = 0;
        int j = 0;
        while (left.length > i && right.length > j) {
            if (left[i] <= right[j])
                result[pos++] = left[i++];
            else
                result[pos++] = right[j++];
        }

        while (left.length > i) {
            result[pos++] = left[i++];
        }

        while (right.length > j) {
            result[pos++] = right[j++];
        }
        return result;
    }
}