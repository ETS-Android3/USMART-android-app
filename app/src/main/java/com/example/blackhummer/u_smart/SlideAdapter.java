package com.example.blackhummer.u_smart;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {


    Context context ;
    LayoutInflater layoutInflater ;

    public SlideAdapter(Context context)
    {
        this.context= context;

    }

    public int []slide_image = {

            R.drawable.smart2,
            R.drawable.smartf,
            R.drawable.ind2,
    };


    public String []slide_headings = {

            "Smart House",
            "Smart Farm",
            "Industry 4.0",
    };

    public String []slide_descs = {

            " Notre serre est entièrement autonome" +
                    "elle gère" +
                    " automatiquement les besoins des plantes" +
                    " Vous n’auriez besoin d’aucune interaction directe " ,

            " A part le faite qu’elle soit économique" +
                    " au niveau de la consommation d’eaunotre serre est vendue" +
                    " à un prix presque introuvable sur le marché " +
                    "sans oublier les services qui vont avec. " ,


            " Nous utilisons des lampes à LED pour créer" +
                    " une recette de lumière spécifique pour chaque plante" +
                    "en donnant aux greens exactement le spectre" +
                    " l'intensité et la fréquence dont ils ont besoin pour la photosynthèse "
    };



    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject( View view, Object o) {
        return view == (LinearLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout1,container,false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id. slide_desc);


        slideImageView.setImageResource(slide_image[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout)object);

    }
}










