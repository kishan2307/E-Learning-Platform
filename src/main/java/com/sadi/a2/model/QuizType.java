package com.sadi.a2.model;

import javax.persistence.*;

@Entity
@Table(name="quiztype")
public class QuizType {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column (name="type")
    private String type;
    @Column (name="numquestion")
    private int numquestion;
    @Column (name="time")
    private int time;

    //
    public QuizType(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumquestion() {
        return numquestion;
    }

    public void setNumquestion(int numquestion) {
        this.numquestion = numquestion;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "QuizType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", numquestion=" + numquestion +
                ", time=" + time +
                '}';
    }
}
