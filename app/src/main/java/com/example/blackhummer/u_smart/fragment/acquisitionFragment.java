package com.example.blackhummer.u_smart.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.blackhummer.u_smart.LoginAfter;
import com.example.blackhummer.u_smart.R;
import com.example.blackhummer.u_smart.aquisition;


public class acquisitionFragment extends Fragment {


    public acquisitionFragment() {
    }
    ImageView go ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.acquisition, container, false);


        ImageView go = (ImageView)view.findViewById(R.id.go);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivtiy();
            }
        });



        return view;
    }

    public void openLoginActivtiy()
    {
        Intent intent = new Intent(getActivity().getApplicationContext(),aquisition.class);
        startActivity(intent);
        //   notificationcall();

    }
}
