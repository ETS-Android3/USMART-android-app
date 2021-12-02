package com.example.blackhummer.u_smart.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.blackhummer.u_smart.House.BathRoom;
import com.example.blackhummer.u_smart.House.BedRoom;
import com.example.blackhummer.u_smart.House.Depot;
import com.example.blackhummer.u_smart.House.Irrigation;
import com.example.blackhummer.u_smart.House.Kitchen;
import com.example.blackhummer.u_smart.House.LivingRoom;
import com.example.blackhummer.u_smart.R;

public class ControlFragment extends Fragment {

    CardView bed,bath,living,depot,kitchen,irrigation;

    public ControlFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ctrl_home, container, false);

        CardView bed = view.findViewById(R.id.bed);
        CardView bath = view.findViewById(R.id.bath);
        CardView living = view.findViewById(R.id.living);
        CardView depot = view.findViewById(R.id.depot);
        CardView kitchen = view.findViewById(R.id.kitchen);
        CardView irrigation = view.findViewById(R.id.irrigation);


        bed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BedRoom.class);
                startActivity(intent);
            }
        });



        bath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BathRoom.class);
                startActivity(intent);
            }
        });




        living.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LivingRoom.class);
                startActivity(intent);
            }
        });


        kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Kitchen.class);
                startActivity(intent);
            }
        });


        // Zeydin tawa


        depot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Depot.class);
                startActivity(intent);
            }
        });

        irrigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Irrigation.class);
                startActivity(intent);
            }
        });









        return view;
    }
}
