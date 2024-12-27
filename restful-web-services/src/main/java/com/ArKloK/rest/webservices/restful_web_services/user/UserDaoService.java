package com.ArKloK.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int userCount;
	static {
		users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(20)));
		users.add(new User(++userCount, "Pepe", LocalDate.now().minusYears(12)));
		users.add(new User(++userCount, "Steve", LocalDate.now().minusYears(25)));
		users.add(new User(++userCount, "Jorge", LocalDate.now().minusYears(8)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findUser(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public User saveUser(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

	public void deleteUser(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

}
