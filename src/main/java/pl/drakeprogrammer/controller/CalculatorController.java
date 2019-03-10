package pl.drakeprogrammer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

	@GetMapping("/calculator")
	public String home() {
		return "calculator";
	}

	@PostMapping("/calculator")
	public String calculate(@RequestParam(defaultValue = "0") int valueA,
			@RequestParam(defaultValue = "0") int valueB) {
		int result = valueA + valueB;
		System.out.printf("%d + %d = %d\n", valueA, valueB, result);
		return "calculator";
	}
}
