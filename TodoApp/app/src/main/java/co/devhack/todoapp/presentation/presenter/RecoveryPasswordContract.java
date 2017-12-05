package co.devhack.todoapp.presentation.presenter;

/**
 * Created by cdcalvo on 5/12/17.
 */

public interface RecoveryPasswordContract {

    interface View {

        void showMessageSucces(String message);

        void showMessageError(Exception error);
    }

    interface UserActionsListener {

        void onRecoveryPassword(String email);
    }
}
