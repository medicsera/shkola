package org.example;




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

        bowl.addRight(40);
        bowl.addLeft(30);
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

    // 5
        Table table = new Table(3, 4);
        table.setValue(0, 1, 5);
        table.setValue(1, 2, 10);

        System.out.println("Таблица:");
        System.out.println(table);

        System.out.println("Среднее значение: " + table.average());


    }
}