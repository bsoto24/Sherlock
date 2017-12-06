package com.openlab.sherlock.ui.login;

/**
 * Created by Bryam Soto on 01/12/2017.
 */

public class LoginPresenter implements Login.Presenter {

    private Login.View view;
    private Login.Model model;

    LoginPresenter(Login.View view) {
        this.view = view;
        model = new LoginModel(this);
    }

    @Override
    public void login(String email, String password) {
        model.login(email, password);
    }

    @Override
    public void loginSuccessful(int user_id) {
        view.loginSuccessful(user_id);
    }

    @Override
    public void loginError(String error) {
        view.loginError(error);
    }
}
