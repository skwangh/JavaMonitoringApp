package com.ncsoft.platform.javamonitoringapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.data.LineDataSet;
import com.ncsoft.platform.javamonitoringapp.R;
import com.ncsoft.platform.javamonitoringapp.fragments.PerformanceMonitorFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by skwangh on 2015-12-11.
 */
public class LegendAdapter extends BaseAdapter {

    private PerformanceMonitorFragment performanceMonitorFragment;
    private List<LineDataSet> lineDataSetList;

    public LegendAdapter(PerformanceMonitorFragment performanceMonitorFragment, List<LineDataSet> lineDataSetList) {
        this.performanceMonitorFragment = performanceMonitorFragment;
        this.lineDataSetList = lineDataSetList;
    }


    private Map<Integer, View> viewMap = new HashMap<Integer, View>();

    /* 추상메서드 구현 */
    @Override
    public int getCount() {
        return lineDataSetList.size();
    }

    @Override
    public Object getItem(int position) {
        return lineDataSetList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        View view = viewMap.get(position);
        if (view == null) {
            LineDataSet lineDataSet = lineDataSetList.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_legend, null);

            TextView labelView = (TextView) view.findViewById(R.id.layout_legend_label);
            labelView.setText(lineDataSet.getLabel());

            LinearLayout colorLayout = (LinearLayout) view.findViewById(R.id.layout_legend_color);
            colorLayout.setBackgroundColor(lineDataSet.getColor());
        }

        return view;
    }

    public void setLineSelected(int position) {
        for (int i = 0 ; i < lineDataSetList.size() ; i++) {
            if (position == i) {
                lineDataSetList.get(i).setLineWidth(4f);
            } else {
                lineDataSetList.get(i).setLineWidth(1f);
            }
        }
    }
}
