package YearA.TermB.OOP1.exam.UndoableList;

public class Action <E>{
    private E element;
    private Type type;

    public Action(E element , Type type){
        this.element = element;
        this.type = type;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
