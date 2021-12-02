package com.example.blackhummer.u_smart.House;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.blackhummer.u_smart.R;
import com.example.blackhummer.u_smart.fragment.ControlFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Kitchen extends AppCompatActivity {

    ImageView back;

    String fan_action = "on";
    String lamp_action = "on";
    String window_action = "on";

    int click_lemp = 0;
    int click_fan = 0;
    int click_window = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen_layout);

        ImageView back = (ImageView) findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        CardView lemp = findViewById(R.id.lemp);
        CardView fan = findViewById(R.id.fan);
        CardView window = findViewById(R.id.window);

        lemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //      notificationcall();

                if (click_lemp == 0) {
                    lamp_kitchen_action();
                    click_lemp = 1;
                } else {
                    lamp_kitchen_close();
                    click_lemp = 0;
                }
            }
        });
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //      notificationcall();

                if (click_lemp == 0) {
                    fan_kitchen_action();
                    click_lemp = 1;
                } else {
                    fan_kitchen_close();
                    click_lemp = 0;
                }
            }
        });
        window.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //      notificationcall();

                if (click_lemp == 0) {
                    window_kitchen_action();
                    click_lemp = 1;
                } else {
                    window_kitchen_close();
                    click_lemp = 0;
                }
            }
        });

    }


    @Override
    public void onBackPressed() {
        finish();
    }


    private void lamp_kitchen_action() {
        String url = "https://aerogen.000webhostapp.com/ctrl_lamp_kitchen_open.php";
        final String hum_sol = this.lamp_action.trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")) {
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


                Map<String, String> params = new HashMap<>();
                params.put("lamp_kitchen_action", hum_sol);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void fan_kitchen_action() {
        String url = "https://aerogen.000webhostapp.com/ctrl_fan_kitchen_open.php";
        final String hum_sol = this.fan_action.trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")) {
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


                Map<String, String> params = new HashMap<>();
                params.put("fan_kitchen_action", hum_sol);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void window_kitchen_action() {
        String url = "https://aerogen.000webhostapp.com/ctrl_window_kitchen_open.php";
        final String hum_sol = this.window_action.trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            if (success.equals("1")) {
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


                Map<String, String> params = new HashMap<>();
                params.put("window_kitchen_action", hum_sol);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }





    private void lamp_kitchen_close ()
    {
        String url = "https://aerogen.000webhostapp.com/ctrl_lamp_kitchen_open.php";
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
                params.put("lamp_kitchen_action",hum_sol);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void fan_kitchen_close ()
    {
        String url = "https://aerogen.000webhostapp.com/ctrl_fan_kitchen_open.php";
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
                params.put("fan_kitchen_action",hum_sol);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void window_kitchen_close ()
    {
        String url = "https://aerogen.000webhostapp.com/ctrl_window_kitchen_open.php";
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
                params.put("window_kitchen_action",hum_sol);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }





}
