package br.com.springtest.controllers;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.springtest.models.Brother​;
import br.com.springtest.models.Role;
import br.com.springtest.models.User;
import br.com.springtest.services.BrotherService;
import br.com.springtest.services.RoleService;
import br.com.springtest.services.UserService;
import br.com.springtest.validations.UserValidation;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private BrotherService brotherService;
	@Autowired
	private RoleService roleService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UserValidation());
	}

	@RequestMapping(value = "/users/registration", method = RequestMethod.GET)
	public ModelAndView registration(User user) {
		
		ModelAndView modelAndView = new ModelAndView("users/registration");
		
		
		List<Brother​> brothers = brotherService.listBrothers();
		List<Role> roles = roleService.listRoles();
		
		modelAndView.addObject("brothers", brothers);
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}

	@RequestMapping(value = "/users/registration", method = RequestMethod.POST)
	public ModelAndView save(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();

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
	
	@RequestMapping(value = "/users/detail/{id}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("users/detail");
		User user = userService.find(id);
		modelAndView.addObject("user", user);

		return modelAndView;
	}
}
