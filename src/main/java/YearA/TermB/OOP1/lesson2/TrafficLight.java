package YearA.TermB.OOP1.lesson2;

import java.util.Random;

public class TrafficLight {

    public static final int RED = 1;
    public static final int YELLOW = 2;
    public static final int GREEN = 3;


    private int currentColor;
    private int greenTime;
    private int yellowTime;
    private int redTime;
    private int distanceFromStart;
    private String name;


    public String toString(){
        return this.name + "- The current light is: " + colorToText();
    }

    public int getDistanceFromStart(){
        return this.distanceFromStart;
    }

    public int getCurrentColor(){
        return this.currentColor;
    }

    public TrafficLight(String name , int distanceFromStart){
        this.name = name;
        this.distanceFromStart = distanceFromStart;
        this.currentColor = RED;
        Random rnd = new Random();
        this.yellowTime = 1000;
        this.greenTime = rnd.nextInt(5000,8000);
        this.redTime = rnd.nextInt(4000,7000);
        autoChangeLight();
    }

    public String colorToText(){
        if(this.currentColor == 1){
            return "red";
        } else if (this.currentColor == 2) {
            return "yellow";
        }
        else{
            return "green";
        }
    }

    public void autoChangeLight(){
       new Thread (()->{
            while(true){
                System.out.println(this);
                if(this.currentColor == RED){
                    try {
                        Thread.sleep(this.redTime);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    this.currentColor = YELLOW;
                }
                else if(this.currentColor == YELLOW){
                    try {
                        Thread.sleep(this.yellowTime);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    this.currentColor = GREEN;
                }
                else{
                    try {
                        Thread.sleep(this.greenTime);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    this.currentColor = RED;
                }
            }
        }).start();


    }
}
