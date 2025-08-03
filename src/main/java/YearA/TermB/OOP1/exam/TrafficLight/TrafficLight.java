package YearA.TermB.OOP1.exam.TrafficLight;

import java.util.Random;

public class TrafficLight {

    public static final int RED = 1;
    public static final int YELLOW = 2;
    public static final int GREEN = 3;

    private int currentColor;
    private int yellowTime;
    private int redTime;
    private int greenTime;
    private int distanceFromStart;
    private String name;
    public static final Random rnd = new Random();




    public TrafficLight(String name,int distanceFromStart){
        this.currentColor = RED;
        this.yellowTime = 1000;
        this.greenTime = rnd.nextInt(5000,8000);
        this.redTime = rnd.nextInt(4000,7000);
        this.distanceFromStart = distanceFromStart;
        this.name = name;
        autoChangingColor();
    }

    public String toString(){
        return "The Current color is:" + currentColor;
    }

    public void autoChangingColor(){
        Thread t1 = new Thread(()->{
            while(true){
                if(this.currentColor ==  RED){
                    try {
                        Thread.sleep(this.redTime);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    this.currentColor = YELLOW;
                    System.out.println(this.name + " Color is yellow");
                }
                else if(this.currentColor == YELLOW){
                    try {
                        Thread.sleep(this.yellowTime);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    this.currentColor = GREEN;
                    System.out.println(this.name +" Color is green");
                }
                else{
                    try {
                        Thread.sleep(this.greenTime);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    this.currentColor = RED;
                    System.out.println(this.name +" Color is red");
                }
            }

        });
        t1.start();
    }

    public int getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(int currentColor) {
        this.currentColor = currentColor;
    }

    public int getYellowTime() {
        return yellowTime;
    }

    public void setYellowTime(int yellowTime) {
        this.yellowTime = yellowTime;
    }

    public int getRedTime() {
        return redTime;
    }

    public void setRedTime(int redTime) {
        this.redTime = redTime;
    }

    public int getGreenTime() {
        return greenTime;
    }

    public void setGreenTime(int greenTime) {
        this.greenTime = greenTime;
    }

    public int getDistanceFromStart() {
        return distanceFromStart;
    }

    public void setDistanceFromStart(int distanceFromStart) {
        this.distanceFromStart = distanceFromStart;
    }
}
