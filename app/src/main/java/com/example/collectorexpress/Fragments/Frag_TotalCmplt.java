package com.example.collectorexpress.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.collectorexpress.Activities.Act_details;
import com.example.collectorexpress.Activities.Act_home;
import com.example.collectorexpress.Adapter.Ad_list;
import com.example.collectorexpress.ModelDetails;
import com.example.collectorexpress.R;
import com.example.collectorexpress.RecyclerTouchListener;
import com.example.collectorexpress.UtilClass.MarshMallowPermission;
import com.example.collectorexpress.UtilClass.SessionParam;
import com.example.collectorexpress.UtilClass.Utility;
import com.example.collectorexpress.retrofit.BaseRequest;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Frag_TotalCmplt extends Fragment {

    private BaseRequest baseRequest;
    Utility utility;
    Context context;
    Activity activity;
    SessionParam sessionParam;
    MarshMallowPermission marshMallowPermission;
    Toolbar toolbar;
    AppBarLayout appBar;
    FrameLayout lyt_defult;
    RecyclerView rv_list;
    ArrayList<ModelDetails>modelDetails = new ArrayList<>();
    Ad_list ad_list;

    public Frag_TotalCmplt(Toolbar toolbar) {
        this.toolbar = toolbar;
        toolbar.setTitle("Total");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_total_complents, null);

        utility = new Utility();
        sessionParam = new SessionParam(getContext());
        marshMallowPermission = new MarshMallowPermission(getActivity());

        rv_list = view.findViewById(R.id.rv_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_list.setLayoutManager(layoutManager);

        ad_list = new Ad_list(getContext(),modelDetails,sessionParam);
        rv_list.setAdapter(ad_list);

        rv_list.addOnItemTouchListener(new RecyclerTouchListener(getContext(), rv_list, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent = new Intent(getContext(), Act_details.class);
                startActivity(intent);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return view;

    }


}
