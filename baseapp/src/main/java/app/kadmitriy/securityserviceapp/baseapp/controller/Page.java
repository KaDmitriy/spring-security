package app.kadmitriy.securityserviceapp.baseapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Page {

	@GetMapping("/")
	String getIndex() {
		return "index";
	}
	
	
	
}
