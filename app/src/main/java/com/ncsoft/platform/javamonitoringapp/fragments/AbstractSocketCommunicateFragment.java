package com.ncsoft.platform.javamonitoringapp.fragments;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;

import com.ncsoft.platform.javamonitoring.component.remote.socket.SocketCommandCaller;
import com.ncsoft.platform.javamonitoringapp.constants.Servers;
import com.ncsoft.platform.javamonitoringapp.sockets.SocketPostProcess;


/**
 * Created by skwangh on 2015-11-24.
 */
public class AbstractSocketCommunicateFragment extends Fragment {

    protected String remoteHost = Servers.SOCKET_COMMAND_HOST;


    protected class SocketCommunicateTask extends AsyncTask<Object, Void, Object> {

        private SocketPostProcess socketPostProcess;

        public SocketCommunicateTask(SocketPostProcess postProcess) {
            this.socketPostProcess = postProcess;
        }

        @Override
        protected Object doInBackground(Object... params) {
            Object result = SocketCommandCaller.call(remoteHost, params[0], (String)params[1], (Object[])params[2]);
            return result;
        }

        @Override
        protected void onPostExecute(Object result) {
            super.onPostExecute(result);

            socketPostProcess.setResult(result);
            socketPostProcess.run();
        }
    }
}
