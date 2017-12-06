package com.openlab.sherlock.ui.pasword;

/**
 * Created by Bryam Soto on 01/12/2017.
 */

public interface Password {


    interface View {
        void restorePassword();

        void restoreSuccessfull(String message);

        void restoreError(String error);
    }

    interface Presenter {
        void restorePassword(String email);

        void restoreSuccessfull(String message);

        void restoreError(String error);

    }

    interface Model {
        void restorePassword(String email);
    }
}
