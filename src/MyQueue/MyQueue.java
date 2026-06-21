package MyQueue;

public class MyQueue<E> {
    private Object[] elements;
    private int size = 0;
    // Начальная емкость очереди
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueue() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    // Добавить элемент в конец очереди(то же самое что и у стека)
    public void enqueue(E item) {
        // Если массив заполнен, расширяем его вручную в 2 раза
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newElements = new Object[newCapacity];

            // Ручное копирование элементов
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }

            elements = newElements;
        }

        // Добавляем новый элемент в самый конец
        elements[size++] = item;
    }

    // Извлечь первый элемент из начала очереди с его удалением
    public E dequeue() {
        if (size == 0) {
            System.out.println("Очередь пуста");
        }

        // Первый элемент всегда находится на индексе 0
        E item = (E) elements[0];

        // Сдвигаем все оставшиеся элементы влево на одну позицию вручную
        for (int i = 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }

        elements[size - 1] = null;
        size--;

        return item;
    }

    // Посмотреть первый элемент в начале очереди без удаления (аналог peek/element)
    public E peek() {
        if (size == 0) {
            System.out.println("Очередь пуста");
        }

        return (E) elements[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
