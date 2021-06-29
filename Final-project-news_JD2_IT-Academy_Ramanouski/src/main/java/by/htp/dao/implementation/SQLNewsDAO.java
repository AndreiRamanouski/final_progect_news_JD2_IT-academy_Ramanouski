package by.htp.dao.implementation;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import by.htp.dao.exception.DAOException;
import by.htp.bean.News;
import by.htp.dao.NewsDAO;

@Repository
@Transactional()
public class SQLNewsDAO implements NewsDAO  {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public News getSingleNews(int id) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		News news = currentSession.get(News.class, id);
		return news;
	}
	
	@Override
	public void updateNews(int id, String title, String brief, String content) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		News news = new News(id,title,brief,content,java.time.LocalDateTime.now());
		news.setStatus("active");
		currentSession.saveOrUpdate(news);
	}
	
	@Override
	public List<News> all() throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<News> query = currentSession.createQuery("from News where status = 'active'", News.class);
		List<News> news = query.getResultList();
		return news;
	}

	@Override
	public void removeNews(int id) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("update News set status = 'removed' where id=:newsId");
		query.setParameter("newsId", id);
		query.executeUpdate();		
	}
}
