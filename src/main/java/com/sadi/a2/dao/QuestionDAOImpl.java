package com.sadi.a2.dao;



import com.sadi.a2.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDAOImpl implements QuestionDAO {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addQuestion(Question q) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(q);

    }

    @Override
    public void updateQuestion(Question q) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(q);


    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Question> listQuestions() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Question> questionsList = session.createQuery("from Question").list();
        for(Question q : questionsList){

        }
        return questionsList;
    }

    @Override
    public Question getQuestionById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Question q = (Question) session.load(Question.class, new Integer(id));

        return q;
    }

    @Override
    public void removeQuestion(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Question q = (Question) session.load(Question.class, new Integer(id));
        if(null != q){
            session.delete(q);
        }


    }
}
