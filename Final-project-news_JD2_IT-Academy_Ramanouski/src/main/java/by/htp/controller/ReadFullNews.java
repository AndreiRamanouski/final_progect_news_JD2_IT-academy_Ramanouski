package by.htp.controller;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import by.htp.bean.News;
import by.htp.service.NewsService;
import by.htp.service.exception.ServiceException;

@Controller
@RequestMapping("/Controller")
public class ReadFullNews {

	@Autowired
	private NewsService newsService;
	
	@RequestMapping(params = {"command=single_news"})
	public String execute(@ModelAttribute("News") News news, Model model, Principal principal) 
			throws ServletException, IOException, ServiceException {
		News singleNews = newsService.getSingleNews(news.getId());
		
		if (singleNews == null) {
			model.addAttribute("message", "An error has occurred");
			return "redirect:AnonymousController?command=error_page";
		}
		
		model.addAttribute("singleNews", singleNews);
		return "read_single_news";
	}
}
