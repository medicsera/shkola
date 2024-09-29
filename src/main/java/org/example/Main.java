package org.example;


public class Main {
    public static String first(int n) {

        if (n % 7 == 0 && n % 5 == 0 ) {
            return "fizzbuzz";
        } else if (n % 5 == 0) {
            return "fizz";
        } else if (n % 7 == 0) {
            return "buzz";
        } else {
            return Integer.toString(n);
        }
    }

    public static String second(String n) {

        String wrd;
        wrd = n;

        char[] arr = wrd.toCharArray();
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            l++;
            r--;
        }

        return String.valueOf(arr);
    }

    public static String third(double a, double b, double c) {

        double d = b * b - 4 * a * c;
        double coren1 = 0;
        double coren2 = 0;

        if (d >= 0) {
            coren1 = (-b + Math.sqrt(d)) / (2 * a);
            coren2 = (-b - Math.sqrt(d)) / (2 * a);
        }

        if (Math.abs(coren1 % 1) > 0.00001 || Math.abs(coren2 % 1) > 0.00001) {
            return "Уравнение имеет вещественные корни: " + coren1 + " и " + coren2;
        } else {
            return "У уравнения нет вещественных корней.";
        }

    }

    public static double fourth(double n, double m) {
        double sum = 0;

        while (true) {
            double term = 1 / (Math.pow(n, 2) + n - 2);

            if (Math.abs(term) < m) {
                break;
            }

            sum += term;
            n++;
        }

        return sum;
    }

    public static boolean fifth(String n) {
        String text;
        text = n;

        String newText = text.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder sb = new StringBuilder(newText);
        String revText = sb.reverse().toString();

        boolean checkText;
        checkText = newText.equalsIgnoreCase(revText);

        return checkText;
    }

    public static void main(String[] args) {

        // (1)
        int n1 = 500;
        for (int i = 0; i <= n1; i++) {
            System.out.print(first(i)+' ');
        }
        // (2)
        String n2 = "Mimi mamo mu";
        String res = second(n2);
        System.out.println(res);
        // (3)
        double a2 = 2;
        double b2 = 6;
        double c2 = -3;

        System.out.println(third(a2, b2, c2));
        // (4)
        double n4 = 2;
        double m4 = 1e-6;
        double res2 = fourth(n4, m4);
        System.out.println(res2);
        // (5)
        String n5 = "вич был - у баб - улыбчив.";
        boolean result5 = fifth(n5);
        System.out.println(result5);
    }
}