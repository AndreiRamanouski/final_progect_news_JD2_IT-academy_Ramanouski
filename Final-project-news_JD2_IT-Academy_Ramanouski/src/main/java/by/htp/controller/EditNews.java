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
@RequestMapping("/AdminController")
public class EditNews {

	@Autowired
	private NewsService newsService;

	@RequestMapping(params = {"command=editnews"})
	public String execute(@ModelAttribute("News") News news, Model model, Principal principal) 
			throws ServletException, IOException, ServiceException {
		News singleNews = newsService.getSingleNews(news.getId());

		if (singleNews == null) {
			model.addAttribute("message", "An arror has occured. Please contact us.");
			return "redirect:AnonymousController?command=go_to_error_page";
		}

		model.addAttribute("singleNews", singleNews);
		return "edit_news";
	}
}

