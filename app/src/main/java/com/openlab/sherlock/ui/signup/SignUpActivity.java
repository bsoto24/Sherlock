package com.openlab.sherlock.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.openlab.sherlock.R;
import com.openlab.sherlock.ui.interests.InterestsActivity;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity implements SignUp.View {

    private Button btnSignUp;
    private SignUp.Presenter presenter;
    String[] rol = {"Pregrado", "Bachiller", "Docente", "Postgrado"};
    String[] role = {"undergraduate", "bachelor", "professor", "postgraduate"};
    int rolePosition = 0;

    private TextInputEditText edtFirstName, edtLastName, edtEmail, edtPassword, edtORCID, edtUNMSM;
    private Spinner spnRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);
        showToolbar("Regístrate", true);

        presenter = new SignUpPresenter(this);

        spnRole = findViewById(R.id.spn_role);
        edtFirstName = findViewById(R.id.edt_first_name);
        edtLastName = findViewById(R.id.edt_last_name);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        edtUNMSM = findViewById(R.id.edt_unmsm);
        edtORCID = findViewById(R.id.edt_orcid);

        spnRole.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rol));
        spnRole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                rolePosition = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //nothing
            }
        });

        btnSignUp = findViewById(R.id.btn_sign_up);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("TAG", edtORCID.getText().toString());
                Log.e("TAG", role[rolePosition]);
                Log.e("TAG", edtUNMSM.getText().toString());
                Log.e("TAG", edtPassword.getText().toString());
                Log.e("TAG", edtEmail.getText().toString());
                Log.e("TAG", edtFirstName.getText().toString());
                Log.e("TAG", edtLastName.getText().toString());
                Log.e("TAG", edtEmail.getText().toString());

                presenter.signUp(
                        edtORCID.getText().toString(),
                        role[rolePosition],
                        edtUNMSM.getText().toString(),
                        edtPassword.getText().toString(),
                        edtEmail.getText().toString(),
                        edtFirstName.getText().toString(),
                        edtLastName.getText().toString(),
                        edtEmail.getText().toString(),
                        new ArrayList<Integer>());
            }
        });

    }

    public void showToolbar(String title, boolean upButton) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void signUpsuccessfully(String message) {
        Intent intent = new Intent(SignUpActivity.this, InterestsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void signUpError(String error) {
        Snackbar.make(findViewById(R.id.container), error, Snackbar.LENGTH_LONG).show();
    }
}