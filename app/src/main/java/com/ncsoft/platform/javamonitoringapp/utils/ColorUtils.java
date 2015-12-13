package com.ncsoft.platform.javamonitoringapp.utils;

import android.graphics.Color;

/**
 * Created by skwangh on 2015-12-11.
 */
public class ColorUtils {

    public static int getColor(int index) {
        return colorSet[index % colorSet.length];
    }

    private static int[] colorSet = new int[] {
            Color.rgb(255,0,0)
            ,Color.rgb(255,153,0)
            ,Color.rgb(204,255,0)
            ,Color.rgb(51,255,0)
            ,Color.rgb(0,255,255)
            ,Color.rgb(0,102,255)
            ,Color.rgb(51,0,255)
            ,Color.rgb(204,0,255)
            ,Color.rgb(255,0,153)
            ,Color.rgb(255,128,128)
            ,Color.rgb(255,204,128)
            ,Color.rgb(229,255,128)
            ,Color.rgb(153,255,128)
            ,Color.rgb(128,255,178)
            ,Color.rgb(128,179,255)
            ,Color.rgb(153,128,255)
            ,Color.rgb(230,128,255)
            ,Color.rgb(255,128,204)
            ,Color.rgb(229,0,0)
            ,Color.rgb(0,204,82)
            ,Color.rgb(0,204,204)
            ,Color.rgb(178,107,0)
            ,Color.rgb(143,179,0)
            ,Color.rgb(0,71,179)
            ,Color.rgb(36,0,179)
            ,Color.rgb(143,0,179)
            ,Color.rgb(178,0,107)
            ,Color.rgb(178,89,89)
            ,Color.rgb(178,143,89)
            ,Color.rgb(161,179,89)
            ,Color.rgb(107,179,89)
            ,Color.rgb(89,125,179)
            ,Color.rgb(107,89,179)
            ,Color.rgb(161,89,179)
            ,Color.rgb(179,89,143)
            ,Color.rgb(153,0,0)
            ,Color.rgb(0,153,153)
            ,Color.rgb(77,153,107)
            ,Color.rgb(102,128,0)
            ,Color.rgb(25,128,0)
            ,Color.rgb(0,128,128)
            ,Color.rgb(26,0,128)
            ,Color.rgb(102,0,0)
            ,Color.rgb(102,61,0)
            ,Color.rgb(0,102,41)
            ,Color.rgb(0,102,102)
            ,Color.rgb(0,41,102)
            ,Color.rgb(82,0,102)
            ,Color.rgb(102,0,61)
            ,Color.rgb(102,51,51)
            ,Color.rgb(102,82,51)
            ,Color.rgb(92,102,51)
            ,Color.rgb(51,71,102)
            ,Color.rgb(61,51,102)
            ,Color.rgb(102,51,82)
    };
}
