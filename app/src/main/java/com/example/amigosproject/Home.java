package com.example.amigosproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Home extends Fragment {
    ViewFlipper imgBanner;
    CardView cardview1,cardview2,cardview3,cardview4,cardview5,cardview6,cardview7,cardview8;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardview1=getView().findViewById(R.id.card1);
        cardview2=getView().findViewById(R.id.cardview2);
        cardview3=getView().findViewById(R.id.cardview3);
        cardview4=getView().findViewById(R.id.cardview4);
        cardview5=getView().findViewById(R.id.cardview5);
        cardview6=getView().findViewById(R.id.cardview6);
        cardview7=getView().findViewById(R.id.cardview7);
        cardview8=getView().findViewById(R.id.cardview8);
        imgBanner = getView().findViewById(R.id.imagBanner);

        int sliders[] = {
                R.drawable.w2, R.drawable.w11, R.drawable.w6, R.drawable.w5
        };

        for (int slide : sliders) {
            bannerFlipper(slide);
        }

        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), cardview1.class));
            }
        });
        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), cardview2.class));
            }
        });
        cardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), cardview3.class));
            }
        });
        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), cardview4.class));
            }
        });
        cardview5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), cardview5.class));
            }
        });
        cardview6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), cardview6.class));
            }
        });
        cardview7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), cardview7.class));
            }
        });
        cardview8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), cardview8.class));
            }
        });

    }


    public void bannerFlipper(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(image);
        imgBanner.addView(imageView);
        imgBanner.setFlipInterval(3000);
        imgBanner.setAutoStart(true);
        imgBanner.setInAnimation(getActivity(), android.R.anim.fade_in);
        imgBanner.setOutAnimation(getActivity(), android.R.anim.fade_out);
    }
}
