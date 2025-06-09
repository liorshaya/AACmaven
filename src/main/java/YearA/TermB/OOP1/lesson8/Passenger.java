package YearA.TermB.OOP1.lesson8;

import java.io.File;

public class Passenger {
    private Integer passengerId;
    private Integer survived;
    private Integer pClass;
    private String name;
    private String sex;
    private Integer age;
    private Integer sibSp;
    private Integer Parch;
    private String ticket;
    private Double fare;
    private String cabin;
    private char embarked;

    public Passenger(Integer passengerId, Integer survived, Integer pClass, String name, String sex, Integer age, Integer sibSp, Integer parch, String ticket, Double fare, String cabin, char embarked) {
        this.passengerId = passengerId;
        this.survived = survived;
        this.pClass = pClass;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sibSp = sibSp;
        this.Parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        this.cabin = cabin;
        this.embarked = embarked;
    }

    public String getFormattedName() {
        String[] parts = name.split(", ");
        if (parts.length < 2) return name;
        String lastName = parts[0];
        String[] titleAndFirstName = parts[1].split("\\. ");
        if (titleAndFirstName.length < 2) return name;
        String firstName = titleAndFirstName[1];
        return firstName + " " + lastName;
    }

}
