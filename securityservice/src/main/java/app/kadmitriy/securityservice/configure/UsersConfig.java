package app.kadmitriy.securityservice.configure;

import app.kadmitriy.securityservice.user.model.UserModel;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UsersConfig {

	@Bean
	List<UserModel> getUserModel(){
		List<UserModel> list = Arrays.asList(
				new UserModel(1, "123", "User1", "ok1", 25),
				new UserModel(2, "234", "User2", "ok2", 26),
				new UserModel(3, "345", "User3", "ok3", 27)
		);
		return list;
	}
	
}
