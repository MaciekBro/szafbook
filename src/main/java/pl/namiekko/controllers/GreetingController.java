package pl.namiekko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.namiekko.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GreetingController {
	
    @Autowired 
    private UserRepository userRepository; 

    @RequestMapping("/")
    public String greeting(Model model, HttpServletRequest request) {
        model.addAttribute("name", (request.getRemoteUser() == null) ? "World" : request.getRemoteUser());
        return "index";
    }

}