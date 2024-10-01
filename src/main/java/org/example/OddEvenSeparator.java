package org.example;

import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class OddEvenSeparator {

    List<Integer> evenList = new ArrayList<>();
    List<Integer> evenOdd = new ArrayList<>();

    public void addNumber(int number) {
        if (number % 2 == 0)
            evenList.add(number);
        else evenOdd.add(number);
    }

    public List even() {
        System.out.println(evenList);
        return evenList;
    }

    public List odd() {
        System.out.println(evenOdd);
        return evenOdd;
    }
}