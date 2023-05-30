package org.example;

public class Woman extends Person {
    private Man partner;
    private String maidenName;

    // Конструктор
    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }

    // Геттер та сеттер для partner
    public Man getPartner() {
        return partner;
    }

    public void setPartner(Man partner) {
        this.partner = partner;
    }

    // Геттер та сеттер для maidenName
    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    // Метод, що повертає true, якщо жінка на пенсії
    public boolean isRetired() {
        return getAge() >= 60;
    }

    // Метод, що реєструє шлюб
    public void registerPartnership(Man man) {
        this.partner = man;
        setLastName(man.getLastName());
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