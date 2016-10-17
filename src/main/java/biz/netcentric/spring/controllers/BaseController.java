package biz.netcentric.spring.controllers;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public String getTemplates(Model model) {
		model.addAttribute("templateName", "sample template name");
		return "templates";
	}

}
