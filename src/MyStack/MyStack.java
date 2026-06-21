package MyStack;


public class MyStack<E> {
    // Внутренний массив для хранения элементов
    private Object[] elements;
    // Количество элементов в стеке и также указывает на индекс следующей свободной ячейки
    private int size = 0;
    // Начальная емкость массива
    private static final int DEFAULT_CAPACITY = 10;


    public MyStack() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    // Поместить элемент на вершину стека (O(1))
    public void push(E item) {
        // Логика расширения массива напрямую: если массив заполнен, увеличиваем его в 2 раза
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newElements = new Object[newCapacity];
            // копирование элементов
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }

            elements = newElements;
        }

        // Добавляем элемент и увеличиваем размер
        elements[size++] = item;
    }

    // Извлечь элемент с вершины стека с его удалением (O(1))
    public E pop() {
        if (size == 0) {
            System.out.println("Пустой стек");
        }

        // Берем верхний элемент
        int lastIndex = size - 1;
        E item =  (E)elements[lastIndex]; //приведение от Object к E

        // Очищаем ячейку для сборщика мусора и уменьшаем размер
        elements[lastIndex] = null;
        size--;

        return item;
    }

    // Посмотреть элемент на вершине стека без удаления (O(1))
    public E peek() {
        if (size == 0) {
            System.out.println("Пустой стек");
        }

        return (E) elements[size - 1];
    }

    // Проверить, пуст ли стек
    public boolean isEmpty() {
        return size == 0;
    }

    // Получить текущее количество элементов в стеке
    public int size() {
        return size;
    }
}