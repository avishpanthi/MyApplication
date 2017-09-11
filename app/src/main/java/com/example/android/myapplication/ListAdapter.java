package com.example.android.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sanz on 10/09/2017.
 */

public class ListAdapter extends ArrayAdapter<RestList> {
    private Activity context;
    private List<RestList> restaurantList;
    public ListAdapter(Activity context, List<RestList> restaurantList){
        super(context,R.layout.rest_list,restaurantList);
        this.context = context;
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listVIewItem = inflater.inflate(R.layout.rest_list,null,true);

        TextView name = (TextView) listVIewItem.findViewById(R.id.restName);
        TextView lat = (TextView) listVIewItem.findViewById(R.id.latitude);
        TextView lon = (TextView) listVIewItem.findViewById(R.id.longitude);

        RestList restaurant = restaurantList.get(position);

        name.setText(restaurant.getName());
        String latt = String.valueOf(restaurant.getLatitude());
        String lng = String.valueOf(restaurant.getLongitude());
        lat.setText("Latitude: "+latt);
        lon.setText("Longitude: "+lng);

        return listVIewItem;
    }

}
