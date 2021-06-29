package by.htp.dao;

import java.util.List;

import by.htp.bean.News;
import by.htp.dao.exception.DAOException;

public interface NewsDAO {

	List<News> all() throws DAOException;
	News getSingleNews(int id) throws DAOException;
	void removeNews(int id) throws DAOException;
	void updateNews(int id, String title, String brief, String content) throws DAOException;

	
}
