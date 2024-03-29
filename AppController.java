package net.codejava;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
	@Autowired hpi
	private UserRepository repo;
	    @GetMapping("")
	    public String viewHomePage() {
	        return "index";
    }
	    @GetMapping("/register")
	    public String showSignUpForm(Model model) {	
	    	model.addAttribute("user", new User());
			return "signup_Form";
	    	
	    }
	    @PostMapping("/process_register")
	    public String processRegistration(User user) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
	    	repo.save(user);
	    	return "register_success";
	    }
	    @GetMapping("/list_users")
	    public String viewUsersList(Model model) {
	    	List<User> listUsers =repo.findAll();
	    	model.addAttribute("listUsers", listUsers);//time youtube 1.13.27
	    	return "users";
	    }
	   
	    }

