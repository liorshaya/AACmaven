package YearA.TermB.OOP1.exam.TrafficLight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        List<TrafficLight> light = new ArrayList<>();

        light.add(new TrafficLight("t1",0));
        light.add(new TrafficLight("t2",2000));
        light.add(new TrafficLight("t3",4000));
        light.add(new TrafficLight("t4",6000));


        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            cars.add(new Car());
            long startTime = System.currentTimeMillis();
            int position = 0;

            System.out.println("The car " + (i+1) + " is starting the race!");

            for (int j = 0; j < light.size(); j++) {
                while (position < light.get(j).getDistanceFromStart()){
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }

                    int meterPerSecond = (cars.get(i).getSpeed() * 1000)/3600;
                    position+= meterPerSecond;

                    if(position > light.get(j).getDistanceFromStart()){
                        break;
                    }
                }

                while(light.get(j).getCurrentColor() != TrafficLight.GREEN){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            while (position < 6200){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int meterPerSecond = (cars.get(i).getSpeed() * 1000)/3600;
                position+= meterPerSecond;
            }

            long endTime = System.currentTimeMillis();
            int totalSeconds = (int)(endTime-startTime)/1000;
            cars.get(i).setTotalTimeToFinish(totalSeconds);

            System.out.println("The car " + (i+1) + " had finished the race by " + totalSeconds + "seconds!");
        }

        System.out.println("All cars finished!");
    }


}
