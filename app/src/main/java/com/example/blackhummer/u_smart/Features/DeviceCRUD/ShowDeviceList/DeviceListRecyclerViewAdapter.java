package com.example.blackhummer.u_smart.Features.DeviceCRUD.ShowDeviceList;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.blackhummer.u_smart.Database.DatabaseQueryClass;
import com.example.blackhummer.u_smart.Features.DeviceCRUD.CreateDevice.Device;
import com.example.blackhummer.u_smart.Features.DeviceCRUD.CreateDevice.DeviceCreateDialogFragment;
import com.example.blackhummer.u_smart.Features.DeviceCRUD.CreateDevice.DeviceCreateListener;
import com.example.blackhummer.u_smart.Features.DeviceCRUD.UpdateDeviceInfo.DeviceUpdateDialogFragment;
import com.example.blackhummer.u_smart.Features.DeviceCRUD.UpdateDeviceInfo.DeviceUpdateListener;
import com.example.blackhummer.u_smart.R;
import com.example.blackhummer.u_smart.Util.Config;

import java.util.List;

public class DeviceListRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private Context context;
    private List<Device> subjectList;

    public DeviceListRecyclerViewAdapter(Context context, List<Device> subjectList) {
        this.context = context;
        this.subjectList = subjectList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_subject, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final int listPosition = position;
        final Device subject = subjectList.get(position);

        holder.subjectNameTextView.setText(subject.getName());
        holder.subjectCodeTextView.setText(String.valueOf(subject.getCode()));

        holder.crossButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setMessage("Are you sure, You wanted to delete this subject?");
                alertDialogBuilder.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                deleteSubject(subject);
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
                editSubject(subject.getId(), listPosition);
            }
        });
    }

    private void editSubject(long subjectId, int listPosition){
        DeviceUpdateDialogFragment subjectUpdateDialogFragment = DeviceUpdateDialogFragment.newInstance(subjectId, listPosition, new DeviceUpdateListener() {
            @Override
            public void onSubjectInfoUpdate(Device subject, int position) {
                subjectList.set(position, subject);
                notifyDataSetChanged();
            }
        });
        subjectUpdateDialogFragment.show(((DeviceListActivity) context).getSupportFragmentManager(), Config.UPDATE_DEVICE);
    }

    private void deleteSubject(Device subject) {
        DatabaseQueryClass databaseQueryClass = new DatabaseQueryClass(context);
        boolean isDeleted = databaseQueryClass.deleteSubjectById(subject.getId());

        if(isDeleted) {
            subjectList.remove(subject);
            notifyDataSetChanged();
            ((DeviceListActivity) context).viewVisibility();
        } else
            Toast.makeText(context, "Cannot delete!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }
}
