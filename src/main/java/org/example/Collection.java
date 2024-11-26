package org.example;
import java.util.*;

public class Collection {
    public static void main(String[] args) {
        // a) Создаем массив из N случайных чисел от 0 до 100.
        int N = 10; // Задайте нужное количество
        int[] array = new Random().ints(N, 0, 101).toArray();
        System.out.println("Массив: " + Arrays.toString(array));

        // b) Создаем список List на основе массива.
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        System.out.println("Список: " + list);

        // c) Сортируем список по возрастанию.
        Collections.sort(list);
        System.out.println("Отсортированный список по возрастанию: " + list);

        // d) Сортируем список в обратном порядке.
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Отсортированный список в обратном порядке: " + list);

        // e) Перемешиваем список.
        Collections.shuffle(list);
        System.out.println("Перемешанный список: " + list);

        // f) Циклический сдвиг на 1 элемент.
        if (!list.isEmpty()) {
            int first = list.remove(0);
            list.add(first);
        }
        System.out.println("Циклический сдвиг на 1 элемент: " + list);

        // g) Оставляем только уникальные элементы.
        Set<Integer> uniqueSet = new HashSet<>(list);
        list = new ArrayList<>(uniqueSet);
        System.out.println("Список с уникальными элементами: " + list);

        // h) Оставляем только дублирующиеся элементы.
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        list.clear();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        System.out.println("Список с дублирующимися элементами: " + list);

        // i) Получаем массив из списка.
        Integer[] newArray = list.toArray(new Integer[0]);
        System.out.println("Массив из списка: " + Arrays.toString(newArray));

        // j) Подсчитываем количество вхождений каждого числа в массив и выводим на экран.
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            System.out.println("Число " + entry.getKey() + " встречается " + entry.getValue() + " раз.");
        }
    }
}
