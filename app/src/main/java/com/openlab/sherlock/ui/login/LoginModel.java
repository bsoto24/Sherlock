package com.openlab.sherlock.ui.login;

/**
 * Created by Bryam Soto on 01/12/2017.
 */

public class LoginModel implements Login.Model {

    private Login.Presenter presenter;

    LoginModel(Login.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void login(String email, String password) {
//        LoginRequest loginService =
//                ServiceFactory.createService(LoginRequest.class);
//        Call<User> call = loginService.login(email, password);
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                if (response.isSuccessful() && response.body().getAccountLevel().equals("operator")) {
//                    presenter.loginSuccessful(response.body().getProtectedNaturalArea().getId(), response.body().getProtectedNaturalArea().getName());
//                } else {
//                    presenter.loginError("Correo y/o contraseña inválido");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                presenter.loginError("Vuelve a intentarlo cuando tengas conexión");
//            }
//        });

        if (email.equals("") && password.equals("")) {
            presenter.loginSuccessful(1);
        } else {
            presenter.loginError("Correo y/o contraseña inválido");
        }
    }

}
