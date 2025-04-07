package YearA.TermB.OOP1.lesson2;

import java.util.Random;

public class Car {
    private int speed;
    private int totalTimeToFinish;

    public Car(){
        Random rnd = new Random();
        this.speed = rnd.nextInt(0,31)+50;
    }

    public void setTotalTimeToFinish(int total){
        this.totalTimeToFinish = total;
    }

    public String toString(){
        return "The current car speed is: " + this.speed + " and time to finish: " + this.totalTimeToFinish + ".";
    }

    public int getSpeed(){
        return this.speed;
    }



}
