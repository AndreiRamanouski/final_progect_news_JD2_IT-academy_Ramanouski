package by.htp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value={"/AnonymousController","/Controller","/AdminController"})
public class Localization {
	
	@RequestMapping(params = {"command=localization"})

	public String execute(@RequestParam("commandRedirect") String commandForRedirect) 
			throws ServletException, IOException {
		return "redirect:" + commandForRedirect;
	}
}
