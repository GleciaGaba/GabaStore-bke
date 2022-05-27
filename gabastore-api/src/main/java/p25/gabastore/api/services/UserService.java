package p25.gabastore.api.services;

import p25.gabastore.api.dtos.UserCreate;
import p25.gabastore.api.dtos.UserSignIn;
import p25.gabastore.api.security.Jwt;

public interface UserService {

    void create(UserCreate inputs);

    Jwt signIn(UserSignIn inputs);

}
