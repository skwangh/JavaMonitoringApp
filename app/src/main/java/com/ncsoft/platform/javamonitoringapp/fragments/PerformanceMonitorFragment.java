package com.ncsoft.platform.javamonitoringapp.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapLabel;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.ncsoft.platform.javamonitoringapp.R;
import com.ncsoft.platform.javamonitoringapp.adapters.LegendAdapter;
import com.ncsoft.platform.javamonitoringapp.utils.MpChartUtils;

import java.util.ArrayList;
import java.util.List;

import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

/**
 * Created by Administrator on 2015-11-15.
 */
public class PerformanceMonitorFragment extends Fragment implements OnChartValueSelectedListener {

    View view;

    Spinner chartTypeSpinner, chartTimeUnitSpinner;
    LineChart chart;
    ListView chartItemListView;
    LegendAdapter legendAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_performancemonitor, container, false);
        addItemsOnChartTypeSpinner();
        addItemsOnChartTimeUnitSpinner();

        //draw chart
        chart = (LineChart)view.findViewById(R.id.view_chart);
        Legend legend = chart.getLegend();
        legend.setEnabled(false);
        chart.setDescription("");
        chart.setTouchEnabled(true);
        chart.setMarkerView(new SimpleMarkerView(view.getContext(), R.layout.layout_markerview));
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getXAxis().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisRight().setDrawLabels(false);
        chart.setOnChartValueSelectedListener(this);
        chart.setData(MpChartUtils.getDummyData(0));
        chart.invalidate();

        //draw custom legend
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
        //chartItemListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        List<LineDataSet> lineDataSetList = chart.getData().getDataSets();

        legendAdapter = new LegendAdapter(this, lineDataSetList);

        chartItemListView.setAdapter(legendAdapter);

        chartItemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                updateSelectedChartItem(position);
            }
        });
    }

    //리스트에서 클릭할때
    private void updateSelectedChartItem(int position) {
        legendAdapter.setLineSelected(position);
        chart.invalidate();
        chart.setDrawMarkerViews(false);    //markerView를 그리지 않는다.
    }

    //차트에서 선택할때
    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        chartItemListView.setSelection(dataSetIndex);
        chartItemListView.performItemClick(null, dataSetIndex, legendAdapter.getItemId(dataSetIndex));
        chart.setDrawMarkerViews(true);    //markerView를 그려준다.
    }

    @Override
    public void onNothingSelected() {
        //Do Nothing
    }


    public class SimpleMarkerView extends MarkerView {

        private BootstrapLabel marker;

        public SimpleMarkerView(Context context, int layoutResource) {
            super(context, layoutResource);
            marker = (BootstrapLabel) findViewById(R.id.label_markerview);
        }

        @Override
        public void refreshContent(Entry e, Highlight highlight) {
            String xVal = chart.getXAxis().getValues().get(highlight.getXIndex());
            marker.setText(xVal + "\n" + e.getVal());
        }

        @Override
        public int getXOffset(float xpos) {
            int defaultOffset = getWidth() / 2;
            if (xpos < defaultOffset) {
                return (int)xpos * -1;
            } else if (chart.getWidth() - xpos < defaultOffset) {
                return (int)(getWidth() - (chart.getWidth() - xpos)) * -1;
            } else {
                return defaultOffset * -1;
            }
        }

        @Override
        public int getYOffset(float ypos) {
            return (int)(getHeight() * -1.2);
        }
    }
}
