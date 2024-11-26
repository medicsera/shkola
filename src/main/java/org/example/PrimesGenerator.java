package org.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class PrimesGenerator {
    public static List<Integer> generatePrimes(int N) {
        List<Integer> primes = new LinkedList<>();
        int count = 0;
        int number = 2; // Первое простое число
        while (count < N) {
            if (isPrime(number)) {
                primes.add(number);
                count++;
            }
            number++;
        }
        return primes;
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

class PrimesGeneratorTest {
    public static void main(String[] args) {
        int N = 10; // Задайте количество простых чисел
        List<Integer> primes = PrimesGenerator.generatePrimes(N);

        // Прямой порядок
        System.out.println("Простые числа в прямом порядке:");
        for (Integer prime : primes) {
            System.out.print(prime + " ");
        }

        // Обратный порядок
        System.out.println("\nПростые числа в обратном порядке:");
        Iterator<Integer> iterator = primes.iterator();
        List<Integer> reversePrimes = new LinkedList<>();
        while (iterator.hasNext()) {
            reversePrimes.add(0, iterator.next());
        }
        for (Integer prime : reversePrimes) {
            System.out.print(prime + " ");
        }
    }
}

