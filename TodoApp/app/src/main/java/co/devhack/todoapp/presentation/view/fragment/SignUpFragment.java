package co.devhack.todoapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.devhack.todoapp.R;
import co.devhack.todoapp.presentation.presenter.SignUpContract;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements SignUpContract.View{


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
        return view;
    }

    @Override
    public void goToLoginFragment() {
        getChildFragmentManager().popBackStack();
    }

    @Override
    public void goToMainActivity() {

    }
}
