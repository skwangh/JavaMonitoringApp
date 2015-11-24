package com.ncsoft.platform.javamonitoringapp.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ncsoft.platform.javamonitoring.component.log.loglevel.LoggerManager;
import com.ncsoft.platform.javamonitoring.component.log.loglevel.domain.LoggerInfo;
import com.ncsoft.platform.javamonitoring.component.remote.socket.SocketCommandCaller;
import com.ncsoft.platform.javamonitoringapp.R;
import com.ncsoft.platform.javamonitoringapp.constants.Tags;
import com.ncsoft.platform.javamonitoringapp.sockets.SocketPostProcess;

import java.util.SortedMap;

/**
 * Created by Administrator on 2015-11-15.
 */
public class StatusCheckFragment extends AbstractSocketCommunicateFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status_check, container, false);
        //new GetStatusReportTask().execute();
        new SocketCommunicateTask(new GetStatusPostProcess()).execute(LoggerManager.class, "getLoggerInfoMap", new Object[]{""});
        return view;
    }

    private class GetStatusPostProcess extends SocketPostProcess {

        @Override
        public void run() {
            if (result != null) {
                SortedMap<String, LoggerInfo> loggerMap = (SortedMap<String, LoggerInfo>) result;
                for (LoggerInfo loggerInfo : loggerMap.values()) {
                    Log.i(Tags.APP, loggerInfo.getName());
                }
            } else {
                Log.e(Tags.APP, "loggerMap is null");
            }
        }
    }

//    private class GetStatusReportTask extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected Void doInBackground(Void... params) {
//            SortedMap<String, LoggerInfo> loggerMap = null;
//
//            String remoteHost = "112.175.202.31:38083";
//            Object loggerMapObj = SocketCommandCaller.call(remoteHost, LoggerManager.class, "getLoggerInfoMap", new Object[]{""});
//
//        }
//    }
}
