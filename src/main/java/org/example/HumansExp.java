package org.example;

import java.util.*;

class Human implements Comparable<Human> {
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + age;
    }

    @Override
    public int compareTo(Human other) {
        return this.lastName.compareTo(other.lastName);
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }
}


class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getLastName().compareTo(h2.getLastName());
    }
}



public class HumansExp {
    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("Barak", "Obama", 60),
                new Human("Vladimir", "Putin", 71),
                new Human("John", "Smith", 29)
        );

        // a)
        HashSet<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet: " + hashSet);

        // b)
        LinkedHashSet<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet: " + linkedHashSet);

        // c)
        TreeSet<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet: " + treeSet);

        // d)
        TreeSet<Human> treeSetWithComparator = new TreeSet<>(new HumanComparatorByLastName());
        treeSetWithComparator.addAll(humans);
        System.out.println("TreeSet с компаратором по фамилии: " + treeSetWithComparator);

        // e)
        TreeSet<Human> treeSetWithAnonymousComparator = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetWithAnonymousComparator.addAll(humans);
        System.out.println("TreeSet с анонимным компаратором по возрасту: " + treeSetWithAnonymousComparator);
    }
}
