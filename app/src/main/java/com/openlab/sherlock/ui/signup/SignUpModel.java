package com.openlab.sherlock.ui.signup;

import com.openlab.sherlock.data.entity.UserResponse;
import com.openlab.sherlock.data.remote.ServiceFactory;
import com.openlab.sherlock.data.remote.request.SignUpRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bryam Soto on 06/12/2017.
 */

public class SignUpModel implements SignUp.Model {

    private SignUp.Presenter presenter;

    public SignUpModel(SignUp.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void signUp(String orcid_code, String role, String unmsm_code, String password, String username, String first_name, String last_name, String email, List<Integer> interestAreas) {
        SignUpRequest measureRequest = ServiceFactory.createService(SignUpRequest.class);
        Call<UserResponse> call = measureRequest.signUp(orcid_code, role, unmsm_code, password, username, first_name, last_name, email, new int[]{1,2});
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    presenter.signUpsuccessfully("Informacion enviada");
                } else {
                    presenter.signUpError("Ocurrio un error uwu");
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                presenter.signUpError("Ocurrio un error conchasumare");
                t.printStackTrace();
            }
        });
    }
}
