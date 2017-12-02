package co.devhack.todoapp.repository;

import co.devhack.todoapp.domain.model.User;

/**
 * Created by cdcalvo on 30/11/17.
 */

public interface UserRepository {

    void login(String email, String password);

    void signUp(User user);
}
