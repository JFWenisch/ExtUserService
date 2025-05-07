package tech.wenisch.extuserservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import tech.wenisch.extuserservice.pojo.User;
import tech.wenisch.extuserservice.service.UserManagementService;

@Controller
public class GUIController {
	@GetMapping("/")
	public String index(HttpServletRequest request, Model model) {


		return "index";
	}
	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
	    // Save user data (if needed)
	    redirectAttributes.addFlashAttribute("user", user);

	    // Redirect to success page
		return "register-validate";
	}
	@GetMapping("/register-success")
	public String home( Model model) {


		return "register-success";
	}
	@GetMapping("/register/{link}")
	public String getRegisterPage(@PathVariable("link") String link ,  Model model, HttpServletRequest request) 
	{
		User user = UserManagementService.pendingRegistrations.get(link);
		if(user==null)
		{
			return "redirect:/";
		}
		model.addAttribute("user", user);
		return "register";
	}

}
