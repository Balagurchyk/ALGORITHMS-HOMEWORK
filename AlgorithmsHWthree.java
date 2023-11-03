package com.proftelran.org.algorithms;

public class AlgorithmsHWthree {

    static int FibonacciRecursion(int n) {
        if (n <= 1) {
            return n;
        } else {
            return FibonacciRecursion(n - 1) + FibonacciRecursion(n - 2);
        }
    }
    static int FibonacciIteration(int n) {
        if (n <= 1) {
            return n;
        } else {
            int n0 = 0;
            int n1 = 1;
            for (int i = 2; i <= n; i++) {
                int n2 = n0 + n1;
                n0 = n1;
                n1 = n2;
            }
            return n1;
        }
    }

    public static void main(String[] args) {
        int n = 10;

//        for (int i = 0; i < n; i++) {
//            System.out.print(" " + FibonacciRecursion(i));
//        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(" " + FibonacciIteration(i));
        }
    }
}

//        Рекурсивный метод требует значительно больше времени и вызывает функцию рекурсии 10 раз для первых
//        10 чисел Фибоначчи. Сложность алгоритма: O(2^n).
//        Итеративный метод работает намного быстрее и требует только n итераций цикла для n чисел Фибоначчи.
//        Сложность алгоритма: O(n).
//        Чем больше n, тем дольше работает рекурсивный метод.
