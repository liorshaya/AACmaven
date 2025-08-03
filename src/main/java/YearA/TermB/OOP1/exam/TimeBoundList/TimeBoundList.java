package YearA.TermB.OOP1.exam.TimeBoundList;

import java.util.ArrayList;
import java.util.List;

public class TimeBoundList<E> {
        private List<Element<E>> elements;
        private List<E> removedElements;
        private int timeout;

        public TimeBoundList(int timeout){
            this.elements = new ArrayList<>();
            this.removedElements = new ArrayList<>();
            this.timeout = timeout;
            autoRemoveOldElements();
        }

        public void autoRemoveOldElements(){
            Thread t1 = new Thread(()->{
                while(true){
                    for (int i = 0; i < elements.size(); i++) {
                        Element<E> el = elements.get(i);
                        long duration = System.currentTimeMillis() - el.getCreationTime();
                        if(duration >= timeout * 1000L){
                            removedElements.add(el.getElement());
                            elements.remove(i);
                            i--;
                            System.out.println("The element: " + el.getElement() + " removed!");
                        }
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            t1.start();
        }

        public List<E> getRemovedElements(){
            return removedElements;
        }

        public void refresh(int index){
            if(index >= 0 && index < elements.size()){
                elements.get(index).setCreationTime(System.currentTimeMillis());
            }
        }
}
