package org.example;

import java.util.HashMap;
import java.util.Map;

public class SwapMap {
    public static <K, V> Map<V, K> swap(Map<K, V> map) {
        Map<V, K> swappedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            swappedMap.put(entry.getValue(), entry.getKey());
        }
        return swappedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("one", 1);
        originalMap.put("two", 2);
        originalMap.put("three", 3);

        Map<Integer, String> swappedMap = swap(originalMap);
        System.out.println("Nсходная карта: " + originalMap);
        System.out.println("Обмененная карта: " + swappedMap);
    }
}
