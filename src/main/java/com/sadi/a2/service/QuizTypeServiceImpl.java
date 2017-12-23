package com.sadi.a2.service;



import com.sadi.a2.dao.QuizTypeDAO;
import com.sadi.a2.model.QuizType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuizTypeServiceImpl implements  QuizTypeService {

    private QuizTypeDAO quizTypeDAO;

    public void setQuizTypeDAO(QuizTypeDAO quizTypeDAO) {
        this.quizTypeDAO = quizTypeDAO;
    }
    @Transactional
    @Override
    public void addQuizType(QuizType qt) {
        this.quizTypeDAO.addQuizType(qt);
    }

    @Override
    @Transactional
    public void updateQuizType(QuizType qt) {
        this.quizTypeDAO.updateQuizType(qt);
    }

    @Override
    @Transactional
    public List<QuizType> listQuizTypes() {
        return this.quizTypeDAO.listQuizTypes();
    }

    @Override
    @Transactional
    public QuizType getQuizTypeById(int id) {
        return this.quizTypeDAO.getQuizTypeById(id);
    }

    @Override
    @Transactional
    public void removeQuizType(int id) {
        this.quizTypeDAO.removeQuizType(id);

    }
}
