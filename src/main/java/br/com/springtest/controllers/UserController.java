package br.com.springtest.controllers;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.springtest.models.User;
import br.com.springtest.services.UserService;
import br.com.springtest.validations.UserValidation;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UserValidation());
	}

	@RequestMapping(value = "/users/registration", method = RequestMethod.GET)
	public ModelAndView registration(User user) {
		return new ModelAndView("users/registration");
	}

	@RequestMapping(value = "/users/registration", method = RequestMethod.POST)
	public ModelAndView save(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		
		/*User userExists = userService.findUserByUserName(user.getUserName());
		if (userExists != null) {
			result.rejectValue("userName", "error.user.userName");
			modelAndView.setViewName("/users/registration");
		}*/
		if (result.hasErrors()) {
			modelAndView = registration(user);
		} else{
			user.setActive(0);
			user.setRegistrationDate(Calendar.getInstance());
			user.setLastUpdate(Calendar.getInstance());
			userService.saveUser(user);
			redirectAttributes.addFlashAttribute("message", "Usuário cadstrado com sucesso!");
			modelAndView.setViewName("redirect:/users");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView list() {
		List<User> users = userService.listUsers();
		ModelAndView modelAndView = new ModelAndView("users/list");
		modelAndView.addObject("users", users);

		return modelAndView;
	}
}
