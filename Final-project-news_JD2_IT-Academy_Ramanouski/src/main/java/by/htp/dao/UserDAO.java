package by.htp.dao;

import by.htp.bean.User;
import by.htp.dao.exception.DAOException;

public interface UserDAO {
	User authorization (String login, String password) throws DAOException;
	User getUser (String login) throws DAOException;
	void createUser(User registrationInfo) throws DAOException;
}
