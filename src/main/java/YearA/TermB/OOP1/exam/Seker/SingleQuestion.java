package YearA.TermB.OOP1.exam.Seker;

import java.util.HashSet;

public class SingleQuestion extends Question{
    private HashSet<String> options;

    public SingleQuestion(String question , boolean isRequired , boolean isDemograph, HashSet<String> options){
        super(question,isRequired,isDemograph);
        this.options = options;
    }

    public boolean checkOneSelection(){
        return options.size() == 1;
    }


}
