package MyBinaryTree;

public class MyBinaryTree <E extends Comparable<E>> {
    // Корень дерева
    private Node<E> root;
    // Количество элементов в дереве
    private int size = 0;

    // Внутренний класс, представляющий узел дерева
    private static class Node<E> {
        E item;
        Node<E> left;   // Ссылка на левого потомка (меньше текущего)
        Node<E> right;  // Ссылка на правого потомка (больше текущего)

        Node(E item) {
            this.item = item;
        }
    }

    // Добавление элемента в дерево (O(log n))
    public void add(E element) {
        if (element == null) {
            System.out.println("Элемент не может быть null");
        }

        Node<E> newNode = new Node<E>(element);

        // Если дерево пустое, новый узел становится корнем
        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node<E> current = root;
        while (true) {
            // Сравниваем добавляемый элемент с текущим узлом
            int compare = element.compareTo(current.item);

            if (compare < 0) {
                // Если элемент меньше, уходим в левое поддерево
                if (current.left == null) {
                    current.left = newNode; // Нашли свободное место
                    size++;
                    return;
                }
                current = current.left; // Идем дальше вниз
            } else if (compare > 0) {
                // Если элемент больше, уходим в правое поддерево
                if (current.right == null) {
                    current.right = newNode; // Нашли свободное место
                    size++;
                    return;
                }
                current = current.right; // Идем дальше вниз
            } else {
                // Если элемент уже есть в дереве, ничего не делаем
                return;
            }
        }
    }

    // Поиск элемента в дереве (O(log n))
    // Возвращает true, если элемент найден
    public boolean contains(E element) {
        if (element == null || root == null) {
            return false;
        }

        Node<E> current = root;
        while (current != null) {
            int compare = element.compareTo(current.item);

            if (compare < 0) {
                current = current.left;  // Ищем в левой ветке
            } else if (compare > 0) {
                current = current.right; // Ищем в правой ветке
            } else {
                return true; // Элемент совпал!
            }
        }

        return false; // Обошли ветку и ничего не нашли
    }

    // Получить текущее количество уникальных элементов
    public int size() {
        return size;
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return size == 0;
    }

}
