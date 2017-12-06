package com.openlab.sherlock.ui.interests;

import com.openlab.sherlock.data.entity.Interest;

import java.util.List;

/**
 * Created by Bryam Soto on 06/12/2017.
 */

public class InterestsPresenter implements Interests.Presenter {

    private Interests.View view;
    private Interests.Model model;

    public InterestsPresenter(Interests.View view) {
        this.view = view;
        this.model = new InterestsModel(this);
    }

    @Override
    public void showInterests(List<Interest> interests) {
        view.showInterests(interests);
    }

    @Override
    public void findInterests(String search) {
        model.findInterests(search);
    }
}
