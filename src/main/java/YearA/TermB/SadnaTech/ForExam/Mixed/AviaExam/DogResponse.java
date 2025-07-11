package YearA.TermB.SadnaTech.ForExam.Mixed.AviaExam;

public class DogResponse {
    private String message;
    private String success;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "DogResponse{" +
                "message='" + message + '\'' +
                ", success='" + success + '\'' +
                '}';
    }
}
