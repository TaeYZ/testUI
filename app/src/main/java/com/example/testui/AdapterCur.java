package com.example.testui;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterCur extends BaseAdapter {
    List<Item> list;
    Context context;

    //初始化
    public AdapterCur(List<Item> list, Context context) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        return list.size();
    }

    public Item getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.activity_test4_1, null);
            viewHolder=new ViewHolder();
            viewHolder.imageView=(ImageView) convertView.findViewById(R.id.img);
            viewHolder.textView=(TextView) convertView.findViewById(R.id.text_view);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }

        int a = Color.parseColor("#ABC000");
        int b = Color.parseColor("#FFFFFF");
        viewHolder.textView.setText(list.get(position).getName());
        //改变选中颜色
        if(list.get(position).isBo() == true){
            viewHolder.textView.setBackgroundColor(a);
            viewHolder.imageView.setBackgroundColor(a);
        }
        else {
            viewHolder.textView.setBackgroundColor(b);
            viewHolder.imageView.setBackgroundColor(b);

        }
        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}