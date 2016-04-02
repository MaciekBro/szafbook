package pl.namiekko.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import pl.namiekko.entities.User;

@Controller
public class UserController extends WebMvcConfigurerAdapter {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String showForm(User userForm) {
		return "userform";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String checkPersonInfo(@Valid User user, Model model, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "userform";
		}
		model.addAttribute("currentUser", user);
        return "userpage";
	}
}