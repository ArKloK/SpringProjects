package com.ArKloK.learn_sprng_security.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.RolesAllowed;

@RestController
public class TodoResource {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final List<Todo> TODOS_LIST = List.of(new Todo("carlos", "Learn AWS"),
			new Todo("carlos", "Get AWS Certified"));

	@GetMapping("/todos")
	public List<Todo> retrieveAllTodos() {
		return TODOS_LIST;
	}

	@GetMapping("/users/{username}/todos")
	// @PreAuthorize("hasRole('USER') and #username == authentication.name")
	@PostAuthorize("returnObject.username == 'carlos'")
	@RolesAllowed({ "ADMIN", "USER" })
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	public Todo retrieveTodosForAUser(@PathVariable(name = "username") String username) {
		return TODOS_LIST.get(0);
	}

	@PostMapping("/users/{username}/todos")

	public void createTodosForAUser() {
		logger.info("Create todo for carlos");
	}

}

record Todo(String username, String description) {
}