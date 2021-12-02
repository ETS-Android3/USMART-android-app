package com.example.blackhummer.u_smart.fragment;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.blackhummer.u_smart.Adapter;
import com.example.blackhummer.u_smart.Model;
import com.example.blackhummer.u_smart.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {



    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    // Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();




    private CardView cardTop,cardRight,cardLeft,cardLeft2;

    public HomeFragment() {}



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home, container, false);




        models = new ArrayList<>();
        models.add(new Model(R.drawable.brochure, "Brochure", "Brochure is an informative paper document (often also used for advertising) that can be folded into a template"));
        models.add(new Model(R.drawable.sticker, "Sticker", "Sticker is a type of label: a piece of printed paper, plastic, vinyl, or other material with pressure sensitive adhesive on one side"));
        models.add(new Model(R.drawable.poster, "Poster", "Poster is any piece of printed paper designed to be attached to a wall or vertical surface."));
        models.add(new Model(R.drawable.namecard, "Namecard", "Business cards are cards bearing business information about a company or individual."));

        adapter = new Adapter(models, getActivity().getApplicationContext());

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);



        cardTop = view.findViewById(R.id.cardTop);
        cardRight = view.findViewById(R.id.cardRight);
        cardLeft = view.findViewById(R.id.cardLeft);
        cardLeft2 = view.findViewById(R.id.cardLeft2) ;



        Animation animeBottomToTop = AnimationUtils.loadAnimation(getActivity(),R.anim.anime_bottom_to_top);
        Animation animeTopToBottom = AnimationUtils.loadAnimation(getActivity(),R.anim.anime_top_to_bottom);
        Animation animeRightToleft = AnimationUtils.loadAnimation(getActivity(),R.anim.anime_right_to_left);
        Animation animeLeftToRight = AnimationUtils.loadAnimation(getActivity(),R.anim.anime_left_to_right);


        // setup Animation :
        cardLeft2.setAnimation(animeBottomToTop);
        cardTop.setAnimation(animeTopToBottom);
        cardRight.setAnimation(animeRightToleft);
        cardLeft.setAnimation(animeLeftToRight);


        return view;

    }
}
