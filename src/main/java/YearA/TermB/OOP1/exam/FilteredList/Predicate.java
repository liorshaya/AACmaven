package YearA.TermB.OOP1.exam.FilteredList;

public class Predicate <E>{
    private E element;


    public Predicate<E> filter(){
        if((Integer) this.element % 2 == 0){
            return this.element;
        }
    }
}
