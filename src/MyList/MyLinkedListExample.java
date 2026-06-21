package MyList;

import shared.Example;

public class MyLinkedListExample implements Example {
    public void execute() {
        System.out.println("-----LinkedList НАЧАЛО ТЕСТА-----");

        // 1. Создаем список для тестирования
        MyLinkedList<String> list = new MyLinkedList<>();

        // 2. Тестируем добавление элементов
        list.add("Java");
        list.add("Python");
        list.add("C++");
        System.out.println("Размер после добавления 3 элементов: " + list.size());

        // 3. Тестируем получение по индексу
        System.out.println("Элемент под индексом 0: " + list.get(0));
        System.out.println("Элемент под индексом 1: " + list.get(1));
        System.out.println("Элемент под индексом 2: " + list.get(2));

        String missingElement = list.get("JavaScript");
        System.out.println("Поиск отсутствующего 'JavaScript': " + missingElement);

        // 5. Тестируем удаление по индексу
        String removedElement = list.remove(1); // Удаляем "Python"
        System.out.println("Удален элемент: " + removedElement);
        System.out.println("Новый размер списка: " + list.size());
        System.out.println("Элемент, сместившийся на индекс 1: " + list.get(1));

        System.out.println("-----LinkedList КОНЕЦ ТЕСТА-----");
    }
}
