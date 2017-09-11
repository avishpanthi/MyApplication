package com.example.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.LocationCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ListViewActivity extends AppCompatActivity {
    DatabaseReference reference;
    ListView listView;
    double x;
    double y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView) findViewById(R.id.listView);
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("path/to/geofire/firebase-hq");
//        GeoFire geoFire = new GeoFire(ref);
//        geoFire.getLocation("firebase-hq", new LocationCallback() {
//            @Override
//            public void onLocationResult(String key, GeoLocation location) {
//              x = location.longitude;
//                y = location.latitude;
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
        reference = FirebaseDatabase.getInstance().getReference("Restaurant");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ArrayList<RestList> list = new ArrayList<RestList>();
                for (DataSnapshot a:dataSnapshot.getChildren()){
                    Restaurant restaurant = a.getValue(Restaurant.class);
                    String name = restaurant.getName();
                    double lat = restaurant.getLatitude();
                    double lng = restaurant.getLongitude();
                    list.add(new RestList(name,lat,lng));
                }
            ListAdapter adapter = new ListAdapter(ListViewActivity.this,list);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("dsad", "Failed to read user", databaseError.toException());
            }
        });
    }
//    private void calculateDistance(double x,double y){
//        MapsActivity maps = new MapsActivity();
//        final double x1 = x;
//        final double y1 = y;
//        final double[] x2 = new double[1];
//        final double[] y2 = new double[1];
//
//    }
}
