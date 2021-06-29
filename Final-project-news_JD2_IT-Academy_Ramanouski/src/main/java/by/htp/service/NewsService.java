package by.htp.service;

import java.util.List;

import by.htp.bean.News;
import by.htp.service.exception.ServiceException;

public interface NewsService {
	List <News> viewAll() throws ServiceException;
	void updateNews(int id, String title, String brief, String content) throws ServiceException;
	void removeNews(int id) throws ServiceException;
	News getSingleNews(int id) throws ServiceException;
}