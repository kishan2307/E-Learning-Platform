package com.sadi.a2.model;


import javax.persistence.*;

@Entity
@Table(name="question")
public class Question {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column (name="prompt")
    private String prompt;
    @Column (name="answer1")
    private String answer1;
    @Column (name="answer2")
    private String answer2;
    @Column (name="answer3")
    private String answer3;
    @Column (name="answer4")
    private String answer4;
    @Column (name="correctanswer")
    private String correctanswer;

    //
    public Question(){

    }
//GETTER SETTER

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(String correctanswer) {
        this.correctanswer = correctanswer;
    }

    //TO STRING


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", prompt='" + prompt + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
                ", correctanswer='" + correctanswer + '\'' +
                '}';
    }
}
