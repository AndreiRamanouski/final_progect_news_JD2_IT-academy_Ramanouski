package by.htp.service;


import by.htp.bean.User;
import by.htp.service.exception.ServiceException;

public interface UserService {
	User authorization (String login, String password) throws ServiceException;
	void createUser(User registrationInfo) throws ServiceException;
}
