package com.openlab.sherlock.ui.interests;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.openlab.sherlock.R;
import com.openlab.sherlock.data.entity.Interest;
import com.openlab.sherlock.ui.main.MainActivity;
import com.openlab.sherlock.ui.signup.SignUpActivity;

import java.util.List;

public class InterestsActivity extends AppCompatActivity implements Interests.View {

    private RecyclerView rvInterests;
    private Button btnContinue;
    private Interests.Presenter presenter;
    private InterestsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);

        showToolbar("Tópicos", false);

        rvInterests = findViewById(R.id.rv_interests);
        btnContinue = findViewById(R.id.btn_continue);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InterestsActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        presenter = new InterestsPresenter(this);
        presenter.findInterests("");

        rvInterests.setLayoutManager(new GridLayoutManager(this, 3));

    }

    @Override
    public void showInterests(List<Interest> interests) {
        adapter = new InterestsAdapter(interests, this);
        rvInterests.setAdapter(adapter);
    }

    public void showToolbar(String title, boolean upButton) {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText(title);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
