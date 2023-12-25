package com.proftelran.org.algorithms.sorts;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {29, 10, 14, 37, 13, 54, 83, 12, 89, 36, 47, 57};

        System.out.println("Исходный массив: " + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("Отсортированный массив: " + Arrays.toString(array));
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Находим опорный элемент, который послужит границей между элементами меньше и больше опорного
            int partitionIndex = partition(array, low, high);

            // Рекурсивно сортируем оба подмассива
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // Выбираем опорный элемент (в данном случае, средний элемент)
        int pivot = array[(low + high) / 2];

        // Делаем два указателя для прохода через массив
        int i = low - 1;
        int j = high + 1;

        // Пока указатели не пересекутся
        while (true) {
            // Находим элемент слева, который больше опорного
            do {
                i++;
            } while (array[i] < pivot);

            // Находим элемент справа, который меньше опорного
            do {
                j--;
            } while (array[j] > pivot);

            // Если указатели не пересеклись, меняем элементы местами
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            } else {
                // Указатели пересеклись, возвращаем правый указатель
                return j;
            }
        }
    }
}
