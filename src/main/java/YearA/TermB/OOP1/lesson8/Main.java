package YearA.TermB.OOP1.lesson8;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        List<Passenger> passengers = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File("/Users/shaya/Library/CloudStorage/OneDrive-Personal/intelliJ-Main/AACmaven/src/main/java/YearA/TermB/OOP1/lesson8/Titanic Data.csv"))) {
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] values = line.split(",");
                Passenger p = new Passenger(
                        Integer.getInteger(values[0]),
                        Integer.getInteger(values[1]),
                        Integer.getInteger(values[2]),
                        values[3],
                        values[4],
                        Integer.getInteger(values[5]),
                        Integer.getInteger(values[6]),
                        Integer.getInteger(values[7]),
                        values[8],
                        Double.parseDouble(values[9]),
                        values[10],
                        values[11].charAt(0)
                );
                passengers.add(p);
            }
        } catch (IOException e) {
            System.out.println(" Error" + e.getMessage());
        }
        for (Passenger p : passengers) {
            System.out.println(p.getFormattedName());
        }
    }
}
