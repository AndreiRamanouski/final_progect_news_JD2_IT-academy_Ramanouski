package by.htp.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.htp.bean.News;
import by.htp.service.NewsService;
import by.htp.service.exception.ServiceException;

@Controller
@RequestMapping("/Controller")
public class ToMainPage {
	
	@Autowired
	private NewsService newsService;

	@RequestMapping(params = {"command=tomainpage"})
	public String execute(Model theModel, Principal principal) 
			throws ServletException, IOException, ServiceException {
		List<News> news = newsService.viewAll();
		theModel.addAttribute("news", news);
		
		return "main";
	}
}
