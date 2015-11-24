package com.ncsoft.platform.javamonitoringapp.sockets;

import lombok.Data;

/**
 * Created by skwangh on 2015-11-24.
 */

@Data
public class SocketParam {
    private Class<?> targetClass;
    private String targetMethod;
    private Object[] methodParams;
}
