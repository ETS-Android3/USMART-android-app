package com.example.blackhummer.u_smart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class aquisition extends AppCompatActivity {


    private int pCounter = 0;
    private int mCounter = 0;

    private int Counter1 = 0;
    private int Counter2 = 0;
    private int Counter3 = 0;
    private int Counter4 = 0;
    private int Counter5 = 0;
    private int Counter6 = 0;
    private int Counter7 = 0;
    private int Counter8 = 0;
    private int Counter9 = 0;
    private int Counter10 = 0;
    private int Counter11 = 0;


    TextView num_temp;
    private TextView    num_temp_living,num_hum_living,num_gaz_living,
            num_temp_bed,num_hum_bed,num_gaz_bed,
            num_temp_bath,num_hum_bath,num_gaz_bath,
            num_temp_kitch,num_hum_kitch,num_gaz_kitch;

    ImageView back;

    private RequestQueue mQueue ,queue;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_homes);

        ImageView back = (ImageView) findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button button_living = findViewById(R.id.button_living);
        Button button_bath = findViewById(R.id.button_bath);
        Button button_bed = findViewById(R.id.button_bed);
        Button button_kitech = findViewById(R.id.button_kitech);



        CardView plus_temp_living = findViewById(R.id.plus_temp_living);
        CardView minus_temp_living = findViewById(R.id.minus_temp_living);

        CardView plus_hum_living = findViewById(R.id.plus_hum_living);
        CardView minus_hum_living = findViewById(R.id.minus_hum_living);

        CardView plus_gaz_living = findViewById(R.id.plus_gaz_living);
        CardView minus_gaz_living = findViewById(R.id.minus_gas_living);
        //------------------------------------------------------------------------------------------

        CardView plus_temp_bed = findViewById(R.id.plus_temp_bed);
        CardView minus_temp_bed = findViewById(R.id.minus_temp_bed);

        CardView plus_hum_bed = findViewById(R.id.plus_hum_bed);
        CardView minus_hum_bed = findViewById(R.id.minus_hum_bed);

        CardView plus_gaz_bed = findViewById(R.id.plus_gaz_bed);
        CardView minus_gaz_bed = findViewById(R.id.minus_gaz_bed);
        //------------------------------------------------------------------------------------------


        CardView plus_temp_bath = findViewById(R.id.plus_temp_bath);
        CardView minus_temp_bath = findViewById(R.id.minus_temp_bath);

        CardView plus_hum_bath = findViewById(R.id.plus_hum_bath);
        CardView minus_hum_bath = findViewById(R.id.minus_hum_bath);

        CardView plus_gaz_bath = findViewById(R.id.plus_gaz_bath);
        CardView minus_gaz_bath = findViewById(R.id.minus_gaz_bath);


        //------------------------------------------------------------------------------------------

        CardView plus_temp_kitch = findViewById(R.id.plus_temp_kitch);
        CardView minus_temp_kitch = findViewById(R.id.minus_temp_kitch);

        CardView plus_hum_kitch = findViewById(R.id.plus_hum_kitch);
        CardView minus_hum_kitch = findViewById(R.id.minus_hum_kitch);

        CardView plus_gaz_kitch = findViewById(R.id.plus_gaz_kitch);
        CardView minus_gaz_kitch = findViewById(R.id.minus_gaz_kitch);



        //-------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------
        plus_temp_living.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                pCounter++;
                num_temp_living.setText(Integer.toString(pCounter));
            }
        });

        minus_temp_living.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                pCounter--;
                num_temp_living.setText(Integer.toString(pCounter));
            }
        });

        //---------------------------    2

        plus_hum_living.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Counter1++;
                num_hum_living.setText(Integer.toString(Counter1));
            }
        });

        minus_hum_living.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter1--;
                num_hum_living.setText(Integer.toString(Counter1));
            }
        });
        //-------------------------------    3

        plus_gaz_living.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter2++;
                num_gaz_living.setText(Integer.toString(Counter2));
            }
        });

        minus_gaz_living.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter2--;
                num_gaz_living.setText(Integer.toString(Counter2));
            }
        });

        //-------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------

        plus_temp_bed.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter3++;
                num_temp_bed.setText(Integer.toString(Counter3));
            }
        });

        minus_temp_bed.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter3--;
                num_temp_bed.setText(Integer.toString(Counter3));
            }
        });

        //---------------------------------

        plus_hum_bed.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter4++;
                num_hum_bed.setText(Integer.toString(Counter4));
            }
        });

        minus_hum_bed.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter4--;
                num_hum_bed.setText(Integer.toString(Counter4));
            }
        });

        //-----------------------------------

        plus_gaz_bed.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter5++;
                num_gaz_bed.setText(Integer.toString(Counter5));
            }
        });

        minus_gaz_bed.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter5--;
                num_gaz_bed.setText(Integer.toString(Counter5));
            }
        });
        //-------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------
        //-------------------------------------------------------------------------------------------------------

        plus_temp_bath.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter6++;
                num_temp_bath.setText(Integer.toString(Counter6));
            }
        });

        minus_temp_bath.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter6--;
                num_temp_bath.setText(Integer.toString(Counter6));
            }
        });

        //-------------------------------------

        plus_hum_bath.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter7++;
                num_hum_bath.setText(Integer.toString(Counter7));
            }
        });

        minus_hum_bath.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter7--;
                num_hum_bath.setText(Integer.toString(Counter7));
            }
        });
        //-------------------------------------
        plus_gaz_bath.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter8++;
                num_gaz_bath.setText(Integer.toString(Counter8));
            }
        });

        minus_gaz_bath.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter8--;
                num_gaz_bath.setText(Integer.toString(Counter8));
            }
        });

        //---------------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------------

        plus_temp_kitch.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter9++;
                num_temp_kitch.setText(Integer.toString(Counter9));
            }
        });

        minus_temp_kitch.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter9--;
                num_temp_kitch.setText(Integer.toString(Counter9));
            }
        });

        //-------------------------------------        -----------------------------------------
        plus_hum_kitch.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter10++;
                num_hum_kitch.setText(Integer.toString(Counter10));
            }
        });

        minus_hum_kitch.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter10--;
                num_hum_kitch.setText(Integer.toString(Counter10));
            }
        });

        //----------------------------------------        ------------------------------------

        plus_gaz_kitch.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter11++;
                num_gaz_kitch.setText(Integer.toString(Counter11));
            }
        });

        minus_gaz_kitch.setOnClickListener(new View.OnClickListener () {
            @Override

            public void onClick(View view) {
                Counter11--;
                num_gaz_kitch.setText(Integer.toString(Counter11));
            }
        });


        //---------------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------------


        num_temp_living = (TextView) findViewById(R.id.num_temp_living);
        num_hum_living = (TextView) findViewById(R.id.num_hum_living);
        num_gaz_living = (TextView) findViewById(R.id.num_gaz_living);
        num_temp_bed = (TextView) findViewById(R.id.num_temp_bed);
        num_hum_bed = (TextView) findViewById(R.id.num_hum_bed);
        num_gaz_bed = (TextView) findViewById(R.id.num_gaz_bed);
        num_temp_bath = (TextView) findViewById(R.id.num_temp_bath);
        num_hum_bath = (TextView) findViewById(R.id.num_hum_bath);
        num_gaz_bath = (TextView) findViewById(R.id.num_gaz_bath);
        num_temp_kitch = (TextView) findViewById(R.id.num_temp_kitch);
        num_hum_kitch = (TextView) findViewById(R.id.num_hum_kitch);
        num_gaz_kitch = (TextView) findViewById(R.id.num_gaz_kitch);

        LinearLayout linear= (LinearLayout)findViewById(R.id.linearLayout1);

        mQueue = Volley.newRequestQueue(this);
        queue = Volley.newRequestQueue(this);  // this = context


