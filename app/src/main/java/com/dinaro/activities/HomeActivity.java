package com.dinaro.activities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dinaro.R;

public class HomeActivity extends AppCompatActivity {

    TextView txtSettings;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


         navController = Navigation.findNavController(this, R.id.nav_host_fragment);


        initiateView();

        homeClicked();




    }




//
//    private void activityClicked(){
//        int colorPrimary = getResources().getColor(R.color.colorAccent);
//        int colorDefault = getResources().getColor(R.color.colorGreyPrimary);
//
////        imageViewHome.setImageResource(R.drawable.ic_non_clicked);
//
//
////        txtActivity.setTextColor(colorPrimary);
////        txtActivity.setCompoundDrawablesWithIntrinsicBounds(null, changeIconColor(this,R.drawable.ic_activity) , null, null);
////
////
////        txtSettings.setTextColor(colorDefault);
////        txtSettings.setCompoundDrawablesWithIntrinsicBounds(null, changeIconColorBack(this,R.drawable.ic_setting) , null, null);
//
//
//    }

//    private void settingsClicked(){
//        int colorPrimary = getResources().getColor(R.color.colorAccent);
//        int colorDefault = getResources().getColor(R.color.colorGreyPrimary);
//
////        imageViewHome.setImageResource(R.drawable.ic_non_clicked);
//
//
//        txtSettings.setTextColor(colorPrimary);
//        txtSettings.setCompoundDrawablesWithIntrinsicBounds(null, changeIconColor(this,R.drawable.ic_setting) , null, null);
//
//
//        txtActivity.setTextColor(colorDefault);
//        txtActivity.setCompoundDrawablesWithIntrinsicBounds(null, changeIconColorBack(this,R.drawable.ic_activity) , null, null);
//
//
//    }

    private Drawable changeIconColor(Context context , int drawable){
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(context, drawable);
        assert unwrappedDrawable != null;
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.colorAccent));

        return wrappedDrawable;

    }

    private Drawable changeIconColorBack(Context context , int drawable){
        Drawable unwrappedDrawable = AppCompatResources.getDrawable(context, drawable);
        assert unwrappedDrawable != null;
        Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
        DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.grey));

        return wrappedDrawable;

    }

    ImageView img_settings,img_discovery,img_stats,img_home;

    TextView settings,discovery,stats,home;

    private void initiateView() {

        img_home = findViewById(R.id.img_home);
        img_settings = findViewById(R.id.img_settings);
        img_discovery = findViewById(R.id.img_discovery);
        img_stats = findViewById(R.id.img_stats);



        home = findViewById(R.id.home);
        settings = findViewById(R.id.settings);
        discovery = findViewById(R.id.discovery);
        stats = findViewById(R.id.stats);

        onClick();


    }


    private void onClick() {
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                homeClicked();
                if (navController.getCurrentDestination().getId() == R.id.activityFragment) {


                } else if (navController.getCurrentDestination().getId() == R.id.homeFragment) {

                    navController.navigate(R.id.action_homeFragment_to_activityFragment);


                } else if (navController.getCurrentDestination().getId() == R.id.settingsFragment) {

                    navController.navigate(R.id.action_settingsFragment_to_activityFragment);

                }else if (navController.getCurrentDestination().getId() == R.id.searchCalendarFragment) {

                    navController.navigate(R.id.action_searchCalendarFragment_to_activityFragment);

                }
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                settingsClicked();
                if (navController.getCurrentDestination().getId() == R.id.activityFragment) {
                    navController.navigate(R.id.action_activityFragment_to_settingsFragment);

                } else if (navController.getCurrentDestination().getId() == R.id.homeFragment) {
                    navController.navigate(R.id.action_homeFragment_to_settingsFragment);


                } else if (navController.getCurrentDestination().getId() == R.id.settingsFragment) {

                }else if (navController.getCurrentDestination().getId() == R.id.searchCalendarFragment) {

                    navController.navigate(R.id.action_searchCalendarFragment_to_settingsFragment);

                }

            }

        });

        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                statsClicked();

            }
        });

        discovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                discoveryClicked();
            }
        });
    }

    private void homeClicked(){
        final int colorPrimary = getResources().getColor(R.color.colorPrimary);
        final int colorDefault = getResources().getColor(R.color.colorGreyPrimary);

        home.setTextColor(colorPrimary);
        img_home.setImageResource(R.drawable.ic_activity_selected);

        settings.setTextColor(colorDefault);
        stats.setTextColor(colorDefault);
        discovery.setTextColor(colorDefault);

        img_settings.setImageResource(R.drawable.ic_settings);
        img_stats.setImageResource(R.drawable.ic_stats);
        img_discovery.setImageResource(R.drawable.ic_events);


    }

    private void settingsClicked(){
        final int colorPrimary = getResources().getColor(R.color.colorPrimary);
        final int colorDefault = getResources().getColor(R.color.colorGreyPrimary);

        settings.setTextColor(colorPrimary);
        img_settings.setImageResource(R.drawable.ic_settings_selected);

        home.setTextColor(colorDefault);
        stats.setTextColor(colorDefault);
        discovery.setTextColor(colorDefault);

        img_home.setImageResource(R.drawable.ic_activity);
        img_stats.setImageResource(R.drawable.ic_stats);
        img_discovery.setImageResource(R.drawable.ic_events);

    }

    private void statsClicked(){
        final int colorPrimary = getResources().getColor(R.color.colorPrimary);
        final int colorDefault = getResources().getColor(R.color.colorGreyPrimary);

        stats.setTextColor(colorPrimary);
        img_stats.setImageResource(R.drawable.ic_stats_selected);

        home.setTextColor(colorDefault);
        settings.setTextColor(colorDefault);
        discovery.setTextColor(colorDefault);

        img_home.setImageResource(R.drawable.ic_activity);
        img_settings.setImageResource(R.drawable.ic_settings);
        img_discovery.setImageResource(R.drawable.ic_events);



    }


    private void discoveryClicked(){
        final int colorPrimary = getResources().getColor(R.color.colorPrimary);
        final int colorDefault = getResources().getColor(R.color.colorGreyPrimary);

        discovery.setTextColor(colorPrimary);
        img_discovery.setImageResource(R.drawable.ic_events_selected);

        home.setTextColor(colorDefault);
        settings.setTextColor(colorDefault);
        stats.setTextColor(colorDefault);

        img_home.setImageResource(R.drawable.ic_activity);
        img_settings.setImageResource(R.drawable.ic_settings);
        img_stats.setImageResource(R.drawable.ic_stats);





    }



}
