package co.devhack.todoapp.presentation.presenter;

/**
 * Created by cdcalvo on 30/11/17.
 */

public interface LoginContract {

    interface View{
        void goToSignUpFragment();

        void goToMainActivity();
    }

    interface UserActionsListener{
        void onLogin(String email, String password, boolean remember);
    }
}
