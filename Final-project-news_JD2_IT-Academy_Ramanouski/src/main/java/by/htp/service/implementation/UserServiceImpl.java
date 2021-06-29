package by.htp.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

import by.htp.bean.User;
import by.htp.dao.UserDAO;
import by.htp.dao.exception.DAOException;
import by.htp.service.UserService;
import by.htp.service.exception.ServiceException;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDAO userDAO;


	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = null;
		try {
			user = userDAO.getUser(userName);
		}catch (DAOException e) {
			throw new UsernameNotFoundException (e.getMessage(), e);
		}
		UserBuilder userBuilder = null;
		if (user != null) {
			userBuilder = org.springframework.security.core.userdetails.User.withUsername(user.getName());
			userBuilder.password(user.getPassword());
			String[] roles = new String[] {user.getRole()};
			userBuilder.roles(roles);
		} else {
			throw new UsernameNotFoundException("User is not found.");
		}
		return userBuilder.build();
	}

	@Override
	public User authorization(String login, String password) throws ServiceException {
		User user = null;
		try {
			user = userDAO.authorization(login, password);
		}catch (DAOException e) {
			throw new ServiceException (e.getMessage(), e);
		}
		return user;
	}

	@Override
	public void createUser(User registrationInfo) throws ServiceException {

		String name = registrationInfo.getName();
		String surname = registrationInfo.getSurname();
		String login = registrationInfo.getLogin();
		String password = registrationInfo.getPassword();

		try {
			userDAO.createUser(registrationInfo);
		}catch (DAOException e) {
			throw new ServiceException (e.getMessage(), e);
		}
	}
}
