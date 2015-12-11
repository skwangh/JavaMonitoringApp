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

import java.util.List;

/**
 * Created by skwangh on 2015-12-11.
 */
public class LegendAdapter  extends BaseAdapter {

    private List<LineDataSet> lineDataSetList;

    public LegendAdapter(List<LineDataSet> lineDataSetList) {
        this.lineDataSetList = lineDataSetList;
    }

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

        if (convertView == null) {
            LineDataSet lineDataSet = lineDataSetList.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_legend, parent, false);


            TextView labelView = (TextView) convertView.findViewById(R.id.layout_legend_label);
            labelView.setText(position + " : " + lineDataSet.getLabel());

            LinearLayout colorLayout = (LinearLayout) convertView.findViewById(R.id.layout_legend_color);
            colorLayout.setBackgroundColor(lineDataSet.getColor());
        }

        return convertView;
    }

}
