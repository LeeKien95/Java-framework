package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import framgiavn.project01.web.dao.SkillDAO;
import framgiavn.project01.web.model.Skill;
import framgiavn.project01.web.ulti.Logit2;

public class SkillDAOImpl implements SkillDAO{

	private static final Logit2 log = Logit2.getInstance(UserDAOImpl.class);
	public SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Skill findSkillByName(String name) {
		// TODO Auto-generated method stub
		String sql = "Select * from User where User.name = ?";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		List result = null;
		try {
			tx = session.beginTransaction();
			result = session.createQuery(sql)
					.setString(0, name)
					.list();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			if(tx!= null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		if(result.isEmpty()) {
			return null;
		} else {
			return (Skill)result.get(0);
		}	
	}

	@Override
	public Skill findSkillById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "Select * from Skill where Skill.skill_id = ?";
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = null;
		List result = null;
		try {
			tx = session.beginTransaction();
			result = session.createQuery(sql)
					.setParameter(0, id)
					.list();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			if(tx!= null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		if(result.isEmpty()) {
			return null;
		} else {
			return (Skill)result.get(0);
		}
	}

}
