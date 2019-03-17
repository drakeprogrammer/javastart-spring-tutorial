package pl.drakeprogrammer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.drakeprogrammer.components.TimeComponent;

@Controller
public class TimeController {

	private TimeComponent timeComponent;

	@Autowired
	public TimeController(TimeComponent timeComponent) {
		this.timeComponent = timeComponent;
	}

	@GetMapping("/time")
	public void provideTime() {
		System.out.println("Time from TimeComponent: " + timeComponent.getCurrentTime());
	}
}
