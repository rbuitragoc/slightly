package biz.netcentric.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

@RestController
public class BaseController {
  
  private static final Logger LOGGER = Logger.getLogger(BaseController.class);
	
	@RequestMapping("/base.sly")
	public String base() {
	  String msg = "All your base are belong to us";
	  LOGGER.debug(msg);
		return msg;
	}
	
	@RequestMapping("/templates.sly")
	public String getTemplates(Model model, HttpServletRequest request) {
		model.addAttribute("person.name", "Mr. Robertson");
		return "index.sly";
	}

}
