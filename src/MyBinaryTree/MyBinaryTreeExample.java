package MyBinaryTree;

import shared.Example;

public class MyBinaryTreeExample implements Example {
    @Override
    public void execute() {
        System.out.println("-----BinaryTree НАЧАЛО ТЕСТА-----");

        // Создаем дерево для чисел
        MyBinaryTree<Integer> tree = new MyBinaryTree<Integer>();

        // 1. Добавляем элементы
        tree.add(50); // Корень
        tree.add(30); // Уйдет влево от 50
        tree.add(70); // Уйдет вправо от 50
        tree.add(20); // Уйдет влево от 30
        tree.add(40); // Уйдет вправо от 30

        System.out.println("Количество элементов в дереве: " + tree.size()); // Ожидаем 5

        // 2. Тестируем поиск (contains)
        System.out.println("Содержит 40? " + tree.contains(40)); // Ожидаем true
        System.out.println("Содержит 70? " + tree.contains(70)); // Ожидаем true
        System.out.println("Содержит 99? " + tree.contains(99)); // Ожидаем false

        // 3. Попытка добавить дубликат
        tree.add(30);
        System.out.println("Размер после добавления дубликата 30: " + tree.size()); // Все еще 5

        System.out.println("-----BinaryTree КОНЕЦ ТЕСТА-----");
    }
}
