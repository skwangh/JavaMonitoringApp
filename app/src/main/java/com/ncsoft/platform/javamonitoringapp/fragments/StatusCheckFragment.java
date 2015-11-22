package com.ncsoft.platform.javamonitoringapp.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ncsoft.platform.javamonitoring.component.log.loglevel.LoggerManager;
import com.ncsoft.platform.javamonitoring.component.log.loglevel.domain.LoggerInfo;
import com.ncsoft.platform.javamonitoring.component.remote.socket.SocketCommandCaller;
import com.ncsoft.platform.javamonitoringapp.R;

import java.util.SortedMap;

/**
 * Created by Administrator on 2015-11-15.
 */
public class StatusCheckFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status_check, container, false);
        new SocketTestTask().execute();
        return view;
    }


    private class SocketTestTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            SortedMap<String, LoggerInfo> loggerMap = null;

            String remoteHost = "112.175.202.31:38083";
            Object loggerMapObj = SocketCommandCaller.call(remoteHost, LoggerManager.class, "getLoggerInfoMap", new Object[]{""});

            if (loggerMapObj != null) {
                loggerMap = (SortedMap<String, LoggerInfo>) loggerMapObj;
                for (LoggerInfo loggerInfo : loggerMap.values()) {
                    System.out.println(loggerInfo.getName());
                }
            } else {
                System.out.println("loggerMap is null");
            }
            return null;
        }
    }
}
