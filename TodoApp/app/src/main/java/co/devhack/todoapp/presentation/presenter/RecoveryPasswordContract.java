package co.devhack.todoapp.presentation.presenter;

/**
 * Created by cdcalvo on 5/12/17.
 */

public interface RecoveryPasswordContract {

    interface View {
        void showErrorMessage(Exception error);

        void showSuccessMessage();
    }

    interface UserActionsListener {
        void onRecoveryPassword(String email);
    }
}
