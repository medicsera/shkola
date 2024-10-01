package org.example;


import javax.swing.text.Style;

public class Main {
    public static void main(String[] args) {
        //1

        Button poke = new Button();

        String koll = "Количество кликов: ";
        System.out.println(koll + poke.click());
        System.out.println(koll + poke.click());
        System.out.println(koll + poke.click());

    /*2 */System.out.println();

        Balance bowl = new Balance();

        bowl.Lweight = 30;
        bowl.Rweight = 40;
        bowl.result();

    // 3
        System.out.println();

        Bell bell = new Bell();
        bell.sound();

    // 4
        System.out.println();

        OddEvenSeparator num = new OddEvenSeparator();

        num.addNumber(5);
        num.addNumber(8);
        num.addNumber(2);
        num.addNumber(3);
        num.addNumber(7);
        num.addNumber(4);

        num.even();
        num.odd();

    }
}