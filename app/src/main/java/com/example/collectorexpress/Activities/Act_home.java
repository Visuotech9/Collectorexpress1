package com.example.collectorexpress.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.transition.Fade;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.collectorexpress.Fragments.Frag_PendingCmplt;
import com.example.collectorexpress.Fragments.Frag_ResolvedCmplt;
import com.example.collectorexpress.Fragments.Frag_TotalCmplt;
import com.example.collectorexpress.R;
import com.example.collectorexpress.UtilClass.MarshMallowPermission;
import com.example.collectorexpress.UtilClass.SessionParam;
import com.example.collectorexpress.retrofit.BaseRequest;
import com.example.collectorexpress.retrofit.RequestReciever;
import com.transitionseverywhere.extra.Scale;

public class Act_home extends AppCompatActivity implements View.OnClickListener {

    private BaseRequest baseRequest;
    Context context;
    Activity activity;
    SessionParam sessionParam;
    MarshMallowPermission marshMallowPermission;
    Toolbar toolbar;
    ActionBar actionBar;

    FrameLayout lyt_defult;
    Button btn_1, btn_2, btn_3;
    Fragment fragment;
    FragmentTransaction fragmentManager;
    ProgressBar Progressbar1, Progressbar2, Progressbar3, Progressbar4;
    int progressBarValue = 0;
    Handler handler = new Handler();
    CardView card_view1, card_view2, card_view3, card_view4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_home);

        init();

        Progressbar1.setProgress(40);
        Progressbar2.setProgress(50);
        Progressbar3.setProgress(70);
        Progressbar4.setProgress(20);
    }

    private void init() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Home");
        toolbar.setTitleTextColor((Color.parseColor("#FFFFFF")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        context = this;
        activity = this;
        sessionParam = new SessionParam(getApplicationContext());
        marshMallowPermission = new MarshMallowPermission(activity);

        lyt_defult = findViewById(R.id.lyt_defult);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.activity_act_home, null);
        lyt_defult.addView(rowView, lyt_defult.getChildCount());

        card_view1 = findViewById(R.id.card_view1);
        card_view2 = findViewById(R.id.card_view2);
        card_view3 = findViewById(R.id.card_view3);
        card_view4 = findViewById(R.id.card_view4);


        Animation aniSlide1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right);
        card_view1.startAnimation(aniSlide1);

        Animation aniSlide2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left);
        card_view2.startAnimation(aniSlide2);
//
        Animation aniSlide3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.left_to_right);
        card_view3.startAnimation(aniSlide3);

        Animation aniSlide4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.right_to_left);
        card_view4.startAnimation(aniSlide4);

        Progressbar1 = (ProgressBar) findViewById(R.id.progressBar1);
        Progressbar2 = (ProgressBar) findViewById(R.id.progressBar2);
        Progressbar3 = (ProgressBar) findViewById(R.id.progressBar3);
        Progressbar4 = (ProgressBar) findViewById(R.id.progressBar4);

        card_view1.setOnClickListener(this);
        card_view2.setOnClickListener(this);
        card_view3.setOnClickListener(this);
        card_view4.setOnClickListener(this);


    }

    public void sendAPI() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.card_view1:
                actionBar.setDisplayHomeAsUpEnabled(true);
                Fragment fragment1 = new Frag_TotalCmplt(toolbar);
                loadFragment(fragment1);
                break;

            case R.id.card_view2:
                actionBar.setDisplayHomeAsUpEnabled(true);
                Fragment fragment2 = new Frag_TotalCmplt(toolbar);
                loadFragment(fragment2);
                break;

            case R.id.card_view3:
                actionBar.setDisplayHomeAsUpEnabled(true);
                Fragment fragment3 = new Frag_TotalCmplt(toolbar);
                loadFragment(fragment3);
                break;

            case R.id.card_view4:
                actionBar.setDisplayHomeAsUpEnabled(true);
                Fragment fragment4 = new Frag_TotalCmplt(toolbar);
                loadFragment(fragment4);
                break;

        }
    }

    private void loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.lyt_defult, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        toolbar.setTitle("Collector Express");
        actionBar.setDisplayHomeAsUpEnabled(false);
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStackImmediate();
        } else {
            super.onBackPressed();

        }
        return true;
    }

    @Override
    public void onBackPressed() {
        toolbar.setTitle("Collector Express");
        actionBar.setDisplayHomeAsUpEnabled(false);
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStackImmediate();
        } else {
            super.onBackPressed();

        }
    }
}
