package me.whiteship.refactoring._10_data_clumps;

public class Office {

    private String location;

    private Telephone officePhoneNumber;

    public Office(String location, Telephone officePhoneNumber) {
        this.location = location;
        this.officePhoneNumber = officePhoneNumber;
    }

    public String officePhoneNumber() {
        return officePhoneNumber.toString();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Telephone getOfficePhoneNumber() {
        return officePhoneNumber;
    }

    public void setOfficePhoneNumber(Telephone officePhoneNumber) {
        this.officePhoneNumber = officePhoneNumber;
    }
}
