package com.proftelran.org.algorithms;

import java.util.Stack;

        /*Задача getMin().
        Реализовать структуру данных SpecialStack, которая поддерживает все операции со стеком, 
        такие как push(), pop(), isEmpty(), … и дополнительную операцию getMin(), которая должна 
        возвращать минимальный элемент из SpecialStack.
        Все эти операции SpecialStack должны быть O(1). Пространство O(n)
        Чтобы реализовать SpecialStack, используйте структуру данных Stack, реализованную ранее в классе.*/

public class SpecialStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public SpecialStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int item) {
        // Push элемента в основной стек
        mainStack.push(item);

        // Если минимальный стек пуст или текущий элемент меньше или равен минимальному,
        // то push элемента в минимальный стек
        if (minStack.isEmpty() || item <= minStack.peek()) {
            minStack.push(item);
        }
    }

    public int pop() {
        // Если основной стек пуст, возвращаем -1 (или другое значение по вашему выбору)
        if (mainStack.isEmpty()) {
            return -1; // или бросить исключение, если предпочтительно
        }

        // Получаем верхний элемент из основного стека
        int poppedItem = mainStack.pop();

        // Если удаленный элемент был минимальным, удаляем его из минимального стека
        if (poppedItem == minStack.peek()) {
            minStack.pop();
        }

        return poppedItem;
    }

    public int getMin() {
        // Возвращаем верхний элемент минимального стека
        return minStack.peek();
    }

    public boolean isEmpty() {
        // Проверяем, пуст ли основной стек
        return mainStack.isEmpty();
    }

    public static void main(String[] args) {
        SpecialStack specialStack = new SpecialStack();
        specialStack.push(3);
        specialStack.push(5);
        System.out.println("Минимальный элемент: " + specialStack.getMin());  // Вывод: 3
        specialStack.push(2);
        System.out.println("Минимальный элемент: " + specialStack.getMin());  // Вывод: 2
        specialStack.push(1);
        System.out.println("Минимальный элемент: " + specialStack.getMin());  // Вывод: 1
        specialStack.pop();
        System.out.println("Минимальный элемент после pop: " + specialStack.getMin());  // Вывод: 2
    }
}
