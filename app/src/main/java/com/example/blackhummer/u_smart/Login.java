package com.example.blackhummer.u_smart;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    Button loginbtn ;
    EditText username,password ;
    RequestQueue queueVolley ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username = findViewById(R.id.userEmail);
        password = findViewById(R.id.userPassword);
        loginbtn= findViewById(R.id.loginbtn);
/*
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivtiy();
            }
        });

        */

        queueVolley = Volley.newRequestQueue(this);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://aerogen.000webhostapp.com/login.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("Failed"))
                        {
                            Toast.makeText(Login.this,"Login Failed" ,Toast.LENGTH_SHORT).show();
                            password.setText("");
                        }
                        else {
                            // Toast.makeText(LoginActivity.this,"Login sec" ,Toast.LENGTH_SHORT).show();



                            openLoginActivtiy();
                            password.setText("");
                            username.setText("");
                            //   notificationcall();

                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("pppp","onError");
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String>map = new HashMap<>();
                        map.put("username",username.getText().toString());
                        map.put("password",password.getText().toString());
                        //  map.put("id",id);

                        return map ;
                    }
                };
                queueVolley.add(stringRequest);
            }
        });




    }


    public void openLoginActivtiy(){
        Intent intent = new Intent(this,LoginAfter.class);
        startActivity(intent);
     //   notificationcall();

    }

    public void notificationcall()
    {
        NotificationCompat.Builder notificationbuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.user)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.bitcon))
                .setContentTitle(" Welcome ")
                .setContentText(" Welcome Mr ");
        NotificationManager notificationManagers = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManagers.notify(1,notificationbuilder.build());
        this.getSystemService(Context.NOTIFICATION_SERVICE);
    }

}
