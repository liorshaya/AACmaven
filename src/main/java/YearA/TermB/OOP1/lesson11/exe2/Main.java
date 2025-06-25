package YearA.TermB.OOP1.lesson11.exe2;

public class Main {
    public static void main(String[] args) {
        UndoableList<String> list = new UndoableList<>(3);
        list.add("B");
        System.out.println(list);
        list.add("a");
        System.out.println(list);
        list.add("f");
        System.out.println(list);
        list.add("f");
        System.out.println(list);
        list.add("d");
        list.remove("B");
        System.out.println(list);
    }

}
