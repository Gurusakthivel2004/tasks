package runner;

import subcar.Swift;
import subcar.SCross;
import subcar.XUV;
import car.Car;
import bird.BirdAbstract;
import bird.ParrotMod;
import bird.Duck;
import java.util.Scanner;

public class CarRunner {
  
  public static void main(String[] args) {
    CarRunner carRunner = new CarRunner();
    System.out.println("Enter the question number");
    Scanner reader = new Scanner(System.in);
    int questionNo = reader.nextInt();
    switch(questionNo) {
      case 2:
        carRunner.createSwiftInstance(carRunner);
        break;
      case 3:
        carRunner.createSCrossInstance(carRunner);
        break;
      case 5:
        carRunner.printSubCars(new Swift());
        break;
      case 6:
        carRunner.acceptsSwiftObject(new Swift());
        Car swiftCar = new Swift();
        //carRunner.acceptsSwiftObject(swiftCar);
        //carRunner.acceptsSwiftObject(new SCross());
        //carRunner.acceptsSwiftObject(new XUV());
        break;
      case 7:
        carRunner.handleMaintanence();
        break;
      case 8:
        carRunner.handleOverloadedConstructor();
        break;
      case 9:
        carRunner.handleAbstract();
        break;
      case 10:
        carRunner.handleBird();
        break;
    }
  }
  
  public void handleBird() {
    Duck duck = new Duck();
    duck.fly();
    duck.speak();
  }
  
  public void handleAbstract() {
    // BirdAbstract birdabs = new BirdAbstract();
    ParrotMod parrotMod = new ParrotMod();
    parrotMod.fly();
    parrotMod.speak();
  }
  
  public void handleOverloadedConstructor() {
    XUV xuv = new XUV();
    //XUV carXUV = new XUV("incoming string");
  }
  
  public void handleMaintanence() {
    SCross scross = new SCross();
    scross.maintenance();
    Car carScross = new SCross();
    carScross.maintenance();  
    Car car = new Car();
    car.maintenance();
    Car swift = new Swift();
    swift.maintenance();
  }
  
  public void acceptsSwiftObject(Swift swift) {
    //
  }
  
  public void printSubCars(Car car) {
    if(car instanceof Swift) {
      System.out.println("Hatch");
    } else if(car instanceof SCross) {
      System.out.println("sedan");
    } else if(car instanceof XUV) {
      System.out.println("SUV");
    }
  }
  
  public void createSwiftInstance(CarRunner carRunner) {
    Swift swift = new Swift();
    swift.setSeats(4);
    swift.setAirbags(2);
    swift.setModel("CNG");
    swift.setColor("red");
    carRunner.printSubCar(swift);
  }
  
  public void createSCrossInstance(CarRunner carRunner) {
    SCross sCross = new SCross();
    sCross.setYearOfMake(2022);
    sCross.setEngineNumber("41");
    sCross.setType("sedan");
    sCross.setSeats(4);
    sCross.setAirbags(2);
    sCross.setModel("Delta");
    sCross.setColor("blue");
    carRunner.printCar(sCross);
    carRunner.printSubCar(sCross);
  }
  
  public void printCar(Car car) {
    int yearOfMake = car.getYearOfMake();
    String engineNumber = car.getEngineNumber();
    String type = car.getType();
    System.out.println("Year of making is : " + yearOfMake + ", engineNumber : " + engineNumber + " and type : " + type); 
  }
  
  public void printSubCar(Car car) {
    if (car instanceof Swift) {
      Swift swift = (Swift) car;
      System.out.println("Model : " + swift.getModel() + ", color : " + swift.getColor() + ", seats : " + swift.getSeats() + " and Airbags : " + swift.getAirbags()); 
    } else if (car instanceof SCross) {
      SCross scross = (SCross) car;
      System.out.println("Model : " + scross.getModel() + ", color : " + scross.getColor() + ", seats : " + scross.getSeats() + " and Airbags : " + scross.getAirbags()); 
    } else if (car instanceof XUV) {
      XUV xuv = (XUV) car;
      System.out.println("Model : " + xuv.getModel() + ", color : " + xuv.getColor() + ", seats : " + xuv.getSeats() + " and Airbags : " + xuv.getAirbags()); 
    }
  }
  
}
