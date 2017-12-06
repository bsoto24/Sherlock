package com.openlab.sherlock.data.remote.request;

import com.openlab.sherlock.data.entity.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Bryam Soto on 06/12/2017.
 */

public interface SignUpRequest {

    @FormUrlEncoded
    @POST("investigator/")
    Call<UserResponse> signUp(
            @Field("orcid_code") String orcid_code,
            @Field("role") String role,
            @Field("unmsm_code") String unmsm_code,
            @Field("password") String password,
            @Field("username") String username,
            @Field("first_name") String first_name,
            @Field("last_name") String last_name,
            @Field("email") String email,
            @Field("interest_areas") int[] interest_areas
    );

}
