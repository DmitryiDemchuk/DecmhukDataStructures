package MySet;

import shared.Example;

public class MyHashSetExample implements Example {
    @Override
    public void execute() {
        System.out.println("-----Set НАЧАЛО ТЕСТА-----");

        MyHashSet<String> set = new MyHashSet<>();

        // 1. Добавляем уникальные элементы
        System.out.println("Добавлен 'Java': " + set.add("Java"));
        System.out.println("Добавлен 'Python': " + set.add("Python"));
        System.out.println("Добавлен 'C++': " + set.add("C++"));
        System.out.println("Размер множества: " + set.size());

        // 2. Пытаемся добавить дубликат
        System.out.println("Добавлен 'Java' повторно: " + set.add("Java")); // false!

        System.out.println("Размер после дубликата: " + set.size()); // Все еще 3

        // 3. Проверяем наличие элементов (contains)
        System.out.println("Содержит 'Python'? " + set.contains("Python"));
        System.out.println("Содержит 'Ruby'? " + set.contains("Ruby"));

        // 4. Проверяем удаление
        System.out.println("Удален 'Python'? " + set.remove("Python")); // true
        System.out.println("Содержит 'Python' теперь? " + set.contains("Python")); // false
        System.out.println("Итоговый размер: " + set.size()); // Ожидаем 2

        System.out.println("-----Set КОНЕЦ ТЕСТА-----");
    }
}
