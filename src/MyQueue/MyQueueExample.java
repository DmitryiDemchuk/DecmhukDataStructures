package MyQueue;

import shared.Example;

public class MyQueueExample implements Example {
        @Override
        public  void execute() {
            System.out.println("-----Queue НАЧАЛО ТЕСТА-----");

            // 1. Создаем очередь для строк
            MyQueue<String> queue = new MyQueue<String>();

            // 2. Встаем в очередь (Enqueue)
            queue.enqueue("Первый");
            queue.enqueue("Второй");
            queue.enqueue("Третий");
            System.out.println("Размер очереди после добавления: " + queue.size());

            // 3. Смотрим, кто первый на выход (Peek)
            System.out.println("Кто первый в очереди (peek): " + queue.peek());

            // 4. Извлекаем элементы из начала очереди (Dequeue)
            System.out.println("Обслужен (dequeue): " + queue.dequeue());
            System.out.println("Обслужен (dequeue): " + queue.dequeue());

            // 5. Проверяем остаток после обслуживания клиентов
            System.out.println("Текущий размер очереди: " + queue.size());
            System.out.println("Кто теперь первый: " + queue.peek());
            System.out.println("Очередь пустая? " + queue.isEmpty());

            System.out.println("-----Queue КОНЕЦ ТЕСТА-----");
        }
}

