package co.devhack.todoapp.presentation.presenter;

/**
 * Created by cdcalvo on 30/11/17.
 */

public interface AuthContract  {

    //Interface que implementará el Fragment o Activity
    interface View{
        void goToLoginFragment();

        void goToMainActivity();
    }

    //Interface que implementará el presenter
    interface UserActionsListener{
        void goToFirstFragment();

    }

}
