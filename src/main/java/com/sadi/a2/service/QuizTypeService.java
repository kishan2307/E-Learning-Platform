package com.sadi.a2.service;





import com.sadi.a2.model.QuizType;

import java.util.List;

public interface QuizTypeService {
    public void addQuizType(QuizType qt);
    public void updateQuizType(QuizType qt);
    public List<QuizType> listQuizTypes();
    public QuizType getQuizTypeById(int id);
    public void removeQuizType(int id);
}
