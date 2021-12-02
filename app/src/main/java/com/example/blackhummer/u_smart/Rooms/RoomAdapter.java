package com.example.blackhummer.u_smart.Rooms;


import com.example.blackhummer.u_smart.R;
import com.example.blackhummer.u_smart.Rooms.RoomObject;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RoomAdapter extends
        RecyclerView.Adapter<RoomAdapter.MyViewHolder> {
    private Context context;
    private List<RoomObject> productObjectList;
    public RoomAdapter(Context context, List<RoomObject> productObjectList) {
        this.context = context;
        this.productObjectList = productObjectList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.modelitem_product, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RoomObject productObject = productObjectList.get(position);
        // Set ImageView Product Image By Position
        // setText Product Name By Position
        holder.productname.setText(productObject.getName());

    }
    @Override
    public int getItemCount() {
        return productObjectList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView productname;

        public MyViewHolder(View view) {
            super(view);
            productname = view.findViewById(R.id.productname);
        }
    }
    /**
     * Formatting timestamp to `MMM d` format
     * Input: 2019-02-21 00:15:42
     * Output: Mar 21
     */
    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        } catch (ParseException e) {
        }
        return "";
    }
}