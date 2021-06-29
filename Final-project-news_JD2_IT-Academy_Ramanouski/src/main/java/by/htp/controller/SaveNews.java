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
public class SaveNews {

	@Autowired
	private NewsService newsService;

	@RequestMapping(params = {"command=savenews"})
	public String execute(@ModelAttribute("singleNews") News news, Model theModel, Principal principal) 
			throws ServletException, IOException, ServiceException {
		int id = news.getId();
		String title = news.getTitle();
		String brief = news.getBrief();
		String content = news.getContent();
		newsService.updateNews(id, title, brief, content);
		theModel.addAttribute("message", "Saved");
		return "redirect:Controller?command=toindexpage";
	}
}
