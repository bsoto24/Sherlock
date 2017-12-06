package com.openlab.sherlock.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.openlab.sherlock.R;
import com.openlab.sherlock.ui.main.MainActivity;
import com.openlab.sherlock.ui.pasword.PasswordActivity;
import com.openlab.sherlock.ui.signup.SignUpActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, Login.View {

    private Button btnLogin;
    private TextView tvSignUp, tvRestorePassword;
    private TextInputEditText edtEmail, edtPassword;

    private Login.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        tvSignUp = findViewById(R.id.tv_sign_up);
        tvRestorePassword = findViewById(R.id.tv_restore_password);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);

        btnLogin.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);
        tvRestorePassword.setOnClickListener(this);

        presenter = new LoginPresenter(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.tv_sign_up:
                signUp();
                break;
            case R.id.tv_restore_password:
                restorePassword();
                break;
        }

    }

    @Override
    public void login() {
        presenter.login(edtEmail.getText().toString(), edtPassword.getText().toString());
    }

    @Override
    public void loginSuccessful(int user_id) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void loginError(String error) {
        Snackbar.make(findViewById(R.id.container), error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void restorePassword() {
        Intent intent = new Intent(LoginActivity.this, PasswordActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void signUp() {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}
