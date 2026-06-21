package MyArrayList;

// Только Integer чтобы в будущем написать сортировку и не использовать Comparable
public class MyArrayList {
    private int[] elements;
    private int size = 0;
    // Начальная емкость массива по умолчанию
    private static final int DEFAULT_CAPACITY = 10;

    // Конструктор по умолчанию
    public MyArrayList() {
        this.elements = new int[DEFAULT_CAPACITY];
    }

    // Добавление элемента в конец списка (O(1) амортизированное)
    public void add(int element) {
        // Если массив заполнен, расширяем его вручную в 2 раза
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            int[] newElements = new int[newCapacity];

            // Ручное копирование элементов в новый массив
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }

            elements = newElements;
        }

        // Записываем число и увеличиваем размер
        elements[size++] = element;
    }

    // Получение элемента по индексу (O(1))
    public int get(int index) {
        // Валидация индекса напрямую
        if (index < 0 || index >= size) {
            System.out.println("Индекс больше размера массива, текущий размер" + size);
        }

        return elements[index];
    }

    // Изменение элемента по индексу
    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            System.out.println("Индекс больше размера массива, текущий размер: " + size);
            return;
        }
        elements[index] = element;
    }

    // Поиск индекса элемента по значению (O(n))
    // Возвращает индекс первого вхождения или -1, если элемент не найден
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) { // Для примитивов используем прямое сравнение через ==
                return i;
            }
        }
        return -1;
    }

    // Удаление элемента по индексу (O(n))
    public int remove(int index) {
        // Валидация индекса напрямую
        if (index < 0 || index >= size) {
            System.out.println("Индекс больше размера массива, текущий размер" + size);
        }

        // Запоминаем удаляемое значение для возврата
        int oldValue = elements[index];

        // Вручную сдвигаем все элементы после удаляемого влево на одну позицию
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        // Уменьшаем размер списка.
        size--;

        return oldValue;
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
