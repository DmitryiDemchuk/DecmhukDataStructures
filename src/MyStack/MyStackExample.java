package MyStack;

import shared.Example;

public class MyStackExample implements Example {
    @Override
    public  void execute() {
        System.out.println("-----Stack НАЧАЛО ТЕСТА-----");

        // 1. Создаем стек для хранения чисел
        MyStack<Integer> stack = new MyStack<Integer>();

        // 2. Добавляем элементы
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Размер стека после 3 добавлений: " + stack.size());

        // 3. Смотрим верхний элемент без удаления
        System.out.println("Элемент на вершине (peek): " + stack.peek()); // Ожидаем 30
        System.out.println("Размер стека не изменился: " + stack.size());

        // 4. Извлекаем элементы с вершины
        System.out.println("Извлекли элемент (pop): " + stack.pop()); // Ожидаем 30
        System.out.println("Извлекли элемент (pop): " + stack.pop()); // Ожидаем 20

        // 5. Проверяем остаток
        System.out.println("Текущий размер стека: " + stack.size()); // Ожидаем 1
        System.out.println("Элемент на вершине теперь: " + stack.peek()); // Ожидаем 10
        System.out.println("Стек пустой? " + stack.isEmpty()); // false

        System.out.println("-----Stack КОНЕЦ ТЕСТА-----");
    }
}
