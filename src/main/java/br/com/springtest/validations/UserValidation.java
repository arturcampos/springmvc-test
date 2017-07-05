package br.com.springtest.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.springtest.models.User;

public class UserValidation implements Validator {

	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	//private static final String USERNAME_PATTERN = "^(?=.{5,20}$)(?![.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");

		User user = (User) target;
		// user validation in spring
		/*if (!(user.getUserName() != null && user.getEmail().isEmpty())) {
			pattern = Pattern.compile(USERNAME_PATTERN);
			matcher = pattern.matcher(user.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("userName", "field.incorrect");
			}
		}*/

		// email validation in spring
		if (!(user.getBrother​().getEmail() != null && user.getBrother​().getEmail().isEmpty())) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(user.getBrother​().getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "field.incorrect");
			}
		}

	}
}
