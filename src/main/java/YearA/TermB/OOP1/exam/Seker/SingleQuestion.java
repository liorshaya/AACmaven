package YearA.TermB.OOP1.exam.Seker;

import java.util.HashSet;

public class SingleQuestion extends Question{
    private HashSet<String> answer;

    public SingleQuestion(String question , boolean isRequired , boolean isDemograph){
        super(question,isRequired,isDemograph);
    }
}
