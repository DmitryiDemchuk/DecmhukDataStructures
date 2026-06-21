package MySorting;

import MyArrayList.MyArrayList;

public class ArrayListSorter {

    //Вспомогательный метод для обмена двух элементов в MyArrayList.
    private static void swap(MyArrayList list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }


    /**
     * Публичный метод для запуска быстрой сортировки.
     * Время работы: O(n log n). Пространство: O(log n).
     */
    public static void quickSort(MyArrayList list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        runQuickSort(list, 0, list.size() - 1);
    }

    //Рекурсивный метод быстрой сортировки.
    private static void runQuickSort(MyArrayList list, int low, int high) {
        if (low < high) {
            // Разделение массива и получение индекса опорного элемента
            int pivotIndex = partition(list, low, high);

            // Рекурсивно сортируем элементы до и после опорного
            runQuickSort(list, low, pivotIndex - 1);
            runQuickSort(list, pivotIndex + 1, high);
        }
    }


    // Метод разделения. Берет последний элемент как опорный и переносит меньшие элементы влево
    private static int partition(MyArrayList list, int low, int high) {
        int pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше или равен опорному
            if (list.get(j) <= pivot) {
                i++;
                swap(list, i, j);
            }
        }
        // Ставим опорный элемент на его правильное место
        swap(list, i + 1, high);
        return i + 1;
    }




    // Публичный метод для запуска сортировки слиянием. Время работы: гарантированно O(n log n). Стабильный алгоритм.
    public static void mergeSort(MyArrayList list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        runMergeSort(list, 0, list.size() - 1);
    }


    //Рекурсивное деление массива пополам.
    private static void runMergeSort(MyArrayList list, int left, int right) {
        if (left < right) {
            // Находим середину
            int mid = left + (right - left) / 2;

            // Сортируем левую и правую половины
            runMergeSort(list, left, mid);
            runMergeSort(list, mid + 1, right);

            // Сливаем две отсортированные половины вместе
            merge(list, left, mid, right);
        }
    }


    //Слияние двух отсортированных частей во временные массивы,а затем обратно в MyArrayList.
    private static void merge(MyArrayList list, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // Создаем временные массивы примитивов под левую и правую части
        int[] leftPart = new int[leftSize];
        int[] rightPart = new int[rightSize];

        // Копируем данные из MyArrayList во временные массивы
        for (int i = 0; i < leftSize; i++) {
            leftPart[i] = list.get(left + i);
        }
        for (int j = 0; j < rightSize; j++) {
            rightPart[j] = list.get(mid + 1 + j);
        }

        // Индексы для прохода по подмассивам и для записи в основной список
        int i = 0, j = 0;
        int k = left;

        // Слияние элементов в порядке возрастания
        while (i < leftSize && j < rightSize) {
            if (leftPart[i] <= rightPart[j]) {
                list.set(k, leftPart[i]);
                i++;
            } else {
                list.set(k, rightPart[j]);
                j++;
            }
            k++;
        }

        // Копирование оставшихся элементов левой части (если есть)
        while (i < leftSize) {
            list.set(k, leftPart[i]);
            i++;
            k++;
        }

        // Копирование оставшихся элементов правой части (если есть)
        while (j < rightSize) {
            list.set(k, rightPart[j]);
            j++;
            k++;
        }
    }
}
