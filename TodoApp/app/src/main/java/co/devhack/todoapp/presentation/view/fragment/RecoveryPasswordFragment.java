package co.devhack.todoapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.devhack.todoapp.R;
import co.devhack.todoapp.helpers.Utilities;
import co.devhack.todoapp.presentation.presenter.RecoveryPasswordContract;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecoveryPasswordFragment extends DialogFragment implements RecoveryPasswordContract.View, View.OnClickListener {

    private RecoveryPasswordContract.UserActionsListener mActionsListener;
    private TextInputLayout tilEmail;

    public RecoveryPasswordFragment() {
        // Required empty public constructor
    }

    public static RecoveryPasswordFragment getInstance(){
        return new RecoveryPasswordFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recover_password, container, false);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnRecoveryPassword:
                onRecoveryPassword();
                break;
        }
    }

    @Override
    public void showMessageSucces(String message) {

    }

    @Override
    public void showMessageError(Exception error) {

    }

    public void onRecoveryPassword(){

        try{
            boolean result = true;
            String email = tilEmail.getEditText().getText().toString();

            if(Utilities.isEmpty(email)){
                tilEmail.setError(getString(R.string.is_required));
                tilEmail.setErrorEnabled(true);
                result = false;
            }else{
                tilEmail.setError(null);
                tilEmail.setErrorEnabled(false);
            }

            if(result){
                mActionsListener.onRecoveryPassword(email);
            }
        }catch (Exception e){

        }
    }
}
