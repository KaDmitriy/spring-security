package app.kadmitriy.securityservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.kadmitriy.securityservice.user.model.UserModel;

@RestController
@RequestMapping(value = "/info")
public class Info {

	@Autowired
	private List<UserModel> listUserModel;
	
	@GetMapping("/")
	public String getInfo() {
		
		return "ok";
	}
	
	@GetMapping("/users")
	public List<UserModel> getUsers() {
		
		return listUserModel;
	}
	
}
