package biz.netcentric.spring.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@RestController
public class BaseController {
  
  private static final Logger LOGGER = Logger.getLogger(BaseController.class);
  
  @Autowired
  FreeMarkerConfigurer freeMarkerConfigurer;
	
	@RequestMapping("/base.sly")
	public String base() {
	  String msg = "All your base are belong to us";
	  LOGGER.debug(msg);
		return msg;
	}
	
	@RequestMapping("/templates.sly")
	public ModelAndView getTemplates(HttpServletRequest request, HttpServletResponse response) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
	  
	  Map<String, Object> model = new HashMap<>();
	  
	  model.put("person", new HashMap<String, String>(){{put("name", "John");put("spouse", "Celia");}});
	  model.put("child", "Michael");
	  
//	  Template t = freeMarkerConfigurer.getConfiguration().getTemplate("template1.html");
//	  t.process(model, response.getWriter());
	  
	  ModelAndView mav = new ModelAndView("template1.html");
	  mav.addAllObjects(model);
		return mav;
	}

}