/*
        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);

        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Welcome.this ,MainActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
*/







        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });





        // Toast --------------------------------------------------------------------------------------------

        button_kitech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //        Toast toast = Toast.makeText(getApplicationContext(), "Hello button kitech!", Toast.LENGTH_SHORT); toast.show();
                update ();
            }
        });
        button_bed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //        Toast toast = Toast.makeText(getApplicationContext(), "Hello button bed!", Toast.LENGTH_SHORT); toast.show();
                update ();

            }
        });
        button_bath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //       Toast toast = Toast.makeText(getApplicationContext(), "Hello button bath!", Toast.LENGTH_SHORT); toast.show();
                update ();

            }
        });
        button_living.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //        Toast toast = Toast.makeText(getApplicationContext(), "Hello button living!", Toast.LENGTH_SHORT); toast.show();
                update ();

            }
        });




    }

    private void jsonParse()
    {
        String url = "https://aerogen.000webhostapp.com/parametre_Seuil.php";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("parametres");
                            for (int i = 0;i<jsonArray.length();i++)
                            {
                                JSONObject tbl_consultations = jsonArray.getJSONObject(i);
                                String Humidite_air_living = tbl_consultations.getString("hum_living");
                                String temperature_living = tbl_consultations.getString("temp_living");
                                String co2_living = tbl_consultations.getString("co2_living");

                                String Humidite_air_bed = tbl_consultations.getString("hum_bed");
                                String temperature_bed = tbl_consultations.getString("temp_bed");
                                String co2_bed = tbl_consultations.getString("co2_bed");

                                String Humidite_air_bath = tbl_consultations.getString("hum_bath");
                                String temperature_bath = tbl_consultations.getString("temp_bath");
                                String co2_bath = tbl_consultations.getString("co2_bath");

                                String Humidite_air_kitchen = tbl_consultations.getString("hum_kitchen");
                                String temperature_kitchen = tbl_consultations.getString("temp_kitchen");
                                String co2_kitchen = tbl_consultations.getString("co2_kitchen");



                                num_temp_living.setText(null);
                                num_hum_living.setText(null);
                                num_gaz_living.setText(null);

                                num_temp_bed.setText(null);
                                num_hum_bed.setText(null);
                                num_gaz_bed .setText(null);

                                num_temp_bath.setText(null);
                                num_hum_bath.setText(null);
                                num_gaz_bath.setText(null);

                                num_temp_kitch.setText(null);
                                num_hum_kitch.setText(null);
                                num_gaz_kitch.setText(null);


                                num_temp_living.append(temperature_living);
                                num_hum_living.append(Humidite_air_living);
                                num_gaz_living.append(co2_living);

                                num_temp_bed.append(temperature_bed);
                                num_hum_bed.append(Humidite_air_bed);
                                num_gaz_bed .append(co2_bed);

                                num_temp_bath.append(temperature_bath);
                                num_hum_bath.append(Humidite_air_bath);
                                num_gaz_bath.append(co2_bath);

                                num_temp_kitch.append(temperature_kitchen);
                                num_hum_kitch.append(Humidite_air_kitchen);
                                num_gaz_kitch.append(co2_kitchen);


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }


    private void update ()
    {
        String url = "https://aerogen.000webhostapp.com/update_Seuil.php";

        final String temp_living = this.num_temp_living.getText().toString().trim();
        final String hum_living = this.num_hum_living.getText().toString().trim();
        final String gaz_living = this.num_gaz_living.getText().toString().trim();

        final String temp_bed = this.num_temp_bed.getText().toString().trim();
        final String hum_bed = this.num_hum_bed.getText().toString().trim();
        final String gaz_bed = this.num_gaz_bed.getText().toString().trim();

        final String temp_bath = this.num_temp_bath.getText().toString().trim();
        final String hum_bath = this.num_hum_bath.getText().toString().trim();
        final String gaz_bath = this.num_gaz_bath.getText().toString().trim();

        final String temp_kitch = this.num_temp_kitch.getText().toString().trim();
        final String hum_kitch = this.num_hum_kitch.getText().toString().trim();
        final String gaz_kitch = this.num_gaz_kitch.getText().toString().trim();




        // final String id = getId();

//        final ProgressDialog progressDialog = new ProgressDialog(getActivity().getApplicationContext());
        //       progressDialog.setMessage("Saving ... ");
        //       progressDialog.show();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");

                            if (success.equals("1"))
                            {
                                Toast.makeText(getApplicationContext(),"Success !",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),"error 1!"+e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"error 2! "+error.toString(),Toast.LENGTH_SHORT).show();
                    }
                })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {


                Map<String, String>  params = new HashMap<>();
                params.put("temp_living",temp_living);
                params.put("hum_living",hum_living);
                params.put("co2_living",gaz_living);

                params.put("temp_bed",temp_bed);
                params.put("hum_bed",hum_bed);
                params.put("co2_bed",gaz_bed);

                params.put("temp_bath",temp_bath);
                params.put("hum_bath",hum_bath);
                params.put("co2_bath",gaz_bath);

                params.put("temp_kitchen",temp_kitch);
                params.put("hum_kitchen",hum_kitch);
                params.put("co2_kitchen",gaz_kitch);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
