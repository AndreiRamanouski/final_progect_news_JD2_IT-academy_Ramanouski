package by.htp.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.htp.bean.News;
import by.htp.bean.User;
import by.htp.service.NewsService;
import by.htp.service.exception.ServiceException;

@Controller
@RequestMapping("/AnonymousController")
public class ToIndexPage {
	
	@Autowired
	private NewsService newsService;

	@RequestMapping(params = {"command=toindexpage"})
	public String execute(Model theModel, Principal principal) throws ServiceException {
		User user = new User();
		List<News> news = newsService.viewAll();
		theModel.addAttribute("news", news);
		theModel.addAttribute("user", user);
		
		return "main_index";
	}
}
