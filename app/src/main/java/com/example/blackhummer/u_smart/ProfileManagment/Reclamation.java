package com.example.blackhummer.u_smart.ProfileManagment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.blackhummer.u_smart.LoginAfter;
import com.example.blackhummer.u_smart.R;
import com.example.blackhummer.u_smart.Reclamation.Medical;
import com.spark.submitbutton.SubmitButton;

public class Reclamation extends AppCompatActivity {
    Dialog mDialog ;
    ImageView back ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.reclamation);

        final FloatingActionButton fab = findViewById(R.id.fab);
      //  final fabMenu = findViewById(R.id.fabMenu);
        ImageView back = (ImageView)findViewById(R.id.back);
        mDialog = new Dialog(this);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }



    @Override
    public void onBackPressed()
    {
        finish();
    }




    public void ShowPopup (View v)
    {
        SubmitButton btndone;
        mDialog.setContentView(R.layout.popup);
        btndone = (SubmitButton)mDialog.findViewById(R.id.btndone);

        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        mDialog.show();

    }


    public void ShowPo (View v)
    {
        Intent intent = new Intent(this,Medical.class);
        startActivity(intent);
        //   notificationcall();


    }

}