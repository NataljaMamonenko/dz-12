package org.example;

public class Main {
    public static void main(String[] args) {
        // Створення об'єктів Man и Woman
        Man john = new Man("Jone", "Doe", 70);
        Woman jane = new Woman("Jane", "Doe", 65);

        // Перевірка метода isRetired
        System.out.println(john.getFirstName() + " is retired: " + john.isRetired());
        System.out.println(jane.getFirstName() + " is retired: " + jane.isRetired());

        // Регістрація шлюбу
        john.registerPartnership(jane);
        System.out.println(john.getFirstName() + " and " + jane.getFirstName() + " are partners");

        // Перевірка метода isRetired післе регістрации шлюбу
        System.out.println(john.getFirstName() + " is retired: " + john.isRetired());
        System.out.println(jane.getFirstName() + " is retired: " + jane.isRetired());

        // Розлучення
        john.deregisterPartnership(true);
        System.out.println(john.getFirstName() + " and " + jane.getFirstName() + " are no longer partners");

        // Перевірка метода isRetired післе розлучення
        System.out.println(john.getFirstName() + " is retired: " + john.isRetired());
        System.out.println(jane.getFirstName() + " is retired: " + jane.isRetired());
    }
}
