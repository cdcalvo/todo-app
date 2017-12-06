package co.devhack.todoapp.domain.usecase.impl;

import co.devhack.todoapp.domain.model.User;
import co.devhack.todoapp.domain.usecase.UserUseCase;
import co.devhack.todoapp.helpers.Callback;
import co.devhack.todoapp.repository.UserRepository;
import co.devhack.todoapp.repository.impl.UserFireBaseRepository;

/**
 * Created by cdcalvo on 2/12/17.
 */

public class UserUseCaseImpl implements UserUseCase {

    private UserRepository userRepository;

    public UserUseCaseImpl() {

        this.userRepository = new UserFireBaseRepository();
    }

    @Override
    public void login(String email, String password, final boolean remember, final Callback<User> callback) {

        userRepository.login(email, password, new Callback<User>() {
            @Override
            public void success(User result) {
                if(result != null && remember){
                    //TODO Guardar Email en SharedPreferences
                }
                callback.success(result);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });

    }

    @Override
    public void signUp(String fullName, String email, String password, final Callback<User> callback) {

        User user = new User(fullName, email, password);
        userRepository.signUp(user, new Callback<User>() {
            @Override
            public void success(User result) {
                callback.success(result);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }

    @Override
    public void recoveryPassword(String email, final Callback<Boolean> callback) {
        userRepository.recoveryPassword(email, new Callback<Boolean>() {
            @Override
            public void success(Boolean result) {
                callback.success(result);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }

}
