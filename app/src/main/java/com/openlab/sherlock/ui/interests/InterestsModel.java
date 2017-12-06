package com.openlab.sherlock.ui.interests;

import android.util.Log;

import com.openlab.sherlock.data.entity.Interest;
import com.openlab.sherlock.data.remote.ServiceFactory;
import com.openlab.sherlock.data.remote.request.InterestsRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bryam Soto on 06/12/2017.
 */

public class InterestsModel implements Interests.Model {

    private Interests.Presenter presenter;

    public InterestsModel(Interests.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void findInterests(String search) {
        InterestsRequest interestsRequest = ServiceFactory.createService(InterestsRequest.class);
        Call<List<Interest>> call = interestsRequest.getInterests();
        call.enqueue(new Callback<List<Interest>>() {
            @Override
            public void onResponse(Call<List<Interest>> call, Response<List<Interest>> response) {
                if (response.isSuccessful()) {
                    Log.e("TAG", response.body().toString());
                    ArrayList<Interest> interests = (ArrayList<Interest>) response.body();
                    for (Interest i : interests) {
                        Log.e("TAG", i.getName());
                    }
                    presenter.showInterests(interests);
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<Interest>> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}
