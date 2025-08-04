package YearA.TermB.OOP1.exam.Seker;

import java.util.HashSet;

public class MultiSelection extends Question{
    private int maxSelection;
    private HashSet<String> options;

    public MultiSelection(String question , boolean isRequired, boolean isDemograph , HashSet<String> options , int maxSelection){
        super(question, isRequired, isDemograph);
        this.options = options;
        this.maxSelection = maxSelection;
    }

    public boolean checkMaxSelection(){
        return options.size() <= maxSelection;
    }
}
