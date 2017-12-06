package com.openlab.sherlock.data.remote.request;

import com.openlab.sherlock.data.entity.Interest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Bryam Soto on 06/12/2017.
 */

public interface InterestsRequest {

    @GET("interest_area/")
    Call<List<Interest>> getInterests();

}
