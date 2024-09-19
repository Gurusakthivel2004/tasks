package subcar;

import car.Car;

public class XUV extends Car {
  private int seats;
  private int airbags;
  private String model;
  private String color;
  
  public XUV() {
      super("incoming string"); 
  }
  
  public int getSeats() {
    int carSeats = seats;
    return carSeats;
  }
  
  public void setSeats(int seats) {
    this.seats = seats;
  }
  
  public int getAirbags() {
    int carAirbags = airbags;
    return carAirbags;
  }
  
  public void setAirbags(int airbags) {
    this.airbags = airbags;
  }
  
  public String getModel() {
    String carModel = model;
    return carModel;
  }
  
  public void setModel(String model) {
    this.model = model;
  }
  
  public String getColor() {
    String carColor = color;
    return carColor;
  }
  
  public void setColor(String color) {
    this.color = color;
  }
}
