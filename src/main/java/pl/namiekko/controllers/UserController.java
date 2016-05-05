package pl.namiekko.controllers;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import pl.namiekko.entities.User;

@Controller
public class UserController extends WebMvcConfigurerAdapter {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Calendar.class, new FlexibleCalendarEditor());
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showForm(User userForm) {
		return "userform";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String checkPersonInfo(@Valid User user, Model model, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "userform";
		}
		model.addAttribute("currentUser", user);
		return "userpage";
	}
}

class FlexibleCalendarEditor extends PropertyEditorSupport {

	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static Pattern DATE_PATTERN_YMD = Pattern
			.compile("^(?<year>\\d{4})\\D(?<month>\\d{1,2})\\D(?<day>\\d{1,2})$");
	private static Pattern DATE_PATTERN_DMY = Pattern
			.compile("^(?<day>\\d{1,2})\\D(?<month>\\d{1,2})\\D(?<year>\\d{4})$");

	/**
	 * Parse the calendar date from the given text.
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null || text.length() == 0) {
			setValue(null);
		} else {
			Matcher matcherYMD = DATE_PATTERN_YMD.matcher(text);
			Matcher matcherDMY = DATE_PATTERN_DMY.matcher(text);
			Matcher m;
			if (matcherYMD.matches()) {
				m = matcherYMD;
			} else if (matcherDMY.matches()) {
				m = matcherDMY;
			} else {
				throw new IllegalArgumentException(
						"Could not parse date: " + text + ". Please use " + DATE_FORMAT.toPattern());
			}
			int year = Integer.valueOf(m.group("year")).intValue();
			int month = Integer.valueOf(m.group("month")).intValue();
			int day = Integer.valueOf(m.group("day")).intValue();

			if (year > 1900 && month < 13 && day < 32) {
				Calendar cal = Calendar.getInstance();
				cal.set(year, month, day);
				setValue(cal);
			} else {
				throw new IllegalArgumentException(
						"Could not parse date: " + text + ". Please use " + DATE_FORMAT.toPattern());
			}
		}
	}

	@Override
	public String getAsText() {
		Calendar value = (Calendar) getValue();
		return (value != null ? DATE_FORMAT.format(value) : "");
	}
}