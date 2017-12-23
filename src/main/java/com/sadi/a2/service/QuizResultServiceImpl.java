package com.sadi.a2.service;


import com.sadi.a2.dao.QuizResultDAO;
import com.sadi.a2.model.QuizResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuizResultServiceImpl implements QuizResultService {

    private QuizResultDAO quizResultDAO;

    public void setQuizResultDAO(QuizResultDAO quizResultDAO) {
        this.quizResultDAO = quizResultDAO;
    }

    @Override
    @Transactional
    public void addQuizResult(QuizResult qr) {
        this.quizResultDAO.addQuizResult(qr);
    }

    @Override
    @Transactional
    public void updateQuizResult(QuizResult qr) {
        this.quizResultDAO.updateQuizResult(qr);
    }

    @Override
    @Transactional
    public List<QuizResult> listQuizResults() {
        return this.quizResultDAO.listQuizResults();
    }

    @Override
    public QuizResult getQuizResultById(int id) {
        return this.quizResultDAO.getQuizResultById(id);
    }

    @Override
    @Transactional
    public void removeQuizResult(int id) {

        this.quizResultDAO.removeQuizResult(id);

    }
}
