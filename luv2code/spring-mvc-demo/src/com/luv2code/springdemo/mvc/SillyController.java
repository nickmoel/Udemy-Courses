package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// Demonstrating an error with spring for using the same mapping in two controllers
// resolved in helloworldcontroller
public class SillyController {

	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "silly";
	}

}
