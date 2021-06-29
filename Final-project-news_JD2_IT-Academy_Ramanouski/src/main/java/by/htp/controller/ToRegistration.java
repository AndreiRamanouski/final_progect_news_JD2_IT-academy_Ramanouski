package by.htp.controller;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.htp.bean.User;

@Controller
@RequestMapping("/AnonymousController")
public class ToRegistration {

	@RequestMapping(params = {"command=registration"})
	public String execute(Model theModel, Principal principal) 
			throws ServletException, IOException {
		User user = new User();
		theModel.addAttribute("user", user);

		return "registration_page";
	}
}
