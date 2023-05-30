package org.example;

public class Man extends Person {
    private Woman partner;

    // Конструктор
    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    // Геттер та сеттер для partner
    public Woman getPartner() {
        return partner;
    }

    public void setPartner(Woman partner) {
        this.partner = partner;
    }

    // Метод, що повертає true, якщо чоловік на пенсії
    public boolean isRetired() {
        return getAge() >= 65;
    }

    // Метод, що реєструє шлюб
    public void registerPartnership(Woman woman) {
        this.partner = woman;
        woman.setLastName(getLastName());
    }

    // Метод, що розлучає пару
    public void deregisterPartnership(boolean returnToMaidenName) {
        if (partner != null) {
            if (returnToMaidenName) {
                partner.setLastName(partner.getMaidenName());
            }
            this.partner = null;
        }
    }
}
