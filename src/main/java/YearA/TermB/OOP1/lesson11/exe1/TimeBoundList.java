package YearA.TermB.OOP1.lesson11.exe1;

import java.util.ArrayList;
import java.util.List;

public class TimeBoundList<E>{
    private int timeoutSec;
    private List<TimedElement<E>> elements;
    private List<E> removedElements;

    public TimeBoundList(int timeoutSec){
        this.elements = new ArrayList<>();
        this.removedElements = new ArrayList<>();
        this.timeoutSec = timeoutSec;
    }

    public void removeOld(){
        new Thread(() -> {
            while (true) {
                for(int i = 0 ; i< elements.size() ; i++ ){
                    TimedElement<E> te = elements.get(i);
                    long duration = System.currentTimeMillis() - te.getInsertTime();
                    if(duration >= timeoutSec * 1000L){
                        removedElements.add(te.getElement());
                        elements.remove(i);
                        System.out.println("The element " + i + " has removed!");
                        i--;
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public List<E> getRemovedElements(){
        return this.removedElements;
    }

    public void refresh(int index){
        if(index >= 0 && index < elements.size()){
            elements.get(index).refrashTime();
        }
    }


}
