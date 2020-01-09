package com.example.collectorexpress.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.collectorexpress.R;
import com.example.collectorexpress.UtilClass.MarshMallowPermission;
import com.example.collectorexpress.UtilClass.SessionParam;
import com.example.collectorexpress.retrofit.BaseRequest;
import com.google.android.material.appbar.AppBarLayout;

public class Frag_PendingCmplt extends Fragment {

    private BaseRequest baseRequest;
    Context context;
    Activity activity;
    SessionParam sessionParam;
    MarshMallowPermission marshMallowPermission;
    Toolbar toolbar;
    AppBarLayout appBar;


    public Frag_PendingCmplt(Toolbar toolbar) {
        this.toolbar=toolbar;
        toolbar.setTitle("Total");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_pending_complents,null);


        return view;
    }



}
