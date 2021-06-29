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
public class RemoveNews {

	@Autowired
	private NewsService newsService;

	@RequestMapping(params = {"command=removenews"})
	public String execute(@ModelAttribute("id") News news, Model theModel, Principal principal) 
			throws ServletException, IOException, ServiceException {
		newsService.removeNews(news.getId());
		theModel.addAttribute("message","Removed");
		return "redirect:Controller?command=tomainpage";
	}
}
