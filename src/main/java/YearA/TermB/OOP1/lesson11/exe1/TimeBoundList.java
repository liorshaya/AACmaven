package YearA.TermB.OOP1.lesson11.exe1;

import java.util.ArrayList;
import java.util.List;

public class TimeBoundList<E>{
    private long timeoutMillis;
    private List<TimedElement<E>> elements = new ArrayList<>();
    private List<E> removedElements = new ArrayList<>();
}
