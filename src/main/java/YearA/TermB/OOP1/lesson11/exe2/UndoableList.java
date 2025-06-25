package YearA.TermB.OOP1.lesson11.exe2;

import java.util.ArrayList;
import java.util.List;

public class UndoableList<E>{
    private List<E> data;
    private List<Action<E>> history;
    private int maxUndos;
    private int undosPerformed = 0;
    ;

    public UndoableList(int maxUndos){
        this.data = new ArrayList<>();
        this.history = new ArrayList<>();
        this.maxUndos = maxUndos;

    }

    public void add(E element){
        data.add(element);
        this.history.add(new Action<>(ActionType.ADD,element));
    }

    public void remove(E element){
        this.data.remove(element);
        this.history.add(new Action<>(ActionType.REMOVE,element));
    }

    public boolean undo(){
        if(this.history.isEmpty() || undosPerformed >= this.maxUndos){
            return false;
        }
        else{
            Action<E> current = this.history.get(this.history.size() - 1);
            if(current.getType() == ActionType.ADD){
                this.data.remove(this.data.size()-1);
                System.out.println("The element " + current + " has removed");
            }
            else if(current.getType() == ActionType.REMOVE){
                this.data.add(current.getElement());
                System.out.println("The element " + current + " has re-added");
            }
            this.history.remove(current);
            undosPerformed++;
            return true;
        }

    }

    public String toString(){
        return this.data.toString();
    }

    public void commint(){
        this.history.clear();
        undosPerformed = 0;
    }

}
