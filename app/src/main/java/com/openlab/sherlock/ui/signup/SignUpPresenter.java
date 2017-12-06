package com.openlab.sherlock.ui.signup;

import java.util.List;

/**
 * Created by Bryam Soto on 06/12/2017.
 */

public class SignUpPresenter implements SignUp.Presenter {

    private SignUp.View view;
    private SignUp.Model model;

    public SignUpPresenter(SignUp.View view) {
        this.view = view;
        model = new SignUpModel(this);
    }

    @Override
    public void signUpsuccessfully(String message) {
        view.signUpsuccessfully(message);
    }

    @Override
    public void signUpError(String error) {
        view.signUpError(error);
    }

    @Override
    public void signUp(String orcid_code, String role, String unmsm_code, String password, String username, String first_name, String last_name, String email, List<Integer> interestAreas) {
        model.signUp(orcid_code, role, unmsm_code, password, username, first_name, last_name, email, interestAreas);
    }
}
