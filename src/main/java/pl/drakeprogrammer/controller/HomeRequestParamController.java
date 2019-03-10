package pl.drakeprogrammer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeRequestParamController {



	@GetMapping("/requestParam")
	public String home(@RequestParam(defaultValue = "Unknown") String username) {
		System.out.println("Hello " + username);
		return "home";
	}
}
