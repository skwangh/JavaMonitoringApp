package com.ncsoft.platform.javamonitoringapp.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.ncsoft.platform.javamonitoringapp.R;
import com.ncsoft.platform.javamonitoringapp.utils.MpChartUtils;

import java.util.ArrayList;
import java.util.List;

import android.view.ViewGroup.LayoutParams;

/**
 * Created by Administrator on 2015-11-15.
 */
public class PerformanceMonitorFragment extends Fragment {

    View view;
    Spinner chartTypeSpinner, chartTimeUnitSpinner;
    ListView chartItemListView;
    LineChart chart;

    RelativeLayout layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_performance_monitor, container, false);
        layout = (RelativeLayout)view.findViewById(R.id.layout_performance_monitor);
        addItemsOnChartTypeSpinner();
        addItemsOnChartTimeUnitSpinner();

        chart = (LineChart)view.findViewById(R.id.view_chart);
        chart.setData(MpChartUtils.getDummyData(0));
        chart.invalidate();

        Legend legend = chart.getLegend();
        legend.setEnabled(false);

        addItemsOnListChartItem();


        return view;
    }

//    private void customLegend() {
//
//        int colorcodes[] = legend.getColors();
//        String lables[] = legend.getLabels();
//
//        for (int i = 0; i <  colorcodes.length ; i++) {
//            LinearLayout.LayoutParams parms_left_layout = new LinearLayout.LayoutParams(
//                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//            parms_left_layout.weight = 1F;
//            LinearLayout left_layout = new LinearLayout(getActivity());
//            left_layout.setOrientation(LinearLayout.HORIZONTAL);
//            left_layout.setGravity(Gravity.CENTER);
//            left_layout.setLayoutParams(parms_left_layout);
//
//            LinearLayout.LayoutParams parms_legen_layout = new LinearLayout.LayoutParams(
//                    20, 20);
//            parms_legen_layout.setMargins(0, 0, 20, 0);
//            LinearLayout legend_layout = new LinearLayout(getActivity());
//            legend_layout.setLayoutParams(parms_legen_layout);
//            legend_layout.setOrientation(LinearLayout.HORIZONTAL);
//            legend_layout.setBackgroundColor(colorcodes[i]);
//            left_layout.addView(legend_layout);
//
//            TextView txt_unit = new TextView(getActivity());
//            txt_unit.setText(legend.getLabel(i));
//            left_layout.addView(txt_unit);
//
//            LinearLayout.LayoutParams parms_middle_layout = new LinearLayout.LayoutParams(
//                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//            parms_middle_layout.weight = 1F;
//            LinearLayout middle_layout = new LinearLayout(getActivity());
//            middle_layout.setOrientation(LinearLayout.HORIZONTAL);
//            middle_layout.setGravity(Gravity.CENTER);
//            middle_layout.setLayoutParams(parms_middle_layout);
//
//            TextView txt_leads = new TextView(getActivity());
//            txt_leads.setText("450");
//            middle_layout.addView(txt_leads);
//
//            LinearLayout.LayoutParams parms_right_layout = new LinearLayout.LayoutParams(
//                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//            parms_right_layout.weight = 1F;
//            LinearLayout right_layout = new LinearLayout(getActivity());
//            right_layout.setOrientation(LinearLayout.HORIZONTAL);
//            right_layout.setGravity(Gravity.CENTER);
//            right_layout.setLayoutParams(parms_right_layout);
//
//            TextView txt_leads_percentage = new TextView(getActivity());
//            txt_leads_percentage.setText(lables[i]);
//            right_layout.addView(txt_leads_percentage);
//
//            layout.addView(left_layout);
//            layout.addView(middle_layout);
//            layout.addView(right_layout);
//
//        }
//    }

    private void addItemsOnChartTypeSpinner() {

        chartTypeSpinner = (Spinner) view.findViewById(R.id.spinner_chart_type);
        List<String> list = new ArrayList<String>();
        list.add("AVG_STACK_TIME");
        list.add("MAX_STACK_TIME");
        list.add("TOTAL_COUNT");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.layout_spinner, list);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        chartTypeSpinner.setAdapter(dataAdapter);
    }

    private void addItemsOnChartTimeUnitSpinner() {
        chartTimeUnitSpinner = (Spinner) view.findViewById(R.id.spinner_chart_time_unit);
        List<String> list = new ArrayList<String>();
        list.add("THIRTY_SECONDS");
        list.add("FIVE_MINUTES");
        list.add("ONE_HOUR");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.layout_spinner, list);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        chartTimeUnitSpinner.setAdapter(dataAdapter);
    }

    private void addItemsOnListChartItem() {
        Legend legend = chart.getLegend();
        int colors[] = legend.getColors();
        String lables[] = legend.getLabels();

        chartItemListView = (ListView) view.findViewById(R.id.list_view_chart_item);
        List<String> list = new ArrayList<String>();
        for (int i = 0 ; i < lables.length ; i++) {
            list.add(lables[i]);
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.layout_legend, list);
        chartItemListView.setAdapter(dataAdapter);
//        chartItemListView.setSelection(9);
//        chartItemListView.getChildAt(9).setBackgroundColor(Color.BLUE);
    }

}
