package YearA.TermB.OOP1.lesson5;

public abstract class Question {
    private String text;
    private boolean isRequired;

    public Question(String text, boolean isRequired){
        this.text = text;
        this.isRequired = isRequired;
    }

    public String getText(){
        return this.text;
    }

    public boolean getIsRequired(){
        return this.isRequired;
    }

    //public abstract boolean isValidAnswer(String answer);


}
