package YearA.TermB.OOP1.exam.DelayedSet;

public class Element <E>{
    private E element;
    private long insertTime;

    public Element(E element , long insertTime){
        this.element = element;
        this.insertTime = System.currentTimeMillis();
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public long getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(long insertTime) {
        this.insertTime = insertTime;
    }
}
