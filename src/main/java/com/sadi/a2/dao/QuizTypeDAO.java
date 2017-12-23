package com.sadi.a2.dao;



import com.sadi.a2.model.QuizType;

import java.util.List;

public interface QuizTypeDAO {
    public void addQuizType(QuizType qt);
    public void updateQuizType(QuizType qt);
    public List<QuizType> listQuizTypes();
    public QuizType getQuizTypeById(int id);
    public void removeQuizType(int id);
}
