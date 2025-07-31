package YearA.TermB.OOP1.exam.ex1;

import java.util.ArrayList;
import java.util.List;

public class TimeBoundList<E>{
    private List<Element<E>> elements;
    private List<E> removedElement;
    private int timeout;

    public TimeBoundList(int timeout){
        this.elements = new ArrayList<>();
        this.removedElement = new ArrayList<>();
        this.timeout = timeout;
    }

    public void removeOld(){
        while (true){
            new Thread(()->{
                try {
                    for (int i = 0; i < this.elements.size(); i++) {
                        Element<E> el = this.elements.get(i);
                        long duration = System.currentTimeMillis() - el.getInsertTimeTime();
                        if(duration >= this.timeout *1000L){
                            this.elements.remove(i);
                            this.removedElement.add(el.getElement());
                            i--;
                            System.out.println("the element:" + el + "has removed!");
                        }
                    }
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    public List<E> getRemovedElement(){
        return this.removedElement;
    }

    public void refresh(int index){
        if(index >= 0 && elements.size() -1 < index){
            elements.get(index).setInsertTime(System.currentTimeMillis());
        }
    }
}
