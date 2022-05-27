package p25.gabastore.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import p25.gabastore.api.dtos.UserCreate;
import p25.gabastore.api.dtos.UserSignIn;
import p25.gabastore.api.security.Jwt;
import p25.gabastore.api.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserCreate inputs) {
	service.create(inputs);
    }

    @PostMapping("/sign-in")
    public Jwt signIn(@RequestBody UserSignIn inputs) {
	return service.signIn(inputs);
    }

}
