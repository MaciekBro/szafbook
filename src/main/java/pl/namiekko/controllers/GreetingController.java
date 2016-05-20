package pl.namiekko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.namiekko.entities.User;

@Controller
public class GreetingController {
	
    @Autowired 
    private UserRepository userRepository; 

    @RequestMapping("/")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        for(User user: userRepository.findAll()){
        	model.addAttribute("retrievedName", user.getUserName());
        	model.addAttribute("retrievedPassword", user.getPasswordEncrypted());
        	break;
        }                
        return "index";
    }

}