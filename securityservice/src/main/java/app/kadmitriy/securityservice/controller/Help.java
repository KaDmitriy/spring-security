package app.kadmitriy.securityservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/help")
public class Help {

	@GetMapping("/info")
	public String getInfo() {

		return "ok";
	}

}
