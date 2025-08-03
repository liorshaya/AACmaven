package YearA.TermB.OOP1.exam.TrackableSet;

import java.util.*;

public class TrackableSet<E> {
    private HashSet<E> data;
    private Map<E , Type> history;

    public TrackableSet(){
        this.data = new HashSet<>();
        this.history = new LinkedHashMap<>();
    }

    public void add(E e){
        if(!this.data.contains(e)){
            this.data.add(e);
            this.history.put(e,Type.ADDED);
        }
    }

    public void remove(E e){
        if(this.data.contains(e)){
            this.data.remove(e);
            this.history.put(e,Type.REMOVED);
        }
    }

    public boolean containsElement(E e){
        if(this.data.contains(e)){
            return true;
        }
        else {
            return false;
        }
    }

    public List<String> getActionLog(){
        List<String> log = new ArrayList<>();
        for(Map.Entry<E,Type> entry : this.history.entrySet()){
            log.add(entry.getKey() + " " + entry.getValue());
        }
        return log;
    }

    public void clearLog(){
        this.history.clear();
    }
}
