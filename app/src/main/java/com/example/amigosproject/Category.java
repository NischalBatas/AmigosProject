package com.example.amigosproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Category extends Fragment {
    TextView textView, text3, text5, text7, text11, text12, text13, text14, text15, text16, text17, text18;
    ImageView t2, t4, t6, t8, t9, t10;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.activity_category, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = (TextView) getView().findViewById(R.id.text1);
        text11 = (TextView) getView().findViewById(R.id.t11);
        t2 = (ImageView) getView().findViewById(R.id.text2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item1.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });
        text11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item1.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item1.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });

        //item2
        text3 = (TextView) getView().findViewById(R.id.t3);
        text12 = (TextView) getView().findViewById(R.id.t12);
        t4 = (ImageView) getView().findViewById(R.id.t4);
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item2.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });
        text12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item2.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item2.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });

        //item3
        text5 = (TextView) getView().findViewById(R.id.t5);
        t6 = (ImageView) getView().findViewById(R.id.t6);
        text13 = (TextView) getView().findViewById(R.id.t13);
        text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item3.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });
        text13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item3.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item3.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });

        //item4
        text7 = (TextView) getView().findViewById(R.id.t7);
        text14 = (TextView) getView().findViewById(R.id.t14);
        t8 = (ImageView) getView().findViewById(R.id.t8);
        text7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item4.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });
        text14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item4.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item4.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });

        text15 = (TextView) getView().findViewById(R.id.t42);
        text16 = (TextView) getView().findViewById(R.id.t43);
        t9 = (ImageView) getView().findViewById(R.id.t44);
        text15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item4.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });
        text16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item6.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item6.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });

        text17 = (TextView) getView().findViewById(R.id.tj33);
        text18 = (TextView) getView().findViewById(R.id.tj34);
        t10 = (ImageView) getView().findViewById(R.id.tj35);
        text17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item4.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });
        text18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item5.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });
        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Item5.class);
                startActivity(i);

                Toast.makeText(getContext(), "See more", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
