package MySorting;

import MyArrayList.MyArrayList;
import shared.Example;

import java.util.Random;

public class MySortingExample implements Example {
    @Override
    public void execute() {
        int elementsCount = 1_000_000; // Размер тестового наполнения
        Random random = new Random();

        // Создаем два списка для честного сравнения на одинаковых данных
        MyArrayList listForQuickSort = new MyArrayList();
        MyArrayList listForMergeSort = new MyArrayList();

        // Заполняем оба списка абсолютно одинаковыми случайными числами
        for (int i = 0; i < elementsCount; i++) {
            int randomNumber = random.nextInt(1_000_000);
            listForQuickSort.add(randomNumber);
            listForMergeSort.add(randomNumber);
        }

        System.out.println("Создано два списка по " + elementsCount + " элементов.");

        //Замер времени для Quick Sort
        long startQuick = System.currentTimeMillis();
        ArrayListSorter.quickSort(listForQuickSort);
        long endQuick = System.currentTimeMillis();
        long quickDuration = endQuick - startQuick;
        System.out.println("Quick Sort занял: " + quickDuration + " мс");

        // Замер времени для Merge Sort
        long startMerge = System.currentTimeMillis();
        ArrayListSorter.mergeSort(listForMergeSort);
        long endMerge = System.currentTimeMillis();
        long mergeDuration = endMerge - startMerge;
        System.out.println("Merge Sort занял: " + mergeDuration + " мс");
    }
}
