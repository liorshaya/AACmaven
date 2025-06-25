package YearA.TermB.OOP1.lesson11.exe1;

public class TimedElement<E> {
    private E element;
    private long insertTime;

    public TimedElement(E element){
        this.element = element;
        this.insertTime = System.currentTimeMillis();
    }

    public E getElement() {
        return element;
    }

    public long getInsertTime() {
        return insertTime;
    }

    public void refrashTime(){
        this.insertTime = System.currentTimeMillis();
    }
}
