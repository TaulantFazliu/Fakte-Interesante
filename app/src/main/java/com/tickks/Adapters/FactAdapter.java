package com.tickks.Adapters;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.tickks.Factories.ColorFactory;
import com.tickks.R;

import java.util.ArrayList;

public class FactAdapter extends BaseAdapter {

  private Activity activity;
  ArrayList<String> list;
  ColorFactory colorFactory=new ColorFactory();
  String []colors=colorFactory.getColors();
    int []imazhet={R.drawable.ic_filter_1_black_24dp,
                   R.drawable.ic_filter_2_black_24dp,
                   R.drawable.ic_filter_3_black_24dp,
                   R.drawable.ic_filter_4_black_24dp,
                   R.drawable.ic_filter_5_black_24dp,
                   R.drawable.ic_filter_6_black_24dp,
                   R.drawable.ic_filter_7_black_24dp,
                   R.drawable.ic_filter_8_black_24dp,
                   R.drawable.ic_filter_9_black_24dp,
                   R.drawable.ic_forward_10_black_24dp};


  public FactAdapter(Activity activity, ArrayList<String> list) {
    this.activity = activity;
    this.list = list;
  }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    @Override
  public int getCount() {

    return list.size();
  }

  @Override
  public String getItem(int position) {
    return list.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
   View view= LayoutInflater.from(activity).inflate(R.layout.fact_item,null);
   ImageView icon=view.findViewById(R.id.imageView);
      int iconIndex=position%imazhet.length;
      int ikonat=imazhet[iconIndex];
      icon.setImageResource(ikonat);



   String fact=list.get(position);


   int index=position%colors.length;
    String color=colors[index];


   view.setBackgroundColor(R.drawable.gradienti3);

//   icon.setImageResource(R.drawable.ic_lightbulb_outline_black_24dp);



   TextView title=view.findViewById(R.id.fact_text);
   title.setText(fact);
   title.setTextColor(Color.WHITE);



    return view;
  }
}
