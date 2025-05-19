package YearA.TermB.OOP1.lesson5;

public class RatingQuestion extends Question{

    public RatingQuestion(String text , boolean isRequired){
        super(text,isRequired);
    }

    public boolean isValidAnswer(String answer){
        if(answer == null){
            return false;
        }
        if(answer.equals("1") || answer.equals("2")|| answer.equals("3")|| answer.equals("4")|| answer.equals("5")){
            return true;
        }
        return false;
    }
}
