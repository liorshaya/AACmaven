package YearA.TermB.OOP1.lesson2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TrafficLight[] lights = new TrafficLight[4];
        lights[0] = new TrafficLight("A",0);
        lights[1] = new TrafficLight("B",2000);
        lights[2] = new TrafficLight("C",4000);
        lights[3] = new TrafficLight("D",6000);

        Car[] cars = new Car[20];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car();
            long startTime = System.currentTimeMillis();
            int position = 0;

            System.out.println("The car " + (i+1) + "is starting the drive at speed" + cars[i].getSpeed() + "km/h.");

            for (int j = 0; j < lights.length; j++) {
                while(position < lights[i].getDistanceFromStart()){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    int meterPerSecond = (int) (cars[i].getSpeed() * 1000)/3600;
                    position += meterPerSecond;

                    if(position > lights[i].getDistanceFromStart()){
                        break;
                    }
                }

                while (lights[i].getCurrentColor() != TrafficLight.GREEN){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            while(position < 6200){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int meterPerSecond = (int)(cars[i].getSpeed() * 1000)/3600;
                position += meterPerSecond;
            }

            long endTime = System.currentTimeMillis();
            int totalSeconds = (int)(endTime -startTime);
            cars[i].setTotalTimeToFinish(totalSeconds);

            System.out.println("🏁 Car #" + (i + 1) + " finished the track in " + totalSeconds + " seconds\n");

        }

        System.out.println("🎉 All cars finished the simulation!");

    }
}


