package car;

public class CarModel {
  private String type;
  
  public CarModel() {
  }
  
  public CarModel(String incomingString) {
    System.out.println(incomingString);
  }
  
  public String getType() {
    String carType = type;
    return carType;
  }
  
  public void setType(String type) {
    this.type = type;
  }
  
  public String toString() {
	  return "Car model type is " + type;
  }
  
}
