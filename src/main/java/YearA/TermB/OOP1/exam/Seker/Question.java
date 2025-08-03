package YearA.TermB.OOP1.exam.Seker;

public abstract class Question {
    private String question;
    private boolean isRequired;
    private boolean isDemograph;

    public Question(String question , boolean isRequired, boolean isDemograph){
        this.question = question;
        this.isRequired = isRequired;
        this.isDemograph = isDemograph;
    }
}
