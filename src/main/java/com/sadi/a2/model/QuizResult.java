package com.sadi.a2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="quizresult")
public class QuizResult {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column (name="date")
    private String date;
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


    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "QuizResult{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", mark=" + mark +
                '}';
    }
}
