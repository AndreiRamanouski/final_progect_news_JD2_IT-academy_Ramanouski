package by.htp.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.htp.bean.User;
import by.htp.dao.UserDAO;
import by.htp.dao.exception.DAOException;


@Repository
@Transactional()
public class SQLUserDAO implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User authorization(String login, String password) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from User where login = '" + login + "' and password = '" + password + "'", User.class);
		User user = new User(); 
		user =(User) query.getSingleResult();
		return user;
	}
	
	@Override
	public User getUser(String login) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from User where login = '" + login + "'", User.class);
		User user = new User(); 
		user =(User) query.getSingleResult();
		return user;
	}
	
	@Override
	public void createUser(User user) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		user.setRole("user");
		currentSession.saveOrUpdate(user);
	}
}
