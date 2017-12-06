package com.openlab.sherlock.ui.signup;

import java.util.List;

/**
 * Created by Bryam Soto on 06/12/2017.
 */

public interface SignUp {

    interface View {

        void signUpsuccessfully(String message);

        void signUpError(String error);

    }

    interface Presenter {

        void signUpsuccessfully(String message);

        void signUpError(String error);

        void signUp(String orcid_code, String role, String unmsm_code, String password, String username, String first_name, String last_name, String email, List<Integer> interestAreas);


    }

    interface Model {

        void signUp(String orcid_code, String role, String unmsm_code, String password, String username, String first_name, String last_name, String email, List<Integer> interestAreas);

    }

}
