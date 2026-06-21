package MySet;

public class MyHashSet<E> {
    // Внутренний класс для узла связного списка (разрешение коллизий методом цепочек)
    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    // Массив бакетов (корзин), где каждый бакет — это начало связного списка
    private Node<E>[] table;
    // Количество элементов в множестве
    private int size = 0;
    // Вместимость массива по умолчанию
    private static final int DEFAULT_CAPACITY = 16;


    public MyHashSet() {
        this.table = (Node<E>[]) new Node[DEFAULT_CAPACITY];
    }

    // Добавление элемента в множество (O(1) в среднем)
    // Возвращает true, если элемент успешно добавлен, и false, если он уже был
    public boolean add(E element) {
        if (element == null) {
            System.out.println("Null не поддерживается в этой реализации");
        }

        // 1. Вычисляем индекс бакета с помощью хеш-кода объекта
        int bucketIndex = Math.abs(element.hashCode()) % table.length;

        // 2. Ищем элемент в связном списке этого бакета, чтобы избежать дубликатов
        Node<E> current = table[bucketIndex];
        while (current != null) {
            if (element.equals(current.item)) {
                return false; // Элемент уже есть, дубликаты игнорируем, выходим из метода
            }
            current = current.next;
        }

        // 3. Если элемента нет, добавляем его в начало списка этого бакета (быстрая вставка)
        Node<E> newNode = new Node<>(element, table[bucketIndex]);
        table[bucketIndex] = newNode;
        size++;
        return true;
    }

    // Проверка наличия элемента в множестве (O(1))
    public boolean contains(E element) {
        if (element == null || size == 0) {
            return false;
        }

        int bucketIndex = Math.abs(element.hashCode()) % table.length;
        Node<E> current = table[bucketIndex];

        // Проходим по цепочке в бакете
        while (current != null) {
            if (element.equals(current.item)) {
                return true; // Нашли совпадение
            }
            current = current.next;
        }

        return false; // Обойдена вся цепочка, элемента нет
    }

    // Удаление элемента из множества (O(1) в среднем)
    // Возвращает true, если элемент был найден и удален
    public boolean remove(E element) {
        if (element == null || size == 0) {
            return false;
        }

        int bucketIndex = Math.abs(element.hashCode()) % table.length;
        Node<E> current = table[bucketIndex];
        Node<E> previous = null;

        while (current != null) {
            if (element.equals(current.item)) {
                // Если удаляем первый элемент в бакете
                if (previous == null) {
                    table[bucketIndex] = current.next;
                } else {
                    // Если удаляем элемент из середины или конца цепочки
                    previous.next = current.next;
                }
                size--;
                return true; // Выходим из метода
            }
            previous = current;
            current = current.next;
        }

        return false; // Элемент не найден
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
