package com.example.collectorexpress.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.collectorexpress.R;

public class Frag_3 extends Fragment {

    Toolbar toolbar;

    public Frag_3() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_resolved_complents,null);


        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(),"onStart",Toast.LENGTH_SHORT).show();
    }

}
