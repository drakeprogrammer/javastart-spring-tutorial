package pl.drakeprogrammer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeRequestHeaderController {



	@GetMapping("/requestHeader")
	public String home(@RequestParam(defaultValue = "Unknown") String username,
						@RequestHeader("user-agent") String userAgent) {
		System.out.println("Hello " + username);
		System.out.println("Web browser " + userAgent);
		return "home";
	}
}
