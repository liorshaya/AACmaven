package YearA.TermB.OOP1.exam.DelayedSet;

import java.util.HashSet;

public class DelayedSet<E> {
    private HashSet<E> data;
    private int delayInSeconds;


    public DelayedSet(int delayInSeconds){
        this.data = new HashSet<>();
        this.delayInSeconds = delayInSeconds;
        //makingDelay();
    }

    public void makingDelayWhileAddingElement(E element){
        if(this.data.contains(element)){
            return;
        }
        else{
            try {
                Thread.sleep(delayInSeconds *1000L);
                this.data.add(element);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
