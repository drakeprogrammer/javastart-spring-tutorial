package pl.drakeprogrammer.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeHttpServletRequestController {

	@RequestMapping("/httpServletRequest")
	public String home(HttpServletRequest httpServletRequest) {
		String username = httpServletRequest.getParameter("username");
		if (username != null) {
			System.out.println("Hello " + username);
		}
		Cookie[] cookies = httpServletRequest.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + ": " + cookie.getValue());
		}
		return "home";
	}
}
