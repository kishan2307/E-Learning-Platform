package com.sadi.a2.dao;


import com.sadi.a2.model.QuizResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizResultDAOImpl implements QuizResultDAO {



    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }


    @Override
    public void addQuizResult(QuizResult qr) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(qr);


    }

    @Override
    public void updateQuizResult(QuizResult qr) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(qr);

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<QuizResult> listQuizResults() {
        Session session = this.sessionFactory.getCurrentSession();
        List<QuizResult> quizResultsList = session.createQuery("from QuizResult").list();

        return quizResultsList;
    }

    @Override
    public QuizResult getQuizResultById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        QuizResult qr = (QuizResult) session.load(QuizResult.class, new Integer(id));

        return qr;
    }

    @Override
    public void removeQuizResult(int id) {

        Session session = this.sessionFactory.getCurrentSession();
        QuizResult qr = (QuizResult) session.load(QuizResult.class, new Integer(id));
        if(null != qr){
            session.delete(qr);
        }


    }
}
