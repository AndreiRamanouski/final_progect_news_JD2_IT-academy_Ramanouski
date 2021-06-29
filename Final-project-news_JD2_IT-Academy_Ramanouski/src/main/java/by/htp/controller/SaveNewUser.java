package by.htp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import by.htp.bean.User;
import by.htp.service.UserService;
import by.htp.service.exception.ServiceException;

@Controller
@RequestMapping("/AnonymousController")
public class SaveNewUser {

	@Autowired
	private UserService userService;

	@RequestMapping(params = {"command=savenewuser"})
	public String execute(@ModelAttribute("User") User user, Model theModel) throws ServletException, IOException, ServiceException {
		try {
			userService.createUser(user);
			theModel.addAttribute("message", "New user has been created");
			return "redirect:AnonymousController?command=toindexpage";
		} catch (ServiceException e) {
			theModel.addAttribute("message", e.getMessage());
			return "redirect:AnonymousController?command=registration";	
		}
	}
}

