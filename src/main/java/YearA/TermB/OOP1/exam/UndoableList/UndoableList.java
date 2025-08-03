package YearA.TermB.OOP1.exam.UndoableList;

import java.util.ArrayList;
import java.util.List;

public class UndoableList <E>{
    private List<E> data;
    private List<Action<E>> history;
    private int maxUndoes;
    private int counter;

    public UndoableList(int maxUndoes){
        this.data = new ArrayList<>();
        this.history = new ArrayList<>();
        this.maxUndoes = maxUndoes;
        this.counter = 0;
    }

    public void add(E e){
        this.data.add(e);
        this.history.add(new Action<>(e,Type.ADD));
    }

    public void remove(E e){
        this.data.remove(e);
        this.history.add(new Action<>(e,Type.REMOVE));
    }

    public boolean undo(){
        if(this.history.isEmpty() || counter >= maxUndoes){
            return false;
        }
        else{
            Action<E> current = history.get(history.size()-1);
            if(current.getType() == Type.ADD){
                this.data.remove(this.data.get(data.size()-1));
                System.out.println("The element " + current + "has removed!");
            }
            else{
                this.data.add(current.getElement());
                System.out.println("The element " + current + "has added!");
            }

            this.history.remove(current);
            counter++;

        }
        return true;
    }

    public void commit(){
        this.history.clear();
    }
}
