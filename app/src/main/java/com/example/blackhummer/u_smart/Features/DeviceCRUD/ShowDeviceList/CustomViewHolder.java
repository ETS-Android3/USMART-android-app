package com.example.blackhummer.u_smart.Features.DeviceCRUD.ShowDeviceList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.blackhummer.u_smart.R;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    TextView subjectNameTextView;
    TextView subjectCodeTextView;
    ImageView crossButtonImageView;
    ImageView editButtonImageView;

    public CustomViewHolder(View itemView) {
        super(itemView);

        subjectNameTextView = itemView.findViewById(R.id.subjectNameTextView);
        subjectCodeTextView = itemView.findViewById(R.id.subjectCodeTextView);
        crossButtonImageView = itemView.findViewById(R.id.crossImageView);
        editButtonImageView = itemView.findViewById(R.id.editImageView);
    }
}
