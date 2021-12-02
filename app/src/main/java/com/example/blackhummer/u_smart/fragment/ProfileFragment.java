package com.example.blackhummer.u_smart.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.blackhummer.u_smart.Family.FamilyActivity;
import com.example.blackhummer.u_smart.Features.RoomCRUD.ShowRoomList.RoomListActivity;
import com.example.blackhummer.u_smart.House.BedRoom;
import com.example.blackhummer.u_smart.Login;
import com.example.blackhummer.u_smart.ProfileManagment.Profile;
import com.example.blackhummer.u_smart.ProfileManagment.Reclamation;
import com.example.blackhummer.u_smart.R;
import com.example.blackhummer.u_smart.Rooms.Rooms;

public class ProfileFragment extends Fragment {

    CardView profile;



    public ProfileFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.userlayout, container, false);

        CardView bed = view.findViewById(R.id.profile);
        CardView reclamation = view.findViewById(R.id.reclamation);
        CardView room = view.findViewById(R.id.room);
        CardView down = view.findViewById(R.id.down);
        CardView Family = view.findViewById(R.id.Family);



        bed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Profile.class);
                startActivity(intent);
            }
        });

        reclamation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Reclamation.class);
                startActivity(intent);
            }
        });

        room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),RoomListActivity.class);
                startActivity(intent);
            }
        });


        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Login.class);
                startActivity(intent);
            }
        });


        Family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),FamilyActivity.class);
                startActivity(intent);
            }
        });



        return view ;


    }
}
