package com.dinaro.fragments;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dinaro.R;
import com.dinaro.activities.OnClickPaymentActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    ImageView imageViewAirtel,imageViewSteers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);


        imageViewSteers=view.findViewById(R.id.imageViewSteers);
        imageViewSteers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OnClickPaymentActivity.class);
                intent.putExtra("TYPE", "one");
                startActivity(intent);



            }
        });
        imageViewAirtel=view.findViewById(R.id.imageViewAirtel);
        imageViewAirtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OnClickPaymentActivity.class);
                intent.putExtra("TYPE", "two");
                startActivity(intent);

            }
        });
        return view;
    }


}
