package co.devhack.todoapp.presentation.presenter;

/**
 * Created by cdcalvo on 30/11/17.
 */

public class AuthPresenter implements AuthContract.UserActionsListener {

    private AuthContract.View view;

    public AuthPresenter(AuthContract.View view) {
        this.view = view;
    }

    @Override
    public void goToFirstFragment() {
        view.goToLoginFragment();

        //view.goToMainActivity();
    }
}
