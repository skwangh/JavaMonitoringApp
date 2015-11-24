package com.ncsoft.platform.javamonitoringapp.sockets;

import lombok.Setter;

/**
 * Created by skwangh on 2015-11-24.
 */

public abstract class SocketPostProcess implements Runnable {
    @Setter
    protected Object result;
}
