package shared;

import MyBinaryTree.MyBinaryTreeExample;
import MyList.MyLinkedListExample;
import MyQueue.MyQueueExample;
import MySet.MyHashSetExample;
import MySorting.MySortingExample;
import MyStack.MyStackExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExamplePicker {
    private final Map<Integer, Example> examples = Map.of(
            1, new MyBinaryTreeExample(),
            2, new MyLinkedListExample(),
            3, new MyQueueExample(),
            4, new MyHashSetExample(),
            5, new MySortingExample(),
            6, new MyStackExample()
    );

    public void executeSelected() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Список доступных примеров:");
        System.out.println("1 - MyBinaryTreeExample");
        System.out.println("2 - MyLinkedListExample");
        System.out.println("3 - MyQueueExample");
        System.out.println("4 - MyHashSetExample");
        System.out.println("5 - MySortingExample");
        System.out.println("6 - MyStackExample");

        System.out.println("Введите номера примеров через пробел (например: 1 3 5):");

        String input = scanner.nextLine();
        String[] tokens = input.split("\\s+");

        for (String token : tokens) {
            try {
                int key = Integer.parseInt(token);

                if (examples.containsKey(key)) {
                    examples.get(key).execute();
                } else {
                    System.out.println("Пример с номером " + key + " не найден.");
                }
            } catch (NumberFormatException e) {
                System.out.println("'" + token + "' не является корректным числом.");
            }
        }
    }
}
