package com.sadi.a2.dao;



import com.sadi.a2.model.QuizType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizTypeDAOImpl implements QuizTypeDAO {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addQuizType(QuizType qt) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(qt);

    }

    @Override
    public void updateQuizType(QuizType qt) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(qt);


    }
    @SuppressWarnings("unchecked")
    @Override
    public List<QuizType> listQuizTypes() {
        Session session = this.sessionFactory.getCurrentSession();
        List<QuizType> quizTypesList = session.createQuery("from QuizType").list();

        return quizTypesList;
    }

    @Override
    public QuizType getQuizTypeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        QuizType qt = (QuizType) session.load(QuizType.class, new Integer(id));

        return qt;
    }

    @Override
    public void removeQuizType(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        QuizType qt = (QuizType) session.load(QuizType.class, new Integer(id));
        if(null != qt){
            session.delete(qt);
        }

    }
}
