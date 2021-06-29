package by.htp.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.bean.News;
import by.htp.dao.NewsDAO;
import by.htp.dao.exception.DAOException;
import by.htp.service.NewsService;
import by.htp.service.exception.ServiceException;


@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDAO newsDAO;

	@Override
	public List<News> viewAll() throws ServiceException {

		List<News> news;
		try {
			news = newsDAO.all();
		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return news;
	}

	@Override
	public void updateNews(int id, String title, String brief, String content) throws ServiceException {

		try {
			newsDAO.updateNews(id, title, brief, content);
		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}	
	}

	@Override
	public void removeNews(int id) throws ServiceException {

		try {
			newsDAO.removeNews(id);
		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
	
	@Override
	public News getSingleNews(int id) throws ServiceException {
		
		News oneNews = null;

		try {
			oneNews = newsDAO.getSingleNews(id);
		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return oneNews;
	}


}
