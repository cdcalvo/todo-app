package co.devhack.todoapp.presentation.presenter;

import co.devhack.todoapp.domain.usecase.UserUseCase;
import co.devhack.todoapp.domain.usecase.impl.UserUseCaseImpl;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by cdcalvo on 5/12/17.
 */

public class RecoveryPasswordPresenter implements RecoveryPasswordContract.UserActionsListener {

    private RecoveryPasswordContract.View view;
    private UserUseCase userUseCase;

    public RecoveryPasswordPresenter(RecoveryPasswordContract.View view) {
        this.view = view;
        this.userUseCase = new UserUseCaseImpl();
    }

    @Override
    public void onRecoveryPassword(String email) {

        userUseCase.recoveryPassword(email, new Callback<String>() {
            @Override
            public void success(String result) {
                view.showMessageSucces(result);
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }
}
