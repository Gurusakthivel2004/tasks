package car;

public class Car {
  private int yearOfMake;
  private String engineNumber;
  private String type;
  
  public Car() {
  }
  
  public Car(String incomingString) {
    System.out.println(incomingString);
  }
  
  public int getYearOfMake() {
    int yearmake = yearOfMake;
    return yearmake;
  }
  
  public void setYearOfMake(int yearOfMake) {
    this.yearOfMake = yearOfMake;
  }
  
  public String getEngineNumber() { 
    String engineNo = engineNumber;
    return engineNo;
  }
  
  public void setEngineNumber(String engineNumber) {
    this.engineNumber = engineNumber;
  }
  
  public String getType() {
    String carType = type;
    return carType;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public void maintenance() {
    System.out.println("Car under maintenance");
  }
}
