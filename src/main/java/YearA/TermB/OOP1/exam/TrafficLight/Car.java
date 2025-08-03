package YearA.TermB.OOP1.exam.TrafficLight;

import java.util.Random;

public class Car {
    private int speed;
    private int totalTimeToFinish;

    public Car(){
        Random rnd = new Random();
        this.speed = rnd.nextInt(50000,80000);
        displayStat();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTotalTimeToFinish() {
        return totalTimeToFinish;
    }

    public void setTotalTimeToFinish(int totalTimeToFinish) {
        this.totalTimeToFinish = totalTimeToFinish;
    }

    public String toString(){
        return "The speed car is: " + this.speed + " and total time to finish: " + this.totalTimeToFinish;
    }

    public void displayStat(){
        new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("The speed car is: " + this.speed + " and total time to finish: " + this.totalTimeToFinish);
        }).start();
    }

}
