package co.devhack.todoapp.presentation.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import co.devhack.todoapp.R;
import co.devhack.todoapp.helpers.Utilities;
import co.devhack.todoapp.presentation.presenter.SignUpContract;
import co.devhack.todoapp.presentation.presenter.SignUpPresenter;
import co.devhack.todoapp.presentation.view.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements SignUpContract.View, View.OnClickListener {

    private SignUpContract.UserActionsListener mActionsListener;
    private TextInputLayout tilFullName, tilEmail, tilPassword;
    private Button btnSignUp, btnHaveAccount;

    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment getInstance(){
        return new SignUpFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        mActionsListener = new SignUpPresenter(this);

        tilFullName = (TextInputLayout) view.findViewById(R.id.tilFullName);
        tilEmail = (TextInputLayout) view.findViewById(R.id.tilEmail);
        tilPassword = (TextInputLayout) view.findViewById(R.id.tilPassword);
        btnSignUp = (Button) view.findViewById(R.id.btnSignUp);
        btnHaveAccount = (Button) view.findViewById(R.id.btnHaveAccount);

        //Asignar eventos a los Botones
        btnSignUp.setOnClickListener(this);
        btnHaveAccount.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnSignUp:
                onSignUp();
                break;
            case R.id.btnHaveAccount:
                goToLoginFragment();
                break;
        }
    }

    @Override
    public void goToLoginFragment() {
        getChildFragmentManager().popBackStack();
    }

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showMessageError(Exception error) {
        Snackbar.make(getView(), error.getMessage(), Snackbar.LENGTH_LONG).show();
    }

    public void onSignUp(){
        try{
            boolean result = true;
            String fullName = tilFullName.getEditText().getText().toString();
            String email = tilEmail.getEditText().getText().toString();
            String password = tilPassword.getEditText().getText().toString();

            if(Utilities.isEmpty(fullName)){
                tilFullName.setError(getString(R.string.is_required));
                tilFullName.setErrorEnabled(true);
                result = false;
            }else{
                tilFullName.setError(null);
                tilFullName.setErrorEnabled(false);
            }

            if(Utilities.isEmpty(email)){
                tilEmail.setError(getString(R.string.is_required));
                tilEmail.setErrorEnabled(true);
                result = false;
            }else{
                tilEmail.setError(null);
                tilEmail.setErrorEnabled(false);
            }

            if(Utilities.isEmpty(password)){
                tilPassword.setError(getString(R.string.is_required));
                tilPassword.setErrorEnabled(true);
                result = false;
            }else{
                tilPassword.setError(null);
                tilPassword.setErrorEnabled(false);
            }

            if(result){
                mActionsListener.onSignUp(fullName, email, password);
            }
        }catch (Exception e){

        }
    }

}
