package YearA.TermB.OOP1.lesson11.exe2;

public class Action<E> {
    private ActionType type;
    private E element;

    public Action(ActionType type, E element){
        this.type = type;
        this.element = element;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}
