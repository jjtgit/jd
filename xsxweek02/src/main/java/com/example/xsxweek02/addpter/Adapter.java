package com.example.xsxweek02.addpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xsxweek02.user.User;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends BaseAdapter {
    private Context context;
    private List<User.DataBean> list;

    public Adapter(Context context) {
        this.context = context;
        this.list=new ArrayList<>();
    }

    public void setList(List<User.DataBean> list) {
        if (list!=null){
            this.list = list;
        }
        notifyDataSetChanged();
    }
    public void addList(List<User.DataBean> list) {
        if (list!=null){
            list.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return convertView;
    }
    class ViewHolder{
        TextView title,price;
    }
    class ViewHolder1{
        TextView title,price;
        ImageView img;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
