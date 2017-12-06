package com.openlab.sherlock.ui.login;

/**
 * Created by Bryam Soto on 30/11/2017.
 */

public interface Login {

    interface View {
        void login();

        void loginSuccessful(int user_id);

        void loginError(String error);

        void restorePassword();

        void signUp();
    }

    interface Presenter {

        void loginSuccessful(int user_id);

        void loginError(String error);

        void login(String email, String password);

    }

    interface Model {

        void login(String email, String password);

    }
}
