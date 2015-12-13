package com.ncsoft.platform.javamonitoringapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ncsoft.platform.javamonitoringapp.R;

/**
 * Created by Administrator on 2015-11-15.
 */
public class StatusCheckFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statuscheck, container, false);
        return view;
    }

}
