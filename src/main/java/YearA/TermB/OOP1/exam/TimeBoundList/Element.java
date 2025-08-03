package YearA.TermB.OOP1.exam.TimeBoundList;

public class Element <E>{
    private E element;
    private  long creationTime;

    public Element(E element , long creationTime){
        this.element = element;
        this.creationTime = System.currentTimeMillis();
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }
}
