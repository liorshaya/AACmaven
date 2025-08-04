package YearA.TermB.OOP1.exam.Seker;

public class RatingQuestuin extends Question{
    private int selectedQuestion;

    public RatingQuestuin(String question , boolean isRequired, boolean isDemograph, int selectedQuestion){
        super(question, isRequired, isDemograph);
        this.selectedQuestion = selectedQuestion;
    }

    public boolean checkRatingNum(){
        return this.selectedQuestion > 0 && this.selectedQuestion < 6;
    }


}
