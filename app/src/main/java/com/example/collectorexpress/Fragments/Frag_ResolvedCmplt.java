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
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Frag_ResolvedCmplt extends Fragment {

    private BaseRequest baseRequest;
    Context context;
    Activity activity;
    SessionParam sessionParam;
    MarshMallowPermission marshMallowPermission;
    Toolbar toolbar;
    AppBarLayout appBar;

    ViewPager viewPager;
    private TabLayout tabLayout;
    Frag_1 frag_1;
    Frag_2 frag_2;
    Frag_3 frag_3;
    Frag_4 frag_4;

    public Frag_ResolvedCmplt(Toolbar toolbar) {
        this.toolbar=toolbar;
        toolbar.setTitle("Resolved");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.act_tab_layout,null);


        context = getContext();
        activity = getActivity();
        sessionParam = new SessionParam(getContext());

        frag_1 = new Frag_1();
        frag_2 = new Frag_2();
        frag_3 = new Frag_3();
        frag_4 = new Frag_4();

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        appBar =  view.findViewById(R.id.appBar);
        appBar.setPadding(0,0,0,0);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
//        tabLayout.setSmoothScrollingEnabled(true);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(),"onStart - Resolved",Toast.LENGTH_SHORT).show();
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(frag_1, "First");
        adapter.addFragment(frag_2, "Second");
        adapter.addFragment(frag_3, "Third");
        adapter.addFragment(frag_4, "Forth");
        viewPager.setAdapter(adapter);
    }

    public  class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }


    }

}
