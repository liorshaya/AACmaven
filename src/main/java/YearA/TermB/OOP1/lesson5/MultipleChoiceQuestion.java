package YearA.TermB.OOP1.lesson5;

import java.util.List;
import java.util.stream.Collectors;

public class MultipleChoiceQuestion extends Question {
    private List<String> options;
    private int maxSelection;

    public MultipleChoiceQuestion(String text , boolean isRequired , List<String> options , int maxSelection){
        super(text, isRequired);
        this.options = options.stream().distinct().collect(Collectors.toList());
        this.maxSelection = maxSelection;
    }

    public boolean isValidAnswer(List<String> answer){
        if(answer == null || answer.size() > maxSelection){
            return false;
        }
        return answer.stream().allMatch(options::contains);

    }
}
