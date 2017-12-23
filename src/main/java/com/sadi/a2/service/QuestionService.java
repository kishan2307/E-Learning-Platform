package com.sadi.a2.service;





import com.sadi.a2.model.Question;

import java.util.List;

public interface QuestionService {
    public void addQuestion(Question q);
    public void updateQuestion(Question q);
    public List<Question> listQuestions();
    public Question getQuestionById(int id);
    public void removeQuestion(int id);
}
