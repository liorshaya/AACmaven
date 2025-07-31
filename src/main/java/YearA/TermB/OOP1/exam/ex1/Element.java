package YearA.TermB.OOP1.exam.ex1;

public class Element <E>{
    private E element;
    private long insertTime;

    public Element(E element, long time){
        this.element = element;
        this.insertTime = System.currentTimeMillis();
    }

    public long getInsertTimeTime(){
        return this.insertTime;
    }

    public void setInsertTime(long insertTime){
        this.insertTime = insertTime;
    }

    public E getElement(){
        return this.element;
    }
}
