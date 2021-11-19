package models;

import javax.persistence.*;

@Entity
@Table(name = "grade", schema = "public")
public class grade {
    @Id
    @Column(name = "grade_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int grade_id;

    @Column(name = "letter")
    private String letter;

    @Column(name = "presentation")
    private Boolean presentation;

    public grade() {
    }

    public grade(int grade_id, String letter, Boolean presentation) {
        this.grade_id = grade_id;
        this.letter = letter;
        this.presentation = presentation;
    }

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Boolean getPresentation() {
        return presentation;
    }

    public void setPresentation(Boolean presentation) {
        this.presentation = presentation;
    }

    @Override
    public String toString() {
        return "grade{" +
                "grade_id='" + grade_id + '\'' +
                ", letter='" + letter + '\'' +
                ", presentation=" + presentation +
                '}';
    }
}
