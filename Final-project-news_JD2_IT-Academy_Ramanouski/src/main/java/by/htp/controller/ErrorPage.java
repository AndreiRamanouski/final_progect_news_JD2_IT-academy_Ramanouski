package by.htp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import by.htp.service.exception.ServiceException;

@Controller
@RequestMapping(value={"/AnonymousController","/Controller","/AdminController"})
public class ErrorPage {

	@RequestMapping(params = {"command=toerrorpage"})
	public String execute() throws ServletException, IOException, ServiceException {
		return "error_page";
	}
}
