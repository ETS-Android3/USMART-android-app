package com.example.blackhummer.u_smart.Reclamation;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.blackhummer.u_smart.R;

import java.util.List;



public class Medical extends AppCompatActivity{

    private String a ;

    private static final int REQUEST_CALL = 1 ;
    ListView listView;
    String mTitle[] = {"DR Foulen", "DR Hamdi", "DR Nizar", "DR Samir", "DR Borhen"};
    String mDescription[] = {"16 Rue Gafsa", "55 Rue Liberté", "45 Rue Khadhra", "101 Place Pasteur", "25 Place Independence"};
    int img[]={R.drawable.phone, R.drawable.phone, R.drawable.phone, R.drawable.phone, R.drawable.phone};
    int images[] = {R.drawable.doctor, R.drawable.doctor, R.drawable.doctor, R.drawable.doctor, R.drawable.doctor};
    String mNumber[]={"25572905","50779017","25572905","50779017","25572905"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listereclamatoion);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images,mNumber,img);
        listView.setAdapter(adapter);


        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    a = "tel:50779017";
                    makecall(a);
                }
                if (position ==  1) {
                    a = "tel:21392665";
                    makecall(a);
                }
                if (position ==  2) {
                    a = "tel:*124#";
                    makecall(a);
                }
                if (position ==  3) {
                    a = "tel:*130#";
                    makecall(a);
                }
                if (position ==  4) {
                    a = "tel:*111#";
                    makecall(a);
                }
            }
        });
        // so item click is done now check list view
    }

    private void makecall(String a){

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(a));
        startActivity(intent);

    }
/*
        @Override
        public void onRequestPermissionsResult(int requestcode,@NonNull String[] permissions ,@NonNull int[] grantResults){
       if(requestcode == REQUEST_CALL){

           if(grantResults.length > 0 && grantResults [0] == PackageManager.PERMISSION_GRANTED){
               makecall(a);
           }
           else {
               Toast.makeText(this ,"Permisison Denied",Toast.LENGTH_SHORT).show();
           }
       }

        }

*/
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];
        String rNumber[];
        int rImg[];

        MyAdapter (Context c, String title[], String description[], int imgs[],String number[],int img[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
            this.rNumber=number;
            this.rImg=img;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);




            return row;
        }
    }
}
