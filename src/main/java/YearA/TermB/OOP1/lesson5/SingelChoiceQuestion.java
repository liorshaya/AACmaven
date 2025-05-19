package YearA.TermB.OOP1.lesson5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SingelChoiceQuestion extends Question{
    private List<String> options;

    public SingelChoiceQuestion(String text, boolean isRequired , List<String> options){
        super(text,isRequired);
        this.options = options.stream().distinct().collect(Collectors.toList());
    }

    public boolean isValidAnswer(String answer){
        if(answer == null){
            return false;
        }
        return options.contains(answer);
    }
}
