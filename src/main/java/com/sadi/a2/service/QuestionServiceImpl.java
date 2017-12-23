package com.sadi.a2.service;



import com.sadi.a2.dao.QuestionDAO;
import com.sadi.a2.model.Question;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    private QuestionDAO questionDAO;

    public void setQuestionDAO(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }
    @Transactional
    @Override
    public void addQuestion(Question q) {
        this.questionDAO.addQuestion(q);
    }

    @Override
    @Transactional
    public void updateQuestion(Question q) {
        this.questionDAO.updateQuestion(q);
    }

    @Override
    @Transactional
    public List<Question> listQuestions() {
        return this.questionDAO.listQuestions();
    }

    @Override
    @Transactional
    public Question getQuestionById(int id) {
        return this.questionDAO.getQuestionById(id);
    }

    @Override
    @Transactional
    public void removeQuestion(int id) {
        this.questionDAO.removeQuestion(id);

    }
}
