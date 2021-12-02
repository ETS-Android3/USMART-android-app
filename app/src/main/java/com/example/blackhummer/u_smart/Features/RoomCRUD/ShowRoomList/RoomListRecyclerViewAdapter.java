package com.example.blackhummer.u_smart.Features.RoomCRUD.ShowRoomList;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.blackhummer.u_smart.Database.DatabaseQueryClass;
import com.example.blackhummer.u_smart.Features.DeviceCRUD.ShowDeviceList.DeviceListActivity;
import com.example.blackhummer.u_smart.Features.RoomCRUD.CreateRoom.Room;
import com.example.blackhummer.u_smart.Features.RoomCRUD.UpdateRoomInfo.RoomUpdateDialogFragment;
import com.example.blackhummer.u_smart.Features.RoomCRUD.UpdateRoomInfo.RoomUpdateListener;
import com.example.blackhummer.u_smart.R;


import com.example.blackhummer.u_smart.Util.Config;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.List;

public class RoomListRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<Room> RoomList;
    private DatabaseQueryClass databaseQueryClass;

    public RoomListRecyclerViewAdapter(Context context, List<Room> RoomList) {
        this.context = context;
        this.RoomList = RoomList;
        databaseQueryClass = new DatabaseQueryClass(context);
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final int itemPosition = position;
        final Room Room = RoomList.get(position);

        holder.nameTextView.setText(Room.getName());
        holder.registrationNumTextView.setText(String.valueOf(Room.getRegistrationNumber()));

        holder.crossButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setMessage("Are you sure, You wanted to delete this Room?");
                alertDialogBuilder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                deleteRoom(itemPosition);
                            }
                        });

                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        holder.editButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomUpdateDialogFragment roomUpdateDialogFragment = RoomUpdateDialogFragment.newInstance(Room.getRegistrationNumber(), itemPosition, new RoomUpdateListener() {
                    @Override
                    public void onStudentInfoUpdated(Room room, int position) {
                        RoomList.set(position, Room);
                        notifyDataSetChanged();
                    }
                });
                roomUpdateDialogFragment.show(((RoomListActivity) context).getSupportFragmentManager(), Config.UPDATE_ROOM);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DeviceListActivity.class);
                intent.putExtra(Config.ROOM_REGISTRATION, Room.getRegistrationNumber());
                context.startActivity(intent);
            }
        });
    }

    private void deleteRoom(int position) {
        Room Room = RoomList.get(position);
        long count = databaseQueryClass.deleteStudentByRegNum(Room.getRegistrationNumber());

        if(count>0){
            RoomList.remove(position);
            notifyDataSetChanged();
            ((RoomListActivity) context).viewVisibility();
            Toast.makeText(context, "Room deleted successfully", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(context, "Room not deleted. Something wrong!", Toast.LENGTH_LONG).show();

    }

    @Override
    public int getItemCount() {
        return RoomList.size();
    }
}
