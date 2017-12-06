package com.openlab.sherlock.ui.interests;

import com.openlab.sherlock.data.entity.Interest;

import java.util.List;

/**
 * Created by Bryam Soto on 06/12/2017.
 */

public interface Interests {

    interface View {

        void showInterests(List<Interest> interests);

    }

    interface Presenter {

        void showInterests(List<Interest> interests);

        void findInterests(String search);

    }

    interface Model {

        void findInterests(String search);

    }

}
