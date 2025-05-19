package YearA.TermB.OOP1.lesson5;

public class FreeTextQuestion extends Question{

    public FreeTextQuestion(String text , boolean isRequired){
        super(text,isRequired);
    }

    public boolean isValidAnswer(String answer){
        if(answer == null){
            return false;
        }
        return answer.length() <= 20;

    }
}
