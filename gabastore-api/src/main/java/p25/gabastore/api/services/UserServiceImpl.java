package p25.gabastore.api.services;

import java.util.List;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import p25.gabastore.api.dtos.UserCreate;
import p25.gabastore.api.dtos.UserSignIn;

import p25.gabastore.api.entities.Role;
import p25.gabastore.api.entities.User;
import p25.gabastore.api.repositories.UserRepository;
import p25.gabastore.api.security.Jwt;
import p25.gabastore.api.security.JwtProvider;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final PasswordEncoder encoder;

    private final JwtProvider provider;

    public UserServiceImpl(UserRepository repository, PasswordEncoder encoder, JwtProvider provider) {
	this.repository = repository;
	this.encoder = encoder;
	this.provider = provider;
    }

    @Transactional
    @Override
    public void create(UserCreate inputs) {
	User user = new User();
	user.setUsername(inputs.getUsername());
	String encoded = encoder.encode(inputs.getPassword());
	user.setPassword(encoded);
	repository.save(user);
    }

    @Override
    public Jwt signIn(UserSignIn inputs) throws BadCredentialsException {
	String username = inputs.getUsername();
	User user = repository.findByUsernameIgnoreCase(username).orElseThrow(
		() -> new BadCredentialsException(String.format("no user found with username '%s'", username)));
	String password = inputs.getPassword();
	if (!encoder.matches(password, user.getPassword())) {
	    throw new BadCredentialsException(String.format("password does not match for username '%s'", username));
	}
	Role role = user.getRole();
	List<String> roles = null;
	if (role != null) {
	    roles = List.of(role.getName());
	}
	return provider.create(String.valueOf(user.getId()), roles);
    }

}
