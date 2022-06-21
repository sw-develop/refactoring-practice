package me.whiteship.refactoring._10_data_clumps;

public class Employee {

    private String name;

    private Telephone personalPhoneNumber;

    public Employee(String name, Telephone personalPhoneNumber) {
        this.name = name;
        this.personalPhoneNumber = personalPhoneNumber;
    }

    public String personalPhoneNumber() {
        return personalPhoneNumber.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Telephone getPersonalPhoneNumber() {
        return personalPhoneNumber;
    }

    public void setPersonalPhoneNumber(
        Telephone personalPhoneNumber) {
        this.personalPhoneNumber = personalPhoneNumber;
    }
}
