package me.whiteship.refactoring._10_data_clumps;

public class Telephone {

  private String areaCode;

  private String number;

  public Telephone(String areaCode, String number) {
    this.areaCode = areaCode;
    this.number = number;
  }

  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return this.areaCode + "-" + this.number;
  }
}
