package com.dinaro.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dinaro.R;
import com.dinaro.activities.HomeActivity;
import com.dinaro.activities.LoginActivity;
import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneNumberFragment extends Fragment {


    CountryCodePicker ccp;

    public PhoneNumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_phone_number, container, false);
        ccp = view. findViewById(R.id.ccp);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //initialize the navController and make it reference the navhost
        NavController navController= Navigation.findNavController(getActivity(),R.id.nav_host_fragment);


        //initialize the buttons
        Button button=view.findViewById(R.id.next_btn);
        Button button1=view.findViewById(R.id.cancel_btn);


        //set onclicklisteners to the buttons
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navController.navigate(R.id.action_phoneNumberFragment_to_checkRegisteredFragment);

//                Intent i = new Intent(getActivity(), HomeActivity.class);
//                            Bundle bundle = new Bundle();
//                            bundle.putString("2", "xyz");
//                            i.putExtras(bundle);
//                            startActivity(i);
//                            getActivity().finish();

            }
        });



    }
}
