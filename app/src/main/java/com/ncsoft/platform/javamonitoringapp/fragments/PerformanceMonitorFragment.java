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
import com.github.mikephil.charting.data.LineDataSet;
import com.ncsoft.platform.javamonitoringapp.R;
import com.ncsoft.platform.javamonitoringapp.adapters.LegendAdapter;
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
        chartItemListView = (ListView) view.findViewById(R.id.list_view_chart_item);

        List<LineDataSet> lineDataSetList = chart.getData().getDataSets();

        LegendAdapter legendAdapter = new LegendAdapter(lineDataSetList);

        chartItemListView.setAdapter(legendAdapter);

    }

}
