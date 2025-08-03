
package YearA.TermB.OOP1.exam.TrackableSet;

public class Main {
    public static void main(String[] args) {
        TrackableSet<String> ts = new TrackableSet<>();

        ts.add("Apple");
        ts.add("Banana");
        ts.add("Apple"); // לא תתווסף שוב
        ts.remove("Banana");
        ts.remove("Orange"); // לא קיים - לא יקרה כלום
        ts.add("Cherry");
        ts.add("dsdsd");
        ts.add("sdsd");
        ts.add("a");
        ts.remove("a");




        System.out.println("Contains Apple? " + ts.containsElement("Apple"));
        System.out.println("Contains Banana? " + ts.containsElement("Banana"));

        System.out.println("\nAction Log:");
        for (String log : ts.getActionLog()) {
            System.out.println(log);
        }

        ts.clearLog();

        System.out.println("\nAction Log after clear:");
        for (String log : ts.getActionLog()) {
            System.out.println(log);
        }
    }
}
