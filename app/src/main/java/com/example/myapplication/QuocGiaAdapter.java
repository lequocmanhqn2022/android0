package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class QuocGiaAdapter extends BaseAdapter {

    Context context;
    ArrayList<QuocGia> listQuocGia;

    public QuocGiaAdapter(Context context, ArrayList<QuocGia> listQuocGia) {
        this.context = context;
        this.listQuocGia = listQuocGia;
    }


    @Override
    public int getCount() {

        return listQuocGia.size();
    }

    @Override
    public Object getItem(int i) {
        return listQuocGia.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View myView = layoutInflater.inflate(R.layout.dong_quoc_gia, null);

        TextView txtQuocgia = myView.findViewById(R.id.txtQuocgia);
        ImageView imgQuocgia = myView.findViewById(R.id.imagehinh);
        TextView txtToaDo = myView.findViewById(R.id.txtName);

        txtQuocgia.setText(listQuocGia.get(i).ten);
        Glide.with(context).load(listQuocGia.get(i).hinh).into(imgQuocgia);
        txtToaDo.setText(String.valueOf(listQuocGia.get(i).toado));

        return myView;
    }
}
