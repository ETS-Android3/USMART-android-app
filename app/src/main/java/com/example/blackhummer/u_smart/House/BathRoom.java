package com.example.blackhummer.u_smart.House;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.blackhummer.u_smart.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BathRoom extends AppCompatActivity {

    ImageView back ;
    CardView cardView ;

    String fan_action = "on";
    String lamp_action = "on";

    int click_lemp = 0;
    int click_fan = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bathroom);


        ImageView back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        CardView lemp = findViewById(R.id.lemp);

        lemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationcall();

                if (click_lemp == 0) {
                    lamp_bath_action();
                    click_lemp = 1;
                }
                else
                {
                    lamp_bath_close ();
                    click_lemp = 0;
                }
            }
        });


        CardView fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click_fan == 0) {
                //    notificationcall();
                    clim_bath_action();
                    click_fan = 1;
                }
                else {

                    clim_bath_close ();
                    click_fan = 0;
                }
            }
        });


    }




//Back buyton
    @Override
    public void onBackPressed()
    {
        finish();
    }


//notif
    public void notificationcall()
    {
        NotificationCompat.Builder notificationbuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setSmallIcon(R.drawable.user)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.logo))
                .setContentTitle("Notif from Aerogen App ")
                .setContentText("There is somethings activated");
        NotificationManager notificationManagers = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManagers.notify(1,notificationbuilder.build());
        this.getSystemService(Context.NOTIFICATION_SERVICE);
    }

//open
    private void lamp_bath_action ()
    {
        String url = "https://aerogen.000webhostapp.com/ctrl_lamp_bath_open.php";
        final String hum_sol = this.lamp_action.trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1"))
                            {
                             //   Toast.makeText(this,"Success !",Toast.LENGTH_SHORT).show();
                                }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        //    Toast.makeText(this,"error 1!"+e.toString(),Toast.LENGTH_SHORT).show();
                                }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                  //      Toast.makeText(this,"error 2! "+error.toString(),Toast.LENGTH_SHORT).show();
                         }
                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {


                Map<String, String>  params = new HashMap<>();
                params.put("lamp_bath_action",hum_sol);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void clim_bath_action ()
    {
        String url = "https://aerogen.000webhostapp.com/ctrl_clim_bath_open.php";
        final String hum_sol = this.fan_action.trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1"))
                            {
                                //   Toast.makeText(this,"Success !",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            //    Toast.makeText(this,"error 1!"+e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //      Toast.makeText(this,"error 2! "+error.toString(),Toast.LENGTH_SHORT).show();
                    }
                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {


                Map<String, String>  params = new HashMap<>();
                params.put("clim_bath_action",hum_sol);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


//Close

    private void lamp_bath_close ()
    {
        String url = "https://aerogen.000webhostapp.com/ctrl_lamp_bath_open.php";
        final String hum_sol = "off";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1"))
                            {
                           //     Toast.makeText(getActivity(),"Success !",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                          //  Toast.makeText(getActivity(),"error 1!"+e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                      //  Toast.makeText(getActivity(),"error 2! "+error.toString(),Toast.LENGTH_SHORT).show();
                    }
                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {


                Map<String, String>  params = new HashMap<>();
                params.put("lamp_bath_action",hum_sol);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void clim_bath_close ()
    {
        String url = "https://aerogen.000webhostapp.com/ctrl_clim_bath_open.php";
        final String hum_sol = "off";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1"))
                            {
                                //     Toast.makeText(getActivity(),"Success !",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            //  Toast.makeText(getActivity(),"error 1!"+e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //  Toast.makeText(getActivity(),"error 2! "+error.toString(),Toast.LENGTH_SHORT).show();
                    }
                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {


                Map<String, String>  params = new HashMap<>();
                params.put("clim_bath_action",hum_sol);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}