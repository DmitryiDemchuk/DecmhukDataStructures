package MyList;

public class MyLinkedList<E> {
    // ссылки на крайние элементы всего списка
    private Node<E> first;
    private Node<E> last;

    private int size = 0;

    //класс узел из которых состоит список
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.item = element;
            this.next = next;
        }
    }

    // Добавление элемента в конец списка (O(1))
    public void add(E element) {
        Node<E> l = last;
        Node<E> newNode = new Node<E>(l, element, null);
        last = newNode;

        if (l == null) {
            first = newNode; // Если список был пуст, новый узел становится и первым
        } else {
            l.next = newNode; // Связываем предыдущий последний узел с новым
        }
        size++;
    }

    // Получение элемента по индексу (O(n))
    public E get(int index) {

        if (index < 0 || index >= size) {
            System.out.println("Некорректный индекс");
        }

        // Прямой последовательный перебор от начала до нужного индекса
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.item;
    }

    // Получение элемента по значению (O(n))
    public E get(E value){
        for (Node<E> current = first; current != null; current = current.next) {
            if (value.equals(current.item)) {//equals вместо == чтобы сравнить значения а не ссылки на объекты
                return current.item;
            }
        }

        return null;
    }

    // Удаление элемента по индексу (O(n))
    public E remove(int index) {

        if (index < 0 || index >= size) {
            System.out.println("Некорректный индекс");
        }

        Node<E> target = first;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }

        // Сохраняем значения для возврата и изменения связей
        final E element = target.item;
        final Node<E> next = target.next;
        final Node<E> prev = target.prev;

        // Корректируем ссылку у предыдущего узла
        if (prev == null) {
            first = next; // Если удаляем первый, то следующий становится первым
        } else {
            prev.next = next;
            target.prev = null;
        }

        // Корректируем ссылку у следующего узла
        if (next == null) {
            last = prev; // Если удаляем последний, то предыдущий становится последним
        } else {
            next.prev = prev;
            target.next = null;
        }

        target.item = null;
        size--;

        return element;
    }

    // Возвращает текущий размер списка
    public int size() {
        return size;
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return size == 0;
    }
}