package com.sadi.a2.model;

import javax.persistence.*;

@Entity
@Table(name="quizresult")
public class QuizResult {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column (name="useranswer")
    private String useranswer;
    @Column (name="mark")
    private int mark;


    //
    public QuizResult(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUseranswer() {
        return useranswer;
    }

    public void setUseranswer(String useranswer) {
        this.useranswer = useranswer;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "QuizResult{" +
                "id=" + id +
                ", useranswer='" + useranswer + '\'' +
                ", mark=" + mark +
                '}';
    }
}
