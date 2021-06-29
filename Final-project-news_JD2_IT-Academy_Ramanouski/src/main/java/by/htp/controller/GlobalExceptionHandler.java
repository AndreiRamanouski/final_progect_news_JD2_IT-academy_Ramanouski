package by.htp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Component
	public class GlobalExceptionHandler extends SimpleMappingExceptionResolver {
	private static Logger logger = LogManager.getLogger();
	
	@Override
    protected ModelAndView doResolveException(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception e) {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("redirect:AnonymousController?command=errorpage");
	    modelAndView.addObject("message", e.getMessage());
	    logger.info("# exception #" + e.getMessage());
	    return modelAndView;
    }
}
