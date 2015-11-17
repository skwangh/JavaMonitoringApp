package com.ncsoft.platform.javamonitoringapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.ncsoft.platform.javamonitoringapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015-11-15.
 */
public class PerformanceMonitorFragment extends Fragment {

    View view;
    Spinner chartTypeSpinner, chartTimeUnitSpinner;
    ListView chartItemListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_performance_monitor, container, false);
        addItemsOnChartTypeSpinner();
        addItemsOnChartTimeUnitSpinner();
        addItemsOnListChartItem();
        return view;
    }

    private void addItemsOnChartTypeSpinner() {

        chartTypeSpinner = (Spinner) view.findViewById(R.id.spinner_chart_type);
        List<String> list = new ArrayList<String>();
        list.add("AVG_STACK_TIME");
        list.add("MAX_STACK_TIME");
        list.add("TOTAL_COUNT");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, list);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        chartTypeSpinner.setAdapter(dataAdapter);
    }

    private void addItemsOnChartTimeUnitSpinner() {
        chartTimeUnitSpinner = (Spinner) view.findViewById(R.id.spinner_chart_time_unit);
        List<String> list = new ArrayList<String>();
        list.add("THIRTY_SECONDS");
        list.add("FIVE_MINUTES");
        list.add("ONE_HOUR");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.support_simple_spinner_dropdown_item, list);
        dataAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        chartTimeUnitSpinner.setAdapter(dataAdapter);
    }

    private void addItemsOnListChartItem() {
        chartItemListView = (ListView) view.findViewById(R.id.list_view_chart_item);
        List<String> list = new ArrayList<String>();
        list.add("com.ncsoft");
        list.add("com.plaync");
        list.add("com.platform");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);
        chartItemListView.setAdapter(dataAdapter);
    }

}
